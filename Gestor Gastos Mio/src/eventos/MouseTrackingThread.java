package eventos;

import java.awt.Component;

public final class MouseTrackingThread {
	
	Component component;
	
	public  MouseTrackingThread(Component c) {
		this.component =c;
	}
	
	public Thread mouseTrakcingThread = new Thread() {
		
		public void run() {
			while(true) {
				
				try {
					sleep(10);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	};
	
}
