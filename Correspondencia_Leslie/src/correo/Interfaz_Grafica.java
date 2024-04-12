package correo;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Interfaz_Grafica extends JFrame{
	Correo correo = new Correo();
	String op="Carta";
	JTextArea texto = new JTextArea();
	JScrollPane ver = new JScrollPane(texto);
	int urgencia=0;
	
	public boolean nueva() {
		String nombre = JOptionPane.showInputDialog("Destinatario");
        if(nombre==null)return false;
		String direccion = JOptionPane.showInputDialog("Direccion");
		        if(direccion==null)return false;
		String remitente = JOptionPane.showInputDialog("Remitente");
		if(remitente==null)return false;
		String j[]={"Carta","Telegrama","Bulto Postal"};
		
		
		op=j[JOptionPane.showOptionDialog(null,"Tipo de correspondencia",null,JOptionPane.YES_NO_OPTION,JOptionPane.OK_CANCEL_OPTION,null,j,null)];
		if(op==null)return false;
		        Correspondencia c = null;
		try {
		if(op.equals("Carta")) {
		String fechaEnvio = JOptionPane.showInputDialog("Fecha de Envio");
		                        if(fechaEnvio==null)return false;
		String arr[]={"True","False"};	
		        		boolean exterior = Boolean.parseBoolean(arr[JOptionPane.showOptionDialog(null,"Es del exterior",null,JOptionPane.YES_NO_OPTION,JOptionPane.OK_CANCEL_OPTION,null,arr,null)]);
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
		String arr[]={"Muy Urgente","Urgente","Irrelevante"};	
		        		urgencia=JOptionPane.showOptionDialog(null,"Tipo de correspondencia",null,JOptionPane.YES_NO_OPTION,JOptionPane.OK_CANCEL_OPTION,null,arr,null);                    										
		c = new BultoPostal(nombre,direccion,remitente,peso,urgencia);
		}
		correo.nuevaCorrespondencia(c);
		return true;
		}
		catch(Exception ee) {
		JOptionPane.showMessageDialog(null, "Error en la introduccion de datos");
		return false;
		}
	}
	
	public void ini() {
                texto.setEditable(false);
		ver.setSize(500,400);
		ver.setLocation(20,50);
		texto.setSize(500,400);
		Dimension buttonSize = new Dimension(100,35);
		JPanel panel = new JPanel();
		add(panel);
		panel.add(ver);
		panel.setLayout(null);
		
		JButton nuevoc = new JButton("Nueva");
		nuevoc.setSize(buttonSize);
		nuevoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!nueva())JOptionPane.showInternalMessageDialog(null, "Se ha cancelado la operacion");
				else JOptionPane.showMessageDialog(null, "Correspondencia agragada con exito");
			}
		});
	
		panel.add(nuevoc);
		
		JButton despachar = new JButton("Despachar");
		despachar.setSize(buttonSize);
		despachar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setText(correo.despachar());
				texto.repaint();
			}
			
		});
		panel.add(despachar);
		
		JButton personal = new JButton("Entregar");
		personal.setSize(buttonSize);
		personal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = JOptionPane.showInputDialog("Nombre del destinatario");
				if(nombre==null)return;
                                String direccion = JOptionPane.showInputDialog("Direcion a enviar");
                                if(direccion==null)return;
				texto.setText(correo.entregaPersonal(nombre, direccion));
				texto.repaint();
			}
			
		});
		panel.add(personal);
		
		JButton Calculo = new JButton("Calculo");
		Calculo.setSize(buttonSize);
		Calculo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setText("Se haran un total de "+correo.calculoAcumulado()+ " por toda la correspondencia que falta por entregar\n"
						+ "La correspondencia ya entregada tiene un valor de "+correo.calculoEntregada());
				
				texto.repaint();
			}
			
		});
		panel.add(Calculo);
		
		JButton entregada = new JButton("Entregada");
		entregada.setSize(buttonSize);
		entregada.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setText(correo.listaEntregada());
				texto.repaint();
			}
			
		});
		panel.add(entregada);

		JButton botones[] = new JButton[5];
		botones[0] = nuevoc;
		botones[1] = despachar;
		botones[2] = personal;
		botones[3] = Calculo;
		botones[4] = entregada;
		for(int i=0;i<5;i++)
			botones[i].setLocation(10+(i*buttonSize.width)+(5*i),5);
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
