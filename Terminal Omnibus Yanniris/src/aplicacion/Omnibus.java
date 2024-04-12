package aplicacion;
import java.io.*;
import java.util.LinkedList;
public abstract class Omnibus implements Serializable{
	private String chapa;
	private Persona chofer;
	private String destino;
	private float KM;
	protected LinkedList<Persona> pasajeros;
	private float recaudacion = 0;
	
	public Omnibus(String chapa, Persona chofer, String destino, float kM) {
		super();
		this.chapa = chapa;
		this.chofer = chofer;
		this.destino = destino;
		KM = kM;
		pasajeros = new LinkedList<>();
	}
	public String getChapa() {
		return chapa;
	}
	public Persona getChofer() {
		return chofer;
	}
	public String getDestino() {
		return destino;
	}
	public float getKM() {
		return KM;
	}
	
	public void Recaudar() {
		recaudacion+=Precio();
	}
	
	public float getRecaudacion() {
		return recaudacion;
	}
	
	public String toString() {
		return chapa;
	}
	
	public String datos() {
		return chapa+' '+chofer.getCarnet()+' '+destino+' '+KM+' '+recaudacion;
	}
	
	public abstract float Precio();
	
}
