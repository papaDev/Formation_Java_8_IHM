package fr.openclassroom.interfacesdetableaux.JTable;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    private JTable tableau;
    private JButton change = new JButton("Changer la taille");
    // Contenu de notre combo
    private String[] comboData = {"Très bien", "Bien", "Mal"};

    public Fenetre(){
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTable");
        this.setSize(600, 180);

        // Données de notre tableau
        Object[][] data = {
                {"Cysboy", "6boy", comboData[0], new Boolean(true)},
                {"BZHHydde", "BZH", comboData[0], new Boolean(false)},
                {"IamBow", "BoW", comboData[0], new Boolean(false)},
                {"FunMan", "Year", comboData[0], new Boolean(true)}
        };

        String  title[] = {"Pseudo", "Age", "Taille", "OK ?"};
        // Combo à utiliser
        JComboBox combo = new JComboBox(comboData);

        this.tableau = new JTable(data, title);
        this.tableau.setRowHeight(30);
        this.tableau.getColumn("Age").setCellRenderer(new ButtonRenderer());
        this.tableau.getColumn("Age").setCellEditor(new ButtonEditor(new JCheckBox()));
        // On définit l'éditeur par défaut pour la cellule en lui spécifiant quel tupe d'affichage prendre en compte
        this.tableau.getColumn("Taille").setCellEditor(new DefaultCellEditor(combo));
        this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

    }
    public static void main(String[] args){
        Fenetre fen = new Fenetre();
        fen.setVisible(true);
    }
}