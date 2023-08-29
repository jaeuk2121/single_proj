package co.yedam.shopping.productmanager.service;

import lombok.Data;
//제품관리 		table- product
@Data
public class ProductManagerVO {
	private String productId;
	private String productName;
	private int productPrice;
	private String productModel;
	private int productCount;
	private String productColor;
	private String productSale;
	
	public String toString() {
		System.out.println("제품 모델: " + productModel);
		System.out.println("제품 색상: " + productColor);
		System.out.println("제품 가격: " + productPrice);
		System.out.println("제품 재고: " + productCount);
		return null;
	}
}
