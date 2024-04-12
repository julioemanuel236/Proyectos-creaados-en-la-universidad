package Terminal;

import java.util.LinkedList;

public class OmnibusTurismo extends Omnibus{
	private String Llegada;
	private int asientos;

	public OmnibusTurismo(String chapa, Pasajero chofer, String destino, float kM, String horaLlegada, int asientosDisponibles) {
		super(chapa, chofer, destino, kM);
		this.Llegada = horaLlegada;
		this.asientos = asientosDisponibles;
	}
	
	public String getHoraLlegada() {
		return Llegada;
	}
	
	public int getAsientosDisponibles() {
		return asientos;
	}

	@Override
	public float Precio() {
	      if(getKM()<100) return 10; 
	      else if(getKM()>100&&getKM()<200) return 20;
	      else return 30;

	}

	@Override
	public String cargar(LinkedList<PasajeroEspera> espera, LinkedList<PasajeroOficial> oficial) {
		String resultado="";
		int cantidad=0;
		int libres = getAsientosDisponibles();
		boolean vendio=true;
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
		return super.datos()+"Turismo ";
	}
	
}
