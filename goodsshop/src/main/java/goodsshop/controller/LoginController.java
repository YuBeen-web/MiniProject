package goodsshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import goodsshop.command.LoginCommand;
import goodsshop.service.login.EmpIdCheckSerivce;
import goodsshop.service.login.IdcheckService;
import goodsshop.service.login.UserLoginService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	UserLoginService userLoginService;
	@Autowired
	EmpIdCheckSerivce empIdCheckService;
	
	@PostMapping("userIdCheck")
	public @ResponseBody Integer userIdCheck(String userId) {
		return idcheckService.execute(userId);
	}
	
	@PostMapping("empIdCheck")
	public @ResponseBody Integer empIdCheck(String userId) {
		return empIdCheckService.execute(userId);
	}
	
	@PostMapping("login")
	public String login(@Validated LoginCommand loginCommand,BindingResult result, HttpSession session, Model model) {
		userLoginService.execute(loginCommand,result, session);
		if(result.hasErrors()) {
			return "thymeleaf/index";
		}
		return "redirect:/";
	}
}
