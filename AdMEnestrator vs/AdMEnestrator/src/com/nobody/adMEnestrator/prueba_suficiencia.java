package com.nobody.adMEnestrator;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.math.BigDecimal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class prueba_suficiencia {
	
	private class Habitacion{
		int precio;
		int numero;
		int piso;
		Empleado encargado;
	}
	
	private class Cliente{
		String nombre;
		String apellido1;
		String apellido2;
		String ID;
		String sexo;
		boolean vip;
		String rango;
		String pais;
		Date llegada;
		Date ida;
	}
	
	private class Empleado{
		String nombre;
		String apellido1;
		String apellido2;
		boolean jefepiso=false;
		int tiempojefe;
		int tiempo;
		LinkedList<Habitacion> habitaciones;
	}
	
	private class Hotel {
		String nomre;
		int capacidad;
		int categoria;
		LinkedList<String> servicios;
		LinkedList<Empleado> empleados;
		Map<String,BigDecimal> administracion;
		LinkedList<Cliente> tradicionales;
		LinkedList<Cliente> vips;
	}

	private JFrame root = new JFrame();
	private JPanel options = new JPanel();
	private JPanel nuevo_hotel;
	private JPanel nuevo_empleado;
	private JPanel nuevo_cliente;
	private JScrollPane main = new JScrollPane();
	private JPanel nuevo = new JPanel();
	
	public prueba_suficiencia() {
		root.setSize(700,400);
		root.setLayout(null);;
		root.setResizable(false);
		options.setSize(new Dimension(100,root.getHeight()));
		options.setPreferredSize(new Dimension(100,root.getHeight()));
		options.setBackground(Color.DARK_GRAY);
		options.setOpaque(true);
		options.setLocation(0,0);
		options();
		nuevos_panels();
		main.setSize(new Dimension(600,root.getHeight()));
		nuevo.setSize(main.getPreferredSize());
		main.setViewportView(nuevo);
		main.setLocation(options.getWidth(),0);
		root.add(options);
		root.add(main);
		root.setDefaultCloseOperation(root.EXIT_ON_CLOSE);
		root.setVisible(true);
		root.setLocationRelativeTo(null);
		
	}
	
	private void options() {
		JButton newh = new JButton("Nuevo Hotel");
		newh.setSize((int)options.getPreferredSize().getWidth(),40);
		newh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.setViewportView(nuevo_hotel);
			}
		});
		options.add(newh);
		JButton newe = new JButton("Nuevo Empleado");
		newe.setSize((int)options.getPreferredSize().getWidth(),40);
		newe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.setViewportView(nuevo_empleado);
			}
		});
		options.add(newe);
		JButton newc = new JButton("Nuevo Cliente");
		newc.setSize((int)options.getPreferredSize().getWidth(),40);
		newc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.setViewportView(nuevo_cliente);
			}
		});
		options.add(newc);
	}
	
	private void nuevos_panels() {
		nuevo_hotel();
		nuevo_empleado();
		nuevo_cliente();

	}
	
	private void nuevo_hotel() {
		nuevo_hotel = new JPanel();
		nuevo_hotel.setSize(main.getSize());
		nuevo_hotel.setPreferredSize(main.getSize());
		nuevo_hotel.setBackground(Color.red);
		JLabel n = new JLabel("Nombre: ");
		JTextField ntxt = new JTextField();
		ntxt.setBorder(null);
		n.setSize(100,40);
		ntxt.setPreferredSize(new Dimension(100,20));
		nuevo_hotel.add(n);
		nuevo_hotel.add(ntxt);
		nuevo_hotel.add(new JSeparator(main.getWidth()));
	}
	
	private void nuevo_empleado() {
		nuevo_empleado = new JPanel();
		nuevo_empleado.setSize(main.getSize());
		nuevo_empleado.setBackground(Color.blue);
		JLabel n = new JLabel("Nombre: ");
		JTextField ntxt = new JTextField();
		ntxt.setBorder(null);
		n.setSize(100,40);
		ntxt.setPreferredSize(new Dimension(100,20));
		nuevo_empleado.add(n);
		nuevo_empleado.add(ntxt);
		nuevo_empleado.add(new JSeparator(main.getWidth()));

	}
	
	private void nuevo_cliente() {
		nuevo_cliente = new JPanel();
		nuevo_cliente.setSize(main.getSize());
		nuevo_cliente.setPreferredSize(main.getSize());
		nuevo_cliente.setBackground(Color.green);
		JLabel n = new JLabel("Nombre: ");
		JTextField ntxt = new JTextField();
		ntxt.setBorder(null);
		n.setSize(100,40);
		ntxt.setPreferredSize(new Dimension(100,20));
		JLabel pa = new JLabel("Primer Apellido: ");
		JTextField patxt = new JTextField();
		patxt.setBorder(null);
		pa.setSize(100,40);
		patxt.setPreferredSize(new Dimension(100,20));
		JLabel sa = new JLabel("Segundo Apellido: ");
		JTextField satxt = new JTextField();
		satxt.setBorder(null);
		sa.setSize(100,40);
		satxt.setPreferredSize(new Dimension(100,20));
		
		JLabel id = new JLabel("No. Identidad: ");
		JTextField idtxt = new JTextField();
		idtxt.setBorder(null);
		id.setSize(100,40);
		idtxt.setPreferredSize(new Dimension(100,20));
		
		JLabel co = new JLabel("Pais: ");
		JTextField cotxt = new JTextField();
		cotxt.setBorder(null);
		co.setSize(100,40);
		cotxt.setPreferredSize(new Dimension(100,20));
		
		nuevo_cliente.add(n);
		nuevo_cliente.add(ntxt);
		
		nuevo_cliente.add(pa);
		nuevo_cliente.add(patxt);
		
		nuevo_cliente.add(sa);
		nuevo_cliente.add(satxt);
		
		nuevo_cliente.add(id);
		nuevo_cliente.add(idtxt);
		
		nuevo_cliente.add(co);
		nuevo_cliente.add(cotxt);
	}
	
	public static void main(String args[]) {
		new prueba_suficiencia();
	}
}
