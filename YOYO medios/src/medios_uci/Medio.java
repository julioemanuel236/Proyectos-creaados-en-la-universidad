package medios_uci;

public abstract class Medio {
	
	private static final String ESTADOS[] = {"Bien","Regular","Mal"};
	public  static final int BIEN=0,MAL=2,REGULAR=1;
	
	private String serie;
	private float costeuni;
	private int   estado;
	private String tipo;
	private String proveedor;
	private String clasificacion;
	
	public Medio(String serie,float coste,int estado) {
		this.serie=serie;
		this.costeuni=coste;
		this.estado=estado;
	}
	
	public String getSerie() {
		return serie;
	}
	
	public float getCosteUni() {
		return costeuni;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	public String getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(String proveedor) {
		this.proveedor=proveedor;
	}
	
	
	public String getStatus() {
		return ESTADOS[estado];
	}

	public String Clasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	public abstract float Coste();
	
	public String datos() {
		return 	   "No. Serie: "+this.getSerie()+'\n'+
				   "Coste Unitario: "+this.getCosteUni()+'\n'+
				   "Coste: "+this.Coste()+'\n'+
				   "Estado: "+this.getStatus()+'\n'+
				   "Tipo: "+this.Clasificacion()+'\n'+
				   "Proveedor: "+this.getProveedor()+'\n';
	}
}
