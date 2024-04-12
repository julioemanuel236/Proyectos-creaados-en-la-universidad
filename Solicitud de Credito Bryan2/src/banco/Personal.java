package banco;

public class Personal extends Solicitud{
	private String carnet;
	private float  salario;
	private int    sustenta;
	
	public Personal(String nombre, float credito, String direccion, String carnet, float salario, int sustenta) {
		super(nombre, credito, direccion);
		this.carnet = carnet;
		this.salario = salario;
		this.sustenta = sustenta;
	}

	public String getCarnet() {
		return carnet;
	}

	public float getSalario() {
		return salario;
	}

	public int getSustenta() {
		return sustenta;
	}
	
	public float capacidadDePago() {
			return salario-((sustenta+1)*50);
	}
	
	@Override
	public boolean puedeSolicitar() {
		return capacidadDePago()>100;
	}
	
	@Override
	public float mensualidad() {
		
		float cp = capacidadDePago();
		if(100<=cp&&cp<=120)return 30;
		if(121<=cp&&cp<=140)return 40;
		if(cp>140)return 50;
		
		return 1;
	}
	
	
	
}
