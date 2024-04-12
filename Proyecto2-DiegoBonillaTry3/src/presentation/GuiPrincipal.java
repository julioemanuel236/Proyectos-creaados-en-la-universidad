package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

public class GuiPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnSocial;
	private JButton btnAdd;
	private JButton btnTop;
	private JButton btnDistrak;

	public GuiPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnSocial());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnTop());
		contentPane.add(getBtnDistrak());
		setVisible(true);
	}

	public JButton getBtnSocial() {
		if (btnSocial == null) {
			btnSocial = new JButton("Administracion de red social");
			btnSocial.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			btnSocial.setBounds(292, 44, 242, 61);
		}
		return btnSocial;
	}
	public JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Agregar nueva persona");
			btnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			btnAdd.setBounds(292, 116, 242, 61);
		}
		return btnAdd;
	}
	public JButton getBtnTop() {
		if (btnTop == null) {
			btnTop = new JButton("Top 10");
			btnTop.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			btnTop.setBounds(292, 188, 242, 61);
		}
		return btnTop;
	}
	public JButton getBtnDistrak() {
		if (btnDistrak == null) {
			btnDistrak = new JButton("Dijkstra");
			btnDistrak.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			btnDistrak.setBounds(292, 260, 242, 61);
		}
		return btnDistrak;
	}
}
