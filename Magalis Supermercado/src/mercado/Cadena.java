package mercado;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Cadena {
	ArrayList<Almacen> almacenes = new ArrayList<>();
	ArrayList<Producto> productos = new ArrayList<>();
	
	public void addAlmacen(Almacen a) {
		almacenes.add(a);
	}
	
	public int productosNacionalesMayor(int x) {
		int c=0;
		for(int i=0;i<productos.size();i++) {
			if(productos.get(i).getClass()==Nacional.class) {
				if(productos.get(i).precioVenta()>=x)c++;
			}
		}
		return c;
	}
	
	public String productosPais(String pais) {
		String s="";
		
		for(int i=0;i<productos.size();i++) {
			if(productos.get(i).getClass()==Extranjero.class) {
				if(((Extranjero)productos.get(i)).getPais().equals(pais))
					s+=((Extranjero)productos.get(i)).informe();
			}
		}
		if(s.length()==0)s = pais + " no ha vendido productos a Cuba";
		return s;
	}
	
	public void generarDeficiencias() {
		String s="";
		for(Almacen i:almacenes)
			s+=i.hacerPeticion()+'\n';
		
		try {
			FileWriter fw = new FileWriter("Deficiencias.txt");
			fw.write(s);
			fw.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al guardar datos en fichero");
		}
	}
	
	public void vender(Almacen a,Producto p,int cantidad) {
		a.darAlta(p, cantidad);
	}
	
	public String masVendidos() {
		String s="";
		
		for(int i=0;i<almacenes.size();i++) {
			s+="ALMACEN "+(i+1)+':'+almacenes.get(i).masVendido()+'\n';
		}
		
		return s;
	}

	public String menosVendidos() {
		String s="";
		
		for(int i=0;i<almacenes.size();i++) {
			s+="ALMACEN "+(i+1)+almacenes.get(i).menosVendido()+'\n';
		}
		
		return s;
	}

	
	public Cadena() {
		
	}
	
}
