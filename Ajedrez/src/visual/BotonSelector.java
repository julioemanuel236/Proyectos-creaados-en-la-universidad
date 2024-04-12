package visual;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import pieza.Pieza;

import java.awt.Color;

public class BotonSelector extends Component implements MouseListener{

	private Color overColor = new Color(50,200,100,150).brighter();
	private Color background = new Color(0,0,0,0);
	private long tiempoAnimacion = 150;
	
	private Image icon;
	
	Thread overThread;
	Thread outThread;
	Pieza pieza;
	Pieza piezaNueva;
	private boolean changingBackground = false;
	
	public BotonSelector(Pieza pieza,Pieza piezaNueva) {
		this.pieza = pieza;
		setIcon(piezaNueva.getImage());
		this.piezaNueva = piezaNueva;
		addMouseListener(this);
		setBackground(background);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		pieza.setVisible(false);
		pieza.getTablero().setPieza(piezaNueva,pieza.getI(), pieza.getJ());
		pieza.getTablero().notificarCambioPeon();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		changingBackground = false;
		
		if(outThread == null && overThread == null) {			
			iniciarMouseEnterThread();
			//System.out.println("INICIADO ENTRADA NORMAL");
		}
			
	}

	@Override
	public void mouseExited(MouseEvent e) {		
		changingBackground = false;
		
		if(outThread == null && overThread == null) {	
			iniciarMouseExitThread();
			//System.out.println("INICIADO SALIDA NORMAL");
		}
		
	}

	public void iniciarMouseEnterThread() {
		overThread = 
		(new Thread() {
			public void run() {
				changingBackground = true;
				int rObjetivo = overColor.getRed();
				int gObjetivo = overColor.getGreen();
				int bObjetivo = overColor.getBlue();
				int aObjetivo = overColor.getAlpha();
				long inicio = System.currentTimeMillis();
				boolean animar = true;Color backg = getBackground();
				
				int rInicial= backg.getRed();
				int gInicial= backg.getGreen();
				int bInicial= backg.getBlue();
				int aInicial= backg.getAlpha();
												
				while(animar) {
					if(!changingBackground) {
						iniciarMouseExitThread();
						overThread = null;						
						//System.err.println(getName() + " TERMINADO ENTRADO FORAZADO ");
						
						return;
					}
					Color fondo = getBackground();
					double porcentaje = (double)(System.currentTimeMillis() - inicio)/(double)tiempoAnimacion;
					if(System.currentTimeMillis()> inicio+tiempoAnimacion) {
						porcentaje = 1d;
						animar = false;
					}
					int ra = rInicial + (int)((rObjetivo - rInicial) * porcentaje);
					int ga = gInicial + (int)((gObjetivo - gInicial) * porcentaje);
					int ba = bInicial + (int)((bObjetivo - bInicial) * porcentaje);
					int aa = aInicial + (int)((aObjetivo - aInicial) * porcentaje);					
					/*
					System.out.println(ra + " / " + rObjetivo + " " + porcentaje);
					System.out.println(ga + " / " + gObjetivo + " " + porcentaje);
					System.out.println(ba + " / " + bObjetivo + " " + porcentaje);
					System.out.println(aa + " / " + aObjetivo + " " + porcentaje);
					*/
					Color actual = new Color(ra,ga,ba,aa);
					
					setBackground(actual);
					repaint();
					try {
						sleep(1000/144);
					}
					catch(Exception e) {
						
					}
					
				}
				overThread = null;
				//System.err.println(getName() + " TERMINADO ENTRADO");
				
				
			}
		});
		overThread.start();
	}
	
	public void iniciarMouseExitThread() {
		outThread = 
				(new Thread() {
					public void run() {
						changingBackground = true;
						int rObjetivo = background.getRed();
						int gObjetivo = background.getGreen();
						int bObjetivo = background.getBlue();
						int aObjetivo = background.getAlpha();
						
						Color backg = getBackground();
						
						int rInicial= backg.getRed();
						int gInicial= backg.getGreen();
						int bInicial= backg.getBlue();
						int aInicial= backg.getAlpha();
						
						long inicio = System.currentTimeMillis();
						boolean animar = true;
						while(animar) {
							if(!changingBackground) {
								iniciarMouseEnterThread();
								outThread = null;												
								//System.err.println(getName() + " TERMINADO SALIDA FORAZADO ");
										
								return;
							}
							Color fondo = getBackground();
							double porcentaje = (double)(System.currentTimeMillis() - inicio)/(double)tiempoAnimacion;
							if(System.currentTimeMillis()> inicio+tiempoAnimacion) {
								porcentaje = 1d;
								animar = false;
							}
							int ra = rInicial + (int)((rObjetivo - rInicial) * porcentaje);
							int ga = gInicial + (int)((gObjetivo - gInicial) * porcentaje);
							int ba = bInicial + (int)((bObjetivo - bInicial) * porcentaje);
							int aa = aInicial + (int)((aObjetivo - aInicial) * porcentaje);
							/*
							System.out.println(ra + " " + ga + " " + ba + " " + aa + " " + porcentaje);					
							*/
							Color actual = new Color(ra,ga,ba,aa);
							
							setBackground(actual);
							repaint();
							try {
								sleep(1000/144);
							}
							catch(Exception e) {
								
							}
						}
						outThread = null;
						//System.err.println(getName() + " TERMINADO SALIDA");
						
					}
				});
		outThread.start();
	}
	
	private  void pintarImagen(Graphics g) {
		if(icon == null)return;
		int w = icon.getWidth(null);
		int h = icon.getHeight(null);
		
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
		icon = icon.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		g.drawImage(icon,x, y, null);
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());			
		pintarImagen(g);
		
	}

	public Image getIcon() {
		return icon;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}
	
}
