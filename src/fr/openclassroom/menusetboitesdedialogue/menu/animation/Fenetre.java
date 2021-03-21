package fr.openclassroom.menusetboitesdedialogue.menu.animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class Fenetre extends JFrame {

    private Panneau pan = new Panneau();
    private JPanel container = new JPanel();
    private int compteur = 0;
    private boolean animated = true;
    private boolean backX, backY;
    private int x, y;
    private Thread t;

    private JMenuBar menuBar = new JMenuBar();

    private JMenu animation = new JMenu("Animation"),
        forme = new JMenu("Forme"),
        typeForme = new JMenu("Type de forme"),
        aPropos = new JMenu("A propos");

    private JMenuItem lancer = new JMenuItem("Lancer l'animation"),
        arreter = new JMenuItem("Arrêter l'animation"),
        quitter = new JMenuItem("Quitter"),
        aProposItem = new JMenuItem("?");

    private JCheckBoxMenuItem morph = new JCheckBoxMenuItem("Morphing");
    private JRadioButtonMenuItem carre = new JRadioButtonMenuItem("Carré"),
        rond = new JRadioButtonMenuItem("Rond"),
        triangle = new JRadioButtonMenuItem("Triangle"),
        etoile = new JRadioButtonMenuItem("Etoile");

    private ButtonGroup bg = new ButtonGroup();

    // La déclaration pour le menu contextuel
    private JPopupMenu jpm = new JPopupMenu();
    private JMenu background = new JMenu("Couleur de fond");
    private JMenu couleur = new JMenu("Couleur de la forme");

    private JMenuItem launch = new JMenuItem("Lancer l'animation");
    private JMenuItem stop = new JMenuItem("Arrêter l'animation");
    private JMenuItem rouge = new JMenuItem("Rouge"),
        bleu = new JMenuItem("Bleu"),
        vert = new JMenuItem("Vert"),
        blanc = new JMenuItem("blanc"),
        rougeBack = new JMenuItem("Rouge"),
        bleuBack = new JMenuItem("Bleu"),
        vertBack = new JMenuItem("Vert"),
        blancBack = new JMenuItem("Blanc");

    // On crée des listeners globaux
    private StopAnimationListener stopAnimation = new StopAnimationListener();
    private StartAnimationListener startAnimation = new StartAnimationListener();
    // Avec des listeners pour les couleurs
    private CouleurFondListener bgColor = new CouleurFondListener();
    private CouleurFormeListener frmColor = new CouleurFormeListener();

    // Création de notre barre d'outils
    private JToolBar toolBar = new JToolBar();

    // Les boutons de la barre d'outils
    private JButton play = new JButton(new ImageIcon("images/play.jpg")),
        cancel = new JButton(new ImageIcon("images/stop.jpg")),
        square = new JButton(new ImageIcon("images/carre.jpg")),
        tri = new JButton(new ImageIcon("images/triangle.jpg")),
        circle = new JButton(new ImageIcon("images/rond.jpg")),
        star = new JButton(new ImageIcon("images/etoile.jpg"));

    private Color fondBouton = Color.white;
    private FormeListener fListener = new FormeListener();

    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());

        // On initialise le menu stop
        stop.setEnabled(false);
        // On affecte les écouteurs
        stop.addActionListener(stopAnimation);
        launch.addActionListener(startAnimation);

        // On affecte les écouteurs aux points de menu
        rouge.addActionListener(frmColor);
        bleu.addActionListener(frmColor);
        vert.addActionListener(frmColor);
        blanc.addActionListener(frmColor);

        rougeBack.addActionListener(bgColor);
        bleuBack.addActionListener(bgColor);
        vertBack.addActionListener(bgColor);
        blancBack.addActionListener(bgColor);

        // On crée et on passe l'écouteur pour afficher le menu contextuel
        // Création d'une implémentation de MouseAdapter
        // avec redéfinition de la méthode adéquate
        pan.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent event) {
                // Seulement s'il s'agit d'un clic droit
                // if(event.getButton() == MouseEvent.BUTTON3)
                if(event.isPopupTrigger()) {
                    background.add(blancBack);
                    background.add(rougeBack);
                    background.add(bleuBack);
                    background.add(vertBack);

                    couleur.add(blanc);
                    couleur.add(rouge);
                    couleur.add(bleu);
                    couleur.add(vert);

                    jpm.add(launch);
                    jpm.add(stop);
                    jpm.add(couleur);
                    jpm.add(background);
                    // La méthode qui va afficher le menu
                    jpm.show(pan, event.getX(), event.getY());
                }
            }
        });

        container.add(pan, BorderLayout.CENTER);

        this.setContentPane(container);
        this.initMenu();
        this.initToolBar();
        this.setVisible(true);

    }

    private void initToolBar() {
        this.cancel.setEnabled(false);
        this.cancel.addActionListener(stopAnimation);
        this.cancel.setBackground(fondBouton);
        this.play.addActionListener(startAnimation);
        this.play.setBackground(fondBouton);

        this.toolBar.add(play);
        this.toolBar.add(cancel);
        this.toolBar.addSeparator();

        // Ajout des Listeners
        this.circle.addActionListener(fListener);
        this.circle.setBackground(fondBouton);
        this.toolBar.add(circle);

        this.square.addActionListener(fListener);
        this.square.setBackground(fondBouton);
        this.toolBar.add(square);

        this.tri.setBackground(fondBouton);
        this.tri.addActionListener(fListener);
        this.toolBar.add(tri);

        this.star.setBackground(fondBouton);
        this.star.addActionListener(fListener);
        this.toolBar.add(star);

        this.add(toolBar, BorderLayout.NORTH);
    }

    private void initMenu() {
        // Ajout du listener pour lancer l'animation
        // ATTENTION, LE LISTENER EST GLOBAL !!!
        lancer.addActionListener(startAnimation);
        // Cette instruction ajoute l'accélérateur 'c' à notre objet
        lancer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK));
        animation.add(lancer);

        // Ajout du listener pour arrêter l'animation
        // LISTENER A CHANGER ICI AUSSI
        arreter.addActionListener(stopAnimation);
        arreter.setEnabled(false);
        arreter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK +
                KeyEvent.SHIFT_DOWN_MASK));
        animation.add(arreter);

        animation.addSeparator();
        quitter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        animation.add(quitter);

        // Menu forme
        bg.add(carre);
        bg.add(triangle);
        bg.add(rond);
        bg.add(etoile);

        // On crée un nouvel écouteur, inutile de créer 4 instances différentes
        FormeListener f1 = new FormeListener();
        carre.addActionListener(f1);
        rond.addActionListener(f1);
        triangle.addActionListener(f1);
        etoile.addActionListener(f1);

        typeForme.add(rond);
        typeForme.add(carre);
        typeForme.add(triangle);
        typeForme.add(etoile);

        rond.setSelected(true);

        forme.add(typeForme);

        // Ajout du listener pour le morphing
        morph.addActionListener(new MorphListener());
        forme.add(morph);

        // Menu à propos

        // Ajout de ce que doit faire le "?"
        aProposItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane jop = new JOptionPane();
                ImageIcon img = new ImageIcon("images/informations.png");
                String mess = "Merci ! \n J'espère que vous vous amusez bien !\n";
                    mess += "Je crois qu'il est temps d'ajouter des accélérateurs et des "+" mnémoniques dans tout ça.... \n";
                    mess += "\n Allez, Go les Zéros !";
                    jop.showMessageDialog(null, mess, "A propos", JOptionPane.INFORMATION_MESSAGE, img);
            }
        });

        aPropos.add(aProposItem);

        // Ajout des menus dans la barre de menus et ajout de mnémoniques !
        animation.setMnemonic('A');
        menuBar.add(animation);

        forme.setMnemonic('F');
        menuBar.add(forme);

        aPropos.setMnemonic('P');
        menuBar.add(aPropos);

        // Ajout de la barre de menus sur la fenêtre
        this.setJMenuBar(menuBar);
    }

    private void go(){
        x = pan.getPosX();
        y = pan.getPosY();

        while(this.animated) {
            // Si le mode morphing est activé, on utilise la taille actuelle de la forme
            if(pan.isMorph()) {
                if(x < 1) backX = false;
                if(x > pan.getWidth() - pan.getDrawSize()) backX = true;
                if(y < 1) backY = false;
                if(y > pan.getHeight() - pan.getDrawSize()) backY = true;
            }
            // Sinon, on fait comme d'habitude
            else {
                if(x < 1) backX = false;
                if(x > pan.getWidth() - 50) backX = true;
                if(y < 1) backY = false;
                if(y > pan.getHeight() - 50) backY = true;
            }

            if(!backX) pan.setPosX(++x);
            else pan.setPosX(--x);
            if(!backY) pan.setPosY(++y);
            else pan.setPosY(--y);
            pan.repaint();
            try{
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Les classes internes :
    //      -> StartAnimationListener
    //      -> StopAnimationListener
    //      -> PlayAnimation
    //      -> FormeListener
    //      -> MorphListener
    //sont inchangées

    // Ecoute le changement de couleur du fond
    class CouleurFondListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == vertBack)
                pan.setCouleurFond(Color.green);
            else if(e.getSource() == bleuBack)
                pan.setCouleurFond(Color.blue);
            else if(e.getSource() == rougeBack)
                pan.setCouleurFond(Color.red);
            else
                pan.setCouleurFond(Color.white);
        }
    }

    // Ecoute le changement de couleur de la forme
    class CouleurFormeListener implements ActionListener {
        public void actionPerformed(ActionEvent e)  {
            if(e.getSource() == vert)
                pan.setCouleurForme(Color.green);
            else if(e.getSource() == bleu)
                pan.setCouleurForme(Color.blue);
            else if(e.getSource() == rouge)
                pan.setCouleurForme(Color.red);
            else
                pan.setCouleurForme(Color.white);
        }
    }

    public class StartAnimationListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane jop = new JOptionPane();
            int option = jop.showConfirmDialog(null,
                    "Voulez-vous lancer l'animation ?",
                    "Lancement de l'animation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if(option == JOptionPane.OK_OPTION){
                lancer.setEnabled(false);
                arreter.setEnabled(true);

                // On ajoute l'instruction pour le menu contextuel
                launch.setEnabled(false);
                stop.setEnabled(true);

                play.setEnabled(false);
                cancel.setEnabled(true);

                animated = true;
                t = new Thread(new PlayAnimation());
                t.start();
            }
        }
    }

    /**
     * Ecouteur du menu Quitter
     */
    class StopAnimationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();
            int option = jop.showConfirmDialog(null,
                    "Voulez-vous arrêter l'animation ?",
                    "Arrêt de l'animation",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if(option != JOptionPane.NO_OPTION && option != JOptionPane.CANCEL_OPTION &&
                option != JOptionPane.CLOSED_OPTION) {
                animated = false;
                // On remplace nos boutons par nos JMenuItem
                lancer.setEnabled(true);
                arreter.setEnabled(false);

                // ON AJOUTE L'INSTRUCTION POUR LE MENU CONTEXTUEL
                //**************************************************

                // On ajoute l'instruction pour le menu contextuel
                launch.setEnabled(true);
                stop.setEnabled(false);

                play.setEnabled(true);
                cancel.setEnabled(false);
            }
        }
    }

    class PlayAnimation implements Runnable {
        public void run() {
            go();
        }
    }

    class FormeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            //Si l'action vient d'un bouton radio du menu
            if(e.getSource().getClass().getName().equals("javax.swing.JRadioButtonMenuItem"))
                pan.setForme(((JRadioButtonMenuItem)e.getSource()).getText());
            else{
                if(e.getSource() == square){
                    carre.doClick();
                }
                else if(e.getSource() == tri){
                    triangle.doClick();
                }
                else if(e.getSource() == star){
                    etoile.doClick();
                }
                else{
                    rond.doClick();
                }
            }
        }
    }

    class MorphListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Si la case est cochée, activation du mode morphing
            if(morph.isSelected())pan.setMorph(true);
                // Sinon rien !
            else pan.setMorph(false);
        }
    }
}
