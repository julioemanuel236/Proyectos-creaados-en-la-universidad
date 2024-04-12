package nodos;

import doMain.ListaAdyacente;
import doMain.Person;

public class NodoGraf {
	private Person person;
	private ListaAdyacente subList;
	private NodoGraf sigNodo;
	
	
	public NodoGraf(Person person) {
		
		this.person=person;
		this.sigNodo=null;
		this.subList=new ListaAdyacente();
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public ListaAdyacente getSubList() {
		return subList;
	}


	public void setSubList(ListaAdyacente subList) {
		this.subList = subList;
	}


	public NodoGraf getSigNodo() {
		return sigNodo;
	}


	public void setSigNodo(NodoGraf sigNodo) {
		this.sigNodo = sigNodo;
	}


	@Override
	public String toString() {
		return "Grafo" +"\n"+ person.dataString() + "\n...Seguidores..."+ subList;
	}
	
	
	
	
	
	 
	

}
