package aplicacion;

public class Trabajador {
	private String nombre;
	private String carnet;
	private String telefono;
	private String direccion;
	
	public Trabajador(String nombre,String id,String telefono,String direccion) {
		this.nombre=nombre;
		this.carnet=id;
		this.telefono=telefono;
		this.direccion=direccion;
	}
	
	public String informacion() {
		String s = "Nombre: "+nombre+'\n'+
				"Carnet ID: "+carnet+'\n'+
				"Tel�fono: "+telefono+'\n'+
				"Direcci�n: "+direccion+'\n';
		return s;
	}
	
	public String getCarnet() {
		return carnet;
	}
}
