package elementos;

import elementos.serpiente.Cuerpo;

public class Matriz{
	
	private Cuerpo[][] matriz;
	
	public Matriz(int n,int m) {
		matriz = new Cuerpo[n][m];
	}
	
	public int get(int x,int y) {
		if(matriz[y][x] == null)return -1;
		else return matriz[y][x].getId();
	}

	public boolean set(int x,int y,Cuerpo c) {		
		if(x<0 || y < 0 || x>=matriz.length || y>= matriz.length) {
			//System.out.println("MUERTE DE "+c.getId()+" POR FUERA DE RANGO");
			return false;
		}
		Cuerpo temp = matriz[y][x];
		
		if((temp != null && temp.getId()!=c.getId())) {
			//System.out.println("MUERTE DE "+c.getId()+" POR CHOCAR CON OTRA SERPIENTE");
			return false;
			
		}

		matriz[y][x] = c;
		return true;
	}
	
	public void erase(int x,int y) {
		matriz[y][x] = null;
	}
	
	public int getSize() {
		return matriz.length;
	}
	
	public void mostrar() {
		for(int i=0 ; i<getSize(); i++) {
			for(int j=0 ; j<getSize(); j++) {
				int s = get(j, i);
				if(s == -1 )System.out.print('*');
				else System.out.print(s);
			}
			System.out.println();
		}
		System.out.println();
	}
}