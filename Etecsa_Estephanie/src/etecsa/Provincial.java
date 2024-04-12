package etecsa;

public class Provincial extends Llamada{

	public Provincial(String s, String codigo, float d, int h) {
		super(s, codigo, d, h);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float valor(int codigop, float tarifa) {

		int codigo1 = Integer.parseInt(getCodigo().substring(2,4));	
		return Math.abs(codigo1-codigop)+0.5f;
	}

}
