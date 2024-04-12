package Terminal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Terminal {

	protected LinkedList<PasajeroOficial> oficial = new LinkedList<>();
	protected LinkedList<PasajeroEspera> espera = new LinkedList<>();
	protected ArrayList<Omnibus> omnibus = new ArrayList<>();
	
	public Terminal() {
		cargar();
	}
	
	public String salidasEnElDia(String dia) {
		String resultado="";
		for(Omnibus i:omnibus) {
			if(i instanceof OmnibusAstro) {
				if(((OmnibusAstro)i).getDiaSalida().equals(dia))
					resultado+=i.toString()+"\n";
			}
		}
		if(resultado.equals(""))resultado="No salio ningun Omnibus ese dia";
		
		return resultado;
	}

	public String verListas() {
		String resultado="Oficial:\n";
		
		for(PasajeroOficial i:oficial)
			resultado+=i.toString()+"\n";
	
		resultado+="Espera:\n";
		
		for(PasajeroEspera i:espera)
			resultado+=i.toString()+"\n";
		
		if(resultado.equals("Oficial:\nEspera:\n"))resultado="No hay pasajeros en las listas";
		return resultado;
		
	}
	
	public String recaudacionElDia(String dia) {
		float dinero=0;
		
		for(Omnibus i:omnibus) {
			if(i instanceof OmnibusAstro) {
				if(((OmnibusAstro) i).getDiaSalida().equals(dia))dinero+=i.getRecaudacion();
			}
		}
		if(dinero==0)return " No se recaudo nada el "+dia+"\n";
		return "Se recaudo "+dinero+" el "+dia+"\n";
	}
	
	public String destinoMasFrecuente() {
		
		ArrayList<String> destinos = new ArrayList<>();
		ArrayList<Integer> frecuencia = new ArrayList<>();

		for(Omnibus i:omnibus) {
			boolean destino=false;
			for(int j=0;j<destinos.size();j++){
				if(destinos.get(j)==i.getDestino()) {
					frecuencia.set(j,frecuencia.get(j)+1);
					destino=true;
					break;
				}
			}
			if(!destino) {
				destinos.add(i.getDestino());
				frecuencia.add(1);
			}
		}
		String destinoFrecuente="";
		int    frecuenciaMayor=0;
		
		for(int i=0;i<destinos.size();i++) {
			if(frecuenciaMayor<frecuencia.get(i)) {
				frecuenciaMayor=frecuencia.get(i);
				destinoFrecuente=destinos.get(i);
			}
		}
		
		return "El destino al que mas viajan las personas es: "+destinoFrecuente;
		
	}
	
	public String pasajerosPorOmnibus() {
		
		String resultado="";
		for(Omnibus i:omnibus) {
			resultado+=i.getChapa()+":\n";
			for(Pasajero p:i.pasajeros) {
				resultado+=p.datos()+"\n";
			}
			resultado+="\n";
		}
		FileWriter viajes;
		try {
			 viajes = new FileWriter("Viajes.txt");
			 viajes.write(resultado);
		}
		catch(Exception e) {
			
		}
		
		if(resultado.equals(""))return "No hay viajes";
		return resultado;
	}
	
	public String aDondeViajo(String carnet) {
		for(Omnibus i:omnibus) {
			for(Pasajero p:i.pasajeros)
				if(p.getCarnet().equals(carnet))return "La persona con el ID "+carnet+" viajo en el omnibus "+i.getChapa();
				
		}
		return "No se tiene Registro de esa persona";
	}
	
	public String informacionOmnibusPorDestino(String destino) {
		String resultado="";
		
		for(Omnibus i:omnibus) {
			if(i.getDestino().equals(destino))
				resultado+=i.datos()+"\n";	
		}
		
		if(resultado.equals(""))return "Ningun omnibus viajo a "+destino;
		return resultado;
	}
	
	public String cuantosPorTipo() {
		int astro=0,turismo=0;
		
		for(Omnibus i:omnibus)
			if(i instanceof OmnibusAstro)astro++;
			else turismo++;
		String resultado="";
		
		if(astro==0)resultado+="No hay Omnibus Astros registrados\n";
		else resultado+="Hay "+astro+" OmnibusAstros registrados\n";
		if(turismo==0)resultado+="No hay Omnibus de Turismo registrados\n";
		else resultado+="Hay "+turismo+" Omnibus de Turismo registrados\n";
		
		return resultado;
	}
	
	public String omnibusMayorRecaudacion() {
		float recaudacion=0;
		String chapa="Las recaudaciones hasta este momento han sido nulas";
		
		for(Omnibus i:omnibus) {
			if(i.getRecaudacion()>recaudacion) {
				recaudacion=i.getRecaudacion();
				chapa=i.getChapa();
			}
		}
		
		return chapa;
	}
	
	public String nuevoOmnibus(Omnibus o) {
		String resultado = o.cargar(espera, oficial);
		omnibus.add(o);
		guardar();
		return resultado;
	}
		
	
	//___________________________________________________________________________________________________________
	public void cargar() {
		try {
			cargarDatos();
			cargarListas();
		}
		catch(Exception e) {
			
		}
	}
	
	public void cargarDatos() throws Exception {
		
		FileInputStream fis = new FileInputStream("Datos.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		omnibus = (ArrayList<Omnibus>)ois.readObject();
		
	}
	
	private void cargarListaEspera() throws Exception{
		FileReader espera2 = new FileReader("Espera.txt");
		Scanner entrada = new Scanner(espera2);
		
		while(entrada.hasNext()) {
			String carnet = entrada.next();
			String d1 = entrada.next();
			String d2 = entrada.next();
			String d3 = entrada.next();
			PasajeroEspera persona = new PasajeroEspera(carnet,d1,d2,d3);
			espera.add(persona);
		}
	}
	
	private void cargarListaOficial() throws Exception{
		FileReader oficial2 = new FileReader("Oficial.txt");
		Scanner entrada = new Scanner(oficial2);
		
		while(entrada.hasNext()) {
			String carnet = entrada.next();
			String dia = entrada.next();
			String destino = entrada.next();
			PasajeroOficial persona = new PasajeroOficial(carnet,dia,destino);
			oficial.add(persona);
		}
		System.out.println(oficial.size());
		
	}
	
	public void cargarListas() throws Exception {
		cargarListaOficial();
		cargarListaEspera();
		
	}
	
	public void guardar() {
		try {
			guardarDatos();
			guardarListas();
		}
		catch(Exception e) {
			
		}
	}
	
	public void guardarListas() throws Exception{

		guardarListaEspera();
		guardarListaOficial();
		
	}
	
	private void guardarListaOficial() throws Exception {
		FileWriter oficial2 = new FileWriter("Oficial.txt");
		for(PasajeroOficial i:oficial) {
			if(i==null)continue;
			oficial2.write(i.toString()+"\n");
		}
		oficial2.close();
	}
	
	private void guardarListaEspera() throws Exception {
		FileWriter espera2 = new FileWriter("Espera.txt");
		for(PasajeroEspera i:espera) {
			if(i==null)continue;
			espera2.write(i.toString()+"\n");
		}
		espera2.close();
	}
	
	public void guardarDatos() throws Exception {
		
		FileOutputStream fos = new FileOutputStream("Datos.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(omnibus);
		
	}
	
}
