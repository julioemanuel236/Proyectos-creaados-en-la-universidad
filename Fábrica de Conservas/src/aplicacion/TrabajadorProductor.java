package aplicacion;

public class TrabajadorProductor extends Trabajador{
	private int   experiencia;

	

	public TrabajadorProductor(String nombre, String id, String telefono, String direccion,int experiencia) {
		super(nombre, id, telefono, direccion);
		this.experiencia = experiencia;
	}

	public int getExperiencia() {
		return experiencia;
	}
	
	public String informacion() {
		return super.informacion()+"Experiencia: "+experiencia+"\n----------------------------------------";
	}
}
