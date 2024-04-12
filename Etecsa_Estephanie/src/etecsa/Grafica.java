package etecsa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Grafica extends JFrame{
	Central central;
	JPanel mostrar;
	JPanel cliente;
	JPanel opciones;
	JTextArea informacion;
	Cliente seleccionado;
	public void Mostrar() {
		mostrar = new JPanel();
		mostrar.setLayout(null);
		mostrar.setSize(getWidth()/2 -10,(getHeight()*4)/5);
		mostrar.setLocation(mostrar.getWidth(),0);
		add(mostrar);
		informacion = new JTextArea();
		informacion.setSize(mostrar.getSize());
		informacion.setEditable(false);
		JScrollPane jsp = new JScrollPane(informacion);
		jsp.setSize(mostrar.getSize());
		mostrar.add(jsp);
	}
	
	public void Cliente() {
		cliente = new JPanel();
		cliente.setSize(mostrar.getSize());
		add(cliente);
		cliente.setLayout(null);
		
		JTextField nombre = new JTextField("Nombre");
		nombre.setSize(cliente.getWidth()-20,30);
		nombre.setLocation(10,10);
		cliente.add(nombre);
		
		JTextField carnet = new JTextField("Carnet");
		carnet.setSize(cliente.getWidth()-20,30);
		carnet.setLocation(10,50);
		cliente.add(carnet);
		
		JTextField direccion = new JTextField("Direccion");
		direccion.setSize(cliente.getWidth()-20,30);
		direccion.setLocation(10,90);
		cliente.add(direccion);
		
		JTextField telefono = new JTextField("Telefono");
		telefono.setSize(cliente.getWidth()-20,30);
		telefono.setLocation(10,130);
		cliente.add(telefono);
		
		JButton resi = new JButton("Residencial");
		JButton esta = new JButton("Estatal");
		
		JPanel residencial = new JPanel();
		residencial.setLayout(null);
		residencial.setVisible(false);
		residencial.setSize(cliente.getWidth(),100);
		JCheckBox matutino = new JCheckBox("Matutino");
		matutino.setSize(nombre.getSize());
		matutino.setLocation(10,10);
		JCheckBox rastreo = new JCheckBox("Rastreo");
		rastreo.setSize(nombre.getSize());
		rastreo.setLocation(10,50);
		residencial.add(matutino);
		residencial.add(rastreo);
		residencial.setLocation(0,240);
		
		JPanel estatal = new JPanel();
		estatal.setVisible(false);
		estatal.setSize(cliente.getWidth(),100);
		JCheckBox arrendada = new JCheckBox("Arrendada");
		arrendada.setSize(nombre.getSize());
		arrendada.setLocation(10,10);
		estatal.add(arrendada);
		estatal.setLocation(0,220);
		resi.setSize(nombre.getWidth()/2 -10,50);
		resi.setLocation(15,170);
		resi.setFocusable(false);
		resi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resi.setEnabled(false);
				esta.setEnabled(true);
				estatal.setVisible(false);
				residencial.setVisible(true);
			}
			
		});
		cliente.add(resi);
		
	
		esta.setSize(nombre.getWidth()/2 -10,50);
		esta.setLocation(15+esta.getWidth()+10,170);
		esta.setFocusable(false);
		esta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resi.setEnabled(true);
				esta.setEnabled(false);
				estatal.setVisible(true);
				residencial.setVisible(false);
				
			}
			
		});
		cliente.add(esta);
		
		cliente.add(residencial);
		cliente.add(estatal);
		
		JButton aceptar = new JButton("Nuevo Cliente");
		aceptar.setSize(nombre.getWidth()-50,50);
		aceptar.setLocation(35,340);
		aceptar.setFocusable(false);
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cl;
				String tipo;
				String n = nombre.getText();
				String c = carnet.getText();
				String dir = direccion.getText();
				
				String tel = telefono.getText();
				
				if(!resi.isEnabled()) {
					tipo = "Residencial";
					boolean m = matutino.isSelected();
					boolean r = rastreo.isSelected();
					cl = new Residencial(n,c,dir,tel,m,r);
				}
				else if(!esta.isEnabled()) {
					boolean a = arrendada.isSelected();
					tipo = "EStatal";
					cl = new Estatal(n,c,dir,tel,a);
				}
				
				else return;
				
				central.nuevoCliente(cl);
				informacion.setText("Cliente "+tipo+" agregado con exito\nID de operacion: "+System.currentTimeMillis());
				nombre.setText("Nombre");
				carnet.setText("Carnet");
				direccion.setText("Direccion");
				telefono.setText("Telefono");
				matutino.setSelected(false);
				rastreo.setSelected(false);
				arrendada.setSelected(false);
			}
			
		});
		cliente.add(aceptar);
		
		JButton seleccionar = new JButton("Seleccionar Cliente");
		seleccionar.setSize(nombre.getWidth()-50,50);
		seleccionar.setLocation(35,400);
		seleccionar.setFocusable(false);
		seleccionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seleccion();
			}
			
		});
		cliente.add(seleccionar);
		
	}

	public void seleccion() {
		JDialog sel = new JDialog();
		sel.setSize(230,600);
		JPanel p = new JPanel();
		p.setPreferredSize(sel.getSize());
		JScrollPane jsp = new JScrollPane(p);
		jsp.setSize(sel.getSize());
		sel.add(jsp);
		
		for(int i=0;i<central.clientes.size();i++) {
			Cliente c = central.clientes.get(i);
			JButton b = new JButton(c.toString());
			b.setSize(150,30);
			p.setPreferredSize(new Dimension(200,i*30+(i*10)));
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					seleccionado = c;
			
					return;					
					
				}
				
			});
			p.add(b);
		}
		
		sel.setVisible(true);
	
	}
	
	public void Opciones() {
		opciones = new JPanel();
		opciones.setLayout(null);
		opciones.setSize(getWidth(),getHeight()/5);
		opciones.setLocation(0,cliente.getHeight());
		opciones.setBackground(Color.DARK_GRAY);
		add(opciones);
		
		JButton cancelar = new JButton("Baja Temporal");
		cancelar.setSize(150,30);
		cancelar.setLocation(5,5);
		cancelar.setBackground(Color.white);
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(seleccionado!=null) {
					int si = JOptionPane.showConfirmDialog(null, "Dar baja temporal al cliente "+seleccionado.toString());
					if(si==0) {
						informacion.setText(central.bajaTemporal(seleccionado));
					}
				}
				else JOptionPane.showMessageDialog(null, "No hay un cliente seleccionado");
			}
			
		});
		opciones.add(cancelar);
		
		JButton pago = new JButton("Pago");
		pago.setSize(150,30);
		pago.setLocation(5+150+5,5);
		pago.setBackground(Color.white);
		pago.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(seleccionado!=null) {
					informacion.setText(""+central.pago(seleccionado));
				}
				else JOptionPane.showMessageDialog(null, "No hay un cliente seleccionado");
			}
			
		});
		opciones.add(pago);
		
		JButton Pago_Clientes = new JButton("Pagos CLientes");
		Pago_Clientes.setSize(150,30);
		Pago_Clientes.setLocation(5+150+5+150+5,5);
		Pago_Clientes.setBackground(Color.white);
		Pago_Clientes.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					informacion.setText(central.pagoClientes());
			}
			
		});
		opciones.add(Pago_Clientes);
		
		JButton rastreo = new JButton("Rastreo");
		rastreo.setSize(150,30);
		rastreo.setLocation(5+150+5+150+5+150+5,5);
		rastreo.setBackground(Color.white);
		rastreo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(seleccionado!=null) {
					informacion.setText(central.rastreo(seleccionado));
				}
				else JOptionPane.showMessageDialog(null, "No hay un cliente seleccionado");
			}			
		});
		opciones.add(rastreo);
		
		JButton mayor_uso = new JButton("Mayor Uso");
		mayor_uso.setSize(150,30);
		mayor_uso.setLocation(5+150+5+150+5+150+5+150+5,5);
		mayor_uso.setBackground(Color.white);
		mayor_uso.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					informacion.setText(central.clienteMasTiempo());				
				
			}			
		});
		opciones.add(mayor_uso);
		
		JButton matutino = new JButton("Matutino");
		matutino.setSize(150,30);
		matutino.setLocation(5+150+5+150+5+150+5+150+5,5);
		matutino.setBackground(Color.white);
		matutino.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					informacion.setText(central.ficheroMatutino(seleccionado));				
				
			}			
		});
		opciones.add(matutino);
		
		JButton teleseleccion = new JButton("Teleseleccion");
		teleseleccion.setSize(150,30);
		teleseleccion.setLocation(5+150+5,40);
		teleseleccion.setBackground(Color.white);
		teleseleccion.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					informacion.setText(central.teleSeleccion());				
				
			}			
		});
		opciones.add(teleseleccion);
		
		JButton metrado = new JButton("Metrado");
		metrado.setSize(150,30);
		metrado.setLocation(5+150+5+150+5,40);
		metrado.setBackground(Color.white);
		metrado.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					informacion.setText(central.pagoMetrado());				
				
			}			
		});
		opciones.add(metrado);
		
		JButton Nuevo_Pais = new JButton("Nuevo Pais");
		Nuevo_Pais.setSize(150,30);
		Nuevo_Pais.setLocation(5+150+5+150+5+150+5,40);
		Nuevo_Pais.setBackground(Color.white);
		Nuevo_Pais.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					String s="Error en los datos";
					try {
						s=central.nuevoPais(JOptionPane.showInputDialog("Codigo Pais"),
								Float.parseFloat(JOptionPane.showInputDialog("Tarifa")));
						
					}
					catch(Exception ee) {
						
					}
					informacion.setText(s);
									
				
			}			
		});
		opciones.add(Nuevo_Pais);
	}
	
	public void inicializar() {
		Mostrar();
		Cliente();
		Opciones();
	}
	
	public Grafica(){
		central = new Central();
		setResizable(false);
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		inicializar();
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Grafica();
	}
}
