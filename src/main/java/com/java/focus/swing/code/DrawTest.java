package com.java.focus.swing.code;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawTest{
	public static void main(String... args){
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class DrawFrame extends JFrame{
	public DrawFrame(){
		setTitle("Draw Test");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		DrawPanel panel = new DrawPanel();
		add(panel);
	}
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
}

class DrawPanel extends JPanel{
	@Override
    public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setPaint(Color.RED);
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;

		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
		g2.draw(rect);

		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.draw(ellipse);

		g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		double radius = 150;

		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
		g2.draw(circle);

		g2.drawString("hello, pictures", (int)centerX, (int)centerY);
	}
}
