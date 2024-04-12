package cadena;
import java.util.ArrayList;

public class Empleado extends Persona{
	private int anos;
	private float salario = 500;
	private ArrayList<Habitacion> habitaciones;

	public Empleado(String nombre, String id, String sexo, int anos) {
		super(nombre, id, sexo);
		this.anos = anos;
		
	}

	
	public int getAnos() {
		return anos;
	}
	
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	public float Salario() {
		return (salario*24) + (anos*0.1f) + 100 ;
	}

}
