package mercado;

public class Extranjero extends Producto{

	private float usd;
	private String pais;
	
	public Extranjero(String n,String c,float p,int ca,int li,String pais,float usd) {
		super(n,c,p,ca,li);
		this.usd=usd;
		this.pais=pais;
	}

	public String datos() {
		String s=super.datos();
		return s+"Pais: "+pais+'\n'+
				 "Coste USD: "+usd+'\n';
	}

	public float precioVenta() {
		return super.precioVenta()+(usd*27);
	}
	
	public String getPais() {
		return pais;
	}
	
 	public String informe() {
		return getNombre()+" "+getCodigo()+" "+usd+'\n';
	}
}
