package goodsshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodsshop.command.EmployeeCommand;
import goodsshop.service.AutoNumService;
import goodsshop.service.employee.EmployeeDeleteService;
import goodsshop.service.employee.EmployeeDetailService;
import goodsshop.service.employee.EmployeeHireService;
import goodsshop.service.employee.EmployeeListService;
import goodsshop.service.employee.EmployeeUpdateService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeHireService employeeHireService;
	@Autowired
	AutoNumService autoNumSerivce;
	@Autowired
	EmployeeDetailService employeeDetailService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	
	@GetMapping("employeeList")
	public String employeeList(
			@RequestParam(value="page", required = false, defaultValue = "1") int page,
			@RequestParam(value="searchWord", required = false) String searchWord,
			Model model) {
		employeeListService.execute(searchWord, page, model);
		return "thymeleaf/employee/employeeList";
	}
	
	@GetMapping("employeeRegist")
	public String employeeRegist(Model model) {
		String autoNum = autoNumSerivce.execute("emp_","emp_num",5,"employees");
		EmployeeCommand employeeCommand = new EmployeeCommand();
		employeeCommand.setEmpNum(autoNum);
		model.addAttribute("employeeCommand", employeeCommand);
		return "thymeleaf/employee/employeeForm";
	}
	
	@PostMapping("employeeHire")
	public String employeeHire(EmployeeCommand employeeCommand) {
		employeeHireService.execute(employeeCommand);
		return "redirect:employeeList";
	}
	
	@GetMapping("employeeDetail")
	public String employeeDetail(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/employee/employeeInfo";
	}
	
	@GetMapping("employeeModify")
	public String employeeModify(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/employee/employeeUpdate";
	}
	
	@PostMapping("employeeModify")
	public String employeeModify(EmployeeCommand employeeCommand) {
		employeeUpdateService.execute(employeeCommand);
		return "redirect:employeeDetail?empNum="+employeeCommand.getEmpNum();
	}
	
	@GetMapping("employeeDelete")
	public String employeeDelete(String empNum) {
		employeeDeleteService.execute(empNum);
		return "redirect:employeeList";
	}
	
}
