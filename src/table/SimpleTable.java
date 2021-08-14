package table;

import javax.swing.*;

public class SimpleTable {
    JFrame jf = new JFrame("Simple Table");

    // Column
    Object[] titles = {"Name","Age","Gender"};

    // Row
    Object[][] data = {
            {"李清照",29,"F"},
            {"苏格拉底",56,"M"},
            {"李白",35,"M"},
            {"弄玉",18,"F"},
            {"虎头",2,"M"}
    };

    public void init(){
        JTable jTable = new JTable(data,titles);

        jf.add(new JScrollPane(jTable));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleTable().init();
    }
}
