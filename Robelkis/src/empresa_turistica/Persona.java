package empresa_turistica;

import java.io.Serializable;

public class Persona implements Serializable{
	private String nombre;
	private char sexo;
	private String pasaporte;
	
	public String getNombre() {
		return nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	Persona(String nombre,char sexo){
		this.nombre=nombre;
		this.sexo=sexo;
	}
	
	Persona(String nombre,char sexo,String pasaporte){
		this.nombre=nombre;
		this.sexo=sexo;
		this.pasaporte=pasaporte;
	}
	
	Persona(Persona p){
		this.nombre=p.nombre;
		this.sexo=p.sexo;
		this.pasaporte=p.pasaporte;
	}
	
	public String Reporte() {
		return "CHOFER: \n\t"+nombre+"\n\t"+(sexo=='M'?"Masculino":"Femenino")+"\n";
	}
	
	public String toString() {
		return nombre;
	}
}