package banco;

public class Empresarial extends Solicitud{
	private String director;
	private String direccionDirector;
	private float  gananciaPromedio;
	private int    trabajadores;
	private String ministerio; 
	private String codigo;	
	
	
	
	public Empresarial(String nombre, float credito, String direccion, String director, String direccionDirector,
			float gananciaPromedio, int trabajadores, String ministerio, String codigo) {
		super(nombre, credito, direccion);
		this.director = director;
		this.direccionDirector = direccionDirector;
		this.gananciaPromedio = gananciaPromedio;
		this.trabajadores = trabajadores;
		this.ministerio = ministerio;
		this.codigo = codigo;
	}

	public String getDirector() {
		return director;
	}
	
	public String tamano() {
		if(trabajadores<=100)return "Pequeña";
		else if(trabajadores>100&&trabajadores<=300)return "Mediana";
		else return "Grande";
	}
	
	public int categoriaTamano() {
		if(trabajadores<=100)return 0;
		else if(trabajadores>100&&trabajadores<=300)return 1;
		else return 2;
	}
	
	public String getDireccionDirector() {
		return direccionDirector;
	}
	
	public float getGananciaPromedio() {
		return gananciaPromedio;
	}
	
	public int getTrabajadores() {
		return trabajadores;
	}
	
	public String getMinisterio() {
		return ministerio;
	}
	
	public String getCodigo() {
		return codigo;
	}

	@Override
	public float mensualidad() {
		int ct = categoriaTamano();
		if(ct==0)return gananciaPromedio*0.2f;
		else if(ct==1)return gananciaPromedio*0.3f;
		else return gananciaPromedio*0.4f;
		
	}

	@Override
	public boolean puedeSolicitar() {
		int ct = categoriaTamano();
		if(ct==0)return gananciaPromedio>1000;
		else if(ct==1)return gananciaPromedio>5000;
		else return gananciaPromedio>10000;		
	}
	
}
