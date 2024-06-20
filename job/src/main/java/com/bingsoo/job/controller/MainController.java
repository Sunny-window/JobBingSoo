package com.bingsoo.job.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.entity.Posting_skill;
import com.bingsoo.job.entity.RedBean;
import com.bingsoo.job.entity.Subscribe;
import com.bingsoo.job.jwtToken.JWTUtil;
import com.bingsoo.job.repository.CompanyRepository;
import com.bingsoo.job.repository.MemberRepository;
import com.bingsoo.job.repository.PostingRepository;
import com.bingsoo.job.repository.RedBeanRepository;
import com.bingsoo.job.repository.SubscribeRepository;
import com.bingsoo.job.service.CompanyService;
import com.bingsoo.job.service.PostingService;

import io.jsonwebtoken.Claims;

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
    private PostingService postingService;
    
    @Autowired
    private PostingRepository postingRepository;
    
    @Autowired
    private SubscribeRepository subscribeRepository;
    
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
                .role("BEAN")
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
                .role("COM")
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
            .filter(company -> filterByCompanyName(company, filterRequest.getCompanyName()))
            .collect(Collectors.toList());

        return filteredCompanies.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    private boolean filterBySales(Company company, List<String> salesFilters) {
        if (salesFilters.isEmpty()) return true;
        int sales = company.getSales();
        for (String filter : salesFilters) {
            switch (filter) {
                case "~3000":
                    if (sales < 3000) return true;
                    break;
                case "3000~5000":
                    if (sales >= 3000 && sales < 5000) return true;
                    break;
                case "5000~7000":
                    if (sales >= 5000 && sales < 7000) return true;
                    break;
                case "7000~":
                    if (sales >= 7000) return true;
                    break;
            }
        }
        return false;
    }

    private boolean filterBySize(Company company, List<String> sizeFilters) {
        if (sizeFilters.isEmpty()) return true;
        int size = Integer.parseInt(company.getSize());
        for (String filter : sizeFilters) {
            switch (filter) {
                case "대기업":
                    if (size >= 300) return true;
                    break;
                case "중견기업":
                    if (size >= 100 && size < 300) return true;
                    break;
                case "중소기업":
                    if (size < 100) return true;
                    break;
            }
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
    
    private boolean filterByCompanyName(Company company, String companyName) {
        if (companyName == null || companyName.isEmpty()) return true;
        return company.getCompany_name().toLowerCase().contains(companyName.toLowerCase());
    }
    
    static class FilterRequest {
        private List<String> sales;
        private List<String> size;
        private List<String> industry;
        private String companyName;

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
        
        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
    }
    
    @GetMapping("/company-detail/company-info/{cno}")
    public ResponseEntity<CompanyResponse> getCompanyInfo(@PathVariable("cno") String cno) {
        try {
            Company company = companyService.getCompanyByCno(cno);
            if (company != null) {
                CompanyResponse response = convertToResponse(company);
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/company-detail/by-post-code/{postCode}")
    public ResponseEntity<CompanyResponse> getCompanyByPostCode(@PathVariable("postCode") Long postCode) {
        try {
            Optional<Posting> postingOpt = postingRepository.findById(postCode);
            if (postingOpt.isPresent()) {
                Member cid = postingOpt.get().getCid();
                Optional<Company> companyOpt = companyRepository.findByCid(cid);
                if (companyOpt.isPresent()) {
                    CompanyResponse response = convertToResponse(companyOpt.get());
                    return ResponseEntity.ok(response);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/company-detail/postings/{cid}")
    public ResponseEntity<List<PostingResponse>> getPostingsByCid(@PathVariable("cid") String cid) {
        Optional<Member> memberOpt = memberRepository.findById(cid);
        if (memberOpt.isPresent()) {
            List<Posting> postings = postingService.getPostingsByCid(memberOpt.get());
            List<PostingResponse> response = postings.stream()
                    .map(this::convertToPostingResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    private PostingResponse convertToPostingResponse(Posting posting) {
        List<Posting_skill> skills = postingService.getSkillsByPostCode(posting.getPost_code());
        String skillList = skills.stream()
                                 .map(Posting_skill::getStack)
                                 .collect(Collectors.joining(", "));
        String companyName = getCompanyName(posting);
        return new PostingResponse(
            posting.getPost_code(),
            posting.getTitle(),
            posting.getArea(),
            posting.getEmployment_type(),
            posting.getEdu_type(),
            posting.getCareer(),
            posting.getPay(),
            posting.getDeadline(),
            posting.getPostedDate(),
            posting.getJob(),
            posting.getManager_tel(),
            posting.getMain_content(),
            companyName,
            skillList
        );
    }


    private String getCompanyName(Posting posting) {
        if (posting.getCid() != null) {
            Optional<Company> companyOpt = companyRepository.findByCid(posting.getCid());
            if (companyOpt.isPresent()) {
                return companyOpt.get().getCompany_name();
            }
        }
        return "N/A";
    }

    public class PostingResponse {
        private Long postCode;
        private String title;
        private String area;
        private String employmentType;
        private String eduType;
        private String career;
        private Integer pay;
        private LocalDate deadline;
        private LocalDate postedDate;
        private String job;
        private String managerTel;
        private String mainContent;
        private String companyName;
        private String skill;

        public PostingResponse(Long postCode, String title, String area, String employmentType, String eduType, String career, Integer pay, LocalDate deadline, LocalDate postedDate, String job, String managerTel, String mainContent, String companyName, String skill) {
            this.postCode = postCode;
            this.title = title;
            this.area = area;
            this.employmentType = employmentType;
            this.eduType = eduType;
            this.career = career;
            this.pay = pay;
            this.deadline = deadline;
            this.postedDate = postedDate;
            this.job = job;
            this.managerTel = managerTel;
            this.mainContent = mainContent;
            this.companyName = companyName;
            this.skill = skill;
        }

        public Long getPostCode() {
            return postCode;
        }

        public void setPostCode(Long postCode) {
            this.postCode = postCode;
        }

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public String getEmploymentType() {
			return employmentType;
		}

		public void setEmploymentType(String employmentType) {
			this.employmentType = employmentType;
		}

		public String getEduType() {
			return eduType;
		}

		public void setEduType(String eduType) {
			this.eduType = eduType;
		}

		public String getCareer() {
			return career;
		}

		public void setCareer(String career) {
			this.career = career;
		}

		public Integer getPay() {
			return pay;
		}

		public void setPay(Integer pay) {
			this.pay = pay;
		}

		public LocalDate getDeadline() {
			return deadline;
		}

		public void setDeadline(LocalDate deadline) {
			this.deadline = deadline;
		}
		
		public LocalDate getPostedDate() {
			return postedDate;
		}

		public void setPostedDate(LocalDate postedDate) {
			this.postedDate = postedDate;
		}

		public String getJob() {
			return job;
		}

		public void setJob(String job) {
			this.job = job;
		}

		public String getManagerTel() {
			return managerTel;
		}

		public void setManagerTel(String managerTel) {
			this.managerTel = managerTel;
		}

		public String getMainContent() {
			return mainContent;
		}

		public void setMainContent(String mainContent) {
			this.mainContent = mainContent;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getSkill() {
			return skill;
		}

		public void setSkill(String skill) {
			this.skill = skill;
		}
    }

    @GetMapping("/post-detail/{postCode}")
    public ResponseEntity<PostingResponse> getPostDetail(@PathVariable("postCode") Long postCode) {
        Optional<Posting> postingOpt = postingRepository.findById(postCode);
        if (postingOpt.isPresent()) {
            Posting posting = postingOpt.get();
            PostingResponse response = convertToPostingResponse(posting);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    private CompanyResponse convertToResponse(Company company) {
        return new CompanyResponse(
            company.getCno(),
            company.getCompany_name(),
            company.getSccode() != null ? company.getSccode().getSub() : null,
            company.getSize(),
            company.getCeo(),
            company.getTel(),
            company.getAddress(),
            company.getSales(),
            company.getCid() != null ? company.getCid().getUsername() : null
        );
    }

    static class CompanyResponse {
        private String cno;
        private String companyName;
        private String subCategoryName;
        private String size;
        private String ceo;
        private String tel;
        private String address;
        private Integer sales;
        private String cid;

        public CompanyResponse(String cno, String companyName, String subCategoryName, String size, String ceo, String tel, String address, Integer sales, String cid) {
            this.cno = cno;
            this.companyName = companyName;
            this.subCategoryName = subCategoryName;
            this.size = size;
            this.ceo = ceo;
            this.tel = tel;
            this.address = address;
            this.sales = sales;
            this.cid = cid;
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

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getCeo() {
			return ceo;
		}

		public void setCeo(String ceo) {
			this.ceo = ceo;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Integer getSales() {
			return sales;
		}

		public void setSales(Integer sales) {
			this.sales = sales;
		}

		public String getCid() {
			return cid;
		}
		
		public void setCid(String cid) {
			this.cid = cid;
		}
    }
    
    @GetMapping("/main/postings-list")
    public List<Posting> getLatestPostings(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        return postingService.getLatestPostings(page, size);
    }
    
    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribeCompany(@RequestBody Map<String, String> request, @RequestHeader("Authorization") String token) {
        String cno = request.get("cid"); // 여기서 `cid` 대신 `cno`를 받아야 합니다.

        // JWT에서 "Bearer " 접두사 제거
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        // JWT 검증 및 사용자 이름 추출
        if (!JWTUtil.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid token");
        }
        Claims claims = JWTUtil.parseToken(token);
        String username = claims.getSubject();

        // `cno`로 Company를 조회
        Optional<Company> companyOpt = companyRepository.findById(cno);
        if (!companyOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company not found");
        }
        
        // Company에서 `cid`를 추출
        Member companyMember = companyOpt.get().getCid();
        Optional<Member> userMemberOpt = memberRepository.findById(username);

        if (!userMemberOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }

        Member userMember = userMemberOpt.get();

        if (subscribeRepository.existsByCidAndRid(companyMember, userMember)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("already subscribed");
        }

        Subscribe subscribe = Subscribe.builder()
                .cid(companyMember)
                .rid(userMember)
                .build();

        subscribeRepository.save(subscribe);
        return ResponseEntity.ok("success");
    }
}
