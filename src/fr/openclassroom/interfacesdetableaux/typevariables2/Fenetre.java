package fr.openclassroom.interfacesdetableaux.typevariables2;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
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

        ZModel model = new ZModel(data, title);
        System.out.println("Nombre de colonne : " + model.getColumnCount());
        System.out.println("Nombre de ligne : " + model.getRowCount());
        this.tableau = new JTable(model);
        this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
    }

    //Classe modèle personnalisée
    class ZModel extends AbstractTableModel {
        private Object[][] data;
        private String[] title;

        //Constructeur
        public ZModel(Object[][] data, String[] title){
            this.data = data;
            this.title = title;
        }

        //Retourne le nombre de colonnes
        public int getColumnCount() {
            return this.title.length;
        }

        //Retourne le nombre de lignes
        public int getRowCount() {
            return this.data.length;
        }

        //Retourne la valeur à l'emplacement spécifié
        public Object getValueAt(int row, int col) {
            return this.data[row][col];
        }

        /**
         * Retourne le titre de la colonne à l'indice spécifié
         */
        public String getColumnName(int col) {
            return this.title[col];
        }

        //Retourne la classe de la donnée de la colonne
        public Class getColumnClass(int col){
            //On retourne le type de la cellule à la colonne demandée
            //On se moque de la ligne puisque les types de données sont les mêmes quelle que soit la ligne
            //On choisit donc la première ligne
            return this.data[0][col].getClass();
        }

        //Retourne vrai si la cellule est éditable : celle-ci sera donc éditable
        public boolean isCellEditable(int row, int col){
            //On appelle la méthode getValueAt qui retourne la valeur d'une cellule
            //Et on effectue un traitement spécifique si c'est un JButton
            if(getValueAt(0, col) instanceof JButton)
                return false;
            return true;
        }

    }

    public static void main(String[] args){
        Fenetre fen = new Fenetre();
        fen.setVisible(true);
    }
}
