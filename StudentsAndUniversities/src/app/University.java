package app;

import java.util.Arrays;

public class University {

	private String universityName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private float inStateTuitionpercredit[];		
	private float outofStateTuitionpercredit[];		
	private float lateFees;
	private float incidentalFees;
	private float incidentalFeeMax;
	private float optionalHealthCare[];		
	private float onCampusMealPlan[];
				
	public University(String universityName, String streetAddress, String city, String state, String zip,
			String phoneNumber, float[] inStateTuitionpercredit, float[] outofStateTuitionpercredit, float lateFees,
			float incidentalFees, float incidentalFeeMax, float[] optionalHealthCare, float[] onCampusMealPlan) {
		super();
		this.universityName = universityName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.inStateTuitionpercredit = inStateTuitionpercredit;
		this.outofStateTuitionpercredit = outofStateTuitionpercredit;
		this.lateFees = lateFees;
		this.incidentalFees = incidentalFees;
		this.incidentalFeeMax = incidentalFeeMax;
		this.optionalHealthCare = optionalHealthCare;
		this.onCampusMealPlan = onCampusMealPlan;
	}

	public boolean equals(University u) {
		return universityName.equals(u.universityName)&&
		streetAddress.equals(u.streetAddress)&&city.equals(u.city)&&
		state.equals(u.state);
	}
	
	public int compareTo(University u) {
		return universityName.compareToIgnoreCase(u.universityName);
	}
	
	public String toString() {
		return universityName + " " + streetAddress + " " + city
				 + " " + state  + " " + zip + " " + phoneNumber  + " " 
				+ Arrays.toString(inStateTuitionpercredit)  + " " 
				+ Arrays.toString(outofStateTuitionpercredit)  + " " 
				+ incidentalFees  + " "  + Arrays.toString(optionalHealthCare) + " " 
				+ Arrays.toString(onCampusMealPlan);
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
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
	
	public float[] getInStateTuitionpercredit() {
		return inStateTuitionpercredit;
	}
	
	public void setInStateTuitionpercredit(float[] inStateTuitionpercredit) {
		this.inStateTuitionpercredit = inStateTuitionpercredit;
	}
	
	public float[] getOutofStateTuitionpercredit() {
		return outofStateTuitionpercredit;
	}
	
	public void setOutofStateTuitionpercredit(float[] outofStateTuitionpercredit) {
		this.outofStateTuitionpercredit = outofStateTuitionpercredit;
	}
	
	public float getLateFees() {
		return lateFees;
	}
	
	public void setLateFees(float lateFees) {
		this.lateFees = lateFees;
	}
	
	public float getIncidentalFees() {
		return incidentalFees;
	}
	
	public void setIncidentalFees(float incidentalFees) {
		this.incidentalFees = incidentalFees;
	}
	
	public float[] getOptionalHealthCare() {
		return optionalHealthCare;
	}
	
	public void setOptionalHealthCare(float[] optionalHealthCare) {
		this.optionalHealthCare = optionalHealthCare;
	}
	
	public float[] getOnCampusMealPlan() {
		return onCampusMealPlan;
	}
	
	public void setOnCampusMealPlan(float[] onCampusMealPlan) {
		this.onCampusMealPlan = onCampusMealPlan;
	}

	public float getIncidentalFeeMax() {
		return incidentalFeeMax;
	}

	public void setIncidentalFeeMax(float incidentalFeeMax) {
		this.incidentalFeeMax = incidentalFeeMax;
	}				
		
}
