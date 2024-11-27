package goodsshop.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import goodsshop.domain.EmployeeDTO;
import goodsshop.repository.EmployeeRepository;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void execute(Model model) {
		List<EmployeeDTO> list = employeeRepository.employeeAllSelect();
		model.addAttribute("list", list);
	}
}
