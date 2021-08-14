package progress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBarDemo {

    JFrame jf = new JFrame("Progress Bar Demonstration");

    JCheckBox indeterminate = new JCheckBox("Uncertain progress bar");
    JCheckBox noBorder = new JCheckBox("No border");

    // Create progress bar
    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL,0,100);

    public void init(){
        // Construct view

        // Handle selection
        indeterminate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if indeterminate is selected
                boolean selected = indeterminate.isSelected();

                // Set the progress bar as indeterminate
                bar.setIndeterminate(selected);
                bar.setStringPainted(!selected);
            }
        });

        noBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if no border is selected
                boolean selected = noBorder.isSelected();
                bar.setBorderPainted(!selected);
            }
        });

        Box vBox = Box.createVerticalBox();
        vBox.add(indeterminate);
        vBox.add(noBorder);


        // Set progress bar property
        bar.setStringPainted(true);
        bar.setBorderPainted(true);

        // Set the window layout as FlowLayout
        jf.setLayout(new FlowLayout());
        jf.add(vBox);
        jf.add(bar);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

        // Simulate a progression with a loop
        for (int i = 0; i <= 100; i++) {
            // Set percentage value
            bar.setValue(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ProgressBarDemo().init();
    }
}
