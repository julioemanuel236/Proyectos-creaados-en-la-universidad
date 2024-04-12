package tarea;

public class PrimerosPrimos {
	
	public static boolean isPrimo(int n) {
		if(n==1)return false;
		for(int i=2;i<n;i++)
			if(n%i==0)return false;
		return true;
	}
	
	public static void main(String[] args) {
		int[] primos = new int[20];
		int pos=0;
		int num=1;
		while(pos<20) {
			if(isPrimo(num)) {
				primos[pos]=num;		
				pos++;
			}
			num++;
		}
		System.out.println("INDICE\tCONTENIDO");
		for(int i=0;i<20;i++)
			System.out.println((i+1)+"\t"+primos[i]);
	}
}
