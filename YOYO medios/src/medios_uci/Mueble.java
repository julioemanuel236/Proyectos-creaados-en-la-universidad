 package medios_uci;

public class Mueble extends Medio{
	protected static final String TIPO = "Mobiliario";
	protected static final int SILLA=0, MESA=1, BURO=2, CAMA=3, MUEBLE_PC=4;
	protected static final int LABORATORIO=0,AULA=1,APARTAMENTO=2,OFICINA=3;
	
	protected static final String CLASIFICACIONES[]= {"SILLA", "MESA", "BURO", "CAMA", "MUEBLE_PC"};
	protected static final String LOCAL[]= {"LABORATORIO","AULA","APARTAMENTO","OFICINA"};
	private static final int PLUS[] =      {      30       ,20,       40,         50};
	
	private int explotacion;
	private int local;
	private int clasificacion;
	
	public Mueble(String serie,float coste,int estado,String proveedor,int local,int explotacion,int clasificacion){
		super(serie,coste,estado);
		this.explotacion=explotacion;
		setProveedor(proveedor);
		this.setTipo(TIPO);
		this.setClasificacion(clasificacion);
	}
	
	public void setClasificacion(int cls) {
		clasificacion=cls;
		super.setClasificacion(CLASIFICACIONES[cls]);
	}
	
	public float Coste() {
		return getCosteUni()*explotacion+PLUS[local];
	}
	
	public String Local() {
		return LOCAL[local]; 
	}

	public int getLocal() {
		return local;
	}

	public int getClasificacion() {
		return clasificacion;
	}
	
	public String datos() {
		return  super.datos()+
			    "Local: "+this.Local()+'\n'+
				"Explotacion: "+this.explotacion+'\n';
	}
	
}
