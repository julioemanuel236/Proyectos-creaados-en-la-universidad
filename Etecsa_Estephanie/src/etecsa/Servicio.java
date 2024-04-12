package etecsa;

public class Servicio extends Llamada{

	public Servicio(String s, String codigo, float d, int h) {
		super(s, codigo, d, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float valor(int codigop, float tarifa) {
		return 1;
	
	}

		
}
