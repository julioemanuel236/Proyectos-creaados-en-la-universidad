package banco;

public class Personal extends Solicitud{
	private String carnetCliente;
	private float  salarioCliente;
	private int    cantidadDePersonasSustentadas;
	
	public Personal(String nombre, float credito, String direccion, String carnet, float salario, int sustenta) {
		super(nombre, credito, direccion);
		this.carnetCliente = carnet;
		this.salarioCliente = salario;
		this.cantidadDePersonasSustentadas = sustenta;
	}

	public String getCarnet() {
		return carnetCliente;
	}

	public float getSalario() {
		return salarioCliente;
	}

	public int getSustenta() {
		return cantidadDePersonasSustentadas;
	}
	
	public float capacidadDePago() {
			return salarioCliente-((cantidadDePersonasSustentadas+1)*50);
	}
	
	@Override
	public boolean puedeSolicitar() {
		return capacidadDePago()>100;
	}
	
	@Override
	public float pagoMensual() {
		
		float cp = capacidadDePago();
		if(100<=cp&&cp<=120)return 30;
		if(121<=cp&&cp<=140)return 40;
		if(cp>140)return 50;
		
		return 1;
	}

	@Override
	public String datos() {
		return super.datos()+
				"Carnet: "+carnetCliente+"\n"+
				"Salario: "+salarioCliente+"\n"+
				"Sustenta a: "+cantidadDePersonasSustentadas+"\n";
	}
	
}
