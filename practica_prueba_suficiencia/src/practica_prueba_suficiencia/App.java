package practica_prueba_suficiencia;

import javax.management.StringValueExp;
import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;


public class App extends JFrame{

	ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
	ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	class Persona{
		String nombre;
		String apellidos;
		String sexo;
		String ID;
		
		Persona(String[] v){
			nombre=v[0];
			apellidos=v[1];
			sexo=v[2];
			ID=v[3];
		}
		
		Persona(){
			
		}
		
		public String toString(){
			return nombre+"   "+apellidos+"   "+ID;
		}
	}
	
	class Cliente extends Persona{
		int visitas;
		boolean categoria;
		Servicio servicio;
		
		Cliente(String[] v){
			nombre=v[0];
			apellidos=v[1];
			sexo=v[2];
			ID=v[3];
			
		}
		
	}
	
	class Trabajador extends Persona{
		String categoria;
		int aExp;
		Restaurante restaurante;
		
		Trabajador(String[] v){
			nombre=v[0];
			apellidos=v[1];
			sexo=v[2];
			ID=v[3];
			categoria=v[4];
			aExp=Integer.parseInt(v[5]);
		}

		Trabajador(){
			
		}
	}
	
	class Mesero extends Trabajador{
		int mesa;
		
		
		Mesero(String[] v){
			nombre=v[0];
			apellidos=v[1];
			sexo=v[2];
			ID=v[3];
			categoria=v[4];
			aExp=Integer.parseInt(v[5]);
			mesa=Integer.parseInt(v[6]);
		}
		
	}
	
	class Gerente extends Trabajador{
		int tiempoGerencia;
		Gerente(String[] v){
			nombre=v[0];
			apellidos=v[1];
			sexo=v[2];
			ID=v[3];
			categoria=v[4];
			aExp=Integer.parseInt(v[5]);
			tiempoGerencia=Integer.parseInt(v[6]);
		}
	}
	
	class Producto{
		String nombre;
		float precio;
		Servicio servicio;
		Producto(String[] v){
			nombre=v[0];
			precio=Integer.parseInt(v[1]);
		}
		
		public String toString() {
			return nombre+"   "+precio;
		}
	}
	
	class Servicio{
		String nombre;
		Restaurante restaurante;
		ArrayList<Producto>productos = new ArrayList<Producto>();
		
		Servicio(String n){
			nombre=n;
		}
		
		public String toString() {
			return nombre +"   "+ restaurante.toString();
		}
	}
	
	class Restaurante{
		String nombre;
		int categoria; 
		int capacidad;
		String servicios[];
		String proveedores[];
		float porcientoGanancias;
		ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		Restaurante(String[] v){
			nombre=v[0];
			categoria=Integer.parseInt(v[1]);
			capacidad=Integer.parseInt(v[2]);
		}
	
		public String toString() {
			return nombre;
		}
		
	}
	
	class Venta{
		Cliente cliente;
		Servicio servicio;
		Producto producto;
		float coste;
		
		Venta(Cliente cliente,Servicio servicio,Producto producto){
			this.cliente=cliente;
			this.servicio=servicio;
			this.producto=producto;
		}
	}
	
	
	JPanel menu;
	
	String opciones[] = {"Nuevo Trabajador",
			 	         "Nuevo Servicio",
			 	         "Nuevo Producto",
			 	         "Nuevo Restaurante",
			 	         "Nuevo Cliente",
			 	         "Nueva Venta",
			 	         "Guardar Clientes"};
	
	String entradas[][] = {{"Nombre: ","Apellidos: ","sexo: ","Identidad: ","categoria: ","Años de Experiencia: "},
						   {"Nombre: "},
						   {"Nombre: ","Precio: "},
						   {"Nombre: ","Categoria: ","Capacidad: "},
						   {"Nombre: ","Apellidos: ","sexo: ","Identidad: "}};
	
	JPanel paneles[] = new JPanel[opciones.length];
	JPanel seen;
	JComboBox<Restaurante> restaurantes_selection = new JComboBox<Restaurante>();
	JComboBox<Servicio> servicios_selection = new JComboBox<Servicio>();
	JComboBox<Cliente> clientes_selection = new JComboBox<Cliente>();
	Point[] rp = new Point[paneles.length];
	Point[] sp = new Point[paneles.length];
	Point[] cp = new Point[paneles.length];
	
	void cambiarPanel(JPanel p) {
		if(seen!=null)
			seen.setVisible(false);
		try {
			servicios_selection.removeActionListener(selectservice);
		}
		catch(Exception e) {
			
		}
		seen=p;
		if(seen==paneles[0]) {
			restaurantes_selection.setLocation(rp[0]);
			seen.add(restaurantes_selection);
		}
		if(seen==paneles[1]) {
			restaurantes_selection.setLocation(rp[1]);
			seen.add(restaurantes_selection);
		}
		if(seen==paneles[2]) {
			servicios_selection.setLocation(sp[2]);
			seen.add(servicios_selection);
		}
		/*if(seen==paneles[4]) {
			servicios_selection.setLocation(sp[4]);
			seen.add(servicios_selection);
		}*/
		if(seen==paneles[5]) {
			servicios_selection.setLocation(sp[5]);
			clientes_selection.setLocation(cp[5]);
			seen.add(servicios_selection);
			seen.add(clientes_selection);
			servicios_selection.addActionListener(selectservice);
		}		
		seen.setVisible(true);
	}
	
	
	void generar_entradas(JPanel p,String[] v) {
		for(int i=0;i<v.length;i++) {
			JLabel j = new JLabel(v[i]);
			j.setSize(200,30);
			j.setLocation(5,5+(i*j.getHeight())+(i*5));
			p.add(j);
			JTextField txt = new JTextField();
			txt.setLocation(j.getX()+j.getWidth(),j.getY());
			txt.setSize(j.getSize());
			p.add(txt);
		}
		Component k = p.getComponents()[p.getComponentCount()-1];
		Component l = p.getComponents()[p.getComponentCount()-2];
		
		if(p==paneles[0]) {
			JLabel j = new JLabel("Restaurante donde trabaja");
			j.setSize(l.getSize());
			j.setLocation(l.getX(),l.getY()+l.getHeight()+5);
			restaurantes_selection.setSize(k.getSize());
			restaurantes_selection.setLocation(k.getX(),k.getY()+k.getHeight()+5);
			rp[0] = new Point(restaurantes_selection.getLocation());
			k=restaurantes_selection;
			l=j;
			p.add(j);
			p.add(restaurantes_selection);			
		}
		
		if(p==paneles[1]) {
			JLabel j = new JLabel("Restaurante donde se oferta");
			j.setSize(l.getSize());
			j.setLocation(l.getX(),l.getY()+l.getHeight()+5);
			restaurantes_selection.setSize(k.getSize());
			restaurantes_selection.setLocation(k.getX(),k.getY()+k.getHeight()+5);
			rp[1] = new Point(restaurantes_selection.getLocation());
			k=restaurantes_selection;
			l=j;
			p.add(j);
			p.add(restaurantes_selection);			
		}
		
		if(p==paneles[2]) {
			JLabel j = new JLabel("Servicio al que pertenece");
			j.setSize(l.getSize());
			j.setLocation(l.getX(),l.getY()+l.getHeight()+5);
			servicios_selection.setSize(k.getSize());
			servicios_selection.setLocation(k.getX(),k.getY()+k.getHeight()+5);
			sp[2] = new Point(servicios_selection.getLocation());
			k=servicios_selection;
			l=j;
			p.add(j);
			p.add(servicios_selection);
		}
		
		/*if(p==paneles[4]) {
			JLabel j = new JLabel("Servicio que solicitó");
			j.setSize(l.getSize());
			j.setLocation(l.getX(),l.getY()+l.getHeight()+5);
			servicios_selection.setSize(k.getSize());
			servicios_selection.setLocation(k.getX(),k.getY()+k.getHeight()+5);
			sp[4] = new Point(servicios_selection.getLocation());
			k=servicios_selection;
			l=j;
			p.add(j);
			p.add(servicios_selection);
		}*/
		
		JButton nuevo = new JButton("Añadir");
		nuevo.setSize(75,30);	
		nuevo.setLocation(k.getX(),k.getY()+k.getHeight()+5);
		listener(nuevo,p);
		p.add(nuevo);
		
	}
	
	void guardar_clientes() {
		try {
			FileOutputStream fos = new FileOutputStream("Clientes.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientes);
			JOptionPane.showMessageDialog(null, "LOS CLIENTES SE HAN GUARDADO EN EL FICHERO CLIENTES.txt\n"
					+ "LA INFORMACION GUARDADA ESTARÁ DISPONIBLE PARA FUTURAS CORRIDAS");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR LOS CLIENTES EN UN FICHERO");
		}
	}
	
	
	void nuevo_restaurante(String[] txt) {
		try {
			Restaurante r = new Restaurante(txt);
			restaurantes.add(r);
			restaurantes_selection.addItem(r);
		}
		catch(Exception expt) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			expt.printStackTrace();
		}
	}
	
	void nuevo_trabajador(String[] txt,int last) {
		Trabajador t;
		if(txt[4].equals("gerente")) {
			String s = JOptionPane.showInputDialog("Años en el cargo de gerente");
			txt[last]=s;
			try {
				t = new Gerente(txt);
			}
			catch(Exception expt) {
				JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
				expt.printStackTrace();
				return;
			}
		}
		else if(txt[4].equals("mesero")) {
			String s = JOptionPane.showInputDialog("Que mesa atiende este mesero");
			txt[last]=s;
			try {
				t = new Mesero(txt);	
			}
			catch(Exception expt) {
				JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
				expt.printStackTrace();
				return;
			}
		}
		else{
			try {
				t = new Trabajador(txt);						
			}
			catch(Exception expt) {
				JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
				expt.printStackTrace();
				return;
			}
		}
		t.restaurante=(Restaurante)restaurantes_selection.getSelectedItem();
		if(t.restaurante==null) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			return;
		}
		trabajadores.add(t);
	}
	
	void nuevo_producto(String[] txt) {
		Producto p;
		try {
			 p = new Producto(txt);
		}
		catch(Exception expt) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			expt.printStackTrace();
			return;
		}
		p.servicio = (Servicio)servicios_selection.getSelectedItem();
		if(p.servicio==null) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			return;
		}
		p.servicio.productos.add(p);
	
	}
	
	void nuevo_servicio(String[] txt) {
		Servicio s;
		try {
			s = new Servicio(txt[0]);
		}
		catch(Exception expt) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			return;
		}
		s.restaurante = (Restaurante)restaurantes_selection.getSelectedItem();
		if(s.restaurante==null) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			return;
		}
		servicios_selection.addItem(s);
	}
	
	void nuevo_cliente(String[] txt) {
		Cliente c;
		try {
			c = new Cliente(txt);
		}
		catch(Exception expt) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA INTRODUCCION DE DATOS");
			expt.printStackTrace();
			return;
		}
		clientes_selection.addItem(c);
		clientes.add(c);
	}
	
	void listener(JButton nuevo,JPanel p) {
		
		if(p==paneles[3]) {
			nuevo.addActionListener((ActionEvent e)->{
				int c=0;
				String[] txt = new String[(p.getComponentCount()/2)+5];
				for(int i=0;i<p.getComponentCount();i++) {
					Component x = p.getComponents()[i];
					if(x.getClass()==JTextField.class) {
						txt[c++] = ((JTextField)x).getText();
						System.out.println(((JTextField)x).getText());
					}
				}
				final int last=c;
				nuevo_restaurante(txt);
				
			});
		}
		
		if(p==paneles[0]) {
			nuevo.addActionListener((ActionEvent e)->{
				int c=0;
				String[] txt = new String[(p.getComponentCount()/2)+5];
				for(int i=0;i<p.getComponentCount();i++) {
					Component x = p.getComponents()[i];
					if(x.getClass()==JTextField.class) {
						txt[c++] = ((JTextField)x).getText();
						System.out.println(((JTextField)x).getText());
					}
				}
				final int last=c;
				nuevo_trabajador(txt,last);
			});
		}
		
		if(p==paneles[1]) {
			nuevo.addActionListener((ActionEvent e)->{
				int c=0;
				String[] txt = new String[(p.getComponentCount()/2)+5];
				for(int i=0;i<p.getComponentCount();i++) {
					Component x = p.getComponents()[i];
					if(x.getClass()==JTextField.class) {
						txt[c++] = ((JTextField)x).getText();
						System.out.println(((JTextField)x).getText());
					}
				}
				final int last=c;
				nuevo_servicio(txt);
			});
		}
		
		if(p==paneles[2]) {
			nuevo.addActionListener((ActionEvent e)->{
				int c=0;
				String[] txt = new String[(p.getComponentCount()/2)+5];
				for(int i=0;i<p.getComponentCount();i++) {
					Component x = p.getComponents()[i];
					if(x.getClass()==JTextField.class) {
						txt[c++] = ((JTextField)x).getText();
						System.out.println(((JTextField)x).getText());
					}
				}
				final int last=c;
				nuevo_producto(txt);
			});
		}
		
		if(p==paneles[4]) {
			nuevo.addActionListener((ActionEvent e)->{
				int c=0;
				String[] txt = new String[(p.getComponentCount()/2)+5];
				for(int i=0;i<p.getComponentCount();i++) {
					Component x = p.getComponents()[i];
					if(x.getClass()==JTextField.class) {
						txt[c++] = ((JTextField)x).getText();
						System.out.println(((JTextField)x).getText());
					}
				}
				final int last=c;
				nuevo_cliente(txt);
			});
		}
		
		if(p==paneles[5]) {
			
			
		}
	}
	
	ActionListener selectservice;
	
	
	void generar_paneles() {
		for(int i=0;i<paneles.length;i++) {
			JPanel p = new JPanel();
			paneles[i] = p;
			p.setSize(this.getWidth()-menu.getWidth(),this.getHeight());
			p.setLocation(menu.getWidth(),0);
			p.setLayout(null);
			this.add(p);
			p.setVisible(false);
			if(i<entradas.length)
				generar_entradas(p,entradas[i]);
			if(opciones[i].equals("Nueva Venta")) {
				
				Component k = new JPanel();
				Component l = new JPanel();
				l.setSize(200,30);
				l.setLocation(5,-l.getHeight());
				k.setSize(l.getSize());
				k.setLocation(l.getX()+l.getWidth(),l.getY());
			
				JLabel j = new JLabel("Servicio: ");
				j.setSize(l.getSize());
				j.setLocation(l.getX(),l.getY()+l.getHeight()+5);
				servicios_selection.setSize(k.getSize());
				servicios_selection.setLocation(k.getX(),k.getY()+k.getHeight()+5);
				sp[5] = new Point(servicios_selection.getLocation());
				k=servicios_selection;
				l=j;
				p.add(j);
				p.add(servicios_selection);

				j = new JLabel("Producto: ");
				JComboBox<Producto> productos_selection = new JComboBox<Producto>();
				j.setSize(l.getSize());
				j.setLocation(l.getX(),l.getY()+l.getHeight()+5);
				productos_selection.setSize(k.getSize());
				productos_selection.setLocation(k.getX(),k.getY()+k.getHeight()+5);
				k=productos_selection;
				l=j;
				p.add(j);
				p.add(productos_selection);
				
				selectservice = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Servicio s = (Servicio)servicios_selection.getSelectedItem();
						productos_selection.removeAllItems();
						for(Producto pr:s.productos) {
							productos_selection.addItem(pr);
						}
					}
				};
				
				j = new JLabel("Cliente: ");
				j.setSize(l.getSize());
				j.setLocation(l.getX(),l.getY()+l.getHeight()+5);
				clientes_selection.setSize(k.getSize());
				clientes_selection.setLocation(k.getX(),k.getY()+k.getHeight()+5);
				cp[5] = new Point(clientes_selection.getLocation());
				k=clientes_selection;
				l=j;
				p.add(j);
				p.add(clientes_selection);
				
				JButton nuevo = new JButton("Añadir");
				nuevo.setSize(75,30);	
				nuevo.setLocation(k.getX(),k.getY()+k.getHeight()+5);
				listener(nuevo,p);
				p.add(nuevo);
				listener(nuevo, p);
				
			}
		}
	}
	
	void generar_menu() {
		menu = new JPanel();
		menu.setSize(200,this.getHeight());
		menu.setBackground(Color.DARK_GRAY);
		menu.setLayout(null);
		for(int i=0;i<opciones.length;i++) {
			JButton b = new JButton(opciones[i]);
			b.setSize(menu.getWidth()-10,30);
			b.setLocation(5,5+(i*b.getHeight())+(i*5));
			menu.add(b);
			final int k = i;
			b.addActionListener((ActionEvent e)->{
				cambiarPanel(paneles[k]);
			});
		}
		this.add(menu);
	}

	
	App(){
		this.setLayout(null);
		this.setSize(800,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		generar_menu();
		generar_paneles();
		
		this.setVisible(true);
		this.repaint();
	}
	
	
	public static void main(String args[]) {
		new App();
	}
	
}
