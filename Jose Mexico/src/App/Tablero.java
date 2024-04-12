package App;

import java.util.Date;

public class Tablero implements java.io.Serializable{
	final String TIPOS[] = {"Ruteo","Tablero de Prueba Electrica"};
	private String codigo="";
	private int tipo=0;
	private String location1="";
	private String location2="";
	private Date last = new Date();
	private String linea="";
	private boolean two=false;
	public Tablero(String codigo,int tipo){
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		last = new Date();
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return TIPOS[tipo];
	}
	
	public String toString() {
		return "Codigo: "+codigo+"\n"+"Tipo: "+getTipo();
	}
	
	public void enviarA(String env) {
		this.linea = env;
		this.location1=this.location2="";
	}
	
	public void setLocation(String location) {
		if(location1.equals(""))this.location1=location;
		else {
			this.location2=location;
			two=true;
		}
		update();
	}

	public String getFecha() {
		int hora = last.getHours();
		String z;
		if(hora>11) {
			z="PM";
			hora-=12;
			if(hora==0)hora=12;
		}
		else z="AM";
		return last.getDate()+"/"+last.getMonth()+"/"+(last.getYear()+1900)+" "+
			   hora+":"+
			   (last.getMinutes()<10?"0"+last.getMinutes():last.getMinutes())
			   +":"+
			   (last.getSeconds()<10?"0"+last.getSeconds():last.getSeconds())
			   +" "+z;
	}
	
	public String[] getDatos() {
		String datos[] = new String[9];
		datos[0] = this.codigo;
		datos[1] = this.getTipo();
		datos[2] = this.location1;
		datos[3] = (this.location1.equals("")?"X":"Q");
		datos[4] = this.linea;
		datos[5] = (two?this.location2:"");
		datos[6] = (two?(this.location2.equals("")?"X":"Q"):"");
		datos[7] = (two?this.linea:"");
		datos[8] = this.getFecha();
		return datos;
	}
	
	public void update() {
		this.last = new Date();
	}
}