package juego;
import javax.swing.*;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

public class Categoria{
	String nombre;
	String palabras[];
	int cantidadPalabras=0;
	
	public Categoria(String nombre,int cp) {
		this.nombre=nombre;
		palabras = new String[cp];
	}
	
	public void addPalabra(String s) {
		palabras[cantidadPalabras++]=s;
	}
	
	public JPanel visual() {
		Random ram = new Random();
		String palabra = palabras[ram.nextInt(cantidadPalabras)];
		JPanel panel = new JPanel();
		panel.setSize(0,150);
		panel.setLayout(null);
		for(int i=0;i<palabra.length();i++) {
			JLabel linea = new JLabel();
			linea.setBackground(Color.black);
			linea.setOpaque(true);
			linea.setSize(50,10);
			linea.setLocation((i*linea.getWidth())+(i*5),panel.getHeight()-linea.getHeight()-5);
			panel.add(linea);
			panel.setSize(linea.getX()+linea.getWidth(),panel.getHeight());
		}
		
		for(int i=0;i<palabra.length();i++) {
			JLabel letra = new JLabel(""+palabra.charAt(i));
			letra.setName(""+palabra.charAt(i));
			letra.setForeground(Color.black);
			letra.setSize(50,70);
			letra.setHorizontalAlignment(JLabel.CENTER);
			letra.setVerticalAlignment(JLabel.BOTTOM);
			letra.setFont(new Font("Arial",Font.BOLD,60));
			letra.setLocation((i*letra.getWidth())+(i*5),panel.getHeight()-letra.getHeight()-15);
			letra.setVisible(false);
			panel.add(letra);
			
		}
		
		return panel;
	}
}
