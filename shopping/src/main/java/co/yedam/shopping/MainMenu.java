package co.yedam.shopping;

import java.util.Scanner;

import co.yedam.shopping.client.menu.ClientMenu;
import co.yedam.shopping.client.service.ClientService;
import co.yedam.shopping.client.service.ClientVO;
import co.yedam.shopping.client.serviceImpl.ClientServiceImpl;
import co.yedam.shopping.clientbox.menu.ClientBoxMenu;
import co.yedam.shopping.productmanager.menu.ProductManagerMenu;

public class MainMenu {
	Scanner scn = new Scanner(System.in);
	ClientService dao = new ClientServiceImpl();
	ClientMenu cm = new ClientMenu();
	ProductManagerMenu pmm = new ProductManagerMenu();
	ClientBoxMenu cbm = new ClientBoxMenu();
	public void run() {
		boolean b = false;

		do {
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
				clientInsert();
				break;
			case 2:
				clientLogin();
				break;
			case 3:
				managerLogin();
				break;
			case 4:
			}
		} while (!b);
	}

	private void clientLogin() {
		ClientVO vo = new ClientVO();

		System.out.println("고객님의 아이디를 입력해주세요.");
		vo.setClientId(scn.nextLine());
		System.out.println("비밀번호를 입력해주세요.");
		vo.setClientPassword(scn.nextLine());

		vo = dao.clientSelect(vo);

		if (vo != null) {
			System.out.println(vo.getClientName() + "님 환영합니다.");
			
			cbm.run();
		} else {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
		}
	}

	private void managerLogin() {
		ClientVO vo = new ClientVO();
		System.out.println("관리자의 아이디를 입력해주세요.");
		vo.setClientId(scn.nextLine());
		System.out.println("비밀번호를 입력해주세요.");
		vo.setClientPassword(scn.nextLine());
		vo = dao.clientSelect(vo);

		if (vo != null && vo.getAdminCheck() != null) {
			System.out.println("관리자: " + vo.getClientName() + "님 환영합니다.");
			System.out.println("작업번호를 선택하세요");
			System.out.println("1.제품관리");
			System.out.println("2.고객관리");
			System.out.println("3.로그아웃");
			System.out.println("입력");
			int r = scn.nextInt(); 
			scn.nextLine();
			
			switch(r) {
			case 1:
				pmm.run();
				break;
			case 2:
				cm.run();
				break;
			case 3: 
				
				break;
			}

		} else {
			System.out.println("아이디 또는 패스워드가 일치하지 않거나 관리자의 계정이 아닙니다.");
		}
	}

	private void clientInsert() {
		ClientVO vo = new ClientVO();
		System.out.println("아이디를 입력해주세요");
		String id = scn.nextLine();
		vo.setClientId(id);
		vo = dao.clientSelect(vo);
		if (vo != null) {
			System.out.println("아이디가 중복됩니다.");
			return;
		} else {
			ClientVO vo1 = new ClientVO();
			vo1.setClientId(id);
			System.out.println("비밀번호를 입력해주세요");
			String password = scn.nextLine();
			vo1.setClientPassword(password);
			System.out.println("본인의 성함을 입력해주세요");
			vo1.setClientName(scn.nextLine());
			System.out.println("전화번호를 입력해주세요");
			vo1.setClientTel(scn.nextLine());
			System.out.println("집주소를 입력해주세요");
			vo1.setClientAddress(scn.nextLine());

			int n = dao.clientInsert(vo1);
			if (n != 0) {
				System.out.println("회원가입에 성공했습니다.");
			} else {
				System.out.println("회원가입에 실패했습니다.");
			}
		}

	}

}
