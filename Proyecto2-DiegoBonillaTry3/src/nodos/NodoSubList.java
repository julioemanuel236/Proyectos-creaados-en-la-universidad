package nodos;

import doMain.Person;

public class NodoSubList {
	
	private Person person;
	private int distance;
	private NodoSubList sigNodo;
	
	public NodoSubList(Person person) {
		this.person= person;
	}
	
	public NodoSubList(Person person, int distance) {
	
		this.person= person;
		this.distance=distance;
		this.sigNodo= null;
		
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public NodoSubList getSigNodo() {
		return sigNodo;
	}

	public void setSigNodo(NodoSubList sigNodo) {
		this.sigNodo = sigNodo;
	}

	@Override
	public String toString() {
		return "\n"+ person + "\nDistancia---> " + distance +"\n"+ "\nsiguiente persona: " + sigNodo+"\n";
	}
	
	
	
	

}
