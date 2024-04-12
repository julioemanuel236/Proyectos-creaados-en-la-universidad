package empresa_turistica;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Excursion implements Serializable{
	private int numero;
	private String nombre;
	private float precioPersona;
	private Carro carro;
	private Persona[] clientes;
	
	public Excursion(String nombre,int numero,float preciop,Carro carro) {
		this.nombre=nombre;
		this.numero=numero;
		this.precioPersona=preciop;
		this.carro=carro;
		this.clientes = new Persona[carro.getCantidadAsientos()];
	}
	
	public Excursion() {
		
	}
	
	public Excursion(Excursion e) {
		this.numero=e.numero;
		this.nombre=e.nombre;
		this.precioPersona=e.precioPersona;
		this.carro=new Carro(e.carro);
		this.clientes = new Persona[e.clientes.length];
		System.out.println(e.carro.getOcupados());
		for(int i=0;i<e.carro.getOcupados();i++) {
			if(this.clientes[i]==null)continue;
			System.out.println(e.nombre+" "+e.clientes[i]);
			this.clientes[i] = new Persona(e.clientes[i]);
		}
	}
	
	public boolean nuevoCliente(Persona cliente) {
		if(carro.getOcupados()<carro.getCantidadAsientos()) {
			clientes[carro.masOcupados()] = cliente;
			return true;
		}
		else {
			return false;
		}
	}

	public float getRecaudacion() {
		return carro.getOcupados()*precioPersona;
		
	}
	
	public String Reporte() {
		return "EXCURSION: \n\t"+"Nombre: "+nombre+"\n\t"+"Numero: "+numero+"\n\t"+"Precio por Persona: "+precioPersona+"\n\t"+"Capacidad: "+carro.getCantidadAsientos()+"\n\tReservas: "+carro.getOcupados()+"\n\tGanancias: "+carro.getOcupados()*precioPersona
				+"\n"+carro.Reporte()+"\n\n";
	}
	
	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecioPersona() {
		return precioPersona;
	}

	public Carro getCarro() {
		return carro;
	}

	public Persona[] getClientes() {
		return clientes;
	}

	public String toString() {
		return nombre;
	}
	
}