package empresa_turistica;

public class Guagua extends Carro{
	private int pisos;
	
	public int getPisos() {
		return pisos;
	}

	Guagua(String chapa,Persona chofer,int asientos,String tipo,int pisos){
		super(chapa,chofer,asientos,tipo);
		this.pisos=pisos;
	}
	
	Guagua(Guagua g){
		super(g.getChapa(),g.getChofer(),g.getCantidadAsientos(),g.getTipo());
		this.pisos=g.pisos;
	}
	
	public String Reporte() {
		return "VEHICULO: \n\t"+"Chapa: "+getChapa()+
				"\n\tTipo: "+getTipo()+
				"\n\tCantidad de Asientos: "+
				getCantidadAsientos()+
				"\n\tPisos: "+pisos+
				"\n"+getChofer().Reporte();
	}
	
	public String toString() {
		return "Guagua: "+" "+getChapa();
	}
}
