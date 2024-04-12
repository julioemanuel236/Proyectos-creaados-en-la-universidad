package doMain;

import nodos.NodoReaction;

public class ListReaction {
	private NodoReaction first;
	private NodoReaction last;

	public ListReaction() {
		this.first = null;
		this.last = null;
	}

	public NodoReaction getFirst() {
		return first;
	}

	public void setFirst(NodoReaction first) {
		this.first = first;
	}

	public NodoReaction getLast() {
		return last;
	}

	public void setLast(NodoReaction last) {
		this.last = last;
	}

}