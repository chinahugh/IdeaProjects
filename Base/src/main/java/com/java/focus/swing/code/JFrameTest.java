package com.java.focus.swing.code;
import javax.swing.*;
import java.awt.*;

public class JFrameTest{
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("First GUI program");
		frame.setSize(500,500);
		frame.setLocation(100,100);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
