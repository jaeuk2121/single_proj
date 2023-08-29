package co.yedam.shopping.productmanager.map;

import java.util.List;

import co.yedam.shopping.productmanager.service.ProductManagerVO;

public interface ProductManagerMapper {
	List<ProductManagerVO> productSelectList();	//일부조회
	ProductManagerVO productSelect(ProductManagerVO vo); //상세조회
	int productInsert(ProductManagerVO vo); //추가
	int productDelete(ProductManagerVO vo); //삭제
	int productUpdate(ProductManagerVO vo); //수정
}
