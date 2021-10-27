package DB;
import java.sql.*;
import java.io.*;
import java.util.*;
public class insert_file {
	Connection con = Driver_connect.makeConnection("syticket");
	PreparedStatement psmt = null;
	String insert[] = {"insert into cuisine values(?,?)",
			 "insert into meal values(?,?,?,?,?,?)",
			"insert into member values(?,?,?)",
			"insert into orderlist values(?,?,?,?,?,?,?)"};
	String [] file = {"cuisine","meal","member","orderlist"};
	public insert_file() {
		for(int i=0; i<insert.length; i++) {
			try {
				Scanner scanner = new Scanner(new FileInputStream("data/"+file[i]+".txt"));
				
				psmt = con.prepareStatement(insert[i]);
				scanner.nextLine();
				
				while(scanner.hasNext()) {
					String s = scanner.nextLine(); //파일 한줄씩 읽기
					StringTokenizer st = new StringTokenizer(s,"\t");
					int v =st.countTokens();
					for(int j=0; j<v; j++) {
						psmt.setString(j+1, st.nextToken());
					}
					int re = psmt.executeUpdate();
					if(re == 1) {
						System.out.println("파일 적재 성공");
					}else {
						System.out.println("파일 적재 실패");
					}
				}
			}catch(SQLException e) {
				System.out.println("sql 오류");
			}catch(FileNotFoundException e) {
				System.out.println("파일 못찾음");
			}
		}
		
	}

	public static void main(String[] args) {
		new insert_file();
	}

}
