
package paintjcv;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

public class InterfazSeleccionarColorFondo extends JDialog implements ActionListener {

    // Ventana para escoger el color predeterminado
    JColorChooser jcolorfondo = new JColorChooser();

    JButton btnAceptar = new JButton("Aceptar");
    private Dibujar d;

    public InterfazSeleccionarColorFondo(Dibujar dib) {

        // Es necesario obtener el objeto Dibujar para poder manipular la variable color
        // que se encuentra en dicha clase
        d = dib;
        // El this es debido a que esta clase implementa el ActionListener
        btnAceptar.addActionListener(this);

        add(jcolorfondo);
        add(btnAceptar);

        setLayout(new FlowLayout());
        setSize(650, 400);
        setTitle("Selecciona un color...");
        setVisible(true);
        setLocation(220, 100);
        setResizable(false);

    }

    public void actionPerformed(ActionEvent e) {

        // Si el que llama al evento es el boton aceptar
        if (e.getSource() == btnAceptar) {
            // Modificamos el color
            d.colorFondo = jcolorfondo.getColor();

        }
        dispose();
    }
}
