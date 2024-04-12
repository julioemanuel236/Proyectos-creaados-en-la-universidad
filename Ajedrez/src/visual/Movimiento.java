package visual;
import java.awt.Component;
public class Movimiento extends Actualizable{
	
	private Component component;
	private int xObjetivo;
	private int yObjetivo;
	private int xInicial;
	private int yInicial;
	private long tiempoFinal;
	private long tiempoInicio;
	private long tiempo;
	private boolean terminado = false;
	
	public Movimiento(Component c,int x,int y,long tiempo) {
		this.component = c;
		this.xObjetivo = x;
		this.yObjetivo = y;
		this.tiempo = tiempo;
		this.tiempoInicio = System.currentTimeMillis();
		this.tiempoFinal = System.currentTimeMillis()+tiempo;
		this.xInicial = c.getX();
		this.yInicial = c.getY();
	}

	public void actualizar(long time) {
		
		double porcentaje =  ((time)-(this.tiempoInicio))/((double)this.tiempo);
		
		//System.out.println("TIEMPO TRANSCURRIDO: "+(System.currentTimeMillis()-this.tiempoInicio));		
		//System.out.println(porcentaje);
		
		int x = xInicial + (int)((double)(xObjetivo-xInicial)*porcentaje);
		int y = yInicial + (int)((double)(yObjetivo-yInicial)*porcentaje);		
		if(x>xObjetivo && xObjetivo>xInicial)x = xObjetivo;
		else if(x<xObjetivo && xObjetivo<xInicial)x = xObjetivo;
		
		if(y>yObjetivo && yObjetivo>yInicial)y = yObjetivo;
		else if(y<yObjetivo && yObjetivo<yInicial)y = yObjetivo;
		
		component.setLocation(x,y);
		//component.repaint();
		if(porcentaje>=1d)terminado = true;
		
	}
	
	public boolean yaTermino() {
		return this.terminado;
	}
}
