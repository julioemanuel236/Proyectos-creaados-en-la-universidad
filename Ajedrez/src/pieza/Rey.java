package pieza;

import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;

import tablero.Tablero;
import visual.GestorMedia;

public class Rey extends Pieza {

	public static int DI[] = {0,1,1,1,0,-1,-1,-1};	
	public static int DJ[] = {1,1,0,-1,-1,-1,0,1};
		
	private boolean primerMovimiento = true;
	
	public Rey(int i, int j, boolean color, Tablero tablero) {
		super(i, j, color, tablero,DI,DJ);
		if(color)tablero.setReyNegro(this);
		else tablero.setReyBlanco(this);
		// TODO Auto-generated constructor stub
	}

	private boolean reyContrarioCerca(int i,int j) {
		Pieza temp;
		for(int k=0;k<DI.length;k++) {			
		
			int nextI = i + DI[k];
			int nextJ = j + DJ[k];
			if(nextI<0 || nextI>=8 || nextJ<0 || nextJ>=8)
				continue;
			temp = getTablero().getPieza(nextI, nextJ);
			
			if(temp == null) 
				continue;
			
			else if(temp.isColor()!=isColor() && (temp instanceof Rey)) 				
				return true;
					
		}
		
		return false;
	}

	@Override
	public void actualizarCasillasValidas() {
		Pieza temp;
		limpiarListas();
		int i = getI();
		int j = getJ();
				
		for(int k=0;k<DI.length;k++) {			
			int nextI = i + DI[k];
			int nextJ = j + DJ[k];
			if(nextI<0 || nextI>=8 || nextJ<0 || nextJ>=8)
				continue;
			temp = getTablero().getPieza(nextI, nextJ);
			if(temp == null) {
				if(!reyContrarioCerca(nextI,nextJ))
					agregarCasillaDisponible(nextI, nextJ);
			}
			else if(temp.isColor()!=isColor()) {
				if(!reyContrarioCerca(nextI,nextJ))
					agregarCapturaDisonible(nextI, nextJ);
				continue;
			}
			else continue;		
		}
		
	}

	public boolean isJakeAlfil() {
		Pieza temp;
		int di[] = Alfil.DI;
		int dj[] = Alfil.DJ;
		int i = getI();
		int j = getJ();
		
		//revisar para abajo
		
		for(int k=0;k<di.length;k++) {
			for(int pasos = 1; ;pasos++) {
				int nextI = i + pasos*di[k];
				int nextJ = j + pasos*dj[k];
				if(nextI<0 || nextI>=8 || nextJ<0 || nextJ>=8)
					break;
				temp = getTablero().getPieza(nextI, nextJ);
					
				if(temp!=null ) {
					if(temp.isColor() == isColor())
						break;
					else {
						if(temp instanceof Alfil)
							return true;
						else break;
					}
											
				}
				
			}
		}
		return false;
	}

	public boolean isJakeTorre() {
		Pieza temp;
		int di[] = Torre.DI;
		int dj[] = Torre.DJ;
		int i = getI();
		int j = getJ();
		
		//revisar para abajo
		
		for(int k=0;k<di.length;k++) {
			for(int pasos = 1; ;pasos++) {
				int nextI = i + pasos*di[k];
				int nextJ = j + pasos*dj[k];
				if(nextI<0 || nextI>=8 || nextJ<0 || nextJ>=8)
					break;
				temp = getTablero().getPieza(nextI, nextJ);
											
				if(temp!=null ) {
					if(temp.isColor() == isColor())
						break;
					else {
						if(temp instanceof Torre)
							return true;
						else break;
					}
											
				}
			}
		}
		return false;
	}

	public boolean isJakeReyna() {
		Pieza temp;
		int di[] = Reyna.DI;
		int dj[] = Reyna.DJ;
		int i = getI();
		int j = getJ();
		
		//revisar para abajo
		
		for(int k=0;k<di.length;k++) {
			for(int pasos = 1; ;pasos++) {
				int nextI = i + pasos*di[k];
				int nextJ = j + pasos*dj[k];
				if(nextI<0 || nextI>=8 || nextJ<0 || nextJ>=8)
					break;
				temp = getTablero().getPieza(nextI, nextJ);
											
				if(temp!=null ) {
					if(temp.isColor() == isColor())
						break;
					else {
						if(temp instanceof Reyna)
							return true;
						else break;
					}
											
				}
			}
		}
		return false;
	}
	
	public boolean isJakeCaballo() {
	
		int di[] = Caballo.DI;
		int dj[] = Caballo.DJ;
		
		for(int k=0;k<di.length;k++) {
			
			int i = getI() + di[k];
			int j = getJ() + dj[k];
			if(i<0||i>=8||j<0||j>=8)continue;
			Pieza temp = getTablero().getPieza(i,j); 
			if(temp != null && (temp instanceof Caballo) && temp.isColor() != isColor())return true;
			
		}
		
		return false;
	}
	
	public boolean isJakePeon() {
		int paso;
		if(isColor()) {
			if(!getTablero().isArriba())paso = -1;
			else paso = 1;
		}
		else {
			if(getTablero().isArriba())paso = 1;
			else paso = -1;
		}
		int di[] = {1,1,-1,-1};
		int dj[] = {1,-1,1,-1};
		
		for(int k=0;k<di.length;k++) {
		
			int i = getI() + di[k];
			int j = getJ() + dj[k];
			if(i<0||i>=8||j<0||j>=8)continue;
			Pieza temp = getTablero().getPieza(i,j);
			if(temp != null && (temp instanceof Peon) && 
			   temp.isColor() != isColor() && 
			   (((Peon)temp).getPaso()+i) == getI())
					return true;
		}
		
		return false;
		
	}
	
	public boolean isJake() {
		return isJakeAlfil() || isJakeCaballo() || isJakeReyna() || isJakeTorre() || isJakePeon();
		
	}

	@Override
	public Image getImage() {
		return GestorMedia.getReyImage(isColor());
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
