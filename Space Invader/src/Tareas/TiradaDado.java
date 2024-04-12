package Tareas;

import java.util.Scanner;

public class TiradaDado {

	public static void main(String[] args) {
		Scanner entry = new Scanner(System.in);
		
		System.out.println("Valor del dado");
		int n = entry.nextInt();
		if(n<1 || n>6)
			System.out.println("ERROR: numero incorrecto");
		else {
			String numero = "";
			
			switch(n) {
				case 1:numero = "Seis"; 	break;
				case 2:numero = "Cinco";	break;
				case 3:numero = "Cuatro";	break;
				case 4:numero = "Tres";		break;
				case 5:numero = "Dos";		break;
				case 6:numero = "Uno";		break;
			}
			
			System.out.println(numero);
		}
	}
	
}
