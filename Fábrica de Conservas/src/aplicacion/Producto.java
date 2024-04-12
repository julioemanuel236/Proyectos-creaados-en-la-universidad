package aplicacion;

public class Producto {	
	private String nombre;
	private float coste;
	private String fechaVencimiento;
	private Material tipoEnvase;
	private String  mercado;
	private int[] 	produccion = new int[12];
	
	public Producto(String nombre,float coste,String vencimiento,Material envase,String mercado) {
		this.nombre=nombre;
		this.coste=coste;
		this.fechaVencimiento=vencimiento;
		this.tipoEnvase=envase;
		this.mercado=mercado;
	}
	
	public Producto(Producto p) {
		this.nombre=p.nombre;
		this.coste=p.coste;
		this.fechaVencimiento=p.fechaVencimiento;
		this.tipoEnvase=p.tipoEnvase;
		this.mercado=p.mercado;
	}
	
	public boolean exportacion() {
		return (this.mercado.equals("Nacional")?false:true);
	}
	
	public float getValor() {
		return this.getCosteFinal()*this.getProduccionAnual();
	}
	
	public float getValor(int mes) {
		return this.getCosteFinal()*this.getProduccion(mes);
	}
	
	public String informacion() {
		return "Nombre Producto: "+nombre+'\n'+
		 "Valor de venta: "+getCosteFinal()+'\n'+
		 "Importe de venta: "+getValor()+'\n'+
		 "Fecha de vencimiento: "+fechaVencimiento+'\n'+
		 "Mercado destino: "+mercado+'\n'+
		 tipoEnvase.informacion()+"\n"+
		 "----------------------------------------------------------\n";
		
	}
	
	public String fichero() {
		return this.nombre+" @\n"+getCosteFinal()+'\n'+this.fechaVencimiento+'\n'+mercado+'\n'+this.tipoEnvase.fichero()+"\n";
	}
	
	public float getCosteFinal() {
		if(mercado=="Nacional")return tipoEnvase.getCoste()+this.coste;
		else return (this.coste*1.75f)+tipoEnvase.getCoste();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getProduccionAnual() {
		int c = 0;
		for(int i=0;i<12;i++)
			c+=produccion[i];
		return c;
	}
	
	public int getProduccion(int mes) {
		return produccion[mes];
	}
	
	public void setProduccion(int mes,int pro) {
		produccion[mes]=pro;
	}
}
