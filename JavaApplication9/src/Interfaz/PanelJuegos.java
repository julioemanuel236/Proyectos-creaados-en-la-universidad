package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.FlowLayout;


public class PanelJuegos extends JPanel{

    public PanelJuegos() {
        setLayout(new FlowLayout());
        TitledBorder border = BorderFactory.createTitledBorder("Navegación");
        border.setTitleColor(Color.ORANGE);
        setBorder(border);
    }
    
}
