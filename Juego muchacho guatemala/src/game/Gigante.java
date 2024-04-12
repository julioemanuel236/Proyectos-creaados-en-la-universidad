package game;

import java.util.Scanner;

public class Gigante extends Heroe {

	public Gigante() {
		super(350, 56, 1, false,'g');
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean atacar() {
		int dir=0;
		Tablero tablero = App.tablero;
		Scanner cin = new Scanner(System.in);
		System.out.println("En que direccion deseas atacar\nU-arriba\nR-derecha\nD-abajo\nL-izquierda");
		char c=cin.next().charAt(0);
		
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
		
		for(int i=1;i<4;i++) {
			int ax=getX()+(dx[dir]*i);
			int ay=getY()+(dy[dir]*i);
			if(ax<0||ax>=tablero.width||ay<0||ay>=tablero.height)continue;
			if(tablero.map[ay][ax] instanceof Entity) {
				this.hit((Entity)tablero.map[ay][ax]);
			}
		}
		return true;
	}


	
	@Override
	public String info() {
		return "Gigante "+super.info();
	}
	
	@Override
	public String shopping() {
		return "Gigante: "+super.shopping();
	}

}
