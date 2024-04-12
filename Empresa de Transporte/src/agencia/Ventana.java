package agencia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{

	JPanel menu;
	JPanel opcion;
	Agencia agencia = new Agencia();
	
	public void cambioPanel(JPanel p) {
		opcion.removeAll();
		opcion.add(p);
		opcion.repaint();
	}
	
	private void NUEVO() {
		JPanel NUEVO = new JPanel();
		NUEVO.setSize(opcion.getSize());
		NUEVO.setLayout(null);
		JPanel camion;
		JPanel trabajador;
		JPanel viaje;
		
		camion = new JPanel();
		camion.setSize(NUEVO.getWidth()/3,NUEVO.getHeight());
		camion.setLocation(0,0);
		camion.setLayout(null);

		JTextField dat1 = new JTextField("KM/L");
		JTextField dat2 = new JTextField("A�o de fabricaci�n");
		dat2.setEnabled(false);
		JTextField chapa = new JTextField("Chapa");
		JComboBox<String> tipo = new JComboBox<>();
		JButton aceptarc = new JButton("Aceptar");
		tipo.setSize(camion.getWidth(),40);
		chapa.setSize(tipo.getSize());
		dat1.setSize(tipo.getSize());
		dat2.setSize(dat1.getSize());
		aceptarc.setSize(tipo.getWidth()-20,40);		
		dat1.setLocation(0,40);
		dat2.setLocation(0,80);
		chapa.setLocation(0,120);
		aceptarc.setLocation(10,camion.getHeight()-40);
		tipo.addItem("Moderno");
		tipo.addItem("Viejo");
		tipo.addActionListener((ActionEvent)->{
			if(tipo.getSelectedIndex()==0) {
				dat1.setText("KM/L");
				dat2.setEnabled(false);
			}
			else {
				dat1.setText("Cantidad de reparaciones");
				dat2.setEnabled(true);
			}
		});
		camion.add(tipo);
		camion.add(dat1);
		camion.add(dat2);
		camion.add(chapa);
		camion.add(aceptarc);
		camion.setLocation(camion.getWidth(),0);

		aceptarc.addActionListener((ActionEvent)->{
			try {
				String c = chapa.getText();
				int d1 = Integer.parseInt(dat1.getText());
				if(tipo.getSelectedIndex()==0) {
					agencia.nuevoCamionModerno(c, d1);
				}
				else {
					int d2 = Integer.parseInt(dat2.getText());
					agencia.nuevoCamionViejo(c, d1, d2);
				}
				NUEVO();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Datos Invalidos");
			}
		});
		NUEVO.add(camion);

		
		trabajador = new JPanel();
		trabajador.setSize(NUEVO.getWidth()/3,NUEVO.getHeight());
		trabajador.setLayout(null);
		NUEVO.add(trabajador);	
		
		JTextField nombre = new JTextField("Nombre:");
		JTextField dni = new JTextField("DNI:");
		JTextField nivelescolar = new JTextField("Nivel Escolar:");
		JTextField sexo = new JTextField("Sexo:");
		JTextField telefono = new JTextField("Tel�fono:");
		JTextField dir = new JTextField("Dir:");
		JTextField exp = new JTextField("Exp:");
		JTextField cargo = new JTextField("Cargo:");
		JTextField salario = new JTextField("Salario Base:");
		JTextField evaluacion = new JTextField("Evaluacion:");
		JCheckBox  admin = new JCheckBox("Administrativo");
		JButton    aceptart = new JButton("Aceptar");
		
		nombre.setSize(trabajador.getWidth(),40);
		dni.setSize(nombre.getSize());
		nivelescolar.setSize(nombre.getSize());
		sexo.setSize(nombre.getSize());
		telefono.setSize(nombre.getSize());
		dir.setSize(nombre.getSize());
		exp.setSize(nombre.getSize());
		cargo.setSize(nombre.getSize());
		salario.setSize(nombre.getSize());
		evaluacion.setSize(nombre.getSize());
		admin.setSize(nombre.getWidth(),40);
		aceptart.setSize(nombre.getWidth()-20,40);
		
		nombre.setLocation(0,0);
		dni.setLocation(0,40);
		nivelescolar.setLocation(0,80);
		sexo.setLocation(0,120);
		telefono.setLocation(0,160);
		dir.setLocation(0,200);
		exp.setLocation(0,240);
		salario.setLocation(0,280);
		evaluacion.setLocation(0,320);
		cargo.setLocation(0,320);
		aceptart.setLocation(10,trabajador.getHeight()-40);
		admin.setLocation(5,aceptart.getY()-45);
		
		cargo.setVisible(false);
		
		admin.addActionListener((ActionListener)->{
			if(admin.isSelected()) {
				evaluacion.setVisible(false);
				cargo.setVisible(true);
			}
			else {
				cargo.setVisible(false);
				evaluacion.setVisible(true);
				
			}
		});
		
		aceptart.addActionListener((ActionEvent)->{
			try {
				String n=nombre.getText();
				String d=dni.getText();
				String ne=nivelescolar.getText();
				String s=sexo.getText();
				String t=telefono.getText();
				String di=dir.getText();
				int    ex=Integer.parseInt(exp.getText());
				int    sa=Integer.parseInt(salario.getText());
				String c=cargo.getText();
				if(admin.isSelected()) {
					agencia.nuevoAdmin(n, d, ne, s, t, di, ex, c, sa);
				}
				else {
					int e=Integer.parseInt(evaluacion.getText());
				    agencia.nuevoChofer(n, d, ne, s, t, di, ex, sa, e);			
				}
				NUEVO();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Datos Invalidos");
			}
		});
		
		trabajador.add(nombre);
		trabajador.add(dni);
		trabajador.add(nivelescolar);
		trabajador.add(sexo);
		trabajador.add(telefono);
		trabajador.add(dir);
		trabajador.add(exp);
		trabajador.add(salario);
		trabajador.add(evaluacion);
		trabajador.add(cargo);
		trabajador.add(aceptart);
		trabajador.add(admin);
		
		viaje = new JPanel();
		viaje.setLayout(null);
		viaje.setSize(NUEVO.getWidth()/3,NUEVO.getHeight());
		viaje.setLocation(camion.getWidth()+camion.getX(),0);
		viaje.setOpaque(true);
	
		JComboBox<String> dia = new JComboBox<>();
		JTextField carga = new JTextField("Carga: ");
		JTextField distancia  = new JTextField("Distancia (KM): ");
		JTextField regreso = new JTextField("D�a de regrso: ");
		JTextField cprov  = new JTextField("Provincias visitadas: ");
		JComboBox<Camion> camiones = new JComboBox<>();
		JComboBox<Chofer> chofers = new JComboBox<Chofer>();
		JCheckBox  inter = new JCheckBox("Interprovincial");
		JButton	   aceptarv = new JButton("Aceptar");
		
		dia.addItem("Lunes");
		dia.addItem("Martes");
		dia.addItem("Miercoles");
		dia.addItem("Jueves");
		dia.addItem("Viernes");
		dia.addItem("S�bado");
		dia.addItem("Domingo");
		
		regreso.setEnabled(false);
		cprov.setEnabled(false);
		
		dia.setSize(viaje.getWidth(),40);
		carga.setSize(dia.getSize());
		distancia.setSize(dia.getSize());
		regreso.setSize(dia.getSize());
		cprov.setSize(dia.getSize());
		camiones.setSize(dia.getSize());
		chofers.setSize(dia.getSize());
		inter.setSize(dia.getWidth(),40);
		aceptarv.setSize(dia.getWidth()-20,40);
		
		dia.setLocation(0,0);
		carga.setLocation(0,40);
		distancia.setLocation(0,80);
		regreso.setLocation(0,120);
		cprov.setLocation(0,160);
		camiones.setLocation(0,200);
		chofers.setLocation(0,240);
		aceptarv.setLocation(5,viaje.getHeight()-40);
		inter.setLocation(5,aceptarv.getY()-40);
		inter.addActionListener((ActionEvent)->{
			if(inter.isSelected()) {
				camiones.removeAllItems();
				chofers.removeAllItems();
				for(CM i:agencia.getModernos()) 
					camiones.addItem(i);
				for(Chofer i:agencia.getChofersA())
					chofers.addItem(i);
				regreso.setEnabled(true);
				cprov.setEnabled(true);
			}
			else {
				camiones.removeAllItems();
				chofers.removeAllItems();
				for(Camion i:agencia.getCamiones()) 
					camiones.addItem(i);
				for(Chofer i:agencia.getChofers())
					chofers.addItem(i);
				regreso.setEnabled(false); 
				cprov.setEnabled(false);  
			}
			NUEVO();
		});

		aceptarv.addActionListener((ActionEvent)->{
			try {
				int d = dia.getSelectedIndex();
				int c = Integer.parseInt(carga.getText());
				int k = Integer.parseInt(distancia.getText());
				Camion ca=(Camion)camiones.getSelectedItem();
				if(ca.getClass()==CM.class)ca=(CM)ca;
				else ca=(CV)ca;
				Chofer ch=(Chofer)chofers.getSelectedItem();
				
				if(inter.isSelected()) {
					int rg= Integer.parseInt(regreso.getText());
					int cp= Integer.parseInt(cprov.getText());
					agencia.nuevoProvincial(d, c, k, ca, ch,rg,cp);
				}
				else agencia.nuevoViaje(d, c, k, ca, ch);
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Datos Invalidos");
			}
		});
		
		for(Camion i:agencia.getCamiones()) 
			camiones.addItem(i);
		for(Chofer i:agencia.getChofers())
			chofers.addItem(i);
		
		viaje.add(dia);
		viaje.add(carga);
		viaje.add(distancia);
		viaje.add(regreso);
		viaje.add(cprov);
		viaje.add(camiones);
		viaje.add(chofers);
		viaje.add(inter);
		viaje.add(aceptarv);
		
		NUEVO.add(viaje);
		
		
		cambioPanel(NUEVO);
	}
	
	private void CARGASEMANA() {
		agencia.volumenCarga();
	}
	
	private void DISTANCIAPROMEDIOCAMION() {
		Camion	m = (Camion)JOptionPane.showInputDialog(null, "Camion:", "Promedio Distancia", JOptionPane.QUESTION_MESSAGE, null, agencia.getCamiones().toArray(), null);
		agencia.distanciaPromedio(m);
	}
	
	private void DATOSVIAJESCHAPA() {
		JPanel panel = new JPanel();
		panel.setSize(opcion.getSize());
		panel.setLayout(null);

		JTextArea txt = new JTextArea();
		JScrollPane sp = new JScrollPane(txt);
		sp.setSize(panel.getWidth(),panel.getHeight()-40);
		
		JComboBox<Camion> camiones = new JComboBox<>();
		for(Camion i:agencia.getCamiones())
			camiones.addItem(i);
		camiones.setSize(200,40);
		camiones.addActionListener((ActionEvent)->{
			txt.setText(agencia.datosViajesChapa((Camion)camiones.getSelectedItem()));
		});
		camiones.setLocation((panel.getWidth()/2)-(camiones.getWidth()/2),0);
		sp.setLocation(0,40);
		panel.add(camiones);
		panel.add(sp);
		cambioPanel(panel);
	}
	
	private void MENORPORDISTANCIA() {
		JPanel panel = new JPanel();
		panel.setSize(opcion.getSize());
		JTextArea txt = new JTextArea(agencia.modernosDistancia());
		txt.setSize(panel.getSize());
		JScrollPane sc = new JScrollPane(txt);
		sc.setSize(panel.getSize());
		panel.add(sc);
		cambioPanel(panel);
	}
	
	private void MASPROVINCIASVIAJE() {
		agencia.masProvinciasViaje();
	}

	private void GENERARNOMINA() {
		JPanel panel = new JPanel();
		panel.setSize(opcion.getSize());
		JTextArea txt = new JTextArea(agencia.generarNomina());
		txt.setSize(panel.getSize());
		JScrollPane sc = new JScrollPane(txt);
		sc.setSize(panel.getSize());
		panel.add(sc);
		cambioPanel(panel);
	}
		
	private void CARGAR() {
		JPanel panel = new JPanel();
		panel.setSize(opcion.getSize());
		JTextArea txt = new JTextArea(agencia.Cargar());
		txt.setSize(panel.getSize());
		JScrollPane sc = new JScrollPane(txt);
		sc.setSize(panel.getSize());
		panel.add(sc);
		cambioPanel(panel);
	}
	
	public void paneles() {
		NUEVO();		
	}
	
	public void menu() {
		menu = new JPanel();
		menu.setSize(210,500);
		menu.setLocation(getWidth()-menu.getWidth()-20,0);
		opcion = new JPanel();
		opcion.setSize(getWidth()-menu.getWidth()-25,getHeight()-50);
		opcion.setLayout(null);
		botones();
		paneles();
		add(opcion);
		add(menu);
	}
	
	public void botones() {
		JButton nuevo,cargasemana,distanciapromediocamion,viajeschapa,mayortransportador,
		modernospordistancia,masprovincias,generarnomina,guardarviajes,cargarviajes;
		menu.setLayout(null);
		
		nuevo = new JButton("Nuevo Elemento");
		nuevo.setSize(200,35);
		nuevo.setLocation(5,5);
		nuevo.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NUEVO();
			}
		});
		menu.add(nuevo);
				
		cargasemana = new JButton("Carga Semanal");
		cargasemana.setSize(200,35);
		cargasemana.setLocation(5,45);
		cargasemana.addActionListener((ActionEvent)->{
			CARGASEMANA();
		});
		menu.add(cargasemana);			
		
		distanciapromediocamion = new JButton("Distancia Promedio");
		distanciapromediocamion.setSize(200,35);
		distanciapromediocamion.setLocation(5,85);
		distanciapromediocamion.addActionListener((ActionEvent)->{
			DISTANCIAPROMEDIOCAMION();
		});
		menu.add(distanciapromediocamion);
						
		viajeschapa = new JButton("Viajes por Chapa");
		viajeschapa.setSize(200,35);
		viajeschapa.setLocation(5,125);
		viajeschapa.addActionListener((ActionEvent)->{
			DATOSVIAJESCHAPA();
		});
		menu.add(viajeschapa);
		
		mayortransportador = new JButton("Mayor Transportador");
		mayortransportador.setSize(200,35);
		mayortransportador.setLocation(5,165);
		mayortransportador.addActionListener((ActionEvent)->{
			agencia.mayorCarga();
		});
		menu.add(mayortransportador);
				
		modernospordistancia = new JButton("Lista Modernos");
		modernospordistancia.setSize(200,35);
		modernospordistancia.setLocation(5,205);		
		modernospordistancia.addActionListener((ActionEvent)->{
			MENORPORDISTANCIA();
		});
		menu.add(modernospordistancia);
				
		masprovincias = new JButton("Mas Provincias");
		masprovincias.setSize(200,40);
		masprovincias.setLocation(5,245);
		masprovincias.addActionListener((ActionEvent)->{
			MASPROVINCIASVIAJE();
		});
		menu.add(masprovincias);
		
		generarnomina = new JButton("Generar N�mina");
		generarnomina.setSize(200,40);
		generarnomina.setLocation(5,295);
		generarnomina.addActionListener((ActionEvent)->{
			GENERARNOMINA();
		});
		menu.add(generarnomina);
		
		guardarviajes = new JButton("Guardar Viajes");
		guardarviajes.setSize(200,40);
		guardarviajes.setLocation(5,345);
		guardarviajes.addActionListener((ActionEvent)->{
			agencia.Guardar();
		});
		menu.add(guardarviajes);
		
		cargarviajes = new JButton("CargarViajes");
		cargarviajes.setSize(200,40);
		cargarviajes.setLocation(5,395);
		cargarviajes.addActionListener((ActionEvent)->{
			CARGAR();
		});
		menu.add(cargarviajes);
	}
	
	Ventana(){
		setSize(820,500);
		setResizable(false);
		setLayout(null);
		menu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Ventana();
	}
	
}
