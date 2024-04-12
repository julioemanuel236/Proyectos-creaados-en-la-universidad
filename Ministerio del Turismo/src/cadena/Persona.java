package cadena;
import java.io.*;

public class Persona extends Object implements Serializable{
	private String nombre;
	private String id;
	private String sexo;
	
	public Persona(String nombre, String id, String sexo) {
		this.nombre = nombre;
		this.id = id;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getId() {
		return id;
	}

	public String getSexo() {
		return sexo;
	}
	
	public String datos() {
		return "Nombre: "+nombre+'\n'+
				"ID: "+id+'\n'+
				"Sexo: "+sexo+'\n';
	}
}
