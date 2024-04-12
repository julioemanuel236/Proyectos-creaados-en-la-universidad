package correo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Interfaz_Grafica extends JFrame{
	Correo correo = new Correo();
	String op="Carta";
	JTextArea texto = new JTextArea();
	JScrollPane ver = new JScrollPane(texto);
	int urgencia=0;
	
	public void ini() {
                texto.setEditable(false);
		ver.setSize(500,400);
		ver.setLocation(20,50);
		texto.setSize(500,400);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.add(ver);
		panel.setLayout(null);
		
		JButton nuevoc = new JButton("Nueva");
		nuevoc.setSize(120,35);
		nuevoc.setLocation(10,5);
		nuevoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = JOptionPane.showInputDialog("Destinatario");
				String direccion = JOptionPane.showInputDialog("Direccion");
				String remitente = JOptionPane.showInputDialog("Remitente");
				
				JComboBox<String> j = new JComboBox<>();
				j.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						op = (String) j.getSelectedItem();
						
					}
					
				});
				j.addItem("Carta");
				j.addItem("Telegrama");
				j.addItem("Bulto Postal");
	
				JOptionPane.showInputDialog(j);
				Correspondencia c = null;
				try {
					if(op.equals("Carta")) {
						String fechaEnvio = JOptionPane.showInputDialog("Fecha de Envio");
						boolean exterior = Boolean.parseBoolean(JOptionPane.showInputDialog(null,"Es del exterior",null,JOptionPane.YES_NO_OPTION));
						c = new Carta(nombre,direccion,remitente,fechaEnvio,exterior);
					}
					
					if(op.equals("Telegrama")) {
						int palabras = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Palabras"));
						float impuesto = Float.parseFloat(JOptionPane.showInputDialog("Impuesto"));
						c = new Telegrama(nombre,direccion,remitente,palabras,impuesto);
					}
					
					if(op.equals("Bulto Postal")) {
						float peso = Float.parseFloat(JOptionPane.showInputDialog("Peso"));
						urgencia=0;
						JComboBox<String> jc = new JComboBox<>();
						j.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								urgencia = jc.getSelectedIndex();
								
							}
							
						});
						jc.addItem("Muy Urgente");
						jc.addItem("Urgente");
						jc.addItem("No Urgente");
			
						JOptionPane.showInputDialog(j);
						
						c = new BultoPostal(nombre,direccion,remitente,peso,urgencia);
					}
					correo.nuevaCorrespondencia(c);
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "Error en la introduccion de datos");
					return;
				}
			}
		});
		panel.add(nuevoc);
		
		JButton despachar = new JButton("Despachar");
		despachar.setSize(120,35);
		despachar.setLocation(10+120+10,5);
		despachar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setText(correo.despachar());
				texto.repaint();
			}
			
		});
		panel.add(despachar);
		
		JButton personal = new JButton("Entregar");
		personal.setSize(120,35);
		personal.setLocation(10+120+10+120+10,5);
		personal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = JOptionPane.showInputDialog("Nombre del destinatario");
				String direccion = JOptionPane.showInputDialog("Direcion a enviar");
				texto.setText(correo.entregaPersonal(nombre, direccion));
				texto.repaint();
			}
			
		});
		panel.add(personal);
		
		JButton Calculo = new JButton("Calculo");
		Calculo.setSize(120,35);
		Calculo.setLocation(10+120+10+120+10+120+10,5);
		Calculo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setText(""+correo.calculoAcumulado());
				texto.repaint();
			}
			
		});
		panel.add(Calculo);
	}
	
	public Interfaz_Grafica(){
		setSize(550,500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ini();
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Interfaz_Grafica();
	}
}
