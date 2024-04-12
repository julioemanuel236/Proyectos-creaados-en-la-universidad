package lista;

public class ListaDoblementeLigada<T> {
	
	private NodoListaDoblementeLigada<T> inicio;
	private NodoListaDoblementeLigada<T> fin;
	
	public ListaDoblementeLigada() {
		
	}
	
	public void insertarFinal(NodoListaDoblementeLigada<T> F,T dato) {
		
		NodoListaDoblementeLigada<T> Q = new NodoListaDoblementeLigada<>();
		
		Q.setInfor(dato);
		if(F != null)F.setLigeDer(Q);
		Q.setLigeIzq(F);
		Q.setLigeDer(null);
		F = Q;

		if(inicio == null)inicio = Q;
	}

	public NodoListaDoblementeLigada<T> getInicio() {
		return inicio;
	}

	public NodoListaDoblementeLigada<T> getFin() {
		return fin;
	}
	
	
}
