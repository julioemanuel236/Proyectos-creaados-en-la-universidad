package aplicacion;
import java.util.LinkedList;

public class Lista {
	protected LinkedList<PO> oficial;
	protected LinkedList<PE> espera;
	
	public Lista() {
		oficial = new LinkedList<>();
		espera = new LinkedList<>();
	}
	
}

