package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import bussines.LogicList;
import bussines.Utils;
import data.FileXML;
import doMain.ListMsg;
import doMain.Person;
import presentation.GuiAddPerson;

public class ControllerAddPerson implements ActionListener {
	private GuiAddPerson guiA;

	public ControllerAddPerson() {
		guiA = new GuiAddPerson();
		addAction();
	}

	public void addAction() {
		guiA.getBtnAdd().addActionListener(this);
		guiA.getBtnBack().addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == guiA.getBtnAdd()) {
			Person person = new Person();

			String dateBornDay = guiA.getTFDateBorn().getText();
			LocalDate dateBorn = LocalDate.parse(dateBornDay, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

			person.setName(guiA.getTFName().getText());
			person.setLastName(guiA.getTFLastName().getText());

			person.setiD(Integer.parseInt(guiA.getTFId().getText()));
			person.setDateBorn(dateBorn);
			person.setDistrict(guiA.getTFDistrict().getText());

			if (guiA.getRdbtnMen().isSelected()) {
				person.setGender(true);

			} else if (guiA.getRdbtnFemenino().isSelected()) {
				person.setGender(false);

			}

			// Verificar si la c�dula ya existe en el grafo
			if (!LogicList.existeCedula(person.getiD(), Utils.grafo)) {

				FileXML.writeXML("XML/Person.xml", person);
				JOptionPane.showMessageDialog(null, "Se agrego una nueva persona en el XML");
				
			} else {

				JOptionPane.showMessageDialog(null, "La persona con esta c�dula ya existe.", "Error",
						JOptionPane.ERROR_MESSAGE);

			}

		}
		if (e.getSource() == guiA.getBtnBack()) {
			new ControllerPrincipal();
			guiA.dispose();
		}

	}

}
