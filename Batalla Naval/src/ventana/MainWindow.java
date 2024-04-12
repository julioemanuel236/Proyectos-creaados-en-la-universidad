package ventana;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.*;

import juego.Tablero;
import juego.Juego;
import juego.Jugador;

public class MainWindow extends JFrame{

	JLayeredPane main;	
	Juego juego;
	Container vista;
	JPanel inicio;
	JPanel partida;
	JPanel puntaje;
	JPanel coleccion;		
	JLabel mapa;
	JLabel tablero;
	JLabel marcos;	
	Tablero tableroJugando;
	
	public static JButton normal,torpedo,misil,hecaton,inicioButton;
 
	public MainWindow() {
		juego = new Juego();
		setSize(700,700);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		ini();
		add(main);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	private void ini() {
		marcos = new JLabel() {
			@Override
			public void paint(Graphics g) {
				g.setColor(Color.blue);
				g.fillRect(100, 0, 1, getHeight());
				g.fillRect(100, 100, getWidth(), 1);
				g.fillRect(0, 0, getWidth(), 1);
				g.fillRect(0, 0, 1, getHeight());
				g.fillRect(0, getHeight()-1, getWidth(), 1);
				g.fillRect(getWidth()-1, 0, 1, getHeight());
			}
		};
		marcos.setSize(getSize());
		add(marcos);
		main = new JLayeredPane();
		JLabel fondo = new JLabel();
		main.setSize(600,600);
		main.setLocation(100,100);
		fondo.setSize(main.getSize());
		fondo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
		main.setLayer(fondo,0);
		main.add(fondo);
		main.setBackground(Color.white);		
		main.setLayout(null);
		iniPaneles();
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage().getScaledInstance(600, 100, Image.SCALE_SMOOTH)));
		logo.setSize(600,100);
		logo.setLocation(100,0);
		add(logo);
		
		JButton inicio = new JButton();
		inicioButton = inicio;
		inicio.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/inicio.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		inicio.setSize(100,100);
		inicio.setContentAreaFilled(false);
		inicio.setBorder(null);
		inicio.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vista==partida) {
					boolean terminado = tableroJugando.derrota||tableroJugando.ganado;
					if(terminado) {
						cambiarVista(null);
						return;						
					}
					int op = JOptionPane.showConfirmDialog(inicio, "Se perderá todo el avance");					
					if(op!=0)return;
				}
				
				cambiarVista(null);
			}
			
		});
		add(inicio);
		
		JButton jugar = new JButton();
		jugar.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/jugar.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		jugar.setSize(100,100);
		jugar.setLocation(0,170);
		jugar.setContentAreaFilled(false);
		jugar.setBorder(null);
		jugar.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(juego.noMapa()) {
					juego.cargarMapas();
				}
				if(juego.noMapa())return;				
				int dificultad = JOptionPane.showInternalOptionDialog(null, "Seleccione una dificultad", "DIFICULTAD", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"FACIL","INTERMEDIO","TITANICO"},null);
				
				TreeMap<String,Tablero> mapas;
				if(dificultad==0)mapas=juego.faciles;
				else if(dificultad==1)mapas=juego.normales;
				else mapas=juego.dificiles;
				if(mapas.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene mapas de esta dificultad");
					return;
				}
				String opciones[] = new String[mapas.size()];
				Object keys[] = mapas.keySet().toArray();
				for(int i=0;i<mapas.keySet().size();i++) {
					Tablero t = mapas.get(keys[i]);
					opciones[i] = t.id+" "+t.mapa[0].length+"X"+t.mapa.length; 
				}
				int mapa = JOptionPane.showInternalOptionDialog(null, "Seleccione una dificultad", "DIFICULTAD", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones ,null);
				Tablero t = mapas.get(keys[mapa]);
				t.setDificultad(dificultad);
				jugar(t);
			}
			
		});
		add(jugar);
		
		JButton puntuacion = new JButton();
		puntuacion.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/puntuacion.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		puntuacion.setSize(100,100);
		puntuacion.setLocation(0,290);
		puntuacion.setContentAreaFilled(false);
		puntuacion.setBorder(null);
		puntuacion.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				verPuntaje();
			}
			
		});
		add(puntuacion);
		
		JButton mapas = new JButton();
		mapas.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/mapas.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		mapas.setSize(100,100);
		mapas.setLocation(0,410);
		mapas.setContentAreaFilled(false);
		mapas.setBorder(null);
		mapas.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vista!=coleccion)cambiarVista(coleccion);
			}
			
		});
		add(mapas);
		
		JButton salir = new JButton();
		salir.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/salir.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		salir.setSize(100,100);
		salir.setLocation(0,getHeight()-salir.getHeight());
		salir.setContentAreaFilled(false);
		salir.setBorder(null);
		salir.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		add(salir);
	}
	
	public void verPuntaje() {	
		if(vista!=puntaje)cambiarVista(puntaje);
		Object lista[] = juego.mejores();
		int n=Math.min(5, lista.length);
		for(int i=0;i<n;i++) { 
			Jugador j = (Jugador)(lista[i]);
			JLabel l = ((JLabel)puntaje.getComponent(i));
			l.setFont(new Font("Arial",Font.BOLD,50));
			l.setText(j.nombre+": "+j.puntos);			
			while(ancho(l)>l.getWidth()-20)l.setFont(new Font("Arial",Font.BOLD,l.getFont().getSize()-1));
			l.setIconTextGap(-(l.getWidth()/2)-(ancho(l)/2));
			l.repaint();
		}
		
	}
	
	private int ancho(JLabel j) {
		int ancho=0;
		String s=j.getText();
		for(int i=0;i<s.length();i++) {
			ancho+=j.getFontMetrics(j.getFont()).charWidth(s.charAt(i));
		}
		return ancho;
	}
	
	public void cambiarVista(Container nueva) {		
		if(nueva==null) {
			if(vista==null)return;
			(new Thread(){
				public void run() {
					long actual = System.currentTimeMillis();					
					long terminar=actual+500;
					
					while(actual<terminar) {
						int d = Math.abs(vista.getY())/10;
						vista.setLocation(0,vista.getY()-70);
						actual=System.currentTimeMillis();
						try {
							sleep(10);
							vista.repaint();
							marcos.repaint();
						}
						catch(Exception e) {
							
						}
					}					
					main.repaint();
					vista=null;
					marcos.repaint();
					MainWindow.this.repaint();
				}
			}).start();
			return;
		}
		(new Thread(){
			public void run() {
				Container temp = vista;
				vista = nueva;
				main.add(nueva);
				main.setLayer(nueva, 2);				
				long actual = System.currentTimeMillis();
				nueva.setLocation(0,-main.getHeight());
				long terminar=actual+500;
				
				while(actual<=terminar) {
					int d = Math.abs(nueva.getY())/5;
					if(d==0)nueva.setLocation(0,0);
					nueva.setLocation(0,nueva.getY()+d);
					if(temp!=null)temp.setLocation(0,temp.getY()+d);
					actual=System.currentTimeMillis();
					try {
						sleep(10);
						nueva.repaint();
						marcos.repaint();
					}
					catch(Exception e) {
						
					}
				}
				nueva.setLocation(0,0);					
				if(temp!=null)temp.setLocation(0,-vista.getHeight());				
				marcos.repaint();
				MainWindow.this.repaint();
			}
		}).start();
		
	}

	public void iniPaneles() {
		
		
		puntaje = new JPanel();
		puntaje.setBackground(Color.white);
		puntaje.setLayout(null);
		puntaje.setSize(main.getSize());
		
		for(int i=0;i<5;i++) {
			JLabel l = new JLabel();
			l.setSize((int)(puntaje.getWidth()*0.8),puntaje.getHeight()/6);			
			l.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/azul.png")).getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH)));
			l.setLocation(puntaje.getWidth()/2 - l.getWidth()/2,10 + (l.getHeight()*i)+(i*20));
			puntaje.add(l);
		}
		
		coleccion = new JPanel();
		coleccion.setBackground(Color.white);
		coleccion.setLayout(null);
		coleccion.setSize(main.getSize());
		JButton nuevoMapa = new JButton();
		nuevoMapa.setSize(75,75);
		nuevoMapa.setLocation(5,5);
		nuevoMapa.setBorder(null);
		nuevoMapa.setContentAreaFilled(false);
		nuevoMapa.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/cargar_mapas.png")).getImage().getScaledInstance(nuevoMapa.getWidth(), nuevoMapa.getHeight(), Image.SCALE_SMOOTH)));
		nuevoMapa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {			
				juego.cargarMapas();
			}
			
		});
		coleccion.add(nuevoMapa);
		mapa = new JLabel();
		mapa.setSize(coleccion.getWidth()-100,coleccion.getHeight()-100);
		mapa.setLocation(50,75);
		mapa.setBackground(Color.white);
//		mapa.setBackground(Color.red);
		mapa.setOpaque(true);
		coleccion.add(mapa);
				
		JLabel id = new JLabel();
		id.setSize(coleccion.getWidth(),75);
		id.setHorizontalAlignment(JLabel.CENTER);
		id.setFont(new Font("Arial",Font.BOLD,40));
		coleccion.add(id);
		
		JButton siguiente = new JButton();
		siguiente.setSize(50,50);
		siguiente.setLocation(coleccion.getWidth()-siguiente.getWidth(),mapa.getY()+((mapa.getHeight()/2)-(siguiente.getHeight()/2)));
		siguiente.setBorder(null);
		siguiente.setContentAreaFilled(false);
		siguiente.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/siguiente.png")).getImage().getScaledInstance(siguiente.getWidth(), siguiente.getHeight(), Image.SCALE_SMOOTH)));		
		siguiente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Tablero t = juego.siguienteDemo();
				if(t!=null) {					
					t.setSize(mapa.getSize());
					t.ajustar();
					mapa.setSize(t.getSize());
					mapa.setLocation((coleccion.getWidth()/2)-(mapa.getWidth()/2),75 +((coleccion.getHeight()-75)/2)-(mapa.getHeight()/2));
					mapa.removeAll();
					mapa.add(t);
					id.setText(t.id);
					t.revelar();									
					mapa.repaint();
				}
			}
			
		});
		coleccion.add(siguiente);
		
		JButton anterior = new JButton();
		anterior.setSize(50,50);
		anterior.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/anterior.png")).getImage().getScaledInstance(anterior.getWidth(), anterior.getHeight(), Image.SCALE_SMOOTH)));
		anterior.setBorder(null);
		anterior.setContentAreaFilled(false);
		anterior.setLocation(0,mapa.getY()+((mapa.getHeight()/2)-(siguiente.getHeight()/2)));
		coleccion.add(anterior);
		anterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Tablero t = juego.anteriorDemo();
				if(t!=null) {
					t.setSize(mapa.getSize());
					t.ajustar();
					mapa.setSize(t.getSize());
					mapa.setLocation((coleccion.getWidth()/2)-(mapa.getWidth()/2),75 +((coleccion.getHeight()-75)/2)-(mapa.getHeight()/2));
					mapa.removeAll();
					mapa.add(t);
					id.setText(t.id);
					t.revelar();									
					mapa.repaint();
				}
			}
			
		});

		
		partida = new JPanel();
		partida.setLayout(null);
		partida.setSize(main.getSize());
		partida.setBackground(Color.white);
		tablero = new JLabel();
		tablero.setSize(partida.getWidth()-100,partida.getHeight()-100);
		tablero.setLocation(100,100);
		partida.add(tablero);
		normal = new JButton();
		normal.setSize(100,100);
		normal.setLocation(partida.getWidth()-100,0);
		normal.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/normal.png")).getImage().getScaledInstance(normal.getWidth(), normal.getHeight(), Image.SCALE_SMOOTH)));
		normal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableroJugando.opcion=0;				
			}
			
		});
		partida.add(normal);
		
		hecaton = new JButton();
		hecaton.setSize(100,100);
		hecaton.setLocation(partida.getHeight()-100,partida.getWidth()-100);
		hecaton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/hecaton.png")).getImage().getScaledInstance(hecaton.getWidth(), hecaton.getHeight(), Image.SCALE_SMOOTH)));
		hecaton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableroJugando.opcion=3;				
			}
			
		});
		partida.add(hecaton);

		misil = new JButton();
		misil.setSize(100,100);
		misil.setLocation(partida.getWidth()-100,((partida.getHeight()-200)/2)-50);
		misil.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/misil.png")).getImage().getScaledInstance(misil.getWidth(), misil.getHeight(), Image.SCALE_SMOOTH)));
		misil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableroJugando.opcion=2;				
			}
			
		});
		partida.add(misil);
		
		torpedo = new JButton();
		torpedo.setSize(100,100);
		torpedo.setLocation(partida.getWidth()-100,((partida.getHeight()-200)/2)+100);
		torpedo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/torpedo.png")).getImage().getScaledInstance(torpedo.getWidth(), torpedo.getHeight(), Image.SCALE_SMOOTH)));
		torpedo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableroJugando.opcion=1;				
			}
			
		});
		partida.add(torpedo);
		
		//		tablero.setSize(getW);
	}
	
	public void jugar(Tablero t) {
		String nombre=JOptionPane.showInputDialog("Dime tu nombre\n");
		if(nombre==null)return;
		nombre.replace(' ',  '_');
		tableroJugando=t;
		t.jugador=nombre;
		tablero.removeAll();
		tablero.add(t);
		t.setPadre(tablero);
		t.resetear();
		tablero.setSize(t.getSize());
		tablero.setLocation(((partida.getWidth()-100)/2)-(tablero.getWidth()/2),(partida.getHeight()/2)-tablero.getHeight()/2);
		System.err.println(tablero.getLocation());
		System.err.println(tablero.getSize());
		cambiarVista(partida);
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}
	

}
