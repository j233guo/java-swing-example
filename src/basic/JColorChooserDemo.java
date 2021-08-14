package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JColorChooserDemo {
    JFrame jFrame = new JFrame("JColorChooser Demonstration");

    JTextArea jta = new JTextArea("Jiaming Guo",6,30);

    JButton btn = new JButton(new AbstractAction("Change text area background color") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show a color chooser，
            Color result = JColorChooser.showDialog(jFrame, "Color Chooser", Color.white);

            // Set background color
            jta.setBackground(result);
        }
    });

    public void init(){
        // Construct view
        jFrame.add(jta);
        jFrame.add(btn,BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new JColorChooserDemo().init();
    }
}
