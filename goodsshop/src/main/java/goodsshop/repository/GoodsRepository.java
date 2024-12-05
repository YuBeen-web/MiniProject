package goodsshop.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goodsshop.domain.GoodsDTO;
import goodsshop.domain.StartEndPageDTO;

@Repository
public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "GoodsMapper";
	String statement;
	
	public List<GoodsDTO> goodsAllSelect(StartEndPageDTO sepDTO){
		statement = namespace + ".goodsAllSelect";
		return sqlSession.selectList(statement, sepDTO);
	}
	
	public int goodsCount(String searchWord) {
		statement = namespace + ".goodsCount";
		return sqlSession.selectOne(statement, searchWord);
	}
	
	public List<GoodsDTO> goodsSellList(String memberNum){
		statement = namespace + ".goodsSellList";
		return sqlSession.selectList(statement, memberNum);
	}
	
	public int goodsInsert(GoodsDTO dto) {
		statement = namespace + ".goodsInsert";
		return sqlSession.insert(statement, dto);
	}
	
	public GoodsDTO goodsOneSelect(String goodsNum) {
		statement = namespace + ".goodsOneSelect";
		return sqlSession.selectOne(statement, goodsNum);
	}
}
