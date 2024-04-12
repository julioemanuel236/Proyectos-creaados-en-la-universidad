package cadena;

public class Vip extends Cliente{
	private String cargo;

	public Vip(String nombre, String id, String sexo, String entrada, String salida, String cargo) {
		super(nombre, id, sexo, entrada, salida);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}
	
	public String datos() {
		return super.datos()+"Cargo: "+cargo+'\n';
	}
}
