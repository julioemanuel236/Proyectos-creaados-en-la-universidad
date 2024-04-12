package arbolbusquedabinario;
import java.util.ArrayList;
import java.io.Serializable;
public class Arbol implements Serializable{

	private Pelicula raiz;
	private Arbol padre;
	private char nodo;
	
	ArrayList<Arbol> hijos = new ArrayList<>();
	
	public Arbol() {
		
	}
	
	public Arbol(Pelicula elemento,char nodo) {
		this.raiz = elemento;
		this.nodo = nodo;
	}
	
	public Arbol(char nodo,Arbol padre) {
		this.nodo = nodo;
		this.padre=padre;
	}
	
	public void agregar(Pelicula elemento,int pos) {
		String nombre = elemento.getNombre();				
		if(pos==nombre.length()) {
			this.raiz=elemento;		
			return;
		}				
		else if(hijos.isEmpty()) {
			char nodo = nombre.charAt(pos);
			Arbol nuevo = new Arbol(nodo,this);
			hijos.add(nuevo);
			nuevo.agregar(elemento, pos+1);
		}
		
		else {			
			char nodo = nombre.charAt(pos);
			int posicion = busqueda(nodo);
			if(hijos.get(posicion).nodo==nodo) {
				hijos.get(posicion).agregar(elemento, pos+1);
			}
			else {
				Arbol nuevo = new Arbol(nodo,this);
				if(nodo>hijos.get(posicion).nodo)posicion++;
				hijos.add(posicion,nuevo);
				nuevo.agregar(elemento, pos+1);
			}
		}
		
	}
	
	public int busqueda(char nodo) {
		int l=0,r=hijos.size()-1;
		int m = 0;
		while(l<r) {
			m = (l+r)/2;
			char temp = hijos.get(m).getNodo();
			if(temp==nodo)return m;
			else if(temp<nodo)l=m+1;
			else if(temp>nodo)r=m-1;
		}
		
		return l;
	}

	String buscar(String texto,int pos) {
		
		String resultado = "";
		if(pos>=texto.length()) {
			if(this.raiz!=null)resultado+=this.raiz.toString()+"\n";
			for(Arbol i:hijos) {
				resultado+=i.buscar(texto, pos);
			}
			return resultado;
		}
		
		if(this.raiz!=null)resultado+=this.raiz.toString()+"\n";
		
		char nodo = texto.charAt(pos);
		int posicion = busqueda(nodo);
		if(hijos.get(posicion).nodo==nodo) {
			return hijos.get(posicion).buscar(texto, pos+1);			
		}		
		return resultado;
	}

	public void ver() {
		System.err.print("\n"+this.nodo +  " " + hijos.size() + " ->");
		for(Arbol i:hijos)
			System.err.print(i.nodo + " .");
		for(Arbol i:hijos)
			i.ver();
	}
	
	public Pelicula getElemento() {
		return raiz;
	}

	public char getNodo() {
		return nodo;
	}

	public ArrayList<Arbol> getHijos() {
		return hijos;
	}

	public Arbol getPadre() {
		return padre;
	}
				
}
