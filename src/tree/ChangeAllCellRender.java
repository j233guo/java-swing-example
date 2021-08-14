package tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class ChangeAllCellRender {
    JFrame jf = new JFrame("Change the appearance of all nodes");

    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    public void init(){
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        tree = new JTree(root);

        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();

        renderer.setBackgroundNonSelectionColor(new Color(220,220,220));

        renderer.setBackgroundSelectionColor(new Color(140,140,140));

        renderer.setBorderSelectionColor(Color.BLACK);

        renderer.setClosedIcon(new ImageIcon("swing\\img\\tree\\close.gif"));

        renderer.setFont(new Font("StSong",Font.BOLD,16));

        renderer.setLeafIcon(new ImageIcon("swing\\img\\tree\\leaf.png"));

        renderer.setOpenIcon(new ImageIcon("swing\\img\\tree\\open.gif"));

        renderer.setTextNonSelectionColor(new Color(255,0,0));

        renderer.setTextSelectionColor(new Color(0,0,255));


        tree.setCellRenderer(renderer);

        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new ChangeAllCellRender().init();
    }
}
