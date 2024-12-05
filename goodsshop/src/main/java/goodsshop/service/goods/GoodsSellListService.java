package goodsshop.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import goodsshop.domain.AuthInfoDTO;
import goodsshop.domain.GoodsDTO;
import goodsshop.repository.GoodsRepository;
import goodsshop.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsSellListService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	GoodsRepository goodsRepository;
	
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberRepository.memberNumSelect(auth.getUserId());
		List<GoodsDTO> list = goodsRepository.goodsSellList(memberNum);
		model.addAttribute("list", list);
	}
}
