package APP;

import javax.swing.JPanel;
import java.awt.Container;
import javax.swing.JLayeredPane;
public class Zone extends JPanel{
	int Limitev;
	int Limiteh;
	
	boolean UP=true;
	boolean DOWN=false;
	boolean RIGHT=true;
	boolean LEFT=false;
	Object padre;
	Imagen fondo;
	
	public Zone() {
		
	}
	public Zone(int w,int h) {
		this.setSize(w,h);
	}
	
	protected void UP() {
		
		UP = true;
		DOWN = false;
		(new Thread() {
			public void run() {
				int k = 30;
				while (UP && Zone.this.getY() >= -Zone.this.getHeight()) {

					Zone.this.setLocation(Zone.this.getX(), Zone.this.getY() - k);
					//if (k > 2)
						k++;
					try {
						sleep(10);
						Zone.this.repaint();
					} catch (Exception e) {

					}

				}
				if (!UP)
					return;
				Zone.this.setLocation(Zone.this.getX(), -Zone.this.getHeight());
			}
		}).start();
	}

	protected void RIGHT() {
		
		RIGHT = true;
		LEFT = false;
		(new Thread() {
			public void run() {
				int k = 30;
				while (RIGHT && Zone.this.getX() < Limiteh) {

					Zone.this.setLocation(Zone.this.getX()+k, Zone.this.getY());
					if(Zone.this.getX()>Limiteh)Zone.this.setLocation(Limiteh,Zone.this.getY());
					if(padre!=null)((JLayeredPane)padre).setLocation(getX()+getWidth(),((JLayeredPane)padre).getY());
					//if (k > 2)
						k++;
					try {
						sleep(10);
						Zone.this.repaint();
					} catch (Exception e) {

					}

				}
				if (!RIGHT)
					return;
				
			}
		}).start();
	}

	protected void LEFT() {
		
		LEFT = true;
		RIGHT = false;
		(new Thread() {
			public void run() {
				int k = 30;
				while (LEFT && Zone.this.getX() >= Limiteh-Zone.this.getWidth()) {

					Zone.this.setLocation(Zone.this.getX()-k, Zone.this.getY());
					if(padre!=null)((JLayeredPane)padre).setLocation(getX()+getWidth(),((JLayeredPane)padre).getY());
					//if (k > 2)
						k++;
					try {
						sleep(10);
						Zone.this.repaint();
					} catch (Exception e) {

					}

				}
				if (!LEFT)
					return;
				Zone.this.setLocation(Limiteh-Zone.this.getWidth(), Zone.this.getY());
			}
		}).start();
	}
			
	protected void DOWN() {
		DOWN = true;
		UP = false;
		(new Thread() {
			public void run() {
				
				int k = 10;
				while (DOWN && Zone.this.getY() < 5) {

					Zone.this.setLocation(Zone.this.getX(), Zone.this.getY() + k);
					//if (k > 2)
						k++;
					try {
						sleep(10);
						Zone.this.repaint();
					} catch (Exception e) {

					}
				}
				if (!DOWN)
					return;
				Zone.this.setLocation(Zone.this.getX(), 5);
			}
		}).start();
	}
}
