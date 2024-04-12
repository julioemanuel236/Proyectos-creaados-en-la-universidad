package cadena;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Interfaz extends JFrame{
	Cadena cadena;
	
	private void iniciar() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(getWidth(),getHeight());
		add(panel);
		
		JButton nuevoHotel = new JButton("Nuevo Hotel");
		nuevoHotel.setSize(panel.getWidth(),40);
		nuevoHotel.setLocation(0,0);
		
		panel.add(nuevoHotel);
		nuevoHotel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					cadena.nuevoHotel();
				
			}
			
		});
		
		JButton nuevaReservacion = new JButton("Nueva Reservacion");
		panel.add(nuevaReservacion);
		nuevaReservacion.setSize(panel.getWidth(),40);
		nuevaReservacion.setLocation(0,40);
		nuevaReservacion.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					cadena.nuevaReservacion();
				
			}
			
		});

		JButton ganancias = new JButton("Ganancias por Reservaciones");
		panel.add(ganancias);
		ganancias .setSize(panel.getWidth(),40);
		ganancias .setLocation(0,80);
		ganancias.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					String s = cadena.ganancias();
					JOptionPane.showMessageDialog(null, s);
			}
			
		});
		
		JButton paismayorpg= new JButton("Pais Mayor Porcentaje Ganancias");
		panel.add(paismayorpg);
		paismayorpg.setSize(panel.getWidth(),40);
		paismayorpg.setLocation(0,120);
		paismayorpg.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					String s = cadena.paisMasPorcentaje();
					JOptionPane.showMessageDialog(null, s);
			}
			
		});
		
		JButton clientesvip = new JButton("Datos Clientes Vip");
		panel.add(clientesvip);
		clientesvip.setSize(panel.getWidth(),40);
		clientesvip.setLocation(0,160);
		clientesvip.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					String s = cadena.datosClientesVip();
					if(s!=null)
						JOptionPane.showMessageDialog(null, s);
			}
			
		});

		JButton ocupacion = new JButton("Porcentaje de Ocupacion");
		panel.add(ocupacion);
		ocupacion.setSize(panel.getWidth(),40);
		ocupacion.setLocation(0,200);
		ocupacion.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					String s = cadena.porcentajeOcupacionFecha();
					JOptionPane.showMessageDialog(null, s);
			}
			
		});

		JButton paisMasTuristas = new JButton("País Más Turista");
		panel.add(paisMasTuristas);
		paisMasTuristas.setSize(panel.getWidth(),40);
		paisMasTuristas.setLocation(0,240);
		paisMasTuristas.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					String s = cadena.paisMasTuristas();
					JOptionPane.showMessageDialog(null, s);
			}
			
		});
		
		JButton cantidadDineroPagoEmpleados = new JButton("Pago a Empleados");
		panel.add(cantidadDineroPagoEmpleados);
		cantidadDineroPagoEmpleados.setSize(panel.getWidth(),40);
		cantidadDineroPagoEmpleados.setLocation(0,280);
		cantidadDineroPagoEmpleados.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					String s = cadena.cantidadDineroPagoEmpleados();
					JOptionPane.showMessageDialog(null, s);
			}
			
		});
		JButton nuevoSocio = new JButton("Nuevo Socio");
		panel.add(nuevoSocio);
		nuevoSocio.setSize(panel.getWidth(),40);
		nuevoSocio.setLocation(0,320);
		nuevoSocio.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					cadena.nuevoSocio();
			}
			
		});
		repaint();
	}
	
	public Interfaz(){
		cadena = new Cadena();
		setSize(250,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciar();
		setVisible(true);
	}
	
}
