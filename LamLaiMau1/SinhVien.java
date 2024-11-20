package LamLaiMau1;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private static final long serialVersionUID = 1L;
	private String hoten;
	private String ngaySinh;
	private String gioiTinh;
	private String cccd;
	private String msv;
	private String job;
	private String account;
	private String password;
	private double diemM1;
	private double diemM2;
	private double diemM3;
	private double diemTB;

	public SinhVien() {
		super();
	}

	public SinhVien(String hoten, String ngaySinh, String gioiTinh, String cccd, String msv, String job, String account,
			String password, double diemM1, double diemM2, double diemM3) {
		super();
		this.hoten = hoten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.cccd = cccd;
		this.msv = msv;
		this.job = job;
		this.account = account;
		this.diemM1 = diemM1;
		this.diemM2 = diemM2;
		this.diemM3 = diemM3;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getMsv() {
		return msv;
	}

	public void setMsv(String msv) {
		this.msv = msv;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getDiemM1() {
		return diemM1;
	}

	public void setDiemM1(double diemM1) {
		this.diemM1 = diemM1;
	}

	public double getDiemM2() {
		return diemM2;
	}

	public void setDiemM2(double diemM2) {
		this.diemM2 = diemM2;
	}

	public double getDiemM3() {
		return diemM3;
	}

	public void setDiemM3(double diemM3) {
		this.diemM3 = diemM3;
	}

	public double getDiemTB() {
		return Math.round((diemM1 + diemM2 + diemM3) / 3);
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	@Override
	public String toString() {
		return "SinhVien [hoten=" + hoten + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", cccd=" + cccd
				+ ", msv=" + msv + ", job=" + job + ", account=" + account + ", password=" + password + ", diemM1="
				+ diemM1 + ", diemM2=" + diemM2 + ", diemM3=" + diemM3 + ", diemTB=" + diemTB + "]";
	}

}
