package game.battleship;

import java.awt.Image;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import game.battleship.MainPanel.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PuntajePanel extends Panel {

	Button arr[] = new Button[3];
	
	private class Puntos{
		String nombre;
		int pts;
		public Puntos(String s,int n){
			nombre=s;
			pts=n;
		}
	}
	
	public PuntajePanel(int w, int h, App app) {
		super(w, h, app);
		
		Button first = new Button("");
		Button second = new Button("");
		Button third = new Button("");
		first.setEnabled(false);
		second.setEnabled(false);
		third.setEnabled(false);
		arr[0]=first;
		arr[1]=second;
		arr[2]=third;
		first.setSize(getWidth()/2,60);
		second.setSize(getWidth()/2,60);
		third.setSize(getWidth()/2,60);
		first.setLocation((getWidth()/4),2*(getHeight())/7);
		second.setLocation((getWidth()/4),4*(getHeight())/7);
		third.setLocation((getWidth()/4),6*(getHeight())/7);
		
		add(first);
		add(second);
		add(third);
		background(w,h);
	}

	public boolean reload() {
		try {
			ArrayList<Puntos> players = new ArrayList<>();
			
			FileReader fr = new FileReader("punteos.war");
			Scanner entry = new Scanner(fr);
			
			while(entry.hasNext()) {
				String s = entry.next();
				int pt = Integer.parseInt(entry.next());
				boolean si=false;
				for(Puntos i:players) {
					if(i.nombre.equals(s)) {
						i.pts+=pt;
						si=true;
						break;
					}
				}
				if(!si)players.add(new Puntos(s,pt));
			}
			fr.close();
			entry.close();
			Comparator<Puntos> cmp = new Comparator<>() {

				@Override
				public int compare(Puntos o1, Puntos o2) {
					if(o1.pts>o2.pts)return -1;
					else if(o1.pts<o2.pts)return 1;				
					return 0;
				}
				
			};
			Collections.sort(players,cmp);
			for(int i=0;i<Math.min(players.size(), 3);i++) {
				arr[i].setText(players.get(i).nombre+" "+players.get(i).pts);
			}
			return true;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "HA OCURRIDO UN ERROR AL INTENTAR CARGAR EL FICHERO DE PUNTAJES");
			return false;
		}
		
	}
	
	private void background(int w,int h) {
		
		JLabel background = new JLabel();
		background.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("/images/Background.png")).getImage().
                getScaledInstance(w, h, Image.SCALE_SMOOTH))));
		background.setSize(w,h);
		add(background);
	}
	
		
}
