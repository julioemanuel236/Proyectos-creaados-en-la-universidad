package game;
import java.util.Random;
public abstract class Heroe extends Mob {

	public Heroe(int vida, int damage,int mM,boolean volar,char c) {
		super(vida, damage,mM,volar,c);
		this.color=App.ANSI_GREEN;
	}	
	
	public String info() {
		return App.ANSI_GREEN+"Heroe "+App.ANSI_RESET+super.info();
	}

	@Override
	public boolean noHit() {
		Random rand = new Random();
		int n=1+ rand.nextInt(101);
		return n>75;
	}
	
	public String all() {
		return "|"+getClass().getSimpleName()+"|"+vida+"/"+vidaMaxima+"|"+damage+"|["+x+","+y+"]|";
	}
	
	public String shopping() {
		return "Vida: "+vidaMaxima+"\tdamage: "+damage;
	}
}
