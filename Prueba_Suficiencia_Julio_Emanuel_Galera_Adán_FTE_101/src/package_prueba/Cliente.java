package package_prueba;

import java.util.ArrayList;

public class Cliente {
	String nombre;
	String carne;
	String direccion;
	String telefono;
	boolean cancelado;
	
	ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
	ArrayList<Llamada_Internacional> llamadasInter = new ArrayList<Llamada_Internacional>();
	ArrayList<Llamada_Interprovincial> llamadasProvi = new ArrayList<Llamada_Interprovincial>();
	
	ArrayList<Llamada> lle = new ArrayList<Llamada>();
	ArrayList<Llamada_Internacional> llei = new ArrayList<Llamada_Internacional>();
	ArrayList<Llamada_Interprovincial> llep = new ArrayList<Llamada_Interprovincial>();
	
	Cliente(String n,String c,String d,String t,boolean can){
		nombre=n;
		carne=c;
		direccion=d;
		telefono=t;
		cancelado=can;
	}
	Cliente(){
		
	}
	
	int cantLlamadasSalientes() {
		if(nombre.equals(-123456789))return -1;
		else return llamadas.size()+llamadasInter.size()+llamadasProvi.size();
	}
	
	public String toString() {
		return telefono + " "+ nombre;
	}
}
