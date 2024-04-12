package medios_uci;

public class Equipo extends Medio {
	protected static final String TIPO = "Equipo Eléctrico";
	protected static final int REFRIGERADOR=0, TV=1, VIDEO=2, VENTILADOR=3, AIRE_ACONDICIONADO=4, COMPUTADORA=5;
	protected static final String CLASIFICACIONES[]= {"REFRIGERADOR", "TV", "VIDEO", "VENTILADOR", "AIRE_ACONDICIONADO", "COMPUTADORA"};
	
	public static final String MARCA[]= {"Sony", "Sanyo", "Atec Panda", "LG"} ;
	public static final int SONY=0,SANYO=1,ACTEC_PANDA=2,LG=3;
	
	private int garantia;
	private int marca;
	private int clasificacion;
	private ArrayList<String> proveedores = new ArrayList<>();
	
	public Equipo(String serie,float coste,int estado,String proovedor,int garantia,int marca,ArrayList<String> proveedores,int clasificacion){
		super(serie,coste,estado);
		this.garantia=garantia;
		this.proveedores.addAll(proveedores);
		this.marca=marca;
		this.setTipo(TIPO);
		this.setClasificacion(clasificacion);
		this.setProveedor(proovedor);
		
	}
	
	public void setClasificacion(int cls) {
		clasificacion=cls;
		super.setClasificacion(CLASIFICACIONES[cls]);
	}
	
	public int getMarca() {
		return marca;
	}
	
	public	int getClasificacion() {
		return clasificacion;
	}
	
	public String Marca() {
		return MARCA[marca];
	}
	
	public int getGarantia() {
		return garantia;
	}
	
	public float Coste() {
		return getCosteUni()*garantia;
	}
	
	public String datos() {
		return super.datos()+
			    "Marca: "+this.Marca()+'\n'+
				"Garantía: "+this.getGarantia()+'\n';
			   
	}
}
