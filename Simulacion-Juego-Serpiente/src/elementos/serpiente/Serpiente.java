package elementos.serpiente;

import elementos.Matriz;
import simulacion.Simulacion;

public class Serpiente extends Thread{

	private Cuerpo cabeza;
	private Cuerpo cola;
	private Matriz tablero;
	private int dir;
	private int pasos;
	private Simulacion simulacion;
	private final int ARRIBA = 8;
	private final int ABAJO = 2;
	private final int IZQUIERDA = 4;
	private final int DERECHA = 6;
	
	
	private final int[][] dondeIr = {{ARRIBA,IZQUIERDA,DERECHA},
									 {ABAJO,IZQUIERDA,DERECHA},
									 {ARRIBA,ABAJO,IZQUIERDA},
									 {ARRIBA,ABAJO,DERECHA}};
	
	public Serpiente(int x,int y,int id,int size,int pasos,Matriz tablero,Simulacion simulacion) {
		this.tablero = tablero;
		this.cabeza = new Cuerpo(x,y,id,tablero);
		this.cola = this.cabeza;
		this.dir = this.ARRIBA;
		this.pasos = pasos;
		this.simulacion = simulacion;
		for(int i = 1 ; i < size ; i++)
			agregarCuerpo();
	}
	
	public int getX() {
		return cabeza.getX();
	}
	
	public int getY() {
		return cabeza.getY();
	}
	
	public int getSerpienteId() {
		return cabeza.getId();
	}
	
	public void move() {		
		
		seleccionarNuevaDireccion();
		int x = cabeza.getX();
		int y = cabeza.getY();
		
		switch(dir) {
			case ARRIBA:y--;break;
			case ABAJO:y++;break;
			case IZQUIERDA:x--;break;
			case DERECHA:x++;break;
		}
		
		//System.out.println("MOVING "+getSerpienteId()+"to dir: "+dir);
		simulacion.registro += "Snake "+getSerpienteId()+ " moved from: ("+(cabeza.getX()+1)+","+(cabeza.getY()+1)+")";
		cabeza.moveTo(x, y);
		simulacion.registro +=" to ("+(x+1)+","+(y+1)+") at "+System.currentTimeMillis() + "\n";
		pasos--;
		if(pasos == 0)cabeza.morir();
		if(cabeza.isMuerta())simulacion.registro +="Snake "+getSerpienteId()+" died at: ("+(x+1)+","+(y+1)+") at "+System.currentTimeMillis() + "\n";
	}
	
	private void seleccionarNuevaDireccion() {
		int pos = 0;
		//System.out.println(getSerpienteId()+" mirando a "+dir);
		switch(dir) {
			case ARRIBA:pos = 0;break;
			case ABAJO:pos = 1;break;
			case IZQUIERDA:pos = 2;break;
			case DERECHA:pos = 3;break;
		}
		
		dir = dondeIr[pos][(int)System.currentTimeMillis()%3];
		//System.out.println(getSerpienteId()+" nuevo mirando a "+dir);
	}
	
	private void agregarCuerpo() {
		
		int x = cola.getX();
		int y = cola.getY();
		int id = cola.getId();
		
		Cuerpo nuevo = new Cuerpo(x,y+1,id,tablero,cola);
		cola.setSiguiente(nuevo);
		cola = nuevo;
		
	}

	public void run() {		
		while(true) {			 
			try {
				if(!isMuerta())
					simulacion.actualizarSerpiente(this);					
				
				Simulacion.BARRIER.await();
			}
			catch(Exception e) {
				e.printStackTrace();
			}				

		}
		
	}
	public boolean isMuerta() {
		return cabeza.isMuerta();
	}
	
}