package co.yedam.shopping.productmanager.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.shopping.common.DataSource;
import co.yedam.shopping.productmanager.map.ProductManagerMapper;
import co.yedam.shopping.productmanager.service.ProductManagerService;
import co.yedam.shopping.productmanager.service.ProductManagerVO;

public class ProductManagerServiceImpl implements ProductManagerService {
	
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ProductManagerMapper map = sqlSession.getMapper(ProductManagerMapper.class);

	@Override
	public List<ProductManagerVO> productSelectList() {
		return map.productSelectList();
	}

	@Override
	public ProductManagerVO productSelect(ProductManagerVO vo) {
		return map.productSelect(vo);
	}

	@Override
	public int productInsert(ProductManagerVO vo) {
		return map.productInsert(vo);
	}

	@Override
	public int productDelete(ProductManagerVO vo) {
		return map.productDelete(vo);
	}

	@Override
	public int productUpdate(ProductManagerVO vo) {
		return map.productUpdate(vo);
	}

}
