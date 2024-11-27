package goodsshop.service.employee;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import goodsshop.command.EmployeeCommand;
import goodsshop.domain.EmployeeDTO;
import goodsshop.repository.EmployeeRepository;

@Service
public class EmployeeHireService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(employeeCommand, dto);
		
		String encodePw = passwordEncoder.encode(employeeCommand.getEmpPw());
		dto.setEmpPw(encodePw);
		
		dto.setEmpPost(employeeCommand.getEmpPost());
		
		employeeRepository.employeeInsert(dto);
	}
}
