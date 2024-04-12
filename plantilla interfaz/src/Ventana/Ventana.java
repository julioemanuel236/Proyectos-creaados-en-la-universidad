package Ventana;

import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{
	
	JPanel background = new JPanel();
	JPanel left = new JPanel();
	JLabel closebt = new JLabel();
	TextField entry1;
	PasswordField entry2;
	Imagen fondo1;
	MouseListener MOVE,REDBG;
	ActionListener close;
	int X,Y;
	
	public Ventana() {
		this.setSize(800,400);
		listeners();
		ini_left();
		ini_background();
		//this.setLayout(null);
		this.setUndecorated(true);
		this.add(background);
		this.setLocationRelativeTo(null);
		this.setVisible(true);		
		
	}
	
	private void ini_background() {
		this.background.setLayout(null);
		this.background.setSize(this.getWidth(),this.getHeight());
		this.background.setBackground(new Color(8,149,215));
		this.background.addMouseListener(this.MOVE);
		this.fondo1 = new Imagen(this.getWidth()-left.getWidth(),this.getHeight(),"Image/fondo1.png",this.left.getWidth(),0);
		this.fondo1.setText("HOLA");
		this.fondo1.setForeground(Color.white);
		this.background.add(fondo1);
		this.background.add(left);
		//System.out.println(left.getWidth());
	}
	
	private void listeners() {
			Ventana.this.MOVE=new MouseListener() {
				boolean pressed=true;
				@Override
				public void mouseClicked(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
					this.pressed=true;
					(new Thread() {
						public void run() {
							int vx=Ventana.this.getX();
							int vy=Ventana.this.getY();
							int mx=e.getX();
							int my=e.getY();
							while(pressed) {
								int px=(int) MouseInfo.getPointerInfo().getLocation().getX();
								int py=(int) MouseInfo.getPointerInfo().getLocation().getY();
								Ventana.this.setLocation((int)(px-mx) ,(int) (py-my));
							}
						}
					}).start();
					
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					this.pressed=false;
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			
			};
			
			Ventana.this.REDBG=new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent ev) {

					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					System.exit(0);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					//FONDO BLANCO
					Ventana.this.closebt.setBackground(Color.white);
					Ventana.this.closebt.setOpaque(true);
					(new Thread() {
						
						public void run() {
							for(int i=255;i>=0;i-=3) {
								Ventana.this.closebt.setBackground(new Color(230,i,i));
								try {
									this.sleep(1);
									Ventana.this.closebt.updateUI();
								}catch(Exception e) {
									
								}
							}
						}
						
					}).start();
					
					//System.out.println("se supone se ponga rojo");
				}

				@Override
				public void mouseExited(MouseEvent e) {
					Ventana.this.closebt.setOpaque(false);
					Ventana.this.closebt.updateUI();
					//System.out.println("se supone se ponga transparente");
				}
				
			};
	}
	
	private void ini_left() {
		this.left.setBackground(Color.WHITE);
		this.left.setSize(550,this.getHeight());
		this.left.setLayout(null);
		this.left.setLocation(0,0);
		closebt.setHorizontalAlignment(SwingConstants.CENTER);
		closebt.setVerticalAlignment(SwingConstants.CENTER);
		closebt.setText("X");
		closebt.setFont(new Font("Roboto",Font.PLAIN,15));
		closebt.setSize(50,30);
		closebt.setBackground(Color.RED);
		closebt.setLocation(0,0);
		closebt.addMouseListener(REDBG);
		entry1 = new TextField((int) (left.getWidth()*0.6),40,"Usuario","Image/user.png");
		entry1.setLocation(entry1.centrarx(left),100);
		entry2 = new PasswordField((int) (left.getWidth()*0.6),40,"Contraseña","Image/key.png");
		entry2.setLocation(entry1.centrarx(left),220);
		this.left.add(entry1);
		this.left.add(entry2);
		this.left.add(closebt);
		entry1.text.requestFocus();
		//System.out.println(left.getHeight()+" "+left.getWidth());
	}
	
	public int centrarx(JComponent a,JComponent b) {
		return (int)((a.getWidth()/2)-(b.getWidth()/2));
	}
	
	public int centrary(JComponent a,JComponent b) {
		return (int)((a.getHeight()/2)-(b.getHeight()/2));
	}
	
	public static void main(String[] args) {
		new Ventana();
	}
	
}
