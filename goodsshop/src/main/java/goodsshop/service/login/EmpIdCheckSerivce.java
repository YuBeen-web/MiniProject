package goodsshop.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goodsshop.repository.LoginRepository;

@Service
public class EmpIdCheckSerivce {
	@Autowired
	LoginRepository loginRepository;
	public Integer execute(String userId) {
		return loginRepository.empIdCheckSelectOne(userId);
	}
}
