package goodsshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import goodsshop.command.MemberCommand;
import goodsshop.service.mypage.MemberMyDeleteService;
import goodsshop.service.mypage.MemberMyInfoService;
import goodsshop.service.mypage.MemberMyUpdateService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("myPage")
public class MyPageController {
	@Autowired
	MemberMyInfoService memberMyInfoService;
	@Autowired
	MemberMyUpdateService memberMyUpdateService;
	@Autowired
	MemberMyDeleteService memberMyDeleteService;
	
	@GetMapping("memberMyPage")
	public String memberMyPage(HttpSession session, Model model) {
		memberMyInfoService.execute(session, model);
		return "thymeleaf/myPage/memberMyPage";
	}
	
	@GetMapping("memberMyPageUpdate")
	public String memberUpdate(HttpSession session, Model model) {
		memberMyInfoService.execute(session, model);
		return "thymeleaf/myPage/memberMyPageUpdate";
	}
	
	@PostMapping("memberMyPageUpdate")
	public String memberUpdate(MemberCommand memberCommand, HttpSession session) {
		memberMyUpdateService.execute(memberCommand, session);
		return "redirect:memberMyPage";
	}
	
	@GetMapping("memberMyPageDelete")
	public String memberMyPageDelete(HttpSession session) {
		memberMyDeleteService.execute(session);
		session.invalidate();
		return "redirect:/";
	}
}
