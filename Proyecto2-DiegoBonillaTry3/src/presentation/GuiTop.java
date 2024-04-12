package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class GuiTop extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea textAreaList;
	private JButton btnShow;
	private JButton btnBack;


	public GuiTop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnShow());
		contentPane.add(getBtnBack());
		setVisible(true);
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Top 10 de personas con mas reacciones");
			lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel.setBounds(254, 24, 302, 39);
		}
		return lblNewLabel;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(127, 74, 555, 431);
			scrollPane.setViewportView(getTextAreaList());
		}
		return scrollPane;
	}
	public JTextArea getTextAreaList() {
		if (textAreaList == null) {
			textAreaList = new JTextArea();
		}
		return textAreaList;
	}
	public JButton getBtnShow() {
		if (btnShow == null) {
			btnShow = new JButton("Mostrar");
			btnShow.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			btnShow.setBounds(341, 516, 115, 39);
		}
		return btnShow;
	}
	public JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Atras");
			btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			btnBack.setBounds(21, 539, 106, 32);
		}
		return btnBack;
	}
}
