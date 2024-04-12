package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bussines.Utils;
import doMain.Grafo;
import doMain.ListMsg;
import doMain.ListReaction;
import nodos.NodoGraf;
import nodos.NodoMsg;
import nodos.NodoReaction;
import nodos.NodoSubList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiListPerson extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox comboBoxUsers;
	private JLabel lblNewLabel_1;
	private JButton btnSelectUser;
	private JComboBox comboBoxFollow;
	private JLabel lblNewLabel_2;
	private JComboBox comboBoxFollowBack;
	private JButton btnFollowBack;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JComboBox comboBoxSuggestions;
	private JButton btnSuggestions;
	private JButton btnFollows;
	private JLabel lblNewLabel_3;
	private JButton btnReaction;
	private String auxNamesUser;
	private String auxNamesFollower;
	private JScrollPane scrollPane_1;
	private JTextArea textAreaAddM;
	private JButton btnAddMessage;
	private JButton btnBack;
	private JComboBox comboBoxPublication;

	public GuiListPerson() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getComboBoxUsers());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnSelectUser());
		contentPane.add(getComboBoxFollow());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getComboBoxFollowBack());
		contentPane.add(getBtnFollowBack());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2_2());
		contentPane.add(getComboBoxSuggestions());
		contentPane.add(getBtnSuggestions());
		contentPane.add(getBtnFollows());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getBtnReaction());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnBack());
		contentPane.add(getComboBoxPublication());
		setVisible(true);
	}

	// Setters y Getters para editar las variables
	public String getAuxNamesUser() {
		return auxNamesUser;
	}

	public void setAuxNamesUser(String auxNamesUser) {
		this.auxNamesUser = auxNamesUser;
	}

	public String getAuxNamesFollower() {
		return auxNamesFollower;
	}

	public void setAuxNamesFollower(String auxNamesFollower) {
		this.auxNamesFollower = auxNamesFollower;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Administracion de la Red Social");
			lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
			lblNewLabel.setBounds(168, 11, 292, 39);
		}
		return lblNewLabel;
	}

	public JComboBox getComboBoxUsers() {
		if (comboBoxUsers == null) {
			comboBoxUsers = new JComboBox();
			comboBoxUsers.setBounds(10, 78, 239, 21);
		}
		return comboBoxUsers;
	}

	// Metodo que aï¿½ade los usuarios al primer comboBox, al combObOX donde estan
	// solo los del grafo
	public void addUsers(Grafo grafo) {
		NodoGraf temp = grafo.getPrimero();

		while (temp != null) {
			comboBoxUsers.addItem(temp.getPerson().getName());
			temp = temp.getSigNodo();
		}

	}  

	public JComboBox getComboBoxFollow() {
		if (comboBoxFollow == null) {
			comboBoxFollow = new JComboBox();
			comboBoxFollow.setBounds(10, 143, 239, 22);
		}
		return comboBoxFollow;
	}

	// Mï¿½todo para agregar los seguidores de la persona seleccionada.
	public void addFollowers(Grafo grafo, String name) {
		// Obtiene el primer nodo del grafo.
		NodoGraf temp1 = grafo.getPrimero();

		// Itera a travï¿½s de todos los nodos del grafo.
		while (temp1 != null) {
			// Comprueba si el nombre del nodo actual coincide con el nombre pasado como
			// parï¿½metro.
			if (temp1.getPerson().getName().equalsIgnoreCase(name)) {
				// Obtiene el primer nodo de la sublista del nodo actual del grafo.
				NodoSubList temp2 = temp1.getSubList().getPrimero();

				// Itera a travï¿½s de todos los nodos de la sublista.
				while (temp2 != null) {
					// Agrega el nombre de la persona del nodo actual de la sublista al
					// comboBoxFollow.
					comboBoxFollow.addItem(temp2.getPerson().getName());
					// Avanza al siguiente nodo en la sublista.
					temp2 = temp2.getSigNodo();
				}
			}

			// Avanza al siguiente nodo en el grafo.
			temp1 = temp1.getSigNodo();
		}
	}

	// Metodo para añadir los publicaciones/comentarios de un random al combobox
	public void addMessage(Grafo grafo, String name, String user) {
		
		NodoGraf temp1 = grafo.getPrimero();


		while (temp1 != null) {

			if (temp1.getPerson().getName().equalsIgnoreCase(name)) {
				
				NodoMsg temp2 = temp1.getPerson().getListM().getPrimero(); 

				while (temp2 != null) {
				
					if(validationReac(temp2.getListR(), user)) {
						
						comboBoxPublication.addItem(temp2.getMessage()+"[♥️]");
						
					}else {
						
						comboBoxPublication.addItem(temp2.getMessage());
					}
									
					temp2 = temp2.getSigNodo();
				}
			}

			temp1 = temp1.getSigNodo();
		}
	}

	//Metodo para verificar las personas que han reaccionado al mensaje. [Validacion]
	public boolean validationReac(ListReaction listReac, String user) {
		
		boolean result = false;
		
		NodoReaction reactions = listReac.getFirst();
		
		
		while(reactions != null) {
			
			if(reactions.getUser().getName().equalsIgnoreCase(user)) {
				
				result = true;
				
			}
			
			reactions = reactions.getNextNod();
		}
		
		
		return result; 
	}
	
	// Mï¿½todo para obtener las personas que sigue la persona seleccionada.
	public void getFollowBack(Grafo grafo, String name) {
		// Obtiene el primer nodo del grafo.
		NodoGraf temp1 = grafo.getPrimero();

		// Itera a travï¿½s de todos los nodos del grafo.
		while (temp1 != null) {
			// Obtiene el primer nodo de la sublista del nodo actual del grafo.
			NodoSubList temp2 = temp1.getSubList().getPrimero();

			// Itera a travï¿½s de todos los nodos de la sublista.
			while (temp2 != null) {
				// Comprueba si el nombre de la persona en el nodo actual de la sublista
				// coincide con el nombre pasado como parï¿½metro.
				if (temp2.getPerson().getName().equalsIgnoreCase(name)) {
					// Agrega el nombre de la persona del nodo actual del grafo al
					// comboBoxFollowBack.
					comboBoxFollowBack.addItem(temp1.getPerson().getName());
					auxNamesUser += temp1.getPerson().getName();
					auxNamesUser += " ";
				}

				// Avanza al siguiente nodo en la sublista.
				temp2 = temp2.getSigNodo();
			}

			// Avanza al siguiente nodo en el grafo.
			temp1 = temp1.getSigNodo();
		}

		// Validacion para que no se recomiende a si misma
		auxNamesUser += name;
	}

	// Mï¿½todo para obtener las personas que sigue el mae seleccionado.
	public void getFollowBack2(Grafo grafo, String name) {
		// Obtiene el primer nodo del grafo.
		NodoGraf temp1 = grafo.getPrimero();
		// Itera a travï¿½s de todos los nodos del grafo.
		while (temp1 != null) {
			// Obtiene el primer nodo de la sublista del nodo actual del grafo.
			NodoSubList temp2 = temp1.getSubList().getPrimero();
			// Itera a travï¿½s de todos los nodos de la sublista.
			while (temp2 != null) {
				// Comprueba si el nombre de la persona en el nodo actual de la sublista
				// coincide con el nombre pasado como parï¿½metro.
				if (temp2.getPerson().getName().equalsIgnoreCase(name)) {
					// Si hay coincidencia, agrega el nombre del nodo actual del grafo a
					// auxNamesFollower.
					auxNamesFollower += temp1.getPerson().getName();
					auxNamesFollower += " ";
				}
				// Avanza al siguiente nodo en la sublista.
				temp2 = temp2.getSigNodo();
			}
			// Avanza al siguiente nodo en el grafo.
			temp1 = temp1.getSigNodo();
		}
	}

	// Mï¿½todo para obtener las sugerencias.
	public void getSuggestion(String follower) {

		// Llama al mï¿½todo getFollowBack2 para obtener los nombres de usuarios que sigue
		// El seguidor pasado como parï¿½metro.
		getFollowBack2(Utils.grafo, follower);

		// Divide las cadenas de nombres de usuario en el seguidor actual y en los
		// nombres de usuario seguidos por ï¿½l en arrays separados.
		String[] nombres1 = auxNamesUser.split("\\s+");
		String[] nombres2 = auxNamesFollower.split("\\s+");

		// Itera sobre los nombres de usuario seguidos por el seguidor actual.
		for (String nombre : nombres2) {
			// Comprueba si el nombre actual no estï¿½ en la lista de nombres de usuario del
			// usuario actual.
			if (!contieneNombre(nombres1, nombre)) {
				// Si no estï¿½ en la lista de nombres de usuario del usuario actual, lo aï¿½ade
				// como sugerencia en el comboBox.
				comboBoxSuggestions.addItem(nombre);
			}
		}
	}

	// Este mï¿½todo comprueba si un array de nombres contiene un nombre especï¿½fico.
	public static boolean contieneNombre(String[] nombres, String nombre) {
		// Itera a travï¿½s de cada elemento del array de nombres.
		for (String n : nombres) {
			// Comprueba si el nombre actual (ignorando mayï¿½sculas/minï¿½sculas) coincide con
			// el nombre buscado.
			if (n.equalsIgnoreCase(nombre)) {
				// Si hay una coincidencia, devuelve true.
				return true;
			}
		}
		// Si no se encontrï¿½ ninguna coincidencia despuï¿½s de recorrer todos los
		// elementos, devuelve false.
		return false;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Usuario:");
			lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(10, 49, 162, 33);
		}
		return lblNewLabel_1;
	}

	public JButton getBtnSelectUser() {
		if (btnSelectUser == null) {
			btnSelectUser = new JButton("Seleccionar");
			btnSelectUser.setBounds(259, 77, 130, 23);
		}
		return btnSelectUser;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Seguidores:");
			lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(10, 117, 197, 26);
		}
		return lblNewLabel_2;
	}

	public JComboBox getComboBoxFollowBack() {
		if (comboBoxFollowBack == null) {
			comboBoxFollowBack = new JComboBox();
			comboBoxFollowBack.setBounds(10, 218, 239, 22);
		}
		return comboBoxFollowBack;
	}

	public JButton getBtnFollowBack() {
		if (btnFollowBack == null) {
			btnFollowBack = new JButton("Seleccionar");
			btnFollowBack.setBounds(259, 218, 130, 23);
		}
		return btnFollowBack;
	}

	public JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("Personas que sigue el usuario:");
			lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_2_1.setBounds(10, 193, 239, 26);
		}
		return lblNewLabel_2_1;
	}

	public JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("Sugerencias:");
			lblNewLabel_2_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_2_2.setBounds(453, 52, 197, 26);
		}
		return lblNewLabel_2_2;
	}

	public JComboBox getComboBoxSuggestions() {
		if (comboBoxSuggestions == null) {
			comboBoxSuggestions = new JComboBox();
			comboBoxSuggestions.setBounds(453, 77, 239, 22);
		}
		return comboBoxSuggestions;
	}

	public JButton getBtnSuggestions() {
		if (btnSuggestions == null) {
			btnSuggestions = new JButton("Seleccionar");
			btnSuggestions.setBounds(520, 106, 130, 23);
		}
		return btnSuggestions;
	}

	public JButton getBtnFollows() {
		if (btnFollows == null) {
			btnFollows = new JButton("Seleccionar");
			btnFollows.setBounds(259, 143, 130, 23);
		}
		return btnFollows;
	}

	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Publicaciones");
			lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(10, 251, 93, 31);
		}
		return lblNewLabel_3;
	}

	public JButton getBtnReaction() {
		if (btnReaction == null) {
			btnReaction = new JButton("Reaccionar");
			btnReaction.setBounds(453, 394, 239, 93);
		}
		return btnReaction;
	}

	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(453, 154, 239, 215);
			scrollPane_1.setViewportView(getTextAreaAddM());
			scrollPane_1.setColumnHeaderView(getBtnAddMessage());
		}
		return scrollPane_1;
	}

	public JTextArea getTextAreaAddM() {
		if (textAreaAddM == null) {
			textAreaAddM = new JTextArea();
		}
		return textAreaAddM;
	}

	public JButton getBtnAddMessage() {
		if (btnAddMessage == null) {
			btnAddMessage = new JButton("Agregar mensaje");
		}
		return btnAddMessage;
	}

	public JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Atras");
			btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			btnBack.setBounds(453, 498, 239, 93);
		}
		return btnBack;
	}

	public JComboBox getComboBoxPublication() {
		if (comboBoxPublication == null) {
			comboBoxPublication = new JComboBox();
			comboBoxPublication.setBounds(10, 279, 379, 22);
		}
		return comboBoxPublication;
	}
}
