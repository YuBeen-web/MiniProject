package goodsshop.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goodsshop.domain.EmployeeDTO;
import goodsshop.domain.StartEndPageDTO;

@Repository
public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "EmployeeMapper";
	String statement;
	
	public List<EmployeeDTO> employeeAllSelect(StartEndPageDTO sepDTO) {
		statement = namespace + ".employeeAllSelect";
		return sqlSession.selectList(statement, sepDTO);
	}
	
	public Integer employeeInsert(EmployeeDTO dto) {
		statement = namespace + ".employeeInsert";
		return sqlSession.insert(statement, dto);
	}
	
	public EmployeeDTO employeeOneSelect(String empNum) {
		statement = namespace + ".employeeOneSelect";
		return sqlSession.selectOne(statement, empNum);
	}
	
	public Integer employeeUpdate(EmployeeDTO dto) {
		statement = namespace + ".employeeUpdate";
		return sqlSession.update(statement, dto);
	}
	
	public Integer employeeDelete(String empNum) {
		statement = namespace + ".employeeDelete";
		return sqlSession.delete(statement, empNum);
	}
	
	public Integer employeeCount(String searchWord) {
		statement = namespace + ".employeeCount";
		return sqlSession.selectOne(statement, searchWord);
	}
	
	public String getEmpNum(String empId) {
		statement = namespace + ".getEmpNum";
		return sqlSession.selectOne(statement, empId);
	}
}
