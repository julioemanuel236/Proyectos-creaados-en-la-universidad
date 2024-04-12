package juego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;

import objetos.*;
import ventana.MainWindow;

public class Tablero extends JLabel{
	public Objeto mapa[][];//matriz que es el mapa
	public Image mar;//imagen del mar
	public Image barco;//imagen del barco
	public Image bomba;//imagen de las bombas
	public Image oculto;//imagen del mar sin activar
	public int naves=0;//cantidad de barcos en el mapa
	public JLabel visible;	//label para dibujar el mapa
	public JLabel marca;//label para dibujar el mapa que se está seleccionando
	public Container padre;//padre del tablero
	private int puntos=0;//puntos obtenidos en la partida
	public String id;//id del mapa
	public int dificultad;//dificultad del tablero
	public int inventario[] = {0,0,0,0};//inventario del jugador
	public int defaultInv[] = {10,4,4,4};//inventario en dificultad facil
	public int opcion=0;//tipo de bomba seleccionada
	public boolean derrota=false;
	public boolean ganado=false;
	public String jugador="player";//nombre del jugador
	
	public Tablero(String id,int w,int h,String map) {		
		this.id=id;//iniciar id
		setLayout(null);//dar layout null
		construirMapa(w,h,map);//construir el mapa, osea asignar objetos a la matriz
		iniciarImagenes();//cargar las imagenes
		iniciarJLabeles();//iniciar los componentes graficos
		add(marca);//añaidr la marca
		add(visible);//añadir al visual del tablero
	}
	
	public void setDificultad(int dif) {
		this.dificultad=dif;//iniciar dificultad
		setInventario();//asignar inventario
	}
	
	public void setInventario() {
		for(int i=0;i<inventario.length;i++)//recorrer le inventario
			inventario[i]=defaultInv[i]-this.dificultad;//asignar la cantidad maxima menos la dicultad, facil es 
		opcion=0;//establecer como bomba por defecto la normal
	}
	
	public void setPadre(Container padre) {
		this.padre=padre;//iniciar padre
		this.setSize(padre.getSize());//dar tamaño al tablero del padre
		ajustar();//ajusta al tamaño
	}
	
	public void resetear() {
		//asignar los valores por defecto a las variables
		derrota=false;
		ganado=false;
		naves=0;
		puntos=0;
		setInventario();//establer inventario por defecto de nuevo
		for(int i=0;i<mapa.length;i++)
			for(int j=0;j<mapa[i].length;j++) {
				mapa[i][j].activado=false;//descativar todas las casillas
				if(mapa[i][j] instanceof Barco)naves++;//contar las naves de nuevo
			}
	}
	
	public void revelar() {
		for(int i=0;i<mapa.length;i++)
			for(int j=0;j<mapa[i].length;j++) {
				mapa[i][j].activado=true;//ir casilla por casilla activando que ya se desbloqueo
				pintar(j,i,(Graphics2D)visible.getGraphics());//actualizar su vista
			}
	}

	private void construirMapa(int w,int h,String map) {
        mapa = new Objeto[h][w];//iniciar el mapa segun las dimensiones
        
        int y=0,x=0;//posicion en la que voy a asignar los objetos
        for(int i=0;i<map.length();i++){
            Objeto e = null;//objeto que voy a signar
            char c = map.charAt(i);//caracter que estoy revisando en la matriz del entrada                      
            if(c=='B'){//si es una B de barco
                i++;//aumentar i en 1
                c = map.charAt(i);//leer caracter que sería el tipo de barco
                switch(c){//crear el tipo de nave según corresponda, la unica diferencia es su valor
                    case '1':e = new Barco(x,y,100,this); break;
                    case '2':e = new Barco(x,y,40,this); break;
                    case '3':e = new Barco(x,y,25,this); break;                    
                }
                naves++;                //aumentar la cantidad de naves
                mapa[y][x]=e;			//aignar a la matriz el objeto
                x++;//aumentar la x es uno
                if(x==w){//si llege al fina le la fila
                    x=0;//retroceder a la primera columna
                    y++;//ir a la siguiente fila
                }
            }
            else{//en caso de que no sea una B
                switch(c){
                    case 'T':e = new Torpedo(x,y,this); break;//crear un torpedo
                    case 'I':e = new Misil(x,y,this); break;//crear un misil
                    case 'O':e = new Hecaton(x,y,this); break;//crear un hecaton
                    case '~':e = new Objeto(x,y,this);break;//crear un objeto que sería mar vacio
                    default:continue;//continuar si es una coma                    
                }
                
                mapa[y][x]=e;//asignar el objeto al mapa
                x++;//auentar la columna
                if(x==w){// si es el final de la fila
                    x=0;//retroceder a la primera columna
                    y++;//ir a la siguiente fila
                }
            }
        }
	}
	
	private void iniciarJLabeles() {
		
		
		visible = new JLabel() {//iniciar visilbe
			@Override 
			public void paint(Graphics g){
				//establercer si pintado como recorrer toda la matriz y pintar cada objeto en su posicoin
				Graphics2D g2 = (Graphics2D)g;			//grafica del label visible
				for(int i=0;i<mapa.length;i++) 
					for(int j=0;j<mapa[i].length;j++) 
						pintar(j,i,g2);//pintar en i,j la grafica g2
				
				//System.out.println("Se Pinto VISIBLE");
			}
		};
			
		visible.addMouseMotionListener(new MouseMotionListener() {
			//esto es para que la marca este sobre la casilla que esta el puntero
			int oldX=-1,oldY=-1;//inicialmente no se esta en ninguna así que -1 y -1
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {						
		//		System.out.println(e);				
				Graphics g = marca.getGraphics();
				Graphics2D g2 = (Graphics2D)g;
				//si se mueve el mause coger la grafica de marca
				g2.setColor(Color.red);//establercer el color en rojo
				int ancho = barco.getWidth(null);//el ancho de la marca que se hará concide con el de un barco siempre
				int alto = barco.getHeight(null);//igual el alto
				int x=ancho*(e.getX()/ancho);//la x sería donde inicia ese cuadrado
				int y=alto*(e.getY()/alto);//el alto igual
				if(x/ancho!=oldX||y/alto!=oldY) {//si alguno es diferente, osea que se cambio de cudaro respecto al anterior
					//System.err.println(oldX+" "+oldY+"/"+(x/ancho)+" "+(y/alto));					
					marca.repaint();					//borrar la marca
					oldX=x/ancho;//actualizar las posiciones
					oldY=y/alto;			
					
					
				}				
				if(!mapa[y/alto][x/ancho].activado)g2.drawRect(x, y, ancho-1, alto-1);//si el objeto no está activado dibujar una marca roja				
				//System.err.println(oldX+" "+oldY+"/"+(x/ancho)+" "+(y/alto));
				
				
			}
			
		});
		
		visible.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				//al hacer click en una casilla
				if(derrota||ganado)return;//si ya se gano o perdio la partida salir
				int ancho = barco.getWidth(null);//anchoe que coincide con el del barco
				int alto = barco.getHeight(null);//alto que coincide con el del barco
				int x=(e.getX()/ancho);//x en el mapa
				int y=(e.getY()/alto);//y en el mapa
				if(mapa[y][x]==null)return;//si no hay nada en esa posicion de la matriz salir
				if(mapa[y][x].activado)return;//si ya fue activado ese objeto salir
				if(inventario[opcion]==0) {//si no hay bombas de ese tipo
					String tipos[] = {"Bombas normales","torpedos","misiles","hecatones"};//arreglo de los tipos
					JOptionPane.showMessageDialog(null, "Ya no tienes mas "+tipos[opcion]);	//informar
					return;//salir
				}
				inventario[opcion]--;//quitar una la opcion de bomba seleciconada
				Bomba bomba=null;//la bomba que pondremos
				switch(opcion) {//seleccionar que tipo de bomba será segun la opcion
					case 0:bomba = new Bomba(x,y,Tablero.this);break;
					case 1:bomba = new Torpedo(x,y,Tablero.this);break;
					case 2:bomba = new Misil(x,y,Tablero.this);break;
					case 3:bomba = new Hecaton(x,y,Tablero.this);break;					
				}
				boolean vacio=false;//si solo era mar
				if(mapa[y][x].getClass()==Objeto.class) {//si es objeto simple
					vacio=true;//vacio verdadero
					//escribir en accion colocacion de bomba
					Juego.escribirAccion(jugador+",Colocacion de "+bomba.getClass().getSimpleName()+" en "+x+"-"+y);
					mapa[y][x]=bomba;//plantar esa bomba en el mapa
				}
				int punto = bomba.activar();//activar la bomba y guardar cuantos puntos da en puntos
				System.err.println(puntos);
				puntos+=punto;				//sumar al acumulado
				if(vacio) {//si estuvo vacio
					mapa[y][x]= new Objeto(x,y,Tablero.this);//cambiar por un objeto vacio
					mapa[y][x].activar();//activar para que se vea 				
				}
				System.out.println(puntos);
				pintar(x,y,(Graphics2D)visible.getGraphics());//pintar nuevamente esa casilla
				if(naves==0) {//si ya no hay naves
					ganado=true;//ganasnte
					victoria();//cartel de victoria y guardar puntaje
					return;//salir
				}
				derrota=true;//derrota temporal verdadero, es para por si te quedas sin bombas
				for(int i=0;i<inventario.length;i++)
					if(inventario[i]>0)derrota=false;//si tienes bombas de algun tipo maracar falso la derrota
				if(derrota)derrota();//si perdiste cartel de derrota y guardar
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		marca = new JLabel();//iniciar marca
		
		//dar los mismo tamaños que el tablero
		visible.setSize(getSize());		
		marca.setSize(getSize());		
		
	}

	public boolean posicionValida(int x,int y) {
		//retorna verdadero sila posicion esta dentro de la matriz
		return !(x<0||y<0||x>=mapa[0].length||y>=mapa.length);
	}
	
	private void iniciarImagenes() {
		try {
			int ancho = Tablero.this.getWidth()/mapa[0].length;//ancho y alto de las imagenes
			int alto = Tablero.this.getHeight()/mapa.length;
			//cargar cada una segun corresponda
			mar = ImageIO.read(getClass().getResource("/imagenes/mar.png"));		
			barco = ImageIO.read(getClass().getResource("/imagenes/barco.png"));
			bomba = ImageIO.read(getClass().getResource("/imagenes/bomba.png"));
			oculto = ImageIO.read(getClass().getResource("/imagenes/oculto.png"));
			
		}
		catch(Exception e) {
			e.printStackTrace();//imprimir error en caso de ocurrir
		}
	}

	public void ajustar() {
		//esta funcion obtiene el ancho actual y alto acutal y ajusta el tamaño de las imagenes a lo que le corresponderiía
		int ancho=getWidth();
		int	alto=getHeight();
		System.err.println(ancho+" "+alto);
		
		mar = this.mar.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		System.err.println(mar.getWidth(null)+ " "+mar.getHeight(null));
		oculto = this.oculto.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		
		
		ancho=(getWidth()/mapa[0].length);
		alto=(getHeight()/mapa.length);		
		
		bomba= this.bomba.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		barco = this.barco.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		setSize(ancho*mapa[0].length,alto*mapa.length);
		visible.setSize(ancho*mapa[0].length,alto*mapa.length);
		marca.setSize(ancho*mapa[0].length,alto*mapa.length);
		
		visible.repaint();
		marca.repaint();
		
	}
	
	public void pintar(int x,int y,Graphics2D g2) {
		int ancho = barco.getWidth(null);//obtener alto y ancho de la casilla
		int alto = barco.getHeight(null);
		 
		Objeto objeto = mapa[y][x];//coger objeto
		if(objeto == null )return;//si esta vacio salir
		x*=ancho;//posicion en la pantalla que le toca
		y*=alto;						
		//System.err.println("Pintando: "+x+" "+y);
		if(objeto.activado) {
			//si ya está activado pintar el mar de fondo
			g2.drawImage(mar, x, y,x+ancho,y+alto, x,y,x+ancho,y+alto, null);
			//luego seleccionar a que tipo de objeto pretenece y pintar la imagen correspondiente
			if(objeto instanceof Bomba) {
				
				g2.drawImage(bomba, x, y, null);
			}
			else if(objeto instanceof Barco) {
				
				g2.drawImage(barco, x, y, null);
				
			}
		}
		else {
			//en caso de estar oculto pintar el mar oscuro
			g2.drawImage(oculto, x, y, x+ancho, y+alto, x, y, x+ancho, y+ancho, null);												
		}
	}
	
	
	private void derrota() {
		if(naves>0) {//si aun hay naves
			Juego.guardarPuntaje(jugador,puntos);//guardar puntaje
			//mostrar carteles
			JOptionPane.showMessageDialog(null, "TE HAS QUEDADO SIN BOMBAS, MEJOR SUERTE PARA LA PROXIMA");
			JOptionPane.showMessageDialog(null,jugador+", tu puntaje fue de "+puntos);
			MainWindow.inicioButton.getActionListeners()[0].actionPerformed(null);//volver al menu
		}
	}
	
	private void victoria() {
		Juego.guardarPuntaje(jugador,puntos);//guardar puntaje
		//mostrar carteles
		JOptionPane.showMessageDialog(null, "FELICIDADES HAS COMPLETADO EL NIVEL");
		JOptionPane.showMessageDialog(null,jugador+", tu puntaje fue de "+puntos);
		MainWindow.inicioButton.getActionListeners()[0].actionPerformed(null);//volver al menu
	}
	
}
//~,B3,~,B1,~,~~,B3,~,B2,B2,~~,B3,~,~,~,~~,~,~,~,~,~~,~,~,~,~,~
//~,B3,~,B1,~~,B3,~,B2,B2~,B3,~,T,~I,~,O,~,~~,~,~,~,~
