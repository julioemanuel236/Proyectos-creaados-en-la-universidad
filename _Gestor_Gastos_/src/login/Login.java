package login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.Usuario;
import mainwindow.MainWindow;
import ventana.*;


public class Login extends JDialog {
	
		private static final long serialVersionUID = 2L;
		private JPanel back;
		private JLabel logintxt;
		private TextField user;
		private ChargeBar chb ;
		private Imagen close;
		private Usuario usuario;
		public JButton SignUp;
		int width = 300;
		int height = 175;
		int movinsu = 0;
		int su1 = 120;
		int su2 = height + 1;

		public Login() {
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setAlwaysOnTop(true);
			this.setFocusable(true);
			this.setUndecorated(true);
			Listeners.addWindowsMove(this);
			this.setSize(width, height);
			this.setBackground(configs.BACKGROUND);
			this.setLayout(null);
			back();
			Closebt();
			logintxt();
			user();
			signup();
			back.add(user);
			this.setLocationRelativeTo(null);
			user.text.requestFocus();
			Imagen img = new Imagen(width,height,configs.getImgRute(0)+"login_background.png");
			back.add(img);
			user.text.grabFocus();
			//this.setVisible(true);
		}
		
		private void back() {
			back = new JPanel();
			back.setSize(this.getSize());
			back.setLayout(null);
			back.setBackground(configs.BACKGROUND);
			chb = new ChargeBar(Login.this.getWidth(),10);
			chb.setLocation(0,Login.this.getHeight()-chb.getHeight());
			chb.setVisible(false);
			chb.barcolor=configs.MAIN_COLOR;
			back.add(chb);
			this.add(back);
		}

		private void Closebt() {
			close = new Imagen(30,30,configs.getImgRute(0)+"close_button.png");
			close.setLocation(this.getWidth()-close.getWidth(),0);
			
			Listeners.add_Exit(close);			
			back.add(close);
		}

		private void logintxt() {
			logintxt = new JLabel();
			logintxt.setSize(100, 50);
			logintxt.setFont(new Font("arial", Font.ITALIC, 30));
			logintxt.setText("Login");
			logintxt.setHorizontalAlignment(SwingConstants.CENTER);
			logintxt.setVerticalAlignment(SwingConstants.CENTER);
			logintxt.setForeground(configs.FOREGROUND);

			logintxt.setLocation((int) ((back.getWidth() / 2) - (logintxt.getWidth() / 2)), 0);
			back.add(logintxt);
		}

		private void user() {
			user = new TextField(250, 50, "User", configs.getImgRute(0)+"user.png");
			user.setLocation(user.centrarx(back), user.centrary(back));
			user.requestFocus();
			user.text.setForeground(configs.FOREGROUND);
			user.hint.setForeground(configs.FOREGROUND_HINT);
			user.text.setCaretColor(configs.FOREGROUND);
		}

		private void signup() {
			SignUp = new JButton();

			SignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			SignUp.setSize(75, 30);
			SignUp.setText("Sign In");
			SignUp.setBackground(configs.MAIN_COLOR);
			SignUp.setOpaque(true);
			SignUp.setLocation((back.getWidth() / 2) - (SignUp.getWidth() / 2), su2);
			SignUp.setBorderPainted(false);
			SignUp.setForeground(Color.white);
			SignUp.setEnabled(false);
			SignUp.setFocusable(false);
			SignUp.setActionCommand("\n");
			ActionListener Next = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					chb.setVisible(true);
					chb.start();
					funciones.capitalizar(user.text.getText().toCharArray());
					
					try {
						
						Login.this.SignUp.removeActionListener(Login.this.SignUp.getActionListeners()[0]);
						usuario = new Usuario(user.text.getText());						
						
					}
					
					catch(Exception exc) {
						exc.printStackTrace();
					}
					
					SignUp.setEnabled(false);
					user.text.setEnabled(false);
				}
				
			};
			SignUp.addActionListener(Next);
			user.KeyButton(SignUp, '\n');
			ComponentListener habilitar = new ComponentListener() {

				@Override
				public void componentResized(ComponentEvent e) {

				}

				@Override
				public void componentMoved(ComponentEvent e) {

				}

				@Override
				public void componentShown(ComponentEvent e) {
					SignUp.setEnabled(false);
					movinsu = -1;
					(new Thread() {
						public void run() {
							while (movinsu == -1 && SignUp.getY() < su2) {
								SignUp.setLocation(SignUp.getX(), SignUp.getY() + 4);
								SignUp.repaint();
								try {
									sleep(1);
								} catch (Exception e) {

								}
							}
						}
					}).start();
				}

				@Override
				public void componentHidden(ComponentEvent e) {
					SignUp.setEnabled(true);
					movinsu = 1;
					(new Thread() {
						public void run() {
							while (movinsu == 1 && SignUp.getY() > su1) {
								SignUp.setLocation(SignUp.getX(), SignUp.getY() - 3);
								SignUp.repaint();
								try {
									sleep(1);
								} catch (Exception e) {

								}
							}

						}
					}).start();
				}

			};
			user.hint.addComponentListener(habilitar);
			back.add(SignUp);
		}

		public Usuario getUser() {
			while(usuario == null) {
				try {					
					Thread.sleep(1000/144);
				}
				catch(Exception e) {
					
				}
			}
			return usuario;
		}
		
		public void mostrar() {
			long tInicio = System.currentTimeMillis();
			long tActual = 0;
			long tFinal = 500;
			setVisible(true);
			setOpacity(0);
			while(tActual<=tFinal){
								
				try {
					float opacity = ((float)tActual/(float)tFinal);				
					setOpacity(opacity);
					Thread.sleep(1000/144);
					
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
				tActual = System.currentTimeMillis() - tInicio;			
							
			}
			
			setOpacity(1);
					
		}
		
	public void ocultar() {
		long tInicio = System.currentTimeMillis();
		long tActual = 0;
		long tFinal = 500;
		setVisible(true);
		setOpacity(0);
		while(tActual<=tFinal){
			
			
			try {
				float opacity = 1-((float)tActual/(float)tFinal);				
				setOpacity(opacity);
				Thread.sleep(1000/144);
				
			}
			catch(Exception ee) {
				ee.printStackTrace();
			}
			tActual = System.currentTimeMillis() - tInicio;			
						
		}
		setOpacity(0);
		dispose();
	}
	

}



