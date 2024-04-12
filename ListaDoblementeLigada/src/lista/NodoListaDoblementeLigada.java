package lista;

public class NodoListaDoblementeLigada<T> {
	
	private NodoListaDoblementeLigada ligeIzq;
	private NodoListaDoblementeLigada ligeDer;
	
	private T infor;
	
	public NodoListaDoblementeLigada() {
		
	}

	public NodoListaDoblementeLigada getLigeIzq() {
		return ligeIzq;
	}

	public void setLigeIzq(NodoListaDoblementeLigada ligeIzq) {
		this.ligeIzq = ligeIzq;
	}

	public NodoListaDoblementeLigada getLigeDer() {
		return ligeDer;
	}

	public void setLigeDer(NodoListaDoblementeLigada ligeDer) {
		this.ligeDer = ligeDer;
	}

	public T getInfor() {
		return infor;
	}

	public void setInfor(T infor) {
		this.infor = infor;
	}
	
	
}
