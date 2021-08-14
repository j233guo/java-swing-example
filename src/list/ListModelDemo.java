package list;

import model.NumberComboBoxListModel;
import model.NumberListModel;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.List;

public class ListModelDemo {
    JFrame jf = new JFrame("List Model Demonstration");

    JList<BigDecimal> jList = new JList<>(new NumberListModel(new BigDecimal(1),new BigDecimal(21),new BigDecimal(2)));
    JComboBox<BigDecimal> jComboBox = new JComboBox<>(new NumberComboBoxListModel(new BigDecimal(0.1),new BigDecimal(1.2),new BigDecimal(0.1)));
    JLabel label = new JLabel("The value you selected is：");
    JTextField jTextField = new JTextField(15);

    public void init() {
        // Construct the view

        // Construct the top
        jList.setVisibleRowCount(4);
        jList.setSelectionInterval(2, 4);

        jList.setFixedCellWidth(90);
        jList.setFixedCellHeight(30);

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<BigDecimal> selectedValuesList = jList.getSelectedValuesList();
                jTextField.setText("");
                for (BigDecimal item: selectedValuesList) {
                    jTextField.setText(jTextField.getText()+item.toString()+", ");
                }
            }
        });

        jComboBox.setMaximumRowCount(4);
        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object selectedItem = jComboBox.getSelectedItem();
                jTextField.setText(selectedItem.toString());
            }
        });

        Box hBox = Box.createHorizontalBox();
        hBox.add(new JScrollPane(jList));

        JPanel tempPanel = new JPanel();
        tempPanel.add(jComboBox);
        hBox.add(tempPanel);
        jf.add(hBox);

        // Construct the bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(label);
        bottomPanel.add(jTextField);
        jf.add(bottomPanel, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new ListModelDemo().init();
    }
}
