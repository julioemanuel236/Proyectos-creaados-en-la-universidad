package agencia;

public class CV extends Camion{

	private int aniof;
	private int reparaciones;
	
	public CV(String chapa,int aniof,int reparaciones) {
		super(chapa);
		this.aniof=aniof;
		this.reparaciones=reparaciones;
	}
	
	public int getAnio() {
		return aniof;
	}
	
	public int getReparaciones() {
		return reparaciones;
	}
	
	public String datos() {
		String s=super.datos();
		s+="Cantidad Reparaciones: "+reparaciones+'\n';
		s+="Año de fabricación: "+aniof+'\n';
		return s;
	}
	
	public String fichero() {
		String s=super.datos();
		s+="Cantidad Reparaciones: "+reparaciones+'|';
		s+="Año de fabricación: "+aniof+'|';
		return s;
	}
	
}
