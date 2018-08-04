package com.java.focus.swing.code;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
	private JFrame frame;
	private Container contentPane;
	private JButton northBtn,southBtn,westBtn,eastBtn;
	private JButton[] btns;
	
	public BorderLayoutDemo(){
		frame = new JFrame("BorderLayoutDemo");
		contentPane = frame.getContentPane();
		frame.setLocation(50, 50);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		initGui();
	}
	
	public void initGui(){
		// frame的默认布局方式是BorderLayout
		contentPane.setLayout(new BorderLayout(5,5));
		westBtn = new JButton("West");
		eastBtn = new JButton("East");
		northBtn = new JButton("North");
		southBtn = new JButton("South");
		//centerBtn = new JButton("Center");
		contentPane.add(westBtn,BorderLayout.WEST);
		contentPane.add(eastBtn,BorderLayout.EAST);
		contentPane.add(northBtn,BorderLayout.NORTH);
		contentPane.add(southBtn,BorderLayout.SOUTH);
		// 组件加入容器的时候不指定位置，默认放在中间区域，
		//另外BorderLayout的其他区域可以不添加组件
		//contentPane.add(centerBtn,BorderLayout.CENTER);
		//contentPane.add(centerBtn);
		btns = new JButton[100];
		// JPanel的默认布局方式就是FlowLayout
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new FlowLayout());
		centerPane.setBackground(Color.BLACK);
		contentPane.add(centerPane, BorderLayout.CENTER);
		for(int i=1;i<=100;i++){
			if(i<10){
				btns[i-1] = new JButton("00"+i);
			}else if(i<100){
				btns[i-1] = new JButton("0"+i);
			}else{
				btns[i-1] = new JButton(""+i);
			}
 			centerPane.add(btns[i-1]);
		}
	}
	public void go(){
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutDemo().go();
	}
}
