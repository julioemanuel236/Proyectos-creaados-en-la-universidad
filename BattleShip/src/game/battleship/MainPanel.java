package game.battleship;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends Panel {

	
	static class Button extends JButton{
		String value;
		public Button(String s) {
			super(s);
			ini();
			this.setFocusable(false);
		}
		
		private void ini() {
			Font f = new Font("Arial",Font.BOLD,20);
			this.setFont(f);
			setBackground(Color.white);
			setForeground(Color.black);
			
		}
		public Button(String s,String n) {
			super(s);
			ini();
			value=n;
			
		}
	}
	
	public MainPanel(int width,int height,App app){
		super(width,height,app);
		home.setVisible(false);
		buttons();
		background(width,height);
	
	}
	
	public void enableIni() {
		getComponents()[1].setEnabled(true);
	}
	
	private void buttons() {
		Button iniPartida = new Button("Iniciar Partida");
		iniPartida.setSize(getWidth()/2,60);
		iniPartida.setEnabled(false);
		iniPartida.setLocation(getWidth()/4,2*getHeight()/7);
		add(iniPartida);		
		
		Button newPartida = new Button("Nueva Partida");
		newPartida.setSize(getWidth()/2,60);
		newPartida.setLocation(getWidth()/4,3*getHeight()/7);
		add(newPartida);
		
		Button puntajes = new Button("Puntuajes");
		puntajes.setSize(getWidth()/2,60);
		puntajes.setLocation(getWidth()/4,4*getHeight()/7);
		add(puntajes);
		
		Button selecTableros = new Button("Coleccion de Tableros");
		selecTableros.setSize(getWidth()/2,60);
		selecTableros.setLocation(getWidth()/4,5*getHeight()/7);
		add(selecTableros);
		
		Button salir = new Button("Salir");
		salir.setSize(getWidth()/2,60);
		salir.setLocation(getWidth()/4,6*getHeight()/7);
		add(salir);
		
		
		iniPartida.addActionListener((ActionEvent)->{
			app.iniciarPartida();
		});
		
		newPartida.addActionListener((ActionEvent)->{
			app.nuevaPartida();
		});
		
		puntajes.addActionListener((ActionEvent)->{
			app.puntajes();
		});
		
		selecTableros.addActionListener((ActionEvent)->{
			app.seleccionTableros();
		});
		
		salir.addActionListener((ActionEvent)->{
			try{
				App.registro.close();
			}
			catch(Exception e) {
				
			}
			System.exit(0);
		});
	}
	
	private void background(int w,int h) {
		
		JLabel background = new JLabel();
		background.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("/images/Background.png")).getImage().
                getScaledInstance(w, h, Image.SCALE_SMOOTH))));
		background.setSize(w,h);
		add(background);
	}
	
}
