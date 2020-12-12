package com.java.focus.swing.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFirstGui {
    // 顶级容器
    private JFrame frame;
    // 附属容器
    private Container contenPane;
    // 组件
    private JButton addBtn, subBtn;
    private JLabel addLbl, eqsLbl;
    private JTextField fld1, fld2, fld3;

    public MyFirstGui() {
        // 初始化容器以及组件
        frame = new JFrame();
        contenPane = frame.getContentPane();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("this is my first GUI");
        contenPane.setBackground(Color.RED);
        initGui();
    }

    public void initGui() {
        // 设置布局管理
        contenPane.setLayout(
                new FlowLayout(FlowLayout.LEFT));
        // 初始化组件
        addBtn = new JButton("Add");
        subBtn = new JButton("Sub");
        addLbl = new JLabel("+");
        eqsLbl = new JLabel("=");
        fld1 = new JTextField(5);
        fld2 = new JTextField(5);
        fld3 = new JTextField(5);
        fld3.setEnabled(false);
        // 将构建好的组件加入容器
        contenPane.add(fld1);
        contenPane.add(addLbl);
        contenPane.add(fld2);
        contenPane.add(eqsLbl);
        contenPane.add(fld3);
        contenPane.add(addBtn);
        contenPane.add(subBtn);
        // 添加监听，并实现控制逻辑
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double d1 = Double.parseDouble(
                        fld1.getText().trim());
                double d2 = Double.parseDouble(
                        fld2.getText().trim());
                double res = 0;
                if (e.getSource() == addBtn)
                    res = d1 + d2;
                if (e.getSource() == subBtn)
                    res = d1 - d2;
                fld3.setText(res + "");
            }
        };
        addBtn.addActionListener(al);
        subBtn.addActionListener(al);
    }

    public void go() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFirstGui().go();
    }
}
