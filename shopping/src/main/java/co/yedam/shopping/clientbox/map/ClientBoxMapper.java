package co.yedam.shopping.clientbox.map;

import java.util.List;

import co.yedam.shopping.clientbox.service.ClientBoxVO;

public interface ClientBoxMapper {
	

	List<ClientBoxVO> clientBoxSelectList();
	ClientBoxVO clientBoxSelect(ClientBoxVO vo);
	int clientBoxInsert(ClientBoxVO vo);
	int clientBoxDelete(ClientBoxVO vo);
	int clientBoxUpdate(ClientBoxVO vo);

	
}
