package goodsshop.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goodsshop.repository.EmployeeRepository;

@Service
public class EmployeeDeleteService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void execute(String empNum) {
		employeeRepository.employeeDelete(empNum);
	}
}
