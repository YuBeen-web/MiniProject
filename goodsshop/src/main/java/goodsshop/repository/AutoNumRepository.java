package goodsshop.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AutoNumRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "AutoNumMapper";
	String statement;
	
	public String AutoNumSelect(Map<String, Object> map) {
		statement = namespace + ".AutoNumSelect";
		return sqlSession.selectOne(statement, map);
	}
}
