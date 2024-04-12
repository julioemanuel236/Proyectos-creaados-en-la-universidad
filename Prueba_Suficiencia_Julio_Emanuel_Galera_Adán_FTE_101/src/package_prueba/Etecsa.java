package package_prueba;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;
import java.util.Scanner;

public class Etecsa extends JFrame{
	
	ArrayList<Cliente_Estatal> CE = new ArrayList<Cliente_Estatal>();
	ArrayList<Cliente_Residencial> CR = new ArrayList<Cliente_Residencial>();
	
	ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
	ArrayList<Llamada_Internacional> llamadasinter = new ArrayList<Llamada_Internacional>();
	ArrayList<Llamada_Interprovincial> llamadasprovin = new ArrayList<Llamada_Interprovincial>();
	
	void newClienteEstatal(String n,String c,String d,String t,boolean can,boolean a) {
		try {
			CE.add(new Cliente_Estatal(n,c,d,t,can,a));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(rootPane, "ERROR AL UNTRODUCIR NUEVO CLIENTE ESTATAL");
		}
	}
	
	void newClienteResidencial(String n,String c,String d,String t,boolean can,boolean m,boolean r) {
		try {
			CR.add(new Cliente_Residencial(n,c,d,t,can,m,r));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(rootPane, "ERROR AL UNTRODUCIR NUEVO CLIENTE RESIDENCIAL");
		}
	}
	
	void bajaMorosidad(Cliente c) {
		if(c==null) {
			JOptionPane.showMessageDialog(null, "NO HAY NADA SELECCIONADO");
			return;
		}
		if(!c.cancelado)
			c.cancelado=true;
		else JOptionPane.showMessageDialog(null, "EL CLIENTE YA ESTA CANCELADO");
	}
	
	void newLLamada(String saliente,String entrante,int minutos, Date fecha) {
		try {
			llamadas.add(new Llamada(minutos,saliente,entrante,fecha));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR LLAMADA LOCAL");
		}
	}
		
	void newLLamadaInter(String saliente,String entrante,int minutos,Date fecha,float tar) {
		try {
			llamadasinter.add(new Llamada_Internacional(minutos,saliente,entrante,fecha,tar));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR LLAMADA LOCAL");
		}	
	}

	void newLLamadaProvi(String saliente,String entrante,int minutos,Date fecha) {
		try {
			llamadasprovin.add(new Llamada_Interprovincial(minutos,saliente,entrante,fecha));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR LLAMADA LOCAL");
		}
	}
	
	void cargarDatos() {
		FileReader fr;
		try {
			fr = new FileReader("REGISTRO.txt");
			Scanner cin = new Scanner(fr);
			while(cin.hasNext()) {
				int minutos = Integer.parseInt(cin.next());
				String numero = cin.next();
				String donde =  cin.next();
				int anio = Integer.parseInt(cin.next());
				int mes = Integer.parseInt(cin.next());
				int dia  = Integer.parseInt(cin.next());
				int hora = Integer.parseInt(cin.next());
				Date fecha = new Date();
				fecha.setDate(dia);
				fecha.setDate(dia);
				fecha.setMonth(mes);
				fecha.setHours(hora);
				if(Llamada_Internacional.formatear(donde)!=null) {
					newLLamadaInter(numero, donde, minutos, fecha,1);
				}
				
				else if(Llamada_Interprovincial.formatear(donde)!=null) {
					newLLamadaProvi(numero, donde, minutos, fecha);
				}
				
				else {
					newLLamada(numero, donde, minutos, fecha);
				}
			}
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,  "ERROR AL ABRIR EL ARCHIVO REGISTRO.TXT");
		}
	}
	
	void NUEVOCLIENTE() {
		JDialog nc = new JDialog();
		nc.setSize(250,400);
		nc.setLayout(null);
		Dimension d = new Dimension(200,30);
		Point p = new Point(5,5);
		
		JTextField nombre = new JTextField("NOMBRE DEL CLIENTE");
		nombre.setSize(d);
		nombre.setLocation(p);
		p.y+=d.height+5;
		nc.add(nombre);
		
		JTextField carnet = new JTextField("CARNET DEL CLIENTE");
		carnet.setSize(d);
		carnet.setLocation(p);
		p.y+=d.height+5;
		nc.add(carnet);
		
		JTextField direccion = new JTextField("DIRECCION DEL CLIENTE");
		direccion.setSize(d);
		direccion.setLocation(p);
		p.y+=d.height+5;
		nc.add(direccion);
		
		JTextField telefono = new JTextField("TELEFONO DEL CLIENTE");
		telefono.setSize(d);
		telefono.setLocation(p);
		p.y+=d.height+5;
		nc.add(telefono);
		
		JComboBox<String> tipo = new JComboBox<String>();
		tipo.setSize(d);
		tipo.setLocation(p);
		tipo.addItem("RESIDENTE");
		tipo.addItem("ESTATAL");
		p.y+=d.height+5;
		nc.add(tipo);
		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setSize(d);
		aceptar.setLocation(p);
		aceptar.addActionListener((ActionEvent)->{
			
				if((tipo.getSelectedItem()).equals("RESIDENTE")) {
					int m = JOptionPane.showConfirmDialog(null, "POSEE SERVICIO MATUTINO","MATITUNO?", JOptionPane.YES_NO_OPTION);
					int r = JOptionPane.showConfirmDialog(null, "POSEE SERVICIO DE RASTREO","RASTREO?", JOptionPane.YES_NO_OPTION);
					newClienteResidencial(nombre.getText(), carnet.getText(), direccion.getText(), telefono.getText(), false,(m==0?true:false),(r==0?true:false));
				}

				else {
					int m = JOptionPane.showConfirmDialog(null, "ES ARRENDADO","ARRENDADO?", JOptionPane.YES_NO_OPTION);
					newClienteEstatal(nombre.getText(), carnet.getText(), direccion.getText(), telefono.getText(), false, (m==0?true:false));
				}
			
		});
		p.y+=d.height+5;
		nc.add(aceptar);
		
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);
	}

	void BAJAMOROSIDAD() {
		JDialog nc = new JDialog();
		nc.setSize(250,400);
		nc.setLayout(null);
		Dimension d = new Dimension(200,30);
		Point p = new Point(5,5);
		
		JComboBox c = new JComboBox();
		
		for(Cliente_Estatal i : CE)
			c.addItem(i);
		for(Cliente_Residencial i : CR)
			c.addItem(i);
		
		c.setSize(d);
		c.setLocation(p);
		p.y+=d.height+5;
		
		JButton baja = new JButton("DAR BAJA");
		baja.setSize(d);
		baja.setLocation(p);
		baja.addActionListener((ActionEvenet)->{
			bajaMorosidad((Cliente)c.getSelectedItem());
		});
		nc.add(baja);
		nc.add(c);
		
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);
		
	}
	
	void PAGOS() {
		JDialog nc = new JDialog();
		nc.setSize(400,400);
		nc.setLayout(null);
		Dimension d = new Dimension(200,30);
		Point p = new Point(5,5);
		JTextArea panel = new JTextArea();
		panel.setEditable(false);
		JScrollPane sp = new JScrollPane(panel);
		sp.setSize(400,400);
		nc.add(sp);
		
		for(Cliente_Estatal i : CE) 
			panel.setText(panel.getText()+"\n"+i.toString()+i.pago());
			
		for(Cliente_Residencial i : CR) 
			panel.setText(panel.getText()+"\n"+i.toString()+i.pago());
			
		sp.revalidate();
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);
	}

	void LLAMADASA() {
		JDialog nc = new JDialog();
		nc.setSize(400,400);
		nc.setLayout(null);
		Dimension d = new Dimension(200,30);
		Point p = new Point(5,5);
		JTextArea panel = new JTextArea();
		panel.setEditable(false);
		JComboBox<Cliente_Residencial> j = new JComboBox();
		
		for(Cliente_Residencial i : CR) 
			if(i.rastreo)j.addItem(i);
		
		j.setLocation(p);
		j.setSize(d);
		j.addActionListener((ActionEvent)->{
			Cliente_Residencial cl = (Cliente_Residencial)j.getSelectedItem();
			if(cl==null) {
				JOptionPane.showMessageDialog(null, "NO HAY NADA SELECCIONADO");
				return;
			}
			for(Llamada i : cl.lle) 
					panel.setText(panel.getText()+"\n"+i.toString());
			
			for(Llamada_Internacional i : cl.llei) 
				panel.setText(panel.getText()+"\n"+i.toString());
			
			for(Llamada_Interprovincial i : cl.llep) 
				panel.setText(panel.getText()+"\n"+i.toString());
		});
		nc.add(j);
		p.y+=d.height+5;
		
		
		
		JScrollPane sp = new JScrollPane(panel);
		sp.setSize(400,400);
		sp.setLocation(p);
		nc.add(sp);
		
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);
	}
	
	void MATUTINO() {
		JDialog nc = new JDialog();
		nc.setSize(400,400);
		nc.setLayout(null);
		Dimension d = new Dimension(200,30);
		Point p = new Point(5,5);
		
		JComboBox<Cliente_Residencial> j = new JComboBox();
		j.setSize(d);
		j.setLocation(p);
		j.addActionListener((ActionEvent)->{
			if(j.getSelectedItem()==null)return;
			((Cliente_Residencial)j.getSelectedItem()).fichero_hora();
		});
		for(Cliente_Residencial i : CR) 
			if(i.matutino)j.addItem(i);
		
		
		nc.add(j);
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);
	}
	
	void MASLLAMO() {
		Cliente c = new Cliente("","","","",false);
		if(CE.isEmpty()&&CR.isEmpty()) {
			JOptionPane.showMessageDialog(null, "NO HAY CLIENTES REGISTADOS");
			return;
		}
		for(Cliente_Estatal i:CE)
			if(i.cantLlamadasSalientes()>c.cantLlamadasSalientes()) {
				c=i;
			}
		
		for(Cliente_Residencial i:CR)
			if(i.cantLlamadasSalientes()>c.cantLlamadasSalientes()) {
				c=i;
			}
		if(c.cantLlamadasSalientes()==0)JOptionPane.showMessageDialog(null, "LOS CLIENTES REGISTRADOS NO HAN REALIZADO LLAMDAS");;
		JOptionPane.showMessageDialog(null, c.toString());
	}
	
	void CLIENTESTELE() {
		JDialog nc = new JDialog();
		nc.setSize(400,400);
		nc.setLayout(null);
		Dimension d = new Dimension(200,30);
		Point p = new Point(5,5);
		JTextArea panel = new JTextArea();
		panel.setEditable(false);
		JScrollPane sp = new JScrollPane(panel);
		sp.setSize(400,400);
		nc.add(sp);
		
		
		JComboBox j = new JComboBox();
		j.setSize(d);
		j.setLocation(p);
		p.y+=d.height+5;
		for(Cliente_Estatal i:CE)
			if(i.llamadasInter.size()>0||i.llamadasProvi.size()>0) {
				float pago=0;
				for(Llamada_Internacional k : i.llamadasInter) {
					pago += k.minutos*(k.tarifa+0.5);
				}
				
				for(Llamada_Interprovincial k :i.llamadasProvi) {
					pago += k.minutos*
							Math.abs(
							Integer.parseInt(k.formatear(k.saliente)[2])-
							Integer.parseInt(k.formatear(k.entrante)[2])
							);
				}
				panel.setText(panel.getText()+"\n"+i.nombre+" "+i.telefono+" "+"$"+pago);
			}
		
		for(Cliente_Residencial i:CR)
			if(i.llamadasInter.size()>0||i.llamadasProvi.size()>0) {
				float pago=0;
				for(Llamada_Internacional k : i.llamadasInter) {
					pago += k.minutos*(k.tarifa+0.5);
				}
				
				for(Llamada_Interprovincial k :i.llamadasProvi) {
					pago += k.minutos*
							Math.abs(
							Integer.parseInt(k.formatear(k.saliente)[2])-
							Integer.parseInt(k.formatear(k.entrante)[2])
							);
				}
				panel.setText(panel.getText()+"\n"+i.nombre+" "+i.telefono+" "+"$"+pago);
			}
		
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);
	}
	
	void METRADO() {
		JDialog nc = new JDialog();
		nc.setSize(400,400);
		nc.setLayout(null);
		Dimension d = new Dimension(200,30);
		Point p = new Point(5,5);
		JTextArea panel = new JTextArea();
		panel.setEditable(false);
		JScrollPane sp = new JScrollPane(panel);
		sp.setSize(400,400);
		nc.add(sp);
		
		
		JComboBox j = new JComboBox();
		j.setSize(d);
		j.setLocation(p);
		p.y+=d.height+5;
		for(Cliente_Estatal i:CE)
			if(i.llamadasInter.size()>0||i.llamadasProvi.size()>0) {
				float tiempo=0;
				for(Llamada k:i.llamadas) {
					tiempo+=k.minutos;
				}
				panel.setText(panel.getText()+"\n"+i.nombre+" "+i.telefono+" "+"$"+(tiempo>300?(tiempo-300)*0.05f:0));
			}
		
		for(Cliente_Residencial i:CR)
			if(i.llamadasInter.size()>0||i.llamadasProvi.size()>0) {
				float tiempo=0;
				for(Llamada k:i.llamadas) {
					tiempo+=k.minutos;
				}
				panel.setText(panel.getText()+"\n"+i.nombre+" "+i.telefono+" "+"$"+(tiempo>300?(tiempo-300)*0.05f:0));
			}
		
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);
	}
	
	String tipo(String s) {
		int c=0;
		boolean alarma=false;
		String temp="";
		for(int i=0;i<s.length();i++) {
			char C=s.charAt(i);
			if(C=='-') {
				c++;
				if(temp=="077")alarma=true;
				temp="";
			}
			if(C!='-'&&(C<'0'||C>'9'))return "no valido";
			
		}
		if(alarma)return "alarma";
		else if(c==3)return "inter";
		else if(c==2)return "provi";
		return "normal";
	}
	
	void NUEVALLAMADA() {
		JDialog nc = new JDialog();
		nc.setSize(400,400);
		nc.setLayout(null);
		Dimension d = new Dimension(200,30);
		Point p = new Point(5,5);
		
		JComboBox j = new JComboBox();
		
		for(Cliente_Estatal i : CE)
			j.addItem(i);
		
		for(Cliente_Residencial i : CR)
			j.addItem(i);
		
		
		
		j.setSize(d);
		j.setLocation(p);
		nc.add(j);
		JButton llamar = new JButton("LLAMAR");
		JButton alarma = new JButton("LLAMAR");
		llamar.setLocation(j.getX()+j.getWidth(),j.getY());
		llamar.setSize(d);
		nc.add(llamar);
		
		llamar.setVisible(false);
		
		j.addActionListener((AcionEvenet)->{
			if(j.getSelectedItem()==null)return;
			if(((Cliente)j.getSelectedItem()).cancelado) {
				JOptionPane.showMessageDialog(null, "USUARIO CANCELADO");
				return;
			}
			llamar.setVisible(true);
			String s = JOptionPane.showInputDialog("NUMERO AL QUE LLAMO");
			Date q = new Date();
			if(j.getSelectedItem().getClass()==Cliente_Residencial.class) {
				Cliente_Residencial cl = (Cliente_Residencial)j.getSelectedItem();
				if(tipo(s)=="alarma") {
					if(!cl.matutino) {
						JOptionPane.showMessageDialog(null, "ERROR, ESE CLIENTE NO DISPONE DE ESE SERVICIO");
						return;
					}
					else cl.hora=s.substring(s.length()-4);
					
					cl.llamadas.add(new Llamada(0,cl.telefono,s,q));
				}
				
				else if(tipo(s)=="inter") {
					
					try {
						float f=Float.parseFloat(JOptionPane.showInputDialog("TARIFA"));
						int  t=Integer.parseInt(JOptionPane.showInputDialog("TIEMPO DE LA LLAMADA"));
						cl.llamadasInter.add(new Llamada_Internacional(t,cl.telefono,s,q,f));
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "TARIFA NO VALIDA");
					}
					
				}
				else if(tipo(s)=="provi") {
					
					try {
						//float f=Float.parseFloat(JOptionPane.showInputDialog("TARIFA"));
						int  t=Integer.parseInt(JOptionPane.showInputDialog("TIEMPO DE LA LLAMADA"));
						cl.llamadasProvi.add(new Llamada_Interprovincial(t,cl.telefono,s,q));
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "TARIFA NO VALIDA");
					}
					
				}
				else if(tipo(s)=="normal") {
					
					try {
						//float f=Float.parseFloat(JOptionPane.showInputDialog("TARIFA"));
						int  t=Integer.parseInt(JOptionPane.showInputDialog("TIEMPO DE LA LLAMADA"));
						cl.llamadas.add(new Llamada(t,cl.telefono,s,q));
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "TARIFA NO VALIDA");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "NUMERO NO VALIDO");
					return;
				}
				
			}
			else {
				Cliente_Estatal cl = (Cliente_Estatal)j.getSelectedItem();
				
				
				if(tipo(s)=="inter") {
					
					try {
						float f=Float.parseFloat(JOptionPane.showInputDialog("TARIFA"));
						int  t=Integer.parseInt(JOptionPane.showInputDialog("TIEMPO DE LA LLAMADA"));
						cl.llamadasInter.add(new Llamada_Internacional(t,cl.telefono,s,q,f));
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "TARIFA NO VALIDA");
					}
					
				}
				else if(tipo(s)=="provi") {
					
					try {
						//float f=Float.parseFloat(JOptionPane.showInputDialog("TARIFA"));
						int  t=Integer.parseInt(JOptionPane.showInputDialog("TIEMPO DE LA LLAMADA"));
						cl.llamadasProvi.add(new Llamada_Interprovincial(t,cl.telefono,s,q));
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "TARIFA NO VALIDA");
					}
					
				}
				else if(tipo(s)=="normal") {
					
					try {
						//float f=Float.parseFloat(JOptionPane.showInputDialog("TARIFA"));
						int  t=Integer.parseInt(JOptionPane.showInputDialog("TIEMPO DE LA LLAMADA"));
						cl.llamadas.add(new Llamada(t,cl.telefono,s,q));
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "TARIFA NO VALIDA");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "NUMERO NO VALIDO");
					return;
				}
				
			}
			
		});
		
		nc.setLocationRelativeTo(null);
		nc.setVisible(true);
	}
	
	void MENU(){
		this.setLayout(null);
		Dimension d = new Dimension(200,30);
		Point p = new Point(5,5);
		
		JButton nuevoCliente = new JButton("NUEVO CLIENTE");
		nuevoCliente.setSize(d);
		nuevoCliente.setLocation(p);
		nuevoCliente.addActionListener((ActionEvente)->{
			NUEVOCLIENTE();
		});
		this.add(nuevoCliente);
		p.y+=d.height+5;
		
		JButton baja = new JButton("DAR BAJA");
		baja.setSize(d);
		baja.setLocation(p);
		baja.addActionListener((ActionEvente)->{
			BAJAMOROSIDAD();
		});
		this.add(baja);
		p.y+=d.height+5;
		
		JButton pagos = new JButton("PAGOS");
		pagos.setSize(d);
		pagos.setLocation(p);
		pagos.addActionListener((ActionEvente)->{
			PAGOS();
		});
		this.add(pagos);
		p.y+=d.height+5;
		
		JButton llamadasa = new JButton("LLAMADAS A...");
		llamadasa.setSize(d);
		llamadasa.setLocation(p);
		llamadasa.addActionListener((ActionEvente)->{
			LLAMADASA();
		});
		this.add(llamadasa);
		p.y+=d.height+5;
		
		JButton matitino = new JButton("MATUTINO DE UN CLIENTE");
		matitino.setSize(d);
		matitino.setLocation(p);
		matitino.addActionListener((ActionEvente)->{
			MATUTINO();
		});
		this.add(matitino);
		p.y+=d.height+5;
		
		
		//ml mas llamo xd xdxdd
		JButton ml = new JButton("CLIENTE CON MAS USO");
		ml.setSize(d);
		ml.setLocation(p);
		ml.addActionListener((ActionEvente)->{
			MASLLAMO();
		});
		this.add(ml);
		p.y+=d.height+5;
		
		JButton metrado = new JButton("PAGO POR METRADO");
		metrado.setSize(d);
		metrado.setLocation(p);
		metrado.addActionListener((ActionEvente)->{
			METRADO();
		});
		this.add(metrado);
		p.y+=d.height+5;
		
		JButton nll = new JButton("NUEVA LLAMADA");
		nll.setSize(d);
		nll.setLocation(p);
		nll.addActionListener((ActionEvente)->{
			NUEVALLAMADA();
		});
		this.add(nll);
		p.y+=d.height+5;
	}
	
	Etecsa(){
		setSize(250,500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MENU();
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Etecsa();
	}
}
