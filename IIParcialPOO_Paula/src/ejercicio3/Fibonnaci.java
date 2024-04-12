package ejercicio3;

public class Fibonnaci implements Serie{
	int valor1;
	int valor2;
	int actual;
	int ini1;
	int ini2;
	int index = 0;
	@Override
	public int getSiguiente() {
		if(index==0) {
			index++;
			return valor1;
		}
		else if(index==1) {
			index++;
			return valor2;
		}
		else {
			actual = valor1+valor2;
			valor1 = valor2;
			valor2 = actual;
			index++;
		return actual;
		}
	}
	@Override
	public void reiniciar() {
		valor1=ini1;
		valor2=ini2;
		actual=0;
		index=0;
		
	}
	@Override
	public void setComenzar(int x) {
	}
	
	public void setInicio(int a,int b){
		if(a<0||b<0)System.out.println("Valores no valido");
		if(a>b)System.out.println("Valores no valido");
		ini1=a;
		ini2=b;		
		reiniciar();
	}
	
	public void generarN(int n) {
		for(int i=0;i<=n;i++) {
			System.out.println(getSiguiente());			
		}
	}
	
	public boolean pertenece(int n) {
		if(n<0)return false;
		 int t1=valor1;
		 int t2=valor2;
		 int t3=actual;
		 int t4=index;
		 reiniciar();
		 while(getSiguiente()<n);
		 boolean ok = actual==n;
		 valor1=t1;
		 valor2=t2;
		 actual=t3;
		 index=t4;
		 return ok;
	}
	
	
}
