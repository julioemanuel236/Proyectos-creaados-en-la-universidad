package pieza;

import java.awt.Image;

import tablero.Tablero;
import visual.GestorMedia;

public class Torre extends Pieza{

	public static int DI[] = {0,1,0,-1};
	public static int DJ[] = {1,0,-1,0};
	
	private boolean primerMovimiento = true;
	
	public Torre(int i, int j, boolean color, Tablero tablero) {
		super(i, j, color, tablero,DI,DJ);
		
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



	@Override
	public Image getImage() {
		return GestorMedia.getTorreImage(isColor());
	}
	
	@Override
	public void moverA(Pieza p) {
		primerMovimiento = false;
		super.moverA(p);
	}
	
	@Override
	public void moverA(int i,int j) {
		primerMovimiento = false;
		super.moverA(i,j);
	}
	

}
