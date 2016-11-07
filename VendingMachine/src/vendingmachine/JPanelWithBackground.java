//this is used to display a vending machine image
package vendingmachine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelWithBackground extends JPanel {

    private Image img;

    public JPanelWithBackground(String img) //accept a String path to set img
    {
        this(new ImageIcon(img).getImage()); //use this for constructor 2's Image argument
    }

    public JPanelWithBackground(Image img) {    //constructor 2
        this.img = img;
        repaint();
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override ///this part's good 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}