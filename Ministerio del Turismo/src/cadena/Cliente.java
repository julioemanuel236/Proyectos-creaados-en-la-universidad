package cadena;

public class Cliente extends Persona{
	private String entrada;
	private String salida;
	
	public Cliente(String nombre, String id, String sexo, String entrada, String salida) {
		super(nombre, id, sexo);
		this.entrada = entrada;
		this.salida = salida;
	}
	
	public String getEntrada() {
		return entrada;
	}
	
	public String getSalida() {
		return salida;
	}

	public String datos() {
		return super.datos()+"Fecha entrada: "+entrada+'\n'+"Fecha salida: "+salida+'\n';
	}

	
}
