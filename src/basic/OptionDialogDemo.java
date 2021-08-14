package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OptionDialogDemo {
    JFrame jf = new JFrame("Option Dialog Demonstration");

    JTextArea jta = new JTextArea(6, 30);

    JButton btn = new JButton(new AbstractAction("Pop up option dialog") {

        @Override
        public void actionPerformed(ActionEvent e) {
            // pop up option dialog
            int result = JOptionPane.showOptionDialog(jf, "Please select your size", "Option Dialog", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Large", "Medium", "Small"}, "Medium");

            switch (result){
                case 0:
                    jta.setText("You selected large");
                    break;
                case 1:
                    jta.setText("You selected medium");
                    break;
                case 2:
                    jta.setText("You selected small");
                    break;
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
        new OptionDialogDemo().init();
    }
}
