package goodsshop.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("file")
public class FileDTO {
	String orgFile;
	String storeFile;
}
