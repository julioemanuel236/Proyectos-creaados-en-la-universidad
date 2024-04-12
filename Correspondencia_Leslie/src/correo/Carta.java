package correo;

import javax.swing.JOptionPane;

public class Carta extends Correspondencia{
	private String fechaEnvio;
	private boolean exterior;
    private int dias = -1;    
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
		try {
			if(dias==-1)
			dias = Integer.parseInt(JOptionPane.showInputDialog("Cuantos dias lleva de enviada la carta "+datos()));
		}
		catch(Exception e) {
			return 0;
		}
                
                if(dias>10){
                    if(exterior) return 10;
                    else return 5;
                }
                else{
                    if(exterior) return 11;
                    else return 8;
                }
	}
	
}
