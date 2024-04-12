package correo;

public class BultoPostal extends Correspondencia{
	private  float peso;
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
	
	public String Urgencia() {
		if(urgencia==0)return "Urgente";
		else if(urgencia==1)return "Medio Urgente";
		else return "Indiferente";
	}

	public float precio() {
                int plus = 0;
                if(urgencia==0)plus=10;
                if(urgencia==1)plus=8;
                
		return peso*4 + plus;
	}
	
}
