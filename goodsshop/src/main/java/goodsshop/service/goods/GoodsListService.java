package goodsshop.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import goodsshop.domain.StartEndPageDTO;
import goodsshop.service.StartEndPageService;

@Service
public class GoodsListService {
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(String searchWord, int page, Model model) {
		int limit = 5;
		StartEndPageDTO sepDTO = startEndPageService.execute(searchWord, page, limit);
		List<GoodsDTO> list = goodsRepository.goodsAllSelect(sepDTO);
	}
}
