package com.java.focus.swing.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalFrame {
	private JFrame frame;
	private JTextField txtField1;
	private JTextField txtField2;
	private JTextField txtField3;
	private JButton addBtn;
	private JButton subBtn;
	private JButton exitBtn;
	private JLabel equalLbl;
	private Container contentPane;

	public CalFrame(String title) {
 		frame = new JFrame(title);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		System.out.println(screenWidth + "x" + screenHeight);

		frame.setSize(screenWidth, screenHeight);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = frame.getContentPane();
		contentPane.setBackground(Color.RED);
		initGUI();
	}

	public void initGUI() {
		// 2.set the layout manager
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 100));

		// 3. add the component
		txtField1 = new JTextField(10);
		txtField2 = new JTextField(10);
		txtField3 = new JTextField(10);
		equalLbl = new JLabel(" = ");
		addBtn = new JButton("add");
		subBtn = new JButton("sub");
		exitBtn = new JButton("exit");
		contentPane.add(txtField1);
		contentPane.add(txtField2);
		contentPane.add(equalLbl);
		contentPane.add(txtField3);
		contentPane.add(addBtn);
		contentPane.add(subBtn);
		contentPane.add(exitBtn);

		class BtnClick implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				int i = Integer.parseInt(txtField1.getText());
				int j = Integer.parseInt(txtField2.getText());
				if (o == addBtn) {
					txtField3.setText("" + (i + j));
				}
				if (o == subBtn) {
					txtField3.setText("" + (i - j));
				}
				if (o == exitBtn) {
					System.exit(0);
				}
			}
		}

		// 4.set the event listener
		ActionListener l = new BtnClick();
		addBtn.addActionListener(l);
		subBtn.addActionListener(l);
		exitBtn.addActionListener(l);
	}

	public void go() {
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		CalFrame f = new CalFrame("calculator");
		f.go();
	}
}
