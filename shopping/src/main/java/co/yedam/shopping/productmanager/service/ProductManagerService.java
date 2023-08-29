package co.yedam.shopping.productmanager.service;

import java.util.List;
//관리자
public interface ProductManagerService {
	List<ProductManagerVO> productSelectList();
	ProductManagerVO productSelect(ProductManagerVO vo);
	int productInsert(ProductManagerVO vo);
	int productDelete(ProductManagerVO vo);
	int productUpdate(ProductManagerVO vo);
	
}
