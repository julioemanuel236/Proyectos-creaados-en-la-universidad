
public class PREGUNTA_ESCRITA_1 {
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

	static Semaforo p1 = new Semaforo(1);
	static Semaforo p2 = new Semaforo(0); 
	static int cont = 0;
	
	static void P1(){
		while(true){
			//System.out.print("ITERACION "+cont+++": ");
			
			for (int i = 0 ; i < 2 ; i++){
				p1.P();
				for(int j=0;j<3;j++) {
					System.out.print('D');
				}
				if(i == 0) 
					p2.V();
			}
				
			System.out.print('P');
			p1.V();
			
			System.out.println();
			/*try {
				Thread.sleep(100);
			}
			catch(Exception e) {
				
			}*/
		}
	}

	static void P2(){
		while(true){
			p2.P();
			for(int i=0;i<3;i++) {
				System.out.print('R');
			}
			p1.V();
		}
	}
}