package banco;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
public class Sucursal {
	protected ArrayList<Solicitud> solicitudes;
	
	public Sucursal() {
		if(!cargar())solicitudes = new ArrayList<>();
	}
	
	public String nuevaSolicitud(Solicitud s) {
		if(s!=null)
			solicitudes.add(s);
		else return "Error, la solicitud no puede estar vacia";
		guardar();
		return "Solicitud agregada con exito";
	}
	
	public String personasConCapacidadDePagoSobre200() {
		String personas="";
		
		for(int i=0;i<solicitudes.size();i++) {
			if(solicitudes.get(i) instanceof Personal) {
				Personal p = (Personal)solicitudes.get(i);
				
				if(p.capacidadDePago()>200)
					personas+=p.getNombre()+' '+p.getCarnet()+'\n';
			}
			
		}
		if(personas.equals(""))return "No hay clientes con esos requisitos";
		return personas;
	}
	
	public String listadoPersonasPuedenRecibir() {
		String lista="";
		
		ArrayList<Personal> arr = new ArrayList<>();

		
		for(int i=0;i<solicitudes.size();i++) {
			if(solicitudes.get(i) instanceof Personal) {
				if(solicitudes.get(i).puedeSolicitar()) {
					Personal p = (Personal)solicitudes.get(i);
					arr.add(p);
				}
			}
		}
		Comparator<Personal> cmp = new Comparator<>() {

			@Override
			public int compare(Personal o1, Personal o2) {
				return o1.getCarnet().compareTo(o2.getCarnet());
				
			}
			
		};
		
		Collections.sort(arr,cmp);
		for(int i=0;i<arr.size();i++)
			lista+=arr.get(i).datos()+'\n';
		
		if(arr.isEmpty())return "No hay clientes con esos requisitos";
		return lista;
	}

	public String listadoEmpresasPuedenRecibir() {
		String lista="";
		
		ArrayList<Empresarial> arr = new ArrayList<>();

		
		for(int i=0;i<solicitudes.size();i++) {
			if(solicitudes.get(i) instanceof Empresarial) {
				if(solicitudes.get(i).puedeSolicitar()) {
					Empresarial p = (Empresarial)solicitudes.get(i);
					arr.add(p);
				}
			}
		}
		Comparator<Empresarial> cmp = new Comparator<>() {

			@Override
			public int compare(Empresarial o1, Empresarial o2) {
				int ministerio = o1.getMinisterio().compareTo(o2.getMinisterio());
				if(ministerio==0)return o1.getCodigo().compareTo(o2.getCodigo());
				return ministerio;
				
			}
			
		};
		
		Collections.sort(arr,cmp);
		for(int i=0;i<arr.size();i++)
			lista+=arr.get(i).datos()+'\n';
		
		if(arr.isEmpty())return "No hay clientes con esos requisitos";
		return lista;
	}

	public float dineroTotalCredito() {
		float dineroTotal=0;
		
		for(int i=0;i<solicitudes.size();i++)
			if(solicitudes.get(i).puedeSolicitar())dineroTotal+=solicitudes.get(i).getCredito();
		
		return dineroTotal;
	}

	public String tiempoPagarPersonales() {
		String tiempoPago="";
		
		for(int i=0;i<solicitudes.size();i++) {
			if(solicitudes.get(i).puedeSolicitar()) 
				if(solicitudes.get(i) instanceof Personal) {
					Personal p = (Personal)solicitudes.get(i);
					tiempoPago+=p.getCarnet()+'\t'+p.tiempoPago()+" Meses \n";
			
			}
		}
		if(tiempoPago.equals(""))return "No hay clientes con esos requisitos";
		return tiempoPago;
	}

	public String tiempoPagarEmpresariales() {
		String tiempo="";
		
		for(int i=0;i<solicitudes.size();i++) {
			if(solicitudes.get(i).puedeSolicitar()) 
				if(solicitudes.get(i) instanceof Empresarial) {
					Empresarial p = (Empresarial)solicitudes.get(i);
					tiempo+=p.getNombre()+'\t'+p.tiempoPago()+" Meses\n";
			
			}
		}
		if(tiempo.equals(""))return "No hay clientes con esos requisitos";
		return tiempo;
	}

	public boolean guardar() {
		try {
			FileOutputStream fos = new FileOutputStream("solicitudes.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(solicitudes);
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean cargar() {
		try {
			FileInputStream fis = new FileInputStream("solicitudes.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			solicitudes = (ArrayList<Solicitud>) ois.readObject();

			System.out.println(solicitudes.size());
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
