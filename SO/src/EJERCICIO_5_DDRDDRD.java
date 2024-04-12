
public class EJERCICIO_5_DDRDDRD {
	
	public static void main(String args[]) {
		(new Thread() {
			public void run() {
				P1();
			}
		}).start();
		(new Thread() {
			public void run() {
				P2();
			}
		}).start();
	}

	static Semaforo p1 = new Semaforo(0);
	static Semaforo p2 = new Semaforo(0); 
	static int cont = 0;
	
	static void P1(){
		while(true){
			//System.out.print("ITERACION "+cont+++": ");
			
			for (int i = 1 ; i <= 5 ; i++){
				
				System.out.print('d');
				if(i == 2 || i == 4){					
					p1.V();
					p2.P();					
				}
				
			}
			System.out.println();
			try {
				Thread.sleep(100);
			}
			catch(Exception e) {
				
			}
		}
	}

	static void P2(){
		while(true){
			int counter = 2;
			
			p1.P();
			
			while(counter !=0){				
				System.out.print('r');
				counter--;
				if(counter==1){
					counter++;
					p2.V();
					p1.P();	
				}	
			}
		}
	}
}
