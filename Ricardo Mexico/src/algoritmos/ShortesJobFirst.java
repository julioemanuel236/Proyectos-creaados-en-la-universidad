package algoritmos;

import java.util.Comparator;
import java.util.PriorityQueue;
public class ShortesJobFirst extends AlgoritmoPlanificacion{

	PriorityQueue<Proceso> procesos;
	
	private Proceso inProcces;
	
	public ShortesJobFirst() {
		procesos = new PriorityQueue<Proceso>(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Proceso p1 = (Proceso) o1;
				Proceso p2 = (Proceso) o2;
				if(p1.getTiempo()<p2.getTiempo())return -1;
				else if(p1.getTiempo()>p2.getTiempo())return 1;
				else if(p1.getId()<p2.getId())return -1;
				else if(p1.getId()>p2.getId())return 1;
				return 0;
			}
			
		});
		inProcces=null;		
	}
	
	public void add(Proceso pr) {
		procesos.add(pr);
	}
	
	public Proceso procces() {
		if(inProcces == null || inProcces.isTerminated()) {// si no hay proceso o ya se terino
			if(procesos.isEmpty())return null;//si no hay mas procesos salir
			inProcces = procesos.poll(); //quitarlo de la lista para pasar al siguiente						
		}
		inProcces.procces();//restar tiempo de ejecucion
		return inProcces;
	}
	
	/*
	public static void main(String args[]) {
		ShortesJobFirst sjf = new ShortesJobFirst();
		System.out.println();
		sjf.add(new Proceso(1,1,1,0));
		sjf.add(new Proceso(2,2,2,0));
		sjf.add(new Proceso(3,2,4,0));
		sjf.add(new Proceso(4,2,3,0));
		Proceso pr;
		int t=0;
		do {
			pr = sjf.procces();
			if(pr==null)break;
			System.err.println(t+" "+pr.getId());
			t++;
		}while(pr!=null);
	}
	*/
	
}
