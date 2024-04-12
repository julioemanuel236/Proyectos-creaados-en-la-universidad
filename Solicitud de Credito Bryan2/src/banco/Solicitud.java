package banco;
import java.io.*;

public abstract class Solicitud implements Serializable{
	private String nombre;
	private float credito;
	private String direccion;
	
	public Solicitud(String nombre, float credito, String direccion) {
		super();
		this.nombre = nombre;
		this.credito = credito;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}
	
	public float getCredito() {
		return credito;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	
	public abstract boolean puedeSolicitar();
	
	public abstract float mensualidad();
	
	public int mesesEnPagar() {
		float m = mensualidad();
		return (int)(getCredito()/m)+(m%getCredito()!=0?1:0);
	}
}
