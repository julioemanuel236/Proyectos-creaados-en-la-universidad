package empresa_turistica;

import java.io.Serializable;

public class Carro implements Serializable{
	
	
	private String chapa;
	private Persona chofer;
	private int cantidadAsientos;
	private int ocupados=0;
	private String tipo;
	
	public String getChapa() {
		return chapa;
	}

	public Persona getChofer() {
		return chofer;
	}

	public int getCantidadAsientos() {
		return cantidadAsientos;
	}

	public int masOcupados() {
		ocupados++;
		return ocupados-1;
	}
	
	public int getOcupados() {
		return ocupados;
	}

	public String getTipo() {
		return tipo;
	}

	Carro(String chapa,Persona chofer,int asientos,String tipo){
		this.chapa=chapa;
		this.chofer=chofer;
		this.cantidadAsientos=asientos;
		this.tipo=tipo;
	}
	
	Carro(){
		
	}
	
	Carro(Carro c){
		this.chapa=c.chapa;
		this.chofer=new Persona(c.chofer);
		this.cantidadAsientos=c.cantidadAsientos;
		this.ocupados=c.ocupados;
		this.tipo=c.tipo;
	}
	
	public String Reporte() {
		return "VEHICULO: \n\t"+"Chapa: "+chapa+
				"\n\tTipo: "+tipo+
				"\n\tCantidad de Asientos: "+
				cantidadAsientos+"\n"+chofer.Reporte();
	}
	
	public String toString() {
		return "Carro: "+" "+chapa;
	}
	
}
