package tree;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class SelectJTree {
    JFrame jf = new JFrame("Listen to selection in JTree");

    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    JTextArea eventTxt = new JTextArea(5, 20);

    public void init() {

        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        tree = new JTree(root);

        //TODO Set selection mode
        TreeSelectionModel selectionModel = tree.getSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        //TODO Set listener
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // Print the selected path to the texts
                TreePath newLeadSelectionPath = e.getNewLeadSelectionPath();
                eventTxt.append(newLeadSelectionPath.toString()+"\n");
            }
        });

        Box box = Box.createHorizontalBox();
        box.add(new JScrollPane(tree));
        box.add(new JScrollPane(eventTxt));

        jf.add(box);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SelectJTree().init();
    }
}
