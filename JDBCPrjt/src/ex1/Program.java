package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO NOTICE VALUES(1,'JDBC란 무엇인가?','newlec','aaa',sysdate,0,'')";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "ADMIN","root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			String title = rs.getString("TITLE");
			System.out.println(title);
		}
		
		rs.close();
		st.close();
		con.close();
	}

}

