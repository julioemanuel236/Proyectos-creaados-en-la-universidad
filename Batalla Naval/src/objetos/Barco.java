package objetos;

import juego.Juego;
import juego.Tablero;

public class Barco extends Objeto{
	int valor;
	
	public Barco(int x,int y,int valor,Tablero t) {
		super(x,y,t);
		this.valor=valor;
	}

	public int getTipo() {
		
		//devolver el tipo de barco según su valor
		if(valor==25)return 3;
		if(valor==40)return 2;
		return 1;
	}
	
	@Override
	public int activar() {
		super.activar();//activar de objeto
		Juego.escribirAccion(t.jugador+",Derribo de barco #"+getTipo()+" en "+x+"-"+y);//escribir derrivo de barco
		t.naves--;//restar la cantidad de naves del tablero
		return valor;//devolver valor
	}
}
