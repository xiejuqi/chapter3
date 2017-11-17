package com.baobaotao.beiyou.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @FileName MyJFrame.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2017/11/15  18:18
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class MyJFrame extends JFrame implements ActionListener {
    JTextArea text = new JTextArea(); // 用于在窗口中显示内容的文本区

    /* 声明面板 conPane。在构造方法中取得内容面板，赋给 conPane。
     * 在构造方法之外声明这个变量是为了让 conPane 成为 MyJFrame 的成员变量。
     * 以后就可以直接引用这个成员变量。
     */
    Container conPane = null;

    // 构造方法
    public MyJFrame(String name, int w, int h) {
        super();
        setTitle(name);
        setSize(w, h);
        setLocation(100, 100);

        conPane = getContentPane();
        conPane.setLayout(new BorderLayout());
        text.setEnabled(false);
        conPane.add(text,  BorderLayout.CENTER);

        JMenuBar mnb = new JMenuBar();

        JMenu fileMenu = new JMenu("图书管理");
        JMenuItem newItem = new JMenuItem("添加图书");
        JMenuItem viewItem = new JMenuItem("显示图书");
        JMenuItem quitItem= new JMenuItem("退出");
        // 类似地创建其它菜单项；需要你自己写代码。

        newItem.addActionListener(this);
        viewItem.addActionListener(this);
        quitItem.addActionListener(this);
        // 类似地给其它菜单项注册时间监听器；需要你自己写代码。

        fileMenu.add(newItem);
        fileMenu.add(viewItem);
        fileMenu.add(quitItem);

        // 类似地把其它菜单项装配到菜单上；需要你自己写代码。
        mnb.add(fileMenu);

        setJMenuBar(mnb);

		/* 关闭窗口时退出程序 */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateText(String s) {
        text.setText(s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand() == "退出") {
            System.exit(0);
        } else if (e.getActionCommand() == "添加图书") {
            text.setText("添加图书");
            MyDialog dlg = new MyDialog(this, "添加图书对话框");
            dlg.setVisible(true);
        } else if  (e.getActionCommand() == "显示图书") {
                text.setText("显示图书");
        }
    }

    public static void main(String[] args) {
        MyJFrame myJFrame = new MyJFrame("书籍管理",500,500);
        myJFrame.setVisible(true);
    }
}



