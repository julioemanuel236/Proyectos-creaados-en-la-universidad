package correo;

import javax.swing.JOptionPane;

public class Carta extends Correspondencia{
	private String fechaEnvio;
	private boolean exterior;
	public Carta(String nombre, String direccion, String remitente, String fechaEnvio, boolean exterior) {
		super(nombre, direccion, remitente);
		this.fechaEnvio = fechaEnvio;
		this.exterior = exterior;
	}
	public String getFechaEnvio() {
		return fechaEnvio;
	}
	public boolean isExterior() {
		return exterior;
	}
	
	public float precio() {
		int dias=0;
		try {
			dias = Integer.parseInt(JOptionPane.showInputDialog("Cuantos dias lleva de enviada la carta "+datos()));
		}
		catch(Exception e) {
			return 0;
		}
		return (dias>10?5+(exterior?5:0):8+(exterior?3:0));
	}
	
}
