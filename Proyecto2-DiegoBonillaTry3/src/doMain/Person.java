package doMain;

import java.time.LocalDate;

import bussines.LogicList;

public class Person {
	
	LogicList logL;
	private String name;
	private String lastName;
	private int iD;
	private LocalDate dateBorn;
	private String district;
	private boolean gender;

	private ListMsg listM;



	public Person() {
		this.listM= new ListMsg();
	}

	public Person(String name, int id) {
		this.name = name;
		this.iD = id;
		this.listM= new ListMsg();
	}

	public Person(String name, String lastName, int iD, LocalDate dateBorn,
		String district, boolean gender) {
		this.name = name;
		this.lastName = lastName;
		this.iD = iD;
		this.dateBorn = dateBorn;
		this.district = district;
		this.gender = gender;
		this.listM= new ListMsg();
	}


	public ListMsg getListM() {
		return listM;
	}

	public void setListM(ListMsg listM) {
		this.listM = listM;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public LocalDate getDateBorn() {
		return dateBorn;
	}
	public void setDateBorn(LocalDate dateBorn) {
		this.dateBorn = dateBorn;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}


	public String dataString() {
		String genderTxt = " ";
		if(isGender()) {

			genderTxt = "Masculino";

		}else {
			genderTxt = "Femenino";
		}

		return "Persona \nNombre: " + name + "\nApellido: " + lastName + "\nIdentificacion: " + iD + "\nFecha de nacimiento: " + dateBorn
				+ "\nDistrito que vive: " + district + "\nGenero: " + genderTxt + "\n"+ LogicList.showList(listM);
	}

	
	public String toString() {
		return name;
	}






}
