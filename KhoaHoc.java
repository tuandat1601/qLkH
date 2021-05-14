package QuanLyKhoaHoc.model;

import java.sql.Date;

public class KhoaHoc {
	private String maKH;
	private String tenKH;
	private String moTa;
	private java.util.Date ngayBD;
	private java.util.Date ngauKT;
	private String maDM;
	private int isDeleted;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	

	public java.util.Date getNgayBD() {
		return ngayBD;
	}
	public void setNgayBD(java.util.Date ngayBD) {
		this.ngayBD = ngayBD;
	}
	public java.util.Date getNgauKT() {
		return ngauKT;
	}
	public void setNgauKT(java.util.Date ngauKT) {
		this.ngauKT = ngauKT;
	}
	public String getMaDM() {
		return maDM;
	}
	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.tenKH;
	}

	
}
