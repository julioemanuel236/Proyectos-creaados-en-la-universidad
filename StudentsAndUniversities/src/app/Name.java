package app;

public class Name {
	private final String firsName;
	private final String middleName;
	private final String lastName;
			
	public Name(String firsName, String middleName, String lastName) {
		super();
		this.firsName = firsName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	public String getFirsName() {
		return firsName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
		
	public boolean equals(Name n) {
		return this.firsName.equals(n.firsName)&&
			   this.middleName.equals(n.middleName)&&
			   this.lastName.equals(n.lastName);
	}
	
	
	
	public String toString() {
		return firsName+" "+middleName+" "+lastName;
	}
	
	public int compareTo(Name n) {
		return (lastName+firsName+middleName).compareToIgnoreCase(n.lastName+n.firsName+n.lastName);
	}
	
}