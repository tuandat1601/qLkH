package QuanLyKhoaHoc.model;

import java.sql.Date;

public class HocVien {
private String maHV;
private String tenHV;
private Date ngaySinh;
private int gioiTinh;
private String diaChi;
private int sdt;
private String maKH;
private int isDeleted;
public String getMaHV() {
	return maHV;
}
public void setMaHV(String maHV) {
	this.maHV = maHV;
}
public String getTenHV() {
	return tenHV;
}
public void setTenHV(String tenHV) {
	this.tenHV = tenHV;
}
public Date getNgaySinh() {
	return ngaySinh;
}
public void setNgaySinh(Date ngaySinh) {
	this.ngaySinh = ngaySinh;
}
public int getGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(int gioiTinh) {
	this.gioiTinh = gioiTinh;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public int getSdt() {
	return sdt;
}
public void setSdt(int sdt) {
	this.sdt = sdt;
}
public String getMaKH() {
	return maKH;
}
public void setMaKH(String maKH) {
	this.maKH = maKH;
}
public int getIsDeleted() {
	return isDeleted;
}
public void setIsDeleted(int isDeleted) {
	this.isDeleted = isDeleted;
}
}
