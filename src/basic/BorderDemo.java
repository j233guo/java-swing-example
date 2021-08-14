package basic;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class BorderDemo {
    JFrame jf  = new JFrame("Border Demonstration");

    public void init(){
        // Construct the view

        // 1.Set JFrame layout as GridLayout
        jf.setLayout(new GridLayout(2,4));

        // 2. Insert different JPanel components into grid, and set border and contents
        // Create BevelBorder
        Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.GREEN, Color.BLUE, Color.GRAY);
        jf.add(getJPanelWithBorder(bevelBorder,"BevelBorder"));

        // Create LineBorder
        Border lineBorder = BorderFactory.createLineBorder(Color.ORANGE, 10);
        jf.add(getJPanelWithBorder(lineBorder,"LineBorder"));

        // Create EmptyBorder
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 5, 20, 10);
        jf.add(getJPanelWithBorder(emptyBorder,"EmptyBorder"));

        // Create EtchedBorder
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED, Color.GREEN);
        jf.add(getJPanelWithBorder(etchedBorder,"EtchedBorder"));

        // Create TitledBorder
        TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.ORANGE,10),"test title",TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("StSong",Font.BOLD,18),Color.BLUE);
        jf.add(getJPanelWithBorder(titledBorder,"TitledBorder"));

        // Create MatteBorder
        MatteBorder matteBorder = new MatteBorder(10, 5, 20, 10, Color.GREEN);
        jf.add(getJPanelWithBorder(matteBorder,"MatteBorder"));

        // Create Compound Border
        CompoundBorder compoundBorder = new CompoundBorder( new LineBorder(Color.RED, 10),titledBorder);
        jf.add(getJPanelWithBorder(compoundBorder,"CompoundBorder"));

        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPanel getJPanelWithBorder(Border border,String content){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel(content));

        // Set border
        jPanel.setBorder(border);

        return jPanel;
    }

    public static void main(String[] args) {
        new BorderDemo().init();
    }
}
