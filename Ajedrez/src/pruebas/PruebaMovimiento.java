package pruebas;
import java.awt.Color;

import javax.swing.*;

import visual.GestorMovimiento;

public class PruebaMovimiento {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel p = new JPanel();
		frame.add(p);
		p.setLayout(null);
		p.setSize(frame.getSize());
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(Color.red);
		label.setSize(100,100);
		p.add(label);
		
		JLabel label1 = new JLabel();
		label1.setOpaque(true);
		label1.setBackground(Color.red);
		label1.setSize(100,100);
		p.add(label1);
		
		JLabel label2 = new JLabel();
		label2.setOpaque(true);
		label2.setBackground(Color.red);
		label2.setSize(100,100);
		p.add(label2);
		
		frame.setVisible(true);
		GestorMovimiento.agregarMovimiento(label, 0, 400, 2000);
		GestorMovimiento.agregarMovimiento(label1, 400, 0, 2000);
		GestorMovimiento.agregarMovimiento(label2, 400, 400, 2000);
		
		GestorMovimiento.run();
		GestorMovimiento.run();
		GestorMovimiento.run();
		
	}
	
}
