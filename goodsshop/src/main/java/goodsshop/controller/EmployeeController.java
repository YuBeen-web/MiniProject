package goodsshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import goodsshop.command.EmployeeCommand;
import goodsshop.service.AutoNumService;
import goodsshop.service.employee.EmployeeDetailService;
import goodsshop.service.employee.EmployeeHireService;
import goodsshop.service.employee.EmployeeListService;

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
	
	@GetMapping("employeeList")
	public String employeeList(Model model) {
		employeeListService.execute(model);
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
}
