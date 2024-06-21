package com.bingsoo.job.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.dto.FavoriteForNameDto;
import com.bingsoo.job.dto.ResumeDto;
import com.bingsoo.job.dto.SubscribeForNameDto;
import com.bingsoo.job.entity.Application;
import com.bingsoo.job.entity.Career;
import com.bingsoo.job.entity.Certificate;
import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.Cover_letter;
import com.bingsoo.job.entity.Desired_area;
import com.bingsoo.job.entity.Desired_industry;
import com.bingsoo.job.entity.Favorite;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.entity.RedBean;
import com.bingsoo.job.entity.Resume;
import com.bingsoo.job.entity.Subscribe;
import com.bingsoo.job.jwtToken.JWTUtil;
import com.bingsoo.job.repository.ApplicationRepository;
import com.bingsoo.job.repository.CareerRepository;
import com.bingsoo.job.repository.CertificateRepository;
import com.bingsoo.job.repository.CompanyRepository;
import com.bingsoo.job.repository.Cover_letterRepository;
import com.bingsoo.job.repository.Desired_areaRepository;
import com.bingsoo.job.repository.Desired_industryRepository;
import com.bingsoo.job.repository.FavoriteRepository;
import com.bingsoo.job.repository.PostingRepository;
import com.bingsoo.job.repository.RedBeanRepository;
import com.bingsoo.job.repository.ResumeRepository;
import com.bingsoo.job.repository.SubscribeRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/redbean")
public class RedbeanController {
	@Autowired
	RedBeanRepository redBeanRepository;

	@Autowired
	ResumeRepository resumeRepository;
	@Autowired
	SubscribeRepository subscribeRepository;

	@Autowired
	FavoriteRepository favoriteRepository;

	@Autowired
	Cover_letterRepository cover_letterRepository;

	@Autowired
	Desired_areaRepository desired_areaRepository;

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	Desired_industryRepository desired_industryRepository;
	
	@Autowired
	PostingRepository postingRepository;

	@Autowired
	CareerRepository careerRepository;

	@Autowired
	CertificateRepository certificateRepository;

	@Autowired
	CompanyRepository companyRepository;

	@GetMapping("/showInfoForm")
	public String showInfoForm() {

		return "등록성공";
	}

	@PutMapping("/updateInfo")
	public String updateInfo(@RequestBody RedBean redBean, @RequestParam("rid") String rid) {
		System.out.println("==============================redBean : " + redBean);
		Member mem = new Member();
		mem.setUsername(rid);
		redBean.setRid(mem);
		System.out.println("=========================mem" + mem);
		redBeanRepository.save(redBean);
		return "등록성공";
	}

	@GetMapping("/showUpdateForm")
	public RedBean showUpdateForm(@RequestHeader("Authorization") String token) {
		System.out.println("==============================redBean :");
		String actualToken = token.substring(7);
		String tokenname = JWTUtil.getUsername(actualToken);
		Member member = new Member();
		member.setUsername(tokenname);
		RedBean redbean = redBeanRepository.findByRid(member).get(0);
		return redbean;
	}

	@PutMapping("/resumeWrite")
	public String resumeWrite(@RequestBody ResumeDto resumedto, @RequestHeader("Authorization") String token) {

		System.out.println("==============================resumedto : " + resumedto);
		//Resume resume = resumeRepository.findRdCode(resume_code);
		Resume resume = new Resume();
		//RedBean redbean = redBeanRepository.findByRid(resume.getRid()).get(0);
		RedBean redbean = new RedBean();
		
		String actualToken = token.substring(7);
		String tokenname = JWTUtil.getUsername(actualToken);
		
		
		Desired_area desired_area = new Desired_area();
//		Optional<Desired_area> opdesired_area = desired_areaRepository.findByRid(redbean.getRid());
//		if (!opdesired_area.isPresent()) {
//			return "원하는 지역 정보를 찾을 수 없습니다.";
//		}
//		Desired_area desired_area = opdesired_area.get();
		
	    Desired_industry desired_industry = new Desired_industry();
	    Career career = new Career();
	    career.setCompanyName(resumedto.getCompanyname());
	    career.setCarDate(resumedto.getCardate());
	    career.setEndDate(resumedto.getEnddate());
	    career.setIndustry(resumedto.getIndustry());
	    career.setJob(resumedto.getJob());
	    career.setPosition(resumedto.getPosition());
	    
		redbean.setName(resumedto.getName());
		redbean.setAddress(resumedto.getAddress());
		redbean.setTel(resumedto.getTel());
		redbean.setEmail(resumedto.getEmail());
		redBeanRepository.save(redbean);
		Member member = new Member();
		member.setUsername(tokenname);
		resume.setRid(member);
		resume.setTitle(resumedto.getTitle());
		resume.setEdu_name(resumedto.getEdu_name());
		resume.setEdu_type(resumedto.getEdu_type());
		resume.setEdu_major(resumedto.getEdu_major());
		resume.setEdu_state(resumedto.getEdu_state());
		resumeRepository.save(resume);

		desired_area.setArea_main(resumedto.getArea_main());
		desired_area.setArea_sub(resumedto.getArea_sub());
		desired_areaRepository.save(desired_area);

		desired_industry.setIndustry(resumedto.getIndustry());
		desired_industry.setJob(resumedto.getJob());
		desired_industryRepository.save(desired_industry);

		career.setCompanyName(resumedto.getCompanyname());
		careerRepository.save(career);

		career.setCarDate(resumedto.getCardate());
		career.setEndDate(resumedto.getEnddate());
		career.setIndustry(resumedto.getIndustry());
		career.setPosition(resumedto.getPosition());
		careerRepository.save(career);
		
		Cover_letter cover_letter = new Cover_letter();
//		Cover_letter cover_letter = cover_letterRepository.findByResume_code(resume_code);
		cover_letter.setSungjang(resumedto.getSungjang());
		cover_letter.setJangdanzeum(resumedto.getJangdanzeum());
		cover_letter.setJuwondongki(resumedto.getJuwondongki());

		cover_letterRepository.save(cover_letter);

		//List<Certificate> certificate = certificateRepository.findByResume_code(resume_code);
		//System.out.println("=============================certificate: " + certificate);
		System.out.println("일=============================resumedto: " + resumedto);
		return "이력서 등록성공";
	}

//	@PutMapping("/resumeUpdate")
//	public String resumeUpdate(@RequestBody Resume resume
//			,@RequestBody Cover_letter cover_letter
//			,@RequestBody Desired_area desired_area
//			,@RequestBody Desired_industry desired_industry
//			,@RequestBody Career career
//			,@RequestBody Certificate certificate
//			) {
//		System.out.println("==============================resume : "+resume);
//		resumeRepository.save(resume);
//		cover_letterRepository.save(cover_letter);
//		desired_areaRepository.save(desired_area);
//		desired_industryRepository.save(desired_industry);
//		careerRepository.save(career);
//		certificateRepository.save(certificate);
//		return "등록성공";
//	}

	@PutMapping("/resumeUpdate")
	public String resumeUpdate(@RequestBody ResumeDto resumedto, @RequestParam("resume_code") long resume_code) {
		
		System.out.println("==============================resumedto : " + resumedto);
		System.out.println("==============================resume_code : " + resume_code);
		Resume resume = resumeRepository.findRdCode(resume_code);
		RedBean redbean = redBeanRepository.findByRid(resume.getRid()).get(0);

		Optional<Desired_area> opdesired_area = desired_areaRepository.findByRid(redbean.getRid());
		if (!opdesired_area.isPresent()) {
			return "원하는 지역 정보를 찾을 수 없습니다.";
		}
		Desired_area desired_area = opdesired_area.get();
		Optional<Desired_industry> opdesired_industry = desired_industryRepository.findByRid(redbean.getRid());
		if (!opdesired_industry.isPresent()) {
			return "원하는 산업 정보를 찾을 수 없습니다.";
		}
		Desired_industry desired_industry = opdesired_industry.get();
		System.out.println("==============================redbean.getRid() : " + redbean.getRid());

		List<Career> careerlist = careerRepository.findByRid(redbean.getRid());
		Career career = careerlist.get(0);

		redbean.setName(resumedto.getName());
		redbean.setAddress(resumedto.getAddress());
		redbean.setTel(resumedto.getTel());
		redbean.setEmail(resumedto.getEmail());
		redBeanRepository.save(redbean);

		resume.setTitle(resumedto.getTitle());
		resume.setEdu_name(resumedto.getEdu_name());
		resume.setEdu_type(resumedto.getEdu_type());
		resume.setEdu_major(resumedto.getEdu_major());
		resume.setEdu_state(resumedto.getEdu_state());
		resumeRepository.save(resume);

		desired_area.setArea_main(resumedto.getArea_main());
		desired_area.setArea_sub(resumedto.getArea_sub());
		desired_areaRepository.save(desired_area);

		desired_industry.setIndustry(resumedto.getIndustry());
		desired_industry.setJob(resumedto.getJob());
		desired_industryRepository.save(desired_industry);

		career.setCompanyName(resumedto.getCompanyname());
		careerRepository.save(career);

		career.setCarDate(resumedto.getCardate());
		career.setEndDate(resumedto.getEnddate());
		career.setIndustry(resumedto.getIndustry());
		career.setPosition(resumedto.getPosition());
		careerRepository.save(career);

		Cover_letter cover_letter = cover_letterRepository.findByResume_code(resume_code);
		cover_letter.setSungjang(resumedto.getSungjang());
		cover_letter.setJangdanzeum(resumedto.getJangdanzeum());
		cover_letter.setJuwondongki(resumedto.getJuwondongki());

		cover_letterRepository.save(cover_letter);

		List<Certificate> certificate = certificateRepository.findByResume_code(resume_code);
		System.out.println("=============================certificate: " + certificate);
		System.out.println("일=============================resumedto: " + resumedto);

//		for (int i =0;i<certificate.size();i++){
//			(certificate.get(i)).setStack(resumedto.getCer_stack().get(i).getStack());
//			certificateRepository.save(certificate.get(i));
//		}

		return "수정성공";
	}

	@GetMapping("/showResumeList")
	public List<Resume> showResumeList(@RequestHeader("Authorization") String token) {
		String actualToken = token.substring(7);
		String tokenname = JWTUtil.getUsername(actualToken);
		Member mem = new Member();
		mem.setUsername(tokenname);
		List<Resume> list = resumeRepository.findAllByRid(mem);
		System.out.println("==============================showResumeList : " + list);
		return list;
	}

	@GetMapping("/resumeDetail")
	public Resume resumeDetail(@RequestParam("resume_code") long resume_code) {
		Resume resume = resumeRepository.findRdCode(resume_code);
		return resume;
	}

	@GetMapping("/showResumeDetail")
	public Resume showResumeDetail(@RequestParam("resume_code") long resume_code) {
		System.out.println("==========================showResumeDetail Start ===============");
		Resume resume = resumeRepository.findRdCode(resume_code);
		return resume;
	}

	@GetMapping("/showSubscribeList")
	public List<SubscribeForNameDto> showSubscribeList(@RequestHeader("Authorization") String token) {
		System.out.println("==============================redBean : ");
		String actualToken = token.substring(7);
		String tokenname = JWTUtil.getUsername(actualToken);
		Member mem = new Member();
		mem.setUsername(tokenname);

		List<Subscribe> list = subscribeRepository.findByRid(mem);
		List<SubscribeForNameDto> list2 = new ArrayList<>();
		// List<Subscribe> list =subscribeRepository.findAll();
		for (int i = 0; i < list.size(); i++) {
			SubscribeForNameDto subscribeForNameDto = new SubscribeForNameDto();

			Optional<Company> opcompany = companyRepository.findByCid(list.get(i).getCid());
			Company company = opcompany.get();

			subscribeForNameDto.setCid(list.get(i).getCid().getUsername());
			subscribeForNameDto.setRid(list.get(i).getRid().getUsername());
			subscribeForNameDto.setCompany_name(company.getCompany_name());
			subscribeForNameDto.setCno(company.getCno());
			list2.add(subscribeForNameDto);
		}
		return list2;
	}

	@GetMapping("/showFavoriteList")
	public List<FavoriteForNameDto> showFavoriteList(@RequestHeader("Authorization") String token) {
	    System.out.println("==============================redBean : ");
	    String actualToken = token.substring(7);
	    String tokenname = JWTUtil.getUsername(actualToken);
	    Member mem = new Member();
	    mem.setUsername(tokenname);
	    List<Favorite> list = favoriteRepository.findByUsername(mem);
	    List<FavoriteForNameDto> list2 = new ArrayList<>();

	    for (int i = 0; i < list.size(); i++) {
	        Posting post = postingRepository.findByPostCode(list.get(i).getPostCode().getPost_code());

	        FavoriteForNameDto favoriteForNameDto = new FavoriteForNameDto();
	        favoriteForNameDto.setFavor_code(list.get(i).getFavorCode());
	        favoriteForNameDto.setPost_code(list.get(i).getPostCode().getPost_code());
	        favoriteForNameDto.setUsername(list.get(i).getUsername().getUsername());

	        Optional<Company> opcompany = companyRepository.findByCid(post.getCid());
	        System.out.println("======================================post.getCid() : "+post.getCid());
	        if (opcompany.isPresent()) {
	            Company company = opcompany.get();
	            favoriteForNameDto.setCompany_name(company.getCompany_name());
	        } else {
	            // 회사가 없는 경우에 대한 예외 처리
	            favoriteForNameDto.setCompany_name("회사 정보를 찾을 수 없습니다.");
	        }

	        list2.add(favoriteForNameDto);
	    }

	    return list2;
	}

	@GetMapping("/showApplicationList")
	public List<Application> showApplicationList() {
		System.out.println("==============================redBean : ");
		List<Application> list = applicationRepository.findAll();

		return list;
	}

//	@GetMapping("/showResumeUpdateForm")
//	public Resume showResumeUpdateForm(@RequestParam("resume_code") long resume_code) {
//		System.out.println("==============================redBean : ");
//		Resume resume = resumeRepository.findRdCode(resume_code);
//		List<RedBean> redbean = redBeanRepository.findByRid(resume.getRid());
//		System.out.println("================================resume: "+resume);
//		return resume;
//	}

	@GetMapping("/showResumeUpdateForm")
	public ResumeDto showResumeUpdateForm(@RequestParam("resume_code") long resume_code) {
		ResumeDto resumeDto = new ResumeDto();
		Resume resume = resumeRepository.findRdCode(resume_code);
		System.out.println("==========================================resume: " + resume);
		System.out.println("==========================================resume_code: " + resume_code);
		resumeDto.setTitle(resume.getTitle());

		RedBean redbean = redBeanRepository.findByRid(resume.getRid()).get(0);
		List<Certificate> cerStackList = certificateRepository.findByRid(resume.getRid());
		System.out.println("==========================================cerStackList: " + cerStackList);

		List<Career> careerlist = careerRepository.findByRid(redbean.getRid());
		Career career = careerlist.get(0);
		Desired_area desired_area = desired_areaRepository.findByResume_code(resume_code);
		System.out.println("==========================================desired_area: " + desired_area);
		Cover_letter cover_letter = cover_letterRepository.findByResume_code(resume_code);
		resumeDto.setName(redbean.getName());
		resumeDto.setAddress(redbean.getAddress());
		resumeDto.setTel(redbean.getTel());
		resumeDto.setEmail(redbean.getEmail());
		resumeDto.setEdu_name(resume.getEdu_name());
		resumeDto.setEdu_type(resume.getEdu_type());
		resumeDto.setEdu_major(resume.getEdu_major());
		resumeDto.setEdu_state(resume.getEdu_state());
		resumeDto.setArea_main(desired_area.getArea_main());
		resumeDto.setArea_sub(desired_area.getArea_sub());
		resumeDto.setCompanyname(career.getCompanyName());
		resumeDto.setCardate(career.getCarDate());
		resumeDto.setEnddate(career.getEndDate());
		resumeDto.setPosition(career.getPosition());
		resumeDto.setCer_stack(cerStackList);
		resumeDto.setSkill_stack(cerStackList);
		resumeDto.setIssuer(cerStackList.get(0).getIssuer());
		resumeDto.setSungjang(cover_letter.getSungjang());
		resumeDto.setJuwondongki(cover_letter.getJuwondongki());
		resumeDto.setJangdanzeum(cover_letter.getJangdanzeum());

		System.out.println("==========================================resumeDto: " + resumeDto);
		return resumeDto;
	}

	@DeleteMapping("/deleteResume")
	public String deleteResume(@RequestParam("resume_code") long resume_code) {

		resumeRepository.deleteByRdCode(resume_code);
		return resume_code + "번 삭제완료";
	}
	
	
	
}
