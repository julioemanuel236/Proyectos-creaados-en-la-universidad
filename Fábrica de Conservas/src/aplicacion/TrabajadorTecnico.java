package aplicacion;

public class TrabajadorTecnico extends Trabajador{

	private String especialidad;

	public TrabajadorTecnico(String nombre, String id, String telefono, String direccion,String especialidad) {
		super(nombre, id, telefono, direccion);
		this.especialidad = especialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}
	
	public String informacion() {
		return super.informacion()+"Especialidad: "+especialidad+"\n----------------------------------------";
	}
}
