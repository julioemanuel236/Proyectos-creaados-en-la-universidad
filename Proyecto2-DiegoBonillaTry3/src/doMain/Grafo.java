package doMain;

import nodos.NodoGraf;

public class Grafo {

	private NodoGraf primero;
	private NodoGraf ultimo;
	
	private int[][] matrizAdyacencia;

	public Grafo() {
		this.primero = null;
		this.ultimo = null;
	}



	public NodoGraf getPrimero() {
		return primero;
	}

	public void setPrimero(NodoGraf primero) {
		this.primero = primero;
	}

	public NodoGraf getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodoGraf ultimo) {
		this.ultimo = ultimo;
	}

	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	@Override
	public String toString() {
		return "Grafo [primero=" + primero + ", ultimo=" + ultimo + "]";
	}

}
