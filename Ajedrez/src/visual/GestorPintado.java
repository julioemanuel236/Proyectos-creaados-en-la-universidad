package visual;

import java.awt.Color;
import java.awt.Component;
import java.util.LinkedList;

import pieza.Pieza;

public class GestorPintado {

	private static LinkedList<Pintado> lista = new LinkedList<>();
	private static LinkedList<Pintado> nuevos = new LinkedList<>();
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
			
			//System.err.println("HILO DE PINTADO TERMINADO");
		}
	
	});
	
	public static void agregarPintado(Component c,Component sobre, int x,int y,int width,int height,Color color,long tiempo) {
		nuevos.addLast( new Pintado(c,sobre,x,y,width,height,color,tiempo) );		
		
	}
	
	public static void agregarPreview(Component c,Pieza sobre, int x,int y,int width,int height,Color color,long tiempo) {
		nuevos.addLast( new PreSeleccion(c,sobre,x,y,width,height,color,tiempo) );		
		
	}
	
	public static void actualizar() {
		
		int n = lista.size();
		//System.out.println(n);
		long time = System.currentTimeMillis();
		for(int i=0;i<n;i++) {			
			Pintado p = lista.pollFirst();
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
			Pintado p = nuevos.pollFirst();
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
