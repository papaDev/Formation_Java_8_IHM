package fr.openclassroom.boutons.flowlayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{

    private JPanel pan = new JPanel();
    private JButton bouton1 = new JButton("bouton 1");
    private JButton bouton2 = new JButton("bouton 2");
    private JButton bouton3 = new JButton("bouton 3");
    private JButton bouton4 = new JButton("bouton 4");
    private JButton bouton5 = new JButton("bouton 5");

    public Fenetre(){
        this.setTitle("FlowLayout");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //Ajout du bouton à notre content pane
        pan.add(bouton1);
        pan.add(bouton2);
        pan.add(bouton3);
        pan.add(bouton4);
        pan.add(bouton5);
        this.setContentPane(pan);
        this.setVisible(true);
    }
}