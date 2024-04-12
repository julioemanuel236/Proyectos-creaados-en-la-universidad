
package paintjcv;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSlider;

public class InterfazGrosorLinea extends JDialog implements ActionListener {
    // Ventana para escoger el grosor de la linea

    JSlider grosor = new JSlider();
    JButton btnAceptar = new JButton("Aceptar");
    private Dibujar d;

    public InterfazGrosorLinea(Dibujar dib) {

        d = dib;

        setLayout(new FlowLayout());
        setSize(250, 100);
        setTitle("Seleccione el grosor de la linea ...");
        setVisible(true);
        setLocation(220, 100);
        setResizable(false);

        grosor.setMaximum(10);
        grosor.setBounds(20, 10, 180, 40);
        grosor.setValue(d.strk_whith);

        btnAceptar.addActionListener(this);

        add(grosor);
        add(btnAceptar);

    }

    public void actionPerformed(ActionEvent e) {

        // Si el que llama al evento es el boton aceptar
        if (e.getSource() == btnAceptar) {
            d.strk_whith = grosor.getValue();
        }

        dispose();
    }
}
