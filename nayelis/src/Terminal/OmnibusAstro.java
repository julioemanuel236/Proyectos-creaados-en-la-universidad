package Terminal;

import java.util.LinkedList;

public class OmnibusAstro extends Omnibus{
	private String diaSalida;
	private String horaSalida;
	private int cantidadAsientos;
	
	public OmnibusAstro(String chapa, Pasajero chofer, String destino, float kM, String diaSalida, String horaSalida,int cantidadAsientos) {
		super(chapa, chofer, destino, kM);
		this.diaSalida = diaSalida;
		this.horaSalida = horaSalida;
		this.cantidadAsientos = cantidadAsientos;
	}
	
	public String getDiaSalida() {
		return diaSalida;
	}
	
	public String getHoraSalida() {
		return horaSalida;
	}
	
	public int getCantidadAsientos() {
		return cantidadAsientos;
	}
	
	@Override
	public float Precio() {
		return getKM()*4;
	}

	@Override
	public String cargar(LinkedList<PasajeroEspera> espera, LinkedList<PasajeroOficial> oficial) {
		String resultado="";
		int cantidad=0;
		int libres = getCantidadAsientos();
		boolean vendio=true;
		while(vendio&&libres>0) {
			vendio=false;
			for(PasajeroOficial i:oficial) {
				if(i.getDestino().equals(getDestino())&&
					diaSalida.equals(i.getDia())) {
					
					pasajeros.add(i);
					resultado+=i.datos()+"\n";
					cantidad++;
					Recaudar();
					libres--;
					vendio=true;
					oficial.remove(i);
					break;
				}
			}
		}
		vendio=true;
		while(libres>0&&vendio) {
			vendio=false;
			for(PasajeroEspera i:espera) {
				if(i.esperaPara(getDestino())) {
					pasajeros.add(i);
					resultado+=i.datos()+"\n";
					cantidad++;
					Recaudar();
					libres--;
					vendio=true;
					espera.remove(i);
					break;
				}
			}
		}
	
		return "Abordaron "+cantidad+" pasajeros:\n\n"+resultado;
	}	
	
	@Override
	public String datos() {
		return super.datos()+"Astro ";
	}
	
}
