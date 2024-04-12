package game.battleship;

import java.awt.Container;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Utiles {
	static int vx,vy,mx,my,px,py;

	public static void addWindowsMove(Container j) {
		
		MouseListener MOVE=new MouseListener() {
			boolean pressed=true;
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				this.pressed=true;
				(new Thread() {
					public void run() {
						 vx=j.getX();
						 vy=j.getY();
						 mx=e.getX();
						 my=e.getY();
						while(pressed) {
							px=(int) MouseInfo.getPointerInfo().getLocation().getX();
							py=(int) MouseInfo.getPointerInfo().getLocation().getY();
							j.setLocation((int)(px-mx) ,(int) (py-my));
						}
					}
				}).start();
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				this.pressed=false;
				
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
		j.addMouseListener(MOVE);
	}

}
