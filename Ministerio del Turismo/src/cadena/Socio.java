package cadena;

import java.io.Serializable;

public class Socio extends Object implements Serializable{
	String pais;
	float porcentajeGanancias;
	
	public Socio(String pais, float porcentajeGanancias) {
		this.pais = pais;
		this.porcentajeGanancias = porcentajeGanancias;
	}
	
	public String getPais() {
		return pais;
	}
	public float getPorcentajeGanancias() {
		return porcentajeGanancias;
	}
	
}
