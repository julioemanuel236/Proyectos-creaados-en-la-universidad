package game;

import java.util.Scanner;

public abstract class Mob extends Entity{
	final int dx[]= {1,1,0,-1,-1,-1,0,1};
	final int dy[]= {0,1,1,1,0,-1,-1,-1};
	
	int movimientos;
	int maxMov;
	int damage;
	boolean volar;
	
	public Mob(int vida,int damage,int mM,boolean volar,char c) {
		super(vida,c);
		this.damage = damage;
		this.maxMov = movimientos = mM;
		this.volar=volar;
	}

	public int getVida() {
		return vida;
	}

	public int getMovimientos() {
		return movimientos;
	}

	public int getDamage() {
		return damage;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void restarMove() {
		this.movimientos=maxMov;
	}
	
	public abstract boolean atacar();
	
	public abstract boolean noHit();
	
	public void hit(Entity m) {
		if(noHit()) {
			App.infoTurno+=info()+"ha fallado el ataque contra "+m.info()+"\n";
			return;
		}
		m.vida-=this.damage;
		App.infoTurno+=m.info()+"ha recibido "+this.damage+" de danno de "+info();
		m.die();
	}
/*	
	public void die() {
		if(!isDead())return;
		App.tablero.map[y][x]=null;
		for(Enemigo i:App.enemy) {
			if(i==this) {
				App.enemy.remove(i);
				break;
			}
		}
		if(overLava)App.tablero.map[y][x] = new Lava(x,y);
		else if(overAgua)App.tablero.map[y][x] = new Agua(x,y);
		else if(overArbol) {
			App.tablero.map[y][x] = new Arbol();
			((Entity)App.tablero.map[y][x]).x=x;
			((Entity)App.tablero.map[y][x]).y=y;
		}
		else App.tablero.map[y][x] = new Planicie(x,y);
		App.infoTurno+=this.getClass().getSimpleName()+" en ["+x+","+y+"] ha desaparecido\n";
		App.infoTurno+="El terreno ["+(x+1)+","+(y+1)+"] a cambiado a " + App.tablero.map[y][x].getClass().getSimpleName()+"\n";
	}
*/
	public boolean mover() {
		Tablero tablero=App.tablero;
		int dir=0;
		Scanner cin = new Scanner(System.in);
							
		System.out.println("En que direccion deseas moverte\nU-arriba\nR-derecha\nD-abajo\nL-izquierda");
		char c=cin.next().charAt(0);
		int k=-1;
		
		while(k<1) {
			App.print("Distancia a caminar("+maxMov+"):");
			k=App.seleccion(maxMov);			
			if(k==0)App.print("Opcion invalida\n");
		}
		
		switch(c) {
		 case 'U':dir=6;break;
		 case 'u':dir=6;break;
		 case 'R':dir=0; break;
		 case 'r':dir=0; break;
		 case 'D':dir=2; break;
		 case 'd':dir=2; break;
		 case 'L':dir=4; break;
		 case 'l':dir=4; break;
		 default : return true;
		}
		
		int x=getX()+(dx[dir]*k);
		int y=getY()+(dy[dir]*k);
		
		
		for(int i=1;i<=k;i++) {
			x=getX()+(dx[dir]*i);
			y=getY()+(dy[dir]*i);
			if(!canMove(x,y)) {
				App.print("El Heroe solo se movera hasta ["+(x+1)+","+(y+1)+"]\nporque "
						+tablero.map[y][x].getClass().getSimpleName()+" le obstruye el camino");
				moveTo(getX()+dx[dir]*(i-1),getY()+(dy[dir]*(i-1)));
				return true;
			}
		}
			
		
		moveTo(x,y);		
		return true;
	}
	
	public void moveTo(int x,int y) {
		if(x==getX()&&y==getY())return;
		App.infoTurno+=this.info()+"se ha movida a la posicion ["+(x+1)+","+(y+1)+"]\n";
		Tablero tablero = App.tablero;
		if(overLava)tablero.map[this.y][this.x]=new Lava(this.x,this.y);
		else if(overAgua)tablero.map[this.y][this.x]=new Agua(this.x,this.y);
		else if(overArbol) {
			tablero.map[this.y][this.x]=new Arbol();
			((Entity)tablero.map[this.y][this.x]).x=this.x;
			((Entity)tablero.map[this.y][this.x]).y=this.y;
		}
		else tablero.map[this.y][this.x]=new Planicie(this.x,this.y);
		overLava = tablero.map[y][x] instanceof Lava;
		overAgua = tablero.map[y][x] instanceof Agua;
		overArbol = tablero.map[y][x] instanceof Arbol;
		tablero.map[y][x]=this;
		this.x=x;
		this.y=y;		
	}
	
	public boolean canMove(int x,int y) {
		Tablero tablero = App.tablero;
		if(x<0||x>=tablero.width||y<0||y>=tablero.height)return false;
		if(volar) {
			if((tablero.map[y][x] instanceof Mob))return false;
		}
		else {
			if(!(tablero.map[y][x] instanceof Planicie))return false;
		}
		return true;
	}
	
}
