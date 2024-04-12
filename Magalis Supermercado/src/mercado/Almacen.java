package mercado;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Almacen {
	protected ArrayList<Producto>  productos = new ArrayList<>();
	protected ArrayList<Venta>  ventas = new ArrayList<>();

	public Almacen(){
		
	}
	
	public void addProducto(Producto p) {
		productos.add(p);
	}
	
	private void venta(Producto p,int cantidad) {
		String s="";
		for(int i=0;i<ventas.size();i++) {
			if(ventas.get(i).producto==p) {
				ventas.get(i).cantidad+=cantidad;
				return;
			}
		}
		ventas.add(new Venta(p,cantidad));
	}
	
	public void darAlta(Producto p,int cantidad) {
		if(cantidad>p.getCantidad()) {
			JOptionPane.showMessageDialog(null, "No se dispone de esa cantidad");
		}
		else {
			venta(p,cantidad);
			p.setCantidad(p.getCantidad()-cantidad);
		}
	}
	
	public String getNacionales() {
		String s="";
		
		for(Producto i:productos) {
			if(i.getClass()==Nacional.class) {
				s+=((Nacional)i).datos();
			}
		}
		return s;
	}
	
	public String listaExtranejeros() {
		String s="";
		
		for(Producto i:productos) {
			if(i.getClass()==Extranjero.class) {
				s+=((Extranjero)i).datos();
			}
		}
		
		return s;
	}
	
	public String getExtranjeros() {
		String s="";
		
		for(Producto i:productos) {
			if(i.getClass()==Extranjero.class) {
				s+=((Extranjero)i).informe();
			}
		}
		return s;
	}

	public String masVendido() {
		int mayor=-1;
		String s="No hay ventas en este almacen";
		
		for(int i=0;i<ventas.size();i++) {
			if(ventas.get(i).cantidad>mayor) {
				s=ventas.get(i).datos()+'\n';
				mayor=ventas.get(i).cantidad;
			}
			else if(ventas.get(i).cantidad==mayor)s+=ventas.get(i).datos();
		}
		
		return s;
	}

	public String menosVendido() {
		int menor=999999;
		String s="No hay ventas en este almacen";
		
		for(int i=0;i<ventas.size();i++) {
			if(ventas.get(i).cantidad<menor) {
				s=ventas.get(i).datos()+'\n';
				menor=ventas.get(i).cantidad;
			}
			else if(ventas.get(i).cantidad==menor)s+=ventas.get(i).datos();
		}
		
		return s;
	}
	

	public String hacerPeticion() {
		String s="";
		
		for(int i=0;i<productos.size();i++) {
			if(productos.get(i).necesita())s+=productos.get(i).getNombre()+'\n';
		}
		
		return s;
	}
}
