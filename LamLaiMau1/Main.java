package LamLaiMau1;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		QuanLySinhVien qlsv = new QuanLySinhVien();
		Scanner scanner = new Scanner(System.in);

		int choice;

		do {
			System.out.println("Chuong trinh quann ly sinh vien: ");
			System.out.println("1. Nhap sinh vien. ");
			System.out.println("2. Hien thi sinh vien. ");
			System.out.println("3. Tim kiem sinh vien. ");
			System.out.println("4. Them ban ghi. ");
			System.out.println("5. Sua ban ghi.");
			System.out.println("6. Xoa ban ghi.");
			System.out.println("7. Thoat.");
			System.out.println("8. Sap xep ban ghi.");
			System.out.print("Chon chuc nang: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1 -> {
				System.out.println("Nhap ho ten: ");
				String hoTen = scanner.nextLine();
				System.out.println("Nhap ngay sinh: ");
				String ngaySinh = scanner.nextLine();
				System.out.println("Nhap gioi tinh: ");
				String gioiTinh = scanner.nextLine();
				System.out.println("Nhap so cccd: ");
				String cccd = scanner.nextLine();
				System.out.println("Nhap ma sinh vien: ");
				String msv = scanner.nextLine();
				System.out.println("Nhap nghe nghiep: ");
				String job = scanner.nextLine();
				System.out.println("Nhap tai khoan: ");
				String account = scanner.nextLine();
				System.out.println("Nhap mat khau: ");
				String password = scanner.nextLine();
				System.out.println("Nhap diem m1: ");
				Double diemM1 = scanner.nextDouble();
				System.out.println("Nhap diem m2: ");
				Double diemM2 = scanner.nextDouble();
				System.out.println("Nhap diem m3: ");
				Double diemM3 = scanner.nextDouble();

				SinhVien sv = new SinhVien(hoTen, ngaySinh, gioiTinh, cccd, msv, job, account, password, diemM1, diemM2,
						diemM3);
				try {
					qlsv.themSinhVien(sv);
					System.out.println("Them thanh cong ");

				} catch (IOException e) {
					System.out.println("Loi khong them duoc sinh vien!");
				}

			}
			case 2 -> {
				qlsv.hienThiSinhVien();
			}
			case 3 -> {
				System.out.println("Nhap ma sinh vien: ");
				String msv = scanner.nextLine();
				SinhVien sv = qlsv.timKiem(msv);
				if (sv != null) {
					System.out.println(sv);
				} else {
					System.out.println("Khong tim thay sinh vien");
				}
			}
			case 4 -> {
				System.out.println("Nhap ho ten: ");
				String hoTen = scanner.nextLine();
				System.out.println("Nhap ngay sinh: ");
				String ngaySinh = scanner.nextLine();
				System.out.println("Nhap gioi tinh: ");
				String gioiTinh = scanner.nextLine();
				System.out.println("Nhap so cccd: ");
				String cccd = scanner.nextLine();
				System.out.println("Nhap ma sinh vien: ");
				String msv = scanner.nextLine();
				System.out.println("Nhap nghe nghiep: ");
				String job = scanner.nextLine();
				System.out.println("Nhap tai khoan: ");
				String account = scanner.nextLine();
				System.out.println("Nhap mat khau: ");
				String password = scanner.nextLine();
				System.out.println("Nhap diem m1: ");
				Double diemM1 = scanner.nextDouble();
				System.out.println("Nhap diem m2: ");
				Double diemM2 = scanner.nextDouble();
				System.out.println("Nhap diem m3: ");
				Double diemM3 = scanner.nextDouble();

				SinhVien sv = new SinhVien(hoTen, ngaySinh, gioiTinh, cccd, msv, job, account, password, diemM1, diemM2,
						diemM3);
				try {
					qlsv.themSinhVien(sv);
					System.out.println("Them thanh cong ");
				} catch (IOException e) {
					System.out.println("Loi khong them duoc sinh vien!");
				}

			}
			case 5 -> {
				System.out.println("Nhap ma sinh vien can sua: ");
				String msv = scanner.nextLine();
				SinhVien svMoi = qlsv.timKiem(msv);
				if (svMoi != null) {
					System.out.println("Nhap ho ten: ");
					String hoTen = scanner.nextLine();
					System.out.println("Nhap ngay sinh: ");
					String ngaySinh = scanner.nextLine();
					System.out.println("Nhap gioi tinh: ");
					String gioiTinh = scanner.nextLine();
					System.out.println("Nhap so cccd: ");
					String cccd = scanner.nextLine();
					System.out.println("Nhap nghe nghiep: ");
					String job = scanner.nextLine();
					System.out.println("Nhap tai khoan: ");
					String account = scanner.nextLine();
					System.out.println("Nhap mat khau: ");
					String password = scanner.nextLine();
					System.out.println("Nhap diem m1: ");
					Double diemM1 = scanner.nextDouble();
					System.out.println("Nhap diem m2: ");
					Double diemM2 = scanner.nextDouble();
					System.out.println("Nhap diem m3: ");
					Double diemM3 = scanner.nextDouble();

					try {
						qlsv.suaSinhVien(msv, new SinhVien(hoTen, ngaySinh, gioiTinh, cccd, msv, job, account, password,
								diemM1, diemM2, diemM3));
						System.out.println("Sua thanh cong!");
					} catch (IOException e) {
						System.out.println("Loi sua sinh vien! ");
					}
				} else {
					System.out.println("Khong tim thay sinh vien! ");
				}
			}
			case 6 -> {
				System.out.println("Nhap ma sinh vien can xoa: ");
				String msv = scanner.nextLine();
				SinhVien svXoa = qlsv.timKiem(msv);
				if (svXoa != null) {
					try {
						qlsv.xoaSinhVien(msv);
						System.out.println("Xoa thanh cong! ");
					} catch (IOException e) {
						System.out.println("Loi xoa sinh vien! ");
					}
				} else {
					System.out.println("Ma sinh vien khong ton tai! ");
				}

			}
			case 7 -> {
				System.out.println("Thoat chuong trinh! ");
			}
//			case 8 ->{
//				qlsv.sapXepSinhVienTheoDiem();
//				qlsv.hienThiSinhVien();
//			}
			
			default -> {
				System.out.println("Lua chon khong hop le, vui long chon lai! ");
			}

			}

		} while (choice != 7);
	}

}