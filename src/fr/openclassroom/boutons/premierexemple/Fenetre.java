package fr.openclassroom.boutons.premierexemple;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

    private JPanel pan = new JPanel();
    // Possibilité 1 : instanciation avec le libellé
    private JButton bouton = new JButton("Mon bouton");

    // Possiblité 2 : instanciation puis définition du libellé
    //JButton bouton2 = new JButton();
    //bouton2.setText("Mon deuxième bouton");

    public Fenetre() {
        this.setTitle("Bouton");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // Ajout du bouton à notre content pane
        pan.add(bouton);
        this.setContentPane(pan);
        this.setVisible(true);
    }

}