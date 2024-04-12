package aplicacion;

public class TrabajadorCientifico extends Trabajador{
	
	private String centro;
	private String grado;
	
	public TrabajadorCientifico(String nombre, String id, String telefono, String direccio, String centro, String gradro) {
		super(nombre, id, telefono, direccio);
		this.centro = centro;
		this.grado = gradro;
	}
	public String getCentro() {
		return centro;
	}
	public String getGradro() {
		return grado;
	}
	
	public String informacion() {
		return super.informacion()+
				"Centro: "+centro+"\n"+
				"Grado: "+grado+"\n----------------------------------------\n";
	}
}
