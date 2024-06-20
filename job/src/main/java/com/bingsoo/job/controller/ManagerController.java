package com.bingsoo.job.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.bingsoo.job.dto.ApplyRequest;
import com.bingsoo.job.dto.NoticeDto;
import com.bingsoo.job.dto.SubscribeRequest;
import com.bingsoo.job.entity.Application;
import com.bingsoo.job.entity.Cs;
import com.bingsoo.job.entity.Cs_reply;
import com.bingsoo.job.entity.Desired_area;
import com.bingsoo.job.entity.Desired_industry;
import com.bingsoo.job.entity.Favorite;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Notice;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.entity.Resume;
import com.bingsoo.job.entity.Subscribe;
import com.bingsoo.job.jwtToken.JWTUtil;
import com.bingsoo.job.repository.ApplicationRepository;
import com.bingsoo.job.repository.CompanyRepository;
import com.bingsoo.job.repository.CsRepository;
import com.bingsoo.job.repository.Cs_replyRepository;
import com.bingsoo.job.repository.Desired_areaRepository;
import com.bingsoo.job.repository.Desired_industryRepository;
import com.bingsoo.job.repository.FavoriteRepository;
import com.bingsoo.job.repository.MemberRepository;
import com.bingsoo.job.repository.NoticeRepository;
import com.bingsoo.job.repository.PostingRepository;
import com.bingsoo.job.repository.ResumeRepository;
import com.bingsoo.job.repository.SubscribeRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/manager")
@CrossOrigin(origins = "http://localhost:8080")
public class ManagerController {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	NoticeRepository noticeRepository;

	@Autowired
	CsRepository csRepository;

	@Autowired
	Cs_replyRepository cs_replyRepository;

	@Autowired
	PostingRepository postingRepository;

	@Autowired
	Desired_areaRepository desiredAreaRepository;

	@Autowired
	Desired_industryRepository desiredIndustryRepository;

	@Autowired
	FavoriteRepository favoriteRepository;

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	ResumeRepository resumeRepository;

	@GetMapping("/member-all")
	public Map<String, List<Member>> getData() {
		List<Member> members = memberRepository.findByRole("BEAN");
		List<Member> companies = memberRepository.findByRole("COM");
		Map<String, List<Member>> data = new HashMap<>();
		data.put("members", members);
		data.put("companies", companies);
		return data;
	}

	@GetMapping("/admin-csList")
	public List<Cs> getCsList(@RequestParam("type") String type) {
		return csRepository.findByTypeOrderByResultAscDateAsc(type);
	}

	@GetMapping("/cs-detail")
	public Map<String, Object> getCsDetail(@RequestParam("cs_code") long csCode) {
		Map<String, Object> response = new HashMap<>();
		Cs cs = csRepository.findById(csCode).orElse(null);
		if (cs != null) {
			response.put("cs", cs);
			List<Cs_reply> replies = cs_replyRepository.findByCsCode(cs);
			response.put("replies", replies);
		}
		return response;
	}

	@PostMapping("/reply")
	public Cs_reply addOrUpdateReply(@RequestParam("cs_code") long csCode, @RequestParam("comment") String comment,
			@RequestParam("reply_id") Optional<Long> replyId) {
		Cs cs = csRepository.findById(csCode).orElse(null);
		if (cs != null) {
			Cs_reply reply;
			if (replyId.isPresent()) {
				Optional<Cs_reply> optionalReply = cs_replyRepository.findById(replyId.get());
				if (optionalReply.isPresent()) {
					reply = optionalReply.get();
				} else {
					reply = new Cs_reply();
				}
			} else {
				reply = new Cs_reply();
			}
			reply.setCsCode(cs);
			reply.setComment(comment);
			cs.setResult("답변");
			csRepository.save(cs);
			return cs_replyRepository.save(reply);
		}
		return null;
	}

	@PostMapping("/reply/{replyId}/edit")
	public Cs_reply editReply(@PathVariable("replyId") long replyId, @RequestParam("comment") String comment) {
		Cs_reply reply = cs_replyRepository.findById(replyId).orElse(null);
		if (reply != null) {
			reply.setComment(comment);
			return cs_replyRepository.save(reply);
		}
		return null;
	}

	@PostMapping("/send-notice")
	public ResponseEntity<Map<String, String>> sendNotice(@RequestBody NoticeDto noticeDto) {
	    Member sender = memberRepository.findById("manager")
	            .orElseThrow(() -> new RuntimeException("발신자 계정을 찾을 수 없습니다."));
	    String[] receiverUsernames = noticeDto.getReceivers().split(", ");
	    for (String receiverUsername : receiverUsernames) {
	        Member receiver = memberRepository.findById(receiverUsername)
	                .orElseThrow(() -> new RuntimeException("수신자 계정을 찾을 수 없습니다."));
	        Notice notice = new Notice();
	        notice.setSender(sender);
	        notice.setReciever(receiver);
	        notice.setMessage(noticeDto.getTitle() + ": " + noticeDto.getContent());
	        notice.setType("관리자");
	        noticeRepository.save(notice);
	    }
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "전송성공");
	    return ResponseEntity.ok(response);
	}
	
	@GetMapping("/notices")
	public List<Notice> getAllNotices() {
		return noticeRepository.findAll();
	}

	@GetMapping("/dashboard-data")
	public Map<String, Object> getDashboardData() {
		Map<String, Object> data = new HashMap<>();

		// 최근 7일간의 가입자 수
		LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
		Map<String, Long> last7DaysMembers = memberRepository.findAll().stream()
				.filter(member -> member.getJoinDate() != null && member.getJoinDate().isAfter(sevenDaysAgo))
				.collect(Collectors.groupingBy(member -> member.getJoinDate().toString(), Collectors.counting()));
		data.put("last7DaysMembers", last7DaysMembers);

		// 최근 한 달간의 채용 공고 수
		LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
		Map<String, Long> lastMonthPostings = postingRepository.findAll().stream()
				.filter(posting -> posting.getPostedDate() != null && posting.getPostedDate().isAfter(oneMonthAgo))
				.collect(Collectors.groupingBy(posting -> posting.getPostedDate().toString(), Collectors.counting()));
		data.put("lastMonthPostings", lastMonthPostings);

		// 하루 방문자 수 데이터 (임의 생성)
		Map<String, Integer> dailyVisitors = new HashMap<>();
		LocalDate today = LocalDate.now();
		Random random = new Random();
		for (int i = 0; i < 30; i++) {
			dailyVisitors.put(today.minusDays(i).toString(), random.nextInt(100));
		}
		data.put("dailyVisitors", dailyVisitors);

		return data;
	}

	@GetMapping("/download/excel")
	public void downloadExcel(@RequestParam(name = "type") String type, HttpServletResponse response)
			throws IOException {
		List<Member> members;
		if (type.equals("member")) {
			members = memberRepository.findByRole("BEAN");
		} else {
			members = memberRepository.findByRole("COM");
		}

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Members");

		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Username");
		headerRow.createCell(1).setCellValue("KakaoID");

		int rowNum = 1;
		for (Member member : members) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(member.getUsername());
			row.createCell(1).setCellValue(member.getKakaoId());
		}

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=members.xlsx");

		workbook.write(response.getOutputStream());
		workbook.close();
	}

    @GetMapping("/find-postings")
    public List<Posting> findPostingsForUser(@RequestHeader("Authorization") String token) {
        // JWT에서 "Bearer " 접두사 제거
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        // JWT 검증 및 사용자 이름 추출
        if (!JWTUtil.validateToken(token)) {
            return null;
        }
        Claims claims = JWTUtil.parseToken(token);
        String username = claims.getSubject();

        Optional<Member> memberOptional = memberRepository.findById(username);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            List<Desired_area> desiredAreas = desiredAreaRepository.findAllByRid(member);
            List<Desired_industry> desiredIndustries = desiredIndustryRepository.findAllByRid(member);

            return postingRepository.findAll().stream()
                .filter(posting -> desiredAreas.stream().anyMatch(da -> da.getArea_main().equals(posting.getArea())) &&
                                   desiredIndustries.stream().anyMatch(di -> di.getIndustry().equals(posting.getIndustry())))
                .collect(Collectors.toList());
        }
        return null;
    }


//	 @PostMapping("/subscribe")
//	 public String subscribe(@RequestBody SubscribeRequest request) {
//	     Posting postCode = postingRepository.findById(request.getPostCode()).orElse(null);
//	     Member rid = memberRepository.findById(request.getRid()).orElse(null);
//
//	     if (postCode == null || rid == null) {
//	         return "fail";
//	     }
//
//	     if (subscribeRepository.existsByPostCodeAndRid(postCode, rid)) {
//	         return "already subscribed";
//	     }
//
//	     Member cid = postCode.getCid();
//
//	     Subscribe subscribe = new Subscribe();
//	     subscribe.setPostCode(postCode);
//	     subscribe.setRid(rid);
//	     subscribe.setCid(cid);
//
//	     subscribeRepository.save(subscribe);
//	     return "success";
//	 }

	 @GetMapping("/resumes")
	    public List<Resume> getResumes(@RequestHeader("Authorization") String token) {
	        // JWT에서 "Bearer " 접두사 제거
	        if (token.startsWith("Bearer ")) {
	            token = token.substring(7);
	        }

	        // JWT 검증 및 사용자 이름 추출
	        if (!JWTUtil.validateToken(token)) {
	            return null;
	        }
	        Claims claims = JWTUtil.parseToken(token);
	        String username = claims.getSubject();

	        Member member = memberRepository.findById(username).orElse(null);
	        if (member != null) {
	            return resumeRepository.findByRid(member);
	        }
	        return null;
	    }

	 @PostMapping("/apply")
	 public String apply(@RequestBody ApplyRequest request, @RequestHeader("Authorization") String token) {
	     // JWT에서 "Bearer " 접두사 제거
	     if (token.startsWith("Bearer ")) {
	         token = token.substring(7);
	     }

	     // JWT 검증 및 사용자 이름 추출
	     if (!JWTUtil.validateToken(token)) {
	         return "invalid token";
	     }
	     Claims claims = JWTUtil.parseToken(token);
	     String username = claims.getSubject();

	     Posting post = postingRepository.findById(request.getPostCode()).orElse(null);
	     Member member = memberRepository.findById(username).orElse(null);
	     Resume resume = resumeRepository.findById(request.getResumeCode()).orElse(null);

	     if (post == null || member == null || resume == null) {
	         return "fail";
	     }

	     // 이미 지원한 공고인지 확인
	     Optional<Application> existingApplication = applicationRepository.findByPostCodeAndRid(post, member);
	     if (existingApplication.isPresent()) {
	         return "already applied";
	     }

	     Application application = new Application();
	     application.setPostCode(post);
	     application.setRid(member);
	     application.setResult("지원 완료");

	     applicationRepository.save(application);
	     return "success";
	 }
	

    @PostMapping("/favorite")
    public String addFavorite(@RequestBody Map<String, String> request, @RequestHeader("Authorization") String token) {
        String postCode = request.get("postCode");

        // JWT에서 "Bearer " 접두사 제거
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        // JWT 검증 및 사용자 이름 추출
        if (!JWTUtil.validateToken(token)) {
            return "invalid token";
        }
        Claims claims = JWTUtil.parseToken(token);
        String username = claims.getSubject();

        Posting post = postingRepository.findById(Long.parseLong(postCode)).orElse(null);
        Member user = memberRepository.findById(username).orElse(null);

        if (post == null || user == null) {
            return "fail";
        }

        if (favoriteRepository.existsByPostCodeAndUsername(post, user)) { // 수정된 메서드명 사용
            return "already favorite";
        }

        Favorite favorite = new Favorite();
        favorite.setPostCode(post); // 필드명을 정확히 사용
        favorite.setUsername(user);

        favoriteRepository.save(favorite);
        return "success";
    }
    
    @GetMapping("/recommendations")
    public ResponseEntity<Map<String, Object>> getRecommendations(@RequestHeader("Authorization") String token) {
        Map<String, Object> recommendations = new HashMap<>();

        // JWT에서 "Bearer " 접두사 제거
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        // JWT 검증 및 사용자 이름 추출
        if (!JWTUtil.validateToken(token)) {
            recommendations.put("error", "Invalid token");
            return ResponseEntity.status(401).body(recommendations);
        }
        Claims claims = JWTUtil.parseToken(token);
        String username = claims.getSubject();

        Optional<Member> memberOptional = memberRepository.findById(username);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();

            // 사용자의 이력서 목록 가져오기
            List<Resume> resumes = resumeRepository.findByRid(member);
            recommendations.put("resumes", resumes);

            // 사용자 희망 지역 및 산업 가져오기
            Optional<Desired_area> desiredAreaOptional = desiredAreaRepository.findByRid(member);
            Optional<Desired_industry> desiredIndustryOptional = desiredIndustryRepository.findByRid(member);

            // 추천 공고 목록 가져오기
            if (desiredAreaOptional.isPresent() && desiredIndustryOptional.isPresent()) {
                Desired_area desiredArea = desiredAreaOptional.get();
                Desired_industry desiredIndustry = desiredIndustryOptional.get();

                List<Posting> recommendedPostings = postingRepository.findByAreaAndIndustry(desiredArea.getArea_main(), desiredIndustry.getIndustry());
                recommendations.put("recommendedPostings", recommendedPostings);
            }
        }

        return ResponseEntity.ok(recommendations);
    }
}
