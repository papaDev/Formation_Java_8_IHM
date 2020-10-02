package fr.openclassroom.boutons.gridlayout;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Fenetre extends JFrame{

    public Fenetre(){
        this.setTitle("Bouton");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //On définit le layout à utiliser sur le content pane
        //Trois lignes sur deux colonnes
        this.setLayout(new GridLayout(3, 2));


        /*
            Il est également possible de définir le nombre de lignes et de colonnes en utilsant ces méthodes
         */
        /*
        GridLayout g1 = new GridLayout();
        g1.setColumns(2);
        g1.setRows(3);
        this.setLayout(g1);
        */
        /*
            Ajouter de l'espace entre les colonnes et les lignes
         *//*
        g1.setHgap(5); // Cinq pixels d'espace entre les colonnes (H comme Horizontal)
        g1.setVgap(5); // Cinq pixels d'espace entre les lignes (V comme Vertical)
        // Ou en abrégé : GridLayout g1 = new GridLayout(3, 2, 5, 5);
        */

        //On ajoute le bouton au content pane de la JFrame
        this.getContentPane().add(new JButton("1"));
        this.getContentPane().add(new JButton("2"));
        this.getContentPane().add(new JButton("3"));
        this.getContentPane().add(new JButton("4"));
        this.getContentPane().add(new JButton("5"));
        this.setVisible(true);
    }

}