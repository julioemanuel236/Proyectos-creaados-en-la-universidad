package Tareas;

public class Mochila {
	
	private String nombre;
	private String material;
	private double Costo;
	private double Venta;
	private int Cantidad;
		
	public Mochila(String nombre, String material, double costo, double venta, int cantidad) {
		this.nombre = nombre;
		this.material = material;
		Costo = costo;
		Venta = venta;
		Cantidad = cantidad;
	}
	
	public double darCosto() {
		return Costo;
	}
	
	public double darVenta() {
		return Venta;
	}
	
	public int darCantidad() {
		return Cantidad;
	}
	
	public String darNombre() {
		return nombre;
	}
	
	public String darMaterial() {
		return material;
	}
	
	public static void main(String[] args) {
		Mochila mochila = new Mochila("Mochila de prueba","Poliester",50000,51000,2);
		
		System.out.println("Nombre: "+mochila.darNombre());
		System.out.println("Material: "+mochila.darMaterial());
		System.out.println("Costo: "+mochila.darCosto());
		System.out.println("Venta: "+mochila.darVenta());
		System.out.println("Cantidad: "+mochila.darCantidad());
	}
}
