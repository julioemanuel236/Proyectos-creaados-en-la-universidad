package gui;

import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class SegmentoSimulacion extends Component{
        
    private Color color;
    private double total=1;
    private double mio;
    private int actual;
    private int objetivo;
    private int mayor;
    public SegmentoSimulacion(int mio){       
        color = Color.blue;
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(color);
        objetivo = (int)(((mio / total))*getHeight());
        //System.out.println("ALTO: "+actual);
        g2.fillRect(0, getHeight()-actual, getWidth(), getHeight());
        if(actual != objetivo) {
        	int dif = (actual<objetivo?1:-1);
        	actual+=dif;
        	try {
        		Thread.sleep(1);
        	}
        	catch(Exception e) {
        		
        	}
        	repaint();
        }
    }
    
    public void paint(int total){        
        this.total=total;
        repaint();
    }
    
    public void paint(int total,int mayor) {
    	this.total = total;
    	this.mayor = mayor;
    	repaint();
    }
    
    
    public int getMio() {
		return (int)mio;
	}

	public void incrementar(){
        this.mio++;        
    }
    
    
}
