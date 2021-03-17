package fr.openclassroom.formulaire.JFormattedTextField.MaskFormatter;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;

public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JFormattedTextField jtf = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JFormattedTextField jtf2 = new JFormattedTextField(NumberFormat.getPercentInstance());
    private JLabel label = new JLabel("Téléphone FR");
    private JLabel label2 = new JLabel("Téléphone USA");
    private JButton b = new JButton("OK");

    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());

        try{
            MaskFormatter tel = new MaskFormatter("## ## ## ## ##");
            // Ou encore
            MaskFormatter tel2 = new MaskFormatter("##-##-##-##-##");
            // Vous pouvez ensuite le passer a votre zone de texte
            jtf = new JFormattedTextField(tel2);
        } catch(ParseException e) {
            e.printStackTrace();
        }

        JPanel top = new JPanel();
        Font police = new Font("Arial", Font.BOLD, 14);
        jtf.setFont(police);
        jtf.setPreferredSize(new Dimension(150, 30));
        jtf.setForeground(Color.BLUE);
        jtf2.setPreferredSize(new Dimension(150, 30));
        b.addActionListener(new BoutonListener());
        top.add(label);
        top.add(jtf);
        top.add(label2);
        top.add(jtf2);
        top.add(b);
        this.setContentPane(top);
        this.setVisible(true);
    }

    class BoutonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("TEXT : jtf " + jtf.getText());
            System.out.println("TEXT : jtf2 " + jtf2.getText());
        }
    }
}
