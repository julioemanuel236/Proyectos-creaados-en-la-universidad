package visorgasto;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigDecimal;
import java.awt.Button;
import java.awt.Color;
import java.awt.GradientPaint;
import data.*;
import ventana.configs;

public class VisorGasto extends Component{

	private Gasto gasto;
	
	private Color background = new Color(0,0,0,100);
	
	private Font fontNombre = new Font("Arciform",Font.PLAIN,12);
	private Font fontPrecio = new Font("Arciform",Font.BOLD,12);	
	private Font fontDolar = new Font("Arciform",Font.PLAIN,9);
	
	private final String DOLAR = "$";
	
	private GradientPaint fondo;
	
	public VisorGasto() {
		
	}
	
	public VisorGasto(Gasto gasto) {
		this.gasto = gasto;
		ini();
	}
	
	public void mostrarGasto(Gasto gasto) {
		this.gasto = gasto;
		ini();
		this.repaint();
	}
	
	private void ini() {
		setForeground(configs.FOREGROUND);
		fondo = new GradientPaint(0, getWidth(), configs.ALTERN_COLOR, getWidth()/2, getHeight()/2, configs.MAIN_COLOR);
	}
	
	@Override
	public void setSize(int widht,int height) {
		super.setSize(widht, height);
		ini();
	}
	
	@Override
	public void setSize(Dimension size) {
		super.setSize(size);
		ini();
	}
	
	private void pintarNombre(Graphics g,String nombre,int x,int y,int width,int height) {
		int alto = textHeight(fontNombre, nombre);
		int w = 0;
		int h = 0;
		while(w<width && h < height) {
			w = 0;
			h = 0;
			alto++;
			fontNombre = ajustarFuente(fontNombre, alto);					
			w = textWidth(fontNombre, nombre);
			h = textHeight(fontNombre, nombre);
		}
		
		while(w>=width || h>=height) {
			w = 0;
			alto--;
			fontNombre = ajustarFuente(fontNombre, alto);
			w = textWidth(fontNombre, nombre);
			h = textHeight(fontNombre, nombre);
		}	
		//System.out.println(height + " <= " + h);
		
		g.setColor(getForeground());
		g.setFont(fontNombre);
		g.drawString(nombre,x+((width-w)/2),y+height-((height-h)/2));
	}
	
	private Font ajustarFuente(Font font,int height) {
		
		while(getFontMetrics(font).getHeight()<height) {			
			font = new Font(font.getFontName(),font.getStyle(),font.getSize()+1);
		}
		
		while(getFontMetrics(font).getHeight()>height) {
			font = new Font(font.getFontName(),font.getStyle(),font.getSize()-1);
		}
		
		return font;
	}
	
	public  void pintarPrecio(Graphics g,BigDecimal precio,int x,int y,int width,int height) {
		//System.out.println(x+" "+y+" "+width+" "+height);
		g.setColor(getForeground());
		int alto = fontPrecio.getSize();
		String precioTexto = String.valueOf(precio.doubleValue());
		
		String textoPrecio = precio.intValue()+".";
		String textoComa = precioTexto.substring(precioTexto.lastIndexOf('.')+1);
		
		if(textoComa.length() == 1)textoComa+='0';
		else if(textoComa.length() >2)textoComa = textoComa.substring(0, 2);
		int w = 0;
		int h = 0;
		while(w<width && h<height) {
			w = 0;
			h = 0;
			alto++;
			
			fontPrecio = ajustarFuente(fontPrecio,alto);
			fontDolar =	ajustarFuente(fontDolar,alto*3/5);
						
			w+=textWidth(fontDolar, DOLAR);
			w+=textWidth(fontPrecio, textoPrecio);
			w+=textWidth(fontDolar, textoComa);
			
			h = textHeight(fontPrecio, textoPrecio) + textHeight(fontDolar, textoComa) - (2*textHeight(fontDolar, DOLAR)/3);
			
		}
		//System.out.println(w + ">=" + width);
		while(w>=width || h>=height) {
			w = 0;
			alto--;
			
			fontPrecio = ajustarFuente(fontPrecio,alto);
			fontDolar =	ajustarFuente(fontDolar,alto*3/5);
						
			w+=textWidth(fontDolar, DOLAR);
			w+=textWidth(fontPrecio, textoPrecio);
			w+=textWidth(fontDolar, textoComa);						
			
			h = textHeight(fontPrecio, textoPrecio) + textHeight(fontDolar, textoComa) - (2*textHeight(fontDolar, DOLAR)/3);
		}	
		
		
		
		
		
		int toCenterY = y + (height/2)-(h/2);
		//System.out.println(h + "--" + height);	
		//System.out.println(toCenterY);	
		//System.out.println(fontDolar.getSize() + " " + alto);
		
		int dolarY = toCenterY+textHeight(fontDolar, DOLAR) ;
		int precioY = dolarY + textHeight(fontPrecio, textoPrecio) - (2*textHeight(fontDolar, DOLAR)/3);
		
		/*
		g.setColor(Color.red);
		g.fillRect(0, 0 , width, height);
		*/
		g.setFont(fontDolar);
		g.setColor(getForeground());
		
		x = (width/2) - (w/2);
		
		
		g.drawString(DOLAR, x, dolarY);		
		x+=textWidth(fontDolar, DOLAR);
		
		g.setFont(fontPrecio);
		
		g.drawString(textoPrecio, x, precioY);
		x+=textWidth(fontPrecio, textoPrecio);
		
		g.setFont(fontDolar);
		
		g.drawString(textoComa, x, dolarY);
		
		
		
	}
	
	public final int textHeight(Font f,String texto) {
		return getFontMetrics(f).getAscent();
	}
	
	public final int textWidth(Font f,String texto) {
		int width = 0;
		int[] arr = getFontMetrics(f).getWidths();
		
		for(int i=0;i<texto.length();i++)
			width+=arr[texto.charAt(i)];
		
		return width;
	}
	
	private void pintarFecha(Graphics g) {
		
	}
	private void pintarBorde(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(0, 0, 0, getHeight());
		g.drawLine(0, 0, getWidth(), 0);
		g.drawLine(getWidth()-1, 0, getWidth()-1, getHeight());
		g.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
	}
	
	@Override
	public void paint(Graphics g) {        
        ((Graphics2D)g).setPaint(fondo);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		pintarNombre(g,gasto.getNombre(),0,getHeight()*2/3,getWidth(),getHeight()/3);
		pintarPrecio(g,gasto.getCosteTotal(),0,0,getWidth()*2/3,getHeight()*2/3);
		pintarFecha(g);
		pintarBorde(g);
		super.paint(g);
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
		//root.add(p);
		p.setLayout(null);
		p.setBackground(Color.white);
		VisorGasto vg = new VisorGasto(new Gasto("Ecleare","Tipo 1","200",10));
		vg.setSize(150,60);
		vg.setLocation(1,1);
		root.add(vg);
		
		root.setVisible(true);
		root.setDefaultCloseOperation(root.EXIT_ON_CLOSE);
	}
	
}
