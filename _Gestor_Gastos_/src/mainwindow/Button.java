package mainwindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import ventana.Imagen;

public class Button extends Component{

	private boolean over=false;
	private boolean clicked=false;
	private boolean reseting = false;
	
	private int maxwidth;
	private int maxheight;
	private int minwidth;
	private int minheight;
	private int delay = 1000/144;
	private int recoverX;
	private int recoverY;
	
	private int crecimiento = 2;
	private int dx = 1;
	private int dy = 1;
	private long tiempoAnimacion = 50;
	private long reactionTime = 0;
	private Image recoverImg;
	
	private double porcentajeAumento = 1.20d;
	
	public Button() {
		super();
		activeMouseListener();
	}

	public Button(Image img) {
		super(img);		
		setSize(img.getWidth(null),img.getHeight(null));
		setRecoverImg(img);		
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	@Override
	public void mouseEnter(){
		sizeIncrement();			
	}
	
	public void sizeIncrement() {
		//System.out.println("ENTRANDO");
				over=true;
				(new Thread(){
					public void run() {
						//CODIGO PARA ESPERAR UN TIEMPO ANTES DE REACCIONAR A EL MOUSE ENTER EVENT
						long ini = System.currentTimeMillis();
						long fin = System.currentTimeMillis()+reactionTime;
						
						while(System.currentTimeMillis()<fin) {
							try {
								Thread.sleep(1);
							}
							catch(Exception e) {
								
							}
						
						}
						
						//CODIGO DE AGRANDADO		
						double sizePerc = ((double)getWidth()/minwidth) - 1.0d;
						long adelanto = (long)(sizePerc * tiempoAnimacion);
						ini = System.currentTimeMillis();
						fin = ini + tiempoAnimacion;
						long actual = adelanto + System.currentTimeMillis() ;
						//while(over&&(getWidth()<maxwidth||getHeight()<maxheight)) {
						while(over && actual < fin) {
																
							while(reseting) {
								try {
									Thread.sleep(1);
								}
								catch(Exception e) {
									
								}
							}
																	
							double perc = (actual-ini)/(double)tiempoAnimacion;
							int crecimientoX = (int)((maxwidth-minwidth)*perc);
							int crecimientoY = (int)((maxheight-minheight)*perc);
							//System.out.println("VOY A PONERLO EN " + getRecoverX() + " " + getRecoverY());
							Button.super.setSize(minwidth+crecimientoX,minheight+crecimientoY);
							Button.super.setLocation(getRecoverX(),getRecoverY());
							Button.super.setImg(recoverImg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
							//System.out.println("X: "+ (centerX + (getWidth()/2) ));
							
							repaint();
						
							try {
								sleep(delay);
							}
							catch(Exception e) {
								
							}
							actual = adelanto + System.currentTimeMillis() ;
						}
						
						if(over) {
							Button.super.setSize(maxwidth,maxheight);
							Button.super.setLocation(getRecoverX(),getRecoverY());
							Button.super.setImg(recoverImg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
						}
					}
				}).start();
				
	}
	
	@Override
	public void mouseExit() {
		sizeDecrement();
	}
	
	public void sizeDecrement() {
		//System.out.println("SALIENDO");
		over=false;
		(new Thread() {
			public void run() {
				//CODIGO DE AGRANDADO
								
				double sizePerc = 1 - (((double)getWidth()/maxwidth) - 1.0d);
				//System.out.println("INICIO DECRECIMIENTO :" + sizePerc);
				long adelanto = tiempoAnimacion - (long)(sizePerc * tiempoAnimacion);
				long ini = System.currentTimeMillis();
				long fin = ini + tiempoAnimacion;
				long actual = adelanto + System.currentTimeMillis() ;
				//while(!over&&(getWidth()<maxwidth||getHeight()<maxheight)) {
				while(!over && actual < fin) {
														
					while(reseting) {
						try {
							Thread.sleep(1);
						}
						catch(Exception e) {
							
						}
					}
					
					double perc = 1 - (actual-ini)/(double)tiempoAnimacion;
					//System.out.println("DECRECIMIENTO: " + perc);
					int crecimientoX = (int)((maxwidth-minwidth)*perc);
					int crecimientoY = (int)((maxheight-minheight)*perc);
					
					Button.super.setSize(minwidth+crecimientoX,minheight+crecimientoY);
					Button.super.setLocation(getRecoverX(),getRecoverY());
					Button.super.setImg(recoverImg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
					repaint();
				
					try {
						sleep(delay);
					}
					catch(Exception e) {
						
					}
					actual = adelanto + System.currentTimeMillis() ;
				}
				
				reseting = true;
				Button.super.setSize(minwidth, minheight);
				Button.super.setLocation(getRecoverX(),getRecoverY());
				Button.super.setImg(recoverImg);
				reseting = false;
			}
		}).start();
		

	}
	
	public void setRecoverImg(Image img) {
		recoverImg = img.getScaledInstance(img.getWidth(null), img.getHeight(null), Image.SCALE_SMOOTH);
	}
			
	@Override
	public void mouseClicked(MouseEvent e) {
		action();		
	}
	
	@Override
	public void movimientoFinalizado() {
		setLocation(getX(),getY());
	}

	public void action() {
		
	}
			
	public int getRecoverX() {
		return recoverX - (getWidth()/2);
	}

	public int getRecoverY() {
		return recoverY - (getHeight()/2);
	}
	
	@Override
	public void setLocation(int x,int y) {
		super.setLocation(x, y);
		//System.out.println("MODIFICANDO RECOVER");
		recoverX = x + (getWidth()/2);
		recoverY = y + (getHeight()/2);		
	}
	
	@Override
	public void setSize(int w,int h) {
		super.setSize(w,h);
		if(getRecoverImg()!=null)
			setRecoverImg(getRecoverImg().getScaledInstance(w, h, Image.SCALE_SMOOTH));
		maxwidth=(int)(getWidth()*porcentajeAumento);
		maxheight=(int)(getHeight()*porcentajeAumento);
		minwidth=getWidth();
		minheight=getHeight();
		
	}
	
	public Image getRecoverImg() {
		return recoverImg;
	}

	public int getCrecimiento() {
		return crecimiento;
	}

	public void setCrecimiento(int crecimiento) {
		this.crecimiento = crecimiento;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public double getPorcentajeAumento() {
		return porcentajeAumento;
	}

	public void setPorcentajeAumento(double porcentajeAumento) {
		this.porcentajeAumento = porcentajeAumento;
	}

	public long getTiempoAnimacion() {
		return tiempoAnimacion;
	}

	public void setTiempoAnimacion(long tiempoAnimacion) {
		this.tiempoAnimacion = tiempoAnimacion;
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public boolean isReseting() {
		return reseting;
	}

	public void setReseting(boolean reseting) {
		this.reseting = reseting;
	}

	public int getMaxwidth() {
		return maxwidth;
	}

	public void setMaxwidth(int maxwidth) {
		this.maxwidth = maxwidth;
	}

	public int getMaxheight() {
		return maxheight;
	}

	public void setMaxheight(int maxheight) {
		this.maxheight = maxheight;
	}

	public int getMinwidth() {
		return minwidth;
	}

	public void setMinwidth(int minwidth) {
		this.minwidth = minwidth;
	}

	public int getMinheight() {
		return minheight;
	}

	public void setMinheight(int minheight) {
		this.minheight = minheight;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public long getReactionTime() {
		return reactionTime;
	}

	public void setReactionTime(long reactionTime) {
		this.reactionTime = reactionTime;
	}

	public void setRecoverX(int recoverX) {
		this.recoverX = recoverX;
	}

	public void setRecoverY(int recoverY) {
		this.recoverY = recoverY;
	}
	
	
	
}
