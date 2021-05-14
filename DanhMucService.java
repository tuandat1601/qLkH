package QuanLyServive;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import QuanLyKhoaHoc.model.DanhMuc;



public class DanhMucService extends SQLServerService{
	public int xulyxoa(DanhMuc dm) {
		try {
			
			String sql = "update DanhMuc set isDeleted = ?,where MaDM = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			
			preparedStatement.setString(2, dm.getMaDM());
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
public Vector<DanhMuc>doctoanbodanhmuc(){
	 Vector<DanhMuc>vec = new Vector<DanhMuc>();
	 try {
		 String sql = "select * from DanhMuc where isDeleted = 0";
		 Statement statement = conn.createStatement();
		 ResultSet result = statement.executeQuery(sql);
		 while(result.next()) {
			 DanhMuc dm = new DanhMuc();
			 dm.setMaDM(result.getString(1));
			 dm.setTenDm(result.getString(2));
			 dm.setIsDeleted(0);
			 vec.add(dm);
			
		 }
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 return vec;
}
}
