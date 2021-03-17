package fr.openclassroom.formulaire.JTextField.simple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JTextField jtf = new JTextField("Valeur par défaut");
    private JLabel label = new JLabel("Un JTextField");

    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        Font police = new Font("Arial", Font.BOLD, 14);
        jtf.setFont(police);
        jtf.setPreferredSize(new Dimension(150, 30));
        jtf.setForeground(Color.BLUE);
        top.add(label);
        top.add(jtf);
        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    }

    class StateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("source : " + ((JCheckBox)e.getSource()).getText() + " - état : " +
                    ((JCheckBox)e.getSource()).isSelected());
        }
    }
}
