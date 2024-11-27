package goodsshop.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import goodsshop.domain.EmployeeDTO;
import goodsshop.repository.EmployeeRepository;

@Service
public class EmployeeDetailService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void execute(String empNum, Model model) {
		EmployeeDTO dto = employeeRepository.employeeOneSelect(empNum);
		model.addAttribute("employeeCommand", dto);
	}
}
