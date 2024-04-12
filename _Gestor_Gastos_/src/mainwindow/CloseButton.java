package mainwindow;

import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class CloseButton extends Button{
	
	JFrame ventana;
	private final long tiempoDesvanecimiento = 500;
	
	public CloseButton(Image img) {
		super(img);
		setSize(img.getWidth(null),img.getHeight(null));
		setDx(2);
		setDy(0);
	}
	
	@Override	
	public void mouseClicked(MouseEvent e) {
		
		long tInicio = System.currentTimeMillis();
		long tActual = 0;
		long tFinal = tiempoDesvanecimiento;
		
		while(tActual<=tFinal){
			
			
			try {
				float opacity = 1.0f-((float)tActual/(float)tFinal);				
				ventana.setOpacity(opacity);
				Thread.sleep(1000/144);
				
			}
			catch(Exception ee) {
				ee.printStackTrace();
			}
			tActual = System.currentTimeMillis() - tInicio;			
						
		}
		System.exit(0);
	
	}
	
	public void setVentana(JFrame ventana) {
		this.ventana = ventana;
	}
			
	
}
