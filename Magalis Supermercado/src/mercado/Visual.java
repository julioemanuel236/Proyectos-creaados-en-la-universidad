package mercado;

import javax.swing.*;
import java.awt.*;

public class Visual extends JFrame{

	Cadena cadena = new Cadena();
	
	private JPanel paneles;
	
	private void panelNuevo() {
		JPanel panel = new JPanel();
		panel.setSize(paneles.getSize());
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JButton almacen = new JButton("NUEVO ALMACEN");
		almacen.setSize(200,40);
		almacen.setLocation((panel.getWidth()/2)-(almacen.getWidth()/2),5);
		almacen.addActionListener((ActionEvent)->{
			cadena.almacenes.add(new Almacen());
			panelNuevo();
		});
		panel.add(almacen);
		
		
		JTextField nombre = new JTextField("NOMBRE PRODUCTO");
		JTextField codigo = new JTextField("CODIGO PRODUCTO");
		JTextField precio = new JTextField("PRECIO PRODUCTO");
		JTextField cantidad = new JTextField("CANTIDAD PRODUCTO");
		JTextField limite = new JTextField("LIMTE PRODUCTO");
		
		nombre.setSize(200,30);
		codigo.setSize(200,30);
		precio.setSize(200,30);
		cantidad.setSize(200,30);
		limite.setSize(200,30);
		
		nombre.setLocation((panel.getWidth()/2)-(nombre.getWidth()/2),50);
		codigo.setLocation(nombre.getX(),nombre.getY()+nombre.getHeight()+5);
		precio.setLocation(nombre.getX(),codigo.getY()+codigo.getHeight()+5);
		cantidad.setLocation(nombre.getX(),precio.getY()+precio.getHeight()+5);
		limite.setLocation(nombre.getX(),cantidad.getY()+cantidad.getHeight()+5);
		
		panel.add(nombre);
		panel.add(codigo);
		panel.add(precio);
		panel.add(cantidad);
		panel.add(limite);
		
		JComboBox<String> tipo = new JComboBox<>();
		tipo.setSize(150,30);
		tipo.setLocation(nombre.getX()+25,limite.getY()+limite.getHeight()+5);
		tipo.addItem("NACIONAL");
		tipo.addItem("EXTRANJERO");

		JComboBox<String> alm = new JComboBox<>();
		alm.setSize(150,30);
		alm.setLocation(nombre.getX()+25,tipo.getY()+tipo.getHeight()+5);
		for(int i=0;i<cadena.almacenes.size();i++)
			alm.addItem("ALMACEN "+(i+1));
		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setSize(150,30);
		aceptar.setLocation(nombre.getX()+25,alm.getY()+alm.getHeight()+5);
		aceptar.addActionListener((ActionEvent)->{
			try {
				String n = nombre.getText();
				String c = codigo.getText();
				float  p = Float.parseFloat(precio.getText());
				int   ca = Integer.parseInt(cantidad.getText());
				int   li = Integer.parseInt(limite.getText());
				String pe;
				float  usd;
				Producto producto;
				if(tipo.getSelectedIndex()==0) {
					pe = JOptionPane.showInputDialog("EMPRESEA: ");
					producto = new Nacional(n,c,p,ca,li,pe);
					cadena.almacenes.get(alm.getSelectedIndex()).addProducto(producto);
					cadena.productos.add(producto);
				}
				else {
					pe = JOptionPane.showInputDialog("PAIS: ");
					usd = Float.parseFloat(JOptionPane.showInputDialog("COSTO USD: "));
					producto = new Extranjero(n,c,p,ca,li,pe,usd);
					cadena.almacenes.get(alm.getSelectedIndex()).addProducto(producto);
					cadena.productos.add(producto);
				}
				JOptionPane.showMessageDialog(null,"PRODUCTO AGREGADO CON EXITO");
				panelNuevo();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Datos Invalidos");
			}
		});
		
		panel.add(tipo);
		panel.add(alm);
		panel.add(aceptar);
		
		paneles.removeAll();
		paneles.add(panel);
		paneles.repaint();
		}
	
	private void panelExistencias() {
		JPanel panel = new JPanel();
		panel.setSize(paneles.getSize());
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JComboBox<Producto> productos = new JComboBox<>();
		productos.setSize(150,30);
		productos.setLocation((panel.getWidth()/2)-(productos.getWidth()/2),40);
		JComboBox<String> almacen = new JComboBox<>();
		almacen.setSize(150,30);
		almacen.setLocation(productos.getX(),5);
		for(int i=0;i<cadena.almacenes.size();i++)
			almacen.addItem("ALMACEN "+(i+1));
		almacen.addActionListener((ActionEvent)->{
			productos.removeAllItems();
			for(Producto i:cadena.almacenes.get(almacen.getSelectedIndex()).productos)
				productos.addItem(i);
		});
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.setSize(150,30);
		aceptar.setLocation(productos.getX(),productos.getY()+productos.getHeight()+5);
		aceptar.addActionListener((ActionEvent)->{
			try {
				int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de existencias en aumentar"));
				Producto p = (Producto)productos.getSelectedItem();
				p.setCantidad(p.getCantidad()+cantidad);
				JOptionPane.showMessageDialog(null, "Cantidad aumentada con exito+\n"
						+ "La cantidad total del producto es ahora de "+p.getCantidad());
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Cantidad invalida");
			}
		});
		
		panel.add(almacen);
		panel.add(productos);
		panel.add(aceptar);
		paneles.removeAll();
		paneles.add(panel);
		paneles.repaint();
		
	}
	
	private void panelVenta() {
		JPanel panel = new JPanel();
		panel.setSize(paneles.getSize());
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JComboBox<Producto> productos = new JComboBox<>();
		productos.setSize(150,30);
		productos.setLocation((panel.getWidth()/2)-(productos.getWidth()/2),40);
		JComboBox<String> almacen = new JComboBox<>();
		almacen.setSize(150,30);
		almacen.setLocation(productos.getX(),5);
		for(int i=0;i<cadena.almacenes.size();i++)
			almacen.addItem("ALMACEN "+(i+1));
		almacen.addActionListener((ActionEvent)->{
			productos.removeAllItems();
			for(Producto i:cadena.almacenes.get(almacen.getSelectedIndex()).productos)
				productos.addItem(i);
		});

		JTextField cantidad = new JTextField("Cantidad a vender");
		cantidad.setSize(150,30);
		cantidad.setLocation(productos.getX(),productos.getY()+productos.getHeight()+5);
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.setSize(150,30);
		aceptar.setLocation(productos.getX(),cantidad.getY()+cantidad.getHeight()+5);
		aceptar.addActionListener((ActionEvent)->{
			try {
				int c = Integer.parseInt(cantidad.getText());
				
				cadena.vender(cadena.almacenes.get(almacen.getSelectedIndex()),(Producto)productos.getSelectedItem(),c);
			}
			catch(Exception e) {
				JOptionPane.showInternalMessageDialog(null, "Cantidad invalida");
			}
		});
		
		panel.add(almacen);
		panel.add(productos);
		panel.add(cantidad);
		panel.add(aceptar);		
		paneles.removeAll();
		paneles.add(panel);
		paneles.repaint();
	}
	
	private void opciones() {
		paneles = new JPanel();
		paneles.setSize(600,500);
		paneles.setLocation(200,0);
		paneles.setLayout(null);
		add(paneles);
		
		JPanel opciones = new JPanel();
		opciones.setSize(200,500);
		opciones.setLayout(null);
		opciones.setBackground(Color.blue);
		
		JButton nuevo = new JButton("NUEVO");
		nuevo.setSize(190,30);
		nuevo.setLocation(5,5);
		nuevo.addActionListener((ActionEvent)->{
			panelNuevo();
		});
		opciones.add(nuevo);
		
		JButton masVenta = new JButton("PRODUCTO MAS VENDIDO");
		masVenta.setSize(190,30);
		masVenta.setLocation(5,40);
		masVenta.addActionListener((ActionEvent)->{
			JOptionPane.showMessageDialog(null, cadena.masVendidos());
		});
		opciones.add(masVenta);
		
		JButton menosVenta = new JButton("PRODUCTO MENOS VENDIDO");
		menosVenta.setSize(190,30);
		menosVenta.setLocation(5,75);
		menosVenta.addActionListener((ActionEvent)->{
			JOptionPane.showMessageDialog(null, cadena.menosVendidos());
		});
		opciones.add(menosVenta);

		JButton nacionalscaros = new JButton("NACIONALES MAS CAROS QUE");
		nacionalscaros.setSize(190,30);
		nacionalscaros.setLocation(5,110);
		nacionalscaros.addActionListener((ActionEvent)->{
			try {
				
				JOptionPane.showMessageDialog(null, cadena.productosNacionalesMayor(
					Integer.parseInt(JOptionPane.showInputDialog("Valor a comparar"))));
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Valor invalido");
			}
		});
		opciones.add(nacionalscaros);

		JButton vendidospais = new JButton("VENTAS POR PAIS");
		vendidospais.setSize(190,30);
		vendidospais.setLocation(5,145);
		vendidospais.addActionListener((ActionEvent)->{
			try {
				
				JOptionPane.showMessageDialog(null, cadena.productosPais(
					(JOptionPane.showInputDialog("Pais: "))));
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Valor invalido");
			}
		});
		opciones.add(vendidospais);
		
		JButton deficiencias = new JButton("GENERAR DEFICIENCIAS");
		deficiencias.setSize(190,30);
		deficiencias.setLocation(5,180);
		deficiencias.addActionListener((ActionEvent)->{
			cadena.generarDeficiencias();
		});
		opciones.add(deficiencias);
		
		JButton existencias = new JButton("AÑADIR EXISTENCIAS");
		existencias.setSize(190,30);
		existencias.setLocation(5,215);
		existencias.addActionListener((ActionEvent)->{
			panelExistencias();
		});
		opciones.add(existencias);

		JButton venta = new JButton("VENDER");
		venta.setSize(190,30);
		venta.setLocation(5,250);
		venta.addActionListener((ActionEvent)->{
			panelVenta();
		});
		opciones.add(venta);
		
		
		add(opciones);
	}
	
	public Visual() {
		this.setSize(800,500);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		opciones();
		
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
		new Visual();
	}
	
}
