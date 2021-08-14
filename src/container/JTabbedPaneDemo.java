package container;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTabbedPaneDemo {
    JFrame jf = new JFrame("JTabbedPane Demonstration");

    JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);

    public void init(){
        // Construct View
        // Add tag
        tabbedPane.addTab("User Management",new ImageIcon("img/container/open.gif"),new JList<String>(new String[]{"User 1","User 2","User 3"}));
        tabbedPane.addTab("Item Management",new JList<String>(new String[]{"Item 1","Item 2","Item 3"}));
        tabbedPane.addTab("Order Management",new ImageIcon("img/container/open.gif"),new JList<String>(new String[]{"Order 1","Order 2","Order 3","Order 4"}));

        // Complete setting
        tabbedPane.setEnabledAt(0,false);
        tabbedPane.setSelectedIndex(1);

        // Listen to the selection in the tab
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                JOptionPane.showMessageDialog(jf,"You selected tab "+(selectedIndex+1));
            }
        });

        jf.add(tabbedPane);


        jf.setBounds(400,400,400,400);
        jf.setResizable(false);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


    public static void main(String[] args) {
        new JTabbedPaneDemo().init();
    }
}
