package UI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DB.Driver_connect;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.sql.*;
import java.text.NumberFormat;

import DB.Driver_connect;
 
public class k_food extends JFrame{
	Vector<Vector<String>> selection =new Vector<Vector<String>>();//선택한 상품정보 벡터
	
	JTextField s_c_tf = new JTextField(10);//선택품명 텍스트 필드
	JTextField s_tf = new JTextField(3);//수량 텍스트 필드
	
	

	
	Connection con = null;
	PreparedStatement psmt = null;
	
	JTable jt;

	
	int maxCount = 0;//조리가능수량
	
	Vector<btn> btn_v = new Vector<btn>();//버튼 벡터
	Vector<btn> btn_v_2 = new Vector<btn>();//조리가능수량,오늘의
	
	String comma = null;
	
	Vector<String>vc = new Vector<String>();//선택열 정보 벡터
	
	JTextField pw_tf = new JTextField(10); //패스워드 텍필
	JComboBox<String> combobox = new JComboBox<String>();//사원번호 콤보박스
	
	String combo = null;//콤보박스
	public k_food(String b) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.add(new north(b),BorderLayout.NORTH);
		c.add(new center(b),BorderLayout.CENTER);
		
		
		setVisible(true);
		setTitle("결제");
		setSize(1000,800);
		
	}
	class north extends JPanel{ //한식
		public north(String b) {
			JLabel title =null ;
			if(b.equals("1")) {
				title = new JLabel("한식");
			}else if(b.equals("2")) {
				title = new JLabel("중식");
			}
			else if(b.equals("3")) {
				title = new JLabel("일식");
			}
			else if(b.equals("4")) {
				title = new JLabel("양식");
			}
			
			title.setFont(new Font("돋움",Font.PLAIN,20));
			add(title);
		
		}
	}
	class center extends JPanel{ //전체 창
		public center(String b) {
			setLayout(new GridLayout(1,2));
			add(new left(b));
			//add(new right(b),new GridLayout(2,1));
		}
	}
	
	class left extends JPanel{ //메뉴 버튼 창
		public left(String b) {
			String sql = "select count(cuisineNo) from meal where cuisineNo = "+b;
			
				con = Driver_connect.makeConnection("syticket");
				try {
					psmt = con.prepareStatement(sql);
					ResultSet rs = psmt.executeQuery();
					
					while(rs.next()) {
						int count = Integer.parseInt(rs.getString(1));
						if(count%5==0) {
							setLayout(new GridLayout(count/5,5));
							
						}else{
							setLayout(new GridLayout(count/5+1,5));
						}
					}
					
				} catch (SQLException e) {
					System.out.println("한식 sql 오류");
				}
				make_btn(b);
				for(int i=0; i<btn_v.size(); i++) {
					add(btn_v.get(i));
				}
			}
		
		public void make_btn(String b){	//메뉴버튼
			String mealname = "select mealName,price,maxCount,todayMeal from meal where cuisineNo = "+b;
			
			con = Driver_connect.makeConnection("syticket");
			
			
			try {
				psmt = con.prepareStatement(mealname);
				ResultSet rs = psmt.executeQuery();
				
				while(rs.next()) {
					btn_v.add(new btn(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
					
				}
				
				
			}catch(SQLException e) {
				System.out.println("make_btn 오류");
			}
		}
	}
	class btn extends JButton{ //메뉴 버튼
		String name;
		public btn(String name,String price,int count,int today) {
			 	this.name=name;
				this.setText("<html><center>"+name+"<br><br>"+price+"</center></html>"); 
				
				if(count<1||today!=1) {
					this.setEnabled(false);
				
				}
				this.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						s_c_tf.setText(name);
						maxCount = count;

						JButton btn = (JButton)e.getSource();
						btn.setEnabled(false);
						}
					});//actionlistener
		
				//this.addActionListener(new n_btn());
		}
		
		public String getName() {
			return name;
		}
	}
	


}
