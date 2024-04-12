package game;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import unidades.*;

public class App extends JPanel{
	public static Scanner cin = new Scanner(System.in);	
	public static Player player;
	public static final String ANSI_BLACK = "";
	public static final String ANSI_RED = "";
	public static final String ANSI_FULL_RED = "";
	public static final String ANSI_GREEN = "";
	public static final String ANSI_YELLOW = "";
	public static final String ANSI_BLUE = "";
	public static final String ANSI_PURPLE = "";
	public static final String ANSI_CYAN = "";
	public static final String ANSI_WHITE = "";
	public static final String ANSI_RESET = "";
	public static final String ANSI_BROWN = "";
	public static final String ANSI_FULL_BLUE = "";
	public static final String ANSI_ORANGE = "";
	public static ArrayList<Player> players;
	private static JFrame windows;
	private static Stack<Container> paneles = new Stack<>();
	public static Dimension size = new Dimension(500,550);
	private static Container vista;
	public static int turno=0;
	private static boolean ingame=false;
	public static int seleccion(int n,String txt) {
		while(true) {
			try {
				int op=Integer.parseInt(JOptionPane.showInputDialog(txt));
				if(op<0||op>n)throw new Exception();
				return op;
			}
			catch(Exception e) {
				print("Opcion no valida\n");
			}
		}
	}
	public static boolean murio = false;
	
	static public class Tienda{
		
		public static void abrir() {			
				Tienda();
				changeView(tienda);
		}
		
		static void comprarHeroe() {
			if(player.oro<200) {
				print("No tienes suficiente oro para comprar un Heroe");
				return;
			}
			mostrarhComprar();
			print("Cada Hereo tiene un valor de 200 monedas de oro \n");				
			
		}
		
		static void comprarItem() {
			if(player.items.size()>=10) {
				print("No puedes llevar mas objetos");
				return;
			}
			mostrarItems();
		}
		
		
		static JPanel mostrarItems;
		public static void mostrarItems() {
			mostrarItems= new JPanel();
			mostrarItems.setSize(size);
			mostrarItems.setLayout(null);
			final ArrayList<Item> items = new ArrayList<>();
			items.add(new SemillaVida());
			items.add(new ElixirVerde());
			items.add(new CapaMovilidad());
			int y=20;
			for(Item t:items) {			
				JButton boton = new JButton(t.getClass().getSimpleName());
				boton.setSize((int)size.getWidth()/2,50);
				boton.setLocation((int)size.getWidth()/4,y);
				boton.setToolTipText("$"+t.precio+" "+t.descripcion);
				y+=boton.getHeight()+10;				
				mostrarItems.add(boton);
				boton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(player.oro<t.precio) {
							print("No tiene suficiente oro");
							return;
						}
						Item it;
						if(t instanceof SemillaVida)it = new SemillaVida();
						else if(t instanceof ElixirVerde)it = new ElixirVerde();
						else it = new CapaMovilidad();
						player.items.add(it);
						print("Se ha comprado el Item "+t.shopping()+"\n");
						player.oro-=t.precio;					
					}
						
					})					;
					
				}								
			
			JButton boton = new JButton("Salir");
			boton.setSize((int)size.getWidth()/2,50);
			boton.setLocation((int)size.getWidth()/4,y);
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					changeView();					
				}
				
			});
			mostrarItems.add(boton);
			changeView(mostrarItems);
		}
		
		static JPanel mostrarHeroes;
		public static void mostrarhComprar() {
			mostrarHeroes = new JPanel();
			mostrarHeroes.setSize(size);
			mostrarHeroes.setLayout(null);			
			System.out.println(player.hComprar.size());
			int y=20;
			for(Heroe t:player.hComprar){								
				
				JButton boton = new JButton(t.getClass().getSimpleName());
				boton.setSize((int)size.getWidth()/2,50);
				boton.setLocation((int)size.getWidth()/4,y);
				y+=boton.getHeight()+10;
				boton.setToolTipText(t.shopping());
				mostrarHeroes.add(boton);
				boton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(player.oro<200) {
							print("No tiene suficiente oro");
							return;
						}
						Heroe nuevo=null;
						String nombre = JOptionPane.showInputDialog("Nombre del "+t.getClass().getSimpleName());
						if(t instanceof Caballero)nuevo = new Caballero(nombre);
						else if(t instanceof Arquero)nuevo = new Arquero(nombre);
						else if(t instanceof Mago)nuevo = new Mago(nombre);
						else if(t instanceof Dragon)nuevo = new Dragon(nombre);
						else if(t instanceof Gigante)nuevo = new Gigante(nombre);
						player.heroes.add(nuevo);
						print("Se ha comprado el heroe "+t.shopping()+"\n");						
						player.oro-=200;
					}
					
				})					;
				
			}
							
			JButton boton = new JButton("Salir");
			boton.setSize((int)size.getWidth()/2,50);
			boton.setLocation((int)size.getWidth()/4,y);
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					changeView();
					
				}
				
			});
			mostrarHeroes.add(boton);
			
			changeView(mostrarHeroes);
			
		}
		
	}
	
	public App() {		
		
		cargarUsuario();
		initWindow();		
		mainMenu();
	}
		
	public void mainMenu() {
		Main(size);
		changeView(main);
	}
	JPanel demoTablero;
	public void demoTablero() {
		seleccionarMapa();
		player.tablero.generarMounstros();
		player.tablero.update();
		demoTablero = new JPanel();
		demoTablero.setSize(size);
		demoTablero.add(player.tablero);
		player.tablero.setLocation(50,25);
		changeView(demoTablero);
		JButton salir = new JButton("Salir");
		salir.setSize(demoTablero.getWidth()/2,50);
		salir.setLocation(demoTablero.getWidth()/4,450);
		demoTablero.add(salir);
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeView();
			}
			
		});
		
	}
	
	
	static JPanel inventario;
	public void inventario() {
		inventario = new JPanel();
		inventario.setSize(size);
		inventario.setLayout(null);
		int x=0,y=0;
		for(Heroe e:player.heroes) {					
			
			JButton boton = new JButton(e.getClass().getSimpleName());
			boton.setSize((int)size.getWidth()/5,50);
			boton.setLocation(x,y);
			boton.setEnabled(false);
			boton.setToolTipText(e.info());
			x+=boton.getWidth();
			if(x==boton.getWidth()*5) {
				x=0;
				y+=boton.getHeight();
			}
			inventario.add(boton);			
			
		}
		
		for(Item e:player.items) {					
			
			JButton boton = new JButton(e.getClass().getSimpleName());
			boton.setSize((int)size.getWidth()/5,50);
			boton.setLocation(x,y);
			x+=boton.getWidth();
			if(x==boton.getWidth()*5) {
				x=0;
				y+=boton.getHeight();
			}
			final Item ie = e;
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					hacerCon(ie);
				}
				
			});
			
			inventario.add(boton);			
			
		}
		
		JButton salir = new JButton("Salir");
		salir.setSize(inventario.getWidth()/2,50);
		salir.setLocation(inventario.getWidth()/4,450);
		inventario.add(salir);
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeView();
			}
			
		});
		
		print("Seleccione un objeto para venderlo o usarlo\n");
		
		changeView(inventario);
	}
	
	
	public void hacerCon(Item i) {
		String arr[] = {"Usar","Vender","Nada"};
		String op=(String) JOptionPane.showInputDialog(null,"Que desea hacer con "+i.nombre,"Que hacer",JOptionPane.QUESTION_MESSAGE,null,arr,null);
		if(op.equals(arr[2])|| op==null)return;
		else if(op.equals(arr[0])) {
			usarItem(i);
		}
		else {
			player.oro+=i.precio/2;
			player.items.remove(i);
			print("Objeto vendido por "+i.precio/2+" monedas de oro\n");
		}
		
	}
	
	public static Heroe seleccionarHeroe() {
		return (Heroe)JOptionPane.showInputDialog(null,"Seleccione un heroe","Que hacer",JOptionPane.QUESTION_MESSAGE,null,player.heroes.toArray(),null);
	}
	
	public static Item seleccionarItem() {
		return (Item)JOptionPane.showInputDialog(null,"Seleccione un Item","Que hacer",JOptionPane.QUESTION_MESSAGE,null,player.items.toArray(),null);
	}
	
	public void usarItem(Item i) {
		Heroe op = seleccionarHeroe();		
		if(op==null)return;
		i.usar(op);
		player.items.remove(i);
	}
	
	public static void iniciarPartida() {		
		if(player.heroes.isEmpty()) {//primera vez que se juega
			print("Para iniciar tu aventura obten un Heroe y algunos objetos\n");
			Tienda.abrir();
			return;
		}
		print("Ahora selecciona un tipo de mapa\n");
		seleccionarMapa();
		if(player.tablero==null)return;
		seleccionHeroes();
		if(player.ingame[0]==null)return;
		print("Todo listo, empezamos\n");
		print("Seleccione unas coordenadas para posicionar el heroe\n");
		
		int X=seleccion(player.tablero.width,"Coordenada X");
		int Y=seleccion(player.tablero.height,"CoordenadaY");
		if(X<1||Y<1||X>=player.tablero.width||Y>=player.tablero.height) {
			print("Estas posiciones son invaliads\n");
			return;
		}
		player.ingame[0].x=X-1;
		player.ingame[0].y=Y-1;
		player.tablero.map[Y-1][X-1]=player.ingame[0];
		player.tablero.generarMounstros();
		gameStart();
	}
	
	
	
	public static void mejorarVida() {
		if(player.oro<80) {
			print("No tienes oro para esto\n");
		}
		if(player.heroes.isEmpty()) {
			print("No tienes ningun heroe\n");
			return;
		}
		Heroe op=seleccionarHeroe();
		if(op==null)return;
		op.vidaMaxima+=50;
		if(!op.isDead())op.vida+=50;
		player.oro-=80;
	}

	public static void mejorarDamage() {
		if(player.oro<125) {
			print("No tienes oro para esto\n");
		}
		if(player.heroes.isEmpty()) {
			print("No tienes ningun heroe\n");
			return;
		}
		
		Heroe op=seleccionarHeroe();
		if(op==null)return;
		op.damage+=10;
		player.oro-=125;
	}
	
	public static void mejorarMovilidad() {
		if(player.oro<500) {
			print("No tienes oro para esto\n");
		}
		if(player.heroes.isEmpty()) {
			print("No tienes ningun heroe\n");
			return;
		}
		
		Heroe op=seleccionarHeroe();
		if(op==null)return;
		op.maxMov++;
		player.oro-=500;
	}
	static JPanel mejoras;
	
	public static void mejoras() {
		if(player.oro<80) {
			print("No tienes dinero para ninguna mejora\n");
			return;
		}
		String arr[] = {"Vida","Danno","Movilidad","Salir"};
		String ds[] = {"80 Le otorga al personaje 50 de vida maxima","125 Le otorga al personaje 10 de ataque","500 Le otorga al personaje 1 casilla adicional de movimiento"};

		print("Posees "+player.oro+" monedas de oro\n");
	
		mejoras= new JPanel();
		mejoras.setSize(size);
		mejoras.setLayout(null);
		JButton botones[] = new JButton[arr.length];
		int y=20;
		for(int i=0;i<arr.length;i++) {
			JButton boton = new JButton(arr[i]);
			boton.setSize((int)size.getWidth()/2,50);
			boton.setLocation((int)size.getWidth()/4,y);
			if(i<ds.length)boton.setToolTipText(ds[i]);
			y+=boton.getHeight()+10;
			mejoras.add(boton);
			botones[i]=boton;
		}

		
		botones[0].addActionListener((ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mejorarVida();				
			}
			
		});


		botones[1].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mejorarDamage();				
			}
			
		});
		
		
		botones[2].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mejorarMovilidad();		
			}
			
		});		

		
		botones[3].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeView();			
			}
			
		});
		
		changeView(mejoras);
		
	}
	
	
	static JLayeredPane game;
	public static void gameStart() {
		ingame=true;
		game = new JLayeredPane();
		game.setSize(size);
		player.tablero.setLocation(50,25);
		player.tablero.update();
		game.setLayer(player.tablero,1);
		game.add(player.tablero);
		game.repaint();
		String arr[] = {"Atacar","Tienda","Salir"};
		JButton botones[] = new JButton[arr.length];
		int x=0;
		for(int i=0;i<arr.length;i++) {
			JButton boton = new JButton(arr[i]);
			boton.setSize((int)size.getWidth()/3,50);
			boton.setLocation(x,450);
			x+=boton.getWidth();
			game.setLayer(boton, 1);
			game.add(boton);
			botones[i]=boton;
		}

		botones[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeView(tienda);
			}
			
		});
		
		
		botones[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(abandonar())changeView();
			}
			
		});		

		botones[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				ejecutarTurno(true);
			}
			
		});		

		changeView(game);
		player.ingame[0].mover();
		
	}
	
	
	static boolean ejecutandoce=false;
	
	public static void ejecutarTurno(boolean atack) {
		(new Thread() {
			public void run() {								
				if(ejecutandoce) {
					return;
				}				
				ejecutandoce=true;
				player.infoTurno="Descripcion del turno:\n";		
				Heroe hero = player.ingame[player.mainHero];
				if(atack)if(!hero.atacar()) {
					ejecutandoce=false;
					return;											
				}
				for(int i=0;i<player.enemy.size();i++) {			
					if(!player.enemy.get(i).atacar())player.enemy.get(i).mover();	
					
					
				}
				player.tablero.update();
				try{
					sleep(500);// tiempo para ver el cambio en la pantalla
				}
				catch(Exception ee){
					ee.printStackTrace();
				}
				//Si el heroe en batalla murio cambiarlo
				murio=false;
				if(hero.isDead()) {
					murio=true;
					int other = (player.mainHero+1)%2;
					Heroe second = player.ingame[other];
					if(second==null||second.isDead()) {
						loss();
						return;					
					}
					else {					
						cambiarHeroe();
						print("Tu heroe a muerto, se a cambiado a tu otro jugador\n");
						int X=0,Y=0;
						while(true) {
							X=seleccion(player.tablero.width,"X: ");						
							Y=seleccion(player.tablero.height,"Y: ");
							if(X<1||Y<1) {
								print("Estas posiciones son invaliads\nPara la proxima use posiciones a partir de 1 y menores que el tamanno del mapa");
							}
							else break;
						}
						((Entity)player.tablero.map[player.ingame[player.mainHero].y][player.ingame[player.mainHero].x]).restaureMap();
						player.tablero.map[Y-1][X-1]=player.ingame[player.mainHero];
						player.ingame[player.mainHero].x=X-1;
						player.ingame[player.mainHero].y=Y-1;
					}
				}
				if(turno>0&&canChange()){				
					boolean op=siNo("Deseas Cambiar el Heroe");
					if(op)cambiarHeroe();
				}
				hero = player.ingame[player.mainHero];
				if(!player.items.isEmpty()&&turno>0) {
					boolean si = siNo("Deseas usar algun objeto\n");					
					if(si) {
						Item op=seleccionarItem();
						if(op==null);
						else {
							Item item = op;
							if(item instanceof SemillaVida) {
								Heroe hero2 = player.ingame[(player.mainHero+1)%2];
								if(hero2!=null)item.usar(hero2);
							}
							else item.usar(hero);
							
							player.items.remove(item);
						}
					}
				}
				if(player.ingame[0].isDead()&&player.ingame[1].isDead()) {
					loss();
					ingame=false;
					return;
				}
				if(player.infoTurno.equals("Descripcion del turno:\n"));
				print(player.infoTurno+"\n");
				if(player.enemy.isEmpty()) {
					win();
					ingame=false;
					return;
				}
				turno++;				
				//print("TURNO: "+ (turno+1) +"\n");				
				player.tablero.update();
				hero.mover();
				ejecutandoce=false;
			}
		}).start();
	}
	
	
	public static boolean abandonar() {		
		boolean op=siNo("Seguro que deseas abandonar?");
		if(op)return true;
		return false;
	}

	public static boolean canChange() {
		int other = (player.mainHero+1)%2;
		if(player.ingame[other]==null) {
			return false;
		}
		if(player.ingame[other].isDead()) {
			for(int i=0;i<player.items.size();i++) {
				Item item=player.items.get(i);
				if(item instanceof SemillaVida) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
	
	public static void loss() {
		print("Has perdido, Mejor suerte a la proxima");
		System.out.println(App.ANSI_RED+"__________________________"+App.ANSI_RESET);
		System.out.println(App.ANSI_RED+"\\Has perdido esta partida/"+App.ANSI_RESET);
		System.out.println(App.ANSI_RED+" \\______________________/"+App.ANSI_RESET);
		changeView();
	}
	
	public static void win() {
		print("Felicidades, has ganado");
		player.oro+=250;
		System.out.println(App.ANSI_GREEN+"_________________________"+App.ANSI_RESET);
		System.out.println(App.ANSI_GREEN+"\\Has GANADO esta partida/"+App.ANSI_RESET);
		System.out.println(App.ANSI_GREEN+" \\_____________________/"+App.ANSI_RESET);
		changeView();
	}
	
	public static boolean cambiarHeroe() {
		int other = (player.mainHero+1)%2;		
		if(player.ingame[other]==null) {
			print("No tienes otro heroe");
			return false;
		}
		if(player.ingame[other].isDead()) {
			boolean semilla=false;
			for(int i=0;i<player.items.size();i++) {
				Item item=player.items.get(i);
				if(item instanceof SemillaVida) {
					semilla=true;
					item.usar(player.ingame[other]);
					player.items.remove(item);
					//mainHero=other;
					break;
				}
			}
			if(!semilla) {
				print("No se puede revivir al heroe\n");
				return true;
			}
			else {
				print("Se uso una semilla vida para revivir al heroe\n");
				return true;
			}
		}
		Heroe heroe = player.ingame[other];
		heroe.overAgua=player.ingame[player.mainHero].overAgua;
		heroe.overLava=player.ingame[player.mainHero].overLava;
		heroe.overArbol=player.ingame[player.mainHero].overArbol;
		heroe.x=player.ingame[player.mainHero].x;
		heroe.y=player.ingame[player.mainHero].y;
		player.tablero.map[heroe.y][heroe.x]=heroe;
		player.mainHero=other;
		return true;
		
		
	}
	
	public static void seleccionarMapa() {
		String arr[] = {"Normal 8*8","Dificl 15*15","Personalizado","carga de fichero"};
		
		String op = (String)JOptionPane.showInputDialog(null,"Tipo de mapa","Que hacer",JOptionPane.QUESTION_MESSAGE,null,arr,null);
		if(op.equals(arr[0]))player.tablero = new Tablero(1);
		else if(op.equals(arr[1]))player.tablero = new Tablero(2);
		else if(op.equals(arr[2]))tableroPersonalizado();			
		else if(op.equals(arr[3]))player.tablero=cargarTableros();			
		else player.tablero=null;
		
	}
	
	private static Tablero cargarTableros() {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filtrer = new FileNameExtensionFilter("Archivos de mapas","th");
		fc.addChoosableFileFilter(filtrer);		
		int op = fc.showOpenDialog(null);
		
		if (op == JFileChooser.APPROVE_OPTION) {
			TreeMap<String,String[]> tableros = new TreeMap<>();
		    File ficheroTableros = fc.getSelectedFile();
		    int cantidadCargada=0;
		    try {
		    	Scanner entry = new Scanner(ficheroTableros);
		    	
		    	while(entry.hasNext()) {    		    		
		    		String id = entry.next();
		    		id = entry.next();

		    		String dimension = entry.next();
		    		dimension = entry.next();
		    		System.out.println(id+"\n"+dimension);
		    		int lines = Integer.parseInt(dimension.substring(dimension.indexOf('X')+1));
		    		String map="";
		    		for(int i=0;i<lines;i++) {
		    			String s=entry.next();
		    			System.out.println(s);
		    			map+=s;        		   			
		    		}
		    		System.out.println(map);
		    		if(tableros.keySet().contains(id)) {
		    			JOptionPane.showMessageDialog(fc, "El mapa con id "+id+" ya fue cargado");
		    			continue;
		    		}
		    		tableros.put(id, new String[]{id,dimension,map});		    				    				    		
		    		cantidadCargada++;
		    	}
		    	JOptionPane.showMessageDialog(fc, "Tableros cargados con exito: "+cantidadCargada);
		    }
		    catch(Exception e) {    		    	
		    	e.printStackTrace();
		    	JOptionPane.showMessageDialog(fc, "Error al cargar los tableros");
		    	JOptionPane.showMessageDialog(fc, "tableros cargados con exito: "+cantidadCargada);		    	
		    }
		    String arr[] = new String[tableros.keySet().size()];
		    int pos=0;
		    for(String i:tableros.keySet()) {
		    	String s[] = tableros.get(i);
		    	arr[pos]=s[0];
		    	pos++;
		    }
		   String s = (String)JOptionPane.showInputDialog(null,"Mapa a usar","Mapa a usar",JOptionPane.QUESTION_MESSAGE,null,arr,null);
		   if(s==null)return null;
		   return new Tablero(tableros.get(s));
		   
		}
		return null;
	}
	
	public static void seleccionHeroes() {
		player.ingame[0]=null;
		player.ingame[1]=null;
		player.ingame[0]=player.ingame[1]=seleccionarHeroe();
		if(player.ingame[0]==null)return;
		if(player.heroes.size()>1) {
			while(player.ingame[1]==player.ingame[0]) {
				player.ingame[1]=seleccionarHeroe();
				if(player.ingame[1]==player.ingame[0])print("Selecciona un segundo heroe diferente\n");
			}
		}
	}

	public static void print(String txt) {
		JOptionPane.showMessageDialog(null, txt);
	}
	
	public static void tableroPersonalizado() {
		System.out.println("Systema de personalizacion de tableros\n");
		String ops[]= {"Alto","Ancho","Cantidad Planicies","Cantidad  Arboles","Cantidad  Agua","Cantidad Lava"};
		int n[]= new int[ops.length];
		int tam=20;
		while(tam!=0) {
			for(int i=0;i<ops.length;i++) {
				n[i]=0;
				while(n[i]<1) {
					if(i>1);
					n[i]=seleccion(tam,ops[i]);
					if(i==1)tam=n[0]*n[1];
					if(n[i]==0)print("valores mayores que 0\n");
					tam-=n[i];
				}
				
				if(n[i]<0)return;
			}
		}
		player.tablero = new Tablero(n[0],n[1],n[2],n[3],n[4],n[5]);	
	}
		
	private void cargarUsuario() {
		String nombre=null;
		String guardada=null;
		while(nombre==null||nombre.isBlank())nombre = JOptionPane.showInputDialog("Cual es tu nombre?");
		guardada = JOptionPane.showInputDialog("Nombre de tu partida guardada");
		player = Player.cargarPlayer(nombre,guardada);
		player.setDirGuardado(guardada);
		App.player=player;
	}
	
	private void initWindow() {
		windows = new JFrame();
		windows.setSize(size);
		windows.setLocationRelativeTo(null);
		windows.setDefaultCloseOperation(windows.EXIT_ON_CLOSE);
		windows.setVisible(true);
		windows.setLayout(null);
		fondo.setSize(size);
		fondo.setFocusable(false);
		fondo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/fondo.jpeg")).getImage().getScaledInstance((int)size.getWidth(),(int)size.getHeight(), Image.SCALE_SMOOTH)));
	}
	
	private static void changeView() {
		paneles.pop();
		changePanel(paneles.peek());
	}
	
	private static void changeView(Container panel) {
		paneles.add(panel);
		changePanel(panel);
	}
	
	private static void changePanel(Container panel) {
		if(vista!=null) {
			windows.remove(vista);
		}
		vista=panel;
		windows.add(vista);		
		windows.repaint();
		vista.add(fondo);
		vista.repaint();
		
	}
	
	JPanel main;
	static JPanel tienda;
	
	private void Main(Dimension size){
		main = new JPanel();
		main.setSize(size);
		main.setLayout(null);
		String nombreBotones[] = {"Iniciar Partida","Tienda","Inventario","Generacion Tablero","Puntaje","Guardar","Salir"};
		JButton botones[] = new JButton[nombreBotones.length];
		int y=20;
		for(int i=0;i<nombreBotones.length;i++) {
			JButton boton = new JButton(nombreBotones[i]);
			boton.setSize((int)size.getWidth()/2,50);
			boton.setLocation((int)size.getWidth()/4,y);
			y+=boton.getHeight()+10;
			main.add(boton);
			botones[i]=boton;
		}

		//boton nueva partida
		botones[0].addActionListener((ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarPartida();				
			}
			
		});
		//boton continuar partida
		botones[1].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Tienda.abrir();
				
			}
			
		});
		
		//boton inventario
		botones[2].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inventario();		
			}
			
		});		

		//boton Genara Mapa
		
		botones[3].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {						
				demoTablero();
			}
			
		});

		botones[4].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				puntuaciones();
				
			}
			
		});

		botones[5].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean g = siNo("Desea guardara la partida");
				if(g) {
					
					String s = JOptionPane.showInputDialog("Nombre de la partida");
					if(s==null)return;
					try {
						try {
							File f = new File(player.dirGuardado);	
							f.delete();
						}
						catch(Exception ee) {
							System.out.println("No tiene partida guardada");
						}
						player.setDirGuardado(s);
						player.Guardar();
					}
					catch(Exception ee) {
						ee.printStackTrace();
					}
				}
			}
			
		});			
		
		//boton salir
		botones[6].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por jugar");
				System.exit(0);
			}
			
		});
	
		}

	static JPanel puntuaciones;
	private void puntuaciones() {
		puntuaciones = new JPanel();
		puntuaciones.setSize(size);
		
		JTextArea txt = new JTextArea();
		JScrollPane jsp = new JScrollPane(txt);		
		txt.setSize((int)size.getWidth(),450);
		txt.setEnabled(false);
		txt.setFont(new Font("Arial",Font.BOLD,25));		
		jsp.setSize(txt.getSize());
		jsp.setLocation(0,0);
		puntuaciones.add(jsp);
		
		String arr[]= {"Orden","Salir"};
		JButton botones[] = new JButton[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			JButton boton = new JButton(arr[i]);
			botones[i]=boton;
			boton.setSize(puntuaciones.getWidth()/2,50);
			boton.setLocation(boton.getWidth()*i,450);
			puntuaciones.add(boton);
		} 
		players = new ArrayList<>();
		players.add(player);
		try {
			FileReader fr = new FileReader("puntos.txt");
			Scanner entry = new Scanner(fr);
			
			while(entry.hasNext()) {
				String nombre = entry.nextLine();
				int puntos = Integer.parseInt(entry.nextLine());
				boolean ok=false;
				for(Player i:players) {
					if(i.nombre.equals(nombre)) {
						i.puntos+=puntos;
						ok=true;
					}
				}
				Player p =new Player(nombre,null);
				p.puntos+=puntos;
				if(!ok)players.add(p);
			}
			entry.close();
		}
		
		catch(Exception e) {
			
		}
		
		Comparator<Player> cmp = new Comparator<>() {

			@Override
			public int compare(Player o1, Player o2) {
				if(o1.puntos<o2.puntos)return -1;
				if(o1.puntos>o2.puntos)return 1;
				return 0;
			}
			
		};
		Collections.sort(players,cmp);
		
		for(Player i:players) {
			txt.setText(txt.getText()+i.nombre+" "+i.puntos+"\n");
		}
		
		botones[0].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {				
				Collections.reverse(players);
				txt.setText("");
				for(Player i:players) {
					txt.setText(txt.getText()+i.nombre+" "+i.puntos+"\n");
				}
			}
			
		});

		botones[1].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {				
				changeView();
			}
			
		});
		changeView(puntuaciones);
	}
	
	private static void Tienda() {
		tienda = new JPanel();
		tienda.setSize(size);
		tienda.setLayout(null);
		String nombreBotones[] = {"Comprar Heroe","Comprar Item","Comprar Mejoras","Salir"};
		JButton botones[] = new JButton[nombreBotones.length];
		int y=20;
		for(int i=0;i<nombreBotones.length;i++) {
			JButton boton = new JButton(nombreBotones[i]);
			boton.setSize((int)size.getWidth()/2,50);
			boton.setLocation((int)size.getWidth()/4,y);
			y+=boton.getHeight()+10;
			tienda.add(boton);
			botones[i]=boton;
		}

		//boton nueva partida
		botones[0].addActionListener((ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tienda.comprarHeroe();				
			}
			
		});
		//boton continuar partida
		botones[1].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {						
				Tienda.comprarItem();				
			}
			
		});

		//boton mejora
		botones[2].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mejoras();
			}
			
		});		
		
		//boton salir
		botones[3].addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeView();
				if(!ingame)iniciarPartida();
			}
			
		});		
	}
	
	public static void guardarPuntaje() {
		try {
			FileWriter fw = new FileWriter("puntos.txt");
			players = new ArrayList<>();
			players.add(player);
			try {
				FileReader fr = new FileReader("puntos.txt");
				Scanner entry = new Scanner(fr);
				
				while(entry.hasNext()) {
					String nombre = entry.nextLine();
					int puntos = Integer.parseInt(entry.nextLine());
					boolean ok=false;
					for(Player i:players) {
						if(i.nombre.equals(nombre)) {
							i.puntos+=puntos;
							ok=true;
						}
					}
					Player p =new Player(nombre,null);
					p.puntos+=puntos;
					if(!ok)players.add(p);
				}
				entry.close();
			}
			
			catch(Exception e) {
				
			}
			for(Player i:players) {
				fw.write(i.nombre+"\n"+i.puntos+"\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean siNo(String text) {
		return (JOptionPane.showConfirmDialog(null,text,text, JOptionPane.OK_CANCEL_OPTION)==0?true:false);
		
	}
	public static JLabel fondo = new JLabel();
	public static void main(String args[]) {		
		new App();		
	}

}
