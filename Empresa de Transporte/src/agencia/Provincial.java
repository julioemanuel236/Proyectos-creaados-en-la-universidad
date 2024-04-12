package agencia;

public class Provincial extends Viaje{
	int regreso;
	int provincias;
	
	public Provincial(int dia,int carga,float km,Camion camion,Chofer chofer,int regreso,int provincias) {
		super(dia,carga,km,camion,chofer);
		this.regreso=regreso;
		this.provincias=provincias;
	}
	
	public String getDiaRegreso() {
		return SEMANA[regreso];
	}
	
	public int getRegreso() {
		return regreso;
	}
	
	public int getProvinciasVisitadas() {
		return provincias;
	}
	
	public String ficheros() {
		String s="|";
		s+="Tipo: Local|";
		s+="Dia: "+Day()+'|';
		s+="Carga: "+getCarga()+'|';
		s+="Distancia: "+getKM()+'|';
		s+="Chofer: "+getChofer().fichero()+'|';
		s+="Camion: "+getCamion().fichero()+'|';
		return s;
	}
	
	public String datos() {
		String s="";
		s+="Tipo: Local\n";
		s+="Dia: "+Day()+'\n';
		s+="Carga: "+getCarga()+'\n';
		s+="Distancia: "+getKM()+'\n';
		s+="Chofer: "+getChofer().datos()+'\n';
		s+="Camion: "+getCamion().datos()+'\n';
		return s;
	}
}
