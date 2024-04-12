package cadena;
import java.io.*;

public class Habitacion extends Object implements Serializable{
	private Piso piso;
	private int numero;
	private Cliente cliente;
	private Empleado empledo;
	private float precio;
	
	public Habitacion(Piso piso, int numero,float precio) {
		this.piso = piso;
		this.numero = numero;
		this.precio=precio;
	}
	
	public Piso getPiso() {
		return piso;
	}
	public int getNumero() {
		return numero;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Empleado getEmpledo() {
		return empledo;
	}
	public float getPrecio() {
		return precio;
	}
	public String toString() {
		return ""+numero;
	}
}
