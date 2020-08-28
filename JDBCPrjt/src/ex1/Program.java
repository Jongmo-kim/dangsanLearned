package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM NOTICE WHERE HIT >= 10";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "ADMIN","root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getNString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getNString("CONTENT");
			int hit = rs.getInt("hit");
			
			System.out.printf("id :%d\ntitle:%s\nwriterId:%s\nregDate:%s\ncontents:%s\nhit:%d",
					id,title,writerId,regDate,content,hit);
			System.out.println();
			System.out.println();
		}
		
		rs.close();
		st.close();
		con.close();
	}

}

