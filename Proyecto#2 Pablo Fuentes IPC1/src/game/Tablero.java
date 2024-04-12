package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import unidades.*;

public class Tablero extends JPanel implements Serializable{
	final int dx[]= {1,1,0,-1,-1,-1,0,1};
	final int dy[]= {0,1,1,1,0,-1,-1,-1};
	
	public int width=8;
	public int height=8;
	public Object map[][];
	public int planicies=0;
	public int porPlanicie=60;
	public 	int porArbol=25;
	public 	int porAgua=10;
	public 	int porLava=5;
	public 	int dificultad=0;
	public JButton botones[][];
	public String plano;
	private Image agua,lava,arbol,planicie;
	private Image caballero,arquero,mago,dragon,gigante;	
	private Image bruja,cancerbero,ogro,flor,gargola;
	
	
	
	public ActionListener moverA= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {			
			JButton boton = ((JButton)e.getSource());
			int x,y;
			if(boton.getWidth()==0)x=0;
			else x = boton.getX()/boton.getWidth();
			if(boton.getHeight()==0)y=0;
			else y = boton.getY()/boton.getHeight();
			App.player.ingame[App.player.mainHero].moveTo(y,x);			
			App.ejecutarTurno(false);
		}
				
	};
	
	ImageFilter imf = new ImageFilter();
	public Tablero(int t) {
		setSize(400,400);
		setLayout(null);
		//App.player.enemy.clear();
		if(t==2) {
			width=height=15;
			porPlanicie=60;
			porArbol=0;
			porAgua=0;
			porLava=10;
		}
		generar();
	}

	public Tablero(String arr[]) {
		setSize(400,400);
		setLayout(null);
		width = Integer.parseInt(arr[1].split("X")[0]);
		height= Integer.parseInt(arr[1].split("X")[0]);
		plano=arr[2];
		generar();
	}
	
	public Tablero(int width, int height, int porPlanicie, int porArbol, int porAgua, int porLava) {
		setSize(400,400);
		setLayout(null);
		App.player.enemy.clear();
		int total = width*height;
		this.width = width;
		this.height = height;
		this.porPlanicie = porPlanicie/total*100;
		this.porArbol = porArbol/total*100;
		this.porAgua = porAgua/total*100;
		this.porLava = porLava/total*100;
		generar();
	}
	
		
	
	private void cargarImagenes() {
		try {
			agua = ImageIO.read(getClass().getResource("/imagenes/agua.jpg")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			lava = ImageIO.read(getClass().getResource("/imagenes/lava.jpg")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			arbol = ImageIO.read(getClass().getResource("/imagenes/arbol.jpg")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			planicie= ImageIO.read(getClass().getResource("/imagenes/planicie.jpg")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			
			caballero = ImageIO.read(getClass().getResource("/imagenes/caballero.png")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			arquero = ImageIO.read(getClass().getResource("/imagenes/arquero.png")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			mago = ImageIO.read(getClass().getResource("/imagenes/mago.png")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			gigante = ImageIO.read(getClass().getResource("/imagenes/gigante.png")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			dragon = ImageIO.read(getClass().getResource("/imagenes/dragon.png")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			
			ogro = ImageIO.read(getClass().getResource("/imagenes/ogro.png")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			gargola = ImageIO.read(getClass().getResource("/imagenes/gargola.png")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			bruja = ImageIO.read(getClass().getResource("/imagenes/bruja.png")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			cancerbero = ImageIO.read(getClass().getResource("/imagenes/cancerbero.png")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH);
			flor = ImageIO.read(getClass().getResource("/imagenes/flor.png")).getScaledInstance(botones[0][0].getWidth()-10, botones[0][0].getWidth()-10, Image.SCALE_SMOOTH); 
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void generar() {		
		map = new Object[height][width];
		botones = new JButton[height][width];				
		//App.player.tablero=this;
		
		if(plano!=null) {
			generarPlano();
			return;
		}
		
		Random rand = new Random();
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				botones[i][j]= new JButton();				
				botones[i][j].setSize(getWidth()/map[i].length,getHeight()/map.length);
				botones[i][j].setLocation(i*botones[i][j].getWidth(),j*botones[i][j].getHeight());
				botones[i][j].setFocusable(false);
				botones[i][j].setBackground(Color.black);
				add(botones[i][j]);
				int n=rand.nextInt(porArbol+porAgua+porLava+porPlanicie);
				if(n<porArbol)map[i][j]=new Arbol();
				else if(n>=porArbol&&n<porArbol+porAgua) {
					if(i==0||i==height-1||j==0||j==width-1) {
						map[i][j]=new Agua(j,i);
						continue;
					}
					boolean si=false;
					
					for(int k=0;k<8;k++) {
						int di=i+dy[k];
						int dj=j+dx[k];
						if(map[di][dj] instanceof Agua) {
							map[i][j] = new Agua(j,i);
							si = true;
						}
						if(!si) {
							map[i][j] = new Planicie(j,i);
							planicies++;
						}
					}
				}
				else if(n>=porArbol+porAgua&&n<porArbol+porAgua+porLava)map[i][j]=new Lava(j,i);
				else {
					map[i][j]=new Planicie(j,i);
					planicies++;
				}
				if(map[i][j] instanceof Entity) {				
					((Entity)map[i][j]).x=j;
					((Entity)map[i][j]).y=i;
				}
			}
		}
		String arr[] = {"Facil","Normal","Dificil"};		
		String dif = (String)JOptionPane.showInputDialog(null,"Seleccione una dificultad","Que hacer",JOptionPane.QUESTION_MESSAGE,null,arr,null);
		switch(dif.charAt(0)) {
			case 'F':dificultad=1;break;
			case 'N':dificultad=2;break;
			case 'D':dificultad=3;break;
		}		
		cargarImagenes();
	}
	
	private void generarPlano() {
		int i=0,j=0;
		for(int k=0;k<plano.length();k++) {
			char c = plano.charAt(k);
			if(c=='T'||c=='#'||c=='~'||c=='-') {
				System.out.println(i+ " "+j);
				botones[i][j]= new JButton();				
				botones[i][j].setSize(getWidth()/map[i].length,getHeight()/map.length);
				botones[i][j].setLocation(i*botones[i][j].getWidth(),j*botones[i][j].getHeight());
				botones[i][j].setFocusable(false);
				botones[i][j].setBackground(Color.black);
				add(botones[i][j]);
				switch(c) {
					case '-':map[i][j] = new Planicie(j,i);j++;break;
					case '~':map[i][j] = new Agua(j,i);j++;break;
					case 'T':map[i][j] = new Arbol();j++;break;
					case '#':map[i][j] = new Lava(j,i);j++;break;
				}
				
				if(j==width) {
					j=0;
					i++;
				}
			}
		}			
		cargarImagenes();
	}
	
	
	
	public void generarVista() {
		int x=0,y=0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {				
				//System.out.println("ACtualizando "+i+" "+j);
				JButton boton = botones[i][j];				
				boton.setIcon(new ImageIcon(getImage(map[i][j])));
				boton.removeActionListener(moverA);
/*				if(map[i][j] instanceof Entity)
				boton.setToolTipText(((Entity)map[i][j]).vida+"/"+((Entity)map[i][j]).vidaMaxima);
				else boton.setToolTipText(null);
*/				if(boton.getBackground().equals(Color.green))boton.setBackground(Color.black);				
				x+=boton.getWidth();
				if(x>=getWidth()) {
					y+=boton.getHeight();
					x=0;
				}
				add(boton);
			}
		}	
		repaint();
	}
	
	public Image getImage(Object obj) {
		if(obj instanceof Lava) return lava;
		else if(obj instanceof Agua) return agua;
		else if(obj instanceof Arbol) return arbol;
		else if(obj instanceof Planicie) return planicie;
		
		else if(obj instanceof Caballero) return caballero;
		else if(obj instanceof Arquero) return arquero;
		else if(obj instanceof Mago) return mago;
		else if(obj instanceof Dragon) return dragon;
		else if(obj instanceof Gigante) return gigante;
		
		else if(obj instanceof Ogro) return ogro;
		else if(obj instanceof Gargola) return gargola;
		else if(obj instanceof Bruja) return bruja;
		else if(obj instanceof FlorCarnivora) return flor;
		else return cancerbero;
	}
	
	public void generarMounstros() {		
		Random rand = new Random();
		
		//System.out.println("Se generaran "+can+"/"+planicie);
		ArrayList<Enemigo> en = new ArrayList<>();
		en.add(new Ogro());
		en.add(new Gargola());
		en.add(new FlorCarnivora());
		if(dificultad>=2) {
			en.add(new Cancerbero());
			en.add(new Bruja());
			en.add(new FlorCarnivora());
			
		}
		if(dificultad==3){
			en.add(new Bruja());
			en.add(new Ogro());
		}
		
		while(en.size()>0) {
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					if(en.isEmpty())return;
					if(map[i][j] instanceof Planicie) {
						if(rand.nextInt(101)<20) {							
							Enemigo e=en.get(rand.nextInt(en.size()));								
							e.x=j;
							e.y=i;
							map[i][j]=e;	
							App.player.enemy.add(e);
							en.remove(e);
						}
					}
				}
			}
		}
		update();
	}
				
	public void animacionGolpe(int x,int y) {
		(new Thread() {		
			public void run() {				
				botones[y][x].setBackground(Color.red);
				long ini=System.currentTimeMillis();
				long t=ini+2000;
				while(System.currentTimeMillis()<t)
					try {
						sleep(10);	
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				botones[y][x].setBackground(Color.black);
			}
		}).start();
	}
	
	public void update() {
		generarVista();
	}	
	


}
