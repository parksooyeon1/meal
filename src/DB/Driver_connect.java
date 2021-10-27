package DB;
import java.sql.*;

public class Driver_connect {
	public static Connection makeConnection(String a) {
		String url = "jdbc:mysql://localhost/"+a;
		String id = "root";
		String pw = "root1234!";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이브 적재 성공");
			con = DriverManager.getConnection(url,id,pw);
			System.out.println("DB 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이브 적재 실패");
		}catch(SQLException e) {
			System.out.println("실패");
		}
		
		return con;
		
	}

	public static void main(String[] args) {
		 Connection con = makeConnection("");
	}

}
