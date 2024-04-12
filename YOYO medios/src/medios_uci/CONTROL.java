package medios_uci;

import java.io.*;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class CONTROL {
	static ArrayList<Medio> medios = new ArrayList<>();
	
	public static void addMedio(Medio m) {
		medios.add(m);
	}
	
	public static String cantidadEquipos() {
		int arr[][] = new int[Equipo.CLASIFICACIONES.length][Equipo.MARCA.length];
		for(int i=0;i<medios.size();i++) {
			if(medios.get(i) instanceof Equipo) {
				Equipo e = (Equipo)medios.get(i);
				arr[e.getClasificacion()][e.getMarca()]++;
			}
		}
		
		String result="";
		for(int i=0;i<Equipo.CLASIFICACIONES.length;i++) {
			result+=Equipo.CLASIFICACIONES[i]+": \n";			
			for(int j=0;j<Equipo.MARCA.length;j++) {
				result+=Equipo.MARCA[j]+": "+arr[i][j]+'\n';
			}
			result+="\n";
			
		}
		return result;
	}
	
	public static String garantias() {
		if(medios.isEmpty()) {
			return "No existen medios";
		}
		Equipo mayor=null,menor=null;
		for(int i=0;i<medios.size();i++) {
			if(medios.get(i) instanceof Equipo) {
				Equipo e = (Equipo)medios.get(i);
				if(i==0) {
					mayor=e;
					menor=e;
					continue;
				}
				if(e.getGarantia()>mayor.getGarantia())mayor=e;
				if(e.getGarantia()<menor.getGarantia())menor=e;
			}
		}
		
		
		String result="El equipo de mayor garantia es: \ns"+mayor.datos()+'\n'+"El equipo de menor garantia es: "+menor.datos();
		
		return result;
	}
	
	public static String estadoMedios() {
		int equipos=0,muebles=0;
		for(int i=0;i<medios.size();i++) {
			if(medios.get(i) instanceof Equipo&&medios.get(i).getEstado()==Medio.MAL) 
				equipos++;
			if(medios.get(i) instanceof Mueble&&medios.get(i).getEstado()==Medio.MAL)
				muebles++;
			
		}
		String result="Existen un total de: "+(equipos+muebles)+" medios en mal estado\n"
				+"Equipos: "+equipos+'\n'
				+"Muebles: "+muebles+'\n';
		
		return result;
		
	}
	
	public static String proveedores() {
		TreeSet<String> proveedores = new TreeSet<String>();
		String	resultado = "";
		for(int i = 0;i<medios.size();i++) {
			if(!proveedores.contains(medios.get(i).getProveedor())) {
				proveedores.add(medios.get(i).getProveedor());
				resultado+=medios.get(i).getProveedor()+'\n';
			}
		}
		
		return resultado;
	}
	
	public static String costes() {
		int costeTipoEquipo[] = new int[Equipo.CLASIFICACIONES.length];
		int costeTipoMueble[] = new int[Mueble.CLASIFICACIONES.length];
		int costeTotalEquipo=0,costeTotalMueble=0;
		int cantidadEquipos=0,cantidadMuebles=0;
		
		for(int i=0;i<medios.size();i++) {
			Medio m = medios.get(i);
			if(m instanceof Equipo) {
				Equipo e = (Equipo)m;
				costeTotalEquipo+=e.Coste();
				costeTipoEquipo[e.getClasificacion()]+=e.Coste();
				cantidadEquipos++;
			}
			else {
				Mueble e = (Mueble)m;
				costeTotalMueble+=e.Coste();
				costeTipoMueble[e.getClasificacion()]+=e.Coste();
				cantidadMuebles++;
			}
		}
		String result = "El coste total de equipos es de: "+costeTotalEquipo+'\n'+
				        "El coste total de muebles es de: "+costeTotalMueble+'\n';
		result+="\nEl coste promedio de equipos es de: "+costeTotalEquipo/(cantidadEquipos==0?1:cantidadEquipos)+'\n';
		result+="El coste promedio de muebles es de: "+costeTotalMueble/(cantidadMuebles==0?1:cantidadMuebles)+'\n';

		result+="\nEquipos: \n";
		for(int i=0;i<costeTipoEquipo.length;i++) 
			result+=Equipo.CLASIFICACIONES[i]+": "+costeTipoEquipo[i]+'\n';
		
		result+="\nMuebles: \n";
		for(int i=0;i<costeTipoMueble.length;i++) 
			result+=Mueble.CLASIFICACIONES[i]+": "+costeTipoMueble[i]+'\n';
		
		return result;
	}
	
	public static void guardarMuebles() {
		try {
			FileWriter fw = new FileWriter("datos.dat");
			
			int arr[] = new int[Mueble.CLASIFICACIONES.length];
			for(int i=0;i<medios.size();i++) 
				if(medios.get(i) instanceof Mueble)
					arr[((Mueble)medios.get(i)).getClasificacion()]++;

			String s="";
			for(int i=0;i<Mueble.CLASIFICACIONES.length;i++)
				s+=Mueble.CLASIFICACIONES[i]+": "+arr[i]+'\n';
			
			fw.write(s);
			fw.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar los datos");
		}
	}
	
}
