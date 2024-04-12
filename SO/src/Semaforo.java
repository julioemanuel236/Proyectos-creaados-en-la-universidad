
public class Semaforo {
	private int n;
	private boolean changing = false;
	
	public Semaforo(int n) {
		this.n = n;
	}
	
	public void V() {
		while(changing) {
			try {
				Thread.sleep(1);
			}
			catch(Exception e) {
				
			}
		}
		changing = true;
		n++;
		changing = false;
		
	}
	
	
	public void V(int k) {
		while(changing) {
			try {
				Thread.sleep(1);
			}
			catch(Exception e) {
				
			}
		}
		changing = true;
		n+=k;
		changing = false;
		
	}
	public void P() {
		while(n ==  0 || changing) {
			try {
				Thread.sleep(1);
			}
			catch(Exception e) {
				
			}
		}
		changing = true;
		n--;
		changing = false;
	}
}
