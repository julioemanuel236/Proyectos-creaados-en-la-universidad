package simulacion;

import elementos.Matriz;
import elementos.serpiente.*;
import java.util.Random;
public class Main {
	
	public static void main(String[] args) {
		int size = 10,cantidadSerpientes = 10,serpientesSize = 5,pasos = 10;
		
		try {
			if(args.length < 4)
				throw new Exception("No se suministraron suficientes entradas");
			size = 				Integer.parseInt(args[0]);
			cantidadSerpientes = 		Integer.parseInt(args[1]);
			serpientesSize = 	Integer.parseInt(args[2]);
			pasos = 			Integer.parseInt(args[3]);
			
			if(cantidadSerpientes>size || serpientesSize>size)
				throw new Exception("Imposible colocar esas serpientes en esa matriz");
			
			if(size<1||cantidadSerpientes<1||serpientesSize<1||pasos<0)
				throw new Exception("No se admiten valores negativos");
		}
		catch(Exception e) {
			System.out.println("ERROR EN LOS DATOS DE ENTADA\n");
			System.out.println("MENSAGE DE ERROR: "+e.getMessage());
			return; 
		}
		Simulacion simulacion = new Simulacion(cantidadSerpientes);
		
		Matriz tablero = new Matriz(size,size);
		Serpiente[] serpientes = new Serpiente[cantidadSerpientes];
		Random rand = new Random();
		int y = size-serpientesSize;
		for(int i=0 ; i<cantidadSerpientes; i++) {
			int x = rand.nextInt(size);
			while((tablero.get(x, y) != -1)) {
				x = rand.nextInt(size);
			}
			serpientes[i] = new Serpiente(x,y,i,serpientesSize,pasos,tablero,simulacion);
		}
			
		simulacion.iniciar(tablero,serpientes);
	}
	
}
