package aplicacion;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JScrollPane;

public class Fabrica {
	
	static float plan;
	
	static Trabajador[] trabajadores = new Trabajador[1000];
	static int cTrabajadores=0;
	
	static ArrayList<Producto> productos = new ArrayList<Producto>();
	static int cProductos=0;
	
	static Material[] materiales = new Material[1000];
	static int cMateriales=0;
	
	public static void addTrabajador(Trabajador t){
		trabajadores[cTrabajadores++]=t;
		JOptionPane.showMessageDialog(null, "Trabajador a�adido con exito" );
	}
	
	public static void addProducto(Producto p){
		if(cProductos==10) {
			JOptionPane.showMessageDialog(null, "Se ha alcanzado el l�mite de productos" );
			return;
		}
		productos.add(p);
		cProductos++;
		JOptionPane.showMessageDialog(null, "Producto a�adido con exito" );
	}
	
	public static void addMaterial(Material m){
		materiales[cMateriales++]=m;
		JOptionPane.showMessageDialog(null, "Material a�adido con exito" );
	}	
	
	public static void mayorProduccion() {
		String s="";
		if(cProductos==0)s="No hay productos registrados";
		for(int i=0;i<cProductos;i++) {
			s+=productos.get(i).getNombre()+": ";
			int c=productos.get(0).getProduccion(0);
			for(int j=1;j<12;j++)
				c=Math.max(c,productos.get(i).getProduccion(j));
			s+=""+c+"\n";
		}
		JOptionPane.showMessageDialog(null, s);
	}
		
	private static void ordenarProductos() {
		Comparator<Producto> cmp = new Comparator<Producto>() {

			@Override
			public int compare(Producto o1, Producto o2) {
				if(o1.getValor()<o2.getValor())return 1;
				else if(o1.getValor()>o2.getValor())return -1;
				return 0;
			}
			
		};
		Collections.sort(productos,cmp);
	}
	
	public static void productosDatos(JTextArea txt) {
		ordenarProductos();
		for(int i=0;i<cProductos;i++) 
			txt.setText(txt.getText()+productos.get(i).informacion()+'\n');
		
	}
	
	public static void exportacionDatos(JTextArea txt) {
		for(int i=0;i<cProductos;i++) 
			if(productos.get(i).exportacion())txt.setText(txt.getText()+productos.get(i).informacion()+'\n');
		
	}	
	
	public static void trabajadoresDatos(JTextArea txt) {
		for(int i=0;i<cTrabajadores;i++)
			if(trabajadores[i] instanceof TrabajadorCientifico)txt.setText(txt.getText()+trabajadores[i].informacion()+'\n');
	}
	
	public static void porcentajePlan() {
		float f=0;
		if(plan==0f) {
			JOptionPane.showMessageDialog(null, "No se ha introduccido un plan");
			return;
		}
		for(int i=0;i<cProductos;i++)
			f+=productos.get(i).getValor();
		JOptionPane.showMessageDialog(null, ""+f+"/"+plan+":"+" "+((f*100)/plan)+"%");
	}
	
	public static void plan() {
		try{
			plan = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el plan monteraio que se desea alcanzar"));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Valor invalido");
		}
	}

	public static void mesMayorProduccion() {
		String arr[] = {"ENE","FEB","MAR","ABR","MAY","JUN","JUL","AGO","SEP","OCT","NOV","DIC"};
		int mes=0;
		int pro=0;
		float aporte=0;
		for(int i=0;i<12;i++) {
			int p=0;
			float ap=0;
			for(int j=0;j<cProductos;j++) {
				p+=productos.get(j).getProduccion(i);
				ap+=productos.get(j).getValor(i);
			}
			if(p>pro) {
				pro=p;
				mes=i;
				aporte = ap;
			}
		}
		JOptionPane.showMessageDialog(null, "El mes de mayor producci�n fue "+arr[mes]+"\n"
				+ "con una produccion de "+pro+" productos y aportando "+aporte);
	}

	public static void guardarTrabajadores() {
		try {
			FileWriter fw = new FileWriter("Trabajadores.txt");
			String s="";
			for(int i=0;i<Fabrica.cTrabajadores;i++)
				s+=Fabrica.trabajadores[i].informacion()+'\n';
			fw.write(s);
			fw.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error, no se pudo guardar la informaci�n de los trabajadores en un fichero");
		}
	}

	public static void guardarProductos() {
		try {
			FileWriter fw = new FileWriter("Productos.txt");
			String s="";
			for(int i=0;i<Fabrica.cProductos;i++)
				s+=Fabrica.productos.get(i).fichero()+'\n';
			fw.write(s);
			fw.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error, no se pudo guardar la informaci�n de los productos en un fichero");
		}
	}
	
	public static void cargarProductos() {
		try {
		FileReader  fr = new FileReader("Productos.txt");
		Scanner cin = new Scanner(fr);
		String txt="";
		String next;
		while(cin.hasNext()) {
			String nombre = "";
			do {
				next=cin.next();
				if(!next.equals("@"))nombre+=next+" ";
			}while(!next.equals("@"));
			float valor = Float.parseFloat(cin.next());
			String fecha = cin.next();
			String mercado= cin.next();
			String envase = "";
			do {
				next=cin.next();
				if(!next.equals("@"))envase+=next+" ";
			}while(!next.equals("@"));
			String clas = cin.next();
			String proveedor=cin.next();
			float precio = Float.parseFloat(cin.next());
		
			int tiempo=0;
			if(!clas.equals("Nacional"))tiempo = Integer.parseInt(cin.next());
			txt+="Nombre Producto: "+nombre+'\n'+
				 "Valor de venta: "+valor+'\n'+
				 "Fecha de vencimiento: "+fecha+'\n'+
				 "Mercado destino: "+mercado+'\n'+
				 "Tipo de envase: "+envase+'\n'+
				 "Proveedor: "+proveedor+'\n'+
				 "Precio del envase: "+precio+'\n'+
				 "Origen del matarial: "+clas+'\n'+
				 (!clas.equals("Nacional")?"Tiempo de viaje: "+tiempo+"\n":"")+
				 "-------------------------------------------------------------------------\n";
				 
		}
			JDialog panel = new JDialog();
			JTextArea see = new JTextArea(txt);
			see.setSize(1000,1000);
			JScrollPane view = new JScrollPane(see);
			panel.add(view);
			panel.setSize(300,500);
			panel.setLocationRelativeTo(null);
			panel.setVisible(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error, no se pudo cargar la informaci�n de los productos del fichero");
		}
	}
	
	public static void datosNombre() {
		String s = JOptionPane.showInputDialog("Nombre del Producto: ");
		for(int i=0;i<cProductos;i++)
			if(productos.get(i).getNombre().equals(s)) {
				JOptionPane.showMessageDialog(null, productos.get(i).informacion());
				return;
			}
		JOptionPane.showMessageDialog(null, "No se encontr� producto con ese nombre");
	}
}
