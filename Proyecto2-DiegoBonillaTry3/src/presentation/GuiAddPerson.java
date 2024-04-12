package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class GuiAddPerson extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tFName;
	private JLabel lblNewLabel_2;
	private JTextField tFLastName;
	private JLabel lblNewLabel_3;
	private JTextField tFId;
	private JLabel lblNewLabel_4;
	private JTextField tFDateBorn;
	private JLabel lblNewLabel_5;
	private JTextField tFDistrict;
	private JLabel lblNewLabel_6;
	private JRadioButton rdbtnMen;
	private JRadioButton rdbtnFemenino;
	private JButton btnAdd;
	private JButton btnBack;

	public GuiAddPerson() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTFName());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTFLastName());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getTFId());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getTFDateBorn());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getTFDistrict());
		contentPane.add(getLblNewLabel_6());
		contentPane.add(getRdbtnMen());
		contentPane.add(getRdbtnFemenino());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnBack());
		setVisible(true);
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("A\u00F1adir persona");
			lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
			lblNewLabel.setBounds(203, 11, 150, 39);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(118, 67, 112, 27);
		}
		return lblNewLabel_1;
	}
	public JTextField getTFName() {
		if (tFName == null) {
			tFName = new JTextField();
			tFName.setBounds(203, 73, 189, 20);
			tFName.setColumns(10);
		}
		return tFName;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Apellido:");
			lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(106, 126, 92, 27);
		}
		return lblNewLabel_2;
	}
	public JTextField getTFLastName() {
		if (tFLastName == null) {
			tFLastName = new JTextField();
			tFLastName.setBounds(203, 132, 189, 20);
			tFLastName.setColumns(10);
		}
		return tFLastName;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Identificacion:");
			lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(70, 180, 128, 14);
		}
		return lblNewLabel_3;
	}
	public JTextField getTFId() {
		if (tFId == null) {
			tFId = new JTextField();
			tFId.setBounds(203, 180, 189, 20);
			tFId.setColumns(10);
		}
		return tFId;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Fecha de nacimiento:");
			lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_4.setBounds(41, 239, 157, 14);
		}
		return lblNewLabel_4;
	}
	public JTextField getTFDateBorn() {
		if (tFDateBorn == null) {
			tFDateBorn = new JTextField();
			tFDateBorn.setBounds(203, 239, 189, 20);
			tFDateBorn.setColumns(10);
		}
		return tFDateBorn;
	}
	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Distrito:");
			lblNewLabel_5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_5.setBounds(127, 288, 71, 14);
		}
		return lblNewLabel_5;
	}
	public JTextField getTFDistrict() {
		if (tFDistrict == null) {
			tFDistrict = new JTextField();
			tFDistrict.setBounds(203, 288, 189, 20);
			tFDistrict.setColumns(10);
		}
		return tFDistrict;
	}
	public JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Genero:");
			lblNewLabel_6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_6.setBounds(120, 333, 78, 14);
		}
		return lblNewLabel_6;
	}
	public JRadioButton getRdbtnMen() {
		if (rdbtnMen == null) {
			rdbtnMen = new JRadioButton("Masculino");
			rdbtnMen.setBounds(203, 332, 109, 23);
		}
		return rdbtnMen;
	}
	public JRadioButton getRdbtnFemenino() {
		if (rdbtnFemenino == null) {
			rdbtnFemenino = new JRadioButton("Femenino");
			rdbtnFemenino.setBounds(314, 332, 109, 23);
		}
		return rdbtnFemenino;
	}
	public JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("A\u00F1adir");
			btnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			btnAdd.setBounds(212, 378, 165, 39);
		}
		return btnAdd;
	}
	public JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Atras");
			btnBack.setBounds(10, 502, 89, 23);
		}
		return btnBack;
	}
}
