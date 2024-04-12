package nodos;

public class NodoTop10 {
	
	private String name;
	private int reaction;
	
	
	private NodoTop10 sigNodo;
	public NodoTop10() {
		// TODO Auto-generated constructor stub
	}
	
	public NodoTop10(String message, int reaction) {
		this.name = message;
		this.reaction = reaction;
	}
	public NodoTop10(String message) {
		this.name = message;
	}
	public NodoTop10(int reaction) {
		this.reaction = reaction;;
	}
	public NodoTop10(String message, int reaction, boolean confirm) {
		super();
		this.name = message;
		this.reaction = reaction;
		this.sigNodo=null;
	}

	




	public String getMessage() {
		return name;
	}

	public void setMessage(String message) {
		this.name = message;
	}

	public int getReaction() {
		return reaction;
	}

	public void setReaction(int reaction) {
		this.reaction = reaction;
	}



	public NodoTop10 getSigNodo() {
		return sigNodo;
	}

	public void setSigNodo(NodoTop10 sigNodo) {
		this.sigNodo = sigNodo;
	}

	@Override
	public String toString() {
	
		
		return "\nNombre: " + name +"\n"+ "Cantidad de reacciones: "+reaction ;
	}
	 
	
	
	
	
	
}
