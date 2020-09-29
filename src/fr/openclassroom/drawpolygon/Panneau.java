package fr.openclassroom.drawpolygon;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {

    public void paintComponent(Graphics g){
        int x[] = {20, 30, 50, 60, 60, 50, 30, 20};
        int y[] = {30, 20, 20, 30, 50, 60, 60, 50};
        g.drawPolygon(x, y, 8);

        int x2[] = {50, 60, 80, 90, 90, 80, 60, 50};
        int y2[] = {60, 50, 50, 60, 80, 90, 90, 80};
        g.fillPolygon(x2, y2, 8);

        int x3[] = {90, 100, 110, 120, 120, 110, 100, 90};
        int y3[] = {100, 90, 90, 100, 120, 130, 130, 120};
        g.drawPolyline(x3, y3, 8);
    }
}
