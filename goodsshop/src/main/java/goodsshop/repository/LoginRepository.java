package goodsshop.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "LoginMapper";
	String statement;
	
	public int idcheckSelectOne(String userId) {
		statement = namespace + ".idcheckSelectOne";
		return sqlSession.selectOne(statement, userId);
		
	}
}
