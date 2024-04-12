package package_prueba;

import java.util.Date;

public class Llamada {
	int minutos;
	String saliente;
	String entrante;
	Date fecha;
	
	Llamada(int min,String sal,String en,Date f){
		minutos=min;
		saliente=sal;
		entrante=en;
		fecha=f;
	}
	
	String toRegistro() {
		return "Minutos: "+minutos+"\n"+
			   "Saliente: "+saliente+"\n"+
			   "Entrante: "+entrante+"\n"+
			   fecha.toString() ;
	}
	
	public String toString() {
		return "Minutos: "+minutos+" "+
				   "Saliente: "+saliente+" "+
				   "Entrante: "+entrante+" "+
				   fecha.toString() ;
	}
	
	float precio() {
		return 0;
	}
	
}
