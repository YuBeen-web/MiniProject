package goodsshop.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goodsshop.repository.LoginRepository;

@Service
public class IdcheckService {
	@Autowired
	LoginRepository loginRepository;
	public Integer execute(String userId) {
		int result = loginRepository.idcheckSelectOne(userId);
		return result;
	}
}
