package tablero;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.event.MouseInputListener;
import javax.swing.plaf.metal.MetalToggleButtonUI;

import java.awt.Point;
import pieza.Pieza;
import visual.GestorMovimiento;
import visual.GestorPintado;
import visual.Letra;
import visual.PanelSelector;
import pieza.*;

public class Tablero extends Container implements MouseInputListener{

	private Pieza blanca,negra;
	
	private final boolean BLANCA = false , NEGRA = true;
	
	private boolean arriba,abajo;
	
	private boolean turno = false;
	
	
	private int altoCasilla,anchoCasilla;
	
	Pieza matrix[][] = new Pieza[8][8];
	
	private Rey reyNegro,reyBlanco;
	private Pieza previa;
	
	
	
	private Color[] colores = {new Color(238,238,213),new Color(97,57,22)};
	private Color[] colorJugador = {Color.red,Color.blue};
	
	private Color movimiento = new Color(50,100,200,100);
	private Color disponible = new Color(50,150,150,100); 
	private Color seleccion = new Color(50,200,100,100); 	
	private Color captura = new Color(100,50,200,100);
	private Color jake = new Color(200,50,50);
	
	private Font font = new Font("Arial",Font.BOLD,10);
	
	private boolean pintando = false;	
	private boolean jakeMate = false;
	private boolean cambiandoPeon = false;
	private boolean juegoTerminado = false;
	
	private PanelSelector panelSelector;
	
	public Tablero() {		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void notificarHover(Pieza p) {
		if(jakeMate)return;
		if(turno == p.isColor()) 
			if((turno && negra == null)||
			   (!turno && blanca == null)) {
				previa = p;
				repaint();					
		}
			
	}

	private boolean mover(Pieza temp, int i,int j) {
		
		LinkedList<Point> movimientos = temp.getCasillasMovimiento();
		LinkedList<Point> capturas = temp.getCasillasCapturas();
		
		for(Point p:movimientos) {
			if(p.x == i && p.y == j) {
				matrix[temp.getI()][temp.getJ()] = null;
				temp.moverA(i,j);					
				matrix[i][j] = temp;
				return true;
			}
		}
		
		for(Point p:capturas) {
			if(p.x == i && p.y == j) {
				matrix[temp.getI()][temp.getJ()] = null;
				temp.moverA(i,j);					
				matrix[i][j] = temp;
				return true;
			}
		}
						
		return false;
	}
	
	private void cambiarPeon(Pieza temp) {
		if(temp.getI() != 0 && temp.getI() != 7) return;
		System.out.println("SE DEBERIA HACER EL CAMBIO DEL PEON");
					
		panelSelector = new PanelSelector(temp,getWidth(),getHeight(),anchoCasilla,altoCasilla);
							
		
		cambiandoPeon = true;
		
		add(panelSelector,0);
		
		repaint();
		
	}
	
	public void notificarSeleccion(Pieza pieza,int i,int j) {
		if(cambiandoPeon || jakeMate)return;
		if(pieza == null) {
			Pieza temp;
			if(turno)temp = negra;
			else temp = blanca;
			if(temp == null)return;
			
			if(mover(temp,i,j)) {							
				siguienteTurno();
				if(temp instanceof Peon)
					if(i == 0 || i == 7) 					
						cambiarPeon(temp);
			}
									
		}
		
		else {
			System.out.println("Notificado por " + pieza.getClass().getSimpleName() + " " + (pieza.isColor()?"Negro":"Blanco") + " en " +"["+(char)('a'+pieza.getJ())+"]["+(pieza.getI()+1)+"]");
														
			if(pieza.isColor() == turno) {
				if(!pieza.puedeMover())return;
				Pieza tmp= null;
				if(!turno && blanca == null)tmp = blanca = pieza;
				if(turno && negra == null)tmp = negra = pieza;
				if(tmp != null)
					pintarSeleccion(tmp);
			}
			
			else {
				if(turno && negra!=null)blanca = pieza;
				if(!turno && blanca!=null)negra = pieza;
			}
			
			if(capturar()) {
				Pieza tmp;
				if(pieza.isColor())tmp = blanca;
				else tmp = negra;
				siguienteTurno();	
				if(tmp instanceof Peon)
					cambiarPeon(tmp);
			}
			
		}
		
		
						
	}
	
	private boolean capturar() {
		Pieza j1;
		Pieza j2;
		
		if(turno) {
			j1 = negra;
			j2 = blanca;			
		}
		else {
			j1 = blanca;
			j2 = negra;
		}
		System.out.println(j1 + "\n" + j2);
		if(j1 == null || j2 == null)return false;
		
		if(puedeComer(j1,j2)) {
			mover(j1,j2.getI(),j2.getJ());
			j2.morir();				
			return true;						
		}
		
		return false;
		
	}
	
	public boolean puedeComer(Pieza p1,Pieza p2) {
		if(p1 == null || p2 == null)return false;
		LinkedList<Point> casillas = p1.getCasillasCapturas();
		int i = p2.getI();
		int j = p2.getJ();
		
		for(Point p : casillas) {			
			if(i == p.x && j == p.y)return true;
		}
		
		return false;
	}
	
	public void siguienteTurno() {
		
		GestorMovimiento.run();
		
		if(turno && reyNegro!=null)reyNegro.desmarcar();
		else if(reyBlanco!=null)reyBlanco.desmarcar();
		turno = !turno;
		blanca = negra = null;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				Pieza pieza = matrix[i][j];
				if(pieza!=null && pieza.isColor() == turno)pieza.actualizarCasillasValidas();
			}
		}
		
		previa = null;
		
		repaint();
		System.err.println("SE CAMBIO EL TURNO");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
										
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int j = e.getX()/anchoCasilla;
		int i = e.getY()/altoCasilla;
		
		System.out.println(i+" "+j);
		
		notificarSeleccion(matrix[i][j],i,j);		
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
	
	private void esperarPintadoEnEjecucion() {
		
		GestorPintado.reset();
		
	}
	
	private void actualizarFont() {
		int alto = altoCasilla/5;		
		int letra = getFontMetrics(font).getHeight();
		
		System.out.println(letra+"/"+alto);
		while(letra<alto) {
			font = new Font(font.getFontName(),font.getStyle(),font.getSize()+1);
			letra = getFontMetrics(font).getHeight();
		}
		while(letra>alto) {
			font = new Font(font.getFontName(),font.getStyle(),font.getSize()-1);
			letra = getFontMetrics(font).getHeight();
		}
		System.out.println(letra+"/"+alto);
	}
	
	private void pintarTablero(Graphics g) {
		g.setColor(colores[0]);		
		boolean pI = false;
		
		int width = getWidth()/8;
		int height = getHeight()/8;
		
		for(int i=0;i<8;i++) {
			for(int j=(pI?1:0);j<8;j++) {
				g.fillRect(j*width, i*height, width, height);
				j++;
			}		
			pI = !pI;
		}
		
		g.setColor(colores[1]);
		pI = true;		
		for(int i=0;i<8;i++) {
			for(int j=(pI? 1:0);j<8;j++) {
				g.fillRect(j*width, i*height, width, height);
				j++;
			}		
			pI = !pI;
		}
		
		
		actualizarFont();
		int x = (anchoCasilla*2)/20;
		String numbers = "87654321";
		
		int posColor = 0;
		g.setFont(font);
		
		for(int i=0;i<8;i++) {
			posColor = (posColor+1)%2;
			g.setColor(colores[posColor]);
			String temp = ""+numbers.charAt(i);
			int y = ((altoCasilla*2)/8)+(altoCasilla*i);
			g.drawString(temp, x, y);
			
		}
		
		String letras =  "abcdefgh";
		posColor = 1;
		int y = getHeight() - getFontMetrics(font).getHeight();
		for(int i=0;i<8;i++) {
			posColor = (posColor+1)%2;
			g.setColor(colores[posColor]);
			String temp = ""+letras.charAt(i);
			x = ((anchoCasilla*7)/8)+(altoCasilla*i);
			g.drawString(temp, x, y);
			
		}
		
		g.setColor(colorJugador[(turno?0:1)]);
		for(int i=0;i<=8;i++) {
			g.drawLine(i*anchoCasilla, 0, i*anchoCasilla , getHeight());
			g.drawLine(0, i*altoCasilla, getWidth() , i*altoCasilla);
		}
		
	}
	
	private void pintarCasillasDisponibles(Graphics g,Pieza pieza) {
		if(pieza != null) {
			
			LinkedList<Point> movimientos = pieza.getCasillasMovimiento();
			LinkedList<Point> capturas = pieza.getCasillasCapturas();
									
			GestorPintado.agregarPintado(this, matrix[pieza.getI()][pieza.getJ()],pieza.getJ()* anchoCasilla, pieza.getI()*altoCasilla, anchoCasilla, altoCasilla, seleccion, 100);
			
			for(Point p : movimientos) {
				//System.out.println(p.x + " / " + p.y);
				GestorPintado.agregarPintado(this,matrix[p.x][p.y], p.y*anchoCasilla, p.x*altoCasilla, anchoCasilla, altoCasilla, movimiento, 100);
								
			}
			 			
			for(Point p : capturas) {
				//System.out.println(p.x + " / " + p.y);
				GestorPintado.agregarPintado(this,matrix[p.x][p.y], p.y*anchoCasilla, p.x*altoCasilla, anchoCasilla, altoCasilla, captura, 100);
			}
									
		}
	}

	private void pintarCasillasPreview(Graphics g,Pieza pieza) {
		if(pieza == null && previa != null) {
			LinkedList<Point> movimientos = previa.getCasillasMovimiento();
			LinkedList<Point> capturas = previa.getCasillasCapturas();

			GestorPintado.agregarPintado(this, previa, previa.getX(), previa.getY(), anchoCasilla, altoCasilla, seleccion.brighter(), 100);

			for (Point p : movimientos) {
				// System.out.println(p.x + " / " + p.y);
				GestorPintado.agregarPintado(this, matrix[p.x][p.y], p.y * anchoCasilla, p.x * altoCasilla,
						anchoCasilla, altoCasilla, movimiento, 100);

			}

			for (Point p : capturas) {
				// System.out.println(p.x + " / " + p.y);
				GestorPintado.agregarPintado(this, matrix[p.x][p.y], p.y * anchoCasilla, p.x * altoCasilla,
						anchoCasilla, altoCasilla, captura, 100);
			}
		}
	}
	
	private boolean revisionDeJake(Graphics g) {
		Rey rey;
		if(turno)
			rey = reyNegro;	
		else rey = reyBlanco;
		
		boolean jakeMateTemp = false;
		
		if(rey !=null && rey.isJake()) {					
			jakeMateTemp = !rey.puedeMover();
			g.setColor(disponible);
			
			for(int i=0;i<matrix.length;i++) {
				for(int j=0;j<matrix[i].length;j++) {
					if(matrix[i][j] == null)continue;
					if(matrix[i][j].isColor() != rey.isColor())continue;
					
										
					if(matrix[i][j] != rey && matrix[i][j].puedeMover()) {
						jakeMateTemp = false;						
						g.fillRect(j*anchoCasilla, i*altoCasilla, anchoCasilla, altoCasilla);
					}
				}
			}
			 			
			g.setColor(jake);
			g.fillRect(rey.getX(), rey.getY(), anchoCasilla, altoCasilla);
			
		}
		
		return jakeMateTemp;
	}
	
	private void pintarSeleccion(Pieza pieza) {
		previa = null;
		GestorPintado.agregarPintado(this,pieza,pieza.getX(), pieza.getY(), anchoCasilla, altoCasilla, seleccion, 100);
		
		for(Point p : pieza.getCasillasMovimiento()) {
			Pieza over = matrix[p.x][p.y];
			int x = p.y*anchoCasilla;
			int y = p.x*altoCasilla;
			GestorPintado.agregarPintado(this,over,x, y, anchoCasilla, altoCasilla, movimiento.darker(), 100);
		}
		
		for(Point p : pieza.getCasillasCapturas()) {
			Pieza over = matrix[p.x][p.y];
			int x = p.y*anchoCasilla;
			int y = p.x*altoCasilla;
			GestorPintado.agregarPintado(this,over,x, y, anchoCasilla, altoCasilla, captura.darker(), 100);
		}
		
		GestorPintado.run();
	}
	
	private void oscurecerTablero(Graphics g) {
		g.setColor(new Color(0,0,0,125));
		g.fillRect(0, 0, getWidth(), getHeight());
		
	}
	
	private void cartelVictoria(Graphics g) {
		
		String cartel = "VICTORIA";
		int width = (getWidth()/cartel.length()) ;
		int height = width;
		long tiempo = 250;
		int x = (getWidth()/2) - ((width*cartel.length())/2);
		int y = (getHeight()/2) - (height/2);
		Color color;
		Rey rey;
		if(turno == NEGRA) {
			color = Color.white;
			rey = reyBlanco;
		}
		else {
			color = Color.black;
			rey = reyNegro;
		}
		
		for(int i=0;i<cartel.length();i++) {
			
			Letra letra = new Letra(cartel.charAt(i),color,font);
			letra.setLocation(rey.getLocation());
			letra.setSize(width,height);			
			
			add(letra,0);
			System.out.println((x + (i*width)) + " - " + y);
			int xFinal = x + (i*width);
			int distancia = (int)Math.sqrt((Math.pow(Math.abs(xFinal-rey.getX()),2)) + (Math.pow(Math.abs(rey.getY()-y),2)));
			GestorMovimiento.agregarMovimiento(letra,xFinal , y, distancia);
		}
		GestorMovimiento.run();
		
	}
	
	@Override
	public void paint(Graphics g) {
		//System.err.println("INICIO EL PAINT DEL TABLERO");		
						
		esperarPintadoEnEjecucion();

		pintando = true;
		pintarTablero(g);
		
		if(!juegoTerminado) {
								
			Pieza pieza;
			if(turno)pieza = negra;
			else pieza = blanca;
			
			if(!cambiandoPeon) { 
									
				pintarCasillasDisponibles(g,pieza);
				
				pintarCasillasPreview(g, pieza);
				
				this.jakeMate = revisionDeJake(g);
				
			}
																					

			
		}
		
		
		super.paint(g);
		GestorPintado.run();
		
		if(this.jakeMate) {
			oscurecerTablero(g);
			
			System.err.println("JAKE MATE GANA " + !turno);
			if(!juegoTerminado) {
				juegoTerminado = true;
				cartelVictoria(g);				
			}
			
		}
		
		else System.err.println("NO JAKE MATE GANA " + !turno);
		
		pintando = false;
	}

	@Override
	public void setSize(int width,int height) {
		anchoCasilla = width/8;
		altoCasilla = height/8;
		//piezasLayer.setSize(width,height);
		super.setSize(width, height);
	}

	@Override
	public void setSize(Dimension d) {
		int width = (int) d.getWidth();
		int height = (int) d.getHeight();
		anchoCasilla = width/8;
		altoCasilla = height/8;	
		super.setSize(width, height);
	}
	
	public int getAltoCasilla() {
		return altoCasilla;
	}

	public int getAnchoCasilla() {
		return anchoCasilla;
	}
	
	public void iniciarPartida() {
	
		arriba = turno;
		abajo = !turno;
		
		removeAll();
		
		crearArriba(arriba);
		crearAbajo(abajo);
		
		turno = NEGRA;
		
		siguienteTurno();
		
		
	}
	
	private void crearArriba(boolean color) {
		
		for(int i=0;i<8;i++) 
			matrix[1][i] = new Peon(1,i,color,this,1);
		
		matrix[0][0] = new Torre(0,0,color,this);
		matrix[0][7] = new Torre(0,7,color,this);
	
		matrix[0][1] = new Caballo(0,1,color,this);
		matrix[0][6] = new Caballo(0,6,color,this);
		
		matrix[0][2] = new Alfil(0,2,color,this);
		matrix[0][5] = new Alfil(0,5,color,this);
		
		matrix[0][4] = new Reyna(0,4,color,this);
		matrix[0][3] = new Rey(0,3,color,this);
		
		
	}
	
	private void crearAbajo(boolean color) {
		
		for (int i = 0; i < 8; i++)
			matrix[6][i] = new Peon(6, i, color, this,-1);

		matrix[7][0] = new Torre(7, 0, color, this);
		matrix[7][7] = new Torre(7, 7, color, this);

		matrix[7][1] = new Caballo(7, 1, color, this);
		matrix[7][6] = new Caballo(7, 6, color, this);

		matrix[7][2] = new Alfil(7, 2, color, this);
		matrix[7][5] = new Alfil(7, 5, color, this);

		matrix[7][4] = new Reyna(7, 4, color, this);
		matrix[7][3] = new Rey(7, 3, color, this);
		
	}
	
	public Pieza getPieza(int i,int j) {
		return matrix[i][j];
	}

	public Rey getReyNegro() {
		return reyNegro;
	}

	public void setReyNegro(Rey reyNegro) {
		this.reyNegro = reyNegro;
	}

	public Rey getReyBlanco() {
		return reyBlanco;
	}

	public void setReyBlanco(Rey reyBlanco) {
		this.reyBlanco = reyBlanco;
	}
	
	public void setPieza(Pieza p,int i,int j) {
		p.setI(i);
		p.setJ(j);
		p.setLocation(j*anchoCasilla,i*altoCasilla);
		matrix[i][j] = p;
		p.setTablero(this);
		add(p);
	}
	
	public void setPiezaEnMatrix(Pieza p ,int i ,int j) {
		matrix[i][j] = p;				
	}

	public boolean isArriba() {
		return arriba;
	}

	public boolean isAbajo() {
		return abajo;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int j = e.getX()/anchoCasilla;
		int i = e.getY()/altoCasilla;
		if(j<0)j = 0;
		if(j>7)j = 7;
		if(i<0)i = 0;
		if(i>7)i = 7;
		if(matrix[i][j] == null && previa != null) {
			previa = null;
			if(( turno && negra == null)||
				(!turno && blanca == null))
				repaint();
			
		}
		
	}
		
	public void actualizarPiezas() {
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[i].length;j++)
				if(matrix[i][j] != null && matrix[i][j].isColor() == turno)
					matrix[i][j].actualizarCasillasValidas();
	}
	
	public void notificarCambioPeon() {
		cambiandoPeon = false;
		
		remove(panelSelector);
		
		actualizarPiezas();
		
		repaint();
	}
}
