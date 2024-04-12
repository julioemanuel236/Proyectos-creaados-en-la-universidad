package etecsa;

public class Llamada {

	private String saliente;
	private String codigo;
	private float duracion;
	private int hora;
	
	public int tipo() {
		int t=0;
		for(int i=0;i<codigo.length();i++){
			if(codigo.charAt(i)=='-')t++;
		}
		if(codigo.contains("-077-"))return 3;
		switch(t){
			case 0:return 0;
			case 2:return 1;
			case 3:return 2;
		}
		return -1;
	}
	
	public float valor(int codigop,float tarifa) {
		return 1;
	}
	
	public Llamada(String s,String codigo,float d,int h) {
		this.codigo=codigo;
		saliente=s;
		duracion=d;
		hora=h;
	}
	
	public float calcularCoste(int codigop,float tarifa) {
		return duracion*valor(codigop,tarifa);
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String data() {
		return saliente+"->"+codigo+": "+duracion+" "+hora;
	}
	
	public String getNumero() {
		return saliente;
	}

	public float getDuracion() {
		return duracion;
	}

}
