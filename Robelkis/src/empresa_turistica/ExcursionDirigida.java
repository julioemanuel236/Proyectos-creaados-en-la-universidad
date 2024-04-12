package empresa_turistica;

public class ExcursionDirigida extends Excursion {
	String nombreGuia;
	
	public ExcursionDirigida(String nombre,int numero,float preciop,Carro carro,String guia) {
		super(nombre,numero,preciop,carro);
		this.nombreGuia=guia;
	}
	
	@Override
	public String Reporte() {
		return "EXCURSION: \n\t"+"Nombre: "+getNombre()+
				"\n\t"+"Numero: "+getNumero()+
				"\n\t"+"Guia: "+nombreGuia+
				"\n\t"+"Precio por Persona: "+
				getPrecioPersona()+"\n\t"+"Capacidad: "+
				getCarro().getCantidadAsientos()+"\n\tReservas: "+
				getCarro().getOcupados()+"\n\tGanancias: "+
				getCarro().getOcupados()*getPrecioPersona()
				+"\n"+getCarro().Reporte()+"\n\n";
	}

	public String getGuia() {
		return nombreGuia;
	}

	public String toString() {
		return getNombre()+ " " +nombreGuia;
	}
}