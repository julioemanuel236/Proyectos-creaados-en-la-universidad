package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{
	Subdireccion estudiantil = new Subdireccion("Estudiante","Havana");

	private JPanel opciones;
	Dimension tamannoPanel = new Dimension(600,500);
	JPanel  interaccion;
	
	Subdireccion sb = new Subdireccion("Subdireccion","Algun lugar");

	public void iniciar() {
		JPanel panel = new JPanel();
		Dimension tam = new Dimension(150,40);
		panel.setLayout(null);
		add(panel);
		panel.setBackground(new Color(176,120,194));
		Point p = new Point(10,10);
		
		JButton nuevoEdificio = new JButton("Nuevo Edificio");
		panel.add(nuevoEdificio);
		nuevoEdificio.setLocation(p);
		p.x+=tam.width+10; 
		nuevoEdificio.setSize(tam);
		
		nuevoEdificio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sb.nuevoEdificio();
			}
			
		});
		
		JButton nuevoBecado = new JButton("Nuevo Becado");
		nuevoBecado.setLocation(p);
		p.x=10;
		p.y+=tam.height+10;
		nuevoBecado.setSize(tam);
		panel.add(nuevoBecado);
		nuevoBecado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sb.nuevoBecado();				
			}
			
		});
		
		JButton datosEdificio = new JButton("Datos de un Edificio");
		panel.add(datosEdificio);
		datosEdificio.setLocation(p);
		p.x+=tam.width+10; 
		datosEdificio.setSize(tam);
		datosEdificio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = sb.datosEdificio();				
				JOptionPane.showInternalMessageDialog(null, s);
			}
			
		});
		
		JButton edificioMasBecados = new JButton("Edificio con mas Becados");
		panel.add(edificioMasBecados);
		edificioMasBecados.setLocation(p);
		p.x=10;
		p.y+=tam.height+10;
		edificioMasBecados.setSize(tam);
		edificioMasBecados.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = sb.edificioMasBecados();				
				JOptionPane.showInternalMessageDialog(null, s);				
			}
			
		});
		
		JButton cantidadBecadosTipo = new JButton("Cantidad de Becados por Tipo");
		panel.add(cantidadBecadosTipo);
		cantidadBecadosTipo.setLocation(p);
		p.x+=tam.width+10; 
		cantidadBecadosTipo.setSize(tam);
		cantidadBecadosTipo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = sb.cantidadBecadosTipo();				
				JOptionPane.showInternalMessageDialog(null, s);				
			}
			
		});
	
		JButton porcentajeOcupacionTotal = new JButton("Porcentaje de Ocupacion total de los Edificios");
		panel.add(porcentajeOcupacionTotal);
		porcentajeOcupacionTotal.setLocation(p);
		p.x=10;
		p.y+=tam.height+10;
		porcentajeOcupacionTotal.setSize(tam);
		porcentajeOcupacionTotal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = sb.porcentajeOcupacionTotal();				
				JOptionPane.showInternalMessageDialog(null, s);				
			}
			
		});
		
		JButton porcentajeOcupacionEdificio = new JButton("Porcentaje de Ocupacion total de un Edificio");
		panel.add(porcentajeOcupacionEdificio);
		porcentajeOcupacionEdificio.setLocation(p);
		p.x+=tam.width+10; 
		porcentajeOcupacionEdificio.setSize(tam);
		porcentajeOcupacionEdificio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = sb.porcentajeOcupacionEdificio();				
				JOptionPane.showInternalMessageDialog(null, s);				
			}
			
		});
		
		JButton datosBecadoCi = new JButton("Datos de un Becado por su carnet");
		datosBecadoCi.setLocation(p); 
		datosBecadoCi.setSize(tam);
		panel.add(datosBecadoCi);
		datosBecadoCi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = sb.datosBecadoCi();				
				JOptionPane.showInternalMessageDialog(null, s);				
			}
			
		});
		
	}
	
	
	public Ventana(){
		setResizable(false);
		setSize(350,280);
		setTitle("Residencia");
		iniciar();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	public static void main(String args[]) {
		new Ventana();
	}
	
}
