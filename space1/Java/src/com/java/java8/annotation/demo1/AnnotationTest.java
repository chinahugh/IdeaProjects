package com.java.java8.annotation.demo1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Auther HUGH
 * @Date 2018/3/24
 * @Description AnnotationTest 主程序
 */
public class AnnotationTest {
    private JFrame mainWin = new JFrame("使用注解绑定事件监听");

    @ActionListenerFor(listener = OkListener.class)
    private JButton ok = new JButton("ok");

    @ActionListenerFor(listener = CancelListener.class)
    private JButton cancel = new JButton("cancel");


    /**
     * 初始化界面
     */
    public void init(){
        JPanel jPanel = new JPanel();
        jPanel.add(ok);
        jPanel.add(cancel);
        mainWin.add(jPanel);
       ActionListenerInstaller.processAnnotations(this,ok,cancel);
        mainWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }
    public static void main(String[] args) {
        new AnnotationTest().init();
    }

}

/**
 * 定义ok按钮事件
 */
class OkListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"单击了ok");
    }
}

/**
 * 定义cancel按钮事件
 */
class CancelListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"单击了cancel");
    }
}
