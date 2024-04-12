package clases;

import java.util.ArrayList;
import java.io.*;
public class Edificio implements Serializable{
	protected ArrayList<Apartamento> apartamentos = new ArrayList<>();
	private String nombre;
	private int    numero;
	
	public Edificio(String nombre,int numero) {
		this.numero=numero;
		this.nombre=nombre;
	}
	
	public void AddApartamento(Apartamento a) {
		apartamentos.add(a);
	}

	public ArrayList<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public String getNombre() {
		return nombre;
	}

	public String datos() {
		return "Nombre: "+nombre+'\n'+
			   "Numero: "+numero+'\n'+
			   "Cantidad Apartamentos: "+apartamentos.size()+'\n';
	}
	
	public int Ocupado() {
		int c=0;
		for(Apartamento i:apartamentos)
			c+=i.getOcupado();
		return c;
	}
	
	public int Capacidad() {
		int c=0;
		for(Apartamento i:apartamentos)
			c+=i.getCapacidad();
		return c;
	}

	@Override
	public String toString() {
		return "Edificio [numero=" + numero + "]";
	}

	public int cantidadBecados() {
		int cantidad=0;
		for(Apartamento i:apartamentos) {
			cantidad+=i.getOcupado();
		}
		return cantidad;
	}
	
	public int getNumero() {
		return numero;
	}
	
}
