package goodsshop.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goodsshop.repository.MemberRepository;

@Service
public class MemberDeleteService {
	@Autowired
	MemberRepository memberRepository;
	public void execute(String memberNum) {
		memberRepository.memberDelete(memberNum);
	}
}
