package agencia;

public class Administrativo extends Trabajador{
	
	private String cargo;
	
	public Administrativo(String n,String c,String ne,String s,String t,String d,int x,float sal,String cargo) {
		super(n,c,ne,s,t,d,x,sal);
		this.cargo=cargo;
		
	}
	
	public String getCargo() {
		return cargo;
	}
	
	
	public float getSalario() {
		float f=getSalario();
		return (f*28f)+200;
	}
	
	public String datos() {
		String s=super.datos();
		return s+"Cargo: "+cargo+'\n';
	}
}
