package medios_uci;

import javax.swing.*;

import java.awt.*;

import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class Ventana extends JFrame {

	JPanel showing = null;
	JButton atras = new JButton("atras");

	private JPanel newPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(400, 420);
		panel.setLocation(300, 0);
		panel.setBackground(Color.white);
		return panel;
	}

	private JPanel equiposPanel() {
		JPanel panel = newPanel();
		JTextArea txt = new JTextArea();
		JScrollPane scroll = new JScrollPane(txt);
		JButton actualizar = new JButton("Actualizar");
		actualizar.setSize(100, atras.getHeight());
		actualizar.setLocation(atras.getWidth() + 15, atras.getY());
		actualizar.addActionListener((ActionEvent) -> {
			txt.setText(CONTROL.cantidadEquipos());
			scroll.revalidate();
		});
		txt.setSize(panel.getWidth(), panel.getHeight() - atras.getHeight() - atras.getY());
		scroll.setSize(txt.getSize());
		txt.setLocation(0, atras.getHeight() + atras.getY());
		scroll.setLocation(txt.getLocation());
		txt.setBackground(null);
		txt.setEditable(false);
		panel.add(actualizar);
		panel.add(scroll);

		return panel;
	}

	private JPanel estadosPanel() {
		JPanel panel = newPanel();
		JTextArea txt = new JTextArea();
		JButton actualizar = new JButton("Actualizar");
		actualizar.setSize(100, atras.getHeight());
		actualizar.setLocation(atras.getWidth() + 15, atras.getY());
		actualizar.addActionListener((ActionEvent) -> {
			txt.setText(CONTROL.estadoMedios());
		});
		txt.setSize(panel.getWidth(), panel.getHeight() - atras.getHeight() - atras.getY());
		txt.setLocation(0, atras.getHeight() + atras.getY());
		txt.setBackground(null);
		txt.setEditable(false);
		panel.add(actualizar);
		panel.add(txt);
		return panel;
	}

	private JPanel garantiasPanel() {
		JPanel panel = newPanel();
		JTextArea txt = new JTextArea();
		JButton actualizar = new JButton("Actualizar");
		actualizar.setSize(100, atras.getHeight());
		actualizar.setLocation(atras.getWidth() + 15, atras.getY());
		actualizar.addActionListener((ActionEvent) -> {
			txt.setText(CONTROL.garantias());
		});
		txt.setSize(panel.getWidth(), panel.getHeight() - atras.getHeight() - atras.getY());
		txt.setLocation(0, atras.getHeight() + atras.getY());
		txt.setBackground(null);
		txt.setEditable(false);
		panel.add(actualizar);
		panel.add(txt);
		return panel;
	}

	private JPanel proveedoresPanel() {
		JPanel panel = newPanel();
		JTextArea txt = new JTextArea();
		JButton actualizar = new JButton("Actualizar");
		actualizar.setSize(100, atras.getHeight());
		actualizar.setLocation(atras.getWidth() + 15, atras.getY());
		actualizar.addActionListener((ActionEvent) -> {
			txt.setText(CONTROL.proveedores());
		});
		txt.setSize(panel.getWidth(), panel.getHeight() - atras.getHeight() - atras.getY());
		txt.setLocation(0, atras.getHeight() + atras.getY());
		txt.setBackground(null);
		txt.setEditable(false);
		panel.add(actualizar);
		panel.add(txt);
		return panel;
	}

	private void guardarMuebles() {
		CONTROL.guardarMuebles();
	}

	private JPanel costes() {
		JPanel panel = newPanel();
		JTextArea txt = new JTextArea();
		JButton actualizar = new JButton("Actualizar");
		actualizar.setSize(100, atras.getHeight());
		actualizar.setLocation(atras.getWidth() + 15, atras.getY());
		actualizar.addActionListener((ActionEvent) -> {
			txt.setText(CONTROL.costes());
		});
		txt.setSize(panel.getWidth(), panel.getHeight() - atras.getHeight() - atras.getY());
		txt.setLocation(0, atras.getHeight() + atras.getY());
		txt.setBackground(null);
		panel.add(actualizar);
		panel.add(txt);
		return panel;
	}

	private void show(JPanel panel, boolean back) {
		if (showing != null)
			showing.setVisible(false);
		showing = panel;
		panel.setVisible(true);
		if (back)
			panel.add(atras);
		add(panel);
		panel.repaint();
	}

	private void panelNuevo() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(300, 420);
		panel.setBackground(Color.lightGray);
		add(panel);

		FocusListener seleccionar = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				((JTextField) e.getSource()).selectAll();

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

		};
		ArrayList<String> provers = new ArrayList<>();
		final JButton proveedores = new JButton("+");

		final JTextField serie = new JTextField("No. Serie"), costeu = new JTextField("Coste Unitario"),
				proveedor = new JTextField("Proveedor"), garantia = new JTextField("Garantia"),
				explotacion = new JTextField("Explotación"), prov = new JTextField("Otros proveedores");
		final JComboBox<String> tipo, producto = new JComboBox<String>(), marca = new JComboBox<String>(),
				local = new JComboBox<String>(), estado = new JComboBox<String>();

		serie.setSize(200, 30);
		serie.setLocation(50, 5);
		serie.addFocusListener(seleccionar);
		panel.add(serie);

		costeu.setSize(200, 30);
		costeu.setLocation(50, 40);
		costeu.addFocusListener(seleccionar);
		panel.add(costeu);

		estado.setSize(200, 30);
		estado.addItem("Bien");
		estado.addItem("Regular");
		estado.addItem("Mal");
		estado.setLocation(50, 75);
		panel.add(estado);

		proveedor.setSize(200, 30);
		proveedor.setLocation(50, 110);
		proveedor.addFocusListener(seleccionar);
		panel.add(proveedor);

		tipo = new JComboBox<String>();
		tipo.addItem(Equipo.TIPO);
		tipo.addItem(Mueble.TIPO);
		tipo.setSize(200, 30);
		tipo.setLocation(50, 145);
		tipo.addActionListener((ActionEvent) -> {
			producto.removeAllItems();
			if (tipo.getSelectedIndex() == 0) {
				for (String i : Equipo.CLASIFICACIONES)
					producto.addItem(i);
				explotacion.setVisible(false);
				local.setVisible(false);
				prov.setVisible(true);
				proveedores.setVisible(true);
				marca.setVisible(true);
				garantia.setVisible(true);
			} else {
				for (String i : Mueble.CLASIFICACIONES)
					producto.addItem(i);
				explotacion.setVisible(true);
				local.setVisible(true);
				prov.setVisible(false);
				proveedores.setVisible(false);
				marca.setVisible(false);
				garantia.setVisible(false);
			}
		});
		panel.add(tipo);

		producto.setSize(200, 30);
		producto.setLocation(50, 180);
		for (String i : Equipo.CLASIFICACIONES)
			producto.addItem(i);
		panel.add(producto);

		marca.setSize(200, 30);
		marca.setLocation(50, 215);
		for (String i : Equipo.MARCA)
			marca.addItem(i);
		panel.add(marca);

		local.setSize(200, 30);
		local.setLocation(50, 215);
		for (String i : Mueble.LOCAL)
			local.addItem(i);
		panel.add(local);
		local.setVisible(false);

		garantia.setSize(200, 30);
		garantia.setLocation(50, 250);
		garantia.addFocusListener(seleccionar);
		panel.add(garantia);

		explotacion.setSize(200, 30);
		explotacion.setLocation(50, 250);
		explotacion.addFocusListener(seleccionar);
		panel.add(explotacion);
		explotacion.setVisible(false);

		prov.setSize(155, 30);
		prov.addFocusListener(seleccionar);
		proveedores.setSize(45, 30);
		prov.setLocation(50, 285);
		proveedores.setLocation(205, 285);
		proveedores.addActionListener((ActionEvent) -> {
			provers.add(prov.getText());
			JOptionPane.showMessageDialog(null, prov.getText() + " Añadido a la lista de proovedores");
		});
		panel.add(prov);
		panel.add(proveedores);

		JButton aceptar = new JButton("Añadir");
		aceptar.setSize(220, 50);
		aceptar.setLocation(40, 320);
		aceptar.addActionListener((ActionEvent) -> {
			try {
				Medio m;
				String noSerie = serie.getText();
				float coste = Float.parseFloat(costeu.getText());
				int status = estado.getSelectedIndex();
				String prove = proveedor.getText();
				int clasi = producto.getSelectedIndex();

				if (tipo.getSelectedIndex() == 0) {
					int mar = marca.getSelectedIndex();
					int gar = Integer.parseInt(garantia.getText());
					m = new Equipo(noSerie, coste, status, prove, gar, mar, provers, clasi);
					provers.clear();
				} else {
					int loc = local.getSelectedIndex();
					int expl = Integer.parseInt(explotacion.getText());
					m = new Mueble(noSerie, coste, status, prove, loc, expl, clasi);
				}
				CONTROL.addMedio(m);
				JOptionPane.showMessageDialog(null, m.getClass().getSimpleName() + " añadido con exito");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al añadir, porfavor revise todos lo datos");
			}
		});
		panel.add(aceptar);
		panel.repaint();

	}

	private void panelMenu() {
		final JButton equipos, estados, garantias, proveedores, guardar, costes;
		atras.setSize(80, 30);
		atras.setLocation(5, 5);
		JPanel menu = new JPanel();
		JPanel equiposPanel = equiposPanel();
		JPanel estadosPanel = estadosPanel();
		JPanel garantiasPanel = garantiasPanel();
		JPanel proveedoresPanel = proveedoresPanel();
		JPanel costesPanel = costes();
		menu.setLayout(null);
		menu.setSize(400, 420);
		menu.setLocation(300, 0);
		menu.setBackground(Color.white);
		add(menu);

		equipos = new JButton("Equipos");
		equipos.setSize(175, 40);
		equipos.setLocation(13, 13);
		equipos.addActionListener((ActionEvent) -> {
			show(equiposPanel, true);
		});
		menu.add(equipos);

		estados = new JButton("Estado");
		estados.setSize(175, 40);
		estados.setLocation(equipos.getX() + equipos.getWidth() + 5, equipos.getY());
		estados.addActionListener((ActionEvent) -> {
			show(estadosPanel, true);
		});
		menu.add(estados);

		garantias = new JButton("Garantias");
		garantias.setSize(175, 40);
		garantias.setLocation(equipos.getX(), equipos.getY() + equipos.getHeight() + 5);
		garantias.addActionListener((ActionEvent) -> {
			show(garantiasPanel, true);
		});
		menu.add(garantias);

		proveedores = new JButton("Principales Proveedores");
		proveedores.setSize(175, 40);
		proveedores.setLocation(garantias.getX() + garantias.getWidth() + 5, garantias.getY());
		proveedores.addActionListener((ActionEvent) -> {
			show(proveedoresPanel, true);
		});
		menu.add(proveedores);

		costes = new JButton("Costes");
		costes.setSize(175, 40);
		costes.setLocation(garantias.getX(), garantias.getY() + garantias.getHeight() + 5);
		costes.addActionListener((ActionEvent) -> {
			show(costesPanel, true);
		});
		menu.add(costes);

		guardar = new JButton("Guardar Muebles");
		guardar.setSize(175, 40);
		guardar.setLocation(costes.getX() + costes.getWidth() + 5, costes.getY());
		guardar.addActionListener((ActionEvent) -> {
			guardarMuebles();
		});
		menu.add(guardar);

		atras.addActionListener((ActionEvent) -> {
			show(menu, false);
		});
		showing = menu;
	}

	Ventana() {
		setLayout(null);
		setSize(715, 450);
		panelNuevo();
		panelMenu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String args[]) {
		new Ventana();
	}
}
