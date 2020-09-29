package fr.openclassroom.drawrect;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {

    public void paintComponent(Graphics g){
        g.drawRect(10, 10, 50, 60);
        g.fillRect(65, 65, 30, 40);
    }
}
