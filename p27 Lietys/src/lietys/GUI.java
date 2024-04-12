package lietys;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class GUI extends JFrame {

	private JComboBox<String> tipoVuelo = new JComboBox<String>();
	private JComboBox<Avion> tipoAvion = new JComboBox<Avion>();
	private JComboBox<Terminal> seleccionTerminal = new JComboBox<Terminal>();
	private JComboBox<Terminal> seleccionVuelos = new JComboBox<Terminal>();
	private JTextArea mostrarDatos = new JTextArea();

	private JPanel funcionalidades;
	private JPanel panelMostrado = null;
	private JPanel paneles[] = new JPanel[20];
	private String ops[] = new String[] { "Nuevo", "", "", "A�adir Reservacion", "Ganancias Entre Fechas",
			"Vuelos por Terminal", "Ventas por Vuelo", "", "", "" };

	private Aereopuerto marti = new Aereopuerto();

	private void ponerFondo(JPanel panel,String ruta) {
		ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource(ruta)).getImage().getScaledInstance(panel.getWidth(), panel.getHeight(),Image.SCALE_SMOOTH));
		JLabel fondo = new JLabel(img);
		fondo.setSize(panel.getSize());
		panel.add(fondo);
		panel.repaint();
	}
	
	private void ventas_entre_fechas() {
		JPanel panel = paneles[4];
		JTextField fecha1;
		JTextField fecha2;
		JLabel results = new JLabel();
		results.setSize(panel.getWidth(), panel.getHeight() - 50);
		results.setLocation(0, 50);
		results.setBackground(Color.gray);
		results.setBorder(null);
		results.setHorizontalAlignment(JLabel.CENTER);

		
		fecha1 = new JTextField();
		
		fecha1.setBorder(null);
		fecha1.setSize(180, 25);
		fecha1.setLocation(100,5);
		panel.add(fecha1);

		fecha2 = new JTextField();
		
		fecha2.setBorder(null);
		fecha2.setSize(180, 25);
		fecha2.setLocation(100,5);
		fecha2.setLocation(panel.getWidth() - 300, 5);
		panel.add(fecha2);
	

		JButton aceptar = new JButton("Buscar");
		aceptar.addActionListener((ActionEvent e) -> {
			try {
				Date f1 = new Date(fecha1.getText());
				Date f2 = new Date(fecha2.getText());
				System.out.println(f1.getYear());
				System.out.println(f2.getYear());
				float ganancias = marti.ventas_entre_fechas(f1,f2);
				results.setText("");
				results.setText("Se ganaron $" + ganancias);
			}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null, "Fechas Incorrectas");
			}
		});

		aceptar.setSize(175, 40);
		aceptar.setLocation((panel.getWidth() / 2) - (aceptar.getWidth() / 2), 5);
		panel.add(aceptar);
		panel.add(results);

	}

	private void ventas_por_vuelo() {
		JPanel panel = paneles[6];
		JComboBox j = new JComboBox();
		JLabel ganancias = new JLabel();
		j.setSize(panel.getWidth(), 30);
		ganancias.setSize(300, 30);
		ganancias.setHorizontalAlignment(JLabel.CENTER);
		ganancias.setLocation((panel.getWidth() / 2) - (ganancias.getWidth() / 2), j.getY() + j.getHeight());
		panel.add(j);
		panel.add(ganancias);

		j.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				j.removeAllItems();
				for (Terminal t : marti.terminales) {
					for (Vuelo v : t.vuelos) {
						j.addItem(v);
					}
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

		});
		j.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ganancias.setText("El vuelo genero : 0$");
				if (j.getSelectedItem() == null)
					return;
				float c = marti.ventas_por_vuelo((Vuelo) j.getSelectedItem());
				ganancias.setText("El vuelo genero : " + c + "$");
			}
		});

	}

	private JPanel annadir_nueva_terminal() {
		JPanel panel = paneles[9];
		panel.setSize(panel.getWidth() / 3, panel.getHeight());
		JLabel etiqueta = new JLabel("Nueva Terminal");
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		etiqueta.setSize(panel.getWidth(), 40);
		panel.add(etiqueta);
		String textos[] = new String[] { "Nombre", "Numero" };
		JTextField entradas[] = new JTextField[2];
		for (int i = 0; i < textos.length; i++) {
			JLabel j = new JLabel(textos[i]);
			j.setSize(100, 30);
			j.setLocation(5, 45 + (i * 5) + (i * 30));
			JTextField jtf = new JTextField();
			entradas[i] = jtf;
			jtf.setSize(200, 30);
			jtf.setLocation(5 + j.getWidth(), j.getY());
			jtf.setBorder(null);
			panel.add(j);
			panel.add(jtf);
		}
		JButton aceptar = new JButton("Registrar Terminal");
		aceptar.setSize(175, 40);
		aceptar.setLocation((panel.getWidth() / 2) - (aceptar.getWidth() / 2),
				panel.getHeight() - 35 - aceptar.getHeight());
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean quit = false;
				for (JTextField i : entradas) {
					if (i.getText().equals("")) {
						i.setText("Este campo es obligatorio");
						quit = true;
					}
				}
				if (quit) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos porfavor");
					// JOptionPane.showMessageDialog(null, "Hubo un error");
					return;
				}

				try {
					String nombre = entradas[0].getText();
					int numero = Integer.parseInt(entradas[1].getText());
					Terminal nueva = marti.annadir_nueva_terminal(nombre, numero);
					seleccionVuelos.addItem(nueva);
					seleccionTerminal.addItem(nueva);

					for (Component i : panel.getComponents()) {
						if (i.getClass() == JTextField.class)
							((JTextField) i).setText("");
					}

					JOptionPane.showMessageDialog(null, "Terminal A�adida con Exito");
					marti.guardarDatosTerminales();
					;
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Error al registrar la terminal");
					// JOptionPane.showMessageDialog(null, "Hubo un Error");
				}
			}
		});
		panel.add(aceptar);
		ponerFondo(panel,"/term.jpg");
		return panel;
	}

	private JPanel annadir_nuevo_avion() {
		JPanel panel = paneles[2];
		panel.setSize(panel.getWidth() / 3, panel.getHeight());
		JLabel etiqueta = new JLabel("Nuevo Avi�n");
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		etiqueta.setSize(panel.getWidth(), 40);
		panel.add(etiqueta);
		String textos[] = new String[] { "Nombre", "Modelo", "Matricula", "Pais Fabricante", "Cantidad de asientos" };
		JTextField entradas[] = new JTextField[5];
		for (int i = 0; i < textos.length; i++) {
			JLabel j = new JLabel(textos[i]);
			j.setSize(130, 30);
			j.setLocation(5, 45 + (i * j.getHeight()) + (i * 5));
			JTextField txt = new JTextField();
			txt.setSize(200, j.getHeight());
			txt.setLocation(j.getX() + j.getWidth(), j.getY());
			txt.setBorder(null);
			entradas[i] = txt;
			panel.add(j);
			panel.add(txt);
		}
		JButton aceptar = new JButton("Registrar Avion");
		aceptar.setSize(175, 40);
		aceptar.setLocation((panel.getWidth() / 2) - (aceptar.getWidth() / 2),
				panel.getHeight() - 35 - aceptar.getHeight());
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean quit = false;
				for (Component i : panel.getComponents()) {
					if (i.getClass() == JTextField.class) {
						JTextField jj = (JTextField) i;
						if (jj.getText().equals("")) {
							quit = true;
							jj.setText("Este campo es obligatorio");
						}
					}
				}
				if (quit) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos");
					// JOptionPane.showMessageDialog(null, "Error al registrar el avion");
					return;
				}
				try {
					String nombre = entradas[0].getText();
					String modelo = entradas[1].getText();
					String matricula = entradas[2].getText();
					String pais = entradas[3].getText();
					int asientos = Integer.parseInt(entradas[4].getText());
					Avion nuevo = marti.annadir_nuevo_avion(nombre, modelo, matricula, pais, asientos);
					System.out.println(nuevo);
					tipoAvion.addItem(nuevo);

					JOptionPane.showMessageDialog(null, "Avion a�adido con exito");
					marti.guardarDatosAviones();
					;
					for (Component i : panel.getComponents()) {
						if (i.getClass() == JTextField.class)
							((JTextField) i).setText("");
					}

				} catch (Exception ee) {
					// JOptionPane.showMessageDialog(null, "Error al Registrar el avion");
					System.out.println("hubo un error al añadir un nuevo avion");
					JOptionPane.showMessageDialog(null, "Error al registrar el avion");
					ee.printStackTrace();
				}
			}
		});
		panel.add(aceptar);
		ponerFondo(panel,"/avion.jpg");
		return panel;
	}

	private JPanel annadir_reservacion() {
		JPanel panel = paneles[3];
		String textos[] = new String[] { "Nombre", "Apellidos", "Vuelo", "Categoria" };
		JTextField txt[] = new JTextField[2];
		JComboBox jcb[] = new JComboBox[2];

		for (int i = 0; i < textos.length; i++) {
			JLabel j = new JLabel(textos[i]);
			j.setSize(100, 30);
			j.setLocation(5, 5 + (i * j.getHeight()) + (i * 5));
			panel.add(j);

			if (i < 2) {
				JTextField tx = new JTextField();
				txt[i] = tx;
				tx.setSize(200, 30);
				tx.setLocation(j.getX() + j.getWidth(), j.getY());
				tx.setBorder(null);
				panel.add(tx);
			}

			else {
				JComboBox cb = new JComboBox();
				jcb[i - 2] = cb;
				cb.setSize(60, 30);
				cb.setLocation(j.getX() + j.getWidth(), j.getY());

				if (i == 2) {
					cb.setSize(600, 30);
					cb.addFocusListener(new FocusListener() {

						@Override
						public void focusGained(FocusEvent e) {
							cb.removeAllItems();
							for (Terminal t : marti.terminales) {
								for (Vuelo v : t.vuelos) {
									if (v.getOcupado() < v.getCapacidad()) {
										cb.addItem(v);
									}
								}
							}
							cb.revalidate();
						}

						@Override
						public void focusLost(FocusEvent e) {

						}

					});

					cb.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							boolean c[] = new boolean[4];
							jcb[1].removeAllItems();
							if (cb.getSelectedItem() == null)
								return;
							for (Asiento i : ((Vuelo) cb.getSelectedItem()).getAvion().getAsiento()) {
								if (i.getPersona() == null) {
									if (!c[i.getCategoria()]) {
										jcb[1].addItem(i);
										c[i.getCategoria()] = true;
									}
								}
							}
						}
					});
				}

				panel.add(cb);

			}
		}
		JButton aceptar = new JButton("Registrar Reservacion");
		aceptar.setSize(panel.getWidth(), 40);
		aceptar.setLocation(panel.getWidth() - aceptar.getWidth() - 5, panel.getHeight() - aceptar.getHeight() - 35);
		panel.add(aceptar);

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean quit = false;
				for (Component i : panel.getComponents()) {
					if (i.getClass() == JTextField.class) {
						JTextField j = (JTextField) i;
						if (j.getText().equals("")) {
							quit = true;
							j.setText("Este campo es obligatorio");
						}
					} else if (i.getClass() == JComboBox.class) {
						JComboBox j = (JComboBox) i;
						if (j.getSelectedItem() == null) {
							quit = true;
						}
					}

				}
				if (quit) {
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
					return;
				}
				try {
					Persona persona = new Persona(txt[0].getText(), txt[1].getText());
					Asiento asiento = (Asiento) jcb[1].getSelectedItem();
					marti.annadir_reservacion(persona, asiento, (Vuelo) jcb[0].getSelectedItem());
					marti.guardarDatosTerminales();
					;
					JOptionPane.showMessageDialog(null, "Reservaci�n a�adida con exito");
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Error al Registrar la reservaci�n");
				}
			}
		});
		ponerFondo(panel,"/reser.jpg");
		return panel;
	}

	private boolean fechaAnterior(Date a, Date b) {
		return (a.getYear()<=b.getYear())&&(a.getMonth()<=b.getMonth())&&(a.getDate()<=b.getDate());
	}

	private JPanel annadir_nuevo_vuelo() {
		JPanel panel = paneles[1];
		panel.setSize(panel.getWidth() / 3, panel.getHeight());
		JLabel etiqueta = new JLabel("Nuevo Vuelo");
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		etiqueta.setSize(panel.getWidth(), 40);
		panel.add(etiqueta);
		String textos[] = new String[] { "Pais Destino", "Ciudad Destino", "Tipo de Vuelo", "Avion", "Terminal",
				"Salida M/D/A", "Llegada M/D/A", "Distancia(KM)", "Precio del vuelo", "Precio del viaje" };
		for (int i = 0; i < textos.length; i++) {
			JLabel j = new JLabel(textos[i]);
			j.setSize(100, 30);
			j.setLocation(5, 45 + (i * 40));
			panel.add(j);
		}

		tipoVuelo.addItem("Internacional");
		tipoVuelo.addItem("Nacional");
		tipoVuelo.setSelectedIndex(-1);
		tipoVuelo.setSize(200, 30);
		tipoAvion.setSize(200, 30);
		seleccionTerminal.setSize(200, 30);

		tipoAvion.setSelectedIndex(-1);
		seleccionTerminal.setSelectedIndex(-1);

		JTextField salida;
		JTextField llegada;

			
		salida = new JTextField();
		salida.setBorder(null);
		salida.setSize(180, 25);
		salida.setLocation(100, 205 + 45);
		panel.add(salida);

		llegada = new JTextField();
		llegada.setBorder(null);
		llegada.setSize(180, 25);
		llegada.setLocation(100, 205 + 45 +45);
		panel.add(llegada);
		

		JTextField paisDestino = new JTextField();
		paisDestino.setSize(200, 30);
		paisDestino.setBorder(null);
		JTextField ciudadDestino = new JTextField();
		ciudadDestino.setSize(200, 30);
		ciudadDestino.setBorder(null);
		JTextField KM = new JTextField();
		KM.setSize(200, 30);
		KM.setBorder(null);
		JTextField costevuelo = new JTextField();
		costevuelo.setSize(200, 30);
		costevuelo.setBorder(null);

		JTextField costeviaje = new JTextField();
		costeviaje.setSize(200, 30);
		costeviaje.setBorder(null);
		JButton aceptar = new JButton("Registrar Vuelo");
		aceptar.setSize(175, 40);
		aceptar.setLocation((panel.getWidth() / 2) - (aceptar.getWidth() / 2),
				panel.getHeight() - 35 - aceptar.getHeight());
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean quit = false;
				for (Component i : panel.getComponents()) {
					if (i.getClass() == JTextField.class) {
						JTextField txt = (JTextField) i;
						if (txt.getText().equals("")) {
							quit = true;
							txt.setText("Este campo es obligatorio");
						}
					} else if (i.getClass() == JComboBox.class) {
						JComboBox jcb = (JComboBox) i;
						if (jcb.getSelectedItem() == null)
							quit = true;
					}
				}
				if (quit) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos");
					return;
				}
				try {
					Date sal = new Date(salida.getText());
					
					System.out.println(sal.toGMTString());
					Date lle = new Date(llegada.getText());
					System.out.println(lle.toGMTString());

					if (!fechaAnterior(sal, lle) ) {
						JOptionPane.showMessageDialog(null, "Fechas incorrectas");
						return;
					}

					Terminal termin = (Terminal) seleccionTerminal.getSelectedItem();
					float precio = Float.parseFloat(costevuelo.getText());
					if (tipoVuelo.getSelectedItem().equals("Internacional"))
						precio += Float.parseFloat(costeviaje.getText()) * 0.1f;
					else
						precio += Float.parseFloat(costeviaje.getText()) * 0.2f;
					marti.annadir_nuevo_vuelo(tipoVuelo.getSelectedItem().toString(), sal, lle,
							((Avion) tipoAvion.getSelectedItem()).clone(), termin, paisDestino.getText(),
							ciudadDestino.getText(), Integer.parseInt(KM.getText()),
							Float.parseFloat(costevuelo.getText()), Float.parseFloat(costeviaje.getText()), precio);
					JOptionPane.showMessageDialog(null, "Vuelo a�adido con exito");
					for (Component i : panel.getComponents()) {
						if (i.getClass() == JTextField.class)
							((JTextField) i).setText("");
					}

				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Error al registrar el vuelo");
					System.out.println("Error al añadir vuelo");
				}
			}
		});

		paisDestino.setLocation(100, 5 + 45);
		ciudadDestino.setLocation(100, 45 + 45);
		KM.setLocation(100, 285 + 45);
		tipoVuelo.setLocation(100, 85 + 45);
		tipoAvion.setLocation(100, 125 + 45);
		seleccionTerminal.setLocation(100, 165 + 45);
		costevuelo.setLocation(100, 325 + 45);
		costeviaje.setLocation(100, 365 + 45);
		panel.add(tipoVuelo);
		panel.add(tipoAvion);
		panel.add(seleccionTerminal);
		panel.add(ciudadDestino);
		panel.add(paisDestino);
		panel.add(KM);
		panel.add(costevuelo);
		panel.add(costeviaje);
		panel.add(aceptar);
		ponerFondo(panel,"/vuelo.jpg");
		return panel;
	}

	private void annadir_nuevo() {
		JPanel terminal = annadir_nueva_terminal();
		JPanel vuelo = annadir_nuevo_vuelo();
		JPanel avion = annadir_nuevo_avion();
		JPanel panel = paneles[0];

		panel.setBackground(Color.red);
		terminal.setLocation(0, 0);
		vuelo.setLocation(terminal.getWidth(), 0);
		avion.setLocation(vuelo.getWidth() + vuelo.getX(), 0);
		terminal.setVisible(true);
		vuelo.setVisible(true);
		avion.setVisible(true);
		panel.add(terminal);
		panel.add(vuelo);
		panel.add(avion);
		System.out.println(panel.countComponents());
	}

	private void vuelos_por_terminal() {
		JPanel panel = paneles[5];

		for (Terminal terminal : marti.terminales)
			seleccionVuelos.addItem(terminal);

		seleccionVuelos.setSelectedIndex(-1);
		seleccionVuelos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos.setText(null);
				for (Vuelo i : ((Terminal) seleccionVuelos.getSelectedItem()).vuelos) {
					mostrarDatos.setText(mostrarDatos.getText() + "\n" + i.toString() + "\n");
				}
			}
		});
		seleccionVuelos.setSize(200, 30);
		seleccionVuelos.setLocation((panel.getWidth() / 2) - (seleccionVuelos.getWidth() / 2), 0);
		JScrollPane sp = new JScrollPane(mostrarDatos);
		sp.setSize(panel.getWidth(), panel.getHeight() - seleccionVuelos.getHeight());
		sp.setLocation((panel.getWidth() / 2) - (sp.getWidth() / 2), seleccionVuelos.getHeight());
		mostrarDatos.setBackground(Color.gray);
		mostrarDatos.setBorder(null);
		mostrarDatos.setEditable(false);

		panel.add(seleccionVuelos);
		panel.add(sp);
	}

	private void annadir_paneles() {
		for (int i = 0; i < paneles.length; i++) {
			JPanel p = new JPanel();
			paneles[i] = p;
			p.setLayout(null);
			p.setOpaque(true);
			p.setBackground(Color.cyan);
			p.setSize(this.getWidth(), getHeight() - funcionalidades.getHeight());
			p.setLocation(0, funcionalidades.getHeight());
			p.setVisible(false);
			this.add(p);
		}
	}

	private void annadir_funcionalidades() {

		for (int i = 0, j = 0; i < ops.length; i++) {
			if (ops[i].equals(""))
				continue;
			JButton jtf = new JButton(ops[i]);
			jtf.setFocusable(false);
			jtf.setBackground(Color.white);
			jtf.setSize(175, 40);
			jtf.setLocation(100 + (j * jtf.getWidth()) + (j * 5), 5);
			final int pos = i;
			jtf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (panelMostrado != null)
						panelMostrado.setVisible(false);
					paneles[pos].setVisible(true);
					panelMostrado = paneles[pos];
				}
			});
			j++;
			funcionalidades.add(jtf);
		}
	}

	public GUI() {
		if (marti.aviones != null)
			for (Avion i : marti.aviones)
				tipoAvion.addItem(i);
		System.out.println(marti.aviones.size());
		if (marti.terminales != null)
			for (Terminal t : marti.terminales)
				seleccionTerminal.addItem(t);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 700);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		funcionalidades = new JPanel();
		funcionalidades.setLayout(null);
		funcionalidades.setSize(getWidth(), 50);
		funcionalidades.setBackground(Color.black);
		funcionalidades.setOpaque(true);
		annadir_funcionalidades();
		annadir_paneles();
		annadir_nuevo();
		annadir_reservacion();
		vuelos_por_terminal();
		ventas_por_vuelo();
		ventas_entre_fechas();
		this.add(funcionalidades);
		this.repaint();
		ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("/fondo.jpg")).getImage().getScaledInstance(paneles[0].getWidth(), paneles[0].getHeight(),Image.SCALE_SMOOTH));
		JLabel fondo = new JLabel(img);
		fondo.setLocation(paneles[0].getLocation());
		fondo.setSize(paneles[0].getSize());
		this.add(fondo);
		ponerFondo(funcionalidades,"/nubes.jpg");
		this.setVisible(true);
	}

}
