package goodsshop.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import goodsshop.domain.MemberDTO;
import goodsshop.domain.StartEndPageDTO;
import goodsshop.repository.MemberRepository;
import goodsshop.service.StartEndPageService;

@Service
public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(String searchWord, int page, Model model) {
		int limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(searchWord, page, limit);
		List<MemberDTO> list = memberRepository.memberAllSelect(sepDTO);
		
		int count = memberRepository.memberCount(searchWord);
		startEndPageService.execute(page, limit, count, list, searchWord, model);
	}
}
