package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GuiPrincipal;

public class ControllerPrincipal implements ActionListener {
	private GuiPrincipal guiP;

	public ControllerPrincipal() {
		guiP = new GuiPrincipal();
		addAction();
	}

	public void addAction() {
		guiP.getBtnSocial().addActionListener(this);
		guiP.getBtnAdd().addActionListener(this);
		guiP.getBtnTop().addActionListener(this);
		guiP.getBtnDistrak().addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == guiP.getBtnSocial()) {
			new ControllerListPerson();
			guiP.dispose();

		}
		if (e.getSource() == guiP.getBtnAdd()) {
			new ControllerAddPerson();
			guiP.dispose();

		}
		if (e.getSource() == guiP.getBtnTop()) {
			new ControllerTop10();
			guiP.dispose();

		}
		if (e.getSource() == guiP.getBtnDistrak()) {
			new ControllerDijkstra();
			guiP.dispose();

		}
		
		

	}

}
