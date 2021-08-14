package basic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JFileChooserDemo {

    JFrame jf = new JFrame("JFileChooser Demonstration");
    JMenuBar jmb = new JMenuBar();
    JMenu jMenu = new JMenu("File");

    JMenuItem open = new JMenuItem(new AbstractAction("Open") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // show file chooser
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.showOpenDialog(jf);

            // get selected file
            File file = fileChooser.getSelectedFile();

            // display the file
            try {
                image = ImageIO.read(file);
                drawArea.repaint();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    });

    JMenuItem save = new JMenuItem(new AbstractAction("Save As") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // show file chooser
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.showSaveDialog(jf);

            // get directory
            File file = fileChooser.getSelectedFile();

            try {
                ImageIO.write(image,"jpeg",file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    });

    BufferedImage image;

    // Component provided by swing, using BufferedImage
    private class MyCanvas extends JPanel{
        @Override
        public void paint(Graphics g) {
            g.drawImage(image,0,0,null);
        }
    }

    MyCanvas drawArea = new MyCanvas();

    public void init(){
        // Construct View
        jMenu.add(open);
        jMenu.add(save);

        jmb.add(jMenu);

        jf.setJMenuBar(jmb);

        drawArea.setPreferredSize(new Dimension(740,500));
        jf.add(drawArea);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JFileChooserDemo().init();
    }
}
