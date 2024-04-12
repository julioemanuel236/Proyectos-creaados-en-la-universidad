package decanato;
import java.util.ArrayList;
public class Alumno {
	private String nombre;
	private String apellidos;
	private String sexo;
	private String ID;
	private String grupo;
	private int    year;
	private String proyecto;
	private boolean ayuda;
	protected ArrayList<Asignatura> asignaturas;
	
	public Alumno(String n,String a,String s,String id,String gru,int year,String p,boolean ayuda) {
		this.nombre=n;
		this.apellidos=a;
		this.sexo=s;
		this.ID=id;
		this.grupo=gru;
		this.year=year;
		this.proyecto=p;
		this.ayuda=ayuda;
		asignaturas = new ArrayList<Asignatura>();
	}
	
	public String getNombre() {
		return nombre;
	}

	
	public String getApellidos() {
		return apellidos;
	}

	
	public String getSexo() {
		return sexo;
	}

	public String getID() {
		return ID;
	}


	public String getGrupo() {
		return grupo;
	}


	public int getYear() {
		return year;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public boolean getAyuda() {
		return ayuda;
	}
	
	public float getPromedio() {
		int s=0;
		
		for(Asignatura i:asignaturas) {
			s+=i.getNota();
		}
		return s/asignaturas.size();
	}
	
	public String getInfo1() {
		return "Nombre y Apellidos :"+nombre+' '+apellidos+'\n'+
				"Grupo: "+grupo+'\n';
				
	}
	
	public String getInfo() {
		return getInfo1()+"Estipendio: "+100+"\n"+getInfo2()+"\n\n";
	}
	
	public String getInfo2() {
		String s="";
		for(Asignatura i:asignaturas)
			s+=i.getNombre()+": "+i.getNota()+'\n';
		return s+getPromedio()+'\n';
	}
	
}
