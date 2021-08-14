package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InputDialogDemo {
    JFrame jf = new JFrame("Input Dialog Demonstration");
    JTextArea jta = new JTextArea(6, 30);
    JButton btn = new JButton(new AbstractAction("Pop up input dialog") {

        @Override
        public void actionPerformed(ActionEvent e) {
            // pop up input dialog
            String result = JOptionPane.showInputDialog(jf, "Please enter your bank account number：", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);
            jta.append(result);
        }
    });

    public void init(){
        jf.add(jta);
        jf.add(btn, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new InputDialogDemo().init();
    }
}
