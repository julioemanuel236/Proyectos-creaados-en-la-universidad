package decanato;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Decanato {
	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	ArrayList<Ayudante> ayudantes = new ArrayList<Ayudante>();
	ArrayList<Licencia> licencias = new ArrayList<Licencia>();
	
	public void nuevoAlumno(Alumno a) {
		alumnos.add(a);
	}
	public void nuevoAyudante(Ayudante a) {
		alumnos.add(a);
		ayudantes.add(a);
	}
	public void nuevoLicencia(Licencia a) {
		alumnos.add(a);
		licencias.add(a);
	}
	
	public Alumno buscarGrupo(String ID) {
		for(Alumno i:alumnos) {
			if(i.getID().equals(ID))
				return i;
		}
		return null;
	}
	
	public float promedioNombre(String nombre,String apellido,int year) {
		for(Alumno i:alumnos) {
			if(i.getNombre().equals(nombre)||i.getApellidos().equals(apellido)) {
				float promedio=0;
				int cantidad=0;
				for(Asignatura j:i.asignaturas) {
					if(j.getYear()==year) {
						promedio+=j.getNota();
						cantidad++;
					}
				}
				return promedio/cantidad;
			}
		}
		return -1;
	}

	public ArrayList<Alumno> titulosOro() {
		ArrayList<Alumno> a = new ArrayList<Alumno>();
		for(Alumno i : alumnos)
			if(i.getPromedio()>=4.75)a.add(i);
		return a;
	}
	
	public String tipoAlumno(Alumno a) {
		for(Ayudante i:ayudantes) 
			if(i.getID().equals(a.getID()))return "Ayudante";
		
		for(Licencia i:licencias) 
			if(i.getID().equals(a.getID()))return "Licencia";
		
		for(Alumno i:alumnos) 
			if(i.getID().equals(a.getID()))return "Normal";
		
		return "No existe";
	}
	
	public String getEscalafon() {
		Comparator<Alumno> c = new Comparator<Alumno>() {
			@Override
			public int compare(Alumno o1, Alumno o2) {
				float p = o1.getPromedio();
				float ap = o2.getPromedio();
				if(p>ap)return 1;
				if(p==ap)return 0;
				return -1;
			}};
		Collections.sort(alumnos,c);
		String s="";
		for(Alumno i : alumnos) {
			s+=i.getNombre()+" "+i.getApellidos()+" - "+i.getPromedio()+'\n';
		}
		return s;
	}

	public void generarEscalafon() {
		FileWriter fw;
		try {
			fw = new FileWriter("Escalafon.txt");
			fw.write(getEscalafon());
			fw.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public void generarImpresion() {
		FileWriter fw;
		try {
			fw = new FileWriter("Escalafon.txt");
			for(Ayudante i:ayudantes) 
				fw.write(i.getInfo());
			for(Licencia i:licencias) 
				fw.write(i.getInfo());
			for(Alumno i:alumnos) 
				fw.write(i.getInfo());
			fw.close();
		}
		catch(Exception e) {
			
		}
	}
	
}