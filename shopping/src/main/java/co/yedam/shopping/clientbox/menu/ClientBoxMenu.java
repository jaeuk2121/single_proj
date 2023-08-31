package co.yedam.shopping.clientbox.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.shopping.clientbox.service.ClientBoxService;
import co.yedam.shopping.clientbox.service.ClientBoxVO;
import co.yedam.shopping.clientbox.serviceImpl.ClientBoxServiceImpl;
import co.yedam.shopping.productmanager.service.ProductManagerService;
import co.yedam.shopping.productmanager.service.ProductManagerVO;
import co.yedam.shopping.productmanager.serviceImpl.ProductManagerServiceImpl;

public class ClientBoxMenu {
	private Scanner scn = new Scanner(System.in);
	ClientBoxService dao = new ClientBoxServiceImpl();
	ProductManagerService pdDao = new ProductManagerServiceImpl();
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "jaeuk";
	String password = "1234";
	String strdriver = "oracle.jdbc.driver.OracleDriver";
	String sql;
	int result;

	Connection conn = null;
	PreparedStatement pstmt = null;

	private void mainTitle() {
		System.out.println(" 구매 페이지");
		System.out.println("1. 모든 상품 조회");
		System.out.println("2. 장바구니 조회");
		System.out.println("3. 장바구니 상품추가");
		System.out.println("4. 장바구니 수정");
		System.out.println("5. 장바구니 삭제");
		System.out.println("6. 작업 종료");
		System.out.println("-------------------");
		System.out.printf("작업번호 선택>>");
	}

	public void run() {
		allDelete();
		boolean start = false;
		do {

			mainTitle();
			int jobCode = scn.nextInt();
			scn.nextLine();
			switch (jobCode) {
			case 1:
				productList();
				break;
			case 2:
				clientBoxList();
				break;
			case 3:
				clientBoxInsert();

				break;
			case 4:
				boxCountUpdate();
				break;
			case 5:
				clientBoxDelete();
				break;
			case 6:
				start = true;
				System.out.println("작업이 종료됩니다");
				break;
			}
		} while (!start);

	}

	private void allDelete() {
		ClientBoxVO vo = new ClientBoxVO();
		dao.allDelete(vo);
	}

	private void clientBoxDelete() {
		ClientBoxVO vo = new ClientBoxVO();
		System.out.println("삭제할 제품코드를 입력하세요");
		vo.setProductId(scn.nextLine());
		dao.clientBoxDelete(vo);

	}

	private void boxCountUpdate() {
		ClientBoxVO vo = new ClientBoxVO();
		dao = new ClientBoxServiceImpl();
		System.out.println("수량을 수정하실 상품코드를 입력하세요");
		vo.setProductId(scn.nextLine());
		System.out.println("주문할 수량을 입력하세요");
		vo.setProductCount(scn.nextInt());
		scn.nextLine();
		dao.boxCountUpdate(vo);

	}

	private void clientBoxInsert() {
		ClientBoxVO vo = new ClientBoxVO();

		System.out.println("장바구니에 넣을 상품코드를 입력하세요");
		vo.setProductId(scn.nextLine());
		String id = vo.getProductId();
		System.out.println("상품 수량을 지정해주세요. ");
		vo.setProductCount(scn.nextInt());
		scn.nextLine();
		int add = vo.getProductCount();

		dao.clientBoxInsert(vo);

		try {
			try {
				Class.forName(strdriver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url, user, password);
			sql = "UPDATE CLIENTBOX SET PRODUCT_COUNT= ?" + " WHERE Product_Id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, add);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			if (conn != null)
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}

			System.out.println("등록 성공");
		}
	}

	private void clientBoxList() {

		List<ClientBoxVO> boxs = new ArrayList<ClientBoxVO>();

		boxs = dao.clientBoxSelectList();

		for (ClientBoxVO c : boxs) {
			c.boxView();
		}
	}

	private void productList() {
		List<ProductManagerVO> products = new ArrayList<ProductManagerVO>();
		products = pdDao.productSelectList();
		for (ProductManagerVO p : products) {
			p.clientView();
		}
	}
}
