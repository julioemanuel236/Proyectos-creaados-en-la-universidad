package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bussines.Utils;
import doMain.Grafo;
import doMain.Person;
import nodos.NodoGraf;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiDijkstra extends JFrame {

	private JPanel contentPane;
	private JComboBox<Person> comboBoxOrigen;
	private JComboBox<Person> comboBoxDestino;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTextArea textAreaShow;
	private JButton btnBack;

	public GuiDijkstra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getComboBoxOrigen());
		contentPane.add(getComboBoxDestino());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getBtnBuscar());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnBack());
		setVisible(true);
	}

	public JComboBox<Person> getComboBoxOrigen() {
		if (comboBoxOrigen == null) {
			comboBoxOrigen = new JComboBox<Person>();
			comboBoxOrigen.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					recargarUsuariosDestion(Utils.grafo);
				}
				
			});
			comboBoxOrigen.setBounds(10, 74, 145, 22);
		}
		return comboBoxOrigen;
	}

	public void addUsersOrigen(Grafo grafo) {
		NodoGraf temp = grafo.getPrimero();

		while (temp != null) {
			comboBoxOrigen.addItem(temp.getPerson());
			temp = temp.getSigNodo();
		}

	}

	public void recargarUsuariosDestion(Grafo grafo) {
		comboBoxDestino.removeAllItems();
		addUsersDestino(grafo);
	}
	
	public JComboBox<Person> getComboBoxDestino() {
		if (comboBoxDestino == null) {
			comboBoxDestino = new JComboBox<Person>();
			comboBoxDestino.setBounds(165, 74, 145, 22);
		}
		return comboBoxDestino;
	}

	public void addUsersDestino(Grafo grafo) {
		NodoGraf temp = grafo.getPrimero();

		while (temp != null) {
			if(temp.getPerson()!= comboBoxOrigen.getSelectedItem())
				comboBoxDestino.addItem(temp.getPerson());
			temp = temp.getSigNodo();
		}

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Recorrido mas corto:");
			lblNewLabel.setBounds(10, 11, 145, 38);
		}
		return lblNewLabel;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Origen:");
			lblNewLabel_1.setBounds(10, 60, 145, 14);
		}
		return lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Destino:");
			lblNewLabel_2.setBounds(165, 60, 145, 14);
		}
		return lblNewLabel_2;
	}

	public JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(320, 74, 89, 23);
		}
		return btnBuscar;
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(27, 126, 430, 323);
			scrollPane.setViewportView(getTextAreaShow());
		}
		return scrollPane;
	}

	public JTextArea getTextAreaShow() {
		if (textAreaShow == null) {
			textAreaShow = new JTextArea();
		}
		return textAreaShow;
	}

	public JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Atras");
			btnBack.setBounds(10, 536, 89, 23);
		}
		return btnBack;
	}
}
