package co.yedam.shopping.client.service;

import lombok.Data;
//회원가입, 회원관리		table- Client
@Data
public class ClientVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberTel;
	private String memberAddress;
	
}
