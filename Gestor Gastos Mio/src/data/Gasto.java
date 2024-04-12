package data;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Gasto {

	private String nombre;
	private String tipo;
	
	private BigDecimal costeUnitario;
	private BigDecimal unidades;
	private long tiempoCreacion;	
	
	public Gasto(String nombre,String tipo,String costeUnitario,int unidades) {
		iniData(nombre, tipo, costeUnitario, unidades);
		this.tiempoCreacion = System.currentTimeMillis();
	}
	
	public Gasto(String nombre,String tipo,String costeUnitario,int unidades,long tiempoCreacion) {
		iniData(nombre,tipo,costeUnitario,unidades);
		this.tiempoCreacion = tiempoCreacion;
	}
	
	private void iniData(String nombre,String tipo,String costeUnitario,int unidades) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.costeUnitario = new BigDecimal(costeUnitario);
		this.unidades = new BigDecimal(unidades);
	}
	
	public BigDecimal getCosteTotal() {
		return this.costeUnitario.multiply(this.unidades);
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public BigDecimal getCosteUnitario() {
		return costeUnitario;
	}

	public BigDecimal getUnidades() {
		return unidades;
	}
	
	public String toString(){
		return nombre+'\n'+tipo+'\n'+costeUnitario.toString()+'\n'+unidades.toString();
	}

	public long getTiempoCreacion() {
		return tiempoCreacion;
	}
	
	
}
