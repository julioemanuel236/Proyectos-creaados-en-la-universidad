package cadena;
import java.util.ArrayList;
import java.io.*;

public class Piso extends Object implements Serializable{
	private ArrayList<Habitacion> habitaciones;
	private Jefe jefe;
	private int numero;
	
	public Piso(int numero,ArrayList<Habitacion> habitaciones) {
		this.numero=numero;
		this.habitaciones=habitaciones;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public Jefe getJefe() {
		return jefe;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String toString() {
		return ""+numero;
	}
}
