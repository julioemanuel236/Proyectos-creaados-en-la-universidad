package nodos;

public class NodoInt {

	private NodoInt siguiente;	
	private int dato;
	
	public NodoInt(int dato) {
		this.dato = dato;
	}

	public NodoInt getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoInt siguiente) {
		this.siguiente = siguiente;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}
	
	
}
