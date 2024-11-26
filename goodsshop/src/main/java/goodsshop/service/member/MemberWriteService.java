package goodsshop.service.member;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import goodsshop.command.UserCommand;
import goodsshop.domain.MemberDTO;
import goodsshop.repository.MemberRepository;

@Service
public class MemberWriteService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(UserCommand userCommand) {
		MemberDTO dto = new MemberDTO();
		BeanUtils.copyProperties(userCommand, dto);
		
		String encodePw = passwordEncoder.encode(userCommand.getMemberPw());
		dto.setMemberPw(encodePw);
		
		dto.setMemberPost(userCommand.getMemberPost());
		
		memberRepository.memberInsert(dto);
	}
}
