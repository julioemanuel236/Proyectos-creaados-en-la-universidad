package visor_gastos;
import java.awt.Color;
import java.awt.Image;
import data.Gasto;
import mainwindow.Component;

public class PanelVisorGastos extends Component{

	private static final long serialVersionUID = 1L;
	private Color fondo = Color.BLUE;
	public final int CANTIDADMAXIMAGASTOS = 1000;
	Gasto[] gastos = new Gasto[CANTIDADMAXIMAGASTOS];
	
	int topSuperior;
	int cantidadActual;
	
	public PanelVisorGastos(Image img) {
		super(img);
	}
	
	public boolean agregarDato(Gasto gasto) {
		if(cantidadActual<gastos.length) {
			gastos[cantidadActual++] = gasto;
			return true;
		}
		
		return false;		
	}
	
	public int agregarDato(Gasto[] gasto) {
		int cont = 0;
		
		for(int i=0;i<gasto.length && cantidadActual<gastos.length;i++,cont++) {
			gastos[cantidadActual++] = gasto[i];
			
		}
		
		return cont;
	}
	
}
