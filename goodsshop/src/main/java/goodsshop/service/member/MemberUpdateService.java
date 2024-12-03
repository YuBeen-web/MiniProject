package goodsshop.service.member;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goodsshop.command.MemberCommand;
import goodsshop.domain.MemberDTO;
import goodsshop.repository.MemberRepository;

@Service
public class MemberUpdateService {
	@Autowired
	MemberRepository memberRepository;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		BeanUtils.copyProperties(memberCommand, dto);
		memberRepository.memberUpdate(dto);
	}
}
