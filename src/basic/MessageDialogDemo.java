package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MessageDialogDemo {
    JFrame jf = new JFrame("Message Dialog Demonstration");

    JTextArea jta = new JTextArea(6, 30);

    JButton btn = new JButton(new AbstractAction("Pop up message dialog") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //弹出一个消息对话框，并且显示  文本域中输入的内容
            String text = jta.getText();

            // Parameter: int messageType to specify dialog type
            //JOptionPane.showMessageDialog(jf,text,"Error Message Dialog",JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(jf,text,"Information Message Dialog",JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(jf,text,"Warning Message Dialog",JOptionPane.WARNING_MESSAGE);
            //JOptionPane.showMessageDialog(jf,text,"Question Message Dialog",JOptionPane.QUESTION_MESSAGE);
            //JOptionPane.showMessageDialog(jf,text,"Plain Dialog",JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(jf,text,"Message Dialog",JOptionPane.WARNING_MESSAGE,new ImageIcon("img/component/female.png"));
        }
    });

    public void init(){
        // Construction
        jf.add(jta);
        jf.add(btn, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new MessageDialogDemo().init();
    }
}
