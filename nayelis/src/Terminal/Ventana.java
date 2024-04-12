package Terminal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ventana extends JFrame{
	
	private Terminal terminal = new Terminal();
	JTextArea info = new JTextArea();
	JScrollPane verInfo = new JScrollPane(info);
	JLabel listaEspera = new JLabel();
	JLabel listaOficial = new JLabel();
	int opcion=0;
	
	public void primero(){
		info.setEditable(false);
		JPanel panel = new JPanel();
		panel.setSize(590,500);
		panel.setLocation(200,100);
		add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.add(verInfo);
		panel.setLayout(null);
		verInfo.setSize(panel.getSize());
		verInfo.setLocation(0,0);
		
		JPanel botones = new JPanel();
		botones.setSize(200,700);
		add(botones);
		botones.setBackground(Color.GRAY);
		botones.setLayout(null);
		segundo(botones);
	
		JPanel infolistas = new JPanel();
		infolistas.setSize(600,100);
		infolistas.setLocation(200,0);
		infolistas.setBackground(Color.DARK_GRAY);
		add(infolistas);
		infolistas.setLayout(null);
		infolistas.add(listaEspera);
		infolistas.add(listaOficial);
		listaEspera.setLocation((infolistas.getWidth()/4)-(listaEspera.getWidth()/2),(infolistas.getHeight()/2)-(listaEspera.getHeight()/2));
		listaOficial.setLocation((infolistas.getWidth()*3/4)-(listaOficial.getWidth()/2),(infolistas.getHeight()/2)-(listaOficial.getHeight()/2));
		
	}
	
	public void segundo(JPanel panel) {
		String opciones[] = {"Nuevo Omnibus","Viajes un Dia","Ver Listas","Dinero Recaudado","Destino mas Frecuente","Pasajeros por Omnibus","Buscar Pasajero","Omnibus con Destino","Mayor Recaudacion"};
		panel.setLocation(0,100);
		panel.setVisible(false);
		JPanel nuevo = new JPanel();
		JPanel menu = new JPanel();
		menu.setSize(200,100);
		menu.setLayout(null);
		menu.setBackground(Color.gray);
		add(menu);
		JButton Menu = new JButton("Menu");
		Menu.setFocusable(false);
		Menu.setSize(150,75);
		Menu.setLocation(25,12);
		menu.add(Menu);
		Menu.setBackground(Color.darkGray);
		Menu.setForeground(Color.white);
		
		Menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(!panel.isVisible());
				nuevo.setVisible(!nuevo.isVisible());
				
			}
			
		});
		listaOficial.setText("Personas en Lista: "+terminal.oficial.size());
		listaEspera.setText("Personas en Espera: "+terminal.espera.size());
		listaOficial.setSize(190,30);
		listaOficial.setForeground(Color.white);
		listaOficial.setLocation(5,panel.getHeight()-50);
		
		listaEspera.setSize(190,30);
		listaEspera.setForeground(Color.white);
		listaEspera.setLocation(5,panel.getHeight()-80);
		JButton botones[] = new JButton[opciones.length];
		for(int i=0;i<opciones.length;i++) {
			JButton boton = new JButton(opciones[i]);
			boton.setSize(190,40);
			boton.setLocation(5,10+(i*boton.getHeight())+(i*10));
			panel.setSize(panel.getWidth(),boton.getY()+boton.getHeight()+10);
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
					Pasajero chofer = new Pasajero(JOptionPane.showInputDialog("Carnet del Chofer"));
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
						String diaLlegad = JOptionPane.showInputDialog("Dia de Salida");
						String horaSalida = JOptionPane.showInputDialog("Hora de Salida");
						int cantidadAsientos = Integer.parseInt(JOptionPane.showInputDialog("cantidad de Asientos"));
						o = new OmnibusAstro(chapa,chofer,destino,KM,diaLlegad,horaSalida,cantidadAsientos);
						
					}
					else {
						String horaLlegada = JOptionPane.showInputDialog("Hora de Llegada");
						int asientosDisponibles = Integer.parseInt(JOptionPane.showInputDialog("Asientos Disponibles"));
						o = new OmnibusTurismo(chapa,chofer,destino,KM,horaLlegada,asientosDisponibles);
					}
					terminal.nuevoOmnibus(o);
					listaOficial.setText("Personas en Lista: "+terminal.oficial.size());
					listaEspera.setText("Personas en Espera: "+terminal.espera.size());
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
				info.setText(terminal.salidasEnElDia(JOptionPane.showInputDialog("Dia de Salida")));
				
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
				info.setText(terminal.recaudacionElDia(JOptionPane.showInputDialog("Dia")));
				
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
				info.setText(terminal.aDondeViajo(JOptionPane.showInputDialog("Carnet del pasajero")));
				
			}
			
		});
		//Omnibus con Destino
		botones[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.setText(terminal.informacionOmnibusPorDestino(JOptionPane.showInputDialog("Destino")));
				
			}
			
		});
		//Mayor Recaudacino
		botones[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.setText(terminal.omnibusMayorRecaudacion());
				
			}
			
		});
	
		
		nuevo.setSize(200,500);
		nuevo.setLocation(0,100);
		nuevo.setBackground(Color.darkGray);
		add(nuevo);
		
		tercero(nuevo,botones[0]);
	}
	
	public void tercero(JPanel panel,JButton nuevo) {
		panel.setLayout(null);
		JTextField chapa = new JTextField("Chapa");
		chapa.setSize(150,30);
		chapa.setLocation(25,10);
		panel.add(chapa);
		
		JTextField chofer = new JTextField("Carnet Chofer");
		chofer.setSize(150,30);
		chofer.setLocation(25,10+30+10);
		panel.add(chofer);
		
		JTextField destino = new JTextField("Destino");
		destino.setSize(150,30);
		destino.setLocation(25,10+30+10+30+10);
		panel.add(destino);
		
		JTextField KM = new JTextField("Distancia");
		KM.setSize(150,30);
		KM.setLocation(25,10+30+10+30+10+30+10);
		panel.add(KM);
		
		JButton astro = new JButton("Astro");
		astro.setSize(75,40);
		astro.setLocation(10+7,10+30+10+30+10+30+10+30+10);
		panel.add(astro);
		
		JButton turim = new JButton("Turismo");
		turim.setSize(75,40);
		turim.setLocation(10+7+15+75,10+30+10+30+10+30+10+30+10);
		panel.add(turim);
		
		JPanel pa = new JPanel();
		pa.setLayout(null);
		pa.setSize(200,120);
		pa.setLocation(0,10+30+10+30+10+30+10+30+10+50);
		pa.setBackground(Color.DARK_GRAY);
		JPanel pt = new JPanel();
		pt.setLayout(null);
		pt.setSize(200,120);
		pt.setLocation(0,10+30+10+30+10+30+10+30+10+50);
		pt.setBackground(Color.DARK_GRAY);
		panel.add(pa);
		panel.add(pt);
		
		//ASTRO
		
		JTextField diaLlegada = new JTextField("Dia de Salida");
		diaLlegada.setSize(150,30);
		diaLlegada.setLocation(25,0);
		pa.add(diaLlegada);
		
		JTextField hora = new JTextField("Hora de Salida");
		hora.setSize(150,30);
		hora.setLocation(25,40);
		pa.add(hora);
		
		JTextField asientos = new JTextField("Asientos Disponibles");
		asientos.setSize(150,30);
		asientos.setLocation(25,80);
		pa.add(asientos);
		
		//ASTRO
		
		//TURISMO
			
			JTextField horaLlegada = new JTextField("Hora de Llegada");
			horaLlegada.setSize(150,30);
			horaLlegada.setLocation(25,0);
			pt.add(horaLlegada);
			
			JTextField casientos = new JTextField("Asientos Disponibles");
			casientos.setSize(150,30);
			casientos.setLocation(25,40);
			pt.add(casientos);
		
		//TURISMO
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pa.setVisible(!pa.isVisible());
				pt.setVisible(!pt.isVisible());
				astro.setEnabled(!astro.isEnabled());
				turim.setEnabled(!turim.isEnabled());
			}
			
		};
		
		astro.addActionListener(al);
		turim.addActionListener(al);
		pt.setVisible(false);
		astro.setEnabled(false);
		
		nuevo.setLocation(5,10+30+10+30+10+30+10+30+10+50+120+10);
		
		nuevo.removeActionListener(nuevo.getActionListeners()[0]);
		nuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Omnibus omnibus;
					String c = chapa.getText();
					Pasajero ch = new Pasajero(chofer.getText());
					String d = destino.getText();
					float km = Float.parseFloat(KM.getText());
					
					if(!astro.isEnabled()) {
						String ds = diaLlegada.getText();
						String hs = hora.getText();
						int ca = Integer.parseInt(asientos.getText());
						omnibus = new OmnibusAstro(c,ch,d,km,ds,hs,ca);
					}
					
					else {
						String hl = horaLlegada.getText();
						int ca = Integer.parseInt(casientos.getText());
						omnibus = new OmnibusTurismo(c,ch,d,km,hl,ca);
					}
					
					info.setText(terminal.nuevoOmnibus(omnibus));
					
					chapa.setText("Chapa");
					chofer.setText("Carnet Chofer");
					destino.setText("Destino");
					KM.setText("Distancia");
					diaLlegada.setText("Dia de Salida");
					hora .setText("Hora de SAlida");
					asientos.setText("Asientos Disponibles");
					horaLlegada.setText("Hora de Llegada");
					casientos.setText("Asientos Disponibles");
					
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "Error en la introduccion de los datos");
				}
		
	 	}
		
		});
		panel.add(nuevo);
		
	}
	
	public Ventana() {
		setLayout(null);
		setSize(800,600);
		setResizable(false);
		primero();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
