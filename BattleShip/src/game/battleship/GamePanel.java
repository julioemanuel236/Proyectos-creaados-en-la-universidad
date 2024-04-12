package game.battleship;

import java.awt.Color;
import java.awt.Font;

import game.battleship.MainPanel.Button;

public class GamePanel extends Panel {
	int seleccion;
	Button normal,torpedo,misil,hecaton;
	public GamePanel(int w, int h,App app) {
		super(w, h,app);
		setSize(w,h);
		App.board.setLocation(0,50);
		System.err.println(App.board.getSize());
		System.err.println(App.board.getLocation());
		setBackground(Color.cyan);
		add(App.board);
		buttons();
	}
	
	private void buttons() {
		normal  = new Button("Normal "+app.player.bombs[0]);
		normal.setSize((getWidth()-50)/4,50);
		normal.setLocation(50,0);
		normal.addActionListener((ActionEvent)->{
			if(App.player.bombs[0]>0){
				App.seleccion=0;
				normal.setEnabled(false);
				torpedo.setEnabled(true);
				misil.setEnabled(true);
				hecaton.setEnabled(true);
			}
		});
		torpedo = new Button("Torpedo "+app.player.bombs[1]);
		torpedo.setSize((getWidth()-50)/4,50);
		torpedo.setLocation(50+(((getWidth()-50)/4)*1),0);
		torpedo.addActionListener((ActionEvent)->{
			if(App.player.bombs[1]>0) {
				App.seleccion=1;
				normal.setEnabled(true);
				torpedo.setEnabled(false);
				misil.setEnabled(true);
				hecaton.setEnabled(true);
			}
		});
		misil   = new Button("Misil "+app.player.bombs[2]);
		misil.setSize((getWidth()-50)/4,50);
		misil.setLocation(50+(((getWidth()-50)/4)*2),0);
		misil.addActionListener((ActionEvent)->{
			if(App.player.bombs[2]>0) {
				App.seleccion=2;
				normal.setEnabled(true);
				torpedo.setEnabled(true);
				misil.setEnabled(false);
				hecaton.setEnabled(true);
			}
		});
		hecaton = new Button("Hecaton"+app.player.bombs[3]);
		hecaton.setSize((getWidth()-50)/4,50);
		hecaton.setLocation(50+(((getWidth()-50)/4)*3),0);
		hecaton.addActionListener((ActionEvent)->{
			if(App.player.bombs[3]>0) {
				App.seleccion=3;
				normal.setEnabled(true);
				torpedo.setEnabled(true);
				misil.setEnabled(true);
				hecaton.setEnabled(false);
			}
		});
		
		switch(App.seleccion) {
			case 1:normal.setEnabled(false);break;
			case 2:torpedo.setEnabled(false);break;
			case 3:misil.setEnabled(false);break;
			case 4:hecaton.setEnabled(false);break;
		}
		
		add(normal);
		add(torpedo);
		add(misil);
		add(hecaton);
		Font f = new Font("Arial",Font.BOLD,10);
		normal.setFont(f);
		torpedo.setFont(f);
		misil.setFont(f);
		hecaton.setFont(f);
	}
	
	
	public void actualizarTextos(){
		normal.setText("Normal "+App.player.bombs[0]);
		torpedo.setText("Torpedo "+app.player.bombs[1]);
		misil.setText("Misil "+app.player.bombs[2]);
		hecaton.setText("Hecaton"+app.player.bombs[3]);
		int arr[] = App.player.bombs;
		if(arr[0]==arr[1]&&arr[1]==arr[2]&&arr[2]==arr[3]&&arr[3]==0)
			App.board.lose();
	}
	

	
	
}
