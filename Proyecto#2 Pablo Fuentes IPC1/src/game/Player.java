package game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import unidades.Arquero;
import unidades.Caballero;
import unidades.Dragon;
import unidades.Enemigo;
import unidades.Gigante;
import unidades.Heroe;
import unidades.Mago;

public class Player implements Serializable{
	public  String nombre;
	
	public  ArrayList<Heroe> heroes = new ArrayList<>();
	public  ArrayList<Heroe> hComprar = new ArrayList<>();
	public  ArrayList<Item> items = new ArrayList<>();
	public  ArrayList<Enemigo> enemy = new ArrayList<>();
	public  Tablero tablero;
	public  int oro=500;
	public 	int puntos = 0;
	public  Heroe ingame[] = new Heroe[2];
	public  int mainHero=0;
	public  String infoTurno="";
	public 	boolean tieneGuardado=false;
	public 	String dirGuardado="";
	
	public Player(String nombre, String dirGuardado) {		
		super();
		
		this.nombre = nombre;		
		if(dirGuardado==null) {
			hComprar.add(new Caballero(""));
			hComprar.add(new Arquero(""));
			hComprar.add(new Mago(""));
			hComprar.add(new Gigante(""));
			hComprar.add(new Dragon(""));
			return;
		}
		this.dirGuardado = nombre+"-"+dirGuardado+".sp";
				
	}
	
	public void Guardar() {
		try{
			FileOutputStream fos = new FileOutputStream(dirGuardado);			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			tablero=null;
			oos.writeObject(this);
		}
		catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se pudo guardar la partida");
		}
	}
	
	public void setDirGuardado(String s) {
		dirGuardado = nombre+"-"+s+".sp";;
	}
	
	public static Player cargarPlayer(String nombre,String dirGuardado) {		
		if(dirGuardado==null)return new Player(nombre,null);
		dirGuardado = nombre+"-"+dirGuardado+".sp";
		try{
			FileInputStream fos = new FileInputStream(dirGuardado);			
			ObjectInputStream oos = new ObjectInputStream(fos);
			Player p = (Player)oos.readObject();
			JOptionPane.showMessageDialog(null, "Bienvenido de nuevo "+p.nombre);
			return p;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo cargar la partida");
			return new Player(nombre,null);
		}
	}
	
}
