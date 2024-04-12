package mainwindow;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class Component extends java.awt.Container {

	int Limitev;
	int Limiteh;

	private boolean mouseListener = false;

	boolean goinUp = false;
	boolean goinDown = false;
	boolean goinRight = false;
	boolean goinLeft = false;
	
	private boolean mouseIn = false;
	private long tiempoMovimiento = 100;
	
	private long lastTimeMouseEntry;
	private long lastTimeMouseExit;
	
	public static LinkedList<Component> COMPONENTS = new LinkedList<>();

	private Image img;

	public Component() {
		super();	
		COMPONENTS.addLast(this);
	}

	public int getLimitev() {
		return Limitev;
	}

	public void setLimitev(int limitev) {
		Limitev = limitev;
	}

	public int getLimiteh() {
		return Limiteh;
	}

	public void setLimiteh(int limiteh) {
		Limiteh = limiteh;
	}

	public boolean isGoinUp() {
		return goinUp;
	}

	public boolean isGoinDown() {
		return goinDown;
	}

	public boolean isGoinRight() {
		return goinRight;
	}

	public boolean isGoinLeft() {
		return goinLeft;
	}

	public Component(Image img) {
		super();
		COMPONENTS.addLast(this);
		this.img = img;
		setSize(img.getWidth(null), img.getHeight(null));
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, 0, 0, null);
		super.paint(g);
	}

	public Image getImg() {
		return img;
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void processMouseMove(int x, int y) {
		// System.out.println(x + " " + y);
		if (mouseEntry(x, y)) {
			 //System.out.println("MOUSE ENTRY FROM "+getClass().getSimpleName());
			lastTimeMouseEntry = System.currentTimeMillis();
			mouseEnter();
		} else if (mouseLeave(x, y)) {
			 //System.out.println("MOUSE EXIT "+getClass().getSimpleName());
			lastTimeMouseExit = System.currentTimeMillis();				
			mouseExit();
		}
		// System.out.println("MANDANDO "+x+" "+y);
		mouseMove(x, y);
	}

	public boolean mouseEntry(int x, int y) {
		x -= getAbsoluteX();
		y -= getAbsoluteY();
		// System.out.println(x + " " + y + " "+ getClass().getSimpleName());
		if (x >= 0 && x <= getWidth() && y >= 0 && y <= getHeight() && !mouseIn) {
			// System.out.println("ENTRANDO A"+getClass().getSimpleName());
			return mouseIn = true;
		}

		return false;
	}

	public boolean isMouseIn() {
		return mouseIn;
	}

	public void setMouseIn(boolean mouseIn) {
		this.mouseIn = mouseIn;
	}

	public boolean mouseLeave(int x, int y) {
		x -= getAbsoluteX();
		y -= getAbsoluteY();
		if ((x < 0 || x > getWidth() || y < 0 || y > getHeight()) && mouseIn) {
			// System.out.println("SALIENDO DE"+getClass().getSimpleName());
			mouseIn = false;
			return true;
		}

		return false;
	}

	public void mouseMove(int x, int y) {

	}

	public void mouseEnter() {

	}

	public void mouseExit() {

	}

	public int getAbsoluteX() {
		int x = 0;
		Container a = this;
		while (a.getParent() != null) {
			x += a.getX();
			a = a.getParent();
		}

		return x + a.getX();
	}

	public int getAbsoluteY() {
		int y = 0;
		Container a = this;
		while (a.getParent() != null) {
			y += a.getY();
			a = a.getParent();
		}

		return y + a.getY();
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void proccesMouseEvent(MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_RELEASED)
			mouseReleased(e);
		else if (e.getID() == MouseEvent.MOUSE_PRESSED)
			mousePressed(e);
		else if (e.getID() == MouseEvent.MOUSE_CLICKED)
			mouseClicked(e);
	}

	public void mousePressed(MouseEvent e) {

	}

	public void setImg(Image img) {
		this.img = img;
		// setSize(img.getWidth(null),img.getHeight(null));
	}

	public boolean over(int x, int y) {
		x -= getAbsoluteX();
		y -= getAbsoluteY();
		return x >= 0 && x <= getWidth() && y >= 0 && y < getHeight();
	}

	public final int textHeight(Font f, String texto) {
		return getFontMetrics(f).getAscent();
	}

	public final int textWidth(Font f, String texto) {
		int width = 0;
		int[] arr = getFontMetrics(f).getWidths();

		for (int i = 0; i < texto.length(); i++)
			width += arr[texto.charAt(i)];

		return width;
	}

	public Font ajustarFuente(Font font, int height) {

		while (getFontMetrics(font).getHeight() < height) {
			font = new Font(font.getFontName(), font.getStyle(), font.getSize() + 1);
		}

		while (getFontMetrics(font).getHeight() > height) {
			font = new Font(font.getFontName(), font.getStyle(), font.getSize() - 1);
		}

		return font;
	}

	public void pintarTexto(Graphics g, String nombre, int x, int y, int width, int height, Font font) {
		
		int alto = textHeight(font, nombre);
		int w = 0;
		int h = 0;
		while (w < width && h < height) {
			w = 0;
			h = 0;
			alto++;
			font = ajustarFuente(font, alto);
			w = textWidth(font, nombre);
			h = textHeight(font, nombre);
		}

		while (w >= width || h >= height) {
			w = 0;
			alto--;
			font = ajustarFuente(font, alto);
			w = textWidth(font, nombre);
			h = textHeight(font, nombre);
		}
		// System.out.println(height + " <= " + h);

		g.setColor(getForeground());
		g.setFont(font);
		g.drawString(nombre, x + ((width - w) / 2), y + height - ((height - h) / 2));
		
	}

	@Override
	public void setSize(int w, int h) {
		super.setSize(w, h);
		if (this.img != null) {
			//System.out.println("ESCALANDO LA IMAGEN DE ESTE "+ getClass().getSimpleName()+" A "+ w + "X" + h);
			this.img = this.img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		}
	}

	

	protected void UP() {

		goinUp = true;
		goinDown = false;
		(new Thread() {
			public void run() {
				
				long ini = System.currentTimeMillis();
				long fin = tiempoMovimiento;
				
				long actual = 0;
				
				int k = Math.max(1, (Limitev - getHeight())/144);
				int y = getY();
				
				while (goinUp && actual < fin) {
					int yObj = Limitev - getHeight();
					double perc = (double)actual/fin;
					int posY = y + (int)((yObj - y)*perc);
					Component.super.setLocation(getX(), posY);
					// if (k > 2)
					k++;
					try {
						sleep(1000/144);
						repaint();
					} catch (Exception e) {

					}
					actual = System.currentTimeMillis() - ini;
				}
				if (!goinUp)
					return;
				setLocation(getX(), -getHeight());
				goinUp = false;
				movimientoFinalizado();
			}
		}).start();
	}

	protected void RIGHT() {

		goinRight = true;
		goinLeft = false;
		(new Thread() {
			public void run() {
				long ini = System.currentTimeMillis();
				long fin = tiempoMovimiento;
				
				long actual = 0;
				
				int k = Math.max(1, (Limitev - getHeight())/144);
				int x = getX();
				int xObj = Limiteh ;
				
				while (goinRight && actual < fin) {
					
					double perc = (double)actual/fin;
					int posX = x + (int)((double)(xObj - x)*perc);
					Component.super.setLocation(posX, getY());
					// if (k > 2)
					k++;
					try {
						sleep(1000/144);
						repaint();
					} catch (Exception e) {

					}
					actual = System.currentTimeMillis() - ini;
				}
				if (!goinRight)
					return;
				setLocation(Limiteh, getY());
				goinRight = false;
				movimientoFinalizado();
			}
		}).start();
	}

	protected void LEFT() {

		goinLeft = true;
		goinRight = false;
		(new Thread() {
			public void run() {
				long ini = System.currentTimeMillis();
				long fin = tiempoMovimiento;
				
				long actual = 0;
				
				int k = Math.max(1, (Limitev - getHeight())/144);
				int x = getX();
								
				while (goinLeft && actual < fin) {
					int xObj = Limiteh - getWidth();
					double perc = (double)actual/fin;
					int posX = x + (int)((double)(xObj - x)*perc);
					Component.super.setLocation(posX, getY());
					// if (k > 2)
					k++;
					try {
						sleep(1000/144);
						repaint();
					} catch (Exception e) {

					}
					actual = System.currentTimeMillis() - ini;
				}
				if (!goinLeft)
					return;
				setLocation(Limiteh - getWidth(), getY());
				goinLeft = false;
				movimientoFinalizado();
			}
		}).start();
		
	}

	protected void DOWN() {
		goinDown = true;
		goinUp = false;
		(new Thread() {
			public void run() {
				
				long ini = System.currentTimeMillis();
				long fin = tiempoMovimiento;
				
				long actual = 0;
				
				int k = Math.max(1, (Limitev - getHeight())/144);
				int y = getY();

				int yObj = Limitev;
				while (goinDown && actual < fin) {
					
					double perc = (double)actual/fin;
					int posY = y + (int)((yObj - y)*perc);
					Component.super.setLocation(getX(), posY);
					try {
						sleep(1000/144);
						repaint();
					} 
					catch (Exception e) {

					}
					actual = System.currentTimeMillis() - ini;
					
				}
				if (!goinDown)
					return;
				setLocation(getX(), getY());
				goinDown = false;
				movimientoFinalizado();
			}
		}).start();
	}

	
	public long getTiempoMovimiento() {
		return tiempoMovimiento;
	}

	public void setTiempoMovimiento(long tiempoMovimiento) {
		this.tiempoMovimiento = tiempoMovimiento;
	}

	public void movimientoFinalizado() {
		
	}

	public long getLastTimeMouseEntry() {
		return lastTimeMouseEntry;
	}

	public void setLastTimeMouseEntry(long lastTimeMouseEntry) {
		this.lastTimeMouseEntry = lastTimeMouseEntry;
	}

	public long getLastTimeMouseExit() {
		return lastTimeMouseExit;
	}

	public void setLastTimeMouseExit(long lastTimeMouseExit) {
		this.lastTimeMouseExit = lastTimeMouseExit;
	}

	public void setGoinUp(boolean goinUp) {
		this.goinUp = goinUp;
	}

	public void setGoinDown(boolean goinDown) {
		this.goinDown = goinDown;
	}

	public void setGoinRight(boolean goinRight) {
		this.goinRight = goinRight;
	}

	public void setGoinLeft(boolean goinLeft) {
		this.goinLeft = goinLeft;
	}
	
	public boolean isMoving() {
		return goinDown || goinUp || goinRight || goinLeft;
	}
	
	
	public boolean isMouseListener() {
		return mouseListener;
	}

	public void activeMouseListener(){
		
		if(this.mouseListener)
			return;
		
		this.mouseListener = true;
		COMPONENTS.addLast(this);
	}
	
}
	
