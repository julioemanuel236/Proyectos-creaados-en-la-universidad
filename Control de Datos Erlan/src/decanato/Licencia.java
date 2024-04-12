package decanato;
import java.util.ArrayList;

public class Licencia extends Alumno{
	ArrayList<Asignatura> repetidas;
	private int repetido;
	public Licencia(String n, String a, String s, String id, String gru, int year, String p, boolean ayuda,Asignatura[] as,int repetido) {
		super(n, a, s, id, gru, year, p, ayuda);
		this.repetido=repetido;
		for(Asignatura i:as)
			this.repetidas.add(i);
	}

	public int getRepetido() {
		return repetido;
	}
	
}