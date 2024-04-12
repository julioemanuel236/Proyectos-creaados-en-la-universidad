package main;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

import login.Login;
import mainwindow.MainWindow;

public class Main {
	public static String  imageruta="/images/rey_mode/";
	public static void main(String[] args) {
		
		try {
			eventos.MouseTrackingThread.run();
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File(Main.class.getResource(imageruta+"fonts/Arciform.otf").getFile())));			
			Login login = new Login();
			login.mostrar();
			data.Usuario usuario = login.getUser();
			System.out.println("USUARIO OBTENIDO");
			MainWindow mainw = new MainWindow(usuario);
			System.out.println("VENTANA CREADA");
			mainw.waitUntilReady();
			System.out.println("VENTANA LISTA PARA MOSTRAR");
			login.ocultar();
			System.out.println("LOGIN OCULTADO COMPLETAMENTE");
			mainw.mostrar();
								
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
