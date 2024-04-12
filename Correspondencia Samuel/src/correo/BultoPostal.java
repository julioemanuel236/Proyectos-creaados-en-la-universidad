package correo;

public class BultoPostal extends Correspondencia{
	private float peso;
	private int urgencia;
	
	public BultoPostal(String nombre, String direccion, String remitente, float peso, int urgencia) {
		super(nombre, direccion, remitente);
		this.peso = peso;
		this.urgencia = urgencia;
	}

	public float getPeso() {
		return peso;
	}

	public int getUrgencia() {
		return urgencia;
	}

	public float precio() {
		return peso*4 + (urgencia==0?10:(urgencia==1?8:0));
	}
	
}
