package co.yedam.shopping.productmanager.map;

import java.util.List;

import co.yedam.shopping.productmanager.service.ProductManagerVO;

public interface ProductManagerMapper {
	List<ProductManagerVO> productSelectList();
	ProductManagerVO productSelect(ProductManagerVO vo);
	int productInsert(ProductManagerVO vo);
	int productDelete(ProductManagerVO vo);
	int productUpdate(ProductManagerVO vo);
}
