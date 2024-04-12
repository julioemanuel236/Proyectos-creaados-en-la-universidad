package doMain;

import nodos.NodoTop10;

public class ListTop10 {
	private NodoTop10 primero;
	private NodoTop10 ultimo;
	
	public ListTop10() {
		this.primero=null;
		this.ultimo=null;
	}
 
	public NodoTop10 getPrimero() {
		return primero;
	}

	public void setPrimero(NodoTop10 primero) {
		this.primero = primero;
	}

	public NodoTop10 getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodoTop10 ultimo) {
		this.ultimo = ultimo;
	}
	
	

}
