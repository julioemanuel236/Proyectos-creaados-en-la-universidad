package tarea;

import java.awt.Point;
import javax.swing.JOptionPane;
import java.util.Random;
public class Examen {

	private int n=4;
	private String[] fichas = {"EL AFIL","EL CABALLO","LA TORRE","EL REY"};
	private Point[] posiciones = new Point[fichas.length];
	private int[] dx = {1,1,0,-1,-1,-1,0,1};
	private int[] dy = {0,1,1,1,0,-1,-1,-1};
	private int[] dxC = {2, 1, -1, -2, -2, -1, 1, 2};
	private int[] dyC = {1, 2, 2, 1, -1, -2, -2, -1};

	public Examen() {
		
	}
		
	public void menu() {
		while(true) {
			String op = JOptionPane.showInputDialog(
					  "1.Configurar\n"
					+ "2.Poner Fichas\n"
					+ "3.Evaluar Amenazas\n"
					+ "0.Salir"
					);
			char c='N';
			if(op!=null && op.length()>0)c = op.charAt(0);
			switch(c) {
				case '1':configurar(); break;
				case '2':posicionar(); break;
				case '3':evaluar(); break;
				case '0':return; 
				default:System.out.println("Opcion no valida");
			}
		}
	}
	
	private void configurar() {
		String op = JOptionPane.showInputDialog("Introduzca el tamanno del tablero");		
		int nuevo = Integer.parseInt(op);
		if(nuevo<2)System.out.println("Valor muy pequenno");
		else this.n = nuevo;
	}
	
	private void posicionar() {
		Random rand = new Random();
		for(int i=0;i<fichas.length;i++) {
			Point np = new Point();
			np.x = rand.nextInt(n);
			np.y = rand.nextInt(n);
			posiciones[i] = np;
			//ver que la posicion no está ocupada
			for(int j=0;j<i;j++) {
				if(posiciones[j].x==np.x && 
				   posiciones[j].y==np.y) {
					//si ya existe esa posicion restar 1 a la i
					//esto la mantiene en el mismo lugar
					i--;
					break;
				}
			}
		}
		mostrarMatriz();
	}
			
	private void mostrarMatriz() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				boolean ficha=false;
				for(int k=0;k<posiciones.length;k++) {
					if(posiciones[k].x==i&&posiciones[k].y==j) {
						ficha = true;
						System.out.print(fichas[k].charAt(3));
						break;
					}
				}
				if(!ficha)System.out.print("*");
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	private void evaluar() {
		String resultado = "";		
		for(int i=0;i<fichas.length;i++) {
			for(int j=0;j<fichas.length;j++) {
				if(i==j)continue;
				boolean ataca=false;
				if(i==0) {
					if(posiciones[i].x + posiciones[i].y == posiciones[j].x + posiciones[j].y)ataca=true;					
					if(posiciones[i].x - posiciones[i].y == posiciones[j].x - posiciones[j].y)ataca=true;
				}
				else if(i==1) {
					for(int k = 0;k<dxC.length;k++) {
						if(posiciones[i].x + dxC[k] == posiciones[j].x && 
						   posiciones[i].y + dyC[k] == posiciones[j].y) {
							ataca=true;
							break;
						}
					}
				}
				else if(i==2) {
					if(posiciones[i].x == posiciones[j].x || 
					   posiciones[i].y == posiciones[j].y)ataca=true;
						
				}
				else {
					for(int k = 0;k<dx.length;k++) {
						if(posiciones[i].x + dx[k] == posiciones[j].x && 
						   posiciones[i].y + dy[k] == posiciones[j].y) {
							ataca=true;
							break;
						}
					}
				}
				if(ataca)resultado+=(fichas[j]+ " es amenazado por "+fichas[i])+"\n";
			}
		}
		System.out.println(resultado);
	}
	
	public static void main(String[] args) {
		new Examen().menu();
	}
}
