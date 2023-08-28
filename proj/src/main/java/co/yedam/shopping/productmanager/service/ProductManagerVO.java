package co.yedam.shopping.productmanager.service;

import lombok.Data;
//제품관리 		table- product
@Data
public class ProductManagerVO {
	private String productId;
	private String productName;
	private int productPrice;
	private String productModel;
	
	public String toString() {
		System.out.println("제품 모델: " + productModel);
		System.out.println("제품 가격: " + productPrice);
		return null;
	}
}
