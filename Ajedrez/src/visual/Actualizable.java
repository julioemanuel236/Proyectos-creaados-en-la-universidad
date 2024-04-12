package visual;

import java.awt.Graphics;

public abstract class Actualizable {
	
	public abstract void actualizar(long time);
			
	protected void actualizar() {
		actualizar(System.currentTimeMillis());
	}
	
}
