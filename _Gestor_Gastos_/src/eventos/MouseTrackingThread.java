package eventos;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import mainwindow.Component;

public final class MouseTrackingThread {
	
	Component component;
		
	public static LinkedList<MouseEvent> MOUSEEVENTS= new LinkedList<>();
	
	public static Thread mouseTrakcingThread = new Thread() {
		
		public void run() {
			
			while(true) {
				 
				Point p = MouseInfo.getPointerInfo().getLocation();				
				int n = Component.COMPONENTS.size();
							
				for(int i=0;i<n;i++) {
					Component c = Component.COMPONENTS.poll();
					(new Thread() {
						public void run() {
							c.processMouseMove(p.x, p.y);
						}
					}).start();	
					Component.COMPONENTS.add(c);
				}
			
				while(!MOUSEEVENTS.isEmpty()) {
					MouseEvent e = MOUSEEVENTS.poll();
					n = Component.COMPONENTS.size();
					//System.out.println("COMPONENTES A ACTUALIZAR "+n);
					
					for(int i=0;i<n;i++) {
						Component c = Component.COMPONENTS.poll();
	
						if(c.over(p.x, p.y)) {
							(new Thread() {
								public void run() {
									c.proccesMouseEvent(e);
								}
							}).start();							
							
						}
						Component.COMPONENTS.add(c);
					}
				}
				
				
				try {
					sleep(1000/144);					
				}
				catch(Exception e) {
					e.printStackTrace();
				}

			}
			
		}
		
	};
	
	public static void run() {
		if(!mouseTrakcingThread.isAlive()) {
			mouseTrakcingThread.start();			
		}
		
	}
	
	
}
