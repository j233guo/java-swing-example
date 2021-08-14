package table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class DefaultTableModel {
    JFrame jf = new JFrame("TableModel Demonstration");
    Object[] titles = {"Name","Age","Gender"};

    Object[][] data = {
            {"李清照",29,"F"},
            {"苏格拉底",56,"M"},
            {"李白",35,"M"},
            {"弄玉",18,"F"},
            {"虎头",2,"M"}
    };

    private Vector titlesV = new Vector();
    private Vector<Vector> dataV = new Vector<>();

    public void init(){
        for (int i = 0; i < titles.length; i++) {
            titlesV.add(titles[i]);
        }

        for (int i = 0; i < data.length; i++) {
            Vector t = new Vector<>();
            for (int j = 0; j < data[i].length; j++) {
                t.add(data[i][j]);
            }
            dataV.add(t);
        }


        // Construct JTable with DefaultTableModel
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(dataV,titlesV);
        JTable jTable = new JTable(model);

        JButton addRow = new JButton("Add a row");
        JButton addColum = new JButton("Add a column");
        JButton deleteRow = new JButton("Remove a row");

        addRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add a row to the table
                model.addRow(new Object[]{"柳岩",18,"F"});
            }
        });

        deleteRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTable.getSelectedRow();
                model.removeRow(selectedRow);
            }
        });



        addColum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addColumn("Occupation");
            }
        });

        JPanel panel = new JPanel();
        panel.add(addRow);
        panel.add(addColum);
        panel.add(deleteRow);

        jf.add(panel, BorderLayout.SOUTH);

        jf.add(new JScrollPane(jTable));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new DefaultTableModel().init();
    }
}
