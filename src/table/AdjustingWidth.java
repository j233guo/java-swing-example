package table;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class AdjustingWidth {
    JFrame jf = new JFrame("Adjusting Table");

    // Column
    Object[] titles = {"Name","Age","Gender"};

    // Row
    Object[][] data = {
            new Object[]{"李清照",29,"F"},
            new Object[]{"苏格拉底",56,"M"},
            new Object[]{"李白",35,"M"},
            new Object[]{"弄玉",18,"F"},
            new Object[]{"虎头",2,"M"},
    };

    public void init(){

        JTable table  = new JTable(data,titles);

        //TODO Set selection mode
        //table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);// default
        //table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // single interval
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// single selection
        //TODO Ste width
        TableColumn column_1 = table.getColumn(titles[0]);
        column_1.setMinWidth(40);
        TableColumn column_3 = table.getColumn(titles[2]);
        column_3.setMaxWidth(50);
        jf.add(new JScrollPane(table));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new AdjustingWidth().init();
    }
}
