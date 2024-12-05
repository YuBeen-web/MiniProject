package goodsshop.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import goodsshop.domain.GoodsDTO;
import goodsshop.domain.StartEndPageDTO;
import goodsshop.repository.GoodsRepository;
import goodsshop.service.StartEndPageService;

@Service
public class GoodsListService {
	@Autowired
	StartEndPageService startEndPageService;
	@Autowired
	GoodsRepository goodsRepository;
	public void execute(String searchWord, int page, Model model) {
		int limit = 5;
		StartEndPageDTO sepDTO = startEndPageService.execute(searchWord, page, limit);
		List<GoodsDTO> list = goodsRepository.goodsAllSelect(sepDTO);
		
		int count = goodsRepository.goodsCount(searchWord);
		startEndPageService.execute(page, limit, count, list, searchWord, model);
	}
}
