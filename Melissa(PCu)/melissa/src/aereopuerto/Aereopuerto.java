package aereopuerto;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class Aereopuerto extends JFrame {
	String rutaterminales="Terminales.dat";
	String rutaaviones="Aviones.dat";
	JComboBox<String> select_tipo = new JComboBox<String>();
	JComboBox<Avion> select_avion = new JComboBox<Avion>();
	JComboBox<Terminal> select_terminal = new JComboBox<Terminal>();
	JComboBox<Terminal> terminal_vuelos = new JComboBox<Terminal>();
	JTextArea ver = new JTextArea();
	ArrayList<Avion> aviones = new ArrayList<Avion>();
	ArrayList<Terminal> terminales = new ArrayList<Terminal>();

	JPanel opciones;
	JPanel panel_visible=null;
	JPanel paneles[] = new JPanel[10];
	String ops[]= new String[]{"Nueva Terminal","Nuevo Vuelo","Nuevo Avion",
			                   "Hacer Reservacion","Ganancias por Fecha",
			                   "Vuelos por Terminal","Ventas por Vuelo"};
	
	private class Persona implements Serializable{
		String nombre;
		String apellidos;
		
		public Persona(String nombre,String apellidos) {
			this.nombre=nombre;
			this.apellidos=apellidos;
		}
	}
	
	private class Reservacion implements Serializable{
		Persona cliente;
		Asiento asiento;
		Vuelo   vuelo;
		float   precio;
		
		public Reservacion(Persona cliente,Asiento asiento,Vuelo vuelo,float precio){
			this.cliente=cliente;
			this.asiento=asiento;
			this.vuelo  =vuelo;
			this.precio=precio;
		}
	}
	
	private class Asiento implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int numero;
		Persona persona=null;
		int categoria;
		float precio;
		
		public String toString() {
			return ""+categoria;
			
		}
	}	

	private class Avion implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Asiento asiento[];
		String matricula;
		int    cantidadAsientos;
		String modelo;
		String nombre;
		String paisFabricante;
		
		public Avion(String nombre,String modelo,String matricula,String paisfabricante,int cantidadasientos) {
			this.nombre=nombre;
			this.modelo=modelo;
			this.matricula=matricula;
			this.paisFabricante=paisfabricante;
			this.cantidadAsientos=cantidadasientos;
			asiento = new Asiento[this.cantidadAsientos];
			int c1=(cantidadasientos*15)/100;
			int c2=(cantidadasientos*25)/100;
			int c3=(cantidadasientos*60)/100;
			if(c1==0)c1=1;
			if(c2==0)c2=2;
			if(c3==0)c3=3;
			System.out.println(c1+" "+c2+" "+c3);
			for(int i=0;i<cantidadAsientos;i++) {
				asiento[i] = new Asiento();
				asiento[i].numero=i+1;
				if(i<c1)asiento[i].categoria=1;
				else if(i<c1+c2)asiento[i].categoria=2;
				else if(i<=cantidadAsientos)asiento[i].categoria=3;
				System.out.println(asiento[i].numero+" "+asiento[i].categoria);
			}
		}
		
		public String toString() {
			return nombre+" "+modelo+" "+paisFabricante+" "+matricula;
		}
	
		public Avion clone() {
			return new Avion(this.nombre,this.modelo,this.matricula,this.paisFabricante,this.cantidadAsientos);
		}
	}
		
	private class Vuelo implements Serializable{
		Terminal terminal;
		String tipo;
		Avion avion;
		Date salida;
		Date arribo;
		String paisDestino;
		String ciudadDestino;
		int capacidad;
		int ocupado=0;
		int km;
		float preciovuelo;
		float preciokm;
		float precio;
		public Vuelo(String tipo,Date salida,Date arribo,Avion avion,Terminal terminal,
				     String paisDestino,String ciudadDestino,int km,float preciovuelo,float preciokm,float precio) {
			this.tipo=tipo;
			this.avion=avion;
			this.salida=salida;
			this.arribo=arribo;
			this.terminal=terminal;
			this.paisDestino=paisDestino;
			this.ciudadDestino=ciudadDestino;
			this.km=km;
			this.capacidad=avion.cantidadAsientos;
			this.preciovuelo=preciovuelo;
			this.preciokm=preciokm;
			this.precio=precio;
		}
		
		public String toString() {
			return terminal+"\t "+tipo+"\t "+avion.toString()+"\t "+ciudadDestino+"\t "+paisDestino+"\t "
		    +salida.getDate()+"/ "+salida.getMonth()+"/ "+salida.getYear()+"-"+
		    arribo.getDate()+"/"+arribo.getMonth()+"/"+arribo.getYear()+" ";
		}
		
	}
	
	private class Terminal implements Serializable{
		String nombre;
		int    numero;
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		
		public Terminal(String nombre,int numero) {
			this.nombre=nombre;
			this.numero=numero;
		}
		
		public String toString() {
			return nombre;
		}
	}

	private void __init() {
		opciones = new JPanel();
		opciones.setSize(200,this.getHeight()-35);
		opciones.setBackground(Color.DARK_GRAY);
		opciones.setOpaque(true);
		opciones.setLayout(null);
		generar_opciones();
		generar_paneles();
		generar_nueva_terminal();
		generar_nuevo_vuelo();
		generar_nuevo_avion();
		generar_reservacion();
		vuelos_por_terminal();
		ventas_por_vuelo();
		ventas_entre_fechas();
		this.add(opciones);
		
	}

	private void ventas_entre_fechas() {
		JPanel panel = paneles[4];
		JTextField fecha1[]  = new JTextField[3];
		JTextField fecha2[] = new JTextField[3];
		JLabel results= new JLabel();
		results.setSize(panel.getWidth(),panel.getHeight()-50);
		results.setLocation(0,50);
		results.setBackground(Color.gray);
		results.setBorder(null);
		results.setHorizontalAlignment(JLabel.CENTER);
		
		for(int i=0;i<3;i++) {
			JTextField jtf = new JTextField();
			fecha1[i]=jtf;
			jtf.setBorder(null);
			jtf.setSize(60,25);
			jtf.setLocation(100+(i*60)+(i*5),5);
			panel.add(jtf);
		}
		
		for(int i=0;i<3;i++) {
			JTextField jtf = new JTextField();
			fecha2[i]=jtf;
			jtf.setBorder(null);
			jtf.setSize(60,25);
			jtf.setLocation(panel.getWidth()-160-((i*60)+(i*5)),5);
			panel.add(jtf);
		}
		
		JButton aceptar = new JButton("Buscar");
		aceptar.addActionListener((ActionEvent e)->{
			int f1d=Integer.parseInt(fecha1[0].getText());
			int f1m=Integer.parseInt(fecha1[1].getText());
			int f1a=Integer.parseInt(fecha1[2].getText());
			
			int f2a=Integer.parseInt(fecha2[0].getText());
			int f2m=Integer.parseInt(fecha2[1].getText());
			int f2d=Integer.parseInt(fecha2[2].getText());
			
			if(!fecha_valida(f1d, f1m, f1a)|!fecha_valida(f2d, f2m, f2a)) {
				JOptionPane.showMessageDialog(null, "Fechas no validas");
				return;
			}
			
			Date a = new Date();
			Date b = new Date();
			
			a.setDate(f1d);
			a.setMonth(f1m);
			a.setYear(f1a);
			
			b.setDate(f2d);
			b.setMonth(f2m);
			b.setYear(f2a);
			results.setText("");
			float ganancias = 0f;
			for(Terminal t:terminales) {
				for(Vuelo v:((Terminal)t).vuelos) {
					if(v.salida.after(a)&v.arribo.before(b))
						ganancias+=v.precio;
				}
			}
			results.setText("Se ganaron $"+ganancias);
		});
		
		aceptar.setSize(175,40);
		aceptar.setLocation((panel.getWidth()/2)-(aceptar.getWidth()/2),5);
		panel.add(aceptar);
		panel.add(results);
		
		
	}
	
	private void ventas_por_vuelo() {
		JPanel panel = paneles[6];
		JComboBox j = new JComboBox();
		JLabel ganancias = new JLabel();
		j.setSize(panel.getWidth(),30);
		ganancias.setSize(300,30);
		ganancias.setHorizontalAlignment(JLabel.CENTER);
		ganancias.setLocation((panel.getWidth()/2)-(ganancias.getWidth()/2),j.getY()+j.getHeight());
		panel.add(j);
		panel.add(ganancias);
		
		j.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				j.removeAllItems();
				for(Terminal t:terminales) {
					for(Vuelo v:t.vuelos) {
						j.addItem(v);
					}
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		j.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ganancias.setText("El vuelo genero : 0$");
				if(j.getSelectedItem()==null)return;
				float c=0;
				for(Asiento i:((Vuelo)j.getSelectedItem()).avion.asiento) {
					System.out.println(i.persona);
					if(i.persona!=null) {
					    c+=i.precio;
					}
				}
				ganancias.setText("El vuelo genero : "+c+"$");
			}
		});
		
	}
	
	private void limpiar_panel(JPanel panel) {
		guardar_datos_terminales();
		guardar_datos_aviones();
		for(Component i:panel.getComponents()) {
			if(i.getClass()==JTextField.class)
				((JTextField)i).setText("");
			else if(i.getClass()==JComboBox.class)
				((JComboBox)i).setSelectedIndex(-1);
		}
	}
	
	private void guardar_datos_terminales() {
		FileOutputStream fos = null;
		//for(Terminal i:terminales)
		//System.out.println(i);
		try {
			fos = new FileOutputStream(rutaterminales);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(terminales);
			fos.close();
		} catch (Exception e) {
			new JOptionPane().showMessageDialog(null,  "Error al guardar datos");
		}
	}

	private void guardar_datos_aviones() {
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(rutaaviones);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(aviones);
			fos.close();
		} catch (Exception e) {
			new JOptionPane().showMessageDialog(null,  "Error al guardar datos");
		}
	}
		
	private void cargar_datos_terminales() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(rutaterminales);
			ObjectInputStream oos = new ObjectInputStream(fis);
			ArrayList<Terminal> readObject = (ArrayList<Terminal>) oos.readObject();
			terminales = readObject;

			fis.close();
		}
		catch(java.io.FileNotFoundException e) {
			
		}
		catch(Exception e) {
			new JOptionPane().showMessageDialog(null,  "Error al cargar datos");
			e.printStackTrace();
		}
	}

	private void cargar_datos_aviones() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(rutaaviones);
			ObjectInputStream oos = new ObjectInputStream(fis);
			ArrayList<Avion> readObject = (ArrayList<Avion>) oos.readObject();
			aviones = readObject;

			fis.close();
		}
		catch(java.io.FileNotFoundException e) {
			
		}
		catch(Exception e) {
			new JOptionPane().showMessageDialog(null,  "Error al cargar datos");
			e.printStackTrace();
		}
	}
	
	private void vuelos_por_terminal() {
		JPanel panel = paneles[5];
		
		for(Terminal terminal:terminales)
				terminal_vuelos.addItem(terminal);
		
		terminal_vuelos.setSelectedIndex(-1);
		terminal_vuelos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ver.setText(null);
				for(Vuelo i:((Terminal)terminal_vuelos.getSelectedItem()).vuelos) {
					ver.setText(ver.getText()+"\n"+i.toString()+"\n");
				}
			}
		});
		terminal_vuelos.setSize(200,30);
		terminal_vuelos.setLocation((panel.getWidth()/2)-(terminal_vuelos.getWidth()/2),0);
		JScrollPane sp = new JScrollPane(ver);
		sp.setSize(panel.getWidth(),panel.getHeight()-terminal_vuelos.getHeight());
		sp.setLocation((panel.getWidth()/2)-(sp.getWidth()/2),terminal_vuelos.getHeight());
		ver.setBackground(Color.gray);
		ver.setBorder(null);
		ver.setEditable(false);
		
		panel.add(terminal_vuelos);	
		panel.add(sp);
	}
	
	private void generar_nueva_terminal() {
		JPanel panel = paneles[0];
		String textos[] = new String[] {"Nombre","Numero"};
		JTextField entradas[] = new JTextField[2];
		for(int i=0;i<textos.length;i++) {
			JLabel j = new JLabel(textos[i]);
			j.setSize(100,30);
			j.setLocation(5,5+(i*5)+(i*30));
			JTextField jtf = new JTextField();
			entradas[i]=jtf;
			jtf.setSize(200,30);
			jtf.setLocation(5+j.getWidth(),j.getY());
			jtf.setBorder(null);
			panel.add(j);
			panel.add(jtf);
		}
		JButton aceptar = new JButton("Registrar Terminal");
		aceptar.setSize(175,40);
		aceptar.setLocation(panel.getWidth()-5-aceptar.getWidth(),panel.getHeight()-5-aceptar.getHeight());
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean quit=false;
				for(JTextField i:entradas) {
					if(i.getText().equals("")) {
						i.setText("Este campo es obligatorio");
						quit=true;
					}
				}	
				if(quit) {
					new JOptionPane().showMessageDialog(null,  "Rellene todos los campos");
					Aereopuerto.this.setTitle("Hubo un error al añadir la terminal");
					return;
				}
				
				try {
					Terminal nueva = new Terminal(entradas[0].getText(),Integer.parseInt(entradas[1].getText()));
					terminales.add(nueva);
					terminal_vuelos.addItem(nueva);
					select_terminal.addItem(nueva);
				
					for(Component i:panel.getComponents()) {
						if(i.getClass()==JTextField.class)
							((JTextField)i).setText("");
					}
					Aereopuerto.this.setTitle("Terminal añadida con exito");
					limpiar_panel(panel);
				}
				catch(Exception ee) {
					new JOptionPane().showMessageDialog(null,  "Error al registrar la terminal");
					Aereopuerto.this.setTitle("Hubo un error al añadir la terminal");
				}
			}
		});
		panel.add(aceptar);
	}
	
	private void generar_nuevo_avion() {
		JPanel panel = paneles[2];
		String textos[] = new String[] {"Nombre","Modelo","Matricula","Pais Fabricante","Cantidad de asientos"};
		JTextField entradas[] = new JTextField[5];
		for(int i=0;i<textos.length;i++) {
			JLabel j = new JLabel(textos[i]);
			j.setSize(130,30);
			j.setLocation(5,5+(i*j.getHeight())+(i*5));
			JTextField txt = new JTextField();
			txt.setSize(200,j.getHeight());
			txt.setLocation(j.getX()+j.getWidth(),j.getY());
			txt.setBorder(null);
			entradas[i]=txt;
			panel.add(j);
			panel.add(txt);
		}
		JButton aceptar = new JButton("Registrar Avion");
		aceptar.setSize(175,40);
		aceptar.setLocation(panel.getWidth()-5-aceptar.getWidth(),panel.getHeight()-5-aceptar.getHeight());
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean quit=false;
				for(Component i:panel.getComponents()) {
					if(i.getClass()==JTextField.class) {
						JTextField jj= (JTextField)i;
						if(jj.getText().equals("")) {
							quit=true;
							jj.setText("Este campo es obligatorio");
						}
					}
				}
				if(quit) {
					new JOptionPane().showMessageDialog(null,  "Rellene todos los campos");
					Aereopuerto.this.setTitle("Hubo un error al añadir el nuevo avion");
					return;				
				}
				try {
					String nombre=entradas[0].getText();
					String modelo=entradas[1].getText();
					String matricula=entradas[2].getText();
					String pais=entradas[3].getText();
					int    asientos=Integer.parseInt(entradas[4].getText());
					Avion nuevo = new Avion(nombre,modelo,matricula,pais,asientos);
					System.out.println(nuevo);
					select_avion.addItem(nuevo);
					aviones.add(nuevo);
					Aereopuerto.this.setTitle("Avion añadido con exito");
					limpiar_panel(panel);
				}
				catch(Exception ee) {
					new JOptionPane().showMessageDialog(null,  "Error al Registrar el avion");
					System.out.println("hubo un error al añadir un nuevo avion");
					Aereopuerto.this.setTitle("Hubo un error al añadir el nuevo avion");
					ee.printStackTrace();
				}
			}
		});
		panel.add(aceptar);
		
	}
	
	private void generar_reservacion() {
		JPanel panel = paneles[3];
		String textos[] = new String[] {"Nombre","Apellidos","Vuelo","Categoria"};
		JTextField txt[] = new JTextField[2];
		JComboBox jcb[] = new JComboBox[2]; 
		for(int i=0;i<textos.length;i++) {
			JLabel j = new JLabel(textos[i]);
			j.setSize(100,30);
			j.setLocation(5,5+(i*j.getHeight())+(i*5));
			panel.add(j);
			if(i<2) {
				JTextField tx = new JTextField();
				txt[i] = tx;
				tx.setSize(200,30);
				tx.setLocation(j.getX()+j.getWidth(),j.getY());
				tx.setBorder(null);
				panel.add(tx);
			}
			else {
				JComboBox cb = new JComboBox();
				jcb[i-2] = cb;
				cb.setSize(60,30);
				cb.setLocation(j.getX()+j.getWidth(),j.getY());
				if(i==2) {
					cb.setSize(panel.getWidth()-cb.getX(),30);
					cb.addFocusListener(new FocusListener() {

						@Override
						public void focusGained(FocusEvent e) {
							cb.removeAllItems();
							for(Terminal t:terminales) {
								for(Vuelo v:t.vuelos) {
									if(v.ocupado<v.capacidad) {
										cb.addItem(v);
									}
								}
							}
							cb.revalidate();
						}

						@Override
						public void focusLost(FocusEvent e) {
							// TODO Auto-generated method stub
							
						}
						
					});
					cb.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {							
							boolean c[] = new boolean[4];
							jcb[1].removeAllItems();
							if(cb.getSelectedItem()==null)return;
							for(Asiento i:((Vuelo)cb.getSelectedItem()).avion.asiento) {
								if(i.persona==null) {
									if(!c[i.categoria]) {
										jcb[1].addItem(i);
										c[i.categoria]=true;
									}
								}
							}
						}
					});
				}
				panel.add(cb);
			}
		}
		JButton aceptar = new JButton("Registrar Reservacion");
		aceptar.setSize(175,40);
		aceptar.setLocation(panel.getWidth()-aceptar.getWidth()-5,panel.getHeight()-aceptar.getHeight()-5);
		panel.add(aceptar);
		
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean quit=false;
				for(Component i:panel.getComponents()) {
					if(i.getClass()==JTextField.class) {
						JTextField j = (JTextField) i;
						if(j.getText().equals("")) {
							quit=true;
							j.setText("Este campo es obligatorio");
						}														
					}
					else if(i.getClass()==JComboBox.class) {
						JComboBox j= (JComboBox) i;
						if(j.getSelectedItem()==null) {
							quit=true;
						}
					}
						
				}
				if(quit) {
					JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
					return;
				}
				try {
					Persona persona = new Persona(txt[0].getText(),txt[1].getText());
					Asiento asiento = (Asiento)jcb[1].getSelectedItem();
					asiento.precio = ((Vuelo)jcb[0].getSelectedItem()).precio;
					if(asiento.categoria==1)asiento.precio+=asiento.precio*0.3;
					else if(asiento.categoria==2)asiento.precio+=asiento.precio*0.2;
					if(asiento.categoria==3)asiento.precio+=asiento.precio*0.1;
					asiento.persona=persona;
					limpiar_panel(panel);
					Aereopuerto.this.setTitle("reservacion añadida con exito");
				}
				catch(Exception ee) {
					new JOptionPane().showMessageDialog(null,  "Error al registrar la reservación");
					Aereopuerto.this.setTitle("Hubo un error en la reservacion");
				}
			}
		});
	}
	
	private boolean fecha_valida(int dia,int mes,int anio) {
		System.out.println(dia+" "+mes+" "+anio);
		int meses[] = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		
		if(anio%4==0||(anio%100==0&&anio%400==0))meses[1]=29;
		if(mes<0||mes>11)return false;
		if(dia>meses[mes-1]||dia<0)return false;
		return true;
	}
	
	private boolean revisar_fechas(Date a,Date b) {
		return a.before(b);
		
	}
	
	private void generar_nuevo_vuelo() {
		JPanel panel = paneles[1];
		
		String textos[] = new String[] {"Pais Destino","Ciudad Destino","Tipo de Vuelo","Avion","Terminal","Salida D/M/A","Llegada D/M/A","Distancia(KM)","Precio del vuelo","Precio del viaje"};
		for(int i=0;i<textos.length;i++) {
			JLabel j = new JLabel(textos[i]);
			j.setSize(100,30);
			j.setLocation(5,5+(i*40));
			panel.add(j);
		}
		
		
		select_tipo.addItem("Internacional");
		select_tipo.addItem("Nacional");
		select_tipo.setSelectedIndex(-1);
		select_tipo.setSize(200,30);		
		select_avion.setSize(200,30);
		select_terminal.setSize(200,30);
		
		if(aviones!=null)
		for(Avion i:aviones)
			select_avion.addItem(i);
		
		if(terminales!=null)
			for(Terminal t:terminales)
				select_terminal.addItem(t);
		
		select_avion.setSelectedIndex(-1);
		select_terminal.setSelectedIndex(-1);
		
		JTextField salida[]  = new JTextField[3];
		JTextField llegada[] = new JTextField[3];
		
		for(int i=0;i<3;i++) {
			JTextField jtf = new JTextField();
			salida[i]=jtf;
			jtf.setBorder(null);
			jtf.setSize(60,25);
			jtf.setLocation(100+(i*60)+(i*5),205);
			panel.add(jtf);
		}
		
		for(int i=0;i<3;i++) {
			JTextField jtf = new JTextField();
			llegada[i]=jtf;
			jtf.setBorder(null);
			jtf.setSize(60,25);
			jtf.setLocation(100+(i*60)+(i*5),245);
			panel.add(jtf);
		}
		
		JTextField paisDestino = new JTextField();
		paisDestino.setSize(200,30);
		paisDestino.setBorder(null);
		JTextField ciudadDestino = new JTextField();
		ciudadDestino.setSize(200,30);
		ciudadDestino.setBorder(null);
		JTextField KM = new JTextField();
		KM.setSize(200,30);
		KM.setBorder(null);
		JTextField costevuelo = new JTextField();
		costevuelo.setSize(200,30);
		costevuelo.setBorder(null);
		
		JTextField costeviaje = new JTextField();
		costeviaje.setSize(200,30);
		costeviaje.setBorder(null);
		JButton aceptar = new JButton("Registrar Vuelo");
		aceptar.setSize(175,40);
		aceptar.setLocation(panel.getWidth()-5-aceptar.getWidth(),panel.getHeight()-5-aceptar.getHeight());
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean quit=false;
				for(Component i:panel.getComponents()) {
					if(i.getClass()==JTextField.class) {
						JTextField txt = (JTextField)i;
						if(txt.getText().equals("")) {
							quit=true;
							txt.setText("Este campo es obligatorio");
						}
					}
					else if(i.getClass()==JComboBox.class) {
						JComboBox jcb =(JComboBox)i;
						if(jcb.getSelectedItem()==null)quit=true;
					}					
				}
				if(quit) {
					new JOptionPane().showMessageDialog(null,  "Rellene todos los campos");
					Aereopuerto.this.setTitle("Hubo un error al añadir el vuelo");
					return;
				}
				try {
					Date sal=new Date();
					sal.setDate(Integer.parseInt(salida[0].getText()));
					sal.setMonth(Integer.parseInt(salida[1].getText()));
					sal.setYear(Integer.parseInt(salida[2].getText()));
					Date lle=new Date();
					lle.setDate(Integer.parseInt(llegada[0].getText()));
					lle.setMonth(Integer.parseInt(llegada[1].getText()));
					lle.setYear(Integer.parseInt(llegada[2].getText()));
					int ds=Integer.parseInt(salida[0].getText());
					int ms=Integer.parseInt(salida[1].getText());
					int as=Integer.parseInt(salida[2].getText());
					
					int dl=Integer.parseInt(llegada[0].getText());
					int ml=Integer.parseInt(llegada[1].getText());
					int al=Integer.parseInt(llegada[2].getText());
					
					if(!revisar_fechas(sal,lle)|
					   !fecha_valida(ds,ms,as)|
					   !fecha_valida(dl,ml,al)) {
						new JOptionPane().showMessageDialog(null,  "Fechas incorrectas");
						return;
					}
					
					Terminal termin = (Terminal)select_terminal.getSelectedItem();
					float precio=Float.parseFloat(costevuelo.getText());
					if(select_tipo.getSelectedItem().equals("Internacional"))
						precio+=Float.parseFloat(costeviaje.getText())*0.1f;
					else precio+=Float.parseFloat(costeviaje.getText())*0.2f;
					Vuelo nuevo = new Vuelo(select_tipo.getSelectedItem().toString(),sal,lle,
							                ((Avion)select_avion.getSelectedItem()).clone(),termin,
							                paisDestino.getText(),ciudadDestino.getText(),Integer.parseInt(KM.getText()),
							                Float.parseFloat(costevuelo.getText()),Float.parseFloat(costeviaje.getText()),precio);
					termin.vuelos.add(nuevo);
					Aereopuerto.this.setTitle("vuelo añadido con exito");
					
					limpiar_panel(panel);
				}
				catch(Exception ee) {
					new JOptionPane().showMessageDialog(null,  "Error al registrar el vuelo");
					System.out.println("Error al añadir vuelo");
					Aereopuerto.this.setTitle("Hubo un error al añadir el vuelo");
				}
			}
		});
		
		paisDestino.setLocation(100,5);
		ciudadDestino.setLocation(100,45);
		KM.setLocation(100,285);
		select_tipo.setLocation(100,85);
		select_avion.setLocation(100,125);
		select_terminal.setLocation(100,165);
		costevuelo.setLocation(100,325);
		costeviaje.setLocation(100,365);
		panel.add(select_tipo);
		panel.add(select_avion);
		panel.add(select_terminal);
		panel.add(ciudadDestino);
		panel.add(paisDestino);
		panel.add(KM);
		panel.add(costevuelo);
		panel.add(costeviaje);
		panel.add(aceptar);
	}
	
	private void generar_paneles() {
		for(int i=0;i<ops.length;i++) {
			JPanel p = new JPanel();
			paneles[i] = p;
			p.setLayout(null);
			p.setOpaque(true);
			p.setBackground(Color.gray);
			p.setSize(this.getWidth()-opciones.getWidth()-15,opciones.getHeight());
			p.setLocation(opciones.getWidth(),0);
			p.setVisible(false);
			this.add(p);
		}
	}
	
	private void generar_opciones() {
		
		for(int i=0;i<ops.length;i++) {
			JButton jtf = new JButton(ops[i]);
			jtf.setSize(175,50);
			jtf.setLocation((opciones.getWidth()/2)-(jtf.getWidth()/2),5+(i*jtf.getHeight())+(i*5));
			final int pos=i;
			jtf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(panel_visible!=null)
						panel_visible.setVisible(false);
					paneles[pos].setVisible(true);
					panel_visible=paneles[pos];
				}
			});
			opciones.add(jtf);
		}
	}
	
	public Aereopuerto() {
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024,500);
		this.setVisible(true);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		cargar_datos_terminales();
		cargar_datos_aviones();
		JLabel bienvenido = new JLabel("Bienvenido al Sistema de Gestion del Areopuerto José Martí");
		bienvenido.setSize(600,100);
		bienvenido.setFont(new Font("Arial",Font.BOLD,15));
		bienvenido.setLocation(200+(this.getWidth()/2)-(bienvenido.getWidth()/2),
								   (this.getHeight()/2)-(bienvenido.getHeight()/2));
		bienvenido.setVerticalAlignment(JLabel.TOP);
		__init();
		this.add(bienvenido);
		this.repaint();
		
	}
	
	public static void main(String[] args) throws Exception{
		try{
			new Aereopuerto();
		}
		catch(Exception e) {
			
		}
	}

}
