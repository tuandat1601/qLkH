package QuanLyServive;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import QuanLyKhoaHoc.model.KhoaHoc;

public class KhoaHocService extends SQLServerService{
	public int luukhoahoc(KhoaHoc kh) {
		try {
			String sql = "insert into KhoaHoc values(?,?,?,?,?,?,?)";
			PreparedStatement prestatement = conn.prepareStatement(sql);
			prestatement.setString(1, kh.getMaKH());
			prestatement.setString(2, kh.getTenKH());
			prestatement.setString(3, kh.getMoTa());
			prestatement.setString(4, kh.getNgayBD().toString());
			prestatement.setString(5, kh.getNgauKT().toString());
			prestatement.setString(6, kh.getMaDM());
			prestatement.setInt(7, 0);
			return prestatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
public ArrayList<KhoaHoc>dockhoahoctheodanhmuc(String madm){
	ArrayList<KhoaHoc>dskh = new ArrayList<KhoaHoc>() ;
try {
	
	String sql ="select * from KhoaHoc where madm=? and isDeleted = 0";
	PreparedStatement prestatement = conn.prepareStatement(sql);
	prestatement.setString(1, madm);
	ResultSet result = prestatement.executeQuery();
	while(result.next()) {
		KhoaHoc kh = new KhoaHoc();
		kh.setMaKH(result.getString(1));
		kh.setTenKH(result.getString(2));
		kh.setMoTa(result.getString(3));
		kh.setNgayBD(result.getDate(4));
		kh.setNgauKT(result.getDate(5));
		kh.setMaDM(result.getString(6));
		kh.setIsDeleted(0);
		dskh.add(kh);
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return dskh;
}
}


