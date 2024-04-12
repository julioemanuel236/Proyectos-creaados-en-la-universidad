
package ventana;

import java.awt.Color;
import java.awt.Font;

public final class configs {

	public static int MODE = 0;
		
	public static Color 	BACKGROUND= Color.DARK_GRAY;
	public static Color		FOREGROUND = Color.white;
	public static Color		FOREGROUND_HINT = Color.lightGray;;
	public static Color		MAIN_COLOR = new Color(20, 144, 255);
	//public static Color		MAIN_COLOR = new Color(80,80,80);
	public static Color 	ALTERN_COLOR = MAIN_COLOR.darker();
	public static String 	FONTNAME = "Arial";
	public static String 	SKINRUTE;
	public static String 	RUTE= "/images/rey_mode/";
	
	public static String getImgRute(int skinId) {
		SKINRUTE = "skin_"+skinId+"/";
		return RUTE+SKINRUTE;
	}
}
