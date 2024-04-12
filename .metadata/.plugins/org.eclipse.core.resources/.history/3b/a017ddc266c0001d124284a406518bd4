package game;

public abstract class Entity extends java.lang.Object{
	int vida;
	int vidaMaxima;
	int x;
	int y;
	char c;
	String color="";
	boolean overLava=false;
	boolean overAgua=false;
	boolean overArbol=false;
	public Entity(int vida,char c) {
		this.vida = vidaMaxima = vida;
		this.c=c;
		//this.color=App.ANSI_BLACK;
	}
	
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
		App.infoTurno+=this.getClass().getSimpleName()+" en ["+(x+1)+","+(y+1)+"] ha desaparecido\n";
		App.infoTurno+="El terreno ["+(x+1)+","+(y+1)+"] a cambiado a " + App.tablero.map[y][x].getClass().getSimpleName()+"\n";
	}
/*
	public void die() {
		if(!this.isDead())return;
		App.infoTurno+=this.getClass().getSimpleName()+" en ["+(x+1)+","+(y+1)+"] ha desaparecido\n";
		App.tablero.map[y][x]=null;
		App.tablero.map[y][x] = new Planicie(x,y);
	}*/
	
	public String info() {
		return color+getClass().getSimpleName()+App.ANSI_RESET+": "+vida+"/"+vidaMaxima+"["+(x+1)+","+(y+1)+"]\n";
	}

	public boolean isDead() {
		return this.vida<=0;
	}
	
	public String toString() {
		return ""+c;
	}
}
