package clases;

public class Estudiante extends Becado{
	public static String MEDIOS[] = {"sabana","sabana","sobrecama","toalla","colcha","percha","perchas","perchas","perchas","perchas","sweater"};
	private String facultad;
	private int    anno;
	private String observacion;
	
	public Estudiante(String solapin,String carnet,String nombre,String apellidos,char sexo,String provincia,Apartamento apartamento,String correo,String ingreso,String facultad,int anno,String observaciones) {
		super(solapin,carnet,nombre,apellidos,sexo,provincia,apartamento,correo,ingreso);
		this.facultad=facultad;
		this.anno=anno;
		this.observacion=observaciones;
	}
	
	
	public String datos(){
		return super.datos()+
				"Facultad: "+facultad+'\n'+
				"Año: "+anno+'\n'+
				"Observacion: "+observacion+'\n';
	}
	
	public static String[] getMEDIOS() {
		return MEDIOS;
	}


	public String getFacultad() {
		return facultad;
	}


	public int getAnno() {
		return anno;
	}


	public String getObservacion() {
		return observacion;
	}


}
