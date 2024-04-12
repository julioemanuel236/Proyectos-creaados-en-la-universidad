package aplicacion;

public class Astro extends Omnibus{
	private String diaSalida;
	private String horaSalida;
	private int cantidadAsientos;
	public Astro(String chapa, Persona chofer, String destino, float kM, String diaSalida, String horaSalida,
			int cantidadAsientos) {
		super(chapa, chofer, destino, kM);
		this.diaSalida = diaSalida;
		this.horaSalida = horaSalida;
		this.cantidadAsientos = cantidadAsientos;
	}
	public String getDiaSalida() {
		return diaSalida;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public int getCantidadAsientos() {
		return cantidadAsientos;
	}
	@Override
	public float Precio() {
		return getKM()*4;
	}
	
	
	
	
	
}
