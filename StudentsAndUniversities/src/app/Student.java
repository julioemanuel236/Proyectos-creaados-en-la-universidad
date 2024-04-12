package app;

public class Student extends Person{
	private String universityName; 
	private final String studentID;		
	private int creditsEnrolled;
	private boolean qualifiesForInstateRate;
	private boolean LateFeeAssessed;
	private char foodOptionChoice;
	private boolean healthOptionChoice;
			
	public Student(Name name, int age, String gender, String streetAddress, String city, String state, String zip,
			String phoneNumber, String UniversityName, String studentID, int creditsEnrolled,
			boolean qualifiesForInstateRate, boolean lateFeeAssessed, char foodOptionChoice,
			boolean healthOptionChoice) {
		super(name, age, gender, streetAddress, city, state, zip, phoneNumber);
		this.universityName = UniversityName;
		this.studentID = studentID;
		this.creditsEnrolled = creditsEnrolled;
		this.qualifiesForInstateRate = qualifiesForInstateRate;
		LateFeeAssessed = lateFeeAssessed;
		this.foodOptionChoice = foodOptionChoice;
		this.healthOptionChoice = healthOptionChoice;
	}

	public String toString() {
		return  super.toString() + " " + universityName + " " + 
				+ creditsEnrolled + " "  + qualifiesForInstateRate + " "  
				+ LateFeeAssessed + " "  + foodOptionChoice + " "  + 
				healthOptionChoice;
	}

	public int compareTo(Student s) {
		int personOrder = super.compareTo(s);
		if(personOrder==0) {
			return studentID.compareTo(s.studentID);
		}
		return personOrder;
	}
	
	public boolean equals(Student s) {
		return getName().equals(s.getName()) && studentID.equals(s.studentID);
	}
	
	public String getUniversityName() {
		return universityName;
	}
	
	public void setUniversityName(String UniversityName) {
		this.universityName = UniversityName;
	}
	
	public int getCreditsEnrolled() {
		return creditsEnrolled;
	}
	
	public void setCreditsEnrolled(int creditsEnrolled) {
		this.creditsEnrolled = creditsEnrolled;
	}
	
	public boolean isQualifiesForInstateRate() {
		return qualifiesForInstateRate;
	}
	
	public void setQualifiesForInstateRate(boolean qualifiesForInstateRate) {
		this.qualifiesForInstateRate = qualifiesForInstateRate;
	}
	
	public boolean isLateFeeAssessed() {
		return LateFeeAssessed;
	}
	
	public void setLateFeeAssessed(boolean lateFeeAssessed) {
		LateFeeAssessed = lateFeeAssessed;
	}
	
	public char getFoodOptionChoice() {
		return foodOptionChoice;
	}

	public void setFoodOptionChoice(char foodOptionChoice) {
		this.foodOptionChoice = foodOptionChoice;
	}
	
	public boolean isHealthOptionChoice() {
		return healthOptionChoice;
	}
	
	public void setHealthOptionChoice(boolean healthOptionChoice) {
		this.healthOptionChoice = healthOptionChoice;
	}
	
	public String getStudentID() {
		return studentID;
	}
		
}
