package co.yedam.shopping.client.service;

import java.util.List;

public interface ClientService {
	List<ClientVO> clientSelectList();
	ClientVO clientSelect(ClientVO vo);
	int clientInsert(ClientVO vo);
	int clientDelete(ClientVO vo);
	int clientUpdate(ClientVO vo);
	
}
