package lietys;

import java.io.Serializable;
import java.util.Date;


public class Vuelo implements Serializable{
	
	private Terminal terminal;
	private String tipo;
	private Avion avion;
	private Date salida;
	private Date arribo;
	private String paisDestino;
	private String ciudadDestino;
	private int capacidad;

	private int ocupado=0;
	private int km;
	private float preciovuelo;
	private float preciokm;
	private float precio;
	
	public Vuelo(String tipo,Date salida,Date arribo,Avion avion,Terminal terminal,
			     String paisDestino,String ciudadDestino,int km,float preciovuelo,float preciokm,float precio) {
		this.tipo=tipo;
		this.avion=avion;
		this.salida=salida;
		this.arribo=arribo;
		this.terminal=terminal;
		this.paisDestino=paisDestino;
		this.ciudadDestino=ciudadDestino;
		this.km=km;
		this.capacidad=avion.getCantidadAsientos();
		this.preciovuelo=preciovuelo;
		this.preciokm=preciokm;
		this.precio=precio;
	}
	
	public String toString() {
		return terminal+"\t "+tipo+"\t "+avion.toString()+"\t "+ciudadDestino+"\t "+paisDestino+"\t "
	    +(salida.getMonth()+1)+"/"+salida.getDate()+"/"+(salida.getYear()+1900)+" - "
	    +(arribo.getMonth()+1)+"/"+arribo.getDate()+"/"+(arribo.getYear()+1900)+" ";
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Date getSalida() {
		return salida;
	}

	public void setSalida(Date salida) {
		this.salida = salida;
	}

	public Date getArribo() {
		return arribo;
	}

	public void setArribo(Date arribo) {
		this.arribo = arribo;
	}

	public String getPaisDestino() {
		return paisDestino;
	}

	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getOcupado() {
		return ocupado;
	}

	public void setOcupado(int ocupado) {
		this.ocupado = ocupado;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public float getPreciovuelo() {
		return preciovuelo;
	}

	public void setPreciovuelo(float preciovuelo) {
		this.preciovuelo = preciovuelo;
	}

	public float getPreciokm() {
		return preciokm;
	}

	public void setPreciokm(float preciokm) {
		this.preciokm = preciokm;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	
}