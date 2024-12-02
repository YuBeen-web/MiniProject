package goodsshop.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goodsshop.domain.MemberDTO;
import goodsshop.domain.StartEndPageDTO;

@Repository
public class MemberRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "MemberMapper";
	String statement;
	
	public int memberInsert(MemberDTO dto) {
		statement = namespace + ".memberInsert";
		return sqlSession.insert(statement, dto);
	}
	
	public List<MemberDTO> memberAllSelect(StartEndPageDTO sepDTO){
		statement = namespace + ".memberAllSelect";
		return sqlSession.selectList(statement, sepDTO);
	}
	
	public int memberCount(String searchWord) {
		statement = namespace + ".memberCount";
		return sqlSession.selectOne(statement, searchWord);
	}
	
	public MemberDTO memberOneSelect(String memberNum) {
		statement = namespace + ".memberOneSelect";
		return sqlSession.selectOne(statement, memberNum);
	}
}
