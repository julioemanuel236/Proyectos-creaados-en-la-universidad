package etecsa;

public class Internacional extends Llamada{

	public Internacional(String s, String codigo, float d, int h) {
		super(s, codigo, d, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float valor(int codigop, float tarifa) {
		return (tarifa*getDuracion())+0.5f;
		
	}
	
	

}
