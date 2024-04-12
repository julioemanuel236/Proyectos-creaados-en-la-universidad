package app;

public class Person {
	final private Name name;
	
	private int age;
	final private String gender;
	private String streetAddress;
	private String city;		
	private String state;		
	private String zip;			
	private String phoneNumber;
		
	public Person(Name name, int age, String gender, String streetAddress, String city, String state, String zip,
			String phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}

	public boolean equals(Person p) {
		return name.equals(p.name)&&age==p.age&&
				gender.equals(p.gender)&&
				streetAddress.equals(p.streetAddress)&&
				city.equals(p.city)&&
				state.equals(p.state)&&
				zip.equals(p.zip);
	}

	public int compareTo(Person p) {
		int nameOrder = name.compareTo(p.name);
		if(nameOrder==0) {
			if(age<p.age)return -1;
			else if(age>p.age)return 1;
			else {
				if(gender.equals("F")&&p.gender.equals("M"))return -1;
				else if(gender.equals("M")&&p.gender.equals("F"))return 1;
				else return 0;
			}
		}
		else return nameOrder;
	}
	
	public String toString() {
		return name.toString() + " " + age + " " + gender + " " + streetAddress + " " + city + " " + state + " " + zip + " " + phoneNumber;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Name getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
}