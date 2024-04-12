package algoritmos;

import java.util.LinkedList;

public class RoundRobin extends AlgoritmoPlanificacion{
	LinkedList<Proceso> procesos;
	
	private int Q;
	private int currentTime;
	
	
	public RoundRobin(int Q) {
		this.Q=Q;
		procesos = new LinkedList<Proceso>();		
		currentTime=0;
	}
	
	public void add(Proceso pr) {
//		System.out.println("A MI LLEGO"+pr);
		procesos.addLast(pr);
		//agregar el proceso a la cola de procesamiento
//		System.out.println("MI LISTA TIENE "+procesos.size());
	}
	
	public Proceso procces() {
		if(procesos.isEmpty()) {
			//si no hay mas procesos retornaar null
//			System.out.println("ESTOY VACIO");
			return null;
		}
		Proceso pr = procesos.peek();// tomar el proceso siguiente
		pr.procces();//restar uno a su tiempo de duracion
		currentTime++;//aumentar el tiempo que lleva en ejecucion
		if(pr.isTerminated()) {//si ya termino
			procesos.poll();//quitarlo de la lista
			currentTime=0;//volver el tiempo a 0
			return pr;
		}
		if(currentTime==Q) {//si el tiempo llego al limite
			procesos.poll();//quitarlo de la lista
			procesos.addLast(pr);//ponerlo al final
			currentTime=0;//volver el tiempo a 0
			return pr;
		}
		
		return pr;
				
	}	
	
}
