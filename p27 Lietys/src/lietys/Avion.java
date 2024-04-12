package lietys;

import java.io.Serializable;


public class Avion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Asiento asiento[];
	private String matricula;
	private String modelo;
	private String nombre;
	private String paisFabricante;
	private int    cantidadAsientos;
	
	public Asiento[] getAsiento() {
		return asiento;
	}

	public void setAsiento(Asiento[] asiento) {
		this.asiento = asiento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getCantidadAsientos() {
		return cantidadAsientos;
	}

	public void setCantidadAsientos(int cantidadAsientos) {
		this.cantidadAsientos = cantidadAsientos;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaisFabricante() {
		return paisFabricante;
	}

	public void setPaisFabricante(String paisFabricante) {
		this.paisFabricante = paisFabricante;
	}

	public Avion(String nombre,String modelo,String matricula,String paisfabricante,int cantidadasientos) {
		this.nombre=nombre;
		this.modelo=modelo;
		this.matricula=matricula;
		this.paisFabricante=paisfabricante;
		this.cantidadAsientos=cantidadasientos;
		asiento = new Asiento[this.cantidadAsientos];
		int c1=(cantidadasientos*15)/100;
		int c2=(cantidadasientos*25)/100;
		int c3=(cantidadasientos*60)/100;
		if(c1==0)c1=1;
		if(c2==0)c2=2;
		if(c3==0)c3=3;
		System.out.println(c1+" "+c2+" "+c3);
		for(int i=0;i<cantidadAsientos;i++) {
			asiento[i] = new Asiento();
			asiento[i].setNumero(i+1);
			if(i<c1)asiento[i].setCategoria(1);
			else if(i<c1+c2)asiento[i].setCategoria(2);
			else if(i<=cantidadAsientos)asiento[i].setCategoria(3);;
			System.out.println(asiento[i].getNumero()+" "+asiento[i].getCategoria());
		}
	}
	
	public String toString() {
		return nombre+" "+modelo+" "+paisFabricante+" "+matricula;
	}

	public Avion clone() {
		return new Avion(this.nombre,this.modelo,this.matricula,this.paisFabricante,this.cantidadAsientos);
	}
}
