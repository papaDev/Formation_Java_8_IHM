package fr.openclassroom.graphics2d.gradientpaint;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {

    public void paintComponent(Graphics g){

       Graphics2D g2d = (Graphics2D)g;

        // Dégradé oblique répété
        /*
        GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 30, Color.cyan, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        */

        // Dégradé oblique stoppé
        /*
        GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 30, Color.cyan, false);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        */

        // Dégradé horizontal arc-en-ciel
        GradientPaint gp, gp2, gp3, gp4, gp5, gp6;
        gp = new GradientPaint(0, 0, Color.RED, 20, 0, Color.magenta, true);
        gp2 = new GradientPaint(20, 0, Color.magenta, 40, 0, Color.blue, true);
        gp3 = new GradientPaint(40, 0, Color.blue, 60, 0, Color.green, true);
        gp4 = new GradientPaint(60, 0, Color.green, 80, 0, Color.yellow, true);
        gp5 = new GradientPaint(80, 0, Color.yellow, 100, 0, Color.orange, true);
        gp6 = new GradientPaint(100, 0, Color.orange, 120, 0, Color.red, true);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, 20, this.getHeight());
        g2d.setPaint(gp2);
        g2d.fillRect(20, 0, 20, this.getHeight());
        g2d.setPaint(gp3);
        g2d.fillRect(40, 0, 20, this.getHeight());
        g2d.setPaint(gp4);
        g2d.fillRect(60, 0, 20, this.getHeight());
        g2d.setPaint(gp5);
        g2d.fillRect(80, 0, 20, this.getHeight());
        g2d.setPaint(gp6);
        g2d.fillRect(100, 0, 20, this.getHeight());
    }
}
