package co.yedam.shopping.productmanager.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.shopping.productmanager.service.ProductManagerVO;
import co.yedam.shopping.productmanager.serviceImpl.ProductManagerServiceImpl;
import resources.ProductManagerService;

public class ProductManagerMenu {
	private Scanner scn = new Scanner(System.in);
	ProductManagerService dao = new ProductManagerServiceImpl();

	private void mainTitle() {
		System.out.println(" 상 품 관 리 ");
		System.out.println("1. 모든 상품 조회");
		System.out.println("2. 단일 제품 상세 조회");
		System.out.println("3. 제품 등록");
		System.out.println("4. 제품 등록정보 수정");
		System.out.println("5. 제품 등록 삭제");
		System.out.println("6. 뒤로 가기");
		System.out.println("-------------------");
		System.out.printf("작업번호 선택>>");
	}

	public void run() {
		boolean start = false;
		do {
			mainTitle();
			int jobCode = scn.nextInt();scn.nextLine();
			
			switch(jobCode) {
			case 1:
				productList();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			}
		}while(!start);
		
	}

	private void productList() {
		List<ProductManagerVO> products = new ArrayList<ProductManagerVO>();
		
		products = dao.productSelectList();
		for(ProductManagerVO p : products) {
			p.toString();
		}
	}

}
