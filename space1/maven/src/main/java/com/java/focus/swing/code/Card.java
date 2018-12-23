package com.java.focus.swing.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card{
	private JFrame  frame;
	private Container contentPane;

	public Card(String title){
		frame = new JFrame(title);
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		contentPane = frame.getContentPane();
		initGUI();
	}
	private void initGUI(){
		contentPane.setLayout(new CardLayout(20, 20));

		for(int i = 10; i < 20; i++){
			JButton btn = new JButton("btn " + i);
			btn.setSize(30, 20);
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					CardLayout cl = 
						(CardLayout)contentPane.getLayout();
					cl.next(contentPane);
				}
			});
			contentPane.add(btn, "btn" + i);
		}
	}
	public void go(){
		frame.setVisible(true);
	}

	public static void main(String... args){
		(new Thread(){
			public void run(){
				(new Card("card")).go();
			}
		}).start();
	}
}






