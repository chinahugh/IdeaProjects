package com.java.focus.swing.code;

import javax.swing.*;
import java.awt.*;

/**
 * 加法计算器
 */
public class AddCalculator extends JFrame {
    private JTextField firstText;
    private JTextField secondText;
    private JTextField resultText;
    private JButton calBtn;
    private JButton clearBtn;
    private JButton exitBtn;

    public AddCalculator(String title) {
        setTitle(title);
        setSize(300, 200);
        setResizable(false);
        setLocation(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        init();
        setVisible(true);
    }

    /**
     * 初始化函数
     */
    private void init() {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel addLabel = new JLabel(" + ");
        JLabel equalLabel = new JLabel(" = ");
        firstText = new JTextField(5);
        secondText = new JTextField(5);
        resultText = new JTextField(5);
        resultText.setEditable(false);
        calBtn = new JButton("Calculate");
        clearBtn = new JButton("Clear");
        exitBtn = new JButton("Exit");
        panel1.add(firstText);
        panel1.add(addLabel);
        panel1.add(secondText);
        panel1.add(equalLabel);
        panel1.add(resultText);
        panel2.add(calBtn);
        panel2.add(clearBtn);
        panel2.add(exitBtn);
        add(panel1);
        add(panel2);
        process();
    }

    private void process() {
        calBtn.addActionListener(e -> {
            int num1 = Integer.parseInt(firstText.getText());
            int num2 = Integer.parseInt(secondText.getText());
            int result = num1 + num2;
            resultText.setText(result + "");
         });
        clearBtn.addActionListener(e -> {
            firstText.setText("");
            secondText.setText("");
            resultText.setText("");
        });
        exitBtn.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        new AddCalculator("Add Calculator");
    }
}
