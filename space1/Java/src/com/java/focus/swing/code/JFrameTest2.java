package com.java.focus.swing.code;
import javax.swing.*;
import java.awt.*;
public class JFrameTest2 extends JFrame{
	public JFrameTest2(String title){
		setTitle(title);
		setSize(300,300);
		setLocation(200,200);
		getContentPane().setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args){
		JFrameTest2 frame = new JFrameTest2("JFrame Test");	
	}
}
