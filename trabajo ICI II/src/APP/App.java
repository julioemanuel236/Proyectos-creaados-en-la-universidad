package APP;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;


class App extends JFrame{

	Imagen imagenes[] = new Imagen[20]; 
	int ci=0;
	JLayeredPane paneles[] = new JLayeredPane[10];
	Imagen menu = new Imagen(40,40,"/Images/menu.png");
	Zone menupanel = new Zone(245,800);
	JLayeredPane seen;
	
	
	App(){
		menu.setLocation(5,10);
		inimenupanel();
		menu.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(menupanel.LEFT) {
					menupanel.RIGHT();
				}
				else if(menupanel.RIGHT) {
					menupanel.LEFT();
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File(getClass().getResource("fonts/Arciform.otf").getFile())));
		}
		catch(Exception e) {
			
		}
		setTitle("Tarea ICI II: Julio Emanuel Galera Adán & Ali Elio Grillo Urquiza");
		cargarImagenes();
		crearPaneles();
		crearElementos();
		cambiarPanel(paneles[0]);
		setLayout(null);
		setResizable(false);
		setSize(810,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	
	private int alto(JButton j) {
		FontMetrics f =j.getFontMetrics(j.getFont());
		return f.getHeight();
	}
	
	private int ancho(JButton j) {
		int ancho=0;
		String s=j.getText();
		for(int i=0;i<s.length();i++) {
			ancho+=j.getFontMetrics(j.getFont()).charWidth(s.charAt(i));
		}
		return ancho;
	}
	
	void panelmenu() {
		
	}
	
	void cambiarPanel(JLayeredPane p) {
		if(p==seen||p==null)return;
		if(menupanel.RIGHT)menupanel.LEFT();
		int l=Integer.parseInt(p.getName());	
		if(seen!=null) {
			move_to(paneles,0,-l*p.getHeight(),200*(Math.abs(Integer.parseInt(seen.getName())-l)));
		}
		
		//if(seen!=null)
	//		seen.setVisible(false);
		seen=p;
		for(Component i:seen.getComponents()){
			if(i.getClass()==TextoAnimado.class) {
				((TextoAnimado)i).restart();
				break;
			}
		}
		seen.setLayer(menu, 10);
		seen.setLayer(menupanel, 9);
		seen.add(menu);
		seen.add(menupanel);
			for(Component i:seen.getComponents()){
				if(i.getClass()==TextoAnimado.class) {
					((TextoAnimado)i).start();
					break;
				}
			}
		
		System.out.println(seen+"    |   "+menupanel.padre);
		//seen.setVisible(true);
	}
	
	void panel0() {
		JLayeredPane p = paneles[0];		
		p.setBackground(Color.white);
		p.setLayout(null);
		p.setOpaque(true);
		
		
		TextoAnimado txt = new TextoAnimado("La industria del software es la industria que involucra la investigación, desarrollo, distribución y comercialización de software utilizando un enfoque especifico centralizado o descentralizado en una de sus dos variantes bien sea democratico o controlado");				
		
		txt.setForeground(Color.black);
		txt.setFont(new Font("Arciform",Font.PLAIN,48));
		txt.setSize(750,400);
		
		p.setLayer(txt,2);
		p.add(txt);
		
		menu.setLocation(5,10);
		//p.add(cen);
//		p.add(dec);
	//	p.add(ded);
		txt.setLocation((p.getWidth()/2)-(txt.getWidth()/2),(p.getHeight()/2)-(txt.getHeight()/2)+20);
		p.setLayer(imagenes[0],0);
		p.add(imagenes[0]);
	}
	
	void inimenupanel() {
		menupanel.Limiteh = 0;
		menupanel.UP=false;
		menupanel.LEFT=true;
		menupanel.setLayout(null);
		menupanel.setBackground(Color.white);
		menupanel.setOpaque(true);
		menupanel.padre=seen;
		Imagen home = new Imagen(40,40,"/Images/home.png");
		home.setLocation(menupanel.getWidth()-home.getWidth()-10,10);
		home.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				cambiarPanel(paneles[0]);				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
			
		
		
		menupanel.add(home);
		
		String arr[]  = new String[]{"Descentralizado Concreto","Centralizado","Descentralizado Democratico","Ejemplos","Componentes o Miembros"};
		JButton botones[] = new JButton[arr.length];
		for(int i=0;i<arr.length;i++) {
			JButton b = new JButton(arr[i]);
			b.setSize(menupanel.getWidth()-50,50);
			b.setForeground(Color.white);
			if(i%2==0)b.setFont(new Font("Arciform",Font.PLAIN,15));
			else b.setFont(new Font("Arciform",Font.PLAIN,20));
			b.setFocusable(false);
			b.setOpaque(true);
			b.setBackground(Color.blue);
			b.setBorder(null);
			botones[i]=b;
			;
			b.setLocation((menupanel.getWidth()/2)-(b.getWidth()/2),(i*50)+ menu.getY()+menu.getWidth() + (i*10)+60);
			b.setName(""+i);
			b.addActionListener((ActionEvent e)->{
				cambiarPanel(paneles[Integer.parseInt(b.getName())+1]);
			});
			menupanel.add(b);
		}
	}

	void panel1() {
		JLayeredPane p = paneles[1];		
		p.setBackground(Color.white);
		p.setLayout(null);
		p.setOpaque(true);
		
		
		TextoAnimado txt = new TextoAnimado("Suando el enfoque descentralizado concreto el equipo tiene un jefe definido que coordina tareas específicas y jefes secundarios que tienen responsabilidades sobre subtareas.");				
		
		txt.setForeground(Color.black);
		txt.setFont(new Font("Arciform",Font.PLAIN,49));
		txt.setSize(750,400);
		
		p.setLayer(txt,2);
		p.add(txt);
		
		menu.setLocation(5,10);
		//p.add(cen);
//		p.add(dec);
	//	p.add(ded);
		txt.setLocation((p.getWidth()/2)-(txt.getWidth()/2),(p.getHeight()/2)-(txt.getHeight()/2)+20);
		p.setLayer(imagenes[1],0);
		p.add(imagenes[1]);			
	}

	void panel2() {
		JLayeredPane p = paneles[2];		
		p.setBackground(Color.white);
		p.setLayout(null);
		p.setOpaque(true);
		
		
		TextoAnimado txt = new TextoAnimado("Cuando se presenta un enfoque centralizado el jefe del equipo se encarga de la resolución de problemas a alto nivel y la coordinación interna del equipo");				
		
		txt.setForeground(Color.black);
		txt.setFont(new Font("Arciform",Font.PLAIN,49));
		txt.setSize(750,400);
		
		p.setLayer(txt,2);
		p.add(txt);
		
		menu.setLocation(5,10);
		//p.add(cen);
//		p.add(dec);
	//	p.add(ded);
		txt.setLocation((p.getWidth()/2)-(txt.getWidth()/2),(p.getHeight()/2)-(txt.getHeight()/2)+20);
		p.setLayer(imagenes[2],0);
		p.add(imagenes[2]);		
	}
	
	void panel3() {
		JLayeredPane p = paneles[3];		
		p.setBackground(Color.white);
		p.setLayout(null);
		p.setOpaque(true);
		
		
		TextoAnimado txt = new TextoAnimado("Si se usa el enfoque descentralizado democrático el equipo no tiene un jefe permanente. Más bien se  nombran coordinadores de tareas a corto plazo y se sustituyen por otros para diferentes tareas.");				
		
		txt.setForeground(Color.black);
		txt.setFont(new Font("Arciform",Font.PLAIN,49));
		txt.setSize(750,400);
		
		p.setLayer(txt,2);
		p.add(txt);
		
		menu.setLocation(5,10);
		//p.add(cen);
//		p.add(dec);
	//	p.add(ded);
		txt.setLocation((p.getWidth()/2)-(txt.getWidth()/2),(p.getHeight()/2)-(txt.getHeight()/2)+20);
		p.setLayer(imagenes[3],0);
		p.add(imagenes[3]);
	}

	void panel4() {
		JLayeredPane p = paneles[4];		
		p.setBackground(Color.white);
		p.setLayout(null);
		p.setOpaque(true);						
		ScrollPanel sb = new ScrollPanel(p.getWidth(),p.getHeight());
		sb.border.show("all", false);
		sb.vsb.active=Color.blue;
		menu.setLocation(5,10);
		sb.back.setSize(sb.getWidth(),0);
		String[] txt = new String[]{"Empresa de desarrollo de software", "Comunidad de desarrollo de sofware","Empresa de desarrollo de tecnología y equipamiento"};
		for(int i=4;i<ci;i++) {
			Imagen m = imagenes[i];
			JLabel j = new JLabel(txt[(i-4)/2]);
			m.setLocation(0,sb.back.getHeight());
			
			j.setSize(800,50);
			j.setForeground(Color.cyan);
			j.setFont(new Font("Arciform",Font.PLAIN,40));
			j.setHorizontalAlignment(JLabel.CENTER);
			sb.back.setSize(sb.back.getWidth(),sb.back.getHeight()+m.getHeight());
			j.setLocation((sb.back.getWidth()/2) -(j.getWidth()/2),sb.back.getHeight()-m.getHeight());
			sb.back.add(j);
			sb.back.add(m);
			
		}
		p.setLayer(sb,0);
		p.add(sb);
		
	}
	
	void panel5() {
		JLayeredPane p = paneles[5];		
		p.setBackground(Color.white);
		p.setLayout(null);
		p.setOpaque(true);
		
		
		TextoAnimado txt = new TextoAnimado("Componentes:\n"
				+ "-Empresas de desarrollo de software: Microsoft, Ubisoft \n "
				+ "-Comunidad de desarrollo de software (software libre): Comunidad de Linux ,Stackoverflow \n "
				+ "-Empresas de desarrollo de tecnologías y equipamiento: Nvidea, AMD \n"
			);				
		
		txt.setForeground(Color.black);
		txt.setFont(new Font("Arciform",Font.PLAIN,35));
		txt.setSize(750,400);
		
		p.setLayer(txt,2);
		p.add(txt);
		
		menu.setLocation(5,10);
		//p.add(cen);
//		p.add(dec);
	//	p.add(ded);
		txt.setLocation((p.getWidth()/2)-(txt.getWidth()/2),(p.getHeight()/2)-(txt.getHeight()/2)+20);
		//p.setLayer(imagenes[3],0);
		//p.add(imagenes[3]);

	}
	
	void crearElementos() {
		panel0();
		panel1();
		panel2();
		panel3();
		panel4();
		panel5();
	}
	
	void crearPaneles() {
		for(int i=0;i<10;i++) {
			JLayeredPane p = new JLayeredPane();
			p.setName(""+i);
			paneles[i] = p;
			p.setSize(800,470);
			p.setLocation(0,i*p.getHeight());
			p.setLayout(null);
			add(p);
		}
	}

	public static void move_to(Container[] j,int x,int y,long time) {
		(new Thread() {
			public void run() {
				int xi=j[0].getX();
				int yi=j[0].getY();
				int xt;
				int yt;
				long ti=System.currentTimeMillis();
				long tf=ti+time;
				while(System.currentTimeMillis()<tf) {
					long ta=System.currentTimeMillis()-ti;
					int xp=xi+(int)((x-xi)*((float)ta/time));
					int yp=yi+(int)((y-yi)*((float)ta/time));
					
					j[0].setLocation(xp,yp);
					for(int k=1;k<j.length;k++) {
						j[k].setLocation(j[k].getX(),j[k-1].getY()+j[k-1].getHeight());
					}
				}
				j[0].setLocation(x,y);
				for(int k=1;k<j.length;k++) {
					j[k].setLocation(j[k].getX(),j[k-1].getY()+j[k-1].getHeight());
				}
			}
		}).start();
	}
	
	void cargarImagenes() {
		while(true) {
			
			try {
				imagenes[ci] = new Imagen(800,470,"/Images/"+ci+".png");
			}
			catch(Exception e) {
				System.out.println("erro al cargar /Images/"+ci+".png");
				try {
					imagenes[ci] = new Imagen(800,470,"/Images/"+ci+".jpg");				
				}
				catch(Exception eee) {
					System.out.println("erro al cargar /Images/"+ci+".jpg");
					try {
						imagenes[ci] = new Imagen(800,470,"/Images/"+ci+".jpeg");
					}
					catch(Exception ee) {
						return;
					}
					
				}
			}
			ci++;
		}
	}
	
	public static void main(String args[]){
		new App();
	}
}

