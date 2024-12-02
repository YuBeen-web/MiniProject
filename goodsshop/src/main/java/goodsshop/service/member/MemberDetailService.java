package goodsshop.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import goodsshop.domain.MemberDTO;
import goodsshop.repository.MemberRepository;

@Service
public class MemberDetailService {
	@Autowired
	MemberRepository memberRepository;
	
	public void execute(String memberNum, Model model) {
		MemberDTO dto = memberRepository.memberOneSelect(memberNum);
		model.addAttribute("memberCommand", dto);
	}
}
