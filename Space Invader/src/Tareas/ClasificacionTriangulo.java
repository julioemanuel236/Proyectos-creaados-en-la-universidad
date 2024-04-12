package Tareas;
import java.util.Scanner;

public class ClasificacionTriangulo {

	public static void main(String[] args) {
		double l1,l2,l3;
		Scanner entry = new Scanner(System.in);
		
		System.out.print("Valor del lado 1: ");
		l1 = entry.nextDouble();
		System.out.print("Valor del lado 2: ");
		l2 = entry.nextDouble();
		System.out.print("Valor del lado 3: ");
		l3 = entry.nextDouble();
		
		if(l1+l2<l3 && l1+l2<l2 && l2+l3<l1)
			System.out.println("No se puede formar un triangulo con esos valores");
		else {
			if(l1 == l2 && l2 == l3)
				System.out.println("Triangulo Equilatero");
			else if(l1 == l2 || l1 == l3 || l2 == l3) 
				System.out.print("Triangulo Isoceles");
			else System.out.print("Triangulo Escaleno");
		}
	}
	
}
