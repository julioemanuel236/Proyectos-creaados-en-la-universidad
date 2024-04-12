package elementos.serpiente;

import elementos.Matriz;
import simulacion.Simulacion;

public class Cuerpo {
	private int x;
	private int y;
	private int id;
	private Cuerpo siguiente;
	private Cuerpo anterior;
	private Matriz tablero;
	private boolean muerta;
	
	public Cuerpo(int x,int y,int id,Matriz tablero) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.tablero = tablero;
		tablero.set(x, y, this);
	}

	public Cuerpo(int x,int y,int id,Matriz tablero,Cuerpo anterior) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.tablero = tablero;
		this.anterior = anterior;
		tablero.set(x, y, this);
	}
	
	public void moveTo(int x,int y) {		
		
		//si no puedo ir hasta ahi porque ahi una pared u otra serpiente muero		
		
		if(isCabeza() && !tablero.set(x,y,this)) {
			morir();
			return;
		}
		
		//movemos recursivamente la parte siguiente hasta llegar a la cola
		if(!isCola())
			siguiente.moveTo(this.x, this.y);
		
		//actualizo esta parte del cuerpo
		if(isCola())
			tablero.erase(this.x, this.y);
		
		this.x = x;
		this.y = y;
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getId() {
		return id;
	}

	public Cuerpo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Cuerpo siguiente) {
		this.siguiente = siguiente;
	}

	public Cuerpo getAnterior() {
		return anterior;
	}

	public void setAnterior(Cuerpo anterior) {
		this.anterior = anterior;
	}
		
	public boolean isCabeza() {
		return anterior == null;
	}
	
	public boolean isCola() {
		return siguiente == null;
	}
	
	public boolean isMuerta() {
		return muerta;
	}
	
	public void morir() {		
		muerta = true;		
		Simulacion.muertes++;
	}
	
}
