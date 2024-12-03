package goodsshop.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import goodsshop.domain.AuthInfoDTO;
import goodsshop.domain.MemberDTO;
import goodsshop.repository.MemberInfoRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberMyInfoService {
	@Autowired
	MemberInfoRepository memberInfoRepository;
	
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberId = auth.getUserId();
		MemberDTO dto = memberInfoRepository.memberSelectOne(memberId);
		model.addAttribute("dto", dto);
	}
}
