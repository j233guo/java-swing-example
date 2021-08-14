package tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTree {
    JFrame jf = new JFrame("Editing Tree");

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    JButton addSiblingBtn = new JButton("Add sibling node");
    JButton addChildBtn = new JButton("Add child node");
    JButton deleteBtn = new JButton("Delete node");
    JButton editBtn = new JButton("Edit current node");

    public void init() {

        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        JTree tree = new JTree(root);

        // Complete the edit
        tree.setEditable(true);
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

        // Add sibling
        addSiblingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //1.Select the current node
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode == null) {
                    return;
                }

                //2.Get the parent of current node
                DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
                if (parentNode == null) {
                    return;
                }

                //3.Create new node
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新结点");

                //4. Add the new node to the parent
                int index = parentNode.getIndex(selectedNode);
                model.insertNodeInto(newNode, parentNode, index);

                // 5.display the new node
                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                tree.scrollPathToVisible(treePath);

                //6.update tree
                tree.updateUI();
            }
        });

        // Add child node
        addChildBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //1. Select the node
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode == null) {
                    return;
                }
                //2.Create new node
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新结点");

                //3.Add the new node
                selectedNode.add(newNode);

                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                tree.scrollPathToVisible(treePath);

                tree.updateUI();
            }
        });

        // Delete node
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (selectedNode != null && selectedNode.getParent() != null) {
                    model.removeNodeFromParent(selectedNode);
                }

            }
        });

        // Edit node
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get path
                TreePath selectionPath = tree.getSelectionPath();

                if (selectionPath != null) {
                    tree.startEditingAtPath(selectionPath);
                }
            }
        });

        jf.add(new JScrollPane(tree));

        JPanel panel = new JPanel();
        panel.add(addSiblingBtn);
        panel.add(addChildBtn);
        panel.add(deleteBtn);
        panel.add(editBtn);

        jf.add(panel, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new EditTree().init();
    }
}