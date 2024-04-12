package gui;
import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Bolita extends Component{
    private Color color;
    private int radio;
    private int profundidad = 0;
    private int index = 0;
    private boolean moviendo = false;
    
    private MouseListener ml = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println(Bolita.this.toString());
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    public Bolita(int diametro){
        radio = diametro/2;
        super.setSize(diametro,diametro);
        Random rand = new Random();      
        color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
        addMouseListener(ml);
    }    
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(color);        
        g2.fillArc(0, 0, getWidth(), getHeight(), 0, 360);
    }
    
    public void desaparecer(){
        setVisible(false);              
    }
    
    public void aumentarProfindidad(){
        profundidad++;
    }
    
    public int getIndex(){
        return index;
    }
    
    public void setIndex(int index){
        this.index=index;
    }
    
    public int getProfundidad(){
        return profundidad;
    }
    
    public boolean isMoviendo(){
        return moviendo;
    }
    
    public void setMoviendo(boolean moviendo){
        this.moviendo=moviendo;
    }
    
    public int getRadio(){
        return radio;
    }

	@Override
	public String toString() {
		return "Bolita [color=" + color + ", radio=" + radio + ", profundidad=" + profundidad + ", index=" + index
				+ ", moviendo=" + moviendo + "]";
	}
    
    
}
