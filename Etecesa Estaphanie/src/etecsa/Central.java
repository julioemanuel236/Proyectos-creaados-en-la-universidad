package etecsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.*;

public class Central {		
	
	public boolean telefonoValido(String s){
		try {
			Integer.parseInt(s);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	private static int codigo;
	protected	ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Llamada> llamadas = new ArrayList<>();
	Map<String,Float> paises;
	
	Central(){
		load();
	}
	
	public String nuevoCliente(Cliente c) {
		clientes.add(c);
		save();
		return "Cliente agregado con exito";
	}

	public String bajaTemporal(Cliente c) {
		return c.setCancelada(true);
		
	}

	public String cargarLlamadas() {
		try {
			FileReader file = new FileReader("Registro.txt");
			Scanner entry = new Scanner(file);
			String numero,codigo,fecha;
			int hora;
			float duracion;
			while(entry.hasNext()){
				numero = entry.next();
				codigo = entry.next();
				fecha = entry.next();
				hora = entry.nextInt();
				duracion = entry.nextFloat();
				this.llamadas.add(new Llamada(numero,codigo,duracion,hora));
			}
			entry.close();
			file.close();
			return "LLamadas cargadas con exito";
		}
		catch(Exception e) {
			return "Erro al cargar los datos";
		}
	}

	public String mostrarLlamadas() {
		String s = "";
		for(Llamada i:llamadas) {
			s+=i.data()+"\n";
		}
		return s;
	}

	public float pago(Cliente c) {
		float pago=0;
		
		for(int i=0;i<llamadas.size();i++){
			if(llamadas.get(i).getNumero()==c.getTelefono()){
				pago+=llamadas.get(i).calcularCoste(codigo,1);
			}
		}

		return pago;
	}

	public String pagoClientes() {
		String s="";
		
		for(Cliente c:clientes) {
			s+=c.datos()+": "+pago(c)+"\n\n";
		}
	
		return s;
	}
	
	public String rastreo(Cliente c) {
		if(!(c instanceof Residencial)) {
			return "El cliente no es residencial";
		}
		
		if(!((Residencial)(c)).tieneMatutino()) {
			return "El cliente no tiene el servicio de rastreo activado";
		}
		
		String s="";
		for(int i=0;i<llamadas.size();i++){
			String a = c.getTelefono();
			
			int p2 = llamadas.get(i).getCodigo().lastIndexOf(' ')+1;				
			String b=llamadas.get(i).getCodigo().substring(p2,p2+llamadas.get(i).getCodigo().length()-p2+1);
			if(a.equals(b))
				s+=llamadas.get(i).data()+'\n';
		}
		return s;
	}

	public String clienteMasTiempo() {
		Map<String,Float> tiempo = new HashMap<>();
		if(clientes.size()==0)return "No hay clientes registrados";
		for(Llamada i:llamadas) {
			if(tiempo.containsKey(i.getNumero())) {
				tiempo.put(i.getNumero(), tiempo.get(i.getNumero())+i.getDuracion());
			}
			else tiempo.put(i.getNumero(), i.getDuracion());
		}
		
		float duracion = 0;
		String numero ="No hay llamadas registradas";
		
		for(String i:tiempo.keySet()) {
			if(tiempo.get(i)>duracion) {
				duracion=tiempo.get(i);
				numero=i;
			}
		}
		
		return numero;
		
	}

	public String ficheroMatutino(Cliente c) {
		if(!(c instanceof Residencial)) {
			return "El cliente no es residencial";
		}
		if(!((Residencial)c).tieneMatutino()) {
			return "El cliente no tiene el servicio matutino activado";
		}
		String h="No tiene Alarmas Programadas";
		String m="";
		for(Llamada i:llamadas) {
			if(i.getNumero().equals(c.getTelefono())) {
				if(i.getCodigo().contains("-077-")) {
					String r =i.getCodigo();
					String hora = r.substring(r.length()-4,4);
					h=hora.substring(0,2);
					m=hora.substring(2,4);
				}
			}
		}
		try{
			FileWriter file = new FileWriter("MATUTINO.txt");
			file.write(h+":"+m);
			return "Fichero generado con exito";
		}
		catch(Exception e) {
			return "Error al generar fichero";
		}
	}
	
	public String teleSeleccion() {
		String s="";
		Map<String,Float> pagos = new HashMap<>();
		
		for(Llamada i:llamadas) {
			if(i.tipo()==2) {
				float tarifa=1;
				if(i.tipo()==2) {
					if(paises.keySet().contains(i.getCodigo().substring(2,4))) {
						tarifa=paises.get(i.getCodigo());
					}
				}
				if(tarifa==0)tarifa=1;
				if(pagos.keySet().contains(i.getNumero()))
					pagos.put(i.getNumero(), pagos.get(i.getNumero())+i.calcularCoste(codigo, tarifa));
				else pagos.put(i.getNumero(), i.calcularCoste(codigo, tarifa));
			}
		}
		
		for(String i:pagos.keySet()) {
			for(Cliente c:clientes) {
				if(c.getTelefono().equals(i)) {
					s+=i+": "+pagos.get(i)+'\n';
				}
			}
		}
		
		return s;
	}

	public String pagoMetrado() {
		String s="";
		Map<String,Float> tiempo = new HashMap<>();
		
		for(Llamada i:llamadas) {			
				if(tiempo.keySet().contains(i.getNumero()))
					tiempo.put(i.getNumero(), tiempo.get(i.getNumero())+i.getDuracion());
				else tiempo.put(i.getNumero(), i.getDuracion());
		}
		
		for(String i:tiempo.keySet()) {
			for(Cliente c:clientes) {
				if(c.getTelefono().equals(i)) {
					s+=c.getTelefono()+": "+Math.max(0f,tiempo.get(i)-300)*0.05;
				}
			}
		}
		return s;
	}
			
	public String nuevoPais(String codigo,float tarifa) {
		if(paises.keySet().contains(codigo)) {
			JOptionPane.showMessageDialog(null, "Ese codigo de pais ya existe");
			return "Este codigo de pais ya esta registrado";
		}
		paises.put(codigo, tarifa);
		return "Codigo "+codigo+" agregadi con exito";
	}
	
	public void save() {
		try {
			FileOutputStream file = new FileOutputStream("DATOS.dat");
			ObjectOutputStream object = new ObjectOutputStream(file);
			
			object.writeObject(clientes);
			object.writeObject(paises);
			object.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al guardar datos");
		}
	}
	
	public void load() {
		try {
			FileInputStream file = new FileInputStream("DATOS.dat");
			ObjectInputStream object = new ObjectInputStream(file);	
			clientes = (ArrayList<Cliente>) object.readObject();
			paises = (Map<String,Float>) object.readObject();
		}
		catch(Exception e) {
			//JOptionPane.showMessageDialog(null, "Error al cargar datos");
		}
	}
}
