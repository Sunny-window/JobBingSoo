package com.bingsoo.job.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.RedBean;
import com.bingsoo.job.repository.CompanyRepository;
import com.bingsoo.job.repository.MemberRepository;
import com.bingsoo.job.repository.RedBeanRepository;
import com.bingsoo.job.service.CompanyService;
import com.bingsoo.job.service.SubCategoryService;

@RestController
@RequestMapping("/main")
@CrossOrigin(origins = "http://localhost:8080")
public class MainController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RedBeanRepository redBeanRepository;

    @Autowired
    private CompanyRepository companyRepository;
    
    @Autowired
    private CompanyService companyService;

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping("/join-form/job-seeker")
    public ResponseEntity<String> registerMember(@RequestParam("username") String username,
                                                 @RequestParam("password") String password,
                                                 @RequestParam("name") String name,
                                                 @RequestParam("tel") String tel,
                                                 @RequestParam("address") String address,
                                                 @RequestParam("email") String email,
                                                 @RequestParam("birth") String birth,
                                                 @RequestParam("gender") String gender,
                                                 @RequestParam("military") String military) {
        
    	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	 LocalDate localDate = null;
    	 
         try {
             // 문자열을 LocalDate로 변환
             localDate = LocalDate.parse(birth, formatter);
         } catch (DateTimeParseException e) {
             System.err.println("날짜 문자열을 파싱할 수 없습니다: " + e.getMessage());
         }

    	
    	// Member 엔티티 생성 및 저장
        Member member = Member.builder()
                .username(username)
                .password(password)
                .role("ROLE_RED_BEAN")
                .build();
        member = memberRepository.save(member);

        // RedBean 엔티티 생성 및 저장
        RedBean redBean = RedBean.builder()
                .rid(member)
                .name(name)
                .tel(tel)
                .address(address)
                .email(email)
                .birth(localDate)
                .gender(gender)
                .military(military)
                .build();
        redBeanRepository.save(redBean);

        return ResponseEntity.ok("일반 회원 가입 성공");
    }


    @PostMapping("/join-form/company")
    public ResponseEntity<String> registerCompany(@RequestParam("username") String username,
                                                  @RequestParam("password") String password,
                                                  @RequestParam("cno") String cno,
                                                  @RequestParam("companyName") String companyName,
                                                  @RequestParam("size") String size,
                                                  @RequestParam("ceo") String ceo,
                                                  @RequestParam("tel") String tel,
                                                  @RequestParam("sales") Integer sales,
                                                  @RequestParam("address") String address,
                                                  @RequestParam("managerName") String managerName,
                                                  @RequestParam("managerTel") String managerTel,
                                                  @RequestParam("managerEmail") String managerEmail) {
        // Member 엔티티 생성 및 저장
        Member member = Member.builder()
                .username(username)
                .password(password)
                .role("ROLE_ICE")
                .build();
        member = memberRepository.save(member);

        // Company 엔티티 생성 및 저장
        Company company = Company.builder()
                .cno(cno)
                .cid(member)
                .company_name(companyName)
                .size(size)
                .ceo(ceo)
                .tel(tel)
                .sales(sales)
                .address(address)
                .manager_name(managerName)
                .manager_tel(managerTel)
                .manager_email(managerEmail)
                .build();
        companyRepository.save(company);

        return ResponseEntity.ok("기업 회원 가입 성공");
    }
    
    @GetMapping("/company-list")
    public List<CompanyResponse> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return companies.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @PostMapping("/company-list/filter")
    public List<CompanyResponse> filterCompanies(@RequestBody FilterRequest filterRequest) {
        List<Company> companies = companyService.getAllCompanies();

        List<Company> filteredCompanies = companies.stream()
            .filter(company -> filterBySales(company, filterRequest.getSales()))
            .filter(company -> filterBySize(company, filterRequest.getSize()))
            .filter(company -> filterByIndustry(company, filterRequest.getIndustry()))
            .collect(Collectors.toList());

        return filteredCompanies.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    private boolean filterBySales(Company company, List<String> salesFilters) {
        if (salesFilters.isEmpty()) return true;
        int sales = company.getSales();
        for (String filter : salesFilters) {
            String[] range = filter.split("-");
            int min = Integer.parseInt(range[0]);
            int max = Integer.parseInt(range[1]);
            if (sales >= min && sales <= max) return true;
        }
        return false;
    }

    private boolean filterBySize(Company company, List<String> sizeFilters) {
        if (sizeFilters.isEmpty()) return true;
        String size = company.getSize();
        for (String filter : sizeFilters) {
            if (size.equals(filter)) return true;
        }
        return false;
    }

    private boolean filterByIndustry(Company company, List<String> industryFilters) {
        if (industryFilters.isEmpty()) return true;
        String industry = company.getSccode().getMccode().getMain();
        for (String filter : industryFilters) {
            if (industry.equals(filter)) return true;
        }
        return false;
    }

    private CompanyResponse convertToResponse(Company company) {
        String subCategoryName = "";
        if (company.getSccode() != null) {
            subCategoryName = company.getSccode().getSub();
        }
        return new CompanyResponse(company.getCno(), company.getCompany_name(), subCategoryName);
    }

    static class CompanyResponse {
        private String cno;
        private String companyName;
        private String subCategoryName;

        public CompanyResponse(String cno, String companyName, String subCategoryName) {
            this.cno = cno;
            this.companyName = companyName;
            this.subCategoryName = subCategoryName;
        }

        public String getCno() {
            return cno;
        }

        public void setCno(String cno) {
            this.cno = cno;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getSubCategoryName() {
            return subCategoryName;
        }

        public void setSubCategoryName(String subCategoryName) {
            this.subCategoryName = subCategoryName;
        }
    }


    static class FilterRequest {
        private List<String> sales;
        private List<String> size;
        private List<String> industry;

        public List<String> getSales() {
            return sales;
        }

        public void setSales(List<String> sales) {
            this.sales = sales;
        }

        public List<String> getSize() {
            return size;
        }

        public void setSize(List<String> size) {
            this.size = size;
        }

        public List<String> getIndustry() {
            return industry;
        }

        public void setIndustry(List<String> industry) {
            this.industry = industry;
        }
    }
    
    /*
    @GetMapping("/company-detail/company-info/{cno}")
    public void getCompanyByCno(@PathVariable("cno") String cno, HttpServletResponse response) throws IOException {
        Company company = companyService.getCompanyByCno2(cno).orElse(null);
        if (company != null) {
            response.sendRedirect("http://localhost:8080/main/comDetail?cno=" + cno);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Company not found");
        }
    }
    */
    
    @GetMapping("/company-detail/company-info/{cno}")
    @ResponseBody
    public ResponseEntity<Company> getCompanyByCno(@PathVariable("cno") String cno) {
        Company company = companyService.getCompanyByCno2(cno).orElse(null);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
