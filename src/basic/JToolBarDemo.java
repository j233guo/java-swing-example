package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JToolBarDemo {
    JFrame jf = new JFrame("JToolBar Demonstration");
    JTextArea jta = new JTextArea(6,35);

    JToolBar jToolBar = new JToolBar("Play Tool Bar",SwingConstants.HORIZONTAL);

    // Create 3 Action objects
    // parameters passed, name and icon, will become the name for buttons when added into toolbar
    Action pre = new AbstractAction("Previous",new ImageIcon("img/component/pre.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("Previous.\n");
        }
    };

    Action pause = new AbstractAction("Pause",new ImageIcon("img/component/pause.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("Pause Playing.\n");
        }
    };

    Action next = new AbstractAction("Next",new ImageIcon("img/component/next.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("Next.\n");
        }
    };


    public void init(){
        // Construct the view

        // Create JButton based on Action object
        JButton preBtn = new JButton(pre);
        JButton pauseBtn = new JButton(pause);
        JButton nextBtn = new JButton(next);

        /*jToolBar.add(pre);
        jToolBar.addSeparator();
        jToolBar.add(pause);
        jToolBar.addSeparator();
        jToolBar.add(next);*/

        jToolBar.add(preBtn);
        jToolBar.addSeparator();
        jToolBar.add(pauseBtn);
        jToolBar.addSeparator();
        jToolBar.add(nextBtn);

        // Make toolbar floatable
        jToolBar.setFloatable(true);

        jf.add(jToolBar, BorderLayout.NORTH);

        // Text Area does not support scrollbar by default
        // Set a component into JScrollPane to support scrolling
        JScrollPane jScrollPane = new JScrollPane(jta);

        jf.add(jScrollPane);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JToolBarDemo().init();
    }
}
