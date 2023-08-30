package co.yedam.shopping.client.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.shopping.client.service.ClientService;
import co.yedam.shopping.client.service.ClientVO;
import co.yedam.shopping.client.serviceImpl.ClientServiceImpl;

public class ClientMenu {
	private Scanner scn = new Scanner(System.in);
	ClientService dao = new ClientServiceImpl();

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

	public void run() {
		boolean start = false;
		do {
			mainTitle();
			int jobCode = scn.nextInt();
			scn.nextLine();

			switch (jobCode) {
			case 1:
				clientList();
				break;
			case 2:
				System.out.printf("조회할 고객아이디 입력>>");
				String id = scn.nextLine();
				clientSelect(id);
				break;
			case 3:
				clientInsert();
				break;
			case 4:
				clientUpdate();
				break;
			case 5:
				clientDelete();
				break;
			case 6:
				start = true;
				System.out.println("작업이 종료됩니다");
				break;
			}
		} while (!start);

	}

	private void clientDelete() {
		ClientVO vo = new ClientVO();
		System.out.println("삭제할 고객 아이디를 입력하세요");
		String id = scn.nextLine();
		vo.setClientId(id);
		int n = dao.clientDelete(vo);
		if (n != 0) {
			System.out.println("삭제완료");
		}

	}

	private void clientUpdate() {
		ClientVO vo = new ClientVO();
		System.out.println("수정할 고객의 아이디를 입력");
		vo.setClientId(scn.nextLine());
		subtitle();
		int key = scn.nextInt();
		scn.nextLine();
		switch (key) {

		case 1:
			System.out.println("변경하실 패스워드를 입력하세요");
			vo.setClientPassword(scn.nextLine());
			break;
		case 2:
			System.out.println("변경하실 이름을 입력하세요");
			vo.setClientName(scn.nextLine());
			break;
		case 3:
			System.out.println("변경하실 전화번호를 입력하세요");
			vo.setClientTel(scn.nextLine());
			break;
		case 4:
			System.out.println("변경하실 주소를 입력하세요");
			vo.setClientAddress(scn.nextLine());
			break;

		}
		int n = dao.clientUpdate(vo);
		if (n != 0) {
			System.out.println("고객 정보 변경이 성공했습니다.");

		} else {
			System.out.println("고객 정보 변경이 실패했습니다.");

		}
	}

	private void subtitle() {
		System.out.println("수정할 항목번호를 선택하세요");
		System.out.println("---------------------");
		System.out.println("1. 비밀번호");
		System.out.println("2. 이름");
		System.out.println("3. 전화번호");
		System.out.println("4. 주소");
		System.out.println("5. 종료");
		System.out.println("---------------------");
		System.out.println("입력>>");

	}

	private void clientInsert() {
		ClientVO vo = new ClientVO();
		System.out.println("==고객 아이디를 입력하세요.");
		vo.setClientId(scn.nextLine());
		System.out.println("==고객 비밀번호를 입력하세요. ");
		vo.setClientPassword(scn.nextLine());
		System.out.println("고객이름을 입력하세요");
		vo.setClientName(scn.nextLine());
		System.out.println("고객 전화번호를 입력하세요.");
		vo.setClientTel(scn.nextLine());
		System.out.println("고객 주소를 입력하세요.");
		vo.setClientAddress(scn.nextLine());
		vo.setAdminCheck(null);

		int n = dao.clientInsert(vo);
		if (n != 0) {
			System.out.println("고객정보를 등록하였습니다.");
		} else {
			System.out.println("고객정보 등록에 실패하였습니다.");
		}
	}

	private void clientSelect(String id) {
		ClientVO vo = new ClientVO();
		vo.setClientId(id);
		vo = dao.clientSelect(vo);
		if (vo != null) {
			vo.simpleView();
		}
	}

	private void clientList() {
		List<ClientVO> clients = new ArrayList<ClientVO>();

		clients = dao.clientSelectList();
		for (ClientVO c : clients) {
			c.simpleView();
		}

	}

}
