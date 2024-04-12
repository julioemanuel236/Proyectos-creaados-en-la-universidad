package data;
import java.math.BigDecimal;

public class Gasto {

	private String nombre;
	private String tipo;
	
	private BigDecimal costeUnitario;
	private BigDecimal unidades;
	private long tiempoCreacion;	
	private Moneda moneda;
	
	public Gasto(String nombre,String tipo,String costeUnitario,int unidades,Moneda moneda) {
		iniData(nombre, tipo, costeUnitario, unidades,moneda);
		this.tiempoCreacion = System.currentTimeMillis();
		
	}
	
	public Gasto(String nombre,String tipo,String costeUnitario,int unidades,long tiempoCreacion,Moneda moneda) {
		iniData(nombre,tipo,costeUnitario,unidades,moneda);
		this.tiempoCreacion = tiempoCreacion;
	}
	
	private void iniData(String nombre,String tipo,String costeUnitario,int unidades,Moneda moneda) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.costeUnitario = new BigDecimal(costeUnitario);
		this.unidades = new BigDecimal(unidades);
		this.moneda = moneda;
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
		return nombre+'\n'+tipo+'\n'+costeUnitario.toString()+'\n'+unidades.toString()+'\n'+moneda;
	}

	public long getTiempoCreacion() {
		return tiempoCreacion;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setCosteUnitario(BigDecimal costeUnitario) {
		this.costeUnitario = costeUnitario;
	}

	public void setUnidades(BigDecimal unidades) {
		this.unidades = unidades;
	}

	public void setTiempoCreacion(long tiempoCreacion) {
		this.tiempoCreacion = tiempoCreacion;
	}
	
	
	
}
