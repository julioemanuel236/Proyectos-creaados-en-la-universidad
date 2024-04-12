package package_prueba;

import java.util.Date;

public class Llamada_Interprovincial extends Llamada{

	
	Llamada_Interprovincial(int min,String sal,String en,Date f){
		super(min,sal,en,f);
	}
	
	static String[] formatear(String s) {
		String arr[] = new String[3];
		String temp="";
		int j=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!='-')temp+=s.charAt(i);
			else {
				arr[j++]=temp;
				temp="";
			} 
		}
		if(j==3)
			return arr;
		else return null;
	}
}
