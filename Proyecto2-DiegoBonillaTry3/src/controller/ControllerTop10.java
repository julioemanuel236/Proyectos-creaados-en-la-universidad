package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bussines.LogicList;
import bussines.Utils;
import doMain.ListaAdyacente;
import nodos.NodoGraf;
import presentation.GuiTop;

public class ControllerTop10 implements ActionListener {
	private GuiTop guiT;
	private ListaAdyacente listA;
	private LogicList logL;
	
	public ControllerTop10() {
		guiT = new GuiTop();
		addAction();
	}
	
	public void addAction() {
		guiT.getBtnShow().addActionListener(this);
		guiT.getBtnBack().addActionListener(this);
		
	}
	
	

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == guiT.getBtnShow()) {
			
			logL.insertarSumaReaccionesEnTop10(Utils.grafo, Utils.listTop10);
			LogicList.organiceList(Utils.listTop10);
			
			guiT.getTextAreaList().setText(logL.showListTop1(Utils.listTop10));
			
		} if(e.getSource() == guiT.getBtnBack()) {
			new ControllerPrincipal();
			guiT.dispose();
		}
            
          	
			
		}
		
	
	
	
}

