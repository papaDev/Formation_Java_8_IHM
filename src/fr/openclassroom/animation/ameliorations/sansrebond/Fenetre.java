package fr.openclassroom.animation.ameliorations.sansrebond;

import javax.swing.*;

public class Fenetre extends JFrame {

    private Panneau pan = new Panneau();

    public Fenetre() {
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan);
        this.setVisible(true);
        go();
    }

    private void go() {
        // Boucle infini
        for(;;) {
            int x = pan.getPosX(), y = pan.getPosY();
            x++;
            y++;
            pan.setPosX(x);
            pan.setPosY(y);
            pan.repaint();
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Si nos coordinnées arrivent au bord de notre composant
            // On réinitialise
            if(x == pan.getWidth() || y == pan.getHeight()) {
                pan.setPosX(-50);
                pan.setPosY(-50);
            }
        }
    }

}
