package goodsshop.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goodsshop.repository.AutoNumRepository;

@Service
public class AutoNumService {
	@Autowired
	AutoNumRepository autoNumRepository;
	public String execute(String sep, String columnName, Integer len, String tableName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sep", sep);
		map.put("columnName", columnName);
		map.put("len", len);
		map.put("tableName", tableName);
		
		String autoNum = autoNumRepository.AutoNumSelect(map);
		return autoNum;
	}
}
