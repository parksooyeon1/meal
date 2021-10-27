package UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.NumberFormat;

import DB.Driver_connect;
import java.util.*;
import java.awt.image.*;
import java.io.*;
public class main extends JFrame{
	JButton b[] = new JButton[4];
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.add(new btn());
		
		setTitle("메인");
		setVisible(true);
		setSize(300,400);
	}
	class btn extends JPanel{
		public btn() {
			String btn_s[] = {"사용자","관리자","사원등록","종료"};
			setLayout(new GridLayout(4,1));
			
			for(int i=0; i<b.length; i++) {
				b[i] = new JButton(btn_s[i]);
				b[i].addActionListener(new ac());
				add(b[i]);
			}
		}
	}
	class ac implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn2 = (JButton)e.getSource();
			if(btn2==b[0]) {
				//dispose();
				new t_release();
			}else if(btn2==b[1]) {
				//dispose();
				new manager();
			}else if(btn2==b[2]) {
				
			}else if(btn2==b[3]) {
				dispose();
			}
			
			
		}
	}
	public static void main(String[] args) {
		new main();
	}

}
