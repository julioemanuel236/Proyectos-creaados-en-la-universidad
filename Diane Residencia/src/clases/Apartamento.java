package clases;

import java.util.ArrayList;
import java.io.*;

public class Apartamento implements Serializable{
	
	protected ArrayList<Becado> becados = new ArrayList<>();
	protected ArrayList<Medio> medios = new ArrayList<>();
	
	private String   tipo;
	private String numero;
	private String telefono;
	private int    capacidad;
	private int    ocupado;
	private String    razon;
	private String numedifi;
	
	public Apartamento(String tipo, String numero,String numedifi, String telefono,
			int capacidad, int ocupado, String razon) {		
		this.numedifi=numedifi;
		this.tipo = tipo;
		this.numero = numero;
		this.telefono = telefono;
		this.capacidad = capacidad;
		this.ocupado = 0;
		this.razon = razon;
	}
	
	@Override
	public String toString() {
		return "Apartamento [numero=" + numero + "]";
	}

	public boolean isLleno() {
		return becados.size()>=capacidad;
	}
	
	public String Numero() {
		return numedifi+'-'+numero;
	}
	
	public void addMedio(Medio m) {
		medios.add(m);
	}
	
	public void addBecado(Becado b) {
		becados.add(b);
		b.setApartamento(this);
		ocupado++;
	}

	public ArrayList<Becado> getBecados() {
		return becados;
	}

	public ArrayList<Medio> getMedios() {
		return medios;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNumero() {
		return numero;
	}

	public String getTelefono() {
		return telefono;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getOcupado() {
		return becados.size();
	}

	public String getRazon() {
		return razon;
	}	
	
}