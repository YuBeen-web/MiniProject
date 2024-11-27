package goodsshop.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goodsshop.domain.EmployeeDTO;

@Repository
public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "EmployeeMapper";
	String statement;
	
	public List<EmployeeDTO> employeeAllSelect() {
		statement = namespace + ".employeeAllSelect";
		return sqlSession.selectList(statement);
	}
	
	public Integer employeeInsert(EmployeeDTO dto) {
		statement = namespace + ".employeeInsert";
		return sqlSession.insert(statement, dto);
	}
	
	public EmployeeDTO employeeOneSelect(String empNum) {
		statement = namespace + ".employeeOneSelect";
		return sqlSession.selectOne(statement, empNum);
	}
}
