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
	
}
