package container;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class SplitPaneDemo {
    Book[] books = {new Book("java自学宝典", new ImageIcon("img/container/java.png"), "国内关于 Java 编程最全面的图书 \n 看得懂 ， 学得会"),
            new Book("轻量级的JAVAEE企业应用实战", new ImageIcon("img/container/ee.png"), "SSM整合开发的经典图书，值的拥有"),
            new Book("Android基础教程", new ImageIcon("img/container/android.png"), "全面介绍Android平台应用程序\n 开发的各方面知识")
    };

    JFrame jf = new JFrame("JSplitPane Demonstration");

    // Declare components used
    JList<Book> bookJList = new JList<>(books);
    JLabel bookCover = new JLabel();
    JTextArea bookDesc = new JTextArea();

    public void init(){
        // Construct View
        // Set component size
        bookJList.setPreferredSize(new Dimension(150,400));
        bookCover.setPreferredSize(new Dimension(220,270));
        bookDesc.setPreferredSize(new Dimension(220,130));

        // Set listener for jList items
        bookJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // get current selected item
                Book book = bookJList.getSelectedValue();
                // display book cover
                bookCover.setIcon(book.getIcon());
                // display book description
                bookDesc.setText(book.getDesc());
            }
        });

        // Construct left area
        JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT,bookCover,new JScrollPane(bookDesc));
        left.setOneTouchExpandable(true);

        // Construct the total
        JSplitPane hole = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,bookJList);

        // Support continuous layout
        hole.setContinuousLayout(true);
        hole.setDividerSize(10);

        jf.add(hole);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SplitPaneDemo().init();
    }
}
