package doMain;

import nodos.NodoInt;
import nodos.NodoSubList;

public class ListaInt {

	private NodoInt primero;
	private NodoInt ultimo;
	
	public ListaInt() {
		
	}
	
	public void agregar(int dato) {
		
		NodoInt nodo = new NodoInt(dato);
		if(primero == null) {
			primero = nodo;
			ultimo = nodo;
		}
		else {
			ultimo.setSiguiente(nodo);
			ultimo = nodo;
		}
			
	}

	public NodoInt getPrimero() {
		return primero;
	}

	public void setPrimero(NodoInt primero) {
		this.primero = primero;
	}

	public NodoInt getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodoInt ultimo) {
		this.ultimo = ultimo;
	}

	public void clear() {
		primero = ultimo = null;
	}
	
	public boolean isEmpty() {
		return primero == null && ultimo == null;
	}
	
	public int poll() {
		int dato = primero.getDato();
		primero = primero.getSiguiente();
		if(primero == null )
			ultimo = null;
		return dato;
	}
}
