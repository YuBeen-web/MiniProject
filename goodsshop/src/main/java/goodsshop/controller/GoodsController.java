package goodsshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodsshop.service.goods.GoodsListService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsListService goodsListService;
	
	@GetMapping("goodsList")
	public String goodsList(
			@RequestParam(value="page", required = false, defaultValue = "1") int page,
			@RequestParam(value="searchWord", required = false) String searchWord,
			Model model) {
		goodsListService.execute(searchWord, page, model);
		return "thymeleaf/goods/goodsList";
	}
}
