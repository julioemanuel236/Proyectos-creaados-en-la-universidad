package banco;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame{
	private Sucursal sucursal = new Sucursal();;
	private final Dimension boton = new Dimension(150,30); 
	
	public void tercero(Container container) {
		container.setLayout(null);
		JTextField nombre = new JTextField("Nombre del Solicitante");
		nombre.setSize(300,30);
		nombre.setLocation(25,10);
		container.add(nombre);
		
		JTextField credito = new JTextField("Credito a Pedir");
		credito.setSize(300,30);
		credito.setLocation(25,nombre.getY()+30+10);
		container.add(credito);
		
		JTextField direccion = new JTextField("Direccion");
		direccion.setSize(300,30);
		direccion.setLocation(25,credito.getY()+30+10);
		container.add(direccion);
		
		JButton personal = new JButton("Personal");
		personal.setSize(140,40);
		personal.setLocation(10+15,direccion.getY()+30+10);
		container.add(personal);
		
		JButton empresa = new JButton("Empresarial");
		empresa.setSize(140,40);
		empresa.setLocation(10+20+15+personal.getWidth(),direccion.getY()+30+10);
		container.add(empresa);
		
		
		
		JPanel pa = new JPanel();
		pa.setLayout(null);
		pa.setSize(370,120);
		pa.setLocation(0,personal.getY()+40+10);
	//	pa.setBackground(Color.DARK_GRAY);
		JPanel em = new JPanel();
		em.setLayout(null);
		em.setSize(370,120);
		em.setLocation(0,empresa.getY()+40+10);
		//em.setBackground(Color.DARK_GRAY);
		container.add(pa);
		container.add(em);
		
		//PERSONAL
		
		JTextField carnet = new JTextField("Carnet");
		carnet.setSize(300,30);
		carnet.setLocation(25,0);
		pa.add(carnet);
		
		JTextField salario = new JTextField("Salario");
		salario.setSize(300,30);
		salario.setLocation(25,40);
		pa.add(salario);
		
		JTextField sustenta = new JTextField("Cantidad de Personas Sustentadas");
		sustenta.setSize(300,30);
		sustenta.setLocation(25,80);
		pa.add(sustenta);
		
		//PERSONAL
		
		//EMPRESARIAL
			
			JTextField nombreDir = new JTextField("Nombre Director");
			nombreDir.setSize(300,30);
			nombreDir.setLocation(25,0);
			em.add(nombreDir);
			
			JTextField dirDir = new JTextField("Direccion del Director");
			dirDir.setSize(300,30);
			dirDir.setLocation(25,nombreDir.getY()+30+10);
			em.add(dirDir);
			
			JTextField ganancias = new JTextField("Ganancias Promedio Anual");
			ganancias.setSize(300,30);
			ganancias.setLocation(25,dirDir.getY()+30+10);
			em.add(ganancias);
			
			JTextField trabajadores = new JTextField("Cantidad de Trabajadores");
			trabajadores.setSize(300,30);
			trabajadores.setLocation(25,ganancias.getY()+30+10);
			em.add(trabajadores);
			
			JTextField ministerio = new JTextField("Ministerio");
			ministerio.setSize(300,30);
			ministerio.setLocation(25,trabajadores.getY()+30+10);
			em.add(ministerio);
			
			JTextField codigo = new JTextField("Codigo");
			codigo.setSize(300,30);
			codigo.setLocation(25,ministerio .getY()+30+10);
			em.add(codigo);
			
			em.setSize(em.getWidth(),codigo.getY()+codigo.getHeight()+10);
		
		//EMPRESARIAL
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pa.setVisible(!pa.isVisible());
				em.setVisible(!em.isVisible());
				personal.setEnabled(!personal.isEnabled());
				empresa.setEnabled(!empresa.isEnabled());
			}
			
		};
		
		personal.addActionListener(al);
		empresa.addActionListener(al);
		em.setVisible(false);
		personal.setEnabled(false);
		
		
		JButton nuevo = new JButton("Aceptar");
		nuevo.setSize(200,50);
		nuevo.setLocation(80,em.getY()+10+em.getHeight());
		
		nuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Solicitud soli;
					String n = nombre.getText();
					float c = Float.parseFloat(credito.getText());
					String dir = direccion.getText();
					
					if(!personal.isEnabled()) {
						String cr = carnet.getText();
						float sal = Float.parseFloat(salario.getText());
						int   sus = Integer.parseInt(sustenta.getText());
						soli = new Personal(n,c,dir,cr,sal,sus);
					}
					
					else {
						String nd = nombreDir.getText();
						String dd = dirDir.getText();
						float  g = Float.parseFloat(ganancias.getText());
						int    ct = Integer.parseInt(trabajadores.getText());
						String m = ministerio.getText();
						String co = codigo.getText();
						soli = new Empresarial(n,c,dir,nd,dd,g,ct,m,co);
					}
					
					sucursal.nuevaSolicitud(soli);
					JOptionPane.showInternalMessageDialog(null, "Solicitud agregada con exito");
			
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "Error en la introduccion de datos");
				}
				
			}
		
		});
		container.add(nuevo);
		
	}
	
	public void mostrarListado(String texto,String titulo) {
		JDialog j = new JDialog();
		j.setResizable(false);
		j.setSize(400,600);
		j.setTitle(titulo);
		j.setLocation(getX()+getWidth(),getY()-(j.getHeight()-getHeight())/2);
		JTextArea txt = new JTextArea();
		
		txt.setSize(j.getSize());
		JScrollPane jsp = new JScrollPane(txt);
		txt.setEditable(false);
		txt.setText(texto);
		j.add(jsp);
		j.setVisible(true);
	}
	
	public void nuevaSolicitud() {
		JDialog j = new JDialog();
		j.setSize(boton);
		j.setSize(370,550);
		j.setTitle("Nueva Solicitud");
		tercero(j.getContentPane());
		j.setLocation(getX()-j.getWidth(),getY()-(j.getHeight()-getHeight())/2);
		j.setVisible(true);
	}
	
	public void botones() {
		JPanel p = new JPanel();
		add(p);
		p.setLayout(null);
		JButton botones[] = new JButton[7];
		botones[0] = new JButton("Nueva Solicitud");
		botones[0].setSize(boton);
		botones[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaSolicitud();
			}
		});
		
		botones[1] = new JButton("Pueden (Personas)");
		botones[1].setSize(boton);
		botones[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarListado(sucursal.listadoPersonasPuedenRecibir(), "solicitudes Aprobadas(Persona)");
			}
		});
		
		botones[2] = new JButton("Pueden (Empresas)");
		botones[2].setSize(boton);
		botones[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								mostrarListado(sucursal.listadoEmpresasPuedenRecibir(), "solicitudes Aprobadas(Empresas)");
			}
		});

		botones[3] = new JButton("Dinero Credito");
		botones[3].setSize(boton);
		botones[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se ha destinado para el credito un total de "+sucursal.dineroTotalCredito()+" de pesos");
			}
		});		
		
		botones[4] = new JButton("Tiempo (Personas)");
		botones[4].setSize(boton);
		botones[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						mostrarListado(sucursal.tiempoPagarPersonales(), "Tiempo en pagar debito de Personas");
			}
		});
		
		botones[5] = new JButton("CP sobre 200");
		botones[5].setSize(boton);
		botones[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							mostrarListado(sucursal.personasConCapacidadDePagoSobre200(), "Personas con capacidad de pago de más de 200");
			}
		});
		
		botones[6] = new JButton("Tiempo (Empresas)");
		botones[6].setSize(boton);
		botones[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						mostrarListado(sucursal.tiempoPagarEmpresariales(), "Tiempo em pagar debito de Empresas");
			}
		});
		
		Point location = new Point(40,25);
		for(int i=0;i<7;i++) {
			if(botones[i]!=null) {
				botones[i].setLocation(location);
				if(i%2==1) {
					location.x=40;
					location.y+=botones[0].getHeight()+10;
				}
				else location.x+=botones[0].getWidth()+10;
				
				p.add(botones[i]);
			}
		}
		botones[6].setLocation(location.x-(int)boton.getWidth()/2,location.y);
	}
	
	public Interfaz() {
		setTitle("Solicitudes de Credito");
		setResizable(false);
		setSize(400,240);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		botones();
		setVisible(true);
		
	}
	
	
	
}
