package game;

import java.io.Serializable;

public class Terreno extends Object implements Serializable{
	public int x,y;
	public char c;
	public Terreno(int x,int y,char c) {
		this.x=x;
		this.y=y;
		this.c=c;
		//App.tablero.map[y][x]=this;
	}

	
	public String toString() {
		return c+"";
	}
}
