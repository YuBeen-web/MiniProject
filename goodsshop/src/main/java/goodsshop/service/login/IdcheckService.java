package goodsshop.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goodsshop.repository.LoginRepository;

@Service
public class IdcheckService {
	@Autowired
	LoginRepository loginRepository;
	public int execute(String userId) {
		return loginRepository.idcheckSelectOne(userId);
	}
}
