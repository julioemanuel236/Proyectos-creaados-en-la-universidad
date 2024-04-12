package agencia;

public class Camion {

	private String chapa;
	private float distanciaTotal=0;
	private float toneladas=0;
	
	public Camion(String chapa) {
		this.chapa=chapa;
	}
	
	public String getChapa() {
		return this.chapa;
	}
	
	public String datos() {
		return "Chapa: "+chapa+'\n';
	}
	
	public String fichero() {
		return "Chapa: "+chapa+'|';
	}
	
	public float getToneladas() {
		return toneladas;
	}
	
	public void addToneladas(float t) {
		toneladas+=t;
	}
	
	public float getDistanciaTotal() {
		return distanciaTotal;
	}
	
	public void addDistanciaTotal(float f) {
		distanciaTotal+=f;
	}
	
	public String toString() {
		return chapa;
	}
}
