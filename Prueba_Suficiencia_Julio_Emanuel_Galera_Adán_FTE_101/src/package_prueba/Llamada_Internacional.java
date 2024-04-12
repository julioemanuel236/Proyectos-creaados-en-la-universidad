package package_prueba;

import java.util.Date;

public class Llamada_Internacional extends Llamada{
	float tarifa;
	
	Llamada_Internacional(int min,String sal,String en,Date f,float tar){
		super(min,sal,en,f);
		tarifa=tar;
	}
	
	static String[] formatear(String s) {
		String arr[] = new String[4];
		String temp="";
		int j=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!='-')temp+=s.charAt(i);
			else {
				arr[j++]=temp;
				temp="";
			} 
		}
		if(j==4)
			return arr;
		return null;
	}
}
