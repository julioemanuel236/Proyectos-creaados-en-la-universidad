package visual;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

import javax.imageio.ImageIO;

public final class GestorMedia {

	private static final BufferedImage[][] piezas = new BufferedImage[6][2];
	private static final int CANTIDAD_PIEZAS = 6;
	private final static int TORRE = 0,CABALLO = 1, ALFIL = 2, REYNA = 3, REY = 4,PEON = 5;
	
	public static void cargarMedia() {
	
		try {
			for(int i=0;i<CANTIDAD_PIEZAS;i++)
				for(int j=0;j<2;j++) {
					piezas[i][j] = ImageIO.read(GestorMedia.class.getResource("/imagenes/"+i+"_"+j+".png"));
				}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("NO SE ENCUENTRA EL FICHERO DE LAS IMAGENES DE LAS PIEZAS");
		}
		
	}
		
	public static Image getPeonImage(boolean color) {
		
		return piezas[PEON][(color?1:0)];
		
	}
	
	public static Image getReyImage(boolean color) {
		
		return piezas[REY][(color?1:0)];
		
	}
	
	public static Image getReynaImage(boolean color) {
		
		return piezas[REYNA][(color?1:0)];
		
	}
	
	public static Image getAlfilImage(boolean color) {
		
		return piezas[ALFIL][(color?1:0)];
		
	}
	
	public static Image getCaballoImage(boolean color) {
		
		return piezas[CABALLO][(color?1:0)];
		
	}
	
	public static Image getTorreImage(boolean color) {
		
		return piezas[TORRE][(color?1:0)];
		
	}
	
}
