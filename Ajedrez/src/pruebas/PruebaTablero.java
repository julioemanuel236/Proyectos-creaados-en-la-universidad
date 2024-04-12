package pruebas;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieza.Peon;
import pieza.Pieza;
import pieza.Rey;
import pieza.Reyna;
import tablero.Tablero;
import visual.GestorMedia;
import visual.GestorMovimiento;

public class PruebaTablero {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(750,750);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		
		JPanel p = new JPanel();
		frame.add(p);
		p.setLayout(null);
		p.setSize(frame.getSize());
		
		Tablero t = new Tablero();			
		t.setSize(700,700);
		p.add(t);
		
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(Color.red);
		label.setSize(100,100);
		//t.add(label);
		
		GestorMedia.cargarMedia();
				
		frame.setVisible(true);
		
		t.iniciarPartida();
	}
}
