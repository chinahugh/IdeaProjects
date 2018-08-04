package com.java.focus.swing.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutEx{
	private JFrame frame;
	private Container contentPane;
	private JButton[] btn = new JButton[5];
	
	public CardLayoutEx(){
		frame = new JFrame("Card Layout Manager Example");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = frame.getContentPane();
		initGUI();
	}
	private void initGUI(){
		contentPane.setLayout(new CardLayout(20,20));
		
		for(int i = 0; i < btn.length; i++){
			btn[i] = new JButton("Button" + i);
			btn[i].addActionListener(
				new ActionListener(){
				public void actionPerformed(ActionEvent e){
					CardLayout cl = 
						(CardLayout)contentPane.getLayout();
					cl.next(contentPane);
				}
			});
			contentPane.add(btn[i],"button" + i);
		}
	}
	public void go(){
		frame.setVisible(true);
	}
	public static void main(String[] args){
		(new CardLayoutEx()).go();
	}
}
