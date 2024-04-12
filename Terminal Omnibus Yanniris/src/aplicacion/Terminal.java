package aplicacion;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Terminal {

	Lista listas = new Lista();
	ArrayList<Omnibus> omnibus = new ArrayList<>();
	
	public Terminal() {
		cargar();
		new Ventana(this);
	}
	
	public String omnibusSalironEn(String dia) {
		String s="";
		for(Omnibus i:omnibus) {
			if(i instanceof Astro) {
				if(((Astro)i).getDiaSalida().equals(dia))s+=i.toString()+"\n";
			}
		}
		if(s.equals(""))s="No salio ningun Omnibus ese dia";
		
		return s;
	}

	public String verListas() {
		String s="Oficial:\n";
		
		for(PO i:listas.oficial)
			s+=i.toString()+"\n";
	
		s+="Espera:\n";
		
		for(PE i:listas.espera)
			s+=i.toString()+"\n";
		
		if(s.equals("Oficial:\nEspera:\n"))s="No hay pasajeros en las listas";
		return s;
		
	}
	
	public String dineroRecaudadoEl(String dia) {
		float f=0;
		
		for(Omnibus i:omnibus) {
			if(i instanceof Astro) {
				if(((Astro) i).getDiaSalida().equals(dia))f+=i.getRecaudacion();
			}
		}
		if(f==0)return " No se recaudo nada el "+dia+"\n";
		return "Se recaudo "+f+" el "+dia+"\n";
	}
	
	public String destinoMasFrecuente() {
		
		ArrayList<String> destinos = new ArrayList<>();
		ArrayList<Integer> frecuencia = new ArrayList<>();
	/*
	 * TOMAR EN CUENTAL LAS LISTAS 
		for(PE i:listas.espera) {
			boolean d1=false,d2=false,d3=false;
			for(int j=0;j<destinos.size();j++){
				if(destinos.get(j)==i.getDestino1()) {
					frecuencia.set(j,frecuencia.get(j)+1);
					d1=true;
					break;
				}
			}
			for(int j=0;j<destinos.size();j++){
				if(destinos.get(j)==i.getDestino2()) {
					frecuencia.set(j,frecuencia.get(j)+1);
					d2=true;
					break;
				}
			}
			for(int j=0;j<destinos.size();j++){
				if(destinos.get(j)==i.getDestino3()) {
					frecuencia.set(j,frecuencia.get(j)+1);
					d3=true;
					break;
				}
			}
					
			if(!d1) {
				destinos.add(i.getDestino1());
				frecuencia.add(1);
			}
			if(!d2) {
				destinos.add(i.getDestino2());
				frecuencia.add(1);
			}
			if(!d3) {
				destinos.add(i.getDestino3());
				frecuencia.add(1);
			}
		}
		
		
		for(PO i:listas.oficial) {
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
	*/
		
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
		
		String s="";
		for(Omnibus i:omnibus) {
			s+=i.getChapa()+":\n";
			for(Persona p:i.pasajeros) {
				s+=p.datos()+"\n";
			}
			s+="\n";
		}
		FileWriter viajes;
		try {
			 viajes = new FileWriter("Viajes.txt");
			 viajes.write(s);
		}
		catch(Exception e) {
			
		}
		
		if(s.equals(""))return "No hay viajes";
		return s;
	}
	
	public String dondeViajo(String carnet) {
		for(Omnibus i:omnibus) {
			for(Persona p:i.pasajeros)
				if(p.getCarnet().equals(carnet))return "La persona con el ID "+carnet+" viajo en el omnibus "+i.getChapa();
				
		}
		return "No se tiene Registro de esa persona";
	}
	
	public String informacionOmnibusDestino(String destino) {
		String s="";
		
		for(Omnibus i:omnibus) {
			if(i.getDestino().equals(destino))
				s+=i.datos()+"\n";	
		}
		
		if(s.equals(""))return "Ningun omnibus viajo a "+destino;
		return s;
	}
	
	public String cuantosPorTipo() {
		int astro=0,turismo=0;
		
		for(Omnibus i:omnibus)
			if(i instanceof Astro)astro++;
			else turismo++;
		String s="";
		
		if(astro==0)s+="No hay Astros registrados\n";
		else s+="Hay "+astro+" Astros registrados\n";
		if(turismo==0)s+="No hay de Turismo registrados\n";
		else s+="Hay "+turismo+" de Turismo registrados\n";
		
		return s;
	}
	
	public String omnibusMayorRecaudacion() {
		float recaudacion=0;
		String chapa="No hay recaudacion";
		
		for(Omnibus i:omnibus) {
			if(i.getRecaudacion()>recaudacion) {
				recaudacion=i.getRecaudacion();
				chapa=i.getChapa();
			}
		}
		
		return chapa;
	}
	
	public void nuevoOmnibus(Omnibus o) {
		if(o instanceof Astro) {
			Astro a = (Astro) o;
			int libres = a.getCantidadAsientos();
			boolean vendio=true;
			while(vendio&&libres>0) {
				vendio=false;
				for(PO i:listas.oficial) {
					if(i.getDestino().equals(a.getDestino())) {
						o.pasajeros.add(i);
						o.Recaudar();
						libres--;
						vendio=true;
						listas.oficial.remove(i);
						break;
					}
				}
			}
			vendio=true;
			while(libres>0&&vendio) {
				vendio=false;
				for(PE i:listas.espera) {
					if(i.vaA(a.getDestino())) {
						o.pasajeros.add(i);
						o.Recaudar();
						libres--;
						vendio=true;
						listas.espera.remove(i);
						break;
					}
				}
			}
		}
		
		else {
			Turismo t = (Turismo) o;
			int libres = t.getAsientosDisponibles();
			boolean vendio=true;
			while(libres>0&&vendio) {
				vendio=false;
				for(PE i:listas.espera) {
					if(i.vaA(t.getDestino())) {
						o.pasajeros.add(i);
						o.Recaudar();
						libres--;
						vendio=true;
						listas.espera.remove(i);
						break;
					}
				}
			}
		}
		
		omnibus.add(o);
		guardar();
	}
		
	
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
	
	public void cargarListas() throws Exception {
		FileReader espera = new FileReader("Espera.txt");
		Scanner entrada = new Scanner(espera);
		
		while(entrada.hasNext()) {
			String carnet = entrada.next();
			String d1 = entrada.next();
			String d2 = entrada.next();
			String d3 = entrada.next();
			PE persona = new PE(carnet,d1,d2,d3);
			listas.espera.add(persona);
		}
		
		FileReader oficial = new FileReader("Oficial.txt");
		entrada = new Scanner(oficial);
		
		while(entrada.hasNext()) {
			String carnet = entrada.next();
			String dia = entrada.next();
			String destino = entrada.next();
			PO persona = new PO(carnet,dia,destino);
			listas.oficial.add(persona);
		}
		System.out.println(listas.oficial.size());
		
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
		FileWriter espera = new FileWriter("Espera.txt");
		for(PE i:listas.espera) {
			if(i==null)continue;
			espera.write(i.toString()+"\n");
		}
		espera.close();
		FileWriter oficial = new FileWriter("Oficial.txt");
		for(PO i:listas.oficial) {
			if(i==null)continue;
			oficial.write(i.toString()+"\n");
		}
		oficial.close();
	}
	
	public void guardarDatos() throws Exception {
		
		FileOutputStream fos = new FileOutputStream("Datos.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(omnibus);
		
	}
	
	public static void main(String args[]) {
		new Terminal();
	}
}
