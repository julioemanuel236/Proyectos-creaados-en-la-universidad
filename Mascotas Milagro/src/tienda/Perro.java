package tienda;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Perro extends Mascota  implements Serializable{
	protected static String RAZAS[] = {"Dálmata","Chow Chow","Bulldog"};
	private static int	  EXTRA[] = {50,30,0};
	private int raza;
	
	public Perro(String pais,String color,int meses,int raza) {
		super(pais,color,meses);
		this.raza=raza;
	}
	
	public String getRaza() {
		return RAZAS[raza];
	}
	
	public float getPrecio() {
		if(getMeses()<=24)return (1000f/getMeses())+EXTRA[raza];
		else return 35+EXTRA[raza];
	}
	

	public JPanel token(ArrayList<Perro> perros,ArrayList<Gato> gatos,JLabel cantidad,JTextField paies,TreeSet<String> Paises,boolean vende) {
		int b=2;
		LineBorder borde = new LineBorder(Color.black, b);
		JPanel panel = new JPanel();
		panel.setSize(125,150);
		panel.setPreferredSize(new Dimension(125,150));
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(borde);
		
		
		JLabel tipo = new JLabel("PERRO");
		JLabel meses = new JLabel(""+getMeses());
		JLabel pais = new JLabel(getPais());
		//JLabel sexo = new JLabel(""+getSexo());
		JLabel precio = new JLabel("$"+getPrecio());
		
		tipo.setSize(panel.getWidth()/2,30);
		pais.setSize(panel.getWidth(),30);
		pais.setLocation(0,panel.getHeight()-pais.getHeight());
		precio.setSize((panel.getWidth()*3)/4,30);
		precio.setLocation(0,pais.getY()-precio.getHeight()+b);
		meses.setSize(panel.getWidth()/4,tipo.getHeight());
		meses.setLocation(panel.getWidth()-meses.getWidth()-b-b,0);
		//sexo.setSize(meses.getSize());
		//sexo.setLocation(tipo.getWidth()-b,0);
		
		tipo.setHorizontalAlignment(JLabel.CENTER);
		meses.setHorizontalAlignment(JLabel.CENTER);
		pais.setHorizontalAlignment(JLabel.CENTER);
		//sexo.setHorizontalAlignment(JLabel.CENTER);
		precio.setHorizontalAlignment(JLabel.CENTER);
		
		tipo.setForeground(Color.black);
		meses.setForeground(Color.black);
		pais.setForeground(Color.black);
		//sexo.setForeground(Color.black);
		precio.setForeground(Color.black);
		
		tipo.setBorder(borde);
		meses.setBorder(borde);
		pais.setBorder(borde);
		//sexo.setBorder(borde);
		precio.setBorder(borde);
		
		String arr[] = {"Color:","Raza:"};
		String res[] = {getColor(),RAZAS[raza]};
		
		for(int i=0;i<2;i++) {
			JLabel jl = new JLabel(arr[i]);
			jl.setSize((panel.getWidth()*2)/6,15);
			jl.setLocation(5,35+(i*5)+(i*jl.getHeight()));
			jl.setForeground(Color.black);
			jl.setHorizontalAlignment(JLabel.LEFT);
			panel.add(jl);
			JLabel jr = new JLabel(res[i]);
			jr.setSize((panel.getWidth()*4)/7,15);
			jr.setLocation(jl.getX()+jl.getWidth(),35+(i*5)+(i*jr.getHeight()));
			jr.setForeground(Color.black);
			jr.setHorizontalAlignment(JLabel.CENTER);
			panel.add(jr);
		}
		
		JButton vender = new JButton("=>");
		vender.setOpaque(true);
		vender.setBackground(Color.GREEN);
		vender.setBorder(borde);
		vender.setFocusable(false);
		vender.setLocation(precio.getX()+precio.getWidth()-b,precio.getY());
		vender.setSize(panel.getWidth()-precio.getWidth()-b,precio.getHeight());
		vender.addActionListener((ActionEvent)->{
			panel.setVisible(false);
			perros.remove(this);
			cantidad.setText(""+gatos.size()+perros.size());	
			cantidad.setText("Mascotas: "+(perros.size()+gatos.size()));
			Paises.remove(getPais());
			System.out.println(Paises.size());
			pais.setText("");
			for(String i:Paises)
				pais.setText(pais.getText()+"   "+i);
			pais.repaint();
		});
		
		panel.add(tipo);
		panel.add(meses);
		panel.add(pais);
		//panel.add(sexo);
		panel.add(precio);
		if(vende)panel.add(vender);
		
		panel.setSize(panel.getWidth()-b-b,panel.getHeight());
		panel.setPreferredSize(new Dimension(panel.getWidth(),panel.getHeight()));
		return panel;
	}
	
	
}
