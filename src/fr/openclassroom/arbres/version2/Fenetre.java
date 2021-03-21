package fr.openclassroom.arbres.version2;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Fenetre extends JFrame {
    private JTree arbre;
    public Fenetre(){
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Les arbres");
        //On invoque la méthode de construction de notre arbre
        buildTree();

        this.setVisible(true);
    }

    private void buildTree(){
        //Création d'une racine
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Racine");

        //Nous allons ajouter des branches et des feuilles à notre racine
        for(int i = 1; i < 6; i++){
            DefaultMutableTreeNode rep = new DefaultMutableTreeNode("Noeud n°"+i);

            //On rajoute 4 branches
            if(i < 4){
                DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode("Fichier enfant");
                rep.add(rep2);
            }
            //On ajoute la feuille ou la branche à la racine
            racine.add(rep);
        }
        //Nous créons, avec notre hiérarchie, un arbre
        arbre = new JTree(racine);

        //Que nous plaçons sur le ContentPane de notre JFrame à l'aide d'un scroll
        this.getContentPane().add(new JScrollPane(arbre));
    }

    public static void main(String[] args){
        Fenetre fen = new Fenetre();
    }
}
