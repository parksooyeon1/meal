package DB;
import java.sql.*;

public class make_table {
	String a = "create table if not exists ";
	String tables[] = {"member(memberNo int not null, memberName varchar(20), passwd varchar(4),primary key(memberNo))",
			"cuisine(cuisineNo int not null ,cuisineName varchar(10),primary key(cuisineNo))",
			"meal(mealNo int not null , cuisineNo int,mealName varchar(20),price int, maxCount int,todayMeal tinyint(1),primary key(mealNo))",
			"orderlist(orderNo int not null , cuisineNo int,mealNo int,memberNo int,orderCount int,amount int,oderDate datetime,primary key(orderNo))"};
	public make_table() {
		try {
			Connection con = Driver_connect.makeConnection("syticket");
			Statement st = con.createStatement();
			for(int i=0; i<tables.length; i++) {
				st.executeUpdate(a+tables[i]);
				
			}
			System.out.println("테이블 생성 성공");
		}catch(SQLException e) {
			System.out.println("테이블 생성 실패");
		}
	}

	public static void main(String[] args) {
		new make_table();
	}

}
