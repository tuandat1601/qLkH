package QuanLyServive;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerService {
protected Connection conn = null;
public SQLServerService() {
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl =
				"jdbc:sqlserver://DESKTOP-6APCFMV:1433;databaseName=QuanLyKhoaHoc;integratedSecurity=true;";
				
		conn = DriverManager.getConnection(connectionUrl);
		
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
}
}
