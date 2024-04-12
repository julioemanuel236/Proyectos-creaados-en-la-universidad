package correo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class Correo {
	ArrayList<Correspondencia> correo;
	
	Correo(){
		if(!cargar())correo = new ArrayList<>();
	}
	
	public void nuevaCorrespondencia(Correspondencia c) {
		correo.add(c);
		guardar();
	}
	
	public String despachar(){
		String s = "No hay correspondencia";
		for(Correspondencia i:correo) {
			if(i==null)continue;
			if(i instanceof Telegrama) {
				s ="Se despacho el Telegrama "+i.datos()+" a un precio de "+i.precio();
				correo.remove(i);
				guardar();
				return s;
			}
		}
		
		for(Correspondencia i:correo) {
			if(i instanceof Carta) {	
				s = "Se despacho la carta "+i.datos()+" a un precio de "+i.precio();
				correo.remove(i);
				guardar();
				return s;
			}
		}
		
		for(Correspondencia i:correo) {
			if(i instanceof BultoPostal) {
				correo.remove(i);
				s = "Se despacho el bulto postal "+i.datos()+" a un precio de "+i.precio();
				correo.remove(i);
				guardar();
				return s;
			}
		}
		return s;				
	}
	
	public String entregaPersonal(String nombre,String direccion) {
		String s = "";
		try {
		for(Correspondencia i:correo) {
			if(i==null)continue;
			if(i.getNombre().equals(nombre)&&i.getDireccion().equals(direccion)) {
				String op;
				if(i instanceof Carta)op="Carta";
				else if(i instanceof Telegrama)op="Telegrama";
				else op="Bulto Postal";
				
				s+="Se entrego "+op+" "+i.datos()+" con un precio de"+i.precio()+'\n';
				correo.remove(i);
			}
		}
		}
		catch(Exception e) {
			
		}
		if(s.equals(""))s="No se encontraron coincidencias";
		else guardar();
		return s;
	}
	
	public float calculoAcumulado() {
		float f=0;
		for(Correspondencia i:correo)
			f+=i.precio();
		return f;
	}
	
	public boolean guardar() {
		try {
			FileOutputStream fos = new FileOutputStream("datos_correspondencia.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(correo);
			
			oos.close();
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean cargar() {
		try {
			FileInputStream fis = new FileInputStream("datos_correspondencia.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			correo = (ArrayList<Correspondencia>) ois.readObject();
			
			ois.close();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
