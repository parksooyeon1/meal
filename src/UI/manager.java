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

public class manager extends JFrame{
	
	JPasswordField jp = new JPasswordField();
	JButton numb[] = new JButton[9];
	JButton zero = new JButton("0");

	String pw = null;
	
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
	String answer = "true";
	

	public manager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		int result  = JOptionPane.showConfirmDialog(null,new center(),"관리자 패스워드 입력",JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			
			pw = new String(jp.getPassword());	//*******************
		
			if(pw.equals("0000")){ 
				System.out.println("관리자");
				//dispose();
				new management();	
			}//else
			else{
				System.out.println("관리자 아님");
				JOptionPane.showMessageDialog(null, "관리자 패스워드를 확인하십시오.","message",JOptionPane.ERROR_MESSAGE);
				
				jp.setText("");
				
			}
		

		}
	}	
	class center extends JPanel{
		public center() {
			setLayout(new BorderLayout());
			add(new n(),BorderLayout.NORTH);
			add(new c(),BorderLayout.CENTER);
			add(new s(),BorderLayout.SOUTH);
		}
	}
	
	class n extends JPanel{
		public n() {
			setLayout(new BorderLayout());
			jp.setEnabled(false);
			add(jp);
		}
	}
	class c extends JPanel{
		public c() {
			setLayout(new GridLayout(3,3));
			String n[] = {"1","2","3","4","5","6","7","8","9"};
			for(int i=0; i<n.length; i++) {
				numb[i] = new JButton(n[i]);
				numb[i].addActionListener(new ac());
				add(numb[i]);
			}
		}
	}
	class s extends JPanel{
		public s() {
			setLayout(new BorderLayout());
			zero.addActionListener(new ac());
			add(zero);
		}
	}
	
	class ac implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			pw = new String(jp.getPassword());
			jp.setText(pw+btn.getText());
//			System.out.println(jp.getText());
				if(pw.length()>4){
					jp.setText(pw.substring(0,4));
				}//if
			
			}
		}
	
	public static void main(String[] args) {
		new manager();
	}

}
