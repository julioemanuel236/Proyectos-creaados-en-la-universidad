package etecsa;

public class Local extends Llamada{

	public Local(String s, String codigo, float d, int h) {
		super(s, codigo, d, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float valor(int codigop, float tarifa) {
		return (getCodigo().equals("777777")?1:0.05f/3);
	}

	
	
}
