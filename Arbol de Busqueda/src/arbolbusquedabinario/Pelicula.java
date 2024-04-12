package arbolbusquedabinario;
import java.util.Date;
import java.io.Serializable;

public class Pelicula implements Serializable{
	private String nombre;
	private String categoria;
	private Date fecha;	
	
	public Pelicula(String nombre, String categoria,Date fecha) {		
		this.nombre = nombre;
		this.categoria = categoria;
		this.fecha = fecha;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public Date getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		String am = "AM";
		int hora = fecha.getHours();
		if(hora>=12) {
			hora-=12;
			am = "PM"; 
		}
		if(hora==0)hora=12;		
		return nombre+":"+categoria+" "+hora+":"+fecha.getMinutes()+" "+am+"  "+fecha.getDate()+"/"+fecha.getMonth()+"/"+fecha.getYear() ;
	}
}
