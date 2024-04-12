package clases;

public class Profesor extends Becado{
	public static String MEDIOS[] = {"sabana","sabana","sabana","sabana","sobrecama","toalla","toalla","colcha","percha","perchas","perchas","perchas","perchas","perchas"};
	private String departamento;
	private String facultad;
	private String asignatura;
	private String categoriaD;
	private String categoriaC;
	
	
	public Profesor(String solapin,String carnet,String nombre,String apellidos,char sexo,String provincia,Apartamento apartamento,String correo,String ingreso,String departamento,String facultad,String asignatura,String categoriaD,String categoriaC) {
		super(solapin,carnet,nombre,apellidos,sexo,provincia,apartamento,correo,ingreso);
		this.departamento=departamento;
		this.facultad=facultad;
		this.asignatura=asignatura;
		this.categoriaC=categoriaC;
		this.categoriaD=categoriaD;
	}

	public String datos() {
		return super.datos()+
				"Departamento: "+departamento+'\n'+
				"Facutlad: "+facultad+'\n'+
				"Asignatura: "+asignatura+'\n'+
				"Categoria Docente: "+categoriaD+'\n'+
				"Categoria Cientifica: "+categoriaC+'\n';
	}

	public static String[] getMEDIOS() {
		return MEDIOS;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getFacultad() {
		return facultad;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public String getCategoriaD() {
		return categoriaD;
	}

	public String getCategoriaC() {
		return categoriaC;
	}
	
	
}
