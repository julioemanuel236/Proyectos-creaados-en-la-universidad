package visorgasto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;

import data.Gasto;
import ventana.configs;

import java.awt.Component;
import java.awt.Font;

public class VerticalScrollBar extends Component{
		
	private static final long serialVersionUID = 1L;

	Color activeColor;
	Color inactiveColor;
	Color fondoColor;
	
	private int indicadorY;
	private int indicadorHeight;
	
	private int elementosVisibles;
	private int totalElementos;
	
	private boolean active;
	
	public VerticalScrollBar() {
		ini();
	}
	
	private void ini() {
		activeColor = configs.MAIN_COLOR;
		inactiveColor = configs.ALTERN_COLOR;
		fondoColor = new Color(0,0,0,100);
		active = false;
	}
	
	public void pintarFondo(Graphics g) {
		g.setColor(fondoColor);
		g.fillRect(0, 0, getWidth(), getHeight());
		indicadorY = 0;
		indicadorHeight = getHeight();
	}
	
	public void pintarIndicador(Graphics g) {
		int width = 0;
		int x = 0;
		
		if(active) {
			g.setColor(activeColor);
		}
			
		else {
			width = getWidth()/3;			
			x = (getWidth()/2)-(width/2);
											
			indicadorHeight = (int)(getHeight()*(double)((double)elementosVisibles/(double)totalElementos));
			
			g.setColor(inactiveColor);						
		}
		
		g.fillRect(x, indicadorY, width, indicadorHeight);
		
	}
	
	@Override
	public void paint(Graphics g) {
		if(totalElementos == 0)return;
		pintarFondo(g);
		pintarIndicador(g);
	}

	public void updateSize() {
		if(getParent() == null)
			return;
		setSize(getWidth(),getParent().getHeight());
	}
	
	public void setElementosVisibles(int e) {
		this.elementosVisibles = e;
	}
	
	public void setTotalElementos(int e) {
		this.totalElementos = e;
	}
	
	public static void main(String[] args) {
		
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File(VisorGasto.class.getResource("/fonts/Arciform.otf").getFile())));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		javax.swing.JFrame root = new javax.swing.JFrame();
		javax.swing.JPanel p = new javax.swing.JPanel();
		root.setSize(500,500);
		p.setSize(root.getSize());
		root.add(p);
		p.setLayout(null);
		p.setBackground(Color.white);
		VerticalScrollBar vg = new VerticalScrollBar();
		vg.setSize(18,200);
		vg.setLocation(100,1);
		p.add(vg);
		vg.setTotalElementos(2);
		vg.setElementosVisibles(1);
		vg.updateSize();
		root.setVisible(true);
		root.setDefaultCloseOperation(root.EXIT_ON_CLOSE);
	}
	
}

