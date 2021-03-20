package fr.openclassroom.menusetboitesdedialogue.boitedesaisie.boitededialogperso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    private JButton bouton = new JButton("Appel à la ZDialog");

    public Fenetre() {
        this.setTitle("Ma JFrame");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(bouton);
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ZDialog zd = new ZDialog(null, "Coucou les Zéros", true);
            }
        });
        this.setVisible(true);
    }
}
