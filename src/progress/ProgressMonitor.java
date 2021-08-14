package progress;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressMonitor {
    Timer timer;
    public void init(){
        // Create a dialog
        javax.swing.ProgressMonitor monitor = new javax.swing.ProgressMonitor(null,"Waiting for task to be completed","Completed",0,100);

        SimulaterActivity simulaterActivity = new SimulaterActivity(100);
        new Thread(simulaterActivity).start();

        // Set timed activity
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get current amount and set progress
                int current = simulaterActivity.getCurrent();
                monitor.setProgress(current);

                // Check if the user clicked cancel
                // Stop the timer, close the dialog and exit the program
                if (monitor.isCanceled()){
                    timer.stop();
                    monitor.close();
                    System.exit(0);
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new ProgressMonitor().init();
    }

    // Define a thread acticity, simulating a time-consuming operation
    private class SimulaterActivity implements Runnable{
        private volatile int current = 0;
        private int amount;

        public SimulaterActivity(int amount) {
            this.amount = amount;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }


        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        @Override
        public void run() {
            // Update progress with loop
            while(current<amount){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                current++;
            }
        }
    }
}
