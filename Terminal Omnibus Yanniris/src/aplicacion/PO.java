package aplicacion;

public class PO extends Persona{
	private String dia;
	private String destino;
	
	public PO(String carnet, String dia, String destino) {
		super( carnet);
		this.dia = dia;
		this.destino = destino;
	}
	
	public String getDia() {
		return dia;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public String toString() {
		return super.toString()+dia+' '+destino+' ';
	}
	
}
