package co.yedam.shopping.clientbox.menu;

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

				break;
			case 5:

				break;
			case 6:
				start = true;
				System.out.println("작업이 종료됩니다");
				break;
			}
		} while (!start);

	}

	private void clientBoxInsert() {
		ClientBoxVO vo = new ClientBoxVO();
		

		System.out.println("장바구니에 넣을 상품코드를 입력하세요");
		vo.setProductId(scn.nextLine());
		System.out.println("주문할 수량을 입력하세요");
		vo.setProductCount(scn.nextInt());
		scn.nextLine();

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
