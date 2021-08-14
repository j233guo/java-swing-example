package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingComponentDemo {
    JFrame f = new JFrame("Swing Basic Component Demonstration");

    // Menu
    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenue = new JMenu("File");
    JMenu editMenue = new JMenu("Edit");

    JMenuItem auto = new JMenuItem("Auto line wrap");
    JMenuItem copy = new JMenuItem("Copy",new ImageIcon("img/component/copy.png"));
    JMenuItem paste = new JMenuItem("Paste",new ImageIcon("img/component/paste.png"));

    JMenu formatMenu = new JMenu("Format");
    JMenuItem comment = new JMenuItem("Comment");
    JMenuItem cancelComment = new JMenuItem("Cancel Comment");

    // text area
    JTextArea ta = new JTextArea(8, 20);

    String[] colors= {"Red","Green","Blue"};
    // list
    JList<String> colorList = new JList<String>(colors);

    // choice component
    JComboBox<String> colorSelect = new JComboBox<String>();

    ButtonGroup bg = new ButtonGroup();
    JRadioButton male = new JRadioButton("Male", false);
    JRadioButton female = new JRadioButton("Female", true);

    JCheckBox isMarried = new JCheckBox("Married？", true);

    // Declare the bottom
    JTextField tf = new JTextField(40);
    JButton ok = new JButton("OK",new ImageIcon("img/component/ok.png"));

    // Right click menu
    JPopupMenu jPopupMenu = new JPopupMenu();

    ButtonGroup poupButtonBg = new ButtonGroup();

    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal Style");
    JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus Style");
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows Style",true);
    JRadioButtonMenuItem windowsClassicItem = new JRadioButtonMenuItem("Windows Classic");
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif Style");

    public void init() {
        // Construct the view

        // Construct the bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(tf);
        bottomPanel.add(ok);

        f.add(bottomPanel, BorderLayout.SOUTH);

        // Construct selection components
        JPanel selectPanel = new JPanel();

        colorSelect.addItem("Red");
        colorSelect.addItem("Green");
        colorSelect.addItem("Blue");

        selectPanel.add(colorSelect);
        bg.add(male);
        bg.add(female);
        selectPanel.add(male);
        selectPanel.add(female);

        selectPanel.add(isMarried);

        // Construct text area components
        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(selectPanel);

        // Construct the top
        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        f.add(top);

        // Construct the top menu
        formatMenu.add(comment);
        formatMenu.add(cancelComment);

        editMenue.add(auto);
        editMenue.addSeparator();
        editMenue.add(copy);
        editMenue.add(paste);
        editMenue.addSeparator();
        editMenue.add(formatMenu);

        menuBar.add(fileMenue);
        menuBar.add(editMenue);

        f.setJMenuBar(menuBar);

        // Construct right click menu
        poupButtonBg.add(metalItem);
        poupButtonBg.add(nimbusItem);
        poupButtonBg.add(windowsItem);
        poupButtonBg.add(windowsClassicItem);
        poupButtonBg.add(motifItem);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Current Style
                String actionCommand = e.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        metalItem.addActionListener(listener);
        nimbusItem.addActionListener(listener);
        windowsItem.addActionListener(listener);
        windowsClassicItem.addActionListener(listener);
        motifItem.addActionListener(listener);

        jPopupMenu.add(metalItem);
        jPopupMenu.add(nimbusItem);
        jPopupMenu.add(windowsItem);
        jPopupMenu.add(windowsClassicItem);
        jPopupMenu.add(motifItem);

        ta.setComponentPopupMenu(jPopupMenu);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    // Change interface sty;e
    private void changeFlavor(String command) throws Exception {
        switch (command) {
            case "Metal Style":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus Style":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
            case "Windows Style":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows Classic":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif Style":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }

        // Refresh the appearance
        SwingUtilities.updateComponentTreeUI(f.getContentPane());
        SwingUtilities.updateComponentTreeUI(menuBar);
        SwingUtilities.updateComponentTreeUI(jPopupMenu);
    }

    public static void main(String[] args) {
        new SwingComponentDemo().init();
    }

}
