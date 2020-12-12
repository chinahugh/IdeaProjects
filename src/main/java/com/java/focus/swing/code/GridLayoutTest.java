package com.java.focus.swing.code;
import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame{
	JButton[] btns;
	public GridLayoutTest(String title){
		setTitle(title);
		setSize(400,400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,3));
		init();
		setVisible(true);
	}
	private void init(){
		btns = new JButton[9];	
		for(int i = 0;i < btns.length;i++){
			btns[i] = new JButton("button"+(i+1));
			add(btns[i]);	
		}
	}
	public static void main(String[] args){
		GridLayoutTest glt = new GridLayoutTest("GridLayout Test");
	}
}
