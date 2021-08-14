package table;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class TableModel {
    JFrame jf = new JFrame("TableModel Demonstration");
    Object[] titles = {"Name","Age","Gender"};

    Object[][] data = {
            {"李清照",29,"F"},
            {"苏格拉底",56,"M"},
            {"李白",35,"M"},
            {"弄玉",18,"F"},
            {"虎头",2,"M"}
    };

    private Vector titlesV = new Vector();// Title
    private Vector<Vector> dataV = new Vector<>();// Data

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


        MyTableModel myTableModel = new MyTableModel();
        //JTable jTable = new JTable(dataV,titlesV);
        JTable jTable = new JTable(myTableModel);

        jf.add(new JScrollPane(jTable));

        JButton btn = new JButton("Get data in selected row");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedColumn = jTable.getSelectedColumn();
                int selectedRow = jTable.getSelectedRow();
                System.out.println("Current Row："+selectedRow);
                System.out.println("Current Column："+selectedColumn);

                Object value = myTableModel.getValueAt(selectedRow, selectedColumn);
                System.out.println("The first cell in select row is："+value);
            }
        });
        jf.add(btn, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    private class MyTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return dataV.size();
        }

        @Override
        public int getColumnCount() {
            return titlesV.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return dataV.get(rowIndex).get(columnIndex);
        }

        @Override
        public String getColumnName(int column) {
            return (String) titlesV.get(column);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    }

    public static void main(String[] args) {
        new TableModel().init();
    }
}
