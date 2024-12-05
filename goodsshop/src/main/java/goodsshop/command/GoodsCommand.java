package goodsshop.command;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GoodsCommand {
	String goodsNum;
	String goodsName;
	Integer goodsPrice;
	String goodsContents;
	String memberNum;
	Date goodsRegist;
	
	MultipartFile goodsMainImage;
	MultipartFile goodsDetailImage[];
}
