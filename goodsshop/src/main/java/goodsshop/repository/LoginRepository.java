package goodsshop.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goodsshop.domain.AuthInfoDTO;

@Repository
public class LoginRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "LoginMapper";
	String statement;
	
	public Integer idcheckSelectOne(String userId) {
		statement = namespace + ".idcheckSelectOne";
		return sqlSession.selectOne(statement, userId);
	}
	
	public AuthInfoDTO loginSelectOne(String userId) {
		statement = namespace + ".loginSelectOne";
		return sqlSession.selectOne(statement, userId);
	}
}
