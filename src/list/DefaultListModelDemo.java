package list;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultListModelDemo {
    JFrame jf = new JFrame("DefaultListModel Demonstration");
    JTextField bookName = new JTextField(20);
    JButton removeBtn = new JButton("Delete Selected Book");
    JButton addBtn = new JButton("Add Book");

    JList<String> bookList;

    DefaultListModel<String> model = new DefaultListModel<>();

    public void init(){
        // Construct view
        model.addElement("java自学宝典");
        model.addElement("轻量级JavaEE企业应用实战");
        model.addElement("Android基础教程");
        model.addElement("JQuery实战教程");

        bookList = new JList<>(model);
        bookList.setVisibleRowCount(4);
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jf.add(new JScrollPane(bookList));

        // Construct the bottom
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = bookName.getText();
                if (!name.trim().equals("")){
                    model.addElement(name);
                }
            }
        });

        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = bookList.getSelectedIndex();

                if (selectedIndex>=0){
                    model.remove(selectedIndex);
                }
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(bookName);
        bottomPanel.add(addBtn);
        bottomPanel.add(removeBtn);

        jf.add(bottomPanel, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new DefaultListModelDemo().init();
    }
}
