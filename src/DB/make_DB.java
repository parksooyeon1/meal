package DB;
import java.sql.*;

public class make_DB {
	String sql = "create database if not exists ";
	public  make_DB(String name) {
		try {
			Connection con = Driver_connect.makeConnection("");
			Statement st = con.createStatement();
			st.execute(sql+name);
			System.out.println("DB 성공!!");
		}catch(SQLException e) {
			System.out.println("DB 오류ㅠ");
		}
	}

	public static void main(String[] args) {
		new  make_DB("syticket");

	}

}
