package ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Nombre del archivo");
		Scanner entry = new Scanner(System.in);
		String nomFich = entry.next();
		Ejercicio2 ej2 = new Ejercicio2();
		try {
			ArrayList<Punto> puntos = ej2.leeArchivoPuntos(nomFich);
			for(Punto p:puntos) {
				System.out.println(p.getX()+" "+p.getY());
			}
		}
		catch(Exception e) {
			System.out.println("no se encuentra el fichero");
		}
		entry.close();
	}
}
