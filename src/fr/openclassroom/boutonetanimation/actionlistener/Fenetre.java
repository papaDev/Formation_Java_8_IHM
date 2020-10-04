package fr.openclassroom.boutonetanimation.actionlistener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame implements ActionListener {

    private Panneau pan = new Panneau();
    private Bouton bouton = new Bouton("mon bouton");
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Le JLabel");
    // Compteur de clics
    private int compteur = 0;

    public Fenetre() {
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.add(pan, BorderLayout.CENTER);

        // Nous ajoutons notre fenêtre à la liste des auditeurs de notre bouton
        bouton.addActionListener(this);

        container.add(bouton, BorderLayout.SOUTH);

        // Définition d'une police d'écriture
        Font police = new Font("Tahoma", Font.BOLD, 16);
        // On l'applique au JLabel
        label.setFont(police);
        // Changement de la couleur du texte
        label.setForeground(Color.blue);
        // On modifie l'alignement du texte grâce aux attributs statiques de la classe JLabel
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

    // Méthode qui sera appalée lors d'un clic sur le bouton
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // Lorsque l'on clique sur le bouton, on met à jour le JLabel
        this.compteur++;
        label.setText("Vous avez cliqué " + this.compteur + " fois");
    }
}
