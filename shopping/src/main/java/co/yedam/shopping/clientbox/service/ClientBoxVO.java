package co.yedam.shopping.clientbox.service;

import lombok.Data;

@Data
public class ClientBoxVO {
	private String productModel;
	private int productPrice;
	private int productCount;
	private String productId;
	private String clientId;
	private int productSale;

	public String boxView() {
		System.out.printf(" | 제품코드: " + productId);
		System.out.printf(" | 제품명 : "+productModel);
		System.out.printf(" | 선택한 수량 : "+productCount);
		System.out.println(" | 제품가격: " + (productPrice));
		return null;

	}

}
