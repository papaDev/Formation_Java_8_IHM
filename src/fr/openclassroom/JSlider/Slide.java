package fr.openclassroom.JSlider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Slide extends JFrame {
    private JLabel label = new JLabel("Valeur actuelle : 30");
    public Slide(){
        this.setSize(250, 150);
        this.setTitle("Slider");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSlider slide = new JSlider();

        slide.setMaximum(100);
        slide.setMinimum(0);
        slide.setValue(30);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        slide.setMinorTickSpacing(10);
        slide.setMajorTickSpacing(20);
        slide.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent event){
                label.setText("Valeur actuelle : " + ((JSlider)event.getSource()).getValue());
            }
        });
        this.getContentPane().add(slide, BorderLayout.CENTER);
        this.getContentPane().add(label, BorderLayout.SOUTH);
    }
    public static void main(String[] args){
        Slide slide = new Slide();
        slide.setVisible(true);
    }
}