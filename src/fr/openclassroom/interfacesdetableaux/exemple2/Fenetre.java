package fr.openclassroom.interfacesdetableaux.exemple2;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    private JTable tableau;
    private JButton change = new JButton("Changer la taille");

    public Fenetre(){
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTable");
        this.setSize(600, 180);

        Object[][] data = {
                {"Cysboy", "6boy", "Combo", new Boolean(true)},
                {"BZHHydde", "BZH", "Combo", new Boolean(false)},
                {"IamBow", "BoW", "Combo", new Boolean(false)},
                {"FunMan", "Year", "Combo", new Boolean(true)}
        };

        String  title[] = {"Pseudo", "Age", "Taille", "OK ?"};

        this.tableau = new JTable(data, title);
        this.tableau.setRowHeight(30);
        this.tableau.getColumn("Age").setCellRenderer(new ButtonRenderer());
        this.tableau.getColumn("Taille").setCellRenderer(new ComboRenderer());
        this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

    }
    public static void main(String[] args){
        Fenetre fen = new Fenetre();
        fen.setVisible(true);
    }
}