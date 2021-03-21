package fr.openclassroom.interfacesdetableaux.tableau2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableComponent extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JButton)
            return (JButton) value;
            //Lignes ajoutées
        else if(value instanceof JComboBox)
            return (JComboBox) value;
        else
            return this;
    }
}
