package agencia;

public class Chofer extends Trabajador{

	private	char categoria;
	private int evaluacion;
	private int interprovinciales=0;
	
	public Chofer(String n,String c,String ne,String s,String t,String d,int x,float sal,int ev) {
		super(n,c,ne,s,t,d,x,sal);
		if(x>=5)categoria='A';
		else categoria='B';
		evaluacion=ev;
	}
	
	public char getCategoria(){
		return categoria;
	}

	public void interProvincial() {
		this.interprovinciales++;
	}
	
	public float getSalario() {
		float f=super.getSalario();
		float plus=0;
		
		if(categoria=='A') 						
			plus=30f*interprovinciales;
		
		else plus=10*evaluacion;
		
		return (f*28f)+plus;
	}
	
	public String datos() {
		String s=super.datos();
		s+="Categoria: "+categoria+'\n';
		return s;
	}
	
	public String fichero() {
		String s=super.fichero();
		s+="Categoria: "+categoria;
		return s;
	}
}
