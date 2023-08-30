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
	private int productSale;
	
	public String simpleView() {
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("제품 코드: " + productId);
		System.out.println(" | 제품 모델: " + productModel);
		System.out.printf(" | 제품 색상: " + productColor);
		System.out.printf(" | 제품 가격: " + productPrice +"원");
		System.out.printf(" | 제품 재고: " + productCount +"개");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		return null;
	}
	public String detailView() {
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("제품 코드: " + productId);
		System.out.printf(" | 제품 종류: " + productName);
		System.out.println(" | 제품 모델: " + productModel);
		System.out.printf("제품 색상: " + productColor);
		System.out.printf(" | 제품 가격: " + productPrice +"원");
		System.out.printf(" | 제품 재고: " + productCount +"개");
		System.out.printf(" | 제품 할인: " + productSale +"%%");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		return null;
	}
	public String clientView() {
		int value = productPrice*productSale/100;
		System.out.println("-----------------------------------------------------------------");
		if(productSale>0) {
			System.out.println("	할인중인 상품입니다.");
		}
		System.out.printf("제품 코드: " + productId);
		System.out.println(" | 제품 모델: " + productModel);
		System.out.printf(" | 제품 가격: " + (productPrice-value) +"원");
		System.out.printf(" | 제품 재고: " + productCount +"개");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		return null;
	}
	public String clientDetailView() {
		int value = productPrice*productSale/100;
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("제품 코드: " + productId);
		System.out.printf(" | 제품 종류: " + productName);
		System.out.println(" | 제품 모델: " + productModel);
		System.out.printf("제품 색상: " + productColor);
		System.out.printf(" | 기존 가격: " + productPrice +"원");
		System.out.printf(" | 제품 할인: " + productSale +"%%");
		System.out.printf(" | ★할인 가격★: " + (productPrice-value) +"원");
		System.out.printf(" | 제품 재고: " + productCount +"개");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		return null;
	}
}
