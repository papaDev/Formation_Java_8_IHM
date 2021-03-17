package fr.openclassroom.formulaire.KeyListener.Controle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Fenetre extends JFrame {

    private JPanel container = new JPanel();
    private JTextField jtf;
    private JLabel label = new JLabel("Téléphone FR");
    private JButton b = new JButton("OK");

    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());

        jtf = new JTextField();
        JPanel top = new JPanel();

        Font police = new Font("Arial", Font.BOLD, 14);
        jtf.setFont(police);
        jtf.setPreferredSize(new Dimension(150, 30));
        jtf.setForeground(Color.BLUE);
        // On ajoute l'écouteur à notre composant
        jtf.addKeyListener(new ClavierListener());

        top.add(label);
        top.add(jtf);
        top.add(b);

        this.setContentPane(top);
        this.setVisible(true);
    }

    class ClavierListener implements KeyListener {

        public void keyReleased(KeyEvent event) {
            if(!isNumeric(event.getKeyChar()))
                jtf.setText(jtf.getText().replace(String.valueOf(event.getKeyChar()),""));
        }

        public void keyPressed(KeyEvent event) {}
        public void keyTyped(KeyEvent event) {}

        // Retourne true si le paramètre est numérique, false dans le cas contraire
        private boolean isNumeric(char carac) {
            try {
                Integer.parseInt(String.valueOf(carac));
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }

    }
}
