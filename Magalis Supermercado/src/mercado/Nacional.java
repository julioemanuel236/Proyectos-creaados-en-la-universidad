package mercado;

public class Nacional extends Producto{

	private String empresa;
	
	public Nacional(String n,String c,float p,int ca,int li,String empr) {
		super(n,c,p,ca,li);
		empresa=empr;
	}
	
	public String datos() {
		String s=super.datos();
		return s+"Empresa: "+empresa+'\n';
	}
		
}
