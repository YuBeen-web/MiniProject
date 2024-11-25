package goodsshop.controller;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import goodsshop.command.UserCommand;
import goodsshop.service.AutoNumService;
import goodsshop.service.member.MemberWriteService;

@Controller
@RequestMapping("register")
public class MemberJoinController {
	@Autowired
	MemberWriteService memberWriteService;
	@Autowired
	AutoNumService autoNumService;
	
	@GetMapping("userAgree")
	public String userAgree() {
		return "thymeleaf/memberJoin/userAgree";
	}
	@GetMapping("userWrite")
	public String userWrite(Model model) {
		String autoNum = autoNumService.execute("mem_","member_num",5,"members");
		UserCommand userCommand = new UserCommand();
		userCommand.setMemberNum(autoNum);
		model.addAttribute("userCommand", userCommand);
		return "thymeleaf/memberJoin/userForm";
	}
	@PostMapping("userWrite")
	public String user(@Validated UserCommand userCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/memberJoin/userForm";
		}
		if(!userCommand.isMemberPwEqualMemberPwCon()) {
			result.rejectValue("memberPwCon", "userCommand.memberPwCon", "비밀번호가 일치 하지 않습니다.");
			return "System.out.println(\"비밀번호 확인이 다릅니다.\");";
		}
		memberWriteService.execute(userCommand);
		return "thymeleaf/memberJoin/userJoin";
	}
}
