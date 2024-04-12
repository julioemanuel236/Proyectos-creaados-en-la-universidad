package arbolbusquedabinario;
import java.util.ArrayList;

public class Arbol {

	private Pelicula elemento;
	private char nodo;
	ArrayList<Arbol> hijos = new ArrayList<>();
	
	public Arbol() {
		
	}
	
	public Arbol(Pelicula elemento,char nodo) {
		this.elemento = elemento;
		this.nodo = nodo;
	}
	
	public Arbol(char nodo) {
		this.nodo = nodo;
	}
	
	public void agregar(Pelicula elemento,int pos) {
		String nombre = elemento.getNombre();				
		if(pos==nombre.length()) {
			this.elemento=elemento;		
			return;
		}				
		else if(hijos.isEmpty()) {
			char nodo = nombre.charAt(pos);
			Arbol nuevo = new Arbol(nodo);
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
				Arbol nuevo = new Arbol(nodo);
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
			if(this.elemento!=null)resultado+=this.elemento.getNombre()+": "+this.elemento.getCategoria()+"\n";
			for(Arbol i:hijos) {
				resultado+=i.buscar(texto, pos);
			}
			return resultado;
		}
		
		if(this.elemento!=null)resultado+=this.elemento.getNombre()+": "+this.elemento.getCategoria()+"\n";
		
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
		return elemento;
	}

	public char getNodo() {
		return nodo;
	}

	public ArrayList<Arbol> getHijos() {
		return hijos;
	}
			
}
