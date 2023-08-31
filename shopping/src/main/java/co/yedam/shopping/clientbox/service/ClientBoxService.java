package co.yedam.shopping.clientbox.service;

import java.util.List;
//장바구니
public interface ClientBoxService {
	
	List<ClientBoxVO> clientBoxSelectList();
	ClientBoxVO clientBoxSelect(ClientBoxVO vo);
	int clientBoxInsert(ClientBoxVO vo);
	int clientBoxDelete(ClientBoxVO vo);
	int clientBoxUpdate(ClientBoxVO vo);
	int boxCountUpdate(ClientBoxVO vo);
	int allDelete(ClientBoxVO vo);
}
