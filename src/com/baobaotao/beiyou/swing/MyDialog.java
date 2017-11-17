package com.baobaotao.beiyou.swing;

import com.baobaotao.beiyou.Book;
import com.baobaotao.beiyou.db.BookDao;
import org.codehaus.jettison.json.JSONString;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

/**
 * @FileName MyDialog.java
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
 * @Date: 2017/11/15  18:19
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class MyDialog extends JDialog implements ActionListener {

    JLabel idLabel;
    JLabel titleLabel;
    JLabel authorLabel;
    JLabel publisherLabel;
    JLabel priceLabel;

    JTextField idField;
    JTextField titleField;
    JTextField authorField;
    JTextField publisherField;
    JTextField priceField;

    JButton doneButton;
    JButton cancelButton;

    private BookDao bookDao = new BookDao();


    // 类似地声明其它数据成员；需要你自己写代码。

    // 构造方法
    MyDialog (JFrame fra, String s) {
        super(fra, s, true);
        setSize(300, 200);
        setLocation(200,200);
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        // con.setSize(300, 200);

        idLabel = new JLabel("序号：", SwingConstants.RIGHT);
        titleLabel = new JLabel("书名：", SwingConstants.RIGHT);
        authorLabel = new JLabel("作者：", SwingConstants.RIGHT);
        publisherLabel = new JLabel("出版商：", SwingConstants.RIGHT);
        priceLabel = new JLabel("价格：", SwingConstants.RIGHT);
        idField = new JTextField();
        titleField = new JTextField();
        authorField = new JTextField();
        publisherField = new JTextField();
        priceField = new JTextField();
        idField.setEditable(false);
        doneButton = new JButton("确定");
        cancelButton = new JButton("取消");

        doneButton.addActionListener(this);
        cancelButton.addActionListener(this);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(5, 2));
        northPanel.add(idLabel);
        northPanel.add(idField);
        northPanel.add(titleLabel);
        northPanel.add(titleField);
        northPanel.add(authorLabel);
        northPanel.add(authorField);
        northPanel.add(publisherLabel);
        northPanel.add(publisherField);
        northPanel.add(priceLabel);
        northPanel.add(priceField);
        con.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 2));
        southPanel.add(doneButton);
        southPanel.add(cancelButton);
        con.add(southPanel, BorderLayout.SOUTH);

        con.setVisible(true);
        //pack(); // size the JFrame to fit its contents
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        StringBuffer sb = new StringBuffer();

        if (e.getSource() == doneButton) {

            sb = sb.append(titleField.getText() + "\t" + authorField.getText() +  "\t" +
                    publisherField.getText() +  "\t" + priceField.getText() +"\n");
			/* 用this.getOwner() 获取当前对话框的拥有者。
			 * (MyJFrame)(this.getOwner()) 是把取得的父窗口对象做“向下定型”为 MyJFrame 类型，
			 * 这样才能调用 MyJFrame 类中我们自己定义的属性和方法。
			 * 之后调用 updateText() 方法更新 JFrame 窗口内容面板中的 JTextArea 对象就可以了。
			 */
            ((MyJFrame)(this.getOwner())).updateText(sb.toString());
            setVisible(false);

            Book book = new Book();
            book.setTitle(titleField.getText());
            book.setAuthor(authorField.getText());
            book.setPublisher(publisherField.getText());
            book.setPrice(new BigDecimal(priceField.getText()));
            bookDao.addBooks(book);

            dispose();
        } else if (e.getSource() == cancelButton) {
            List<Book> bookList = bookDao.fetchBooks();
            for(int i = 0 ; i < bookList.size() ; i ++){
                Book book = bookList.get(i);
                sb = sb.append(i+1 + "\t"+book.getTitle() + "\t" + book.getAuthor() +  "\t" +
                        book.getPublisher() +  "\t" + book.getPrice() +"\n");
            }
            ((MyJFrame)(this.getOwner())).updateText(sb.toString());
            setVisible(false);
            dispose();
        }
    }
}


