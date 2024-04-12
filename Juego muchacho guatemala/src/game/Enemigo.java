package game;

import java.util.Random;

public abstract class Enemigo extends Mob {
	int vision;
	public Enemigo(int vida, int damage,int mM,boolean volar,char c) {
		super(vida,damage,mM,volar,c);
		this.vision=mM+2;
		this.color=App.ANSI_RED;
	}

	@Override
	public boolean mover() {
		if(inRange()&&App.tablero.dificultad==3) {
			perseguir();
			return true;
		}
		if(maxMov==0)return false;
		Tablero tablero=App.tablero;
		int dir=0;
		int arr[]= {0,2,4,6};
		Random rand = new Random();
		dir = arr[rand.nextInt(4)];
		int k=rand.nextInt((maxMov+1));
		int x=getX()+(dx[dir]*k);
		int y=getY()+(dy[dir]*k);
		
		if(!canMove(x,y))return false;
		moveTo(x,y);
		
		return true;
	}
	
	@Override
	public boolean noHit() {
		Random rand = new Random();
		int n=1+ rand.nextInt(100);
		return n>60;
	}

	public void perseguir() {
		if(!inRange())return;
		int rx=x,ry=y;
		int dmin=App.tablero.width*App.tablero.height;
		int arr[]= {0,2,4,6};
		for(int i=0;i<4;i++) {
			int dir=arr[i];
			for(int j=1;j<=maxMov;j++) {
				int x=this.x+(dx[dir]*j);
				int y=this.y+(dy[dir]*j);
				int d=distanciaManhatanToHero(x,y);
				if(!canMove(x,y))continue;				
				if(d==0)continue;
				if(d<dmin) {
					rx=x;
					ry=y;
					dmin=d;
				}
			}
		}
		moveTo(rx,ry);
	}
	
	public int distanciaManhatanToHero(int x,int y) {
		Heroe e = App.ingame[App.mainHero];
		return Math.abs(e.x-x)+Math.abs(e.y-y);
	}
	
	public boolean inRange() {		
		return distanciaManhatanToHero(x,y)<=vision;
	}
	
}
