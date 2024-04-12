package objetos;

import juego.Tablero;

public class Hecaton extends Bomba {

	public Hecaton(int x, int y,Tablero t) {
		super(x, y,t);
		// TODO Auto-generated constructor stub
	}
	
	public int activar() {
		super.activar();//activar de la bomba
		int puntos=0;//puntos totales
		for(int i=0;i<8;i++) {
			if(!t.posicionValida(x+DX[i], y+DY[i]))continue;//si la posicion a visitar no e svalida omitirla
			Objeto obj = t.mapa[y+DY[i]][x+DX[i]];
			if(obj.activado)continue;//si el objeto ya fue activado omitirlo
			puntos+=obj.activar();//aumentar el resultado de activar el objeto
							
		}
		return puntos;//retornar resultado
	}
}
