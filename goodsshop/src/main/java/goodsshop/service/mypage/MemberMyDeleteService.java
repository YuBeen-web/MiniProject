package goodsshop.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goodsshop.domain.AuthInfoDTO;
import goodsshop.repository.MemberInfoRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberMyDeleteService {
	@Autowired
	MemberInfoRepository memberInfoRepository;
	public void execute(HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberId = auth.getUserId();
		
		memberInfoRepository.memberDelete(memberId);
	}
}
