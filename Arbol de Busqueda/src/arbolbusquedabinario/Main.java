package arbolbusquedabinario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;

public class Main {
	private static Scanner entry = new Scanner(System.in);
	private static Arbol arbol = new Arbol();
	
	public static void print(String txt) {
		System.out.print(txt);
	}
	
	public static void nuevaPelicula() {
		String nombre;
		String categoria;
		int dia,mes,year,hora,minutos;
		String pm;
		Date fecha;
		print("\tNUEVA PELICULA\n");
		print("Nombre: ");
		nombre = entry.nextLine();
		print("Categoria: ");
		categoria = entry.nextLine();	
		print("\tFECHA\n");
		try {
			print("DIA: ");
			dia = Integer.parseInt(entry.nextLine());
			print("MES: ");
			mes = Integer.parseInt(entry.nextLine());
			print("ANNO: ");
			year = Integer.parseInt(entry.nextLine());
			fecha = new Date(year,mes,dia);						
			print("HORA: ");
			hora = Integer.parseInt(entry.nextLine());
			print("MINUTOS: ");
			minutos = Integer.parseInt(entry.nextLine());
			print("AM/PM: ");
			pm = entry.nextLine();			
			hora*=60*60*1000;
			hora+=(minutos*60*1000);
			if(pm.equalsIgnoreCase(pm))hora+=(12*60*60*1000);
			fecha = new Date(fecha.getTime()+hora);
			arbol.agregar(new Pelicula(nombre,categoria,fecha), 0);			
			guardar();
		}
		catch(Exception e) {
			e.printStackTrace();
			print("Formato de fecha incorrecto\n");
		}
		
	}
		
	private static void guardar() {
		try {
			FileOutputStream fos = new FileOutputStream("Peliculas.dat");
			ObjectOutputStream ous = new ObjectOutputStream(fos);
			ous.writeObject(arbol);
			ous.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public static void buscarPelicula() {		
		String texto;
		print("\tBUSCAR PELICULA\n");
		print("Nombre: ");
		texto = entry.nextLine();
		String resultado = arbol.buscar(texto,0);
		System.out.println(resultado);
	}
	
	private static void cargar() {
		try {
			FileInputStream fis = new FileInputStream("Peliculas.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			arbol = (Arbol)ois.readObject();
			ois.close();
		} catch (Exception e) {

		}		
	}
	
	public static void main(String[] args) {
		cargar();
		while(true) {
			print("1-Agregar Pelicula\n");
			print("2-Buscar Pelicula\n");
			print("3-Salir\n");
			int op = Integer.parseInt(entry.nextLine());
			switch(op) {
				case 1:nuevaPelicula(); break;
				case 2:buscarPelicula(); break;
				case 3:return;
			}
		}
	}
}
