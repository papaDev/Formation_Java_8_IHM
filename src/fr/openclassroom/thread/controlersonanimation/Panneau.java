package fr.openclassroom.thread.controlersonanimation;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {

    private int posX = -50;
    private int posY = -50;

    public void paintComponent(Graphics g) {
        // On choisit une couleur de fond pour le rectangle
        g.setColor(Color.white);
        // On le dessine de sorte qu'il occupe toute la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        // On redéfinit une couleur pour le rond
        g.setColor(Color.red);
        // On le dessine aux coordonnées souhaitées
        g.fillOval(posX, posY, 50, 50);
        // Affichage dans la console qui montre les coordonnées du rond
        // System.out.println("posX " + posX + " posY " + posY);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

}
