package goodsshop.service.employee;

import java.io.File;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		
		/////파일 추가
		// 경로
		URL resource = getClass().getClassLoader().getResource("/static/upload");
		System.out.println("resource : " + resource);
		String filrDir = resource.getFile();
		
		// 이미지
		File mf = employeeCommand.getEmpImage();
		String originalFile = ((MultipartFile) mf).getOriginalFilename();
		String extension = originalFile.substring(originalFile.lastIndexOf("."));
		
		//이름짓기
		String imageName = UUID.randomUUID().toString().replace("-", "");
		String imageFileName = imageName + extension;
		
		//파일 생성
		File file = new File(filrDir + "/" + imageFileName);
		try {
			mf.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setEmpImage(imageFileName);
		
		employeeRepository.employeeInsert(dto);
	}
}
