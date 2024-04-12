package pieza;

import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;

import tablero.Tablero;
import visual.GestorMedia;

public class Alfil extends Pieza{

	public static final int DI[] = {1,1,-1,-1};	
	public static final int DJ[] = {1,-1,-1,1};
	
	public Alfil(int i, int j, boolean color, Tablero tablero) {
		super(i, j, color, tablero,DI,DJ);

	}

	@Override
	public Image getImage() {
		return GestorMedia.getAlfilImage(isColor());
	}

	@Override
	public void actualizarCasillasValidas() {		
		Pieza temp;
		limpiarListas();
		int i = getI();
		int j = getJ();
		
		//revisar para abajo
		
		for(int k=0;k<DI.length;k++) {
			for(int pasos = 1; ;pasos++) {
				int nextI = i + pasos*DI[k];
				int nextJ = j + pasos*DJ[k];
				if(nextI<0 || nextI>=8 || nextJ<0 || nextJ>=8)
					break;
				temp = getTablero().getPieza(nextI, nextJ);
				if(temp == null) {
					agregarCasillaDisponible(nextI, nextJ);
				}
				else if(temp.isColor()!=isColor()) {
					agregarCapturaDisonible(nextI, nextJ);
					break;
				}
				else break;
			}
		}
	}

}
