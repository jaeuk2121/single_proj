package co.yedam.shopping.productmanager.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.shopping.productmanager.service.ProductManagerService;
import co.yedam.shopping.productmanager.service.ProductManagerVO;
import co.yedam.shopping.productmanager.serviceImpl.ProductManagerServiceImpl;

public class ProductManagerMenu {
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
		System.out.println(" 상 품 관 리 ");
		System.out.println("1. 모든 상품 조회");
		System.out.println("2. 단일 제품 상세 조회");
		System.out.println("3. 제품 등록");
		System.out.println("4. 제품 등록정보 수정");
		System.out.println("5. 제품 등록 삭제");
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
				System.out.printf("조회할 제품코드 입력>>");
				String id = scn.nextLine();
				productSelect(id);
				break;
			case 3:
				productInsert();
				break;
			case 4:
				productUpdate();
				break;
			case 5:
				productDelete();
				break;
			case 6:
				start = true;
				System.out.println("작업이 종료됩니다");
				break;
			}
		} while (!start);

	}

	private void productDelete() {
		ProductManagerVO vo = new ProductManagerVO();
		System.out.println("삭제할 코드 입력");
		vo.setProductId(scn.nextLine());
		String id = vo.getProductId();

		try {
			try {
				Class.forName(strdriver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url, user, password);
			sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("변경성공");
			} else {
				System.out.println("변경실패");
			}
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
		}

	}

	private void productInsert() {
		ProductManagerVO vo = new ProductManagerVO();
		System.out.printf("제품 코드 입력>>");
		vo.setProductId(scn.nextLine());
		System.out.printf("제품 종류 입력>>");
		vo.setProductName(scn.nextLine());
		System.out.printf("제품 모델명 입력>>");
		vo.setProductModel(scn.nextLine());
		System.out.printf("제품 색상 입력>>");
		vo.setProductColor(scn.nextLine());
		System.out.printf("제품 가격 입력>>");
		vo.setProductPrice(scn.nextInt());
		scn.nextLine();
		System.out.printf("제품 재고 입력>>");
		vo.setProductCount(scn.nextInt());
		scn.nextLine();
		System.out.printf("제품 할인율 입력>>");
		vo.setProductSale(scn.nextInt());
		scn.nextLine();

		int n = dao.productInsert(vo);
		if (n != 0) {
			System.out.println("==제품 등록에 성공했습니다.");
		} else {
			System.out.println("==제품 등록에 실패했습니다.");
		}

	}

	private void productUpdate() {
		boolean b = true;
		ProductManagerVO vo = new ProductManagerVO();
		System.out.printf("수정할 제품의 코드 입력>>");
		vo.setProductId(scn.nextLine());
		vo = dao.productSelect(vo);

		while (b) {

			updateTitle();
			int key = scn.nextInt();
			scn.nextLine();

			switch (key) {
			case 1:
				int shopProduct = vo.getProductCount();
				System.out.println("현재 수량: " + shopProduct);
				System.out.println("제거할 제품의 수량을 입력");
				int addProduct = scn.nextInt();
				scn.nextLine();
				int add = shopProduct + addProduct;
				vo.setProductCount(add);

				try {
					try {
						Class.forName(strdriver);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					conn = DriverManager.getConnection(url, user, password);
					sql = "UPDATE PRODUCT SET PRODUCT_COUNT= ?" + " WHERE Product_Id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, add);
					pstmt.setString(2, vo.getProductId());
					result = pstmt.executeUpdate();
					if (result == 1) {
						System.out.println("변경성공");
					} else {
						System.out.println("변경실패");
					}
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
				}

				System.out.println("추가완료");
				break;
			case 2:

				shopProduct = vo.getProductCount();
				System.out.println("현재 수량: " + shopProduct);
				System.out.println("제거할 제품의 수량을 입력");
				int removeProduct = scn.nextInt();
				scn.nextLine();
				int remove = shopProduct - removeProduct;
				vo.setProductCount(remove);
				if (shopProduct < removeProduct) {
					System.out.println("제거할 수량을 다시 확인해주세요.");
				} else {

					try {
						try {
							Class.forName(strdriver);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						conn = DriverManager.getConnection(url, user, password);
						sql = "UPDATE PRODUCT SET PRODUCT_COUNT= ?" + " WHERE Product_Id = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, remove);
						pstmt.setString(2, vo.getProductId());
						result = pstmt.executeUpdate();
						if (result == 1) {
							System.out.println("변경성공");
						} else {
							System.out.println("변경실패");
						}
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
					}
				}
				break;

			case 3:
				System.out.println("현재 할인율: " + vo.getProductSale() + "%");
				System.out.println("적용할 할인율 입력");

				vo.setProductSale(scn.nextInt());
				scn.nextLine();
				int sale = vo.getProductSale();

				try {
					try {
						Class.forName(strdriver);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					conn = DriverManager.getConnection(url, user, password);
					sql = "UPDATE PRODUCT SET PRODUCT_SALE= ?" + " WHERE Product_Id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, sale);
					pstmt.setString(2, vo.getProductId());
					result = pstmt.executeUpdate();
					if (result == 1) {
						System.out.println("변경성공");
					} else {
						System.out.println("변경실패");
					}
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

				}
				break;
			case 4:
				System.out.println("현재 제품명: " + vo.getProductName());
				System.out.println("변경할 제품종류 입력");
				vo.setProductName(scn.nextLine());
				String name = vo.getProductName();
				try {
					try {
						Class.forName(strdriver);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					conn = DriverManager.getConnection(url, user, password);
					sql = "UPDATE PRODUCT SET PRODUCT_NAME= ?" + " WHERE Product_Id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, vo.getProductId());
					result = pstmt.executeUpdate();
					if (result == 1) {
						System.out.println("변경성공");
					} else {
						System.out.println("변경실패");
					}
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

				}
				break;
			case 5:
				System.out.println("현재 모델명: " + vo.getProductModel());
				System.out.println("변경할 모델명 입력");
				vo.setProductModel(scn.nextLine());
				String model = vo.getProductModel();
				try {
					try {
						Class.forName(strdriver);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					conn = DriverManager.getConnection(url, user, password);
					sql = "UPDATE PRODUCT SET PRODUCT_MODEL= ?" + " WHERE Product_Id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, model);
					pstmt.setString(2, vo.getProductId());
					result = pstmt.executeUpdate();
					if (result == 1) {
						System.out.println("변경성공");
					} else {
						System.out.println("변경실패");
					}
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

				}
				break;
			case 6:
				System.out.println("현재 색상: " + vo.getProductColor());
				System.out.println("변경할 색상 입력");
				vo.setProductColor(scn.nextLine());
				String color = vo.getProductColor();
				try {
					try {
						Class.forName(strdriver);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					conn = DriverManager.getConnection(url, user, password);
					sql = "UPDATE PRODUCT SET PRODUCT_COLOR= ?" + " WHERE Product_ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, color);
					pstmt.setString(2, vo.getProductId());
					result = pstmt.executeUpdate();
					if (result == 1) {
						System.out.println("변경성공");
					} else {
						System.out.println("변경실패");
					}
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

				}
				break;
			case 7:
				System.out.println("현재 가격: " + vo.getProductPrice());
				System.out.println("변경할 가격 입력");
				vo.setProductPrice(scn.nextInt());
				scn.nextLine();
				int price = vo.getProductPrice();
				try {
					try {
						Class.forName(strdriver);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					conn = DriverManager.getConnection(url, user, password);
					sql = "UPDATE PRODUCT SET PRODUCT_PRICE= ?" + " WHERE Product_Id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, price);
					pstmt.setString(2, vo.getProductId());
					result = pstmt.executeUpdate();
					if (result == 1) {
						System.out.println("변경성공");
					} else {
						System.out.println("변경실패");
					}
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

				}
				break;
			case 8:
				System.out.println("입력을 종료합니다.");
				b = false;
			}

		}

	}

	private void updateTitle() {
		System.out.println("1. 제품수량추가");
		System.out.println("2. 제품수량제거");
		System.out.println("3. 제품할인율");
		System.out.println("4. 제품명");
		System.out.println("5. 제품모델");
		System.out.println("6. 제품색깔");
		System.out.println("7. 제품가격");
		System.out.println("8. 입력종료");

		System.out.println("---------------------");
		System.out.printf("입력>>");
		System.out.println();

	}

	private void productSelect(String id) {
		// 세부정보
		ProductManagerVO vo = new ProductManagerVO();
		vo.setProductId(id);
		vo = dao.productSelect(vo);
		if (vo != null) {
			vo.detailView();
		} else {
			System.out.println("제품이 존재하지 않습니다.");
		}
	}

	private void productList() {
		// 제품전체목록
		List<ProductManagerVO> products = new ArrayList<ProductManagerVO>();

		products = dao.productSelectList();
		for (ProductManagerVO p : products) {
			p.simpleView();
		}
	}

}
