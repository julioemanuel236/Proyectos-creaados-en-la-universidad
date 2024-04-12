package App;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

import java.util.Random;
public class Ventana extends JFrame{

	JButton entradaButton,salidaButton,buscarButton;
	JPanel mainPanel,entradaPanel,salidaPanel; 
	JPanel actualView;
	JTextArea info;
	JTextArea disponibles;
	JComboBox<String> localizacion;
	Tablero tableroEntrada;
	Random rand = new Random();
	static Almacen almacen = new Almacen();
	static Historial historial = new Historial();	
	
	public void switchView(JPanel panel) {
		if(actualView!=null) 
			actualView.setVisible(false);
		actualView=panel;
		actualView.setVisible(true);
		add(actualView);
		repaint();
		if(actualView==entradaPanel) {
			setTitle("BOOM-Entrada Almacen");
			almacen.actualizarLoc(localizacion);
			disponibles.setText(almacen.disponibles());
			if(tableroEntrada==null)tableroEntrada = newTablero();
			info.setText(tableroEntrada.toString());
			JOptionPane.showMessageDialog(null,tableroEntrada);
		}
		else if(actualView==mainPanel)setTitle("BOOM");
		else if(actualView==salidaPanel)setTitle("BOOM-Salida Tab");
		
	}
	
	private String nextCode() {
		int code = rand.nextInt(10001)+1;
		String cero="0000";
		int size = (int)Math.log10(code);
		return cero.substring(size)+code++;
	}
	
	private Tablero newTablero() {
		return tableroEntrada = new Tablero(nextCode(),rand.nextInt(2));
	}
	
	public Ventana() {
		//setUndecorated(true);		
		/*
		 * esto agregara 500 entradas nuevas, todas las sacara por la linea 205
		 * */
		/*
		  	for(int i=0;i<500;i++) {
			Tablero t = newTablero();
			String p = almacen.disponibles();
			p = p.substring(p.length()-6);
			System.out.println(p);
			almacen.add(t,p);
			almacen.enviarA(t.getCodigo(), "205");
		}*/
		setTitle("BOOM");
		setResizable(false);
		setSize(250,400);
		setLocationRelativeTo(null);
		setLayout(null);
		iniPanels();
		switchView(mainPanel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniEntradaPanel() {
		entradaPanel = new JPanel();
		entradaPanel.setSize(getSize());
		entradaPanel.setVisible(false);
		entradaPanel.setLayout(null);
		entradaPanel.setBackground(Color.white);
		
		JLabel nombre = new JLabel("Entrada a Almacen");
		nombre.setSize(getWidth()-30,getHeight()*1/11);
		nombre.setFont(new Font("Arial",Font.PLAIN,22));
		nombre.setForeground(Color.blue);
		nombre.setLocation(30,0);
		
		JLabel escanear = new JLabel("Escanear Tablero");
		escanear.setSize(getWidth()-15,getHeight()*1/12);
		escanear.setFont(new Font("Arial",Font.PLAIN,20));
		escanear.setForeground(Color.red);
		escanear.setLocation(15,nombre.getHeight()+5);
							
		
		JButton guardar = new JButton("Guardar");
		guardar.setSize((getWidth()/3)+10,getHeight()*1/12);
		guardar.setLocation((getWidth()/4)-(guardar.getWidth()/2)-7,getHeight()-guardar.getHeight()-50);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setSize((getWidth()/3)+10,getHeight()*1/12);
		cancelar.setLocation((3*getWidth()/4)-(guardar.getWidth()/2)-7,getHeight()-guardar.getHeight()-50);
		
		guardar.setBackground(Color.lightGray);
		cancelar.setBackground(Color.lightGray);
		
		JLabel locD = new JLabel("Loc. Disponibles: ");
		JLabel locA = new JLabel("Loc. Almacen: ");
		JLabel comen = new JLabel("Comentarios: ");
		comen.setSize(getWidth()/2,getHeight()*1/10);
		comen.setLocation(5,guardar.getY()-comen.getHeight()-15);
		comen.setHorizontalAlignment(JLabel.LEFT);
		comen.setVerticalAlignment(JLabel.TOP);
		
		locA.setSize(getWidth()/2,getHeight()*1/11);
		locA.setLocation(5,comen.getY()-locA.getHeight()-15);
		locA.setHorizontalAlignment(JLabel.LEFT);
		
		locD.setSize(getWidth()/2,getHeight()*1/7);
		locD.setLocation(5,locA.getY()-locD.getHeight()-15);
		locD.setHorizontalAlignment(JLabel.LEFT);
		locD.setVerticalAlignment(JLabel.TOP);
		
		info = new JTextArea();
		info.setSize(getWidth(),locD.getY()-15-(escanear.getY()+escanear.getHeight()));				
		info.setLocation(5, escanear.getY()+escanear.getHeight()+15);		
		info.setFont(new Font("Arial",Font.BOLD,10));
		info.setEditable(false);
		
		disponibles = new JTextArea();
		disponibles.setSize(locD.getSize());
		disponibles.setLocation(locD.getX()+locD.getWidth()-25,locD.getY());
		disponibles.setBackground(Color.LIGHT_GRAY);		
		disponibles.setEditable(false);
		disponibles.setBorder(new TextFieldBorder());
		
		localizacion= new JComboBox<>();
		localizacion.setSize(locA.getSize());
		localizacion.setLocation(locA.getX()+locA.getWidth()-25,locA.getY());
		localizacion.setBackground(Color.lightGray);
		
		JTextArea comentarios = new JTextArea();
		comentarios.setSize(comen.getSize());
		comentarios.setLocation(comen.getX()+comen.getWidth()-25,comen.getY());
		comentarios.setBorder(new TextFieldBorder());
		
		
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchView(mainPanel);
			}
			
		});
		
		guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				almacen.add(tableroEntrada, (String)localizacion.getSelectedItem());
				tableroEntrada = newTablero();
				switchView(mainPanel);
			}
			
		});
		
		entradaPanel.add(nombre);		
		entradaPanel.add(escanear);
		entradaPanel.add(info);
		entradaPanel.add(disponibles);
		entradaPanel.add(localizacion);
		entradaPanel.add(guardar);
		entradaPanel.add(cancelar);
		entradaPanel.add(comen);
		entradaPanel.add(comentarios);
		entradaPanel.add(locA);
		entradaPanel.add(locD);
	}
	
	private void iniMainPanel() {	
		mainPanel = new JPanel();
		mainPanel.setSize(getSize());
		mainPanel.setVisible(false);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		
		Font font = new Font("Arial",Font.PLAIN,20);
		entradaButton = new JButton("Entrada");
		salidaButton = new JButton("Salida");
		buscarButton = new JButton("Buscar Tablero");
		
		entradaButton.setFocusable(false);
		salidaButton.setFocusable(false);
		buscarButton.setFocusable(false);
		
		entradaButton.setBackground(Color.lightGray);
		salidaButton.setBackground(Color.lightGray);
		buscarButton.setBackground(Color.lightGray);
		
		entradaButton.setFont(font);
		salidaButton.setFont(font);
		buscarButton.setFont(font);
		
		entradaButton.setSize(getWidth()*9/10,getHeight()*1/10);
		salidaButton.setSize(getWidth()*9/10,getHeight()*1/10);
		buscarButton.setSize(getWidth()*9/10,getHeight()*1/10);
		
		entradaButton.setLocation(5,5);
		salidaButton.setLocation(entradaButton.getX(),entradaButton.getY()+entradaButton.getHeight()+5);
		buscarButton.setLocation(entradaButton.getX(),salidaButton.getY()+salidaButton.getHeight()+5);
		
		entradaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchView(entradaPanel);
			}
		});
		
		
		salidaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchView(salidaPanel);
			}
		});			
		
		buscarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Reporte();
				//switchView(salidaPanel);
			}
		});
		mainPanel.add(entradaButton);
		mainPanel.add(salidaButton);
		mainPanel.add(buscarButton);
		
	}
	
	private void iniSalidaPanel() {
		salidaPanel = new JPanel();
		salidaPanel.setSize(getSize());
		salidaPanel.setVisible(false);
		salidaPanel.setLayout(null);
		salidaPanel.setBackground(Color.white);
		
		JLabel nombre = new JLabel("Registro de Salida");
		nombre.setSize(getWidth()-30,getHeight()*1/11);
		nombre.setFont(new Font("Arial",Font.PLAIN,22));
		nombre.setForeground(Color.blue);
		nombre.setLocation(30,0);
		
		JLabel escanear = new JLabel("Escanear Tablero");
		escanear.setSize(getWidth()-15,getHeight()*1/12);
		escanear.setFont(new Font("Arial",Font.PLAIN,20));
		escanear.setForeground(Color.red);
		escanear.setLocation(15,nombre.getHeight()+5);	
		
		JButton guardar = new JButton("Guardar");
		guardar.setSize((getWidth()/3)+10,getHeight()*1/12);
		guardar.setLocation((getWidth()/4)-(guardar.getWidth()/2)-7,getHeight()-guardar.getHeight()-50);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setSize((getWidth()/3)+10,getHeight()*1/12);
		cancelar.setLocation((3*getWidth()/4)-(guardar.getWidth()/2)-7,getHeight()-guardar.getHeight()-50);
		
		JLabel labels[] = new JLabel[5];
		String arr[] = {"Tablero: ","Almacenista: ","Requisitor: ","Ubicacion","Comentarios"};
		for(int i=0;i<5;i++) {
			JLabel jl = new JLabel(arr[i]);
			jl.setSize(getWidth()/2 -30,getHeight()*1/13);
			jl.setLocation(jl.getWidth()/4,2*getHeight()/10+(i*jl.getHeight())+(i*10));
			salidaPanel.add(jl);
			labels[i]=jl;	
		}
		labels[4].setSize(labels[4].getWidth(),labels[4].getHeight()*2);
		labels[4].setVerticalAlignment(JLabel.TOP);
		
		JTextField tablero = new JTextField();
		tablero.setSize(labels[0].getSize());
		tablero.setLocation(getWidth()/2,labels[0].getY());
		tablero.setBackground(Color.lightGray);
		
		JComboBox<String> almacenista = new JComboBox<>();
		almacenista.setSize(labels[1].getSize());
		almacenista.setLocation(getWidth()/2,labels[1].getY());
		almacenista.setBackground(Color.lightGray);
		almacenista.addItem("Jose M");
		almacenista.addItem("Santiago A");
		JTextField requisitor = new JTextField("Produccion");
		requisitor.setSize(labels[2].getSize());
		requisitor.setLocation(getWidth()/2,labels[2].getY());
		requisitor.setBackground(Color.lightGray);
		
		JComboBox<String> ubicacion = new JComboBox<>();
		ubicacion.setSize(labels[3].getSize());
		ubicacion.setLocation(getWidth()/2,labels[3].getY());
		ubicacion.setBackground(Color.lightGray);		
		String ubc[] = {"205","304","310","402"};
		for(int i=0;i<4;i++)
			ubicacion.addItem(ubc[i]);
		
		JTextArea comentarios = new JTextArea();
		comentarios.setSize(labels[4].getSize());
		comentarios.setLocation(getWidth()/2,labels[4].getY());
		comentarios.setBorder(new TextFieldBorder());
		guardar.setBackground(Color.lightGray);
		cancelar.setBackground(Color.lightGray);
		
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchView(mainPanel);
			}
			
		});
		
		guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				almacen.enviarA(tablero.getText(), (String)ubicacion.getSelectedItem());				
				switchView(mainPanel);
			}
			
		});
		
		salidaPanel.add(nombre);
		salidaPanel.add(escanear);
		salidaPanel.add(tablero);
		salidaPanel.add(requisitor);
		salidaPanel.add(almacenista);
		salidaPanel.add(ubicacion);
		salidaPanel.add(comentarios);
		salidaPanel.add(guardar);
		salidaPanel.add(cancelar);
	}
	
	private void iniPanels() {
		iniMainPanel();
		iniEntradaPanel();
		iniSalidaPanel();
	}
		
	public static void main(String []args) {
		new Ventana();
	}
}
