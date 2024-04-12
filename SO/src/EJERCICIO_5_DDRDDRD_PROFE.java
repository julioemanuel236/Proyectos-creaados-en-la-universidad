
public class EJERCICIO_5_DDRDDRD_PROFE {
	
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

	static Semaforo D = new Semaforo(2);
	static Semaforo R = new Semaforo(0); 
	
	
	static void P1(){
		while(true){
			//System.out.print("ITERACION "+cont+++": ");
			
			for (int i = 1 ; i <= 5 ; i++){
				D.P();
				System.out.print('d');
				if(i == 2 || i == 4){					
					R.V();					
				}
				
			}
			D.V(2);			
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
						
			
			while(counter !=0){			
				R.P();
				System.out.print('r');
				counter--;
				if(counter==1){
					counter++;
					D.V(2);					
						
				}	
			}
			D.V();
		}
	}
}
