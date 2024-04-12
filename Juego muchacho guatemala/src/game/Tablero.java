package game;

import java.util.Random;
import java.util.Scanner;

public class Tablero {
	final int dx[]= {1,1,0,-1,-1,-1,0,1};
	final int dy[]= {0,1,1,1,0,-1,-1,-1};
	
	int width=8;
	int height=8;
	Object map[][];
	int planicie=0;
	int porPlanicie=60;
	int porArbol=25;
	int porAgua=10;
	int porLava=5;
	int dificultad=0;

	public Tablero(int t) {
		App.enemy.clear();
		if(t==2) {
			width=height=16;
			porPlanicie=0;
			porArbol=0;
			porAgua=0;
			porLava=30;
		}
		generar();
	}

	public Tablero(int width, int height, int porPlanicie, int porArbol, int porAgua, int porLava) {
		App.enemy.clear();
		this.width = width;
		this.height = height;
		this.porPlanicie = porPlanicie;
		this.porArbol = porArbol;
		this.porAgua = porAgua;
		this.porLava = porLava;
		generar();
	}
	
	
	public void generar() {
		map = new Object[height][width];
		App.tablero=this;
		Random rand = new Random();
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				int n=rand.nextInt(porArbol+porAgua+porLava);
				if(n<porArbol)map[i][j]=new Arbol();
				else if(n>=porArbol&&n<porArbol+porAgua) {
					if(i==0||i==height-1||j==0||j==width-1) {
						map[i][j]=new Agua(j,i);
						continue;
					}
					boolean si=false;
					int arr[]= {0,2,4,6};
					for(int k=0;k<4;k++) {
						int di=i+dy[k];
						int dj=j+dx[k];
						if(map[di][dj] instanceof Agua) {
							map[i][j] = new Agua(j,i);
							si = true;
						}
						if(!si) {
							map[i][j] = new Planicie(j,i);
							planicie++;
						}
					}
				}
				else if(n>=porArbol+porAgua&&n<porArbol+porAgua+porLava)map[i][j]=new Lava(j,i);
				else map[i][j]=new Planicie(j,i);
				if(map[i][j] instanceof Entity) {				
					((Entity)map[i][j]).x=j;
					((Entity)map[i][j]).y=i;
				}
			}
		}
							
		System.out.println("Seleccione una dificultad\n1-facil\n2-normal\n3-dificil");
		Scanner cin = new Scanner(System.in);
		dificultad=cin.nextInt();
		
	}
	
	public String selectColor(Object o) {
		if(o instanceof Enemigo) {
			return App.ANSI_RED;
		}
		else if(o instanceof Heroe) {
			return App.ANSI_PURPLE;
		}
		else if(o instanceof Agua) {
			return App.ANSI_BLUE;
		}
		else if(o instanceof Arbol) {
			return App.ANSI_BROWN;
		}
                else if(o instanceof Lava){
                    return App.ANSI_ORANGE;
                }
		else return App.ANSI_WHITE;
	}
	
	public void generarVista() {
	/*	
              System.out.println("-------------------------------------\n");
		for(int i=0;i<height;i++) {						
			System.out.print("| ");
			String color=selectColor(map[i][0]);
			System.out.print(color+map[i][0]+" ");
			for(int j=0;j<width-1;j++) {
				System.out.print("| ");
				System.out.print(color+map[i][j+1]);
				System.out.print(" ");
			}
			System.out.print("| ");
			System.out.print(color+map[i][width-1]);
			System.out.print(" |\n");
			System.out.print("-------------------------------------\n");
		}
	*/	

		System.out.print("  ");
                String color;
		for(int i=0;i<width;i++) 
			System.out.print(" "+(i+1)+" ");
		System.out.println();
		for(int i=0;i<height;i++) {
			System.out.print((i+1)+" ");
			for(int j=0;j<width;j++) {
                color=selectColor(map[i][j]);
				System.out.print(" "+color+map[i][j]+App.ANSI_RESET+" ");
			}
			System.out.println();
		}
	}
	
	public void generarMounstros() {
		int can=1+dificultad;
		Random rand = new Random();
		
		//System.out.println("Se generaran "+can+"/"+planicie);
		while(can>0) {
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					if(can==0)return;
					if(map[i][j] instanceof Planicie) {
						if(rand.nextInt(101)<20) {
							int t=rand.nextInt()%5;
							Enemigo e=null;
							switch(t) {
								case 0:e = new Ogro(); break;
								case 1:e = new Cancerbero(); break;
								case 2:e = new FlorCarnivora(); break;
								case 3:e = new Bruja(); break;
								default:e = new Gargola(); break;
							}
							e.x=j;
							e.y=i;
							map[i][j]=e;	
							App.enemy.add(e);
							can--;
						}
					}
				}
			}
		}
	}
			
	public void ver() {
		generarVista();
	}

}
