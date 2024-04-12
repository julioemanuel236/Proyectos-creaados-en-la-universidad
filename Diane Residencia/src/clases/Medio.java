package clases;
import java.io.*;

public class Medio implements Serializable{
	private String nombre;
	private String codigo;
	private Becado asignado;
	private Apartamento aptAsignado;
	int cantidad;
	public Medio(String nombre,String codigo,int cantidad) {
		this.nombre=nombre;
		this.codigo=codigo;
		this.cantidad=cantidad;
	}
	
	public void asginarA(Becado p) {
		this.asignado=p;
		p.addMedio(this);
	}
	
	public void AsignarAApt(Apartamento a) {
		this.aptAsignado=a;
		a.addMedio(this);
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public Becado getAsignado() {
		return asignado;
	}

	public Apartamento getAptAsignado() {
		return aptAsignado;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	
}
