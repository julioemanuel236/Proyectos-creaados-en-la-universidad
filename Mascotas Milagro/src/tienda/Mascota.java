package tienda;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Mascota implements Serializable{

	private String pais;
	private String color;
	private int    meses;
	
	public Mascota(String pais,String color,int meses) {
		this.pais=pais;
		this.color=color;
		this.meses=meses;
	}
	
	public String getPais() {
		return pais;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getMeses() {
		return meses;
	}
	
	public abstract float getPrecio();
	
	public abstract JPanel token(ArrayList<Perro> perros,ArrayList<Gato> gatos,JLabel cantidad,JTextField paies,TreeSet<String> Paises,boolean vender);
}
