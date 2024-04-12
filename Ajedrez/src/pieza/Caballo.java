package pieza;

import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;

import tablero.Tablero;
import visual.GestorMedia;

public class Caballo extends Pieza {
		
	public static final int DI[] = {-2,-1,1,2,2,1,-1,-2};
	public static final int DJ[] = {1,2,2,1,-1,-2,-2,-1};
	
	public Caballo(int i, int j, boolean color, Tablero tablero) {
		super(i, j, color, tablero,DI,DJ);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Image getImage() {
		return GestorMedia.getCaballoImage(isColor());
	}

	
	@Override
	public void actualizarCasillasValidas() {
		limpiarListas();
		for(int k=0;k<DI.length;k++) {
			int i = getI() + DI[k];
			int j = getJ() + DJ[k];
			if(i<0||i>=8||j<0||j>=8)continue;
			Pieza temp = getTablero().getPieza(i,j); 
			if(temp == null)agregarCasillaDisponible(i, j);
			else if(temp.isColor() != isColor())agregarCapturaDisonible(i, j);
		}
		
	}
	

}
