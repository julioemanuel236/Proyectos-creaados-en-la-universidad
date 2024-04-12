package etecsa;

public class Residencial extends Cliente{

	private boolean matutino;
	private boolean rastreo; 

	Residencial(String n,String c,String d,String t,boolean m,boolean r){
		super(n,c,d,t);
		this.matutino=m;
		this.rastreo=r;
	}
	
	public boolean tieneRastreo() {
		return rastreo;
	}
	
	public boolean tieneMatutino() {
		return matutino;
	}
	
	public String datos() {
		return super.datos()+
				"Matutino: "+(matutino?"Si":"No")+'\n'+
				"Rastreo: "+(rastreo?"Si":"No")+'\n';
	}
	

}
