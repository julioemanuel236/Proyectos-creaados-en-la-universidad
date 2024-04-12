package banco;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame{
	private Sucursal sucursal;
	private final Dimension boton = new Dimension(150,30); 
	private int opcionNuevo;
	
	public void nuevaSolicitud() {
		JButton botones[] = new JButton[2];
		
		botones[0] = new JButton("Personal");
		botones[1] = new JButton("Empresarial");
		
		botones[0].setSize(boton);
		botones[1].setSize(boton);
		
		botones[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcionNuevo=0;
			}
		});
		botones[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcionNuevo=1;
			}
		});
		String datos="Error en la introduccion de los datos";
		try {
			JOptionPane.showMessageDialog(null, botones);
			Solicitud solicitud=null;
			String nombre = JOptionPane.showInputDialog("Nombre");
			float credito = Float.parseFloat(JOptionPane.showInputDialog("Credito pedido"));
			String direccion = JOptionPane.showInputDialog("Direccion");
			if(opcionNuevo==0) {
				String carnet = JOptionPane.showInputDialog("Carnet");
				float  salario = Float.parseFloat(JOptionPane.showInputDialog("Salario"));
				int    sustenta = Integer.parseInt(JOptionPane.showInputDialog("A cuantas personas sustena sin contarse el/ella"));
				datos = "Nombre:\t"+nombre+'\n'+
						"credito:\t"+credito+'\n'+
						"Direccion:\t"+direccion+'\n'+
						"Carnet:\t"+carnet+'\n'+
						"Salario:\t"+salario+'\n'+
						"A cuantos sustenta:\t"+sustenta+'\n'+
						"DATOS AGRAGADOS CON EXITO\n";
				
				solicitud = new Personal(nombre,credito,direccion,carnet,salario,sustenta);
			}
			else if(opcionNuevo==1) {
				String director = JOptionPane.showInputDialog("Nombre Director de la Empresa: ");
				String direccionDirector = JOptionPane.showInputDialog("Direccion del Director");
				float  gananciaPromedio = Float.parseFloat(JOptionPane.showInputDialog("Ganancia Promedio de los ultimos 5 años"));
				int    trabajadores = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de trabajadores de la empresa"));
				String ministerio = JOptionPane.showInputDialog("Ministerio al que pertenece");  
				String codigo = JOptionPane.showInputDialog("Codigo de la empresa");
				datos = "Nombre:\t"+nombre+'\n'+
						"Credito:\t"+credito+'\n'+
						"Direccion:\t"+direccion+'\n'+
						"Nombre Director:\t"+director+'\n'+
						"Direccion Director:\t"+direccionDirector+'\n'+
						"Ganancias Promedio:\t"+gananciaPromedio+'\n'+
						"Cantidad trabajadores:\t"+trabajadores+'\n'+
						"Ministerio:\t"+ministerio+'\n'+
						"Codigo:\t"+codigo+'\n'+
						"DATOS AGRAGADOS CON EXITO\n";
						
				solicitud = new Empresarial(nombre, credito, direccion, director, direccionDirector, gananciaPromedio, trabajadores, ministerio, codigo);
			}
			else {
				JOptionPane.showMessageDialog(null, "Error en la introducción de datos");
				return;
			}
			sucursal.nuevaSolicitud(solicitud);
			mostrarListado(datos,nombre);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la introducción de datos");
		}
		
		
	}
	
	public void mostrarListado(String texto,String titulo) {
		JDialog j = new JDialog();
		j.setResizable(false);
		j.setSize(300,600);
		j.setTitle(titulo);
		j.setLocationRelativeTo(null);
		JTextArea txt = new JTextArea();
		txt.setSize(j.getSize());
		JScrollPane jsp = new JScrollPane(txt);
		txt.setEditable(false);
		txt.setText(texto);
		j.add(jsp);
		j.setVisible(true);
	}
	
	public void botones() {
		JPanel p = new JPanel();
		add(p);
		p.setLayout(null);
		JButton botones[] = new JButton[8];
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
				mostrarListado(sucursal.tiempoPagarPersonales(), "Tiempo em pagar debito de Personas");
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
		
		
		botones[7] = new JButton("X");
		botones[7].setSize(50,30);
		botones[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		for(int i=0;i<8;i++) {
			if(botones[i]!=null) {
				botones[i].setLocation(boton.width*i,0);
				p.add(botones[i]);
			}
		}
	}
	
	public GUI(){
		sucursal = new Sucursal();
		
		setUndecorated(true);
		setAlwaysOnTop(true);
		setSize(1100,30);
		setLocationRelativeTo(null);
		setLocation(getX(),0);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		botones();
		
		setVisible(true);
	}
}
