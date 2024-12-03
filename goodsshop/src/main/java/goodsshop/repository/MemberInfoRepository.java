package goodsshop.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goodsshop.domain.MemberDTO;

@Repository
public class MemberInfoRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "MemberInfoMapper";
	String statement;
	
	public MemberDTO memberSelectOne(String memberId) {
		statement = namespace + ".memberSelectOne";
		return sqlSession.selectOne(statement, memberId);
	}
	
	public int memberUpdate(MemberDTO dto) {
		statement = namespace + ".memberUpdate";
		return sqlSession.update(statement, dto);
	}
	
	public int memberDelete(String memberId) {
		statement = namespace + ".memberDelete";
		return sqlSession.delete(statement, memberId);
	}
}
