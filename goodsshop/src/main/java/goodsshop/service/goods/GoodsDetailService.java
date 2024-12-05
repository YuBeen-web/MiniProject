package goodsshop.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import goodsshop.domain.AuthInfoDTO;
import goodsshop.domain.GoodsDTO;
import goodsshop.repository.GoodsRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsDetailService {
	@Autowired
	GoodsRepository goodsRepository;
	public void execute(String goodsNum, Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		session.setAttribute("auth", auth);
		
		GoodsDTO dto = goodsRepository.goodsOneSelect(goodsNum);
		model.addAttribute("goodsCommand", dto);
		
		model.addAttribute("newLine", "\n");
	}
}
