package game;
import unidades.Heroe;
import java.io.Serializable;

public abstract class Item extends Object implements Serializable{
	public int precio;
	public String nombre;
	public String descripcion;
	
	public Item(String nombre,int precio,String descripcion) {
		this.nombre=nombre;
		this.precio=precio;
		this.descripcion=descripcion;
	}
	
	public abstract void usar(Heroe e);

	public String shopping() {
		return "Precio: "+precio;
	}
	
	public String info() {
		return nombre;
	}

	public String venta() {
		return nombre+" "+(int)(precio/2);
	}
	
	public String toString() {
		return getClass().getSimpleName();
	}
}

