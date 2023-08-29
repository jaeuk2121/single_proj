package co.yedam.shopping.client.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import co.yedam.shopping.productmanager.service.ProductManagerService;
import co.yedam.shopping.productmanager.serviceImpl.ProductManagerServiceImpl;

public class ClientMenu {
	private Scanner scn = new Scanner(System.in);
	ProductManagerService dao = new ProductManagerServiceImpl();
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "jaeuk";
	String password = "1234";
	String strdriver = "oracle.jdbc.driver.OracleDriver";
	String sql;
	int result;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	private void mainTitle() {
		System.out.println(" 고 객 관 리 ");
		System.out.println("1. 모든 고객 조회");
		System.out.println("2. 단일 고객 상세 조회");
		System.out.println("3. 고객 등록");
		System.out.println("4. 고객 등록정보 수정");
		System.out.println("5. 고객 등록 삭제");
		System.out.println("6. 작업 종료");
		System.out.println("-------------------");
		System.out.printf("작업번호 선택>>");
	}
	
	
	
	
	
}
