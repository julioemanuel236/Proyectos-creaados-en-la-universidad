package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import pieza.Pieza;

public class PreSeleccion extends Pintado{

	public PreSeleccion(Component c, Pieza sobre, int x, int y, int width, int hegith, Color color, long tiempo) {
		super(c, sobre, x, y, width, hegith, color, tiempo);
	}

	@Override
	public void actualizar(long time) {
		double porcentaje =  0.8+(((time)-(this.getTiempoInicio()))/((double)this.getTiempo())*0.2d);
		if(porcentaje > 1d)porcentaje = 1d;
						
		
		
		//System.err.println(x+ " "+ y + " "+ width+" "+height);
		//System.out.println(color);
		Graphics g2 = this.getComponent().getGraphics();
		g2.setColor(this.getColor());
											
		if(getSobre() != null) {
			Image img = ((Pieza)getSobre()).getImage();
			
			int w = img.getWidth(null);
			int h = img.getHeight(null);
			
			if(h>w) {
				double relacion = (double)w/(double)h;
				h = (int)(getHeight());
				w = (int)(((double)h)*relacion);
			}
			else if(w>h) {
				double relacion = (double)h/(double)w;
				w = (int)(getWidth());
				h = (int)(((double)w)*relacion);
			}
			
			w*=porcentaje;
			h*=porcentaje;					
			int x = (this.getX()+(this.getWidth()/2))-(w/2);
			int y = (this.getY()+(this.getHeight()/2))-(h/2);
			
			img = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
			g2.drawImage(img, x, y,null);
			
		}
		//component.repaint();
		if(time>getTiempoFinal())setTerminado(true);
	}
	
}
