package pruebas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieza.Peon;
import pieza.Reyna;
import tablero.Tablero;
import visual.GestorMedia;
import visual.BotonSelector;

public class PruebaBotones {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(750,750);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		
		JPanel p = new JPanel();
		frame.add(p);
		p.setLayout(null);
		p.setSize(frame.getSize());
					
		BotonSelector buton = new BotonSelector(null,null);
		buton.setSize(100,100);
		GestorMedia.cargarMedia();
		buton.setIcon(GestorMedia.getAlfilImage(false));
		p.add(buton);
		
		frame.setVisible(true);
	}
}
