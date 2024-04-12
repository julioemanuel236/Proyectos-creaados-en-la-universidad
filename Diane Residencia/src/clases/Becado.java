package clases;

import java.util.ArrayList;
import java.io.*;
public abstract class Becado implements Serializable{
	private String solapin;
	private String carnet;
	private String nombre;
	private String apellidos;
	private char   sexo;
	private String provincia;
	private  Apartamento apartamento;
	private String correo;
	private String ingreso;
	protected ArrayList<Medio> medios = new ArrayList<>();

	public Becado(String solapin,String carnet,String nombre,String apellidos,char sexo,String provincia,Apartamento apartamento,String correo,String ingreso) {
		this.solapin=solapin;
		this.carnet=carnet;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.sexo=sexo;
		this.provincia=provincia;
		this.apartamento=apartamento;
		this.correo=correo;
		this.ingreso=ingreso;
	}

	public String datos() {
		return "Solapin: "+solapin+'\n'+
			   "Carnet: "+carnet+'\n'+
			   "Nombre: "+nombre+' '+apellidos+'\n'+
			   "Sexo: "+sexo+'\n'+
			   "Provincia: "+provincia+'\n'+
			   "Correo: "+correo+'\n'+
			   "Fecha Ingreso: "+ingreso+'\n'+
			   "Numero Apartamento: "+apartamento.Numero()+'\n';
	}
	
	public void addMedio(Medio m) {
		this.medios.add(m);
	}
	
	public String getCarnet() {
		return carnet;
	}
	
	public void setApartamento(Apartamento apt) {
		this.apartamento=apt;
	}
	
	public String getSolapin() {
		return this.solapin;
	}
	
}
