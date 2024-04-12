package App;

import javax.swing.*;
import javax.swing.border.LineBorder;

import algoritmos.*;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class Ventana extends JFrame{

	private class Proces{
		public int id;
		public int ti;
		public int tf;
		
		public Proces(int id, int ti, int tf) {
			super();
			this.id = id;
			this.ti = ti;
			this.tf = tf;
		}
		
		
	}
	
	
	PriorityQueue<Proceso> procesos = new PriorityQueue<>(new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			Proceso p1 = (Proceso)o1;
			Proceso p2 = (Proceso)o2;
			if(p1.getInicio()<p2.getInicio())return -1;
			else if(p1.getInicio()>p2.getInicio())return 1;
			else if(p1.getId()<p2.getId())return -1;
			else if(p1.getId()>p2.getId())return 1;
			return 0;
		}
		
	});
	
	ScrollPanel zone;
	ScrollPanel table;
	AlgoritmoPlanificacion algoritmo = new PrioridadApropiativo();
	ArrayList<JTextField[]> entrys = new ArrayList<>();
	JLabel 	   etiquetas[] = new JLabel[4];	
	private Proces ultimo;
	private int xpos = 5;
	private boolean up=false;
	private float esperaPromedio=0;
	private float cpuPromedio;
	private JLabel tiempoEjecucion;
	private JLabel tiempoEspera;
	
	Ventana(){
		setLayout(null);
		setResizable(false);
		setSize(900,500);		
		iniTable();		
		iniZone();
		iniButtons();		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		p.setSize(getSize());
		p.setBackground(Color.DARK_GRAY);
		add(p);
		setVisible(true);
		int arr[]= {18,16,10,5,9,7,8};
		for(int i=1;i<=7;i++) {
			JTextField jt[] = entrys.get(i-1);
			for(int j=0;j<3;j++) {				
				switch(j) {
					case 0:jt[j].setText(""+i);break;
					case 1:jt[j].setText(""+arr[i-1]);break;
					case 2:jt[j].setText(""+0);break;
				}
				
			}
		}
	}
	
	private void iniButtons() {	
		JComboBox<String> jcb = new JComboBox<>();
		jcb.setLocation(table.getWidth()+table.getX(),5);
		jcb.setSize(getWidth()-jcb.getX()-15,50);
		
		jcb.requestFocus();
		jcb.addItem("Prioridad Apropiativo");		
		jcb.addItem("Round Robin");		
		jcb.addItem("SJF");
		add(jcb);
		
		jcb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				(new Thread() {
					public void run() {
						int size;
						if(jcb.getSelectedIndex() == 0) {
							size = etiquetas.length;	
							algoritmo = new PrioridadApropiativo();
						}
						else {
							if(jcb.getSelectedIndex()==1)algoritmo = new RoundRobin(1);
							else algoritmo = new ShortesJobFirst();
							size = etiquetas.length-1;
						}
						for(int i=0;i<size;i++) {												
							JLabel jl = etiquetas[i];
							jl.setSize(table.getWidth()/size,20);			
//							System.out.println(jl.getSize());
							jl.setLocation(0+(i*jl.getWidth()),0);
							jl.setHorizontalAlignment(JLabel.CENTER);
							jl.setForeground(Color.white);		
							jl.setVisible(true);
						}
						for(int i=0;i<entrys.size();i++) {
							JTextField entry[] = entrys.get(i);
							for(int j=0;j<size;j++) {
								JTextField jt = entry[j];						
								jt.setSize(etiquetas[j].getSize());
								jt.setLocation(etiquetas[j].getX(),i*jt.getHeight());
								jt.setVisible(true);
								try {
									sleep(10);
									
								}
								catch(Exception ee) {
									
								}
										
							}
						}
						
						for(int i=size;i<etiquetas.length;i++)
							etiquetas[i].setVisible(false);
						for(int i=0;i<entrys.size();i++) {
							JTextField entry[] = entrys.get(i);
							for(int j=size;j<entry.length;j++) {
								JTextField jt = entry[j];
								jt.setVisible(etiquetas[j].isVisible());
								try {
									sleep(10);
									
								}
								catch(Exception ee) {
									
								}
							}
						}
					}
				}).start();
			}
		});
		
		JButton ejecutar = new JButton("Ejecutar Simluacion");
		ejecutar.setSize(jcb.getWidth(),50);
		ejecutar.setLocation(jcb.getX(),jcb.getHeight()+jcb.getY()+5);		
		add(ejecutar);
		JLabel tej = new JLabel("Tiempo de Ejecucion");
		tej.setSize(jcb.getWidth()/2,100);
		tej.setFont(new Font("Arial",Font.BOLD,20));
		tej.setHorizontalAlignment(JLabel.CENTER);
		tej.setForeground(Color.white);
		tej.setLocation(jcb.getX(),ejecutar.getY()+ejecutar.getHeight());
		add(tej);
		
		
		JLabel te = new JLabel("Tiempo de Espera");
		te.setSize(jcb.getWidth()/2,100);
		te.setFont(new Font("Arial",Font.BOLD,20));
		te.setHorizontalAlignment(JLabel.CENTER);
		te.setForeground(Color.white);
		te.setLocation(jcb.getX()+te.getWidth(),ejecutar.getY()+ejecutar.getHeight());
		add(te);
		
		tiempoEspera = new JLabel();
		tiempoEspera.setSize(jcb.getWidth()/2,100);
		tiempoEspera.setFont(new Font("Arial",Font.BOLD,30));
		tiempoEspera.setHorizontalAlignment(JLabel.CENTER);
		tiempoEspera.setForeground(Color.white);
		tiempoEspera.setLocation(jcb.getX()+te.getWidth(),te.getY()+te.getHeight());
		add(tiempoEspera);
		
		tiempoEjecucion = new JLabel();
		tiempoEjecucion.setSize(jcb.getWidth()/2,100);
		tiempoEjecucion.setFont(new Font("Arial",Font.BOLD,30));
		tiempoEjecucion.setHorizontalAlignment(JLabel.CENTER);
		tiempoEjecucion.setForeground(Color.white);
		tiempoEjecucion.setLocation(jcb.getX(),te.getY()+te.getHeight());
		add(tiempoEjecucion);
		
		ejecutar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(algoritmo instanceof RoundRobin) {
					try {
						int quantum = Integer.parseInt(JOptionPane.showInputDialog("Quantum"));
						algoritmo = new RoundRobin(quantum);
					}
					catch(Exception ee) {
						JOptionPane.showMessageDialog(null, "QUANTUM NO VALIDO");
						return;
					}
				}
				procesos.clear();
				int arr[] = {0,0,0,0};					
				for(int i=0;i<entrys.size();i++) {
					try {							
						JTextField[] entry = entrys.get(i);
						int size = entry.length-(entry[entry.length-1].isVisible()?0:1);
						for(int j=0;j<size;j++) {
							arr[j]=Integer.parseInt(entry[j].getText());
						}
						procesos.add(new Proceso(arr[0],arr[1],arr[2],arr[3]));
					}
					catch(Exception ee) {							
					
					}
					
				}
				JOptionPane.showMessageDialog(null, "Se han cargado "+procesos.size()+" procesos");
				run();
			}
		});
	}
	
	private void iniTable() {
		table = new ScrollPanel(getWidth()/2,getHeight()-160);
		table.setLocation((getWidth()/4),70);
		table.border.color("all",Color.blue);
		table.back.setBackground(Color.darkGray);
		table.setLocation(0,20);
		String arr[]= {"ID PROCESO","TIEMPO RAFAGA","TIEMPO LLEGADA","PRIORIDAD"};
		for(int i=0;i<arr.length;i++) {
			JLabel jl = new JLabel(arr[i]);
			etiquetas[i]=jl;
			jl.setSize(table.getWidth()/4,20);			
			jl.setBorder(new LineBorder(Color.blue));
			jl.setLocation(0+(i*jl.getWidth()),0);
			jl.setHorizontalAlignment(JLabel.CENTER);
			jl.setForeground(Color.white);
			add(jl);
		}
		for(int i=0;i<17;i++) {
			JTextField entry[] = new JTextField[etiquetas.length];
			for(int j=0;j<etiquetas.length;j++) {
				JTextField jt = new JTextField();
				entry[j]=jt;
				if(j==0) {
					jt.setText(""+(i+1));
					jt.setEditable(false);
				}
				jt.setHorizontalAlignment(JTextField.CENTER);
				jt.setSize(etiquetas[j].getSize());
				jt.setLocation(etiquetas[j].getX(),i*jt.getHeight());
				table.back.add(jt);				
			}
			entrys.add(entry);
		}
		add(table);
	}

	public void run() {
		zone.back.removeAll();
		zone.back.repaint();
		xpos=10;
		ultimo=null;
		cpuPromedio=0;
		esperaPromedio=0;
		TreeMap<Integer,Proces > map = new TreeMap<>();
		float cp = procesos.size();
		for(int i=0; ; i++) {			
			while(!procesos.isEmpty() && procesos.peek().getInicio()==i) {
				algoritmo.add(procesos.poll());
			}
			Proceso pr = algoritmo.procces();
			if(pr==null&&procesos.isEmpty()) {
				if(ultimo!=null) {
					ultimo.tf=i;
					pintar(true);
					ultimo=null;
				}									
				if(algoritmo instanceof RoundRobin) {
					esperaPromedio=0;
					for(int k:map.keySet())
						esperaPromedio+=map.get(k).ti;
				}
				tiempoEspera.setText(""+esperaPromedio/cp);
				tiempoEjecucion.setText(""+cpuPromedio/cp);
				System.out.println("ESPERA: "+esperaPromedio/cp);
				System.out.println("CPU: "+cpuPromedio/cp);
				return;
			}
			else if(pr==null) {
				if(ultimo!=null) {
					//map.get(ultimo.id).ti+=(ultimo.ti-map.get(ultimo.id).tf);
					ultimo.tf=i;						
					map.get(ultimo.id).tf=i;
					pintar(false);
					ultimo=null;
				}
				esperaPromedio=0;
				
				continue;
			}
			if(ultimo==null) {
				ultimo = new Proces(pr.getId(),i,i);
				if(map.get(ultimo.id)==null)
				map.put(ultimo.id , new Proces(pr.getId(),i,i));
				else {
					System.out.println(ultimo.id+" "+ultimo.ti+" "+map.get(ultimo.id).tf);
					map.get(ultimo.id).ti+=(ultimo.ti-map.get(ultimo.id).tf-1);
					map.get(ultimo.id).tf=i;
				}
			}
			else if(ultimo.id==pr.getId()) {
				map.get(ultimo.id).ti+=(ultimo.ti-map.get(ultimo.id).tf);
				ultimo.tf=i;
				map.get(ultimo.id).tf=i;
			}
			else {
				pintar(false);
				ultimo = new Proces(pr.getId(),i,i);
				if(map.get(ultimo.id)==null)
				map.put(ultimo.id , new Proces(pr.getId(),i,i));
				else {
					System.out.println(ultimo.id+" "+ultimo.ti+" "+map.get(ultimo.id).tf);
					map.get(ultimo.id).ti+=(ultimo.ti-map.get(ultimo.id).tf-1);
					map.get(ultimo.id).tf=i;
				}
			}
		}
		
	}
	
	private void pintar(boolean b) {
		esperaPromedio+=ultimo.ti;
		JLabel jl = new JLabel();
		jl.setHorizontalAlignment(JLabel.CENTER);
		jl.setSize(100,40);
		jl.setText("P"+ultimo.id);
		jl.setLocation(xpos,(zone.back.getHeight()/2)-(jl.getHeight()/2));		
		jl.setOpaque(true);
		jl.setBackground(Color.white);
		jl.setBorder(new LineBorder(Color.blue));
		JLabel ti = new JLabel(""+ultimo.ti);
		ti.setSize(40,40);
		ti.setLocation(xpos-(ti.getWidth()/2),jl.getHeight()+jl.getY());
		ti.setVerticalAlignment(JLabel.TOP);
		ti.setForeground(Color.white);
		ti.setHorizontalAlignment(JLabel.CENTER);
		
		zone.back.add(ti);
		xpos+=jl.getWidth();
		JLabel tf = new JLabel(""+ultimo.tf);
		if(b) {
			cpuPromedio=ultimo.tf;
			tf.setSize(40,40);
			tf.setLocation(xpos-(tf.getWidth()/2),jl.getHeight()+jl.getY());
			tf.setVerticalAlignment(JLabel.TOP);
			tf.setForeground(Color.white);
			tf.setHorizontalAlignment(JLabel.CENTER);
		}
		JLabel mark = new JLabel();
	
		zone.back.add(mark);
		zone.back.add(tf);
		zone.back.add(jl);
		zone.back.setSize(xpos+10,zone.back.getHeight());
		up=!up;
//		System.out.println(jl.getSize()+" "+jl.getLocation());
		repaint();
		
	}
	
	private void iniZone() {
		zone = new ScrollPanel(getWidth()-15,100);
		zone.setLocation(0,getHeight()-zone.getHeight()-40);
		zone.back.setBackground(Color.DARK_GRAY);
		zone.setBackground(Color.DARK_GRAY);
		zone.hsb.inactive=Color.cyan;
		zone.hsb.active=Color.cyan;
		zone.border.color("all", Color.blue);
		add(zone);
		
	}
	
	public static void main(String args[]) {
		new Ventana();
	}
}
