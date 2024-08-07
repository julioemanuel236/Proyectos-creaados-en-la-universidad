package tienda;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.io.*;
import java.util.TreeMap;

public class App extends JFrame{
	
	ArrayList<Perro> perros = new ArrayList<Perro>();
	ArrayList<Gato> gatos = new ArrayList<Gato>();
	TreeSet<String> paisOrden = new TreeSet<String>();
	JPanel dataPerro,dataGato,tokenPerro,tokenGato;
	JLabel cantidad;
	JScrollPane datosPerro,datosGato,Paises;
	JTextField paises;
	
	private void addTokenPerro(JPanel token) {
		dataPerro.add(token);
		datosPerro.revalidate();
		tokenPerro=token;
		actualizarPaises();
		Mascota m = new Perro("cuba","negro",5,0);

	}

	private void addTokenGato(JPanel token) {
		dataGato.add(token);		
		datosGato.revalidate();
		tokenGato=token;
		actualizarPaises();
	}
	
	private void actualizarPaises() {
		System.out.println("Actualizando");
		cantidad.setText("Mascotas: "+(perros.size()+gatos.size()));
		paises.setText("");
		for(String i:paisOrden)
			paises.setText(paises.getText()+"   "+i);
		Paises.revalidate();
	}
	
	private void nuevoPerro() {
		try {
			
			String pais = JOptionPane.showInputDialog("Pais de prosedencia:");
			String color = JOptionPane.showInputDialog("Color del perro:");
			int meses = Integer.parseInt(JOptionPane.showInputDialog("Meses de nacido:"));
			int raza = JOptionPane.showOptionDialog(null, "Raza del perro", "Raza",JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, Perro.RAZAS,null);
			
			Perro p = new Perro(pais,color,meses,raza);
			
			paisOrden.add(pais);
			perros.add(p);
			addTokenPerro(p.token(perros,gatos,cantidad,paises,paisOrden,true));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la introducci�n de los datos");
		}
	}

	private void nuevoGato() {
		try {
			String pais = JOptionPane.showInputDialog("Pais de prosedencia:");
			String color = JOptionPane.showInputDialog("Color del gatp:");
			int meses = Integer.parseInt(JOptionPane.showInputDialog("Meses de nacido:"));
			String ojos = JOptionPane.showInputDialog("Color de los ojos:");
			int pedigri = JOptionPane.showOptionDialog(null, "Tiene pedigr�?", "Raza",JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Si","No"},null);
			int sexo = JOptionPane.showOptionDialog(null, "Sexo del gato",  "Raza",JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Masculino","Femenino"},null);
			Gato g = new Gato(pais,color,meses,ojos,(pedigri==0?true:false),(sexo==0?'M':'F'));
			
			paisOrden.add(pais);
			gatos.add(g);
			addTokenGato(g.token(perros,gatos,cantidad,paises,paisOrden,true));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la introducci�n de los datos");
		}
	}
	
	private void Color() {
		Map<String,Integer> colores = new TreeMap<String,Integer>();
	
		for(Gato i:gatos) {
			if(colores.get(i.getColor())==null) {
				System.out.println(colores.size());
				colores.put(i.getColor(), new Integer(1));
			}
			else {
				Integer a = colores.get(i.getColor());
				a++;
				colores.put(i.getColor(), a);
			}
		}
		for(Perro i:perros) {
			if(colores.get(i.getColor())==null) {
				System.out.println(colores.size());
				colores.put(i.getColor(), new Integer(1));
			}
			else {
				Integer a = colores.get(i.getColor());
				a++;
				colores.put(i.getColor(), a);
			}
		}
		
		int menor=10000000;
		String color=null;
		for(String s:colores.keySet()) {
			if(colores.get(s)<menor) {
				color=s;
				menor=colores.get(s);
			}
		}
		JOptionPane.showMessageDialog(null, "El color menos comun es: "+color);
	}
	
	private void porPais() {
		JDialog panel = new JDialog();
		panel.setSize(500,220);
		
		JPanel poner = new JPanel();
		JScrollPane vista = new JScrollPane(poner);
		vista.setVerticalScrollBarPolicy(vista.VERTICAL_SCROLLBAR_NEVER);
		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
		mascotas.addAll(perros);
		mascotas.addAll(gatos);
		
		
		Comparator<Mascota> cmp = new Comparator<Mascota>() {

			@Override
			public int compare(Mascota o1, Mascota o2) {
				
				String a=o1.getPais();
				String b=o2.getPais();
				return a.compareTo(b);
			
			}
			
		};
		
		Collections.sort(mascotas, cmp);
		for(int i=0;i<mascotas.size();i++)
			poner.add(mascotas.get(i).token(perros, gatos, cantidad, paises, paisOrden, false));
		
		panel.add(vista);
		panel.setLocationRelativeTo(null);
		panel.setVisible(true);
	}
	
	private void init() {
		JButton nuevo,salir,nuevoPerro,nuevoGato,masVieja,porPais,guardar,cargar,color,Pais;
		/*
		nuevo = new JButton("+");
		nuevo.setLocation(0,0);
		nuevo.setSize(50,50);
		nuevo.setFont(new Font("Arial",Font.BOLD,30));
		nuevo.setBackground(Color.white);
		nuevo.setOpaque(true);
		nuevo.setBorder(null);
		nuevo.setFocusable(false);
		add(nuevo);
		*/
		
		
		porPais = new JButton("Lugares") ;
		porPais.setLocation(0,100);
		porPais.setSize(50,50);
		porPais.setFont(new Font("Arial",Font.BOLD,10));
		porPais.setBackground(Color.white);
		porPais.setOpaque(true);
		porPais.setBorder(null);
		porPais.setFocusable(false);
		porPais.addActionListener((ActionEvent)->{
			int arr[] = new int[paisOrden.size()];
			String p[] = new String[paisOrden.size()];
			int i=0;
			for(String s:paisOrden)
				p[i++]=s;
			
			for(Gato g:gatos) {
				String pais = g.getPais();
				for(int j=0;j<paisOrden.size();j++)
					if(p[j].equals(pais)) {
						arr[j]++;
						break;
					}
			}
			for(Perro g:perros) {
				String pais = g.getPais();
				for(int j=0;j<paisOrden.size();j++)
					if(p[j].equals(pais)) {
						arr[j]++;
						break;
					}
			}
			String resultado="";
			for(int j=0;j<paisOrden.size();j++)
				resultado+=p[j]+": "+arr[j]+'\n';
			JOptionPane.showMessageDialog(null, resultado);
		});
		add(porPais);
		
		guardar = new JButton("Guardar");
		guardar.setLocation(0,150);
		guardar.setSize(50,50);
		guardar.setFont(new Font("Arial",Font.BOLD,10));
		guardar.setBackground(Color.white);
		guardar.setOpaque(true);
		guardar.setBorder(null);
		guardar.setFocusable(false);
		guardar.addActionListener((ActionEvent)->{
			Guardar();
		});
		add(guardar);
		
		color = new JButton("color");
		color.setLocation(0,200);
		color.setSize(50,50);
		color.setFont(new Font("Arial",Font.BOLD,10));
		color.setBackground(Color.white);
		color.setOpaque(true);
		color.setBorder(null);
		color.setFocusable(false);
		color.addActionListener((ActionEvent)->{
			Color();
		});
		add(color);
		
		Pais = new JButton("Pa�s");
		Pais.setLocation(0,250);
		Pais.setSize(50,50);
		Pais.setFont(new Font("Arial",Font.BOLD,10));
		Pais.setBackground(Color.white);
		Pais.setOpaque(true);
		Pais.setBorder(null);
		Pais.setFocusable(false);
		Pais.addActionListener((ActionEvent)->{
			porPais();
		});
		add(Pais);
		
		/*
		cargar = new JButton("Cargar");
		cargar.setLocation(0,200);
		cargar.setSize(50,50);
		cargar.setFont(new Font("Arial",Font.BOLD,10));
		cargar.setBackground(Color.white);
		cargar.setOpaque(true);
		cargar.setBorder(null);
		cargar.setFocusable(false);
		cargar.addActionListener((ActionEvent)->{
			Cargar();
		});
		add(cargar);
		*/
		
		nuevoPerro = new JButton("+P");
		nuevoPerro.setLocation(0,0);
		nuevoPerro.setSize(50,50);
		nuevoPerro.setFont(new Font("Arial",Font.BOLD,30));
		nuevoPerro.setBackground(Color.white);
		nuevoPerro.setOpaque(true);
		nuevoPerro.setBorder(null);
		nuevoPerro.setFocusable(false);
		nuevoPerro.addActionListener((ActionEvent)->{
			nuevoPerro();
		});
		add(nuevoPerro);
		
		nuevoGato= new JButton("+G");
		nuevoGato.setLocation(0,50);
		nuevoGato.setSize(50,50);
		nuevoGato.setFont(new Font("Arial",Font.BOLD,30));
		nuevoGato.setBackground(Color.white);
		nuevoGato.setOpaque(true);
		nuevoGato.setBorder(null);
		nuevoGato.setFocusable(false);
		nuevoGato.addActionListener((ActionEvent)->{
			nuevoGato();
		});
		add(nuevoGato);
		
		
		cantidad = new JLabel("Mascotas: 0");
		cantidad.setHorizontalAlignment(JLabel.CENTER);
		cantidad.setFont(new Font("Arial",Font.BOLD,20));
		cantidad.setSize(150,50);
		cantidad.setLocation(50,0);
		cantidad.setOpaque(true);
		cantidad.setBackground(Color.white);
		add(cantidad);
		
		paises = new JTextField();
		paises.setEditable(false);
		paises.setOpaque(true);
		paises.setBorder(null);
		paises.setBackground(Color.white);
		paises.setFont(new Font("Arial",Font.BOLD,30));
		paises.setForeground(Color.black);
		Paises = new JScrollPane(paises);
		Paises.setBorder(null);
		Paises.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		Paises.setLocation(cantidad.getX()+cantidad.getWidth(),0);
		Paises.setSize(450,50);
		add(Paises);
		
		masVieja = new JButton("Antigua");
		masVieja.setOpaque(true);
		masVieja.setBorder(null);
		masVieja.setBackground(Color.white);
		masVieja.setFont(new Font("Arial",Font.BOLD,15));
		masVieja.setForeground(Color.black);
		masVieja.setBorder(null);
		masVieja.setLocation(Paises.getX()+Paises.getWidth(),0);
		masVieja.setSize(100,50);
		masVieja.addActionListener((ActionEvent)->{
			if(perros.size()+gatos.size()==0) {
				JOptionPane.showMessageDialog(null, "No hay mascotas");
				return;
			}
			int edad=0;
			JPanel viejas = new JPanel();
			
			for(Mascota i:gatos)
				if(i.getMeses()==edad)viejas.add(i.token(perros,gatos,cantidad,paises,paisOrden,false));
				else if (i.getMeses()>edad) {
					viejas.removeAll();
					edad=i.getMeses();
					viejas.add(i.token(perros,gatos,cantidad,paises,paisOrden,false));
				}
			for(Mascota i:perros)
				if(i.getMeses()==edad)viejas.add(i.token(perros,gatos,cantidad,paises,paisOrden,false));
				else if (i.getMeses()>edad) {
					viejas.removeAll();
					edad=i.getMeses();
					viejas.add(i.token(perros,gatos,cantidad,paises,paisOrden,false));
				}
			JOptionPane.showMessageDialog(null, viejas);
		});
		add(masVieja);		
		
		salir = new JButton("X");
		salir.setFont(new Font("Arial",Font.BOLD,20));
		salir.setHorizontalAlignment(JButton.CENTER);
		salir.setVerticalAlignment(JButton.CENTER);
		salir.setFocusable(false);
		salir.setOpaque(true);
		salir.setBorder(null);
		salir.setBackground(Color.red);
		salir.setSize(50,50);
		salir.setLocation(getWidth()-salir.getWidth(),0);
		salir.addActionListener((ActionEven)->{
			System.exit(0);
		});
		add(salir);
				
		
		
		dataPerro = new JPanel();
		datosPerro = new JScrollPane(dataPerro);
		dataPerro.setSize(850,200);
		datosPerro.setSize(750,200);
		datosPerro.setLocation(50,50);
		dataPerro.setBackground(Color.lightGray);
		add(datosPerro);
		
		dataGato = new JPanel();
		datosGato = new JScrollPane(dataGato);
		dataGato.setSize(850,200);
		datosGato.setSize(750,200);
		datosGato.setLocation(50,250);
		dataGato.setBackground(Color.lightGray);
		add(datosGato);
	}
	
	private void Cargar() {
		try {
			FileInputStream fis = new FileInputStream("datos.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			perros = (ArrayList<Perro>)ois.readObject();
			gatos = (ArrayList<Gato>)ois.readObject();
			paisOrden = (TreeSet<String>)ois.readObject();
			ois.close();
			for(Gato i:gatos)
				if(i!=null)	addTokenGato(i.token(perros,gatos,cantidad,paises,paisOrden,true));
			for(Perro i:perros)
				if(i!=null) addTokenPerro(i.token(perros,gatos,cantidad,paises,paisOrden,true));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void Guardar() {
		try {
			FileOutputStream fos = new FileOutputStream("datos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(perros);
			oos.writeObject(gatos);
			oos.writeObject(paisOrden);
			oos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public App() {
		setSize(800,450);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		init();
		setLocationRelativeTo(null);
		setVisible(true);
		Cargar();
	}
	
	public static void main(String args[]) {
		new App();
	}
}
