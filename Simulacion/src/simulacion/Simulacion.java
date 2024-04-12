package simulacion;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.FontMetrics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Font;

public class Simulacion extends JFrame{

	int cantidad;
	int tiempos[] = new int[4];
	
	private Menu menu;
	
 	private static int ancho(JLabel j) {
		int ancho=0;
		String s=j.getText();
		for(int i=0;i<s.length();i++) {
			ancho+=j.getFontMetrics(j.getFont()).charWidth(s.charAt(i));
		}
		return ancho;
	}
	
	private static int alto(JLabel j) {
		FontMetrics f =j.getFontMetrics(j.getFont());
		return f.getHeight();
	}
	
	private static int centrarX(Container container,JComponent obj) {
		return (int)((container.getWidth()/2)-(obj.getWidth()/2));
		
	}
	
	private static int centrarY(Container container,JComponent obj) {
		return (int)((container.getHeight()/2)-(obj.getHeight()/2));
	}
	
	class Menu extends JPanel{
		JTextField txts[] = new JTextField[5];
		JFrame frame = new JFrame();
		Menu(){
			frame.add(this);
			frame.setResizable(false);
			setLayout(null);
			frame.setSize(500,400);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBackground(Color.gray);			
			ini();
			frame.setVisible(true);
		}

		private void ini() {
			String ops[]= {"Cantidad","T Inventario","T Producción","T Empaquetado","T Salida"};
			int x=(frame.getWidth()/2) - 150,y=10;
			for(int i=0;i<ops.length;i++) {
				JLabel jlb = new JLabel(ops[i]);
				Font font = new Font("Arial",Font.PLAIN,20);
				jlb.setLocation(x,y);
				jlb.setFont(font);
				int w=150;
				int h=alto(jlb);
				jlb.setSize(w,h);
				x+=w+10;
				JTextField txt = new JTextField();
				txt.setFont(font);
				txts[i]=txt;
				txt.setSize(w,h);
				txt.setLocation(x,y);
				x=(frame.getWidth()/2) -150;
				y+=h+10;
				add(jlb);
				add(txt);
			}
			
			JButton next = new JButton("Siguiente");
			next.setBackground(Color.yellow);
			next.setSize(150,60);
			next.setLocation(centrarX(frame,next),y+50);
			next.addActionListener((ActionEvent)->{
				try {
					for(int i=0;i<txts.length;i++)
						tiempos[i] = Integer.parseInt(txts[i].getText());
				}
				catch(Exception e) {
					JOptionPane.showInternalMessageDialog(next, "Valores invalidos");
				}
			});
			add(next);
			System.out.println(next.getLocation());
			Simulacion.this.Start();
		}
	}
	
	class Zona extends Container{
		Color color;
		String nombre;
		int cantidad;
		
		public Zona() {
			String.valueof
		}
	}
	private void Start() {
		
	}
	
	public Simulacion() {
		setSize(800,500);
		menu = new Menu();
	}
	
	public static void main(String[] args) {
		new Simulacion();
	}
}
