package juego;
import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Interfaz extends JFrame{
	Categoria categorias[];
	boolean experto=false;
	
	int puntos = 6;
	int letras;
	int hints;
	
	private void init() {
		setLayout(null);
		setSize(700,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void cargar() {
		try {
			FileReader fr = new FileReader("Palabras.txt");
			Scanner entry = new Scanner(fr);
			int t = Integer.parseInt(entry.next());
			categorias = new Categoria[t];
			while(t>0) {
				String s = entry.next();
				int cp = Integer.parseInt(entry.next());
				Categoria cat = new Categoria(s,cp);
				while(cp>0) {
					String palabra=entry.next();
					cat.addPalabra(palabra);
					cp--;
				}
				categorias[--t]=cat;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LAS PALABRAS");
			System.exit(0);
		}
	}
	
	private void dificultad() {
		JButton novato = new JButton("NOVATO");
		JButton experto = new JButton("EXPERTO");
		novato.setOpaque(true);
		experto.setOpaque(true);
		novato.setBackground(Color.blue);
		experto.setBackground(Color.red);
		novato.setSize(getWidth()/2,getHeight());
		experto.setSize(getWidth()/2,getHeight());
		experto.setLocation(novato.getWidth(),0);
		novato.setFocusable(false);
		experto.setFocusable(false);
		novato.setForeground(Color.white);
		experto.setForeground(Color.white);
		novato.setFont(new Font("Arial",Font.BOLD,50));
		experto.setFont(new Font("Arial",Font.BOLD,50));
		ActionListener k = (ActionEvent e)->{
			if(((JButton)e.getSource()).getText().equals("EXPERTO"))this.experto=true;
			if(this.experto)hints=3;
			else hints=6;
			novato.setVisible(false);
			experto.setVisible(false);
			seleccionCategoria();
			
		};
		novato.addActionListener(k);
		experto.addActionListener(k);
		add(novato);
		add(experto);
		
	}

	private void Victoria() {
		JOptionPane.showMessageDialog(null, "FELICIDADES HAS ADIVINADO LA PALABRA");
		System.exit(0);
	}
	
	private void Derrota() {
		JOptionPane.showMessageDialog(null, "MEJOR SUERTE PARA LA PRÓXIMA");
		System.exit(0);
	}
	
	private boolean vocal(char c) {
		switch(c) {
		case 'a':return true;
		case 'e':return true;
		case 'i':return true;
		case 'o':return true;
		case 'u':return true;
		
		case 'A':return true;
		case 'E':return true;
		case 'I':return true;
		case 'O':return true;
		case 'U':return true;
		
		default:return false;
		}
		
	}
	
	private void elementos(JPanel panel,JPanel palabra) {
		String teclado[]= {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
		Vida vida = new Vida();
		vida.setLocation((panel.getWidth()/2)-(vida.getWidth()/2),0);
		panel.add(vida);
		letras=palabra.getComponentCount()/2;
		int ini=75;
		for(int i=0;i<3;i++) {
			for(int j=0;j<teclado[i].length();j++) {
				final char c = teclado[i].charAt(j);
				final char cc;
				if(c>='A'&&c<='Z')cc=(char)((int)c+'a'-'A');
				else cc=(char)((int)c-'a'-'A');
				JButton tecla = new JButton(""+c);
				tecla.setSize(50,50);
				tecla.setLocation(ini+(j*50)+(5*j),palabra.getHeight()+palabra.getY()+10+(50*i)+(5*i));
				tecla.setFocusable(false);
				tecla.setOpaque(true);
				tecla.setName(""+c);
				tecla.addActionListener((ActionEvent)->{
					tecla.setEnabled(false);
					boolean si=false;
					boolean gano=true;
					for(Component cp:palabra.getComponents()) {
						if(cp.getName()!=null)
						if(cp.getName().equals(""+c)||
						   cp.getName().equals(""+cc)) {
							cp.setVisible(true);
							si=true;
							letras--;
							tecla.setBackground(Color.green);
						}
					}
					if(letras<=0)Victoria();
					if(!si) {
						tecla.setBackground(Color.red);
						puntos--;
						vida.Hit();
						if(experto&&vocal(c))vida.Hit();
						
						if(puntos==0)Derrota();
					}
					
				});
				panel.add(tecla);
			}
			ini+=25;
		}
		
		ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("/hint.png")).getImage().getScaledInstance(20, 100,Image.SCALE_SMOOTH));
		JButton hint = new JButton(img);
		hint.setContentAreaFilled(false);
		hint.setBorder(null);
		panel.add(hint);
		hint.setSize(img.getIconWidth(),img.getIconHeight());
		hint.setLocation(5,5);
		
		hint.addActionListener((ActionEvent)->{
			if(hints==0) {
				JOptionPane.showMessageDialog(null, "No puedes pedir más pistas");
				return;
			}
			hints--;
			for(Component comp:palabra.getComponents()) {
				if(!comp.isVisible()) {
					String c = comp.getName();
					String cc;
					if(c.charAt(0)>='A'&&c.charAt(0)<='Z')cc=""+(char)((int)c.charAt(0)+'a'-'A');
					else cc=""+(char)((int)c.charAt(0)-'a'-'A');
					for(Component com:palabra.getComponents()) {
						if(com.getName()!=null) {
							if(com.getName().equals(""+c)||
						       com.getName().equals(""+cc)) {
							   com.setVisible(true);
							   letras--;
							}
						}
					}
					for(Component com:panel.getComponents()) {
						if(com.getName()!=null) {
							if(com.getName().equals(""+c)||
						       com.getName().equals(""+cc)) {
							   ((JButton)com).setEnabled(false);
							   ((JButton)com).setBackground(Color.green);
							}
						}
					}
					if(puntos==0)Derrota();
					if(letras<=0)Victoria();
					vida.Hit();
					return;
				}
			}
			
		});
	}
	
	private void GAME(int k,JPanel ocultar) {
		ocultar.setVisible(false);
		JPanel juego = new JPanel();
		juego.setLayout(null);
		juego.setSize(getSize());
		add(juego);
		JPanel p = categorias[k].visual();
		p.setLocation((getWidth()/2)-(p.getWidth()/2),(getHeight()/3)-(p.getHeight()/2));
		juego.add(p);
		elementos(juego,p);
	}
	
	private void seleccionCategoria() {
		JPanel categorias = new JPanel();
		categorias.setSize(getWidth(),getHeight());
		categorias.setLayout(null);
		categorias.setOpaque(true);
		categorias.setBackground(Color.white);
		add(categorias);
		Dimension size = new Dimension(150,40);
		Random ram = new Random();
		Point points[] = new Point[this.categorias.length];
		for(int i=0;i<this.categorias.length;i++) {
			JButton cat = new JButton(this.categorias[i].nombre);
			Point p=null;
			cat.setSize(size);
			cat.setOpaque(true);
			cat.setFocusable(false);
			final int k=i;
			cat.addActionListener((ActionEvent)->{
				GAME(k,categorias);
			});
			while(true) {
			
				
				p = new Point(ram.nextInt(getWidth()-200),ram.nextInt(getHeight()-50));
				boolean poner=true;
				
				for(int j=0;j<i;j++) 
					if(
					  (p.x>=points[j].getX()-cat.getWidth()&&p.x<=points[j].getX()+cat.getWidth()) &&
					  (p.y>=points[j].getY()-cat.getHeight()&&p.y<=points[j].getY()+cat.getHeight())
					   ){
						poner=false;
						break;
					}	
				
				if(poner) {
					points[i]=p;
					break;
				}
			}
			cat.setLocation(p);
			cat.setBackground(new Color(p.x%255,p.y%255,(p.x+p.y)%255));
			categorias.add(cat);
			
			
		}
		
		repaint();
	}
	
	Interfaz(){
		cargar();
		init();
		dificultad();	
	}
	
	public static void main(String args[]) {
		new Interfaz();
	}
}
