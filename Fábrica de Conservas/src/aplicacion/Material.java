package aplicacion;

public class Material {
	private String nombreMaterial;
	private String clasificacion;
	private String proveedor;
	private float precio;
	
	public Material(String nombre,String proveedor,float precio) {
		this.nombreMaterial=nombre;
		this.proveedor=proveedor;
		this.precio=precio;
		setClasificacion("Nacional");
	}
	public void setClasificacion(String s) {
		this.clasificacion=s;
	}
	
	public float getCoste() {
		return this.precio;
	}
	
	public String getMercado() {
		return this.clasificacion;
	}
	
	public String toString() {
		return this.nombreMaterial+" "+this.proveedor;
	}
	
	public String informacion() {
	
		return "Tipo de envase: "+nombreMaterial+'\n'+
		 "Proveedor: "+proveedor+'\n'+
		 "Precio del envase: "+precio+'\n'+
		 "Origen del matarial: "+clasificacion+'\n';
	
	}

	public String fichero() {
		return this.nombreMaterial+" @\n"+this.clasificacion+"\n"+this.proveedor+"\n"+this.precio+"\n";
	}
	
}
