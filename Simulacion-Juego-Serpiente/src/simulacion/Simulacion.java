package simulacion;
import java.io.FileWriter;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

import elementos.Matriz;
import elementos.serpiente.*;
public class Simulacion extends ReentrantLock{

	public static CyclicBarrier BARRIERSNAKES;
	public static CyclicBarrier BARRIER;
	public static int muertes = 0;
	private int serpientes;
	public String registro = "";
	
	public Simulacion(int hilos) {
		this.serpientes = hilos;
		BARRIERSNAKES = new CyclicBarrier(hilos);
		BARRIER = new CyclicBarrier(hilos+1);
	}
	
	public void actualizarSerpiente(Serpiente s) {				
		lock();
		//System.out.println("MOVIENDO "+s.getSerpienteId());
		s.move();				
		//System.out.println("TERMINO DE MOVERSE "+s.getSerpienteId());		
		unlock();
	}
	
	public void iniciar(Matriz tablero,Serpiente[] serpientes) {

		tablero.mostrar();
		
		for(int i=0 ; i<serpientes.length; i++)
			serpientes[i].start();
		
		while(muertes<this.serpientes) {						
			try {				
				//System.out.println("ESPERANDO A QUE LAS SERPIENTES ACABEN");
				//System.out.println("BARRERA");
				Thread.sleep(300);
				BARRIER.await();
				//System.out.println("YA ACABARON");
				//System.out.println(muertes);
				tablero.mostrar();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
			tablero.mostrar();
			try {
				FileWriter fw = new FileWriter("log.txt");
				fw.write(registro);
				fw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.exit(0);
	}
	
	public void nuevaBaja() {
		muertes++;
	}
}