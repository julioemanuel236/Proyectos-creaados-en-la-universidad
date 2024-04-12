package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

	public ArrayList<Punto> leeArchivoPuntos(String nomFich) throws FileNotFoundException{
		FileReader fr = new FileReader(nomFich);
		ArrayList<Punto> puntos = new ArrayList<>();
		Scanner entry = new Scanner(fr);
		int pSize = "Puntos".length();
		while(entry.hasNext()) {
			String line = entry.nextLine();
			if(line.substring(0,pSize).equals("Punto"))puntos.add(new Punto(Double.MAX_VALUE,Double.MAX_VALUE));
			try {
				int p1 = line.indexOf('(');
				int c = line.indexOf(',');
				int p2 = line.indexOf(')');
				double x = Double.parseDouble(line.substring(p1+1,c));
				double y = Double.parseDouble(line.substring(c+1,p2));
				puntos.add(new Punto(x,y));
			}
			catch(Exception e) {
				e.printStackTrace();
				puntos.add(new Punto(Double.MAX_VALUE,Double.MAX_VALUE));
			}
		}
		
		return puntos;
	}
	
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
	}
	
}
