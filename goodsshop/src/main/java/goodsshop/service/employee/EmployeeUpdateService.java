package goodsshop.service.employee;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goodsshop.command.EmployeeCommand;
import goodsshop.domain.EmployeeDTO;
import goodsshop.repository.EmployeeRepository;

@Service
public class EmployeeUpdateService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(employeeCommand, dto);
		employeeRepository.employeeUpdate(dto);
	}
}
