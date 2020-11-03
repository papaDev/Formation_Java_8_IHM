package fr.openclassroom.formulaire.jcombobox.actionlistener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Fenetre extends JFrame {

    private JPanel container = new JPanel();
    private JComboBox combo;
    private JLabel label = new JLabel("Une ComboBox");

    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());

        // Ici, nous changeons juste la façon d'initialiser la JComboBox
        String[] tab = {"Option 1", "Option 2", "Option 3", "Option 4"};
        combo = new JComboBox(tab);

        // Ajout du listener
        combo.addItemListener(new ItemState());
        combo.addActionListener(new ItemAction());
        combo.setPreferredSize(new Dimension(100, 20));
        combo.setForeground(Color.blue);

        JPanel top = new JPanel();
        top.add(label);
        top.add(combo);
        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    }

    // Classe interne implémentant l'interface ItemListener
    class ItemState implements ItemListener {
        public void itemStateChanged(ItemEvent e){
            System.out.println("événement déclenché sur : " + e.getItem());
        }
    }

    class ItemAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("ActionListener : action sur " + combo.getSelectedItem());
        }
    }
}
