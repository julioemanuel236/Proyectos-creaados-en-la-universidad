package ejercicio1;



public class Main {
	
	public static class Reloj implements ClienteTemporizador,Temporizador{

		public Reloj() {
			
		}
		
		@Override
		public void timeout() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void registrar() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {

		Puerta puerta = new Puerta();	
		PuertaTemporizada puertaT = new PuertaTemporizada();
		Reloj reloj = new Reloj();
	}
}
