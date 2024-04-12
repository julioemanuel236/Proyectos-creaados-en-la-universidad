package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bussines.LogicList;
import bussines.Utils;
import data.FileXML;
import doMain.ListMsg;
import doMain.Person;
import nodos.NodoGraf;
import nodos.NodoMsg;
import presentation.GuiListPerson;

public class ControllerListPerson implements ActionListener {

	private GuiListPerson guiL;
	private LogicList log;

	public ControllerListPerson() {
		guiL = new GuiListPerson();
		log = new LogicList();
		guiL.addUsers(Utils.grafo);
		addAction();

	}

	public void addAction() {

		guiL.getBtnSelectUser().addActionListener(this);
		guiL.getBtnFollowBack().addActionListener(this);
		guiL.getBtnAddMessage().addActionListener(this);
		guiL.getBtnReaction().addActionListener(this);
		guiL.getBtnSuggestions().addActionListener(this);
		guiL.getBtnBack().addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == guiL.getBtnSelectUser()) {

			guiL.getComboBoxSuggestions().removeAllItems();
			guiL.getComboBoxFollow().removeAllItems();
			guiL.getComboBoxFollowBack().removeAllItems();
			guiL.getComboBoxPublication().removeAllItems();
			guiL.setAuxNamesUser("");
			guiL.addFollowers(Utils.grafo, (String) guiL.getComboBoxUsers().getSelectedItem());
			guiL.getFollowBack(Utils.grafo, (String) guiL.getComboBoxUsers().getSelectedItem());

		}

		if (e.getSource() == guiL.getBtnFollowBack()) {
			guiL.getComboBoxSuggestions().removeAllItems();
			guiL.getComboBoxPublication().removeAllItems();
			guiL.setAuxNamesFollower("");

			guiL.addMessage(Utils.grafo, (String) guiL.getComboBoxFollowBack().getSelectedItem(),
					(String) guiL.getComboBoxUsers().getSelectedItem());
			guiL.getSuggestion((String) guiL.getComboBoxFollowBack().getSelectedItem());

		}

		if (e.getSource() == guiL.getBtnAddMessage()) {
			
			String selectedPersonName = (String) guiL.getComboBoxUsers().getSelectedItem();
			
			if (selectedPersonName != null) {
				
				NodoGraf temp = Utils.grafo.getPrimero();
				
				while (temp != null) {
					
					Person person = temp.getPerson();
					
					if (person.getName().equals(selectedPersonName)) {
						
						String comentario = guiL.getTextAreaAddM().getText(); 
						LogicList.insertarMens(person.getListM(), comentario);
						JOptionPane.showMessageDialog(null, "Se guardo mensaje en "+ guiL.getComboBoxUsers().getSelectedItem());
					}
					
					temp = temp.getSigNodo();
				}
				
			} else {
				
				System.out.println("No se ha seleccionado ninguna persona.");
			}
			
			guiL.getTextAreaAddM().setText(" ");									

		}

		if (e.getSource() == guiL.getBtnReaction()) {

			log.reaction((String) guiL.getComboBoxUsers().getSelectedItem(),
					(String) guiL.getComboBoxPublication().getSelectedItem(),
					(String) guiL.getComboBoxFollowBack().getSelectedItem());

			guiL.getComboBoxPublication().addItem((String) guiL.getComboBoxPublication().getSelectedItem() + " ♥️ ");
			guiL.getComboBoxPublication().removeItem((String) guiL.getComboBoxPublication().getSelectedItem());

		}

		if (e.getSource() == guiL.getBtnSuggestions()) {

			guiL.getComboBoxFollowBack().addItem(guiL.getComboBoxSuggestions().getSelectedItem());
			log.añadirSugerencia((String) guiL.getComboBoxSuggestions().getSelectedItem(),
					(String) guiL.getComboBoxUsers().getSelectedItem());
			guiL.getComboBoxSuggestions().removeItem(guiL.getComboBoxSuggestions().getSelectedItem());

		}

		if (e.getSource() == guiL.getBtnBack()) {
			new ControllerPrincipal();
			guiL.dispose();
		}

	}

}
