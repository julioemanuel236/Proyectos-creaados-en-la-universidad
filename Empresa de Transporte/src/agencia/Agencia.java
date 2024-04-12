package agencia;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Agencia {
	
	private ArrayList<CM> modernos = new ArrayList<>();
	private ArrayList<CV> viejos = new ArrayList<>();
	private ArrayList<Viaje> viajes = new ArrayList<>();
	private ArrayList<Provincial> provinciales = new ArrayList<>();
	private ArrayList<Administrativo> admins = new ArrayList<>();
	private ArrayList<Chofer> chofers = new ArrayList<>();
	
	public void nuevoCamionModerno(String chapa,float kml) {
		modernos.add(new CM(chapa,kml));
	}
	
	public void nuevoCamionViejo(String chapa,int anio,int rep) {
		viejos.add(new CV(chapa,anio,rep));
	}
	
	public void nuevoViaje(int dia,int carga,float km,Camion camion,Chofer chofer) {
		camion.addDistanciaTotal(km);
		camion.addToneladas(carga);
		viajes.add(new Viaje(dia,carga,km,camion,chofer));
	}
	
	public void nuevoProvincial(int dia,int carga,int km,Camion camion,Chofer chofer,int regreso,int provincias) {
		camion.addDistanciaTotal(km);
		camion.addToneladas(carga);
		chofer.interProvincial();
		provinciales.add(new Provincial(dia,carga,km,camion,chofer,regreso,provincias));
	}
	
	public void nuevoAdmin(String n,String c,String ne,String s,String t,String d,int x,String cargo,float sal) {
		admins.add(new Administrativo(n,c,ne,s,t,d,x,sal,cargo));
	}
	
	public void nuevoChofer(String n,String c,String ne,String s,String t,String d,int x,float sal,int eva) {
		chofers.add(new Chofer(n,c,ne,s,t,d,x,sal,eva));
	}
	
	public String volumenCarga() {
		float volumen=0;
		float distancia=0;
		for(Viaje i:viajes) {
			volumen+=i.getCarga();
			distancia+=i.getKM();
		}
		for(Provincial i:provinciales) {
			volumen+=i.getCarga();
			distancia+=i.getKM();
		}
		if(distancia==0)distancia=1;
		String s="El total de volumen de carga transportado fue de "+(volumen/(distancia))+" toneladas/kilometro";
		JOptionPane.showMessageDialog(null, s);
		return s;
	}
	
	public String distanciaPromedio(Camion camion) {
		float distancia=0;
		int cv=0;
	
		for(Viaje i:viajes) 			
			if(i.getCamion()==camion) {
				distancia+=i.getKM();
				cv++;
		}
		
		for(Provincial i:provinciales) 
			if(i.getCamion()==camion) {
				distancia+=i.getKM();
				cv++;
			}
		
		
		if(cv==0)cv=1;
		String s="La distancia promedio de recorrida por ese cami�n fue de"+(distancia/cv);
		JOptionPane.showMessageDialog(null, s);
		return s;
	}

	public String datosViajesChapa(Camion m) {
		String s="";
		s="Camion: "+m.getChapa()+'\n';
		
		for(Viaje i:viajes)
			if(i.getCamion()==m)s+=i.datos();
		
		if(m.getClass()==CM.class)
		for(Provincial i:provinciales)
			if(i.getCamion()==m)s+=i.datos();
		return s;
	}

	public String mayorCarga() {
		String s="";
		
		float t=0;
		for(int i=0;i<modernos.size();i++)
			if(modernos.get(i).getToneladas()>t) {
				t=modernos.get(i).getToneladas();
				s=modernos.get(i).datos()+'\n';
			}
			else if(modernos.get(i).getToneladas()==t) {
				s+=modernos.get(i).datos()+'\n';
			}
		JOptionPane.showMessageDialog(null, s);
		return  s;
	}
	
	public String modernosDistancia() {
		String s="";
		
		Comparator<CM> cmp = new Comparator<>() {
			@Override
			public int compare(CM a, CM m) {
				if(a.getDistanciaTotal()>m.getDistanciaTotal())return 1;
				else if(a.getDistanciaTotal()<m.getDistanciaTotal())return -1;
				return 0;
			}
		};
		
		Collections.sort(modernos,cmp);
		
		for(int i=0;i<modernos.size();i++)
			s+=modernos.get(i).datos()+'\n';
		
		return s;
	}

	public String masProvinciasViaje() {
		String s="";
		int provincias=0;
		for(int i=0;i<provinciales.size();i++) {
			Provincial j = provinciales.get(i);
			if(j.getProvinciasVisitadas()>provincias) {
				s=((CM)j.getCamion()).datos()+'\n';
				
			}
			else if(j.getProvinciasVisitadas()==provincias) {
				s+=((CM)j.getCamion()).datos()+'\n';
			}
				
		}
		
		return s;
	}
		
	public String generarNomina() {
		String s="";
		
		for(Administrativo i:admins)
			s+=i.getCarnet()+"\t"+i.getSalario()+'\n';
		
		for(Chofer i:chofers)
			s+=i.getCarnet()+"\t"+i.getSalario()+'\n';
		
		try {
			FileWriter fw = new FileWriter("Nomina.txt");
			fw.write(s);
			fw.close();
		}
		catch(Exception e) {
			
		}
		
		return s;
	}

	public String Guardar() {
		String s="";
		try {
			FileWriter fw = new FileWriter("Viajes.txt");
			for(Viaje i:viajes)
				s+=i.fichero()+'|';
			for(Provincial i:provinciales)
				s+=i.fichero()+'|';
			fw.write(s);
			fw.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al guardar los viajes en archivo");
		}
		return s;
	}

	public String Cargar() {
		String s="";
		try {
			FileReader fr = new FileReader("Viajes.txt");
			Scanner entrada = new Scanner(fr);
			while(entrada.hasNext()) {
				String r=entrada.next();
				char arr[] = r.toCharArray();
				for(int i=0;i<r.length();i++) {
					if(arr[i]=='|')arr[i]='\n';
				}
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i]);
					s+=arr[i];
				}
				System.out.println("");
				entrada.close();
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar los viajes del archivo");
		}
		return s;
	}	
	
	public ArrayList<CM> getModernos(){
		return modernos;
	}
	
	public ArrayList<CV> getViejos(){
		return viejos;
	}

	public ArrayList<Camion> getCamiones(){
		ArrayList<Camion> v = new ArrayList<>();
		v.addAll(modernos);
		v.addAll(viejos);
		return v;
	}
	
	public ArrayList<Chofer> getChofers(){
		return chofers;
	}

	public ArrayList<Chofer> getChofersA(){
		ArrayList<Chofer> v = new ArrayList<Chofer>();
		for(Chofer i:chofers)
			if(i.getCategoria()=='A')v.add(i);
		
		return v;
	}
	
	public ArrayList<Chofer> getChofersB(){
		ArrayList<Chofer> v = new ArrayList<Chofer>();
		for(Chofer i:chofers)
			if(i.getCategoria()=='B')v.add(i);
		
		return v;
	}

	public ArrayList<Trabajador> getTrabajadores(){
		ArrayList<Trabajador> v = new ArrayList<Trabajador>();
		v.addAll(admins);
		v.addAll(chofers);
		return v;
	}

}
