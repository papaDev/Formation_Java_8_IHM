package fr.openclassroom.drawline;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {

    public void paintComponent(Graphics g){
        // x1, y1, width, height, arcWidth, arcHeight
        g.drawLine(0, 0, this.getWidth(), this.getHeight());
        g.drawLine(0, this.getHeight(), this.getWidth(), 0);
    }
}
