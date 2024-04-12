package Terminal;
import java.io.*;
public class Pasajero implements Serializable{
	private String carnet;
	
	public Pasajero(String carnet) {
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
