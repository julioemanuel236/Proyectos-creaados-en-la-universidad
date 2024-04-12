package banco;
import java.io.*;

public abstract class Solicitud implements Serializable{
	private String nombreSolicitante;
	private float creditoSolicitado;
	private String direccionDelSolicitante;
	
	public Solicitud(String nombre, float credito, String direccion) {
		super();
		this.nombreSolicitante = nombre;
		this.creditoSolicitado = credito;
		this.direccionDelSolicitante = direccion;
	}

	public String getNombre() {
		return nombreSolicitante;
	}
	
	public float getCredito() {
		return creditoSolicitado;
	}
	
	public String getDireccion() {
		return direccionDelSolicitante;
	}
	
	
	public abstract boolean puedeSolicitar();
	
	public abstract float pagoMensual();
	
	public int tiempoPago() {
		float m = pagoMensual();
		return (int)(getCredito()/m)+(m%getCredito()!=0?1:0);
	}
	
	public String datos() {
		return "Nombre: "+nombreSolicitante+"\n"+
			   "Credito: "+creditoSolicitado+"\n"+
			   "Direccion: "+direccionDelSolicitante+"\n";
	}
}
