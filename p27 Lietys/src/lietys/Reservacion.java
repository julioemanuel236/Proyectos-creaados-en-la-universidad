package lietys;

import java.io.Serializable;

public class Reservacion implements Serializable{
	private Persona cliente;
	private Asiento asiento;
	private Vuelo   vuelo;
	private float   precio;
	
	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public Asiento getAsiento() {
		return asiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Reservacion(Persona cliente,Asiento asiento,Vuelo vuelo,float precio){
		this.cliente=cliente;
		this.asiento=asiento;
		this.vuelo  =vuelo;
		this.precio=precio;
	}
}
