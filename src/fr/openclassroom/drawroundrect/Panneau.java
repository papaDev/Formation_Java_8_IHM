package fr.openclassroom.drawroundrect;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {

    public void paintComponent(Graphics g){
        // x1, y1, width, height, arcWidth, arcHeight
        g.drawRoundRect(10, 10, 30, 50, 10, 10);
        g.fillRoundRect(55, 65, 55, 30, 5, 5);
    }
}
