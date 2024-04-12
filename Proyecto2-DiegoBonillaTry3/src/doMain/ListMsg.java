package doMain;

import nodos.NodoMsg;

public class ListMsg {
	private NodoMsg primero;
	private NodoMsg ultimo;
	
	public ListMsg() {
		this.primero=null;
		this.ultimo=null;
	}
 
	public NodoMsg getPrimero() {
		return primero;
	}

	public void setPrimero(NodoMsg primero) {
		this.primero = primero;
	}

	public NodoMsg getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodoMsg ultimo) {
		this.ultimo = ultimo;
	}
	
	

}
