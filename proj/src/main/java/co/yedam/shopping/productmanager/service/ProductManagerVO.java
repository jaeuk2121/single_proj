package co.yedam.shopping.productmanager.service;

import lombok.Data;

@Data
public class ProductManagerVO {
	private String productId;
	private String productName;
	private int productPrice;
	private String productModel;
	
	public String allSelect() {
		System.out.println("제품 모델: " + productModel);
		System.out.println("제품 가격: " + productPrice);
		return null;
	}
}
