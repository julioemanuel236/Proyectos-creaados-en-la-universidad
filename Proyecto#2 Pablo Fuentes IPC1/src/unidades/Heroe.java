package unidades;

import game.*;
import java.util.Random;
public abstract class Heroe extends Mob {
	
	String nombre;
	
	public Heroe(String nombre,int vida, int damage,int mM,boolean volar,char c) {
		super(vida, damage,mM,volar,c);
		this.color=App.ANSI_GREEN;
		this.nombre=nombre;
	}	
	
	public String info() {
		return nombre+" "+App.ANSI_GREEN+"Heroe "+App.ANSI_RESET+super.info();
	}

	@Override
	public boolean noHit() {
		Random rand = new Random();
		int n=1+ rand.nextInt(101);
		return n>75;
	}
	
	public String all() {
		return nombre+"|"+getClass().getSimpleName()+"|"+vida+"/"+vidaMaxima+"|"+damage+"|["+(x+1)+","+(y+1)+"]|";
	}
	
	public String shopping() {
		return "Vida: "+vidaMaxima+"\tdamage: "+damage;
	}
	
	public String toString() {
		return nombre+" "+super.toString();
	}
}
