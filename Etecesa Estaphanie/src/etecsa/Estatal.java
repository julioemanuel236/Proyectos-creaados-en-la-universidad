package etecsa;

public class Estatal extends Cliente {
	private	boolean arrendada;
	

	public Estatal(String n,String c,String d,String t,boolean a) {
		super(n,c,d,t);
		this.arrendada=a;
	}

	public String datos() {
		return super.datos()+"Arrendada: "+(arrendada?"Si":"No")+'\n';
	}
	
	
}
