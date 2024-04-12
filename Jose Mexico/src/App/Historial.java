package App;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

public class Historial {
	TreeMap<String,Tablero> tableros = new TreeMap<>();
	
	public Historial() {
		try {
			FileInputStream fis = new FileInputStream("historial.alm");
			ObjectInputStream ois = new ObjectInputStream(fis);
			tableros = (TreeMap<String,Tablero>)ois.readObject();
			ois.close();
			fis.close();	
		}
		catch(Exception e) {
			System.out.println("OCURRIO UN ERROR AL CARGAR EL HISTORIAL");
		}
	}
	
	public void add(Tablero t) {
		tableros.put(t.getCodigo(), t);
		guardar();
	}
	
	public void update(Tablero t) {
		tableros.put(t.getCodigo(), t);
		System.out.println("Actualizado Tablero:\n"+t);
		guardar();
	}
	
	public void guardar() {
		try {
			FileOutputStream fis = new FileOutputStream("historial.alm");
			ObjectOutputStream ois = new ObjectOutputStream(fis);
			ois.writeObject(tableros);
			ois.close();
			fis.close();
		}
		catch(Exception e) {
			System.out.println("OCURRIO UN ERROR AL GUARDAR EL HISTORIAL");
		}
	}
	
}
