package cadena;

import java.util.ArrayList;

public class Jefe extends Empleado{
	private int tiempoCargo;

	public Jefe(String nombre, String id, String sexo, int anos, int tiempoCargo) {
		super(nombre, id, sexo, anos);
		this.tiempoCargo = tiempoCargo;
	}

	public int getTiempoCargo() {
		return tiempoCargo;
	}

	public float Salario() {
		return super.Salario()+50 + (tiempoCargo*0.1f);
	}
}
