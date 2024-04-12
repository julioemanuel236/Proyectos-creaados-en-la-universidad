package agencia;

public abstract class Trabajador {
	private String nombre;
	private String carnet;
	private String nivelEscolar;
	private String sexo;
	private String telefono;
	private String dir;
	private int    xp;
	private float  salario;
	
	public Trabajador(String n,String c,String ne,String s,String t,String d,int x,float salario) {
		nombre=n;
		carnet=c;
		nivelEscolar=ne;
		sexo=s;
		telefono=t;
		dir=d;
		xp=x;
		this.salario=salario;
	}
	public float getSalario() {
		return salario;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getCarnet() {
		return carnet;
	}
	public String getNivelEscolar() {
		return nivelEscolar;
	}
	public String getSexo() {
		return sexo;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getDireccino() {
		return dir;
	}
	public int getExperiencia() {
		return xp;
	}
	public String toString() {
		return carnet;
	}
	
	public String datos() {
		return "Nombre: "+nombre+'\n'+
			   "Carnet: "+carnet+'\n'+
			   "Nivel Escolar: "+nivelEscolar+'\n'+
			   "Sexo: "+sexo+"\n"+
			   "Tel�fono: "+telefono+'\n'+
			   "Direcci�n: "+dir+'\n'+
			   "Experiencia: "+xp+'\n';		   
	}

	public String fichero() {
		return "Nombre: "+nombre+'|'+
				   "Carnet: "+carnet+'|'+
				   "Nivel Escolar: "+nivelEscolar+'|'+
				   "Sexo: "+sexo+"|"+
				   "Tel�fono: "+telefono+'|'+
				   "Direcci�n: "+dir+'|'+
				   "Experiencia: "+xp+'|';	
	}
	
}
