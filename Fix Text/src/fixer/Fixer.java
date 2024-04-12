package fixer;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Fixer {

	String fileRute = "50Names.txt";
	String corretRute = "50CorrectNames.txt";
	ArrayList<Person> persons;
	
	public Fixer() {
		try {
			loadPersons();
			writeFile();
		}
		catch(Exception e) {
			
		}
		
	}
	
	private void writeFile()throws Exception {
		FileWriter fr = new FileWriter(corretRute);
		for(int i=0;i<persons.size();i++)
			fr.write(persons.get(i).toStrign()+"\n");//wirte in the file all people
		fr.close();
	}
	
	public void loadPersons()throws Exception {
		FileReader fr = new FileReader(fileRute);
		Scanner entry = new Scanner(fr);
		entry.useDelimiter("[,\n\r]+");
		persons = new ArrayList<>();
		String data[] = new String[4];//temporary data
		int pos=0;//pos of what its loading  0 first name, 1 middle name, 2 last name, 3 city
		while(entry.hasNext()) {
			String line[] = entry.nextLine().split(",");//get line a split
			for(int j=0;j<line.length;j++) {//move from data
				if(pos==4)persons.add(new Person(data[0],data[1],data[2],data[3]));	//if pos == 4 means its a full person in data
				pos%=4;				
				data[pos]=line[j];
				pos++;
			}
		}
		//comparator to sort for name
		Comparator<Person> cmp = new Comparator<>() {

			@Override
			public int compare(Person o1, Person o2) {
				int orderLast = o1.getLastName().compareToIgnoreCase(o2.getLastName());
				if(orderLast==0) {
					int orderFirst = o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
					if(orderFirst==0) 
						return o1.getMiddleName().compareToIgnoreCase(o2.getMiddleName());					
					else return orderFirst;
				}
				return orderLast;
			}
			
		};
		
		Collections.sort(persons,cmp);
	}
	
	
	public static void main(String[] args) {
		new Fixer();
	}
}