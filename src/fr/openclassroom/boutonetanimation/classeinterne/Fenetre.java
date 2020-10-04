package fr.openclassroom.boutonetanimation.classeinterne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    private Panneau pan = new Panneau();
    private JButton bouton = new JButton("bouton 1");
    private JButton bouton2 = new JButton("bouton 2");
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Le JLabel");
    private int compteur = 0;

    public Fenetre() {
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.add(pan, BorderLayout.CENTER);

        // Première classe écoutant mon premier bouton
        bouton.addActionListener(new BoutonListener());
        // Deuxième classe écoutant mon premier bouton
        bouton.addActionListener(new Bouton3Listener());


        bouton2.addActionListener(new Bouton2Listener());

        JPanel south = new JPanel();
        south.add(bouton);
        south.add(bouton2);
        container.add(south, BorderLayout.SOUTH);

        Font police = new Font("Tahoma", Font.BOLD, 16);
        label.setFont(police);
        label.setForeground(Color.blue);
        label.setHorizontalAlignment(JLabel.CENTER);
        container.add(label, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
        go();
    }

    private void go() {
        // Les coordonnées de départ de notre rond
        int x = pan.getPosX(), y = pan.getPosY();
        // Le booléen pour savoir si l'on recule ou non sur l'axe x
        boolean backX = false;
        // Le booléen pour savoir si l'on recule ou non sur l'axe y
        boolean backY = false;

        // Dans cet exemple, j'utilise une boucle while
        // Vous verrez qu'elle fonctionne très bien
        while(true) {
            // Si la coordonnée x est inférieure à 1, on avance
            if(x < 1)
                backX = false;

            // Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
            if(x > pan.getWidth() - 50)
                backX = true;

            // Idem pour l'axe y
            if(y < 1)
                backY = false;
            if(y > pan.getHeight() - 50)
                backY = true;

            // Si on avance, on incrémente la coordonnée backX est un booléen, donc !backX revient à écrire
            // if(backX == false)
            if(!backX)
                pan.setPosX(++x);
            // Sinon, on décrémente
            else
                pan.setPosX(--x);

            // Idem pour l'axe Y
            if(!backY)
                pan.setPosY(++y);
            else
                pan.setPosY(--y);

            // On redessine notre Panneau
            pan.repaint();

            // Comme on dit : la pause s'impose ! Ici, trois milièmes de seconde
            try{
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // Classe écoutant notre premier bouton
    class BoutonListener implements ActionListener {
        // Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            label.setText("Vous avez cliqué sur le bouton 1");
        }
    }

    // Classe écoutant notre second bouton
    class Bouton2Listener implements ActionListener {
        // Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            label.setText("Vous avez cliqué sur le bouton 2");
        }
    }

    // Classe écoutant notre second bouton
    class Bouton3Listener implements ActionListener {
        // Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            System.out.println("Ma classe interne numéro 3 écoute bien !");
        }
    }
}
