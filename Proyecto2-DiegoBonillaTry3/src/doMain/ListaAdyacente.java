package doMain;

import nodos.NodoSubList;

public class ListaAdyacente {
	private NodoSubList primero;
	private NodoSubList ultimo;
	
	
	public ListaAdyacente() {
		primero=null;
		ultimo=null;
	}


	public NodoSubList getPrimero() {
		return primero;
	}


	public void setPrimero(NodoSubList primero) {
		this.primero = primero;
	}


	public NodoSubList getUltimo() {
		return ultimo;
	}


	public void setUltimo(NodoSubList ultimo) {
		this.ultimo = ultimo;
	}


	@Override
	public String toString() {
		return "" + primero;
	}
	

	public void agregar(NodoSubList nodo) {
		
		if(primero == null) {
			primero = nodo;
			ultimo = nodo;
		}
		else {
			ultimo.setSigNodo(nodo);
			ultimo = nodo;
		}
			
	}

}
