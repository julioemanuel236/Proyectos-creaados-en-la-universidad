package cadena;
import java.util.ArrayList;
import java.io.*;
public class Hotel extends Object implements Serializable{

	private String nombre;
	private int    capacidad;
	private ArrayList<Piso> pisos;
	private ArrayList<Empleado> empleados;
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Reservacion> reservaciones = new ArrayList<>();
	private ArrayList<Socio> socios = new ArrayList<>();
	
	public Hotel(String nombre,int capacidad, ArrayList<Piso> pisos, ArrayList<Empleado> empleados) {
		this.nombre = nombre;
		this.pisos = pisos;
		this.empleados = empleados;
		this.capacidad=capacidad;
	}
	
	
	public void nuevaReservacion() {
		Cliente c;
		String tipoHabitacion = (String) Utiles.seleccion("Tipo Habitacion",new String[]{"Simple","Doble","Triple"});
		if(tipoHabitacion==null)return;
		String nombre = Utiles.leer("Nombre Cliente");
		if(nombre==null)return;
		String id = Utiles.leer("ID Cliente");
		if(id==null)return;
		String sexo = Utiles.leer("Sexo Cliente");
		if(sexo==null)return;
		String entrada = Utiles.leer("Fecha Entrada Cliente");
		if(entrada==null)return;
		String salida = Utiles.leer("Fecha Salida Cliente");
		if(salida==null)return;
		String pais = Utiles.leer("Pais de procedencia");
		if(pais==null)return;
		boolean vip = Utiles.sino("Es Cliente VIP");
		
		if(vip) {
			String cargo = Utiles.leer("Cargo Cliente");
			if(cargo==null)return;
			c = new Vip(nombre,id,sexo,entrada,salida,cargo);
		}
		
		else c = new Cliente(nombre,id,sexo,entrada,salida);
		
		clientes.add(c);
		ArrayList<Habitacion> hb = new ArrayList<>();
		for(Piso p:pisos) {
			hb.addAll(p.getHabitaciones());
		}
		Habitacion h = (Habitacion) Utiles.seleccion("Seleccione una Habitacion",hb.toArray());
		if(h!=null)
			reservaciones.add(new Reservacion(c,h.getPrecio(),pais));
	}

	float ganancias() {
		float f=0;
		
		for(Reservacion r:reservaciones) {
			f+=r.getPrecio();
		}
		
		return f;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String datosVips() {
		String s="";
		
		for(Cliente i:clientes) {
			if (i instanceof Vip) {
				Vip vip = (Vip) i;
				s+=vip.datos()+'\n';
			}
		}
		
		return s;
	}
	
	public String paisMayorProcedencia() {
		ArrayList<String> pais = new ArrayList<>();
		ArrayList<Integer> porcentaje = new ArrayList<>();
		
		for(Reservacion r:reservaciones) {
			boolean b=false;
			for(int i=0;i<pais.size();i++) {
				
				if(pais.get(i).equals(r.getPais())) {
					porcentaje.set(i,porcentaje.get(i)+1);
					b=true;
				
			}
			}
			if(!b) {
				pais.add(r.getPais());
				porcentaje.add(1);
			}
		}
		String pam="";
		int pm=0;
		for(int i=0;i<pais.size();i++) {
			if(porcentaje.get(i)>pm) {
				pm = porcentaje.get(i);
				pam = pais.get(i);
			}
		}
		
		return pam;
	}

	public String porcentajeOcupacionFecha(String f) {
		int c=0;
		for(Reservacion r:reservaciones) {
			if(r.ocupado(f))c++;
		}
		
		return "%"+(c/capacidad)*100;
	}
	
	public float pagoEmpleados() {
		float f=0;
		for(Empleado e:empleados) {
			if(e instanceof Jefe) {
				f+=((Jefe)e).Salario();
			}
			else f+=e.Salario();
		}
		return f;
	}
	
	public int cantidadMayorProcedencia() {
		ArrayList<String> pais = new ArrayList<>();
		ArrayList<Integer> porcentaje = new ArrayList<>();
		
		for(Reservacion r:reservaciones) {
			boolean b=false;
			for(int i=0;i<pais.size();i++) {
				
				if(pais.get(i).equals(r.getPais())) {
					porcentaje.set(i,porcentaje.get(i)+1);
					b=true;
				}
				
			}
			if(!b) {
				pais.add(r.getPais());
				porcentaje.add(1);
			}
		}
		String pam="";
		int pm=0;
		for(int i=0;i<pais.size();i++) {
			if(porcentaje.get(i)>pm) {
				pm = porcentaje.get(i);
				pam = pais.get(i);
			}
		}
		
		return pm;
	}
	
	public ArrayList<Socio> getSocios(){
		return socios;
	}
	
	public ArrayList<Piso> getPisos() {
		return pisos;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public String toString() {
		return nombre;
	}

}
