package pieza;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import tablero.Tablero;
import visual.GestorMovimiento;

public abstract class Pieza extends Component implements MouseListener{
	
	//atributos

	private int i;
	private int j;
	private boolean color;	
	private Tablero tablero;
				
	private final int[] DI;
	private final int[] DJ;
	
	private LinkedList<Point> movimientos = new LinkedList<>();
	private LinkedList<Point> capturas = new LinkedList<>();
	
	private boolean marcada = false;
	
	public Pieza(int i,int j,boolean color,Tablero tablero,int[] di,int[] dj) {
		this.DI = di;
		this.DJ = dj;
		this.i = i;
		this.j = j;	
		
		this.color = color;		
		this.tablero = tablero;
		if(tablero != null) {
			setLocation(tablero.getAnchoCasilla()*j,tablero.getAltoCasilla()*i);
			setSize(tablero.getAnchoCasilla(),tablero.getAltoCasilla());
			tablero.add(this);
		}
			
		//System.out.println("PEON CREADO");
		addMouseListener(this);
		//System.out.println(this);
		
	}
				
	public int[] getDI() {
		return DI;
	}

	public int[] getDJ() {
		return DJ;
	}

	public LinkedList<Point> getCasillasCapturas(){
		return capturas;
	}
		
	public LinkedList<Point> getCasillasMovimiento(){
		return movimientos;
	}
	
	public void morir() {
		setVisible(false);
	}

	public int getI() {
		return i;
	}

	public void moverA(Pieza p) {
		GestorMovimiento.agregarMovimiento(this, p.getX(), p.getY(), 250);
		setI(p.getI());
		setJ(p.getJ());
		GestorMovimiento.run();		
	}
	
	public void moverA(int i,int j) {
		int width = tablero.getAnchoCasilla();
		int height = tablero.getAltoCasilla();
		GestorMovimiento.agregarMovimiento(this, j*width, i*height, 250);
		setI(i);
		setJ(j);
		GestorMovimiento.run();
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public Tablero getTablero() {		
		return tablero;		
	}

	public void setTablero(Tablero tablero) {
		setLocation(tablero.getAnchoCasilla()*j,tablero.getAltoCasilla()*i);
		setSize(tablero.getAnchoCasilla(),tablero.getAltoCasilla());
		this.tablero = tablero;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	}

	@Override
	public void mousePressed(MouseEvent e) {		
		tablero.notificarSeleccion(this,i,j);		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		tablero.notificarHover(this);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	public abstract void actualizarCasillasValidas();
	
	public abstract Image getImage();
	
	@Override
	public void paint(Graphics g) {		
		//System.out.println("MEH");
		Image img = getImage();
		if(img == null) {
			System.out.println("IMAGEN NULL");
			g.setColor(Color.red);
			g.fillRect(0, 0,getWidth(), getHeight());
		}
		
		else {
			setSize(tablero.getAnchoCasilla(),tablero.getAltoCasilla());
			//System.out.println(getSize());
			int w = img.getWidth(null);
			int h = img.getHeight(null);
			
			if(h>w) {
				double relacion = (double)w/(double)h;
				h = (int)(getHeight()*0.8f);
				w = (int)(((double)h)*relacion);
			}
			else if(w>h) {
				double relacion = (double)h/(double)w;
				w = (int)(getWidth()*0.8f);
				h = (int)(((double)w)*relacion);
			}
			
			int x = (getWidth()/2) - (w/2);
			int y = (getHeight()/2) - (h/2);
			
			g.setColor(new Color(0,0,0,1));
			g.fillRect(0, 0, getWidth(), getHeight());
			img = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
			g.drawImage(img, x, y, null);
		}
		
	}

	public void limpiarListas() {
		movimientos.clear();
		capturas.clear();
	}
	
	public void agregarCasillaDisponible(int i,int j) {
		if(!poneEnJakeAMiRey(i, j))
			movimientos.add(new Point(i,j));
	}
	
	public void agregarCapturaDisonible(int i,int j) {
		if(!poneEnJakeAMiRey(i, j))
			capturas.add(new Point(i,j));
	}
	
	public boolean poneEnJakeAMiRey(int i,int j) {
		
		Pieza temp = tablero.getPieza(i, j);
		int miI = getI();
		int miJ = getJ();
		tablero.setPiezaEnMatrix(null, getI(), getJ());
		tablero.setPiezaEnMatrix(this, i, j);
		setI(i);
		setJ(j);
		Rey rey = (color?tablero.getReyNegro():tablero.getReyBlanco());
		if(rey == null)return false;
		
		boolean resultado = rey.isJake();
		tablero.setPiezaEnMatrix(temp, i, j);
		tablero.setPiezaEnMatrix(this, miI, miJ);
		setI(miI);
		setJ(miJ);
		
		return resultado;
		
	}

	public boolean puedeMover() {
		return !movimientos.isEmpty() || !capturas.isEmpty();
	}
	
	public boolean isMarcada() {
		return marcada;
	}
	
	public void marcar() {
		marcada = true;
	}
	
	public void desmarcar() {
		marcada = false;
	}
}
