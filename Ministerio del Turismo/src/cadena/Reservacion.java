package cadena;
import java.io.*;

public class Reservacion extends Object implements Serializable{
	Cliente cliente;
	float precio;
	String pais;
	public Reservacion(Cliente cliente, float precio,String pais) {		
		this.cliente = cliente;
		this.precio = precio;
		this.pais=pais;
	}
	public Cliente getCLiente() {
		return cliente;
	}
	public float getPrecio() {
		return precio;
	}
	
	public String getPais() {
		return pais;
	}
		
	public boolean ocupado(String fecha) {
		return cliente.getEntrada().compareTo(fecha)<0 && cliente.getSalida().compareTo(fecha)>0;
	}
}
