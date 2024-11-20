package MauDe2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		ProjectorDAO dao = new ProjectorDAO();
		ProjectorManager manager = new ProjectorManager();
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n--- Projector Management Menu ---");
			System.out.println("1. Thêm máy chiếu");
			System.out.println("2. Chỉnh sửa máy chiếu");
			System.out.println("3. Xoá thông tin máy chiếu");
			System.out.println("4. Tìm kiếm máy chiếu theo tên");
			System.out.println("5. Tìm máy chiếu theo giá ");
			System.out.println("6. Hiển thị thông tin máy chiếu");
			System.out.println("7. Lưu và thoát");
			System.out.print("Nhập lựa chọn: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1: {
				System.out.print("Nhập ID: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Nhập tên sản phẩm: ");
				String name = scanner.nextLine();
				System.out.print("Nhập giá sản phẩm: ");
				double price = scanner.nextDouble();
				System.out.print("Nhập tổng số lượng sản phẩm: ");
				int total = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Nhập thương hiệu: ");
				String brand = scanner.nextLine();
				System.out.print("Nhập năm sản xuất: ");
				int year = scanner.nextInt();

				Projector projector = new Projector(id, name, price, total, brand, year);
				if (manager.addProjector(projector)) {	
					dao.writeFile(manager.getProjectors());
					System.out.println("Thêm thành công.");
				} else {
					System.out.println("Không thể thêm. ID đã tồn tại.");
				}
				break;
			}

			case 2: {
				System.out.print("Chọn ID để chỉnh sửa: ");
				int id = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Nhập tên sản phẩm: ");
				String name = scanner.nextLine();
				System.out.print("Nhập giá sản phẩm: ");
				double price = scanner.nextDouble();
				System.out.print("Nhập tổng số lượng sản phẩm: ");
				int total = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Nhập thương hiệu: ");
				String brand = scanner.nextLine();
				System.out.print("Nhập năm sản xuất: ");
				int year = scanner.nextInt();

				Projector updatedProjector = new Projector(id, name, price, total, brand, year);
				dao.writeFile(manager.getProjectors());
				if (!manager.editProjector(updatedProjector)) {
					System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
				}
				break;
			}

			case 3: {
				System.out.print("Nhập ID để xoá: ");
				int id = scanner.nextInt();
				if (!manager.delProjector(id)) {
					System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
				}else {
					dao.writeFile(manager.getProjectors());
				}
				break;
			}

			case 4: {
				System.out.print("Nhập tên để tìm kiếm: ");
				String name = scanner.nextLine();
				List<Projector> searchResults = manager.searchProjector(name);
				if (!searchResults.isEmpty()) {
					System.out.println("Kết quả:");
					for (Projector p : searchResults) {
						System.out.println(p);
					}
				} else {
					System.out.println("Không tìm thấy máy chiếu với thông tin đã cho.");
				}
				break;
			}
			case 5: {
				System.out.print("Nhập giá thấp nhất: ");
				double minPrice = scanner.nextDouble();
				System.out.print("Nhập giá cao nhất: ");
				double maxPrice = scanner.nextDouble();

				List<Projector> searchResults = manager.searchProjector(minPrice, maxPrice);
				if (!searchResults.isEmpty()) {
					System.out.println("Kết quả:");
					for (Projector p : searchResults) {
						System.out.println(p);
					}
				} else {
					System.out.println("Không tìm thấy máy chiếu trong đoạn đã cho.");
				}
				break;
			}
			case 6: {
				manager.hienThi();
				break;
			}
			case 7: {
				dao.writeFile(manager.getProjectors());
				System.out.println("Thoát chương trình.");
				break;
			}
			default: {
				System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 7.");
			}
			}
		} while (choice != 7);

	}
}
