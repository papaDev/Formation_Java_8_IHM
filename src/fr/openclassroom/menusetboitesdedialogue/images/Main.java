package fr.openclassroom.menusetboitesdedialogue.images;


import javax.swing.*;

public class Main {

    public static void main(String[] args){

        JOptionPane jop1, jop2, jop3;
        jop1 = new JOptionPane();
        ImageIcon img = new ImageIcon("images/informations.png");
        jop1.showMessageDialog(null, "Message informatif", "Information",
                JOptionPane.INFORMATION_MESSAGE, img);
        jop2 = new JOptionPane();
        img = new ImageIcon("images/warning.png");
        jop2.showMessageDialog(null, "Message préventif", "Attention",
                JOptionPane.WARNING_MESSAGE, img);
        jop3 = new JOptionPane();
        img = new ImageIcon("images/erreur.png");
        jop3.showMessageDialog(null, "Message d'erreur", "Erreur",
                JOptionPane.ERROR_MESSAGE, img);

    }
}
