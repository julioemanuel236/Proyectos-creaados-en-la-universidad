package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Pintado extends Actualizable{
	private Component component;
	private int x;
	private int y;	
	private long tiempoInicio;
	private long tiempoFinal;
	private long tiempo;
	private boolean terminado = false;
	private Color color;
	private int width;
	private int height;
	private Component sobre;
	
	public Pintado(Component c,Component sobre,int x,int y,int width,int hegith,Color color,long tiempo) {
		
		this.component = c;
		this.sobre = sobre;
		this.x = x;
		this.y = y;
		this.tiempo = tiempo;		
		this.tiempoInicio = System.currentTimeMillis();
		this.tiempoFinal = tiempoInicio + tiempo;
		this.color = color;
		this.width = width;
		this.height = hegith;
				
	}

	public void actualizar(long time) {
		
		double porcentaje =  ((time)-(this.tiempoInicio))/((double)this.tiempo);
		if(porcentaje > 1d)porcentaje = 1d;
		
		int width = (int)((double)this.width*porcentaje);
		int height =  (int)((double)this.height*porcentaje);
		int x = (this.x+(this.width/2))-(width/2);
		int y = (this.y+(this.height/2))-(height/2);
		
		//System.err.println(x+ " "+ y + " "+ width+" "+height);
		//System.out.println(color);
		Graphics g2 = this.component.getGraphics();
		g2.setColor(this.color);
				
		g2.fillRect(x, y, width, height);
						
		if(sobre != null)
			sobre.paint(g2.create(this.x, this.y, this.width, this.height));
		//component.repaint();
		if(porcentaje>=1d)terminado = true;
		
	}
	
	public void actualizar() {
		actualizar(System.currentTimeMillis());
	}
	
	public boolean yaTermino() {
		return this.terminado;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public long getTiempoInicio() {
		return tiempoInicio;
	}

	public void setTiempoInicio(long tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}

	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Component getSobre() {
		return sobre;
	}

	public void setSobre(Component sobre) {
		this.sobre = sobre;
	}

	public long getTiempoFinal() {
		return tiempoFinal;
	}

	public void setTiempoFinal(long tiempoFinal) {
		this.tiempoFinal = tiempoFinal;
	}
	
	
}
