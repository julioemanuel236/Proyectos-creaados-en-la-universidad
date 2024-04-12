package unidades;
import java.io.Serializable;

import game.*;

public abstract class Entity extends java.lang.Object implements Serializable{
	public int vida;
	public int vidaMaxima;
	public int x;
	public int y;
	public char c;
	public String color="";
	public boolean overLava=false;
	public boolean overAgua=false;
	public boolean overArbol=false;
	public int puntaje;
	public Entity(int vida,char c) {
		this.vida = vidaMaxima = vida;
		this.c=c;
		//this.color=App.player.ANSI_BLACK;
	}
	
	public void restaureMap() {
		if(overLava)App.player.tablero.map[y][x] = new Lava(x,y);
		else if(overAgua)App.player.tablero.map[y][x] = new Agua(x,y);
		else if(overArbol) {
			App.player.tablero.map[y][x] = new Arbol();
			((Entity)App.player.tablero.map[y][x]).x=x;
			((Entity)App.player.tablero.map[y][x]).y=y;
		}
		else App.player.tablero.map[y][x] = new Planicie(x,y);	
	}
	
	public void die() {
		if(!isDead())return;
		App.player.puntos+=puntaje;
		App.guardarPuntaje();
		App.player.tablero.map[y][x]=null;
		for(Enemigo i:App.player.enemy) {
			if(i==this) {
				App.player.enemy.remove(i);
				break;
			}
		}
		restaureMap();
		App.player.infoTurno+=getClass().getSimpleName()+" en ["+(x+1)+","+(y+1)+"] ha desaparecido\n";
		App.player.infoTurno+="El terreno ["+(x+1)+","+(y+1)+"] a cambiado a " + App.player.tablero.map[y][x].getClass().getSimpleName()+"\n";
		App.player.tablero.update();
		App.player.puntos+=this.puntaje;
	}

	
	public String info() {
		return color+getClass().getSimpleName()+App.ANSI_RESET+": "+vida+"/"+vidaMaxima+"["+(x+1)+","+(y+1)+"]\n";
	}

	public boolean isDead() {
		return this.vida<=0;
	}
	
	public String toString() {
		return getClass().getSimpleName();
	}
}
