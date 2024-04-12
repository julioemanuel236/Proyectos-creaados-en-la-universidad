package decanato;

public class Asignatura {
	private String nombre;
	private float  nota;
	private int	   year;
	private int    semestre;
	
	public Asignatura(String nombre,float nota,int year,int semestre) {
		this.nombre=nombre;
		this.nota=nota;
		this.year=year;
		this.semestre=semestre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public float getNota() {
		return nota;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getSemestre() {
		return semestre;
	}
	
}

