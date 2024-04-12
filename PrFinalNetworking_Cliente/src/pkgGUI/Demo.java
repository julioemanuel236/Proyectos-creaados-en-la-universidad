package pkgGUI;

import javax.swing.*;
import java.awt.*;

public class Demo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("3 EN RAYA");
        Panel panel = new Panel();
        Controlador controlador = new Controlador(panel);
        panel.addListeners(controlador);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null); // Para que salga en medio de la pantalla

    }
}
