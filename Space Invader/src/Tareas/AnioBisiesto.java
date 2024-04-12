package Tareas;
import java.util.Scanner;

public class AnioBisiesto {

	public static void main(String[] args) {
		Scanner entry = new Scanner(System.in);
		System.out.print("Introduzca un anno: ");
		int year = entry.nextInt();
		if(year%4 == 0 && year%100 !=0)
			System.out.println("Es Bisiesto");
		else System.out.println("No es Bisiesto");
	}
}
