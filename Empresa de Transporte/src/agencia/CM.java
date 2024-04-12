package agencia;

public class CM extends Camion{

	private	float kml;
	
	public CM(String chapa,float kml) {
		super(chapa);
		this.kml=kml;
	}
	
	public float getKilometroLitro() {
		return this.kml;
	}
	public String datos() {
		String s=super.datos();
		s+="KM/L: "+kml+'\n';
		s+="Tipo: Moderno"+'\n';
		return s;
	}
	
	public String fichero() {
		String s=super.fichero();
		s+="KM/L: "+kml+'|';
		s+="Tipo: Moderno"+'|';
		return s;
	}
	
}
