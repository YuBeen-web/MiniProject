package goodsshop.service.mypage;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import goodsshop.command.MemberCommand;
import goodsshop.domain.AuthInfoDTO;
import goodsshop.domain.MemberDTO;
import goodsshop.repository.MemberInfoRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberMyUpdateService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberInfoRepository memberInfoRepository;
	public void execute(MemberCommand memberCommand, HttpSession session) {
		MemberDTO dto = new MemberDTO();
		BeanUtils.copyProperties(memberCommand, dto);
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String currentPw = auth.getUserPw();
		
		System.out.println(memberCommand.getMemberPw());
		System.out.println(currentPw);
		System.out.println(passwordEncoder.matches(memberCommand.getMemberPw(), currentPw));
		
		if(memberCommand.getMemberPw().equals(currentPw)) {
			memberInfoRepository.memberUpdate(dto);
		}
	}
}
