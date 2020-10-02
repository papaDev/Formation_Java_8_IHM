package fr.openclassroom.animation;

import javax.swing.JFrame;

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
        for(int i = -50; i < pan.getWidth(); i++) {
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
        }
    }

}
