package UI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
 

public class t_release extends JFrame{//식권 발행창
	JButton btn[] = new JButton[4];//식권 사진 버튼
	
	public t_release() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		JTabbedPane tab = createTabbedPane();
		
		c.add(new north(),BorderLayout.NORTH);
		c.add(tab,BorderLayout.CENTER);//탭
		c.add(new south(),BorderLayout.SOUTH);
		
		setTitle("식권 발매 프로그램");
		setSize(450,800);
		setVisible(true);
		
		
	}
	class north extends JPanel{
		public north() {
			JLabel la = new JLabel("식권 발매 프로그램");
			la.setFont(new Font("궁서",Font.PLAIN,20));
			add(la);
		}
	}
	public JTabbedPane createTabbedPane() {//탭 만들기
			JTabbedPane tab = new JTabbedPane();
			tab.addTab("메뉴",new menu());
			
			return tab;
		
	}
	class menu extends JPanel{//탭에 얹을 메뉴 페널
		public menu() {
			setLayout(new GridLayout(2,2));
			ImageIcon icon[] = new ImageIcon[4];
			JToolBar tool[] = new JToolBar[4];//툴팁 달기
			String toolname[] = {"한식","중식","일식","양식"};
			String img[] = {"data/menu_1.png","data/menu_2.png","data/menu_3.png",
					"data/menu_4.png"};
			for(int i=0; i<icon.length; i++) {
				tool[i] = new JToolBar();
				tool[i].setBackground(Color.LIGHT_GRAY);
				
				icon[i] = new ImageIcon(img[i]);
				btn[i] = new JButton(icon[i]);
				btn[i].setToolTipText(toolname[i]);
				
				tool[i].add(btn[i]);
				
				btn[i].addActionListener(new ac());
				
				add(btn[i]);
			}
		}
	}
	class south extends JPanel{
		JLabel la = new JLabel("");
		public south() {
			TimerRunnable th = new TimerRunnable();
			th.start();//thread 시작, 생성
			add(la);
			this.setBackground(Color.BLACK);
		}
		class TimerRunnable extends Thread{

			@Override
			public void run() {
				
				while(true){
					try {
						Thread.sleep(1000);//1초동안 쉬기
						
					}catch(InterruptedException e) {
						System.out.println("타이머 오류");
					return;
					}
					Calendar c = Calendar.getInstance();
					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH);
					int day = c.get(Calendar.DATE);
					int hour = c.get(Calendar.HOUR_OF_DAY);
					int min = c.get(Calendar.MINUTE);
					int second = c.get(Calendar.SECOND);
					//합쳐서 레이블에 얹기
					String time = (year+"년 "+month+"월 "+day+"일 "+
					hour+"시 "+min+"분 "+second+"초");
					la.setFont(new Font("돋움",Font.PLAIN,15));
					la.setForeground(Color.CYAN);
					la.setBackground(Color.BLACK);
					la.setText("현재시간 : "+time);
					la.setOpaque(true);
					
				}//while
				
			}//run
			
			
		}//timerunnable

		
	}
	
	class ac implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			String k ="select * from meal where cuisineNo = 1";//한식
			if(b==btn[0]) {//한식
				new k_food("1");
			}else if(b==btn[1]) {//중식
				new k_food("2");
			}else if(b==btn[2]) {//일식
				new k_food("3");
			}else if(b==btn[3]) {//양식
				new k_food("4");
			}
		}
		
		
	}
	public static void main(String[] args) {
		new t_release();
	}

}


