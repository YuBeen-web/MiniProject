package goodsshop.service.goods;

import java.io.File;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import goodsshop.command.GoodsCommand;
import goodsshop.domain.AuthInfoDTO;
import goodsshop.domain.GoodsDTO;
import goodsshop.repository.GoodsRepository;
import goodsshop.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsWriteService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	GoodsRepository goodsRepository;
	public void execute(GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		BeanUtils.copyProperties(goodsCommand, dto);
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberRepository.memberNumSelect(auth.getUserId());
		dto.setMemberNum(memberNum);
		
		URL resource = getClass().getClassLoader().getResource("static/upload");
		System.out.println("resource : "+resource);
		String filrDir = resource.getFile();
		
		MultipartFile mf = goodsCommand.getGoodsMainImage();
		String originalFile = mf.getOriginalFilename();
		
		String extension = originalFile.substring(originalFile.lastIndexOf("."));
		
		String storeName = UUID.randomUUID().toString().replace("-", "");
		String storeFileName = storeName + extension;
		
		File file = new File(filrDir + "/" + storeFileName);
		try {
			mf.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dto.setGoodsMainImage(storeFileName);
		dto.setGoodsMainStoreImage(storeFileName);
		
		if(!goodsCommand.getGoodsDetailImage()[0].getOriginalFilename().isEmpty()) {
			String originalTotal = "";
			String storeTotal = "";
			for(MultipartFile mpf : goodsCommand.getGoodsDetailImage()) {
				originalFile = mpf.getOriginalFilename();
				extension = originalFile.substring(originalFile.lastIndexOf("."));
				storeName = UUID.randomUUID().toString().replace("-", "");
				storeFileName = storeName + extension;
				file = new File(filrDir + "/" + storeFileName);
				try {
					mpf.transferTo(file);
				}catch(Exception e) {
					e.printStackTrace();
				}
				originalTotal += originalFile + "/";
				storeTotal += storeFileName + "/";
			}
			dto.setGoodsDetailImage(originalTotal);
			dto.setGoodsDetailStoreImage(storeTotal);
		}
		
		goodsRepository.goodsInsert(dto);
	}
}
