package Main.Logica;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonPersonalizado extends JButton implements ActionListener {
    private final int anchoBoton = 10; // Ancho deseado del botón
    private final int altoBoton = 10; // Alto deseado del botón
    private boolean tieneColor = false; // Variable para controlar si tiene un color asignado
    private Turno turno; // Referencia a la clase Turno

    
    public BotonPersonalizado(String tipoBoton, Turno turno) {
        this.setBorder(new LineBorder(Color.GREEN)); // Establecer borde para separar los botones
        this.setBorderPainted(true);
        this.setContentAreaFilled(true);

        // Establecer tamaño preferido para cada botón
        this.setPreferredSize(new Dimension(anchoBoton, altoBoton));

        this.turno = turno; // Asignar referencia a la instancia de Turno

        cambiarTipo(tipoBoton);

        // Agregar el ActionListener al botón
        this.addActionListener(this);
    }

    public void cambiarTipo(String tipoBoton) {
        // Lógica para cambiar el tipo del botón
        if (tipoBoton.equals("Negro")) {
            this.setIcon(new ImageIcon("imagen/Fichanegra.png"));
            tieneColor = true; // Establecer que tiene un color asignado
        } else if (tipoBoton.equals("Blanco")) {
            this.setIcon(new ImageIcon("imagen/Fichablanca.png"));
            tieneColor = true; // Establecer que tiene un color asignado
        } else {
            // Configuración para otros tipos de botones (Default, Ayuda, etc.)
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!tieneColor) {
            int numeroTurno = turno.obtenerTurno(); // Obtener el número de turno actual

            if (numeroTurno == 1) {
                cambiarTipo("Negro");
            } else {
                cambiarTipo("Blanco");
            }

            turno.cambiarTurno(); // Cambiar al siguiente turno
        }
    }
}
