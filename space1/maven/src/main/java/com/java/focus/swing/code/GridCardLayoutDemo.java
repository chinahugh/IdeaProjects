package com.java.focus.swing.code;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GridCardLayoutDemo extends JFrame {
	private Container contentpane;
	private JButton[] btns;
	private JLabel[] labels;

	public GridCardLayoutDemo() {
		this.setTitle("GridCardLayoutDemo");
		setBounds(50, 50, 600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentpane = this.getContentPane();
		initGui();
		setVisible(true);
	}

	public void initGui() {
		contentpane.setLayout(new GridLayout(3, 3));
		btns = new JButton[9];
		for (int i = 0; i < 9; i++) {
			btns[i] = new JButton("" + (i + 1));
			contentpane.add(btns[i]);
		}
		bulidCardLayout(btns[4]);
	}

	public void bulidCardLayout(final JButton btn) {
		btn.setLayout(new CardLayout());
		labels = new JLabel[5];
		labels[0] = new JLabel("lbl one");
		/*
		 * labels[0].setFont(new Font("宋体",3,20));
		 * labels[0].setForeground(Color.blue); labels[0].setPreferredSize(new
		 * Dimension(50, 50)); //labels[0].setSize(300,300);
		 * //labels[0].setOpaque(true);
		 */
		labels[0].setBackground(Color.red);

		labels[1] = new JLabel("lbl two");
		labels[1].setBackground(Color.YELLOW);
		labels[2] = new JLabel("lbl three");
		labels[2].setBackground(Color.GREEN);
		labels[3] = new JLabel("lbl four");
		labels[3].setBackground(Color.black);
		labels[4] = new JLabel("lbl five");
		labels[4].setBackground(Color.orange);
		btn.add(labels[0], "one");
		btn.add(labels[1], "two");
		btn.add(labels[2], "three");
		btn.add(labels[3], "four");
		btn.add(labels[4], "five");
		for (int i = 0; i < 5; i++) {
			labels[i].setFont(new Font("宋体", 3, 20));
			labels[i].setForeground(Color.blue);
			labels[i].setOpaque(true);
			// 适配器类主要是解决接口中所有方法都需要实现的问题设计的
			// 适配器类中的所有方法都没有逻辑，只有签名
			labels[i].addMouseListener(new MouseAdapter() {
				@Override
                public void mouseClicked(MouseEvent e) {
					Object obj = e.getSource();
					for (int j = 0; j < 5; j++) {
						if (obj == labels[j]) {
							btns[1].setText("this is " + labels[j].getName() + " card");
							CardLayout layout = (CardLayout) btn.getLayout();
							layout.next(btn);
							break;
						}
					}
				}
			});
		}
	}

	public static void main(String[] args) {
		new GridCardLayoutDemo();
	}
}
