package agencia;

public class Viaje {
	protected static final String SEMANA[] = {"LUNES","MARTES","MIERCOLES","JUEVES","VIERNES","S�BADO","DOMINGO"};
	private	Camion camion;
	private Chofer chofer;
	private int dia;
	private float carga;
	private float km;
	
	public Viaje(int dia,int carga,float km,Camion camion,Chofer chofer) {
		this.dia=dia;
		this.carga=carga;
		this.km=km;
		this.camion=camion;
		this.chofer=chofer;
	}
	
	public Camion getCamion() {
		return camion;
	}
	
	public Chofer getChofer() {
		return chofer;
	}
	
	public String Day() {
		return SEMANA[dia];
	}
	
	public int getDia() {
		return dia;
	}
	
	public float getCarga() {
		return carga;
	}
	
	public float getKM() {
		return km;
	}

	public String fichero() {
		String s="|";
		s+="Tipo: Local|";
		s+="Dia: "+Day()+'|';
		s+="Carga: "+carga+'|';
		s+="Distancia: "+km+'|';
		s+="Chofer:|"+chofer.fichero()+'|';
		s+="Camion:|"+camion.fichero()+'|';
		return s;
	}
	
	public String datos() {
		String s="";
		s+="Tipo: Local\n";
		s+="Dia: "+Day()+'\n';
		s+="Carga: "+carga+'\n';
		s+="Distancia: "+km+'\n';
		s+="Chofer: \n"+chofer.datos()+'\n';
		s+="Camion: \n"+camion.datos()+'\n';
		return s;
	}
}
