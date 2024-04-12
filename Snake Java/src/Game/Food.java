package Game;
import javax.swing.JLabel;
import java.util.Random;
import java.awt.Color;

public class Food extends JLabel{
	int X=100;
	int Y=300;
	Field field;
	public Food(Field f){
		this.setOpaque(true);
		this.setBackground(Color.RED);
		this.setSize(20,20);
		this.setLocation(100,300);
		this.field=f;
		f.add(this);
		
	}
	
	private void poner(int x,int y){
		this.X=x;
		this.Y=y;
		this.setLocation(x, y);
		this.updateUI();
	}
		
	public void nueva(Snake s){
		Random r=new Random();
		while(true) {
			boolean b=true;
			int x=r.nextInt(field.getWidth()/20);	
			int y=r.nextInt(field.getHeight()/20);
			for(int i=0;i<s.size;i++) {
				if(s.Snake[i].X==x*20&&s.Snake[i].Y==y*20){
						b=false;
						break;
					}
				}
			if(b) {
				//System.out.println("X: "+X*20+' '+"Y: "+Y*20);
				poner(x*20,y*20);
				return;
			}
		}
	}
	
}
