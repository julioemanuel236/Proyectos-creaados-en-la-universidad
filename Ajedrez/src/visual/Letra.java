package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tablero.Tablero;

public class Letra extends Component{

	private String texto;
	private Color color;
	private Font font;
	
	public Letra(char letra,Color color,Font font) {
		this.texto = ""+letra;
		this.color = color;
		this.font = font;
	}
	
	@Override
	public void paint(Graphics g) {
																							
		int alto = getHeight();		
		int letra = getFontMetrics(font).getHeight();
		
		while(letra<alto) {
			font = new Font(font.getFontName(),font.getStyle(),font.getSize()+1);
			letra = getFontMetrics(font).getHeight();
		}
		
		while(letra>alto) {
			font = new Font(font.getFontName(),font.getStyle(),font.getSize()-1);
			letra = getFontMetrics(font).getHeight();
		}
		
		//font = new Font(font.getFontName(),font.getStyle(),30);
		
		System.out.println("ALTO LETRA VICTORIA "+font.getSize());
		
		int ancho = getFontMetrics(font).getWidths()[texto.charAt(0)];
		g.setColor(new Color(0,0,0,0));
		
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setFont(font);
		g.setColor(color);
		
		g.drawString(texto, (getWidth()/2)-(ancho/2), (getHeight())-(alto/4));
			
	}
	/*
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(750,750);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		
		JPanel p = new JPanel();
		frame.add(p);
		p.setLayout(null);
		p.setSize(frame.getSize());
		
		Letra letra = new Letra('H',Color.black,new Font("Arial",Font.BOLD,12));
		
		letra.setSize(p.getSize());
		letra.setLocation(0,0);
		
		p.add(letra);
		
		frame.setVisible(true);
		
	}*/
	
}
