package visorgasto;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import data.Gasto;


public class PanelVisorGasto extends Container{

	private static final long serialVersionUID = 1L;

	public final int CANTIDADMAXIMAGASTOS = 1000;
	Gasto[] gastos = new Gasto[CANTIDADMAXIMAGASTOS];
	
	int topSuperior;
	int cantidadActual;
	
	@Override
	public void paint(Graphics g) {
	
		g.setColor(Color.red);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		super.paint(g);
		
	}
	
	public static void main(String[] args) {
		javax.swing.JFrame root = new javax.swing.JFrame();
		javax.swing.JPanel p = new javax.swing.JPanel();
		root.setSize(500,500);
		root.add(p);
		p.setLayout(null);
		p.setBackground(Color.black);
		PanelVisorGasto vg = new PanelVisorGasto();
		vg.setSize(400,400);
		vg.setLocation(0,0);
		p.add(vg);
		
		root.setVisible(true);
		root.setDefaultCloseOperation(root.EXIT_ON_CLOSE);
	}
	
	public void agregarDato(Gasto gasto) {
		if(cantidadActual<gastos.length)
			gastos[cantidadActual++] = gasto;
	}
	
	public void agregarDato(Gasto[] gasto) {
		for(int i=0;i<gasto.length && cantidadActual<gastos.length;i++)
		gastos[cantidadActual++] = gasto[i];
	}
}