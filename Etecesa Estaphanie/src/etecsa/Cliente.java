package etecsa;
import java.io.Serializable;
public class Cliente implements Serializable{
	private String nombre;
	private String carnet;
	private String direccion;
	private String telefono;
	private boolean cancelada;
	
	public Cliente(String n,String c,String d,String t) {
		this.nombre=n;
		this.carnet=c;
		this.direccion=d;
		this.telefono=t;
		cancelada=false;
	}
	
	
	
	public String data() {
		return nombre+" "+telefono;
	}
	
	public String datos() {
		return 	   "Nombre: "+nombre+'\n'+
				   "Carnet: "+carnet+'\n'+
				   "Direccion: "+direccion+'\n'+
				   "Telefono: "+telefono+'\n';
	}
	
	public String setCancelada(boolean c) {
		if(cancelada)return "\n Este cliente ya esta cancelado\n";
		else this.cancelada=c;
		return "Cliente canelado";
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String toString() {
		return data();
	}

}
