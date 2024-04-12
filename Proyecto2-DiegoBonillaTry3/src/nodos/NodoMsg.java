package nodos;

import doMain.ListReaction;

public class NodoMsg {

	private String message;
	private int reactions;
	private ListReaction listR;
	private NodoMsg sigNodo;

	public NodoMsg(String message, int reactions) {
		this.message = message;
		this.reactions = reactions;
		this.listR = new ListReaction();
	}

	public NodoMsg(String message) {
		this.message = message;
		this.listR = new ListReaction();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ListReaction getListR() {
		return listR;
	}

	public void setListR(ListReaction listR) {
		this.listR = listR;
	}

	public NodoMsg getSigNodo() {
		return sigNodo;
	}

	public void setSigNodo(NodoMsg sigNodo) {
		this.sigNodo = sigNodo;
	}

	public int getReactions() {
		return reactions;
	}

	public void setReactions(int reactions) {
		this.reactions = reactions;
	}

	@Override
	public String toString() {
		return "\n>>>Nodo Mensajes<<<  \nMensaje: " + message + "\nNumero de reacciones: " + 
	reactions+ "\n";
	}

	
}
