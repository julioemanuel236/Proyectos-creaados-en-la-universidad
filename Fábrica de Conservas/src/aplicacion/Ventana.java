package aplicacion;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Date;

public class Ventana extends JFrame{
	
	JPanel panel;
	JPanel trabajadorPanel,productoPanel,produccionPanel,listasPanel,ficherosPanel;
	String clasificacion;
	
	private void botones(JPanel menu) {
		JButton trabajador = new JButton("Nuevo Trabajador");
		trabajador.setSize(140,35);
		trabajador.setLocation(5,5);
		trabajador.setOpaque(true);
		trabajador.setBackground(Color.darkGray);
		trabajador.setFocusable(false);
		trabajador.setForeground(Color.white);
		trabajador.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(trabajadorPanel);
				panel.repaint();
			}
		});
		menu.add(trabajador);
		
		JButton producto = new JButton("Nuevo Producto");
		producto.setSize(140,35);
		producto.setLocation(5,45);
		producto.setOpaque(true);
		producto.setBackground(Color.darkGray);
		producto.setFocusable(false);
		producto.setForeground(Color.white);
		producto.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(productoPanel);
				panel.repaint();
			}
		});
		menu.add(producto);
		
		JButton produccion = new JButton("Produccion");
		produccion.setSize(140,35);
		produccion.setLocation(5,85);
		produccion.setOpaque(true);
		produccion.setBackground(Color.darkGray);
		produccion.setFocusable(false);
		produccion.setForeground(Color.white);
		produccion.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				produccionPanel();
				panel.repaint();
			}
		});
		menu.add(produccion);

		JButton listas = new JButton("Listas");
		listas.setSize(140,35);
		listas.setLocation(5,125);
		listas.setOpaque(true);
		listas.setBackground(Color.darkGray);
		listas.setFocusable(false);
		listas.setForeground(Color.white);
		listas.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				listasPanel();
				panel.repaint();
			}
		});
		menu.add(listas);
				
		JButton ficheros = new JButton("Ficheros");
		ficheros.setSize(140,35);
		ficheros.setLocation(5,165);
		ficheros.setOpaque(true);
		ficheros.setBackground(Color.darkGray);
		ficheros.setFocusable(false);
		ficheros.setForeground(Color.white);
		ficheros.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(ficherosPanel);
				panel.repaint();
			}
		});
		menu.add(ficheros);
		
		JButton mayorProduccion = new JButton("Mayores Producciones");
		mayorProduccion.setSize(140,35);
		mayorProduccion.setLocation(5,205);
		mayorProduccion.setOpaque(true);
		mayorProduccion.setBackground(Color.darkGray);
		mayorProduccion.setFocusable(false);
		mayorProduccion.setForeground(Color.white);
		mayorProduccion.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fabrica.mayorProduccion();
				
			}
		});
		menu.add(mayorProduccion);

		JButton plan = new JButton("Annadir plan");
		plan.setSize(140,35);
		plan.setLocation(5,245);
		plan.setOpaque(true);
		plan.setBackground(Color.darkGray);
		plan.setFocusable(false);
		plan.setForeground(Color.white);
		plan.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fabrica.plan();
				
			}
		});
		menu.add(plan);
		
		JButton porcentajePlan = new JButton("Procentaje Plan");
		porcentajePlan.setSize(140,35);
		porcentajePlan.setLocation(5,285);
		porcentajePlan.setOpaque(true);
		porcentajePlan.setBackground(Color.darkGray);
		porcentajePlan.setFocusable(false);
		porcentajePlan.setForeground(Color.white);
		porcentajePlan.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fabrica.porcentajePlan();
				
			}
		});
		menu.add(porcentajePlan);

		JButton mesmayorProduccion = new JButton("Mes Mayore Produccion");
		mesmayorProduccion.setSize(140,35);
		mesmayorProduccion.setLocation(5,325);
		mesmayorProduccion.setOpaque(true);
		mesmayorProduccion.setBackground(Color.darkGray);
		mesmayorProduccion.setFocusable(false);
		mesmayorProduccion.setForeground(Color.white);
		mesmayorProduccion.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fabrica.mesMayorProduccion();
			}
		});
		menu.add(mesmayorProduccion);
		
		JButton mostrarFichero = new JButton("Datos en fichero");
		mostrarFichero.setSize(140,35);
		mostrarFichero.setLocation(5,365);
		mostrarFichero.setOpaque(true);
		mostrarFichero.setBackground(Color.darkGray);
		mostrarFichero.setFocusable(false);
		mostrarFichero.setForeground(Color.white);
		mostrarFichero.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fabrica.cargarProductos();
			}
		});
		menu.add(mostrarFichero);
		
		JButton datosNombre = new JButton("Datos por Nombre");
		datosNombre.setSize(140,35);
		datosNombre.setLocation(5,405);
		datosNombre.setOpaque(true);
		datosNombre.setBackground(Color.darkGray);
		datosNombre.setFocusable(false);
		datosNombre.setForeground(Color.white);
		datosNombre.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fabrica.datosNombre();
			}
		});
		menu.add(datosNombre);
		
		
		JButton datosTrabajador = new JButton("Datos Trabajador");
		datosTrabajador.setSize(140,35);
		datosTrabajador.setLocation(5,445);
		datosTrabajador.setOpaque(true);
		datosTrabajador.setBackground(Color.darkGray);
		datosTrabajador.setFocusable(false);
		datosTrabajador.setForeground(Color.white);
		datosTrabajador.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String arr[] = {"Tecnico","Cientifico","Productor"};
				int tipo = JOptionPane.showOptionDialog(null, "Tipo de Trabajador", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, arr, null);
				String carnet = JOptionPane.showInputDialog("Carnet del trabajador");
				for(Trabajador i:Fabrica.trabajadores) {
                                    if(i==null)continue;
					if(i.getCarnet().equals(carnet)) {
						if((tipo==0 && i instanceof TrabajadorTecnico)||
						   (tipo==1 && i instanceof TrabajadorCientifico)||
						   (tipo==2 && i instanceof TrabajadorProductor)){
						JOptionPane.showMessageDialog(null, i.informacion());
						return;
						}
					}
				}
				JOptionPane.showMessageDialog(null, "No hay trabajdor con ese carnet");
			}
		});
		menu.add(datosTrabajador);
		
		JButton salir = new JButton("Salir");
		salir.setSize(140,35);
		salir.setLocation(5,menu.getHeight()-40);
		salir.setOpaque(true);
		salir.setBackground(Color.darkGray);
		salir.setFocusable(false);
		salir.setForeground(Color.white);
		salir.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(salir);
	}
	
	private void ficherosPanel() {
		ficherosPanel = new JPanel();
		ficherosPanel.setSize(panel.getSize());
		ficherosPanel.setLayout(null);
		
		JButton trabajadores = new JButton("Exportar Trabajadores a Fichero de Texto");
		trabajadores.setSize(panel.getWidth()/4,panel.getHeight());
		trabajadores.addActionListener((ActionEvent)->{
			Fabrica.guardarTrabajadores();
		});
		ficherosPanel.add(trabajadores);
		
		JButton produccion = new JButton("Exportar Produccion a Fichero de Texto");
		produccion.setSize(panel.getWidth()/4,panel.getHeight());
		produccion.setLocation(produccion.getWidth(),0);
		produccion.addActionListener((ActionEvent)->{
			Fabrica.guardarProductos();
		});
		ficherosPanel.add(produccion);
	}
	
	private void produccionPanel() {
		produccionPanel= new JPanel();
		produccionPanel.setSize(panel.getSize());
		produccionPanel.setLayout(null);
		String arr[] = {"ENE","FEB","MAR","ABR","MAY","JUN","JUL","AGO","SEP","OCT","NOV","DIC"};
		for(int i=0;i<12;i++) {
			JLabel jl = new JLabel(arr[i]);
			jl.setSize(50,30);
			jl.setHorizontalAlignment(JLabel.CENTER);
			jl.setLocation(190+(i*jl.getWidth()),5);			
			produccionPanel.add(jl);
		}

		for(int i=0;i<Fabrica.cProductos;i++) {
			JLabel jl = new JLabel(Fabrica.productos.get(i).getNombre());
			jl.setSize(190,30);
			jl.setLocation(5,(i+1)*jl.getHeight());
			Producto p = Fabrica.productos.get(i);
			JTextField datos[] = new JTextField[12];
			for(int j=0;j<12;j++) {
				JTextField jt = new JTextField(""+p.getProduccion(j));
				datos[j]=jt;
				jt.setSize(50,30);
				jt.setLocation(190+(j*jt.getWidth()),jl.getY());
				jt.setHorizontalAlignment(JTextField.CENTER);
				produccionPanel.add(jt);
			}
			JButton actualizar = new JButton("=>");
			actualizar.setSize(produccionPanel.getWidth()-datos[11].getX()-datos[11].getWidth(),30);
			actualizar.setLocation(datos[11].getX()+datos[11].getWidth(),(i+1)*jl.getHeight());
			actualizar.setFocusable(false);
			
			actualizar.addActionListener((ActionEvent)->{
				for(int k=0;k<12;k++)
					try {
						p.setProduccion(k, Integer.parseInt(datos[k].getText()));
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error: "+p.getNombre()+" en el mes "+arr[k]);
					}
			});
				
			
			produccionPanel.add(actualizar);
			produccionPanel.add(jl);
		}
		
		panel.add(produccionPanel);
		
	
		
		
	}

	private void trabajadorPanel() {
		trabajadorPanel = new JPanel();
		trabajadorPanel.setSize(panel.getSize());
		trabajadorPanel.setLayout(null);
		
		JLabel nombrel = new JLabel("Nombre: ");
		JTextField nombre = new JTextField();
		nombrel.setSize(100,25);
		nombre.setSize(350,25);		
		nombrel.setLocation(5,5);
		nombre.setLocation(nombrel.getX()+100,nombrel.getY());
		trabajadorPanel.add(nombrel);
		trabajadorPanel.add(nombre);
		
		JLabel idl = new JLabel("Carnet: ");
		JTextField id = new JTextField();
		idl.setSize(100,25);
		id.setSize(350,25);		
		idl.setLocation(5,35);
		id.setLocation(idl.getX()+100,idl.getY());
		trabajadorPanel.add(idl);
		trabajadorPanel.add(id);
		
		JLabel dirl = new JLabel("Direccion: ");
		JTextField dir = new JTextField();
		dirl.setSize(100,25);
		dir.setSize(350,25);		
		dirl.setLocation(5,65);
		dir.setLocation(dirl.getX()+100,dirl.getY());
		trabajadorPanel.add(dirl);
		trabajadorPanel.add(dir);
		
		JLabel tel = new JLabel("Telefono: ");
		JTextField te = new JTextField();
		tel.setSize(100,25);
		te.setSize(350,25);		
		tel.setLocation(5,95);
		te.setLocation(tel.getX()+100,tel.getY());
		trabajadorPanel.add(tel);
		trabajadorPanel.add(te);

		JLabel esl = new JLabel("Especialidad: ");
		JTextField es = new JTextField();
		esl.setSize(100,25);
		es.setSize(350,25);		
		esl.setLocation(5,125);
		es.setLocation(esl.getX()+100,esl.getY());
		trabajadorPanel.add(esl);
		trabajadorPanel.add(es);		
		
		JLabel grl = new JLabel("Grado: ");
		JTextField gr = new JTextField();
		grl.setSize(100,25);
		gr.setSize(350,25);		
		grl.setLocation(5,155);
		gr.setLocation(grl.getX()+100,grl.getY());
		trabajadorPanel.add(grl);
		trabajadorPanel.add(gr);
				
		JLabel cel = new JLabel("Centro de Estudio: ");
		JTextField ce = new JTextField();
		cel.setSize(100,25);
		ce.setSize(350,25);		
		cel.setLocation(5,185);
		ce.setLocation(cel.getX()+100,cel.getY());
		trabajadorPanel.add(cel);
		trabajadorPanel.add(ce);		
		
		JLabel expl = new JLabel("Experiencia: ");
		JTextField exp = new JTextField();
		expl.setSize(100,25);
		exp.setSize(350,25);		
		expl.setLocation(5,215);
		exp.setLocation(expl.getX()+100,expl.getY());
		trabajadorPanel.add(expl);
		trabajadorPanel.add(exp);
		
		es.setEnabled(false);
		gr.setEnabled(false);
		ce.setEnabled(false);
		exp.setEnabled(false);
		
		JButton productor,tecnico,cientifico,aceptar;
		
		productor = new JButton("Productor");
		productor.setSize((trabajadorPanel.getWidth()/3)-15,50);
		productor.setLocation(trabajadorPanel.getWidth()-productor.getWidth()-30,15);
		trabajadorPanel.add(productor);
		
		tecnico = new JButton("Tecnico");
		tecnico.setSize(productor.getSize());
		tecnico.setLocation(trabajadorPanel.getWidth()-productor.getWidth()-30,15+tecnico.getHeight()+5);
		trabajadorPanel.add(tecnico);
		
		cientifico = new JButton("Cientifico");
		cientifico.setSize(productor.getSize());
		cientifico.setLocation(trabajadorPanel.getWidth()-productor.getWidth()-30,15+tecnico.getHeight()+5+cientifico.getHeight()+5);
		trabajadorPanel.add(cientifico);
		
		aceptar = new JButton("Aceptar");
		aceptar.setSize(tecnico.getSize());
		aceptar.setLocation((trabajadorPanel.getWidth()/2)-(aceptar.getWidth()/2),trabajadorPanel.getHeight()-aceptar.getHeight()-5);
		trabajadorPanel.add(aceptar);
		
		productor.addActionListener((ActionEvent)->{
			es.setEnabled(false);
			gr.setEnabled(false);
			ce.setEnabled(false);
			exp.setEnabled(true);
			clasificacion = "Productor";
			productor.setEnabled(false);
			tecnico.setEnabled(true);
			cientifico.setEnabled(true);
		});
		
		tecnico.addActionListener((ActionEvent)->{
			es.setEnabled(true);
			gr.setEnabled(false);
			ce.setEnabled(false);
			exp.setEnabled(false);
			clasificacion = "Tecnico";
			productor.setEnabled(true);
			tecnico.setEnabled(false);
			cientifico.setEnabled(true);
		});
		
		cientifico.addActionListener((ActionEvent)->{
			es.setEnabled(false);
			gr.setEnabled(true);
			ce.setEnabled(true);
			exp.setEnabled(false);
			clasificacion = "Cientifico";
			productor.setEnabled(true);
			tecnico.setEnabled(true);
			cientifico.setEnabled(false);
		});
		
		aceptar.addActionListener((ActionEvent)->{
			try {
				String centro=null;
				String grado=null;
				if(ce.isEnabled()) {
					centro=ce.getText();
					grado=gr.getText();
				}
				else if(te.isEnabled())centro=te.getText();
				int expe=0;
				if(exp.isEnabled())expe=Integer.parseInt(exp.getText());
				Trabajador t ;
				if(!productor.isEnabled()) {
					t = new TrabajadorProductor(nombre.getText(),id.getText(),te.getText(),dir.getText(),expe);
				}
				else if(!tecnico.isEnabled()) {
					t = new TrabajadorTecnico(nombre.getText(),id.getText(),te.getText(),dir.getText(),es.getText());
				}
				else {
					t = new TrabajadorCientifico(nombre.getText(),id.getText(),te.getText(),dir.getText(),centro,grado);
				}
				
				Fabrica.addTrabajador(t);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error en la introduccion de datos" );
			}
		});
		
		productor.doClick();
		
	}
	
	private void listasPanel() {
		
		listasPanel = new JPanel();
		listasPanel.setSize(panel.getSize());
		listasPanel.setLayout(null);
		
		JTextArea productos = new JTextArea();
		JTextArea exportacion = new JTextArea();
		JTextArea trabajadores = new JTextArea();
	
		JScrollPane p = new JScrollPane(productos);
		JScrollPane e = new JScrollPane(exportacion);
		JScrollPane t = new JScrollPane(trabajadores);
		
		productos.setSize(1000,1000);
		exportacion.setSize(1000,1000);
		trabajadores.setSize(1000,1000);
		
		p.setSize(panel.getWidth()/3,panel.getHeight());
		e.setSize(p.getSize());
		t.setSize(p.getSize());
	
		p.setLocation(0,0);				
		e.setLocation(p.getWidth(),0);
		t.setLocation(e.getWidth()+e.getX(),0);
		
		Fabrica.productosDatos(productos);
		Fabrica.exportacionDatos(exportacion);
		Fabrica.trabajadoresDatos(trabajadores);
		
		listasPanel.add(p);
		listasPanel.add(e);
		listasPanel.add(t);
		
		panel.add(listasPanel);
	}
	
	private void nuevoMaterial(JComboBox<Material> jcm,JPanel panel,boolean nacional) {
		JLabel separator = new JLabel("Agregar Material Para Envases");
		separator.setSize(productoPanel.getWidth(),30);
		separator.setLocation(0,5);
		separator.setForeground(Color.white);
		separator.setHorizontalAlignment(JLabel.CENTER);
		panel.add(separator);
		
		JLabel nombrel = new JLabel("Nombre: ");
		JTextField nombre = new JTextField();
		nombrel.setSize(100,25);
		nombre.setSize(350,25);		
		nombrel.setLocation(5,35);
		nombre.setLocation(nombrel.getX()+100,nombrel.getY());
		panel.add(nombrel);
		panel.add(nombre);
		
		JLabel prol = new JLabel("Proveedor: ");
		JTextField pro = new JTextField();
		prol.setSize(100,25);
		pro.setSize(350,25);		
		prol.setLocation(5,65);
		pro.setLocation(prol.getX()+100,prol.getY());
		panel.add(prol);
		panel.add(pro);
		
		JLabel col = new JLabel("Coste: ");
		JTextField co = new JTextField();
		col.setSize(100,25);
		co.setSize(350,25);		
		col.setLocation(5,95);
		co.setLocation(col.getX()+100,col.getY());
		panel.add(col);
		panel.add(co);
		
		JLabel fvl = new JLabel("Tiempo: ");
		JTextField fv = new JTextField();
		fvl.setSize(100,25);
		fv.setSize(350,25);		
		fvl.setLocation(5,125);
		fv.setLocation(fvl.getX()+100,fvl.getY());
		panel.add(fvl);
		panel.add(fv);
		
		JButton nac,impo,aceptar;
		
		aceptar = new JButton("Aceptar"); 
		aceptar.setSize(panel.getWidth()/3,50);
		aceptar.setLocation((panel.getWidth()/2)-(aceptar.getWidth()/2),panel.getHeight()-aceptar.getHeight());
		panel.add(aceptar);
		
		nac = new JButton("Nacional");
		nac.setSize(aceptar.getSize());
		nac.setLocation((panel.getWidth()/4)-(nac.getWidth()/2),155);
		panel.add(nac);
		
		impo = new JButton("Importacion");
		impo.setSize(aceptar.getSize());
		impo.setLocation((3*(panel.getWidth()/4))-(impo.getWidth()/2),155);
		panel.add(impo);
		
		nac.addActionListener((ActionEvent)->{
			fv.setEnabled(false);
			nac.setEnabled(false);
			impo.setEnabled(true);
		});
		
		impo.addActionListener((ActionEvent)->{
			fv.setEnabled(true);
			nac.setEnabled(true);
			impo.setEnabled(false);
		});
		
		aceptar.addActionListener((ActionEvent)->{
			try {
				String cate = "Nacional";
				int tiempo=0;
				Material m;
				if(!impo.isEnabled()) {
					cate = "Importacion";
					tiempo=Integer.parseInt(fv.getText());
					m = new MaterialExtranjero(nombre.getText(),pro.getText(),Float.parseFloat(co.getText()),tiempo);
				}
				else m = new Material(nombre.getText(),pro.getText(),Float.parseFloat(co.getText()));
				Fabrica.addMaterial(m);
				if(!nacional)jcm.addItem(m);
				else if(cate.equals("Nacional"))jcm.addItem(m);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error en la introduccion de datos" );
			}
		});
		
		if(nacional)nac.doClick();
		else impo.doClick();
	}
	
	private void productoPanel() {
		productoPanel = new JPanel();
		productoPanel.setSize(panel.getSize());
		productoPanel.setLayout(null);
		
		JLabel nombrel = new JLabel("Nombre: ");
		JTextField nombre = new JTextField();
		nombrel.setSize(100,25);
		nombre.setSize(350,25);		
		nombrel.setLocation(5,5);
		nombre.setLocation(nombrel.getX()+100,nombrel.getY());
		productoPanel.add(nombrel);
		productoPanel.add(nombre);
		
		JLabel col = new JLabel("Coste: ");
		JTextField co = new JTextField();
		col.setSize(100,25);
		co.setSize(350,25);		
		col.setLocation(5,35);
		co.setLocation(col.getX()+100,col.getY());
		productoPanel.add(col);
		productoPanel.add(co);
		
		JLabel fvl = new JLabel("Fecha Vencimiento: ");
		JTextField fv = new JTextField();
		fvl.setSize(100,25);
		fv.setSize(350,25);		
		fvl.setLocation(5,65);
		fv.setLocation(fvl.getX()+100,fvl.getY());
		productoPanel.add(fvl);
		productoPanel.add(fv);
		
		JLabel mel = new JLabel("Mercado: ");
		JComboBox<String> me = new JComboBox<String>();
		mel.setSize(100,25);
		me.setSize(350,25);		
		mel.setLocation(5,95);
		me.setLocation(mel.getX()+100,mel.getY());
		me.addItem("Nacional");
		me.addItem("Exportacion");
		productoPanel.add(mel);
		productoPanel.add(me);

		JLabel mal = new JLabel("Envase: ");
		JComboBox<Material> ma = new JComboBox<Material>();
		mal.setSize(100,25);
		ma.setSize(350,25);		
		mal.setLocation(5,125);
		ma.setLocation(mal.getX()+100,mal.getY());
		productoPanel.add(mal);
		productoPanel.add(ma);
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.setSize(productoPanel.getWidth()/3,50);
		aceptar.setLocation((productoPanel.getWidth()/2)-(aceptar.getWidth()/2),155);
		productoPanel.add(aceptar);
		
		me.addActionListener((ActionEvent)->{
			ma.removeAllItems();
			if(me.getSelectedIndex()==0) {				
				for(int i=0;i<Fabrica.cMateriales;i++) {
					if(Fabrica.materiales[i].getMercado().equals("Nacional"))ma.addItem(Fabrica.materiales[i]);
				}
			}
			else {
				for(int i=0;i<Fabrica.cMateriales;i++) {
					ma.addItem(Fabrica.materiales[i]);
				}
			}
		});
		
		aceptar.addActionListener((ActionEvent)->{
			try {
				Date d = new Date(Date.parse(fv.getText()));				
				Producto p = new Producto(nombre.getText(),Float.parseFloat(co.getText()),fv.getText(),(Material)ma.getSelectedItem(),(String)me.getSelectedItem());
				Fabrica.addProducto(p);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error en la introduccion de datos" );
			}
		});
		
		//-----------------------------------------------------------------------------------------------------------------------
		
		JPanel p = new JPanel();
		p.setLocation(0,245);
		p.setSize(productoPanel.getWidth(),productoPanel.getHeight()-p.getY());
		p.setLayout(null);
		p.setBackground(Color.gray);
		nuevoMaterial(ma,p,(me.getSelectedIndex()==0?true:false));
		productoPanel.add(p);
	}
	
	private void paneles() {

		panel = new JPanel();
		panel.setSize(850,500);
		panel.setLocation(150,0);
		panel.setLayout(null);
		this.add(panel);
		panel.setBackground(Color.white);

		//--------------------------------------------------------------------------------------------------------------------------------------------------
		trabajadorPanel();
		//--------------------------------------------------------------------------------------------------------------------------------------------------		
		productoPanel();
		//--------------------------------------------------------------------------------------------------------------------------------------------------					
		ficherosPanel();
		//--------------------------------------------------------------------------------------------------------------------------------------------------

		//--------------------------------------------------------------------------------------------------------------------------------------------------
	}

	private void menu() {
		JPanel menu1=new JPanel();
		menu1.setSize(150,this.getHeight());
		menu1.setLocation(0,0);
		menu1.setBackground(Color.lightGray);
		menu1.setLayout(null);
		this.add(menu1);
		botones(menu1);
		
	}
	
	public Ventana() {
		this.setLayout(null);
		this.setSize(1000,550);
		this.setResizable(false);
		this.setUndecorated(true);
		
		paneles();
		menu();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
		new Ventana();
	}
}
