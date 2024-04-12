package unidades;

import game.*;

import java.awt.Color;
import java.util.Scanner;
import game.App;
public abstract class Mob extends Entity{
	final public int dx[]= {1,1,0,-1,-1,-1,0,1};
	final public int dy[]= {0,1,1,1,0,-1,-1,-1};
	
	public int movimientos;
	public int maxMov;
	public int damage;
	public boolean volar;
	
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
			App.player.infoTurno+=info()+"ha fallado el ataque contra "+m.info()+"\n";
			return;
		}		
		m.vida-=this.damage;		
		App.player.infoTurno+=m.info()+"ha recibido "+this.damage+" de danno de "+info();
		App.player.tablero.animacionGolpe(m.x,m.y);
		m.die();
	}
/*	
	public void die() {
		if(!isDead())return;
		App.player.tablero.map[y][x]=null;
		for(Enemigo i:App.player.enemy) {
			if(i==this) {
				App.player.enemy.remove(i);
				break;
			}
		}
		if(overLava)App.player.tablero.map[y][x] = new Lava(x,y);
		else if(overAgua)App.player.tablero.map[y][x] = new Agua(x,y);
		else if(overArbol) {
			App.player.tablero.map[y][x] = new Arbol();
			((Entity)App.player.tablero.map[y][x]).x=x;
			((Entity)App.player.tablero.map[y][x]).y=y;
		}
		else App.player.tablero.map[y][x] = new Planicie(x,y);
		App.player.infoTurno+=this.getClass().getSimpleName()+" en ["+x+","+y+"] ha desaparecido\n";
		App.player.infoTurno+="El terreno ["+(x+1)+","+(y+1)+"] a cambiado a " + App.player.tablero.map[y][x].getClass().getSimpleName()+"\n";
	}
*/
	public boolean mover() {
		
		Tablero tablero=App.player.tablero;
		
		int dirr[]= {0,2,4,6};
		for(int j = 0; j<4 ;j++) {
			int dir = dirr[j];
			int xi=getX();
			int yi=getY();
			for(int i=1;i<=maxMov;i++) {
				int x=xi+(dx[dir]*i);
				int y=yi+(dy[dir]*i);
				if(canMove(x,y)){
					tablero.botones[y][x].setBackground(Color.green);
					tablero.botones[y][x].addActionListener(tablero.moverA);					
				}				
				else break;
			}
		}
				
		//moveTo(x,y);
		return true;
		
	}
	
	public void moveTo(int x,int y) {
		if(x==getX()&&y==getY())return;
		App.player.infoTurno+=this.info()+"se ha movida a la posicion ["+(y+1)+","+(x+1)+"]\n";
		Tablero tablero = App.player.tablero;
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
		Tablero tablero = App.player.tablero;
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
