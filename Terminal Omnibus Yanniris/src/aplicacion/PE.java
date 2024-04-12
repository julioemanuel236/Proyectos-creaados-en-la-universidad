package aplicacion;

public class PE extends Persona{
	private String destino1;
	private String destino2;
	private String destino3;
	
	public PE(String carnet, String destino1, String destino2, String destino3) {
		super(carnet);
		this.destino1 = destino1;
		this.destino2 = destino2;
		this.destino3 = destino3;
	}
	
	public String getDestino1() {
		return destino1;
	}
	
	public String getDestino2() {
		return destino2;
	}
	
	public String getDestino3() {
		return destino3;
	}
	
	public boolean vaA(String s) {
		return destino1.equals(s)||destino2.equals(s)||destino3.equals(s);
	}
	
	public String toString() {
		return super.toString()+destino1+' '+destino2+' '+destino3+' ';
	}
	
}
