package goodsshop.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeCommand {
	String empNum;
	
	@NotEmpty(message="아이디를 입력해주세요.")
	String empId;
	
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
			message = "영문자와 숫자 그리고 특수문자가 포함되는 8글자 이상")
	String empPw;
	
	@NotBlank(message="비밀번호 확인을 입력해주세요.")
	String empPwCon;
	
	@NotBlank(message="이름을 입력해주세요.")
	String empName;
	
	@NotBlank(message="주소를 입력해주세요.")
	String empAddr;
	String empAddrDetail;
	String empPost;
	
	@NotBlank(message="연락처를 입력해주세요.")
	String empPhone;
	
	@NotBlank(message="주민번호를 입력해주세요.")
	String empJumin;
	
	String empEmail;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date empHireDate;
	
	MultipartFile empImage;
	
	public boolean isEmpPwEqualEmpPwCon() {
		return empPw.equals(empPwCon);
	}
}
