package visual;
import java.util.LinkedList;

import pieza.Pieza;

import java.awt.Color;
import java.awt.Component;

public final class GestorMovimiento {
	
	private static LinkedList<Movimiento> lista = new LinkedList<>();
	private static LinkedList<Movimiento> nuevos = new LinkedList<>();
	private static boolean ejecutando = false;
	public static final int frameRate= 144;
	private static boolean ejecutarse = false;
	
	private static Thread ejecucion = (new Thread(){
		
		public void run() {
			ejecutando = true;
			ejecutarse = false;
			System.err.println(Thread.currentThread().getName());
			int waitTime= 1000/frameRate;
			
			
			while(true) {
				if(lista.isEmpty())
					ejecutarse = false;
				if(ejecutarse)
					actualizar();
				try {
					sleep(waitTime);
					//System.out.println("Ya espere el waitTime");
					//System.out.println("VALORES: "+ejecutando+ " " + ejecutarse);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				//System.out.println(lista.size());
			}			
			
			//System.err.println("HILO DE Movimiento TERMINADO");
		}
	
	});
	
	public static void agregarMovimiento(Component c,int x,int y,long tiempo) {
		nuevos.addLast( new Movimiento(c,x,y,tiempo) );		
		
	}
		
	public static void actualizar() {
		
		int n = lista.size();
		//System.out.println(n);
		long time = System.currentTimeMillis();
		for(int i=0;i<n;i++) {			
			Movimiento p = lista.pollFirst();
			if(p!=null) {
				p.actualizar(time);
				if(!ejecutarse)return;
				if(!p.yaTermino())lista.add(p);	
			}
				
			//System.out.println("ACTUALIZANDO");
			
		}
		

		
	}
	
	public static void run() {		
		if(!ejecucion.isAlive())
			ejecucion.start();
		
		while(!nuevos.isEmpty()) {
			//System.out.println("AGREGANDO");			
			Movimiento p = nuevos.pollFirst();
			if(p != null)
				lista.addLast(p);
		}
		
		ejecutarse = true;
		
	}
	
	public static void stop() {
		//System.out.println("MANDANDO A PARAR");
		ejecutarse = false;
	}
	
	public static void reset() {
		stop();
		lista.clear();		
		nuevos.clear();
				
	}

	public static boolean isEjecutando() {
		return ejecutando;
	}
	
	public static boolean isEjecutarse() {
		return ejecutarse;
	}	
}