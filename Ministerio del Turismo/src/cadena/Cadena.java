package cadena;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;

public class Cadena implements Serializable{
	private ArrayList<Hotel> hoteles = new ArrayList<>();
	
 	public void nuevoHotel() {
            try{
				String nombreHotel = Utiles.leer("Nombre del Hotel");
				if(nombreHotel==null)return;
				int capacidad = Integer.parseInt(Utiles.leer("Capacidad del Hotel"));
				int cantidadPisos = Integer.parseInt(Utiles.leer("Cantidad de Pisos"));
				
				ArrayList<Piso> pisos = new ArrayList<>();
				
				int numerohab=1;
				
				for(int i=1;i<=cantidadPisos;i++){
					int cantidadHabitaciones = Integer.parseInt(Utiles.leer("Cantidad de Habitaciones en el piso "+i));
					ArrayList<Habitacion> habitaciones = new ArrayList<>();
					Piso p = new Piso(i,habitaciones);
					pisos.add(p);
					for(int j=0;j<cantidadHabitaciones;j++) {
							float precio = Float.parseFloat(Utiles.leer("Precio de la habitaion "+numerohab));
							habitaciones.add(new Habitacion(p,numerohab++,precio));
						}	
					}
				
				int cantidadEmpleados = Integer.parseInt(Utiles.leer("Cantidad de Empleados"));
				ArrayList<Empleado> empleados = new ArrayList<>();
				for(int i=0;i<cantidadEmpleados;i++) {
					Empleado e;
					String nombre = Utiles.leer("Nombre empleado "+i);
					if(nombre==null)return;
					String id = Utiles.leer("ID empleado "+i);;
					if(id==null)return;
					String sexo = Utiles.leer("Sexo empleado "+i);;
					if(sexo==null)return;
					int anos = Integer.parseInt(Utiles.leer("A�os Trabajados empleado "+i));
					boolean esJefe = Utiles.sino("Es Jefe");
					
					if(esJefe) {
						e = new Jefe(nombre,id,sexo,anos,Integer.parseInt(Utiles.leer("Anos de Jefe empleado "+i)));
					}
					else e = new Empleado(nombre,id,sexo,anos);
					
					empleados.add(e);
				}
				Hotel h = new Hotel(nombreHotel, capacidad, pisos, empleados);
				hoteles.add(h);
				guardar();
		    }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR AL INTRODUCIR LOS DATOS");
            	}
            }

	public void nuevaReservacion() {
            try{                              
                Hotel h =(Hotel)Utiles.seleccion("Seleccion un Hotel", hoteles.toArray());
                if(h!=null)h.nuevaReservacion();
                guardar();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR AL INTRODUCIR LOS DATOS");
            }
	}
 	
	public void nuevoSocio() {
		String pais = Utiles.leer("Pais");
		if(pais==null)return;
		float porcentaje = Float.parseFloat(Utiles.leer("Porcentaje de Ganancias"));
		
		Hotel h = (Hotel) Utiles.seleccion("Hotel",hoteles.toArray());
		if(h==null)return;
		h.getSocios().add(new Socio(pais,porcentaje));
		guardar();
	}
	
	public String ganancias() {
		float f=0;
		for(Hotel h:hoteles) {
			f+=h.ganancias();
		}
		return "Las ganancias de la cadena por concepto de Reservacion es de: " + f;
	}

	public String paisMasPorcentaje() {
		ArrayList<String> pais = new ArrayList<>();
		ArrayList<Float> porcentaje = new ArrayList<>();
		
		for(Hotel h:hoteles) {
			for(Socio s:h.getSocios()) {
				boolean b=false;
				for(int i=0;i<pais.size();i++) {
					
					if(pais.get(i).equals(s.getPais())) {
						porcentaje.set(i,porcentaje.get(i)+s.getPorcentajeGanancias());
						b=true;
					}
				}
				if(!b) {
					pais.add(s.getPais());
					porcentaje.add(s.getPorcentajeGanancias());
				}
			}
		}			
		
		String pam="";
		float pm=0; 
		for(int i=0;i<pais.size();i++) {
			if(porcentaje.get(i)>pm) {
				pm = porcentaje.get(i);
				pam = pais.get(i);
			}
		}
		if(pais.isEmpty()) return "No hay socios registrados en nigun hotel";
		return "El pais socio con mayor porcentaje de ganancias es "+pam;
	}

	public String datosClientesVip() {
		String s="";
		
		Hotel h = (Hotel)Utiles.seleccion("Hotel", hoteles.toArray());
		if(h==null)return null;
		return h.datosVips();
	}

	public String paisMasTuristas() {
		String pais[] = new String[hoteles.size()];
		int    cant[] = new int[hoteles.size()];
		for(int i=0;i<hoteles.size();i++) {
			pais[i]=hoteles.get(i).paisMayorProcedencia();
			cant[i]=hoteles.get(i).cantidadMayorProcedencia();
		}
		
		String pm="";
		int cm=0;
		
		for(int i=0;i<hoteles.size();i++) {
			if(cant[i]>cm) {
				cm=cant[i];
				pm=pais[i];
			}
		}
		
		return "El pais que aporto mas turistas fue "+pm;
	}
	
	public String porcentajeOcupacionFecha() {
		String f = Utiles.leer("Fecha");
		Hotel h = (Hotel) Utiles.seleccion("Hotel", hoteles.toArray());
		if(h!=null)
			return "El porcentaje de ocupacion en "+f+"fue de "+h.porcentajeOcupacionFecha(f);
		return "No se ha seleccionado un Hotel";
	}

	public String cantidadDineroPagoEmpleados() {
		float f=0;
		
		for(Hotel h:hoteles) {
			f+=h.pagoEmpleados();
		}
		
		return "La cantidad de dinero a pagar a los empleados es de "+f;
	}
	
	public void guardar() {
		try {
			FileOutputStream fos = new FileOutputStream("Datos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);			
			oos.writeObject(hoteles);
			oos.close();
			fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			
	
	public void cargar() {
		try {
			FileInputStream fis = new FileInputStream("Datos.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			hoteles = (ArrayList<Hotel>) ois.readObject();
			ois.close();
			fis.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Cadena() {
		cargar();
	}
	
	public static void main(String args[]) {		
		new Interfaz();
	}
	
}
