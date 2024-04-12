package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelRegistro extends JPanel{
    private JLabel lNombre;
    private JLabel lPartida;
    private JTextField tNombre;
    private JTextField tPartidaTextField;
    private JButton bJUEGO1, bJUEGO2, bJUEGO3, bJUEGO4;

    /*private static final String EJUEGO1 = "JUEGO1";
    private static final String EJUEGO2= "JUEGO2";
    private static final String EJUEGO3 = "JUEGO3";
    private static final String EJUEGO4 = "JUEGO4";*/


    public PanelRegistro() {
        //GridLayout
        setLayout(new GridLayout(2, 4));  
        TitledBorder border = BorderFactory.createTitledBorder("Registro");
        border.setTitleColor(Color.BLUE);
        setBorder(border);

        lNombre = new JLabel("Nombre:");
        lPartida = new JLabel("Partidas:");
        lNombre.setForeground(Color.BLACK);
        lPartida.setForeground(Color.BLACK);

        tNombre = new JTextField("Carlos");
        tPartidaTextField = new JTextField("5");
        tNombre.setForeground(Color.BLACK);
        tPartidaTextField.setForeground(Color.BLACK);

        bJUEGO1 = new JButton("JUEGO1");
        bJUEGO1.setBackground(Color.orange);
        bJUEGO2 = new JButton("JUEGO2");
        bJUEGO2.setBackground(Color.orange);
        bJUEGO3 = new JButton("JUEGO3");
        bJUEGO3.setBackground(Color.orange);
        bJUEGO4 = new JButton("JUEGO4");
        bJUEGO4.setBackground(Color.orange);

        
        add(lNombre);
        add(tNombre);
        add(lPartida);
        add(tPartidaTextField);
        add(bJUEGO1);
        add(bJUEGO2);
        add(bJUEGO3);
        add(bJUEGO4);
    }
    
}