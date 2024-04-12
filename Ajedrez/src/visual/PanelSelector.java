package visual;


import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import pieza.Alfil;
import pieza.Caballo;
import pieza.Pieza;
import pieza.Reyna;
import pieza.Torre;
import java.lang.Math;
public class PanelSelector extends Container{

	private BotonSelector botonesEleccion[] = new BotonSelector[4];
	
	public PanelSelector(Pieza temp,int ancho,int alto,int anchoCasilla,int altoCasilla) {
		
		setSize(ancho,alto);
		setLocation(0,0);
		
		botonesEleccion[0] = new BotonSelector(temp,new Alfil(temp.getI(),temp.getJ(),temp.isColor(),null));
		botonesEleccion[1] = new BotonSelector(temp,new Torre(temp.getI(),temp.getJ(),temp.isColor(),null));
		botonesEleccion[2] = new BotonSelector(temp,new Reyna(temp.getI(),temp.getJ(),temp.isColor(),null));
		botonesEleccion[3] = new BotonSelector(temp,new Caballo(temp.getI(),temp.getJ(),temp.isColor(),null));
		botonesEleccion[0].setSize(anchoCasilla,altoCasilla);
		botonesEleccion[1].setSize(botonesEleccion[0].getSize());
		botonesEleccion[2].setSize(botonesEleccion[0].getSize());
		botonesEleccion[3].setSize(botonesEleccion[0].getSize());
							
		int w = anchoCasilla*4;
		int h = altoCasilla;
		int x = (getWidth()/2)-(w/2);
		int y = (getHeight()/2)-(h/2);
		
		long tiempoPrimera = 250;
		long retraso = 100;
		int velocidad = 100;
		for(int i=0;i<botonesEleccion.length;i++) {
			botonesEleccion[i].setSize(anchoCasilla,altoCasilla);
			botonesEleccion[i].setLocation(temp.getX(),temp.getY());
			add(botonesEleccion[i],0);
			int xFinal = x+(botonesEleccion[i].getWidth()*i);
			int distancia = (int)Math.sqrt((Math.pow(Math.abs(xFinal-temp.getX()),2)) + (Math.pow(Math.abs(temp.getY()-y),2)));
			GestorMovimiento.agregarMovimiento(botonesEleccion[i], xFinal , y, distancia);
			//botonesEleccion[i].setVisible(true);
		}
		GestorMovimiento.run();
	}
	
	public void paint(Graphics g) {
	
		g.setColor(new Color(0,0,0,125));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		super.paint(g);
	
	}
}

