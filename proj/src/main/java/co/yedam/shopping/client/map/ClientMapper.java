package co.yedam.shopping.client.map;

import java.util.List;

import co.yedam.shopping.client.service.ClientVO;

public interface ClientMapper {
	List<ClientVO> clientSelectList();

	ClientVO clientSelect(ClientVO vo);

	int clientInsert(ClientVO vo);

	int clientDelete(ClientVO vo);

	int clientUpdate(ClientVO vo);
}
