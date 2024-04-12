package aplicacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ventana extends JFrame{
	private Terminal terminal;
	JTextArea info = new JTextArea();
	JScrollPane verInfo = new JScrollPane(info);
	JLabel listaEspera = new JLabel();
	JLabel listaOficial = new JLabel();
	int opcion=0;
	public void primero(){
		info.setEditable(false);
		JPanel panel = new JPanel();
		panel.setSize(810,700);
		panel.setLocation(200,0);
		add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.add(verInfo);
		panel.setLayout(null);
		verInfo.setSize(790,660);
		verInfo.setLocation(10,10);
		
		JPanel botones = new JPanel();
		botones.setSize(200,700);
		add(botones);
		botones.setBackground(Color.GRAY);
		botones.setLayout(null);
		segundo(botones);
		
	}
	
	public void segundo(JPanel panel) {
		String opciones[] = {"Nuevo Omnibus","Viajes un Dia","Ver Listas","Dinero Recaudado","Destino mas Frecuente","Pasajeros por Omnibus","Buscar Pasajero","Omnibus con Destino","Mayor Recaudacion"};
		
		listaOficial.setText("Personas en Lista: "+terminal.listas.oficial.size());
		listaEspera.setText("Personas en Espera: "+terminal.listas.espera.size());
		listaOficial.setSize(190,30);
		listaOficial.setForeground(Color.white);
		listaOficial.setLocation(5,panel.getHeight()-50);
		
		listaEspera.setSize(190,30);
		listaEspera.setForeground(Color.white);
		listaEspera.setLocation(5,panel.getHeight()-80);
		panel.add(listaOficial);
		panel.add(listaEspera);
		JButton botones[] = new JButton[opciones.length];
		for(int i=0;i<opciones.length;i++) {
			JButton boton = new JButton(opciones[i]);
			boton.setSize(190,50);
			boton.setLocation(5,10+(i*boton.getHeight())+(i*10));
			panel.add(boton);
			botones[i]=boton;
		}
		//Nuevo Omnibus
		botones[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Omnibus o;
					String chapa = JOptionPane.showInputDialog("Chapa del Omnibus");
					Persona chofer = new Persona(JOptionPane.showInputDialog("Carnet del Chofer"));
					String destino = JOptionPane.showInputDialog("Destino del Omnibus");;
					float KM = Float.parseFloat(JOptionPane.showInputDialog("Distancia del Viaje(KM)"));
					
					opcion=0;
					JComboBox<String> j = new JComboBox<>();
					j.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							opcion =  j.getSelectedIndex();
							
						}
						
					});
					j.addItem("Astro");
					j.addItem("Turismo");
					JOptionPane.showInputDialog(j);
					
					if(opcion==0) {
						String diaSalida = JOptionPane.showInputDialog("Dia de Salida");
						String horaSalida = JOptionPane.showInputDialog("Hora de Salida");
						int cantidadAsientos = Integer.parseInt(JOptionPane.showInputDialog("cantidad de Asientos"));
						o = new Astro(chapa,chofer,destino,KM,diaSalida,horaSalida,cantidadAsientos);
						
					}
					else {
						String horaLlegada = JOptionPane.showInputDialog("Hora de Llegada");
						int asientosDisponibles = Integer.parseInt(JOptionPane.showInputDialog("Asientos Disponibles"));
						o = new Turismo(chapa,chofer,destino,KM,horaLlegada,asientosDisponibles);
					}
					terminal.nuevoOmnibus(o);
					listaOficial.setText("Personas en Lista: "+terminal.listas.oficial.size());
					listaEspera.setText("Personas en Espera: "+terminal.listas.espera.size());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al entrar los datos");
				}
			}
			
		});
		//Viajes un Dia
		botones[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.setText(terminal.omnibusSalironEn(JOptionPane.showInputDialog("Dia de Salida")));
				
			}
			
		});
		//Ver Listas
		botones[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.setText(terminal.verListas());
				
			}
			
		});
		//Dinero Recaudado
		botones[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.setText(terminal.dineroRecaudadoEl(JOptionPane.showInputDialog("Dia")));
				
			}
			
		});
		//Destino Mas Frecuente
		botones[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.setText(terminal.destinoMasFrecuente());
				
			}
			
		});
		//Pasajeros por Omnibus
		botones[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.setText(terminal.pasajerosPorOmnibus());
				
			}
			
		});
		//Buscar Pasajero
		botones[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.setText(terminal.dondeViajo(JOptionPane.showInputDialog("Carnet del pasajero")));
				
			}
			
		});
		//Omnibus con Destino
		botones[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.setText(terminal.informacionOmnibusDestino(JOptionPane.showInputDialog("Destino")));
				
			}
			
		});
		//Mayor Recaudacino
		botones[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.setText(terminal.omnibusMayorRecaudacion());
				
			}
			
		});
	}
	
	public Ventana(Terminal t) {
		terminal=t;
		setLayout(null);
		setSize(1027,720);
		setResizable(false);
		primero();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
