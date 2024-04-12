package algoritmos;

public class Proceso {
	private int id;
	private int inicio;
	private int tiempo;
	private int prioridad;
	public Proceso(int id, int tiempo, int inicio,int prioridad) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.tiempo = tiempo;
		this.prioridad=prioridad;
	}

	public int getId() {
		return id;
	}

	public int getInicio() {
		return inicio;
	}

	public int getTiempo() {
		return tiempo;
	}
	
	public int getPriority() {
		return this.prioridad;
	}
	
	public void procces() {
//		System.out.println("PROCESANDO: "+getId());
		tiempo--;
	}
	
	public boolean isTerminated() {
		return tiempo==0;
	}
	

}
