package unidades;

import game.*;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class Arquero extends Heroe {

	public Arquero(String nombre) {
		super(nombre,150,100,3,false,'a');
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean atacar() {
		Tablero tablero = App.player.tablero;
		int arr[]= {0,2,4,6};
		ArrayList<Entity> attack = new ArrayList<>();
		
		for(int i=0;i<4;i++) {
			for(int j=1;j<4;j++) {
				int ax=x+(dx[arr[i]]*j);
				int ay=y+(dy[arr[i]]*j);
				if(ax<0||ax>=tablero.width||ay<0||ay>=tablero.height)continue;
				else if(tablero.map[ay][ax] instanceof Entity) {
					attack.add((Entity)tablero.map[ay][ax]);
				}
			}
		}
		
		Entity e = (Entity)JOptionPane.showInputDialog(null,"Seleccione un heroe","Que hacer",JOptionPane.QUESTION_MESSAGE,null,attack.toArray(),null);
		if(e!=null) {			
			hit(e);			
			return true;
		}
		return false;
	}

	public String info() {
		return "Arquero "+super.info();
	}
	
	@Override
	public String shopping() {
		return "Arquero: "+super.shopping();
	}

}
