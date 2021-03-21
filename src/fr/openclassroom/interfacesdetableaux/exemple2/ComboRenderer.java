package fr.openclassroom.interfacesdetableaux.exemple2;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ComboRenderer extends JComboBox implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
        this.addItem("Très bien");
        this.addItem("Bien");
        this.addItem("Mal");
        return this;
    }
}
