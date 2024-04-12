package arbolbusquedabinario;
import java.util.Scanner;

public class main {
	private static Scanner entry = new Scanner(System.in);
	private static Arbol arbol = new Arbol();
	
	public static void print(String txt) {
		System.out.print(txt);
	}
	
	public static void nuevaPelicula() {
		String nombre;
		String categoria;
		print("\tNUEVA PELICULA\n");
		print("Nombre: ");
		nombre = entry.nextLine();
		print("Categoria: ");
		categoria = entry.nextLine();	
		arbol.agregar(new Pelicula(nombre,categoria), 0);		
	}
		
	public static void buscarPelicula() {		
		String texto;
		print("\tBUSCAR PELICULA\n");
		print("Nombre: ");
		texto = entry.nextLine();
		String resultado = arbol.buscar(texto,0);
		System.out.println(resultado);
	}
	
	public static void main(String[] args) {
		

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
