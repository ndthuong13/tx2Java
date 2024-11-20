package LamLaiMau1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuanLySinhVien {

	private List<SinhVien> sinhVienList;
	private final SinhVienDAO sinhVienDAO;

	public QuanLySinhVien() {
		sinhVienDAO = new SinhVienDAO();
		try {
			sinhVienList = sinhVienDAO.readFile();
		} catch (IOException | ClassNotFoundException e) {
			sinhVienList = new ArrayList<>();
		}
	}

	public void themSinhVien(SinhVien sv) throws IOException {
		sinhVienList.add(sv);
		sinhVienDAO.writeFile(sinhVienList);
	}

	public void xoaSinhVien(String msv) throws IOException {
		sinhVienList.removeIf(sv -> sv.getMsv().equals(msv));
		sinhVienDAO.writeFile(sinhVienList);
	}

	public void suaSinhVien(String msv, SinhVien svMoi) throws IOException {
		for (int i = 0; i < sinhVienList.size(); i++) {
			if (sinhVienList.get(i).getMsv().equals(msv)) {
				sinhVienList.set(i, svMoi);
				break;
			}
		}
		sinhVienDAO.writeFile(sinhVienList);
	}
	
//	public void sapXepSinhVienTheoDiem() {
//	    for (int i = 0; i < sinhVienList.size() - 1; i++) {
//	        for (int j = i + 1; j < sinhVienList.size(); j++) {
//	            if (sinhVienList.get(i).getDiemTB() < sinhVienList.get(j).getDiemTB()) {
//	                SinhVien temp = sinhVienList.get(i);
//	                sinhVienList.set(i, sinhVienList.get(j));
//	                sinhVienList.set(j, temp);
//	            }
//	        }
//	    }
//	    System.out.println("Danh sach sinh vien da duoc sap xep theo diem trung binh (giam dan)!");
//	}


	public SinhVien timKiem(String msv) {
		for (SinhVien sv : sinhVienList) {
			if (sv.getMsv().equals(msv)) {
//				System.out.println(
//						"|===============================================================================================================================================|");
//				System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-20s | %-20s | %-5s | %-5s | %-5s | %-6s | \n",
//						"Ma SV", "Ho Ten", "Gioi Tinh", "Ngay Sinh", "CCCD", "Nganh Nghe", "Diem 1", "Diem 2", "Diem 3", "DTB",
//						"TK");
//				System.out.println(
//						"|===============================================================================================================================================|");
//				for (SinhVien svTK : sinhVienList) {
//					System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-20s | %-20s | %-6s | %-6s | %-6s | %-6s | \n",
//							sv.getMsv(), sv.getHoten(), sv.getGioiTinh(), sv.getNgaySinh(),sv.getCccd(), sv.getJob(), sv.getDiemM1(),
//							sv.getDiemM2(), sv.getDiemM2(), sv.getDiemM3(), sv.getDiemTB(), sv.getAccount());
//				}
//				System.out.println(
//						"|===============================================================================================================================================|");
				return sv;
			}
		}
		return null;
	}

	public void hienThiSinhVien() {
		if (sinhVienList.isEmpty()) {
			System.out.println("\nDanh sach sinh vien rong!\n");
			return;
		}

		System.out.println(
				"|===============================================================================================================================================|");
		System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-20s | %-20s | %-5s | %-5s | %-5s | %-6s | \n",
				"Ma SV", "Ho Ten", "Gioi Tinh", "Ngay Sinh", "CCCD", "Nganh Nghe", "Diem 1", "Diem 2", "Diem 3", "DTB",
				"TK");
		System.out.println(
				"|===============================================================================================================================================|");
		for (SinhVien sv : sinhVienList) {
			System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-20s | %-20s | %-6s | %-6s | %-6s | %-6s | \n",
					sv.getMsv(), sv.getHoten(), sv.getGioiTinh(), sv.getNgaySinh(),sv.getCccd(), sv.getJob(), sv.getDiemM1(),
					sv.getDiemM2(), sv.getDiemM2(), sv.getDiemM3(), sv.getDiemTB(), sv.getAccount());
		}
		System.out.println(
				"|===============================================================================================================================================|");

	}

}
