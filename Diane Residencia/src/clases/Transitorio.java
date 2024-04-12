package clases;

public class Transitorio extends Becado{
	public static String MEDIOS[] = {"sabana","sabana","sabana","sabana","sobrecama","toalla","toalla","colcha","percha","perchas","perchas","perchas","perchas","perchas"};
	private String empresa;
	private String motivo;
	private String trabajo;
	
	public Transitorio(String solapin,String carnet,String nombre,String apellidos,char sexo,String provincia,Apartamento apartamento,String correo,String ingreso,String empresa,String motivo,String trabajo) {
		super(solapin,carnet,nombre,apellidos,sexo,provincia,apartamento,correo,ingreso);
		this.empresa=empresa;
		this.motivo=motivo;
		this.trabajo=trabajo;
	}

	public String datos() {
		return super.datos()+
				"Empresa: "+empresa+'\n'+
				"Motivo: "+motivo+'\n'+
				"Trabajo: "+trabajo+'\n';
	}

	
	public static String[] getMEDIOS() {
		return MEDIOS;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getMotivo() {
		return motivo;
	}

	public String getTrabajo() {
		return trabajo;
	}
	
	
}
