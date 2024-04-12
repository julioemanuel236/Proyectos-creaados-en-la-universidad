package empresa_turistica;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Empresa_Turistica extends JFrame{

	private JPanel base;
	private JDialog visible;
	private Excursion[] excursiones = new Excursion[100];
	private int cantidadExcursiones=0;
	private ExcursionDirigida[] excursionesDirigidas = new ExcursionDirigida[100];
	private int cantidadExcursionesDirigidas=0;
	private Carro[] carros = new Carro[100];
	private int cantidadCarros=0;
	private Guagua[] guaguas = new Guagua[100];
	private int cantidadGuaguas=0;
	private Persona[] chofers = new Persona[100];
	int cantidadChofers=0;
	
	void limpiar(Container c,String[] txt) {
		guardarDatos();
		int k=0;
		for(Component i:c.getComponents()) {
			if(i.getClass()==JTextField.class) {
				((JTextField)i).setText(txt[k++]);
			}
			if(i.getClass()==JComboBox.class) {
				((JComboBox)i).setSelectedItem(-1);
			}
		}
	}
	
	void cerrarVisible() {
		if(visible!=null) {
			visible.hide();
			visible=null;
		}
	}
	
	void nuevaExcursion() {
		JDialog ne = new JDialog();
		ne.setResizable(false);
		visible=ne;
		ne.setTitle("Nueva Excursi�n");
		ne.setLayout(null);
		ne.setSize(260,500);
		Dimension d = new Dimension(235,30);
		Point p = new Point(5,5);
		int separacion = 5;
		
		JTextField nombre = new JTextField("Nombre de la excursi�n");
		nombre.setSize(d);
		nombre.setLocation(p);
		p.y+=d.height+separacion;
		ne.add(nombre);
		
		JTextField numero = new JTextField("numero de la excursi�n");
		numero.setSize(d);
		numero.setLocation(p);
		p.y+=d.height+separacion;
		ne.add(numero);
		
		JTextField precio = new JTextField("Precio por persona");
		precio.setSize(d);
		precio.setLocation(p);
		p.y+=d.height+separacion;
		ne.add(precio);
		
		JComboBox carro = new JComboBox();
		for(int i=0;i<cantidadCarros;i++) {
			carro.addItem(new Carro(carros[i]));
		}
		for(int i=0;i<cantidadGuaguas;i++) {
			carro.addItem(new Guagua(guaguas[i]));
		}
		carro.setSize(d);
		carro.setLocation(p);
		p.y+=d.height+separacion;
		ne.add(carro);
		
		JComboBox<String> tipo = new JComboBox<String>();
		tipo.addItem("Libre");
		tipo.addItem("Guiada");
		tipo.setSize(d);
		tipo.setLocation(p);
		p.y+=d.height+separacion;
		ne.add(tipo);
		
		JButton aceptar = new JButton("A�adir Excursi�n");
		aceptar.setSize(d);
		aceptar.setLocation(p);
		aceptar.addActionListener((ActionListener)->{
			try {
				String n = nombre.getText();
				if(n==null)return;
				int   no = Integer.parseInt(numero.getText());
				float pr = Float.parseFloat(precio.getText());
				Carro c  = (Carro)carro.getSelectedItem();
				if(c==null)return;
				String t = (String)tipo.getSelectedItem();
				if(t==null)return;
				if(t.equals("Guiada")) {
					String nombreguia = JOptionPane.showInputDialog("Nombre del guia");
					if(nombreguia==null)return;
					ExcursionDirigida e = new ExcursionDirigida(n,no,pr,c,nombreguia);
					excursionesDirigidas[cantidadExcursionesDirigidas++] = e;
					
				}
				else {
					Excursion e = new Excursion(n,no,pr,c);
					excursiones[cantidadExcursiones++] = e;
				}
				
				limpiar(ne.getContentPane(),new String[]{"Nombre de la excursion","Numero de la excursion","Precio por persona"});
				JOptionPane.showMessageDialog(null, "Excursion a�adida con exito");
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			}
		});
		p.y+=d.height+separacion;
		ne.add(aceptar);
		ne.setSize(ne.getWidth(),p.y+50);
		ne.setLocationRelativeTo(null);
		ne.setVisible(true);
	}
	
	void nuevoCliente() {
		JDialog nc = new JDialog();
		nc.setResizable(false);
		visible=nc;
		nc.setTitle("Nueva Reservaci�n");
		nc.setLayout(null);
		nc.setSize(260,500);
		Dimension d = new Dimension(235,30);
		Point p = new Point(5,5);
		int separacion = 5;
		
		JTextField nombre = new JTextField("Nombre del cliente");
		nombre.setSize(d);
		nombre.setLocation(p);
		p.y+=d.height+separacion;
		nc.add(nombre);
		
		JTextField pasaporte = new JTextField("Pasaporte del cliente");
		pasaporte.setSize(d);
		pasaporte.setLocation(p);
		p.y+=d.height+separacion;
		nc.add(pasaporte);
		
		JComboBox<String> sexo = new JComboBox<String>();
		sexo.setSize(d);
		sexo.setLocation(p);
		sexo.addItem("Masculino");
		sexo.addItem("Femenino");
		p.y+=d.height+separacion;
		nc.add(sexo);
		
		JComboBox<Excursion> excursion = new JComboBox<Excursion>();
		excursion.setSize(d);
		excursion.setLocation(p);
		for(int i=0;i<cantidadExcursiones;i++) 
			excursion.addItem(excursiones[i]);
		for(int i=0;i<cantidadExcursionesDirigidas;i++) 
			excursion.addItem(excursionesDirigidas[i]);
		p.y+=d.height+separacion;
		nc.add(excursion);
		
		JButton aceptar = new JButton("A�adir Reservaci�n");
		aceptar.setSize(d);
		aceptar.setLocation(p);
		aceptar.addActionListener((ActionEvent)->{
			Persona c;
			try {
				Excursion e = (Excursion)excursion.getSelectedItem();
				String n = nombre.getText();
				char s = ((String)sexo.getSelectedItem()).charAt(0);
				String pas = pasaporte.getText();
				c = new Persona(n,s,pas);
				if(c==null)return;
				if(!e.nuevoCliente(c)) {
					JOptionPane.showMessageDialog(null, "No hay capacidad");
					return;
				}
				limpiar(nc.getContentPane(),new String[]{"Nombre del cliente","Pasaporte del cliente"});
				JOptionPane.showMessageDialog(null, "Reserva a�adiad con exito");
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			}
		});
		p.y+=d.height+separacion;
		nc.add(aceptar);
		nc.setSize(nc.getWidth(),p.y+50);
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);;
		
	}
	
	void nuevoCarro() {
		JDialog nc = new JDialog();
		nc.setResizable(false);
		visible=nc;
		nc.setTitle("Nuevo Vehiculo");
		nc.setSize(260,500);
		nc.setLayout(null);
		Dimension d = new Dimension(235,30);
		Point p = new Point(5,5);
		int separacion = 5;
		
		JTextField chapa = new JTextField("Chapa del vehiculo");
		chapa.setSize(d);
		chapa.setLocation(p);
		p.y+=d.height+separacion;
		nc.add(chapa);
		
		JTextField capacidad = new JTextField("Capacidad del vehiculo");
		capacidad.setSize(d);
		capacidad.setLocation(p);
		p.y+=d.height+separacion;
		nc.add(capacidad);
		
		JComboBox<Persona> chofer = new JComboBox<Persona>();
		for(int i=0;i<cantidadChofers;i++) {
			chofer.addItem(chofers[i]);
		}
		chofer.setSize(d);
		chofer.setLocation(p);
		p.y+=d.height+separacion;
		nc.add(chofer);
		
		JComboBox<String> tipo= new JComboBox<String>();
		tipo.addItem("Guagua");
		tipo.addItem("Auto Ligero");
		tipo.setSize(d);
		tipo.setLocation(p);
		p.y+=d.height+separacion;
		nc.add(tipo);
		
		JButton aceptar = new JButton("A�adir Vehiculo");
		aceptar.setSize(d);
		aceptar.setLocation(p);
		aceptar.addActionListener((ActionEvent)->{
			try {
				String ch = chapa.getText();
				Persona c = (Persona)chofer.getSelectedItem();
				int cap = Integer.parseInt(capacidad.getText());
				String t = (String)tipo.getSelectedItem();
				
				if(t.equals("Guagua")) {
					int pisos = Integer.parseInt(JOptionPane.showInputDialog("Pisos de la guagua"));
					Guagua car = new Guagua(ch,c,cap,t,pisos);
					guaguas[cantidadGuaguas++] = car;
				}
				else {
					Carro car = new Carro(ch,c,cap,t);
					carros[cantidadCarros++] = car;
				}
				
				limpiar(nc.getContentPane(),new String[]{"Chapa del vehiculo","Capacidad del vehiculo"});
				JOptionPane.showMessageDialog(null, "Vehiculo a�adido con exito");
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			}
		});
		p.y+=d.height+separacion;
		nc.add(aceptar);
		nc.setSize(nc.getWidth(),p.y+50);
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);
	}

	void nuevoChofer() {
		JDialog nc = new JDialog();
		nc.setResizable(false);
		visible=nc;
		nc.setTitle("Nuevo Chofer");
		nc.setSize(260,500);
		nc.setLayout(null);
		nc.setLayout(null);
		Dimension d = new Dimension(235,30);
		Point p = new Point(5,5);
		int separacion = 5;
		
		JTextField nombre = new JTextField("Nombre del chofer");
		nombre.setSize(d);
		nombre.setLocation(p);
		p.y+=d.height+separacion;
		nc.add(nombre);
		
		JComboBox<String> sexo = new JComboBox<String>();
		sexo.setSize(d);
		sexo.setLocation(p);
		sexo.addItem("Masculino");
		sexo.addItem("Femenino");
		p.y+=d.height+separacion;
		nc.add(sexo);
		
		JButton aceptar = new JButton("A�adir Chofer");
		aceptar.setSize(d);
		aceptar.setLocation(p);
		aceptar.addActionListener((ActionEvent)->{
			Persona c;
			try {
				String n = nombre.getText();
				char s = ((String)sexo.getSelectedItem()).charAt(0);
				c = new Persona(n,s);
				if(c==null)return;
				chofers[cantidadChofers++] = c;
				limpiar(nc.getContentPane(),new String[]{"Nombre del chofer"});
				JOptionPane.showMessageDialog(null, "Chofer a�adido con exito");
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			}
		});
		p.y+=d.height+separacion;
		nc.add(aceptar);
		nc.setSize(nc.getWidth(),p.y+50);
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);
	}
		
	void verDatos() {
		JDialog ver = new JDialog();
		ver.setResizable(false);
		JPanel data = new JPanel();
		data.setLayout(null);
		visible=ver;
		ver.setSize(650,500);
		ver.setLayout(null);
		ver.setLocationRelativeTo(null);
		JScrollPane sp = new JScrollPane(data);
		sp.setSize(650,460);
		int cc=0;
		for(Excursion i:excursiones) {
			if(i==null)break;
			cc+=i.getCarro().getOcupados();
		}
		for(ExcursionDirigida i:excursionesDirigidas) {
			if(i==null)break;
			cc+=i.getCarro().getOcupados();
		}
		JLabel totalExcursiones = new JLabel("Excursiones/Clientes: "+(cantidadExcursiones+cantidadExcursionesDirigidas)+"/"+cc);
		totalExcursiones.setSize(200,30);
		totalExcursiones.setLocation(5,5);
		float total=0;
		
		for(int i=0;i<cantidadExcursiones;i++) {
			total+=excursiones[i].getRecaudacion();
		}
		for(int i=0;i<cantidadExcursionesDirigidas;i++) {
			total+=excursionesDirigidas[i].getRecaudacion();
		}
		
		JLabel totalGanancias = new JLabel("Ganancias totales: "+total);
		totalGanancias.setSize(200,30);
		totalGanancias.setLocation(ver.getWidth()-5-totalGanancias.getWidth(),5);
		JComboBox<String> opciones = new JComboBox<String>();
		
		String ops[] = {"Todas las Excursiones","Excursiones en Guagua","Excursiones Guiadas por...","Excursiones Dirigidas","Datos por numero","Excursion bajo precio y muchos turistas"};
		for(String i:ops)
			opciones.addItem(i);
		
		opciones.setSelectedIndex(-1);
		opciones.addActionListener((ActionEvent)->{
			data.removeAll();
			data.repaint();
			String op = (String)opciones.getSelectedItem();
			Dimension d = new Dimension(200,30);
			Point p = new Point(5,5);
			if(op.equals(ops[0])) {//VER DATOS DE TODAS LAS EXCURSIONES
				Excursion[] excs = new Excursion[cantidadExcursiones+cantidadExcursionesDirigidas];
				for(int i=0;i<cantidadExcursiones;i++)
					excs[i]= new Excursion(excursiones[i]);
				for(int i=0;i<cantidadExcursionesDirigidas;i++)
					excs[i+cantidadExcursiones] = new Excursion(excursionesDirigidas[i]);
				ordenar(excs);
				
				for(Excursion i:excs) {
					if(i==null)continue;
					JLabel nombre = new JLabel(i.getNombre());
					nombre.setSize(d);
					nombre.setLocation(p);
					nombre.setOpaque(true);
					System.out.println(nombre.getSize()+" "+nombre.getLocation());
					p.x+=d.width+5;
					data.add(nombre);
					
					JLabel ganancia = new JLabel(""+i.getRecaudacion());
					ganancia.setSize(d);
					ganancia.setLocation(p);
					p.x+=d.width+5;
					data.add(ganancia);
					p.x=5;
					p.y+=d.height+5;
					System.out.println(i.getNombre()+"\t"+i.getRecaudacion());
					sp.revalidate();
					data.repaint();
				
				}
				
 			}
			
			else if(op.equals(ops[1])) {//VER EXCURSIONES EN GUAGUA
				for(int k=0;k<cantidadExcursiones;k++) {
					Excursion i = excursiones[k];
					System.out.println(i.getCarro().getClass());
					if(i.getCarro().getClass()==Guagua.class) {
						JLabel nombre = new JLabel(i.getNombre());
						nombre.setSize(d);
						nombre.setLocation(p);
						nombre.setOpaque(true);
						System.out.println(nombre.getSize()+" "+nombre.getLocation());
						p.x+=d.width+5;
						data.add(nombre);
						
						JLabel ganancia = new JLabel(""+i.getRecaudacion());
						ganancia.setSize(d);
						ganancia.setLocation(p);
						p.x+=d.width+5;
						data.add(ganancia);
						p.x=5;
						p.y+=d.height+5;
						System.out.println(i.getNombre()+"\t"+i.getRecaudacion());
						sp.revalidate();
						data.repaint();
					}
				}
				for(int k=0;k<cantidadExcursionesDirigidas;k++) {
					Excursion i = excursionesDirigidas[k];
					System.out.println(i.getCarro().getClass());
					if(i.getCarro().getClass()==Guagua.class) {
						JLabel nombre = new JLabel(i.getNombre());
						nombre.setSize(d);
						nombre.setLocation(p);
						nombre.setOpaque(true);
						System.out.println(nombre.getSize()+" "+nombre.getLocation());
						p.x+=d.width+5;
						data.add(nombre);
						
						JLabel ganancia = new JLabel(""+i.getRecaudacion());
						ganancia.setSize(d);
						ganancia.setLocation(p);
						p.x+=d.width+5;
						data.add(ganancia);
						p.x=5;
						p.y+=d.height+5;
						System.out.println(i.getNombre()+"\t"+i.getRecaudacion());
						sp.revalidate();
						data.repaint();
					}
				}
			}
			
			else if(op.equals(ops[2])) {//EXCURSIONES GUIADAS POR ...(Nombre)   muestas las excursinoes que dirigio un guia
				String nombreGuia = JOptionPane.showInputDialog("Nombre o parte de el");
				for(int k=0;k<cantidadExcursionesDirigidas;k++) {
					ExcursionDirigida i = excursionesDirigidas[k];
					if(i.getGuia().contains(nombreGuia)) {
						JLabel nombre = new JLabel(i.getNombre()+"=>"+i.getGuia());
						nombre.setSize(d);
						nombre.setLocation(p);
						nombre.setOpaque(true);
						System.out.println(nombre.getSize()+" "+nombre.getLocation());
						p.x+=d.width+5;
						data.add(nombre);
						
						JLabel ganancia = new JLabel(""+i.getRecaudacion());
						ganancia.setSize(d);
						ganancia.setLocation(p);
						p.x+=d.width+5;
						data.add(ganancia);
						p.x=5;
						p.y+=d.height+5;
						System.out.println(i.getNombre()+"\t"+i.getRecaudacion());
						sp.revalidate();
						data.repaint();
					}
				}
			}
			else if(op.equals(ops[3])) {//VER TODAS LAS Excursiones Dirigidas
				for(int k=0;k<cantidadExcursionesDirigidas;k++) {
					ExcursionDirigida i = excursionesDirigidas[k];
					
					JLabel nombre = new JLabel(i.getNombre()+"=>"+i.getGuia());
					nombre.setSize(d);
					nombre.setLocation(p);
					nombre.setOpaque(true);
					System.out.println(nombre.getSize()+" "+nombre.getLocation());
					p.x+=d.width+5;
					data.add(nombre);
					
					JLabel ganancia = new JLabel(""+i.getRecaudacion());
					ganancia.setSize(d);
					ganancia.setLocation(p);
					p.x+=d.width+5;
					data.add(ganancia);
					p.x=5;
					p.y+=d.height+5;
					System.out.println(i.getNombre()+"\t"+i.getRecaudacion());
					sp.revalidate();
					data.repaint();
					
				}
			}
			
			else if(op.equals(ops[4])) {//SEGUN NUMERO DE EXCURSION VER SUS DATOS
				int numero=-1;
				
				try {
					numero = Integer.parseInt(JOptionPane.showInputDialog("Numero de la excursion"));
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(opciones, "Debe poner un numero");
				}
				
				String datos="No hay excursion con ese numero";
				for(Excursion i:excursiones) {
					if(i==null)continue;
					if(i.getNumero()==numero) {
						datos=i.Reporte();
						break;
					}
				}
				if(datos.equals("No hay excursion con ese numero"))
					for(ExcursionDirigida i:excursionesDirigidas) {
						if(i==null)continue;
						if(i.getNumero()==numero) {
							datos=i.Reporte();
							break;
						}
					}	
				JOptionPane.showMessageDialog(null, datos);
			}			
			
			else if(op.equals(ops[5])) {//menos de 15 pesos y 50 turistas
				
				
				int cantidad =0;
				
				for(int k = 0;k<cantidadExcursiones;k++) {
					Excursion i = excursiones[k];
					if(i.getRecaudacion()/i.getPrecioPersona()>=50&&
							i.getPrecioPersona()<=15) {
						cantidad++;
					}
				}
				
				for(int k = 0;k<cantidadExcursionesDirigidas;k++) {
					Excursion i = excursionesDirigidas[k];
					if(i.getRecaudacion()/i.getPrecioPersona()>=50&&
							i.getPrecioPersona()<=15) {
						cantidad++;
					}
				}
				
				JOptionPane.showMessageDialog(null, "Con estos requisitos hay "+cantidad+" excursiones");
			}
			data.repaint();
			
		});
		opciones.setSize(200,30);
		opciones.setLocation((ver.getWidth()/2)-(opciones.getWidth()/2),5);
		
		sp.setLocation(0,40);
		ver.add(totalExcursiones);
		ver.add(totalGanancias);
		ver.add(sp);
		ver.add(opciones);
		ver.setVisible(true);
	}
	
	void ordenar(Excursion[] v) {
		for(int i=0;i<v.length;i++)
			for(int j=1;j<v.length;j++)
				if(v[j].getRecaudacion()>v[j-1].getRecaudacion()) {
					Excursion temp = v[j];
					v[j]=v[j-1];
					v[j-1]=temp;
				}
	}
	
	//AQUI SE TRABAJA CON FICHEROS
	void generarReporte() {
		File file ; 
		FileWriter reporte;
		Scanner entry;
		try {
			file = new File("administracion de excursiones.txt");//fichero a leer
			reporte = new FileWriter("Reporte.txt");
			entry = new Scanner(file);
			int reportes = 0;
			do {
				int buscar = entry.nextInt();
				for(int i=0;i<cantidadExcursiones;i++) {
					if(excursiones[i].getNumero()==buscar) {
						reporte.write(excursiones[i].Reporte());
						reportes++;
						continue;
					}
				}
				for(int i=0;i<cantidadExcursionesDirigidas;i++) {
					if(excursionesDirigidas[i].getNumero()==buscar) {
						reporte.write(excursionesDirigidas[i].Reporte());
						reportes++;
						continue;
					}
				}
			}while(entry.hasNext());
			reporte.close();
			entry.close();
			JOptionPane.showMessageDialog(null, "SE GENERARON "+reportes+" EN EL FICHERO REPORTE.TXT");
		}
		catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "El FICHERO NUMEROS_EXCURSIONES.TXT NO ES ACCECIBLE");
			return;
		}
		
		
		
	}
	
	void menu() {
		base = new JPanel();
		this.add(base);
		base.setSize(this.getWidth(),this.getHeight());
		base.setLayout(null);
		base.setBackground(Color.white);
		
		Dimension d = new Dimension(200,30);
		Point p = new Point(5,5);
		int separacion=5;
		
		JButton nuevoCliente = new JButton("Nueva Reservaci�n");
		nuevoCliente.setSize(d);
		nuevoCliente.setLocation(p);
		nuevoCliente.addActionListener((ActionListener)->{
			cerrarVisible();
			nuevoCliente();
		});
		p.y+=d.height+separacion;
		
		JButton nuevaExcursion= new JButton("Nuevo Excursi�n");
		nuevaExcursion.setSize(d);
		nuevaExcursion.setLocation(p);
		p.y+=d.height+separacion;
		nuevaExcursion.addActionListener((ActionEvent)->{
			cerrarVisible();
			nuevaExcursion();
		});
		
		
		JButton nuevoCarro = new JButton("Nuevo Carro");
		nuevoCarro.setSize(d);
		nuevoCarro.setLocation(p);
		nuevoCarro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("OBONTONTONONBOTNBOINVOIANAIOD");
				
			}
			
		});
		
		nuevoCarro.addActionListener((ActionEvent)->{
			cerrarVisible();
			nuevoCarro();
		});
		p.y+=d.height+separacion;
		
		JButton nuevoChofer = new JButton("Nuevo Chofer");
		nuevoChofer.setSize(d);
		nuevoChofer.setLocation(p);
		nuevoChofer.addActionListener((ActionEvent)->{
			cerrarVisible();
			nuevoChofer();
		});
		p.y+=d.height+separacion;
		
		JButton verDatos = new JButton("Ver Datos");
		verDatos.setSize(d);
		verDatos.setLocation(p);
		verDatos.addActionListener((ActionEvent)->{
			cerrarVisible();
			verDatos();
		});
		p.y+=d.height+separacion;
		
		JButton generarReporte = new JButton("Generar Reporte");
		generarReporte.setSize(d);
		generarReporte.setLocation(p);
		generarReporte.addActionListener((ActionEvent)->{
			generarReporte();
		});
		p.y+=d.height+separacion;
		
		nuevoCarro.setBackground(Color.gray);
		nuevoChofer.setBackground(Color.gray);
		nuevoCliente.setBackground(Color.gray);
		nuevaExcursion.setBackground(Color.gray);
		verDatos.setBackground(Color.gray);
		generarReporte.setBackground(Color.gray);
		
		nuevoCarro.setOpaque(true);
		nuevoChofer.setOpaque(true);
		nuevoCliente.setOpaque(true);
		nuevaExcursion.setOpaque(true);
		verDatos.setOpaque(true);
		generarReporte.setOpaque(true);
		base.add(nuevoCarro);
		base.add(nuevoChofer);
		base.add(nuevoCliente);
		//base.add(nuevoGuia);
		base.add(nuevaExcursion);
		base.add(verDatos);
		base.add(generarReporte);
	}
	
	//NOMBRES DE LOS FICHEROS DONDE SE GUARDAN LOS DATOS
	String[] datos = {"Excursiones.txt","Carros.txt","Choferes.txt"};

	//GUARDAR DATOS EN UN FICHERO
	void cargarDatos() {
		
		
		try {
			FileInputStream fis = new FileInputStream(datos[0]);
			ObjectInputStream ois = new ObjectInputStream(fis);
			excursiones = (Excursion[])ois.readObject();
			excursionesDirigidas = (ExcursionDirigida[])ois.readObject();
			for(int i=0;i<excursiones.length;i++) {
				if(excursiones[i]==null) {
					cantidadExcursiones=i;
					break;
				}
			}
			for(int i=0;i<excursiones.length;i++) {
				if(excursionesDirigidas[i]==null) {
					cantidadExcursionesDirigidas=i;
					break;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(datos[1]);
			ObjectInputStream ois = new ObjectInputStream(fis);
			carros = (Carro[])ois.readObject();
			guaguas = (Guagua[])ois.readObject();
			for(int i=0;i<carros.length;i++) {
				if(carros[i]==null) {
					cantidadCarros=i;
					break;
				}
			}
			for(int i=0;i<guaguas.length;i++) {
				if(guaguas[i]==null) {
					cantidadGuaguas=i;
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(datos[2]);
			ObjectInputStream ois = new ObjectInputStream(fis);
			chofers = (Persona[])ois.readObject();
			for(int i=0;i<chofers.length;i++) {
				if(chofers[i]==null) {
					cantidadChofers=i;
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//CARGAR DATOS EN UN FICHERO
	void guardarDatos() {
		
		try {
			for(String i:datos) {
				FileOutputStream fos = new FileOutputStream(i);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				if(i.equals(datos[0])) {
					oos.writeObject(excursiones);
					oos.writeObject(excursionesDirigidas);
				}
				else if(i.equals(datos[1])) {
					oos.writeObject(carros);
					oos.writeObject(guaguas);
				}
				else if(i.equals(datos[2]))
					oos.writeObject(chofers);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR DATOS");
		}
		
	}
	
	public Empresa_Turistica() {
		cargarDatos();
		this.setSize(225,300);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Excursions Data Base");
		this.setAlwaysOnTop(true);
		menu();
		this.setVisible(true);
	}
	
}
