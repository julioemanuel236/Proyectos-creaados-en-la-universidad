package aplicacion;

public class Turismo extends Omnibus{
	private String horaLlegada;
	private int asientosDisponibles;

	public Turismo(String chapa, Persona chofer, String destino, float kM, String horaLlegada, int asientosDisponibles) {
		super(chapa, chofer, destino, kM);
		this.horaLlegada = horaLlegada;
		this.asientosDisponibles = asientosDisponibles;
	}
	
	public String getHoraLlegada() {
		return horaLlegada;
	}
	
	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}

	@Override
	public float Precio() {
	      if(getKM()<100) return 10; 
	      else if(getKM()>100&&getKM()<200) return 20;
	      else return 30;

	}

	
}
