package Terminal;

public class PasajeroEspera extends Pasajero{
	private String destinoA;
	private String destinoB;
	private String destinoC;
	
	public PasajeroEspera(String carnet, String destino1, String destino2, String destino3) {
		super(carnet);
		this.destinoA = destino1;
		this.destinoB = destino2;
		this.destinoC = destino3;
	}
	
	public String getdestinoA() {
		return destinoA;
	}
	
	public String getdestinoB() {
		return destinoB;
	}
	
	public String getdestinoC() {
		return destinoC;
	}
	
	public boolean esperaPara(String s) {
		return destinoA.equals(s)||destinoB.equals(s)||destinoC.equals(s);
	}
	
	public String toString() {
		return super.toString()+destinoA+' '+destinoB+' '+destinoC+' ';
	}
	
}
