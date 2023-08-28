package co.yedam.test.product.service;

import lombok.Data;

@Data
public class ProductVO {
	private String productId;
	private String productName;
	private int productPrice;
	private String productModel;
	
	
	public String toString() {
		System.out.printf(productId + " : ");
		System.out.printf(productName + " : ");
		System.out.printf(productPrice + " : ");
		System.out.println(productModel + " : ");
		return null;
	}
}
