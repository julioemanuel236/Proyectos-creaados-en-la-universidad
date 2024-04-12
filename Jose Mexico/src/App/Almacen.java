package App;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import javax.swing.JComboBox;

public class Almacen {
	
	Tablero tableros[] = new Tablero[50];
	
	Random rand = new Random();
	int ocupado = 0;	

	public Almacen() {
		try {
			FileInputStream fis = new FileInputStream("almacen.alm");
			ObjectInputStream ois = new ObjectInputStream(fis);
			tableros = (Tablero[])ois.readObject();
			ois.close();
			fis.close();
			for(int i=0;i<tableros.length;i++)
				if(tableros[i]!=null)ocupado++;
		}
		catch(Exception e) {
			System.out.println("OCURRIO UN ERROR AL CARGAR EL ALMACEN");
		}
	}
	
	private int locationOf(String s) {
		int z = Integer.parseInt(s.substring(1, 3));
		z--;
		z*=10;
		int p = Integer.parseInt(s.substring(4, 6))-1;
		System.out.println(z+" "+p);
		return z+p;
	}
	
	public void add(Tablero t,String p) {
		int pos = locationOf(p);
		for(int i=0;i<tableros.length;i++)
			if(tableros[i]!=null&&tableros[i].getCodigo().equals(t.getCodigo())) {
				pos=i;
				t.setLocation(p);
				Ventana.historial.update(t);
				guardar();
				return;				
			}
		tableros[pos]=t;
		t.setLocation(p);
		Ventana.historial.add(t);
		ocupado++;
		guardar();
	}

	public void enviarA(String codigo,String linea) {
		for(int i=0;i<tableros.length;i++) {			
			if(tableros[i]!=null && tableros[i].getCodigo().equals(codigo)) {
				tableros[i].enviarA(linea);
				Ventana.historial.update(tableros[i]);
				tableros[i]=null;
				ocupado--;
				guardar();
				return;
			}
		}
		System.out.println("No existe esa ID en el almacen");
	}
	
	public String getLocation(int n) {
		int p = (n%10)+1;
		int z = (n/10)+1;
		String r = (p<10?"-0"+p:"-10");
		return "A0"+(z)+r;
	}
	
	public void actualizarLoc(JComboBox<String> jcb) {
		jcb.removeAllItems();
		for(int i=0;i<tableros.length;i++) {
			if(tableros[i]==null)jcb.addItem(getLocation(i));
		}
	}
	
	public String disponibles() {
		int a=0,b=0,c=0;
		int t = tableros.length-ocupado;
		if(t==0)return "No hay";
		do {
			a = rand.nextInt(tableros.length);
		}
		while(tableros[a]!=null);
		if(t==1)return getLocation(a);
		
		do {
			b = rand.nextInt(tableros.length);
		}
		while(a==b||tableros[b]!=null);
		
		if(t==2)return getLocation(a)+"\n"+
				       getLocation(b);				   
		
		do{
			c = rand.nextInt(tableros.length);
		}
		while(c==a||c==b||tableros[c]!=null);
		
		return getLocation(a)+"\n"+
			   getLocation(b)+"\n"+
			   getLocation(c);
	}

	public void guardar() {
		try {
			FileOutputStream fis = new FileOutputStream("almacen.alm");
			ObjectOutputStream ois = new ObjectOutputStream(fis);
			ois.writeObject(tableros);
			ois.close();
			fis.close();
		}
		catch(Exception e) {
			System.out.println("OCURRIO UN ERROR AL GUARDAR EL ALMACEN");
		}
	}
	
}
