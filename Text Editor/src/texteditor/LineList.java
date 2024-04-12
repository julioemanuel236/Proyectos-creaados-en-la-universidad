package texteditor;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/** 
* 
* Student name:  Danny Nhan
* Completion date: programming project 3
*
* LineList.txt: the template file of LineList.java
* Student tasks: implement tasks as specified in this file
*
* LineList class is a linked-base list that represents the contents of a document
*
*/


public class LineList{
   
   private Node head;
   
   public LineList(){   //constructor  
      head=null;
   }
   //Don't modify anything before this line. 
   //Do not add any other instance variables.
   

   // *** Student tasks: implement the following methods *** 
  
   public void empty(){
      	head = null;
   }

   public void load(String fileName, boolean append){
      	if(!append)empty();
      	try {
      		FileReader fr = new FileReader(fileName);
      		Scanner entry = new Scanner(fr);
      		while(entry.hasNext()) {
      			String line = entry.nextLine();
      			addLine(line);
      		}
      		entry.close();
      	}
      	catch(Exception e) {
      		System.out.println(e.toString());
      	}
   }
   
   public void save(String fileName){
      	try {
      		FileWriter fw = new FileWriter(fileName);
      		fw.write(toString());
      		fw.close();
      	}
      	catch(Exception e) {
      		System.out.println(e.toString());
      	}

   }
   
   public void addLine(String line){
      	Node aux = head;
      	if(aux == null) {
      		head = new Node(line);
      		return;
      	}
      	while(aux.getNext() != null) {
      		aux = aux.getNext();
      	}
      	aux.setNext(new Node(line));
   }

   public void addLine(String line, int n){
	    int pos = 2;
	    Node aux = head;
	    Node aux2;
	    Node add = new Node(line);	    
	 	if(aux == null) {	 		
	 		head = new Node(line);
	 		return;
	 	}
	 	if (n == 1) {
	    	head = add;
	    	add.setNext(aux);
	    	return;
	    }
	 	while(aux.getNext() != null && pos<n) {
	 		aux = aux.getNext();
	 		pos++;
	 	}
	 	aux2 = aux.getNext();
	 	aux.setNext(add);
	 	add.setNext(aux2);
   }
   
   public int words(){
	   int cont = 0;
	   Node aux = head;
	   while(aux!=null) {
		   String line = aux.getLine();
		   boolean word = false;
		   for(int i = 0 ; i < line.length() ; i++) {
			   char c = line.charAt(i);
			   //\s(white spaces) \t(tab) , . ; � ? * ! � @ - : . 
			   if(c == '\s' || c == '\t' || c == ',' || c == '.' || c == ';' || c == '\'' || c == '?' ||
			      c == '*' || c == '!' || c == '"' || c == '@' || c == '-' || c == ':' || c== '.'  || c == '\n') {
				   if(word)cont++;
				   word = false;
			   }
			   else word = true;				   
		   }
		   if(word)cont++;
		   aux = aux.getNext();
	   }
	   return cont;
      
   }

   public int lines(){ 
	   int cont = 0;
	   Node aux = head;
	   while(aux!=null) {
		   cont++;
		   aux = aux.getNext();
	   }
	   return cont;
   }

   public void delete(int n){
	   Node aux = head;
	   int pos = 2;
	   if(aux == null)return;
	   if(n == 1) {
		   head = head.getNext();
		   return;
	   }
	   while(aux.getNext() != null && pos < n) {		   
		   aux = aux.getNext();	   
		   pos++;
	   }
	   Node aux2 = aux.getNext();
	   if(aux2 == null)return;
	   aux.setNext(aux2.getNext());
   }

   public String toString(){
	   String s = "";
	   Node aux = head;
	   
	   while(aux!=null) {
		   s += aux.getLine();
		   if(aux.getNext()!=null)s+="\n";
		   aux = aux.getNext();
	   }
	   return s;
   }

   public void print(){	   
	   Node aux = head;
	   int pos = 0;
	   while(aux!=null) {
		   pos++;
		   System.out.println(pos+". "+aux.getLine()); 
		   aux = aux.getNext();
	   }
   }
   
   public void replace(String s1, String s2){
	   Node aux = head;	   
	   while(aux!=null) {
		   aux.replace(s1, s2); 
		   aux = aux.getNext();
	   }
   }

   public void line(int n){
	   Node aux = head;
	   int pos = 1;
	   while(aux!=null && pos < n) { 
		   aux = aux.getNext();
		   pos++;
	   }
	   if(aux == null || pos < n)System.out.println("Line "+n+" does not exist.");
	   else System.out.println(aux.getLine());
   }
}
