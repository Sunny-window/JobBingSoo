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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.dto.NoticeDto;
import com.bingsoo.job.entity.Cs;
import com.bingsoo.job.entity.Cs_reply;
import com.bingsoo.job.entity.Desired_area;
import com.bingsoo.job.entity.Desired_industry;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Notice;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.repository.CompanyRepository;
import com.bingsoo.job.repository.CsRepository;
import com.bingsoo.job.repository.Cs_replyRepository;
import com.bingsoo.job.repository.Desired_areaRepository;
import com.bingsoo.job.repository.Desired_industryRepository;
import com.bingsoo.job.repository.MemberRepository;
import com.bingsoo.job.repository.NoticeRepository;
import com.bingsoo.job.repository.PostingRepository;

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
	private Desired_areaRepository desiredAreaRepository;

	@Autowired
	private Desired_industryRepository desiredIndustryRepository;

	@GetMapping("/member-all")
	public Map<String, List<Member>> getData() {
		List<Member> members = memberRepository.findByRole("ROLE_RED_BEAN");
		List<Member> companies = memberRepository.findByRole("ROLE_ICE");
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
	public Notice sendNotice(@RequestBody NoticeDto noticeDto) {
		Member sender = memberRepository.findById("manager")
				.orElseThrow(() -> new RuntimeException("발신자 계정을 찾을 수 없습니다."));
		String[] receiverUsernames = noticeDto.getReceivers().split(", ");
		Notice notice = new Notice();
		notice.setSender(sender);
		notice.setMessage(noticeDto.getTitle() + ": " + noticeDto.getContent());
		notice.setType("관리자");

		for (String receiverUsername : receiverUsernames) {
			Member receiver = memberRepository.findById(receiverUsername)
					.orElseThrow(() -> new RuntimeException("수신자 계정을 찾을 수 없습니다."));
			notice.setReciever(receiver);
			noticeRepository.save(notice);
		}
		return notice;
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
			members = memberRepository.findByRole("ROLE_RED_BEAN");
		} else {
			members = memberRepository.findByRole("ROLE_ICE");
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
	    public List<Posting> findPostingsForUser() {
	        String username = "user01"; // 하드코딩된 사용자명
	        Optional<Member> memberOptional = memberRepository.findById(username);
	        if (memberOptional.isPresent()) {
	            Member member = memberOptional.get();
	            Optional<Desired_area> desiredAreaOptional = desiredAreaRepository.findByRid(member);
	            Optional<Desired_industry> desiredIndustryOptional = desiredIndustryRepository.findByRid(member);

	            if (desiredAreaOptional.isPresent() && desiredIndustryOptional.isPresent()) {
	                Desired_area desiredArea = desiredAreaOptional.get();
	                Desired_industry desiredIndustry = desiredIndustryOptional.get();
	                return postingRepository.findByAreaAndIndustry(desiredArea.getArea_main(), desiredIndustry.getIndustry());
	            }
	        }
	        return null;
	    }
}
