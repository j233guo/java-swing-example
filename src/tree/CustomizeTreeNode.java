package tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class CustomizeTreeNode {
    JFrame jf = new JFrame("Customize tree node");

    JTree tree;

    DefaultMutableTreeNode friends = new DefaultMutableTreeNode("Friend List");
    DefaultMutableTreeNode qingzhao = new DefaultMutableTreeNode("李清照");
    DefaultMutableTreeNode suge = new DefaultMutableTreeNode("苏格拉底");
    DefaultMutableTreeNode libai = new DefaultMutableTreeNode("李白");
    DefaultMutableTreeNode nongyu = new DefaultMutableTreeNode("弄玉");
    DefaultMutableTreeNode hutou = new DefaultMutableTreeNode("虎头");

    public void init() {
        friends.add(qingzhao);
        friends.add(suge);
        friends.add(libai);
        friends.add(nongyu);
        friends.add(hutou);

        tree = new JTree(friends);

        //TODO Node renderer
        MyRenderer renderer = new MyRenderer();
        tree.setCellRenderer(renderer);

        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    // implement TreeCellRenderer
    private class MyRenderer extends JPanel implements TreeCellRenderer {
        private ImageIcon icon;
        private String name;
        private Color background;
        private Color foreground;

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //给成员变量设置值
            this.icon = new ImageIcon("img/tree/"+value.toString()+".gif");
            this.name = value.toString();

            this.background = hasFocus? new Color(144,200,225) : new Color(255,255,255);
            this.foreground = hasFocus? new Color(255,255,3) : new Color(0,0,0);

            return this;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(80,80);
        }

        @Override
        public void paint(Graphics g) {
            int iconWidth = this.icon.getIconWidth();
            int iconHeight = this.icon.getIconHeight();

            g.setColor(background);
            g.fillRect(0,0,getWidth(),getHeight());

            g.drawImage(this.icon.getImage(),getWidth()/2 - iconWidth/2,10,null);

            g.setColor(foreground);

            g.setFont(new Font("StSong",Font.BOLD,18));
            g.drawString(this.name,getWidth()/2-this.name.length()*20/2,iconHeight+30);
        }
    }

    public static void main(String[] args) {
        new CustomizeTreeNode().init();
    }

}
