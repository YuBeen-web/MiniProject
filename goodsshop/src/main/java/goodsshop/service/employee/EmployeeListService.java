package goodsshop.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import goodsshop.domain.EmployeeDTO;
import goodsshop.domain.StartEndPageDTO;
import goodsshop.repository.EmployeeRepository;
import goodsshop.service.StartEndPageService;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(String searchWord, int page, Model model) {
		int limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(searchWord, page, limit);
		List<EmployeeDTO> list = employeeRepository.employeeAllSelect(sepDTO);
		
		int count = employeeRepository.employeeCount(searchWord);
		startEndPageService.execute(page, limit, count, list, searchWord, model);
	}
}
