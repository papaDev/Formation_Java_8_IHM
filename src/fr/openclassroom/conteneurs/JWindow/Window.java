package fr.openclassroom.conteneurs.JWindow;

import javax.swing.*;
import java.awt.*;

public class Window extends JWindow {

    public static void main(String[] args){
        Window wind = new Window();
        wind.setVisible(true);
    }

    public Window(){
        setSize(220, 165);
        setLocationRelativeTo(null);
        JPanel pan = new JPanel();
        JLabel img = new JLabel(new ImageIcon("planète.jpeg"));
        img.setVerticalAlignment(JLabel.CENTER);
        img.setHorizontalAlignment(JLabel.CENTER);
        pan.setBorder(BorderFactory.createLineBorder(Color.blue));
        pan.add(img);
        getContentPane().add(pan);
    }
}