package fr.openclassroom.interfacesdetableaux.typevariables;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    private JTable tableau;
    private JButton change = new JButton("Changer la taille");

    public Fenetre(){
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTable");
        this.setSize(600, 140);

        Object[][] data = {
                {"Cysboy", new JButton("6boy"), new Double(1.80), new Boolean(true)},
                {"BZHHydde", new JButton("BZH"), new Double(1.78), new Boolean(false)},
                {"IamBow", new JButton("BoW"), new Double(1.90), new Boolean(false)},
                {"FunMan", new JButton("Year"), new Double(1.85), new Boolean(true)}
        };

        String  title[] = {"Pseudo", "Age", "Taille", "OK ?"};
        this.tableau = new JTable(data, title);
        this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
    }

    public static void main(String[] args){
        Fenetre fen = new Fenetre();
        fen.setVisible(true);
    }
}
