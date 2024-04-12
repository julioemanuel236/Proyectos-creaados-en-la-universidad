package lietys;

import java.io.Serializable;

public class Asiento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private Persona persona=null;
	private int categoria;
	private float precio;
	
	public String toString() {
		return ""+categoria;
		
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getNumero() {
		return numero;
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio=precio;
	}
	
	public void setPersona(Persona persona) {
		this.persona=persona;
	}
}	

