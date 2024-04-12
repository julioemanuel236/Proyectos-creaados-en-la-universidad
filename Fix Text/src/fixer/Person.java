package fixer;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private String city;
	
	public Person(String firstName, String middleName, String lastName, String state) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.city = state;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String state) {
		this.city = state;
	}
	
	public String toStrign() {
		return lastName+","+firstName+","+middleName+","+city;
	}
	
}
