package co.yedam.shopping.clientbox.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.shopping.clientbox.map.ClientBoxMapper;
import co.yedam.shopping.clientbox.service.ClientBoxService;
import co.yedam.shopping.clientbox.service.ClientBoxVO;
import co.yedam.shopping.common.DataSource;

public class ClientBoxServiceImpl implements ClientBoxService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ClientBoxMapper map = sqlSession.getMapper(ClientBoxMapper.class);

	@Override
	public List<ClientBoxVO> clientBoxSelectList() {
		return map.clientBoxSelectList();
	}

	@Override
	public ClientBoxVO clientBoxSelect(ClientBoxVO vo) {
		return map.clientBoxSelect(vo);
	}

	@Override
	public int clientBoxInsert(ClientBoxVO vo) {
		return map.clientBoxInsert(vo);
	}

	@Override
	public int clientBoxDelete(ClientBoxVO vo) {
		return map.clientBoxDelete(vo);
	}

	@Override
	public int clientBoxUpdate(ClientBoxVO vo) {
		return map.clientBoxUpdate(vo);
	}

}
