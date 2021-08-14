package tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class ExtendsDefaultCellTreeRenderer {
    JFrame jf = new JFrame("Customize icon based on type");

    JTree tree;

    ImageIcon rootIcon = new ImageIcon("img/tree/root.gif");
    ImageIcon databaseIcon = new ImageIcon("img/tree/database.gif");
    ImageIcon tableIcon = new ImageIcon("img/tree/table.gif");
    ImageIcon columnIcon = new ImageIcon("img/tree/column.gif");
    ImageIcon indexIcon = new ImageIcon("img/tree/index.gif");

    // Node data class, encapsulate node data
    class NodeData{
        public ImageIcon icon;
        public String name;

        public NodeData(ImageIcon icon, String name) {
            this.icon = icon;
            this.name = name;
        }
    }

    DefaultMutableTreeNode root = new DefaultMutableTreeNode(new NodeData(rootIcon,"Database navigation"));
    DefaultMutableTreeNode salaryDb = new DefaultMutableTreeNode(new NodeData(databaseIcon,"Salary Database"));
    DefaultMutableTreeNode customerDb = new DefaultMutableTreeNode(new NodeData(databaseIcon,"Customer Database"));
    DefaultMutableTreeNode employee = new DefaultMutableTreeNode(new NodeData(tableIcon,"Employees"));
    DefaultMutableTreeNode attend = new DefaultMutableTreeNode(new NodeData(tableIcon,"Attendance"));
    DefaultMutableTreeNode concat = new DefaultMutableTreeNode(new NodeData(tableIcon,"Contacts"));
    DefaultMutableTreeNode id = new DefaultMutableTreeNode(new NodeData(indexIcon,"Employee ID"));
    DefaultMutableTreeNode name = new DefaultMutableTreeNode(new NodeData(columnIcon,"Name"));
    DefaultMutableTreeNode gender = new DefaultMutableTreeNode(new NodeData(columnIcon,"Gender"));

    public void init(){

        root.add(salaryDb);
        root.add(customerDb);

        salaryDb.add(employee);
        salaryDb.add(attend);

        customerDb.add(concat);

        concat.add(id);
        concat.add(name);
        concat.add(gender);

        tree = new JTree(root);


        // TODO extend DefaultTreeCellRenderer to edit the appearance
        tree.setCellRenderer(new MyRenderer());

        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    private class MyRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            // Get current node
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

            // Get the name and icon that are about to be rendered
            NodeData nodeData = (NodeData) node.getUserObject();

            this.setText(nodeData.name);
            this.setIcon(nodeData.icon);
            return this;
        }
    }

    public static void main(String[] args) {
        new ExtendsDefaultCellTreeRenderer().init();
    }
}
