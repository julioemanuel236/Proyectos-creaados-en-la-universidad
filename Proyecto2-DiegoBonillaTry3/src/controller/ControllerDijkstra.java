package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bussines.LogicList;
import bussines.Utils;
import doMain.Person;
import presentation.GuiDijkstra;

public class ControllerDijkstra implements ActionListener {

	private GuiDijkstra guiD;
	private LogicList log;
	
	
	public ControllerDijkstra() {
		
		guiD = new GuiDijkstra();
		log = new LogicList();
		guiD.addUsersOrigen(Utils.grafo);
		guiD.addUsersDestino(Utils.grafo);
		
		addAction();
	}
	
	
	public void addAction() {
		guiD.getBtnBuscar().addActionListener(this);
		guiD.getBtnBack().addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == guiD.getBtnBuscar()) {
			
			log.numeroPersonas(Utils.grafo);
									
			String res = log.dijkstraPrueba(Utils.grafo, (Person)(guiD.getComboBoxOrigen().getSelectedItem()), (Person)( guiD.getComboBoxDestino().getSelectedItem() ));
			
			guiD.getTextAreaShow().setText(res);
			
		} if(e.getSource() == guiD.getBtnBack()) {
			
			new ControllerPrincipal();
			guiD.dispose();
		}
								
	}
	
	
	
	

}
