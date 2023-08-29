package co.yedam.shopping.client.service;

import lombok.Data;
//회원가입, 회원관리		table- Client
@Data
public class ClientVO {
	private String clientId;
	private String clientPassword;
	private String clientName;
	private String clientTel;
	private String clientAddress;
	private String adminCheck;
	
	public String simpleView() {
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("아이디: " + clientId);
		//System.out.println(" | 제품 모델: " + clientPassword);
		System.out.printf("고객 성함: " + clientName);
		System.out.printf("전화 번호: " + clientTel);
		System.out.printf("거주지: " + clientAddress );
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		return null;
	}
		
}
