package mainwindow;

import java.awt.Image;
import java.awt.event.MouseEvent;

public class Bar extends Component{
	
	private java.awt.Component ventana;
	
	private int lastX;
	private int lastY;
	
	private int ventanaLastX;
	private int ventanaLastY;
	
	private boolean draggin = false;
	private boolean pressed = false;
	
	public Bar(Image img) {
		super(img);
		setSize(img.getWidth(null),img.getHeight(null));
		activeMouseListener();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {		
		if(!pressed){
			
			pressed = true;		
			lastX = e.getX() + getAbsoluteX();
			lastY = e.getY() + getAbsoluteY();
			
			if(ventana!=null) {
				ventanaLastX = ventana.getX();
				ventanaLastY = ventana.getY();
			}
			//System.out.println("MARCANDO EN "+lastX+ " "+lastY);
		}
				
		//System.out.println("BAR PRESIONADA");
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {		
		draggin = false;
		pressed = false;
	}
	
	@Override
	public void mouseMove(int x,int y) {
		
		//System.out.println(x + " " + y);
		
		if(pressed) {
			if(Math.abs(x-lastX) > 10 || 
			   Math.abs(y-lastY) > 10 )			
					draggin = true;
			//System.out.println("DISTANCIA SUPERADA");
		}
		else {
			//System.out.println("DISTANCIA NO SUPERADA");
		}
		if(draggin) {
			//System.out.println("ARRSATRANDO");
			x -= lastX;
			y -= lastY;
			if(ventana != null)
			ventana.setLocation(ventanaLastX+x,ventanaLastY+y);
		}
		
	}

	public void setVentana(java.awt.Component ventana) {
		this.ventana = ventana;
	}
	
	
}
