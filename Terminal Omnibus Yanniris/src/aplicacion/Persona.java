package aplicacion;
import java.io.*;
public class Persona implements Serializable{
	private String carnet;
	
	public Persona(String carnet) {
		super();

		this.carnet = carnet;
	}

	
	public String getCarnet() {
		return carnet;
	}
	
	public String toString() {
		return carnet+' ';
	}
	
	public String datos() {
		return carnet;
	}
	
}
