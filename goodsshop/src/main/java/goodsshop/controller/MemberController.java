package goodsshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodsshop.command.MemberCommand;
import goodsshop.service.member.MemberDetailService;
import goodsshop.service.member.MemberListService;
import goodsshop.service.member.MemberUpdateService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	
	@GetMapping("memberList")
	public String memberList(
			@RequestParam(value="page", required = false, defaultValue = "1") int page,
			@RequestParam(value="searchWord", required = false) String searchWord,
			Model model) {
		memberListService.execute(searchWord, page, model);
		return "thymeleaf/member/memberList";
	}
	
	@GetMapping("memberDetail")
	public String memberDetail(String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberInfo";
	}
	
	@GetMapping("memberModify")
	public String memberModify(String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberUpdate";
	}
	
	@PostMapping("memberModify")
	public String memberModify(MemberCommand memberCommand) {
		memberUpdateService.execute(memberCommand);
		return "redirect:memberDetail?memberNum="+memberCommand.getMemberNum();
	}
}
