package app;

import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {

	String studentsRute = "StudentFile.txt"; //rute to the students file
	String universitysRute = "Universities9.txt";//rute to the unversities file	
	ArrayList<University> universities;
	ArrayList<Student> students;
	
	public App() {		
		//try to do all, its fails print the error
		try {			
			loadStudents();
			loadUniversities();
			makeReport();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String numberFormat(String s)throws Exception {
		String f = "(";
		f+=s.substring(0, 3);
		f+=")";
		f+=s.substring(3,6);
		f+="-";
		f+=s.substring(6, 10);
		return f;
	}
	
	private String fillTo(String s,int n)throws Exception {
		for(;s.length()<n;)s+=" ";		
		return s;
	}
	
	private int getCategory(int credits) {
		if(credits>=1 && credits<12)return 0;
		else if(credits>=12 && credits<18)return 1;
		else if(credits>=18)return 2;
		else return -1;
		
	}
	
	private void makeReport() throws Exception {
		DecimalFormat format = new DecimalFormat("0.00");
		//comparator to sort university lexicographic
		Comparator<University> univer = new Comparator<>() {


			@Override
			public int compare(University u1, University u2) {
				return u1.getUniversityName().compareToIgnoreCase(u2.getUniversityName());		
			}

		};
		//comparator to sort student by the compareTo funtion of its
		Comparator<Student> student = new Comparator<>() {

			@Override
			public int compare(Student u1, Student u2) {
				return u1.compareTo(u2);								
			}

			

		};
		
		//sort both arrays
		Collections.sort(universities,univer);
		Collections.sort(students,student);
		//move throw all the universities one by one
		for(int i=0;i<universities.size();i++) {
			University uni = universities.get(i);//get the university 
			//declare values we need 
			int studentsTotal=0;
			int studentsIn=0;
			int mealP[] = new int[uni.getOnCampusMealPlan().length];
			float totalTuition=0;
			float inTuition[] = uni.getInStateTuitionpercredit();
			float outTuition[] = uni.getInStateTuitionpercredit();
			float healthCare[] = uni.getOptionalHealthCare();
			String report="";//the string that contains all the report
			String line;//in this string we make line by line
			//the university basic info at first
			
			report+="\t\t\t"+uni.getUniversityName()+"\n";
			report+="\t\t\t"+uni.getStreetAddress()+"\n";
			report+="\t\t\t"+uni.getCity()+","+uni.getState()+" "+uni.getZip()+"\n";
			report+="\t\t\t"+numberFormat(uni.getPhoneNumber())+"\n\n";
			//move throw all the students
			for(int j=0; j<students.size();j++) {
				Student stu = students.get(j);	//get the student
			
				if(stu.getUniversityName().equals(uni.getUniversityName())) {//if the university it the same 
					studentsTotal++;//increment the total of students
					float tuition;
					float totalEstudent=0;
					int credits = stu.getCreditsEnrolled();//get credits of student
					
					//price of tuition in case if in or out state
					if(stu.isQualifiesForInstateRate()) {
						studentsIn++;
						tuition = inTuition[getCategory(credits)];
					}
					else tuition = outTuition[getCategory(credits)];
					
					totalTuition+=tuition;//increment totla tuition of school 
					totalEstudent+=tuition;//increment total student tuition
					line= "";
					//Student info					
					line+="NAME";line=fillTo(line,11);
					line+=stu.getName();line=fillTo(line,40);
					
					line+="CREDITS";line=fillTo(line,50);
					line+=stu.getCreditsEnrolled();
					report+=line+"\n";
					
					line="ADRESS";line=fillTo(line,11);
					line+=stu.getStreetAddress()+", "+stu.getCity()+", "+stu.getState()+" "+stu.getZip();
					report+=line+"\n";
					
					line="PHONE";line=fillTo(line,11);
					line+=numberFormat(stu.getPhoneNumber());
					report+=line+"\n";					
					
					line="TUITION";line=fillTo(line,11);
					line+="$ "+(format.format(tuition));
					report+=line+"\n";
					
					float lateFeed = (stu.isLateFeeAssessed()?tuition*uni.getLateFees():0.00f);
					totalEstudent+=lateFeed;
					line="LATE FEE";line=fillTo(line,11);line+="$ "+(format.format(lateFeed));
					totalEstudent+=tuition;
					report+=line+"\n";
					
					totalEstudent+=Math.min(credits*uni.getIncidentalFees(),uni.getIncidentalFeeMax());
					line="INCIDENTAL";line=fillTo(line,11);line+="$ "+(format.format(Math.min(credits*uni.getIncidentalFees(),uni.getIncidentalFeeMax())));
					report+=line+"\n";
					float healthcare = (stu.isHealthOptionChoice()?healthCare[getCategory(credits)]:0.00f);
					totalEstudent+=healthcare;
					line="HEALTH CARE";line=fillTo(line,11);line+="$ "+(format.format(healthcare));
					report+=line+"\n";
					
					float mealplan = uni.getOnCampusMealPlan()[stu.getFoodOptionChoice()-'A'];
					mealP[stu.getFoodOptionChoice()-'A']++;
					totalEstudent+=mealplan;
					line="MEAL PLAN";line=fillTo(line,11);line+="$ "+mealplan;
					line=fillTo(line,40);
					line+="TOTAL";line=fillTo(line,60);
					line+="$ "+totalEstudent;
					
					report+=line+"\n";
															
					report+="\n";
					
				}

				
			}

			//Unverisity total info
			report+="\t\t\t"+uni.getUniversityName()+"\n";
			
			line="NUMBER OF STUDENT";line=fillTo(line,20);line+=studentsTotal+"\n";
			report+=line;
			
			line="INSTATE";line=fillTo(line,20);line+=studentsIn+"\n";
			report+=line;
			
			line="OUTSTATE";line=fillTo(line,20);line+=(studentsTotal-studentsIn)+"\n";
			report+=line;
			
			int ini=17;
			float food;
			float foodSubTotal=0;
			line="MEAL PLAN";line=fillTo(line,ini);line+="3 Meal a day";line=fillTo(line,35);line+=""+mealP[0];
			food = mealP[0]*uni.getOnCampusMealPlan()[0];
			foodSubTotal+=food;
			line=fillTo(line,40);line+="$ "+(format.format(food));
			report+=line+"\n";
			line="";line=fillTo(line,ini);line+="2 Meal a day";line=fillTo(line,35)+mealP[1];
			food = mealP[1]*uni.getOnCampusMealPlan()[1];
			foodSubTotal+=food;
			line=fillTo(line,40);line+="$ "+(format.format(food));
			report+=line+"\n";
			line="";line=fillTo(line,ini);line+="1 Meal a day";line=fillTo(line,35)+mealP[2];
			food = mealP[2]*uni.getOnCampusMealPlan()[2];
			foodSubTotal+=food;
			line=fillTo(line,40);line+="$ "+(format.format(food));			
			report+=line+"\n";
			
			line = "";line = fillTo(line,ini);line+="FOOD SUB TOTAL";line = fillTo(line,40)+"$ "+(format.format(foodSubTotal));
			report+=line;
			report += "\n\n";
			
			line = "TUITION"; line = fillTo(line,ini); line += "$ " + totalTuition;
			report+=line+"\n";
			
			System.out.println(report);
			

		}		
	}
	
	private boolean YN(String s)throws Exception {
		return s.equalsIgnoreCase("Y");// return true if the letter if y or Y, false other case
	}
	
	private void loadUniversities()throws Exception {
		FileReader fr = new FileReader(universitysRute);//file for unversities data read
		Scanner entry = new Scanner(fr);		//scanner for read the file
		int count = Integer.parseInt(entry.nextLine());//how many universities are in there
		universities = new ArrayList<>();//create the array
//		System.out.println(count);
		
		for(int i=0;i<count;i++) {
			String[] dataLine = entry.nextLine().split(",");//splie te readed line by ','
			float inStateTPC[] = new float[3];//array for tuition in State
			float outStateTPC[] = new float[3];//array for tuition out State
			float optionalHC[] = new float[3];//price of the 3 levels of health care
			float campusMP[] = {0,0,0,0};// meals play value , A,B,C,D
			for(int j=0;j<3;j++) {//there are 3 levels of every thing
				inStateTPC[j] = Float.parseFloat(dataLine[6+j]);//in State data start at 6 pos in dataLine array
				outStateTPC[j] = Float.parseFloat(dataLine[9+j]);//out State data start at 9 pos in dataLine array
				campusMP[j] = Float.parseFloat(dataLine[12+j]);//campus meal data start at 12 pos in dataLine array
				optionalHC[j] = Float.parseFloat(dataLine[15+j]);//healt care data start at 15 pos in dataLine array
			}
			//create an university following the constructor
			University uni = new University(
					dataLine[0],dataLine[1],dataLine[2],dataLine[3],dataLine[4],dataLine[5],
					inStateTPC,outStateTPC,
					Float.parseFloat(dataLine[18]),Float.parseFloat(dataLine[19]),Float.parseFloat(dataLine[20]),
					optionalHC,campusMP
					);
			
			boolean ok=true;//check there are no other equal
			for(int j=0;j<universities.size();j++)
				if(universities.get(j).equals(uni)) {//if found other equal
					ok=false;//check false
					break;//break cuz have no sense continue looking for
				}
			if(ok)//if its unique add to array
			universities.add(uni);
			//else System.out.println(uni.getUniversityName());
			//System.out.println(uni.toString());
		}
		entry.close();		
	}
	

	private void loadStudents() throws Exception{	
		FileReader fr = new FileReader(studentsRute);//file of students
		Scanner entry = new Scanner(fr);		//scanner for reading
		int count = Integer.parseInt(entry.nextLine());//first line, how many student are in there
		
//		System.out.println(count);
		
		students = new ArrayList<>();//create the array
		for(int i=0;i<count;i++) {
			String line =entry.nextLine();
			//System.out.println(line);
			String[] dataLine = line.split(",");//read the line and split it by ','
			Student est = new Student(
					new Name(dataLine[0],dataLine[1],dataLine[2]),//create the name whit the first 3 values
					Integer.parseInt(dataLine[3]),dataLine[4],//put the rest of thing guide by Students constructor
					dataLine[5],dataLine[6],dataLine[7],dataLine[8],
					dataLine[9],
					dataLine[10],dataLine[11],Integer.parseInt(dataLine[12]),
					YN(dataLine[13]),YN(dataLine[14]),dataLine[15].charAt(0),YN(dataLine[16]));
			
			boolean ok=true;//this is to check there are no other students considerated equal
			for(int j=0;j<students.size();j++)
				if(students.get(j).equals(est)) {//if they are equals
					ok=false;//check false
					break;//break, have no sense continue looking for
				}
			if(ok)//if no problem add to array
			students.add(est);
			//else System.out.println(est.getName());
			//System.out.println(est.toString());
		}
		entry.close();
	}
	
	public static void main(String[] args) {
		new App();//start the app
	}
	
}