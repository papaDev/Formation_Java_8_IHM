package fr.openclassroom.arbres.TreeModelListener;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;

//CTRL + SHIFT + O pour générer les imports nécessaires
public class Fenetre extends JFrame {

    private JTree arbre;
    private DefaultMutableTreeNode racine;
    //Notre objet modèle
    private DefaultTreeModel model;
    public Fenetre(){
        this.setSize(200, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree");
        listRoot();
        this.setVisible(true);
    }

    private void listRoot(){
        this.racine = new DefaultMutableTreeNode();
        int count = 0;
        for(File file : File.listRoots())
        {
            DefaultMutableTreeNode lecteur = new DefaultMutableTreeNode(file.getAbsolutePath());
            try {
                for(File nom : file.listFiles()){
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(nom.getName()+"\\");
                    lecteur.add(this.listFile(nom, node));
                }
            } catch (NullPointerException e) {}
            this.racine.add(lecteur);
        }

        //Nous créons notre modèle
        this.model = new DefaultTreeModel(this.racine);
        //Et nous allons écouter ce que notre modèle a à nous dire !
        this.model.addTreeModelListener(new TreeModelListener() {
            /**
             * Méthode appelée lorsqu'un noeud a changé
             */
            public void treeNodesChanged(TreeModelEvent evt) {
                System.out.println("Changement dans l'arbre");
                Object[] listNoeuds = evt.getChildren();
                int[] listIndices = evt.getChildIndices();
                for (int i = 0; i < listNoeuds.length; i++) {
                    System.out.println("Index " + listIndices[i] + ", nouvelle valeur :" + listNoeuds[i]);
                }
            }

            /**
             * Méthode appelée lorsqu'un noeud est inséré
             */
            public void treeNodesInserted(TreeModelEvent event) {
                System.out.println("Un noeud a été inséré !");
            }

            /**
             * Méthode appelée lorsqu'un noeud est supprimé
             */
            public void treeNodesRemoved(TreeModelEvent event) {
                System.out.println("Un noeud a été retiré !");
            }

            /**
             * Méthode appelée lorsque la structure d'un noeud a été modifiée
             */
            public void treeStructureChanged(TreeModelEvent event) {
                System.out.println("La structure d'un noeud a changé !");
            }
        });

        //Nous créons, avec notre hiérarchie, un arbre
        arbre = new JTree();
        //Nous passons notre modèle à notre arbre
        //==> On pouvait aussi passer l'objet TreeModel au constructeur du JTree
        arbre.setModel(model);
        arbre.setRootVisible(false);
        //On rend notre arbre éditable
        arbre.setEditable(true);
        this.getContentPane().add(new JScrollPane(arbre), BorderLayout.CENTER);
    }

    private DefaultMutableTreeNode listFile(File file, DefaultMutableTreeNode node){
        int count = 0;

        if(file.isFile())
            return new DefaultMutableTreeNode(file.getName());
        else{
            File[] list = file.listFiles();
            if(list == null)
                return new DefaultMutableTreeNode(file.getName());

            for(File nom : list){
                count++;
                //Pas plus de 5 enfants par noeud
                if(count < 3){
                    DefaultMutableTreeNode subNode;
                    if(nom.isDirectory()){
                        subNode = new DefaultMutableTreeNode(nom.getName()+"\\");
                        node.add(this.listFile(nom, subNode));
                    }else{
                        subNode = new DefaultMutableTreeNode(nom.getName());
                    }
                    node.add(subNode);
                }
            }
            return node;
        }
    }

    public static void main(String[] args){
        //Nous allons créer des fenêtres avec des looks différents
        //Cette instruction permet de récupérer tous les looks du système

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (InstantiationException e) {}
        catch (ClassNotFoundException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        catch (IllegalAccessException e) {}
        Fenetre fen = new Fenetre();
    }
}