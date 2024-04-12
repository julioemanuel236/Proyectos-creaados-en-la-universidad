package banco;

public class Empresarial extends Solicitud{
	private String directorEmpresa;
	private String direccionDirector;
	private float  gananciaPromedioAnual;
	private int    cantidadTrabajadores;
	private String ministerio; 
	private String codigo;	
	
	
	public Empresarial(String nombre, float credito, String direccion, String director, String direccionDirector, float gananciaPromedio, int trabajadores, String ministerio, String codigo) {
		super(nombre, credito, direccion);
		this.directorEmpresa = director;
		this.direccionDirector = direccionDirector;
		this.gananciaPromedioAnual = gananciaPromedio;
		this.cantidadTrabajadores = trabajadores;
		this.ministerio = ministerio;
		this.codigo = codigo;
	}

	public String getDirector() {
		return directorEmpresa;
	}
	
	public int categoriaTamano() {
		if(cantidadTrabajadores<=100)return 0;
		else if(cantidadTrabajadores>100&&cantidadTrabajadores<=300)return 1;
		else return 2;
	}
	
	public String getDireccionDirector() {
		return direccionDirector;
	}
	
	public float getGananciaPromedio() {
		return gananciaPromedioAnual;
	}
	
	public int getTrabajadores() {
		return cantidadTrabajadores;
	}
	
	public String getMinisterio() {
		return ministerio;
	}
	
	public String getCodigo() {
		return codigo;
	}

	@Override
	public float pagoMensual() {
		int ct = categoriaTamano();
		if(ct==0)return gananciaPromedioAnual*0.2f;
		else if(ct==1)return gananciaPromedioAnual*0.3f;
		else return gananciaPromedioAnual*0.4f;		
	}

	@Override
	public boolean puedeSolicitar() {
		int ct = categoriaTamano();
		if(ct==0)return gananciaPromedioAnual>1000;
		else if(ct==1)return gananciaPromedioAnual>5000;
		else return gananciaPromedioAnual>10000;		
	}
	
	@Override
	public String datos() {
		return super.datos()+
				"Nombre Director: "+directorEmpresa+"\n"+
				"Direccion Director: "+direccionDirector+"\n"+
				"Ganancias Promedio: "+gananciaPromedioAnual+"\n"+
				"Cantidad Trabajadores: "+cantidadTrabajadores+"\n"+
				"Ministerio: "+ministerio+"\n"+
				"Codigo: "+codigo+"\n";
	}
}
