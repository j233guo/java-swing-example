package progress;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBarDemo2 {
    JFrame jf = new JFrame("Progress Bar Demonstration 2");

    JCheckBox indeterminate = new JCheckBox("Indeterminate progress");
    JCheckBox noBorder = new JCheckBox("No border");

    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL,0,100);

    public void init(){
        // Construct view

        // Handle selection
        indeterminate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if indeterminate is selected
                boolean selected = indeterminate.isSelected();

                // set progress bar as indeterminate
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


        // Set property
        bar.setStringPainted(true);
        bar.setBorderPainted(true);

        // Set the window layout as FlowLayout
        jf.setLayout(new FlowLayout());
        jf.add(vBox);
        jf.add(bar);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

        // Start another thread, simulating a time-consuming task
        SimulaterActivity simulaterActivity = new SimulaterActivity(bar.getMaximum());
        new Thread(simulaterActivity).start();

        // Set a timed task
        Timer timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the progression of the activity and set progress bar
                int current = simulaterActivity.getCurrent();
                bar.setValue(current);
            }
        });
        timer.start();

        // Listen to changes in progress bar
        bar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = bar.getValue();
                if (value == simulaterActivity.getAmount()){
                    timer.stop();
                }
            }
        });
    }

    private class SimulaterActivity implements  Runnable{
        // Activity amount
        private int amount;

        // Current completed amount
        private volatile int current;

        public SimulaterActivity(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        @Override
        public void run() {
            // child thread simulating time-consuming activity
            while(current<amount){
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                current++;
            }
        }
    }

    public static void main(String[] args) {
        new ProgressBarDemo2().init();
    }
}
