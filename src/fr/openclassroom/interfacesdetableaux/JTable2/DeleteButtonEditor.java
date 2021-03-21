package fr.openclassroom.interfacesdetableaux.JTable2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private DeleteButtonListener bListener = new DeleteButtonListener();

    public DeleteButtonEditor(JCheckBox checkBox) {
        //Par défaut, ce type d'objet travaille avec un JCheckBox
        super(checkBox);
        //On crée à nouveau notre bouton
        button = new JButton();
        button.setOpaque(true);
        //On lui attribue un listener
        button.addActionListener(bListener);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        //On définit le numéro de ligne à notre listener
        bListener.setRow(row);
        //On passe aussi en paramètre le tableau pour des actions potentielles
        bListener.setTable(table);
        //On réaffecte le libellé au bouton
        button.setText( (value ==null) ? "" : value.toString() );
        //On renvoie le bouton
        return button;
    }

    class DeleteButtonListener implements ActionListener {

        private int row;
        private JTable table;

        public void setRow(int row){this.row = row;}
        public void setTable(JTable table){this.table = table;}

        public void actionPerformed(ActionEvent event) {
            if(table.getRowCount() > 0){
                //On affiche un message mais vous pourriez faire ce que vous voulez
                System.out.println("coucou du bouton : "+ ((JButton)event.getSource()).getText() );
                //On affecte un nouveau libellé à une celulle de la ligne
                ((ZModel)table.getModel()).removeRow(this.row);

            }
        }
    }
}
