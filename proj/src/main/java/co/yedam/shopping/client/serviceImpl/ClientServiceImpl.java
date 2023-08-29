package co.yedam.shopping.client.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.shopping.client.map.ClientMapper;
import co.yedam.shopping.client.service.ClientService;
import co.yedam.shopping.client.service.ClientVO;
import co.yedam.shopping.common.DataSource;

public class ClientServiceImpl implements ClientService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ClientMapper map = sqlSession.getMapper(ClientMapper.class);

	@Override
	public List<ClientVO> clientSelectList() {
		return map.clientSelectList();
	}

	@Override
	public ClientVO clientSelect(ClientVO vo) {
		return map.clientSelect(vo);
	}

	@Override
	public int clientInsert(ClientVO vo) {
		return map.clientInsert(vo);
	}

	@Override
	public int clientDelete(ClientVO vo) {
		return map.clientDelete(vo);
	}

	@Override
	public int clientUpdate(ClientVO vo) {
		return map.clientUpdate(vo);
	}

}
