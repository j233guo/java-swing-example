package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfirmDialogTest {
    JFrame jf = new JFrame("Confirm Dialog Demonstration");
    JTextArea jta = new JTextArea(6, 30);
    JButton btn = new JButton(new AbstractAction("Pop up confirm dialog") {

        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO pop up confirm dialog
            String text = jta.getText();
            jta.append("\n");
            //int result = JOptionPane.showConfirmDialog(jf, text, "confirmation dialog", JOptionPane.DEFAULT_OPTION);
            //int result = JOptionPane.showConfirmDialog(jf, text, "confirmation dialog", JOptionPane.YES_NO_OPTION);
            //int result = JOptionPane.showConfirmDialog(jf, text, "confirmation dialog", JOptionPane.YES_NO_CANCEL_OPTION);
            int result = JOptionPane.showConfirmDialog(jf, text, "confirmation dialog", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION){
                jta.append("You clicked yes\n");
            }

            if (result == JOptionPane.NO_OPTION){
                jta.append("You clicked no\n");
            }

            /*if (result == JOptionPane.OK_OPTION){
                jta.append("You clicked ok\n");
            }*/

            if (result == JOptionPane.CANCEL_OPTION){
                jta.append("You clicked cancel\n");
            }
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
        new ConfirmDialogTest().init();
    }
}
