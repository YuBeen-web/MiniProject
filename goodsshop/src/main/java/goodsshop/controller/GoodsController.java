package goodsshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodsshop.command.GoodsCommand;
import goodsshop.service.AutoNumService;
import goodsshop.service.goods.GoodsDetailService;
import goodsshop.service.goods.GoodsListService;
import goodsshop.service.goods.GoodsSellListService;
import goodsshop.service.goods.GoodsWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsSellListService goodsSellListService;
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsDetailService goodsDetailService;
	
	@GetMapping("goodsList")
	public String goodsList(
			@RequestParam(value="page", required = false, defaultValue = "1") int page,
			@RequestParam(value="searchWord", required = false) String searchWord,
			Model model) {
		goodsListService.execute(searchWord, page, model);
		return "thymeleaf/goods/goodsList";
	}
	
	@GetMapping("goodsSellList")
	public String goodsSellList(HttpSession session, Model model) {
		goodsSellListService.execute(session, model);
		return "thymeleaf/goods/goodsSellList";
	}
	
	@GetMapping("goodsWrite")
	public String goodsWrite(Model model) {
		String autoNum = autoNumService.execute("goods_", "goods_num", 7, "goods");
		GoodsCommand goodsCommand = new GoodsCommand();
		goodsCommand.setGoodsNum(autoNum);
		model.addAttribute("goodsCommand", goodsCommand);
		return "thymeleaf/goods/goodsForm";
	}
	
	@PostMapping("goodsWrite")
	public String goodsWrite(GoodsCommand goodsCommand, HttpSession session) {
		goodsWriteService.execute(goodsCommand, session);
		return "thymeleaf/goods/goodsRedirect";
	}
	
	@GetMapping("goodsDetail")
	public String goodsDetail(String goodsNum, Model model, HttpSession session) {
		goodsDetailService.execute(goodsNum, model, session);
		return "thymeleaf/goods/goodsDetail";
	}
	
	@GetMapping("goodsModify")
	public String goodsModify(String goodsNum, Model model, HttpSession session) {
		goodsDetailService.execute(goodsNum, model, session);
		return "thymeleaf/goods/goodsUpdate";
	}
	
}
