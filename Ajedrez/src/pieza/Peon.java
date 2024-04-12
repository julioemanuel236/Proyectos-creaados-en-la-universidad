package pieza;

import java.awt.Image;

import tablero.Tablero;
import visual.GestorMedia;
import visual.Movimiento;

public class Peon extends Pieza{

	private boolean primerPaso = true;
	private int paso;
	public Peon(int i, int j, boolean color,Tablero tablero,int paso) {
		super(i, j, color,tablero,new int[]{paso,paso},new int[]{1,-1});				
		this.paso = paso;
	}
	

	public void actualizarCasillasValidas() {
		Pieza temp;
		limpiarListas();
				
		int nextI = getI() + paso;
				
		if(nextI<0 || nextI == 8)return;
		
		int j = getJ();		
		
		if(nextI>=0 && nextI < 8 && getTablero().getPieza(nextI,getJ()) == null) { 			
			agregarCasillaDisponible(nextI, getJ());
		}
		
		if(j+1<8 ) {
			temp = getTablero().getPieza(nextI, j+1);
			if(temp != null && temp.isColor() != isColor())
				agregarCapturaDisonible(nextI , j+1);
		}
		
		if(j-1>=0) {
			temp = getTablero().getPieza(nextI, j-1);
			if(temp != null && temp.isColor() != isColor())
				agregarCapturaDisonible(nextI , j-1);
		}
						
		if(primerPaso) {
			nextI += paso;
			if(getTablero().getPieza(nextI-paso,getJ()) == null && getTablero().getPieza(nextI,getJ()) == null)
				agregarCasillaDisponible(nextI, getJ());			
		}
		
	}
	
	@Override
	public void moverA(Pieza p) {
		primerPaso = false;
		super.moverA(p);
	}
	
	@Override
	public void moverA(int i,int j) {
		primerPaso = false;
		super.moverA(i,j);
	}
	
	@Override
	public Image getImage() {
		Image img = GestorMedia.getPeonImage(isColor());	
		return img;
	}

	public int getPaso() {
		return paso;
	}

		

	
}
