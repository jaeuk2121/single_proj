package co.yedam.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.shopping.client.service.ClientService;
import co.yedam.shopping.client.service.ClientVO;
import co.yedam.shopping.client.serviceImpl.ClientServiceImpl;

public class MainMenu {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("방문을 환영합니다");
		System.out.println("1.회원 가입");
		System.out.println("2.고객 로그인");
		System.out.println("3.관리자 로그인");
		System.out.println("4.종료");
		System.out.println("메뉴번호를 선택해주세요");
		int jobCode = scn.nextInt();
		scn.nextLine();

		switch (jobCode) {
		case 1:
			signup();
			break;
		case 2:

		case 3:

		case 4:
		}

//		ProductManagerMenu pmm = new ProductManagerMenu();
//		pmm.run();
	}

	private static void signup() {
		Scanner scn = new Scanner(System.in);
		ClientVO vo = new ClientVO();
		ClientService dao = new ClientServiceImpl();
		List<ClientVO> clients = new ArrayList<ClientVO>();
		clients = dao.clientSelectList();

		System.out.println("아이디를 입력해주세요");
		vo.setClientId(scn.nextLine());
		String id = vo.getClientId();
		for (ClientVO c : clients) {
			if (c.getClientId().equals(id) == true) {
				System.out.println("아이디를 다시 입력해주세요");
				
			}
		}

		System.out.println("비밀번호를 입력해주세요");
		vo.setClientPassword(scn.nextLine());
		System.out.println("본인의 성함을 입력해주세요");
		vo.setClientName(scn.nextLine());
		System.out.println("전화번호를 입력해주세요");
		vo.setClientTel(scn.nextLine());
		System.out.println("집주소를 입력해주세요");
		vo.setClientAddress(scn.nextLine());

		scn.close();

	}
}
