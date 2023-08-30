package co.yedam.shopping.clientbox.service;

import lombok.Data;

@Data
public class ClientBoxVO {
	private String productModel;
	private int productPrice;
	private int productCount;
	private String productId;
	private String clientId;

	public String boxView() {
		System.out.println("제품코드: " + productId);
		System.out.println("제품명: "+productModel);
		System.out.println("제품가격: " + productPrice);
		return null;

	}

}
