package game;

public abstract class Item extends Object {
	int precio;
	String nombre;
	public Item(String nombre,int precio) {
		this.nombre=nombre;
		this.precio=precio;
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
}

