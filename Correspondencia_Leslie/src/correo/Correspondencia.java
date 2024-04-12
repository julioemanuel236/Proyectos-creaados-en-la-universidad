package correo;
import java.io.Serializable;

public abstract class Correspondencia implements Serializable {
	private String nombre;
	private String direccion;
	private String remitente;
	
	public Correspondencia(String nombre, String direccion, String remitente) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.remitente = remitente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getRemitente() {
		return remitente;
	}
	
	public abstract float precio();
	
	public String datos() {
		return nombre+' '+direccion+' '+remitente;
	}
}
