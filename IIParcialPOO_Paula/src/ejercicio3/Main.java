package ejercicio3;

public class Main {

	public static void main(String[] args) {
		Fibonnaci fibo = new Fibonnaci();
		
		fibo.setInicio(0, 1);
		fibo.generarN(15);
		
		Primos primos = new Primos();
		primos.setComenzar(13);
		primos.generarN(15);
		
	}
	
}
