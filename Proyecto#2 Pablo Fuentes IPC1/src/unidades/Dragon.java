package unidades;

import game.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Dragon extends Heroe {

	public Dragon(String nombre) {
		super(nombre,250, 75,3, true ,'d');
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean atacar() {
		int dir=0;
		Tablero tablero = App.player.tablero;
		
		String dirArr[]= {"Arriba","Derecha","Abajo","Izquierda"};
		String direccion = (String)JOptionPane.showInputDialog(null,"Seleccione un heroe","Que hacer",JOptionPane.QUESTION_MESSAGE,null,dirArr,null);
		if(direccion==null)return false;
		if(direccion.equals(dirArr[0]))dir=4;
		if(direccion.equals(dirArr[1]))dir=2;
		if(direccion.equals(dirArr[2]))dir=0;
		if(direccion.equals(dirArr[3]))dir=6;
		
		for(int i=1;i<3;i++) {
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
		return "Dragon "+super.info();
	}
	
	@Override
	public String shopping() {
		return "Dragon: "+super.shopping();
	}

}
