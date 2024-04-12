package Ventana;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;

public class Imagen extends JLabel{
	String ruta;
	ImageIcon original;
	
	public Imagen(){

	}
	
	public Imagen(String s){
		this.setImagen(s);

	}
	
	public Imagen(int w,int h,String s,int x,int y){
		this.setLocation(x,y);
		this.setSize(w,h);
		this.setImagen(s,w,h);

	}
	
		public Imagen(int w,int h,String s){
		this.setSize(w,h);
		this.setImagen(s,w,h);

	}
	

	public void ajustar(){
		this.setIcon(new ImageIcon(original.getImage().getScaledInstance(this.getWidth(),this.getHeight(), Image.SCALE_SMOOTH)));
	}
	
	public void setImagen(String s) {
		try{
			original= new ImageIcon(s);
			this.setIcon(original);
			this.ruta=s;
		}
		catch(Exception e){
			this.setBackground(Color.red);
			this.setOpaque(true);
			e.printStackTrace(System.out);
		}
	}
		public void setImagen(String s,int w,int h) {
		try{
			original = new ImageIcon(new ImageIcon(s).getImage().getScaledInstance(w,h,Image.SCALE_SMOOTH));
			this.setIcon(original);
			this.ruta=s;
			//System.out.println(this.ruta+" Imagen bien puesta");
		}
		catch(Exception e){
			this.setBackground(Color.red);
			this.setOpaque(true);
			//System.out.println("No se encuentra la imagen");
		}
	}
}
