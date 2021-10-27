package UI;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import DB.Driver_connect;
import java.util.*;
import java.awt.image.*;
import java.io.*;
public class management extends JFrame{
	JButton btn[] = new JButton[5];
	public management() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.add(new north(),BorderLayout.NORTH);
		c.add(new center(),BorderLayout.CENTER);
		
		setSize(500,450);
		setTitle("관리");
		setVisible(true);
	}
	
	class north extends JPanel{
		public north() {
			String btn_s[] = {"메뉴 등록","메뉴 관리","결제 조회","종류별 차트","종료"};
			for(int i=0; i<btn.length; i++) {
				btn[i] = new JButton(btn_s[i]);
				btn[i].addActionListener(new ac());
				add(btn[i]);
			}
		}
	}
	class center extends JPanel{
		public center() {
			//ImageIcon icon = new ImageIcon("data/main.jpg");
			//JLabel img = new JLabel(icon);
			//add(img);

			
		}
	}
	
	class ac implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn.equals("메뉴 등록")) {
				dispose();
//				new new_menu();
			}else if(btn.equals("메뉴관리")) {
				dispose();
//				new menu_table2();
			}else if(btn.equals("결제 조회")) {
				dispose();
//				new payment_check();
			}else if(btn.equals("종류별 차트")) {
				
			}else if(btn.equals("종료")) {
				dispose();
			}
			
			
		}
	}
	public static void main(String[] args) {
		new management();

	}

}
