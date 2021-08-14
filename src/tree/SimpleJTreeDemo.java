package tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class SimpleJTreeDemo {
    JFrame jf = new JFrame("Simple Tree Demonstration");


    public void init(){

        // Tree Node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
        DefaultMutableTreeNode guangDong = new DefaultMutableTreeNode("广东");
        DefaultMutableTreeNode guangXi = new DefaultMutableTreeNode("广西");
        DefaultMutableTreeNode foShan = new DefaultMutableTreeNode("佛山");
        DefaultMutableTreeNode shanTou = new DefaultMutableTreeNode("汕头");
        DefaultMutableTreeNode guiLin = new DefaultMutableTreeNode("桂林");
        DefaultMutableTreeNode nanNing = new DefaultMutableTreeNode("南宁");

        // Construct relationships
        root.add(guangDong);
        root.add(guangXi);

        guangDong.add(foShan);
        guangDong.add(shanTou);

        guangXi.add(guiLin);
        guangXi.add(nanNing);


        // Create the tree
        JTree tree = new JTree(root);

        jf.add(tree);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }


    public static void main(String[] args) {
        new SimpleJTreeDemo().init();
    }
}
