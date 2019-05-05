package controlescolar.view.components;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PanelBackgroundImage extends JPanel {

    private URL url = getClass().getResource("fondo_login.jpg");
    Image image = new ImageIcon(url).getImage();

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0,0, 1100, 700, this);
        setOpaque(false);
        super.paint(g);
    }
}
