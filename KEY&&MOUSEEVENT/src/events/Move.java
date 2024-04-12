package events;
import java.lang.Thread;
import javax.swing.JComponent;
import java.awt.Point;

public class Move {
	
	public static void mover(JComponent obj,int goalx,int goaly,int stepsx,int stepsy,int delay){
		(new Thread() {
			
			Point p=obj.getLocation();
			int px=stepsx;
			int py=stepsy;
			int tox=goalx;
			int toy=goaly;
			public void run() {
				if(goalx<p.x) {
					px=-px;
					tox=-tox;
				}
				if(goaly<p.y) {
					py=-py;
					toy=-toy;
				}
				for(int i=p.x,j=p.y;i<tox||j<toy;) {
						if(i<tox)i+=px;
						if(j<toy)j+=py;
						try {
							Thread.sleep(delay);
							obj.setPreferredSize(obj.getSize());
							obj.setLocation(i,j);
							obj.updateUI();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}										
				}
			}
			
		}).start();
		
		}


	public static void mover(App obj,int goalx,int goaly,int stepsx,int stepsy,int delay){
		(new Thread() {
			
			Point p=obj.getLocation();
			int px=stepsx;
			int py=stepsy;
			int tox=goalx;
			int toy=goaly;
			public void run() {
				if(goalx<p.x) {
					px=-px;
					tox=-tox;
				}
				if(goaly<p.y) {
					py=-py;
					toy=-toy;
				}
				for(int i=p.x,j=p.y;i<tox||j<toy;) {
						if(i<tox)i+=px;
						if(j<toy)j+=py;
						try {
							Thread.sleep(delay);
							obj.setPreferredSize(obj.getSize());
							obj.setLocation(i,j);
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}										
				}
			}
			
		}).start();
		
		}

}
