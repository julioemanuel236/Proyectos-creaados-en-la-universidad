package ejercicio3;
import java.util.TreeSet;
public class Primos implements Serie{
	int ini = 2;
	int actual = ini;
	int index=0;
	TreeSet<Integer> primos = new TreeSet<>();	
	
	Primos(){
		primos.add(2);
	}
	
	public int getSiguiente() {
		if(index == 0) {
			index++;
			return ini;
		}
		while(!esPrimo(++actual));
		
		primos.add(actual);
		index++;
		return actual;
	}
	
	public void generarN(int n) {
		int meta = index+n;
		while(index < meta){
			System.out.println(getSiguiente());
		}
	}
	
	boolean esPrimo(int x) {
		for(Integer i:primos) {
			if(i>x)break;
			if(x%i==0)return false;
		}
		
		return true;
			
	}

	@Override
	public void reiniciar() {
		actual = ini;
		index =0;
		
	}

	@Override
	public void setComenzar(int x) {
		if(!esPrimo(x)) {
			System.out.println("Valor no valido\n");
			return;
		}
		reiniciar();
		while(actual<x)getSiguiente();
		ini = actual;
		primos.add(ini);
		reiniciar();
		}
		
	}
