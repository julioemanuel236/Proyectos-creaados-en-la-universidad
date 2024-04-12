package decanato;

import java.util.ArrayList;

public class Ayudante extends Alumno{
	protected ArrayList<Integer> ayudantia;
	protected ArrayList<Asignatura> impartidas;
	
	public Ayudante(String n,String a,String s,String id,String gru,int year,String p,boolean ayuda,int[] ayudantia,Asignatura[] as) {
		super(n,a,s,id,gru,year,p,ayuda);
		for(Integer i:ayudantia)
			this.ayudantia.add(i);
		for(Asignatura i:as)
			this.impartidas.add(i);
	
	}
	
	public String getInfo() {
		return getInfo1()+"Estipendio: "+150+"\n"+getInfo2()+"\n\n";
	}
	
}