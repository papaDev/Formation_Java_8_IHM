package fr.openclassroom.conteneurs.removeOnglet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {
    private JTabbedPane onglet;
    //Compteur pour le nombre d'onglets
    private int nbreTab = 0;

    public Fenetre(){
        this.setLocationRelativeTo(null);
        this.setTitle("Gérer vos conteneurs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);

        //Création de plusieurs Panneau
        Panneau[] tPan = {   new Panneau(Color.RED), new Panneau(Color.GREEN), new Panneau(Color.BLUE)};

        //Création de notre conteneur d'onglets
        onglet = new JTabbedPane();
        for(Panneau pan : tPan){
            //Méthode d'ajout d'onglets
            onglet.addTab("Onglet N°"+(++nbreTab), pan);
        }
        //On passe ensuite les onglets au content pane
        this.getContentPane().add(onglet, BorderLayout.CENTER);

        //Ajout du bouton pour ajouter des onglets
        JButton nouveau = new JButton("Ajouter un onglet");
        nouveau.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onglet.add("Onglet N°"+(++nbreTab), new Panneau(Color.DARK_GRAY));
            }
        });

        //Ajout du bouton pour retirer l'onglet sélectionné
        JButton delete = new JButton("Effacer l'onglet");
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //On récupère l'index de l'onglet sélectionné
                int selected = onglet.getSelectedIndex();
                //S'il n'y a plus d'onglet, la méthode ci-dessus retourne -1
                if(selected > -1)onglet.remove(selected);
            }
        });

        JPanel pan = new JPanel();
        pan.add(nouveau);
        pan.add(delete);

        this.getContentPane().add(pan, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args){
        Fenetre fen = new Fenetre();
    }
}