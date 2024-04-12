package bussines;


import controller.ControllerPrincipal;
import data.FileXML;
import doMain.ListMsg;
import doMain.Person;

public class Main {
	
	public static void main(String[] args) {
		
		LogicList logL = new LogicList();
		FileXML fileXML = new FileXML();
		
		fileXML.readXML("XML/Person.xml", Utils.grafo);
		
		//System.out.println(logL.showList(Utils.grafo.getPrimero().getPerson().getListM()));
		
		System.out.println(logL.Shwo(Utils.grafo));
			new ControllerPrincipal();
		
		}
	
	

}
