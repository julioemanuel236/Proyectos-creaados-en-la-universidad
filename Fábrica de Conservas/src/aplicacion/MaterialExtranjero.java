package aplicacion;

public class MaterialExtranjero extends Material{
	
	private int tiempo;

	public MaterialExtranjero(String nombre, String proveedor, float precio, int tiempo) {
		super(nombre, proveedor, precio);
		this.tiempo = tiempo;
		setClasificacion("Extranjero");
	}

	public int getTiempo() {
		return tiempo;
	}
	
	public String informacion() {
		
		return super.informacion()+
			   "Tiempo Envio: "+tiempo+"\n";

}

	public String fichero() {
	return super.fichero()+tiempo+"\n";
}	
}
