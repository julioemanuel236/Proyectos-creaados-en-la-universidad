package main;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

import login.Login;

public class Main {
	public static String  imageruta="/images/rey_mode/";
	public static void main(String[] args) {
		
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File(Main.class.getResource(imageruta+"fonts/Arciform.otf").getFile())));
			new Login();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
