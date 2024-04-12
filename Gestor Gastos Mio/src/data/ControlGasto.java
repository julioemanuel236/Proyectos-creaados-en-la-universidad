package data;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class ControlGasto {

	LinkedList<Gasto> gastos;
	public static final String SEPARATOR = System.getProperty("file.separator");;
	
	private Usuario usuario;
	
	public ControlGasto() {
		this.gastos = new LinkedList<>();
	}
	
	public ControlGasto(Usuario usuario)throws IOException, URISyntaxException  {
		this.gastos = new LinkedList<>();
		this.usuario = usuario;
		cargarUsuario(usuario);
	}
	
	public void cargarUsuario(Usuario usuario)throws IOException, URISyntaxException {
		this.usuario = usuario;
		Date today = new Date();
		String fileName = today.getYear() + "" + (today.getMonth());
		cargarGastos(fileName);
	}
	
	public void cargarGastos(String fileName) throws IOException, URISyntaxException {
			
		if(usuario == null) {
				return;
		}
		
		
		
		gastos.clear();
		

		try {
			String dir = chek_dir(usuario);
			String dataFileRute = dir + SEPARATOR + fileName;
			FileReader fr = new FileReader(dataFileRute);
			Scanner scanner = new Scanner(fr);
			
			int n = Integer.parseInt(dataFileRute);
			
			for(int i = 0 ; i < n ; i++) {
				String nombre = scanner.nextLine();
				String tipo = scanner.nextLine();;
				String costeUnitario = scanner.nextLine();
				int unidades = Integer.parseInt(scanner.nextLine());
				long tiempoCreacion = Long.parseLong(scanner.nextLine());
				
				gastos.add(new Gasto(nombre, tipo, costeUnitario, unidades,tiempoCreacion));
				gastos.peekLast().toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
					
	}
	
	public void guardarGastos() {
		
	}
	
	private String getRutaRecurso(String filename) throws URISyntaxException, IOException {
		return getRuta() + filename;
	}

	private String getRuta() throws IOException, URISyntaxException {
		final ProtectionDomain domain;
		final CodeSource source;
		final URL url;
		final URI uri;
		String DirectoryPath;
		String separador_directorios = SEPARATOR;
		String JarURL;
		File auxiliar;
		domain = getClass().getProtectionDomain();
		source = domain.getCodeSource();
		url = source.getLocation();
		uri = url.toURI();
		JarURL = uri.getPath();
		auxiliar = new File(JarURL);
		if (auxiliar.isDirectory()) {
			auxiliar = new File(auxiliar.getParentFile().getParentFile().getPath());
			DirectoryPath = auxiliar.getCanonicalPath() + separador_directorios;
		} else {
			JarURL = auxiliar.getCanonicalPath();
			DirectoryPath = JarURL.substring(0, JarURL.lastIndexOf(separador_directorios) + 1);

		}
		return DirectoryPath;

	}

	public String chek_dir(Usuario usuario) throws IOException, URISyntaxException {
		String[] s = new String[] { "Data", usuario.getNombre()};
		String file = getRuta();
		
		for (int i = 0; i < s.length; i++) {
			file +=  SEPARATOR + s[i] ;
			File directorio = new File(file);
			if (!directorio.exists()) {				
				if (directorio.mkdirs()) {
					System.out.println("Directorio creado " + file);
				} else {
					System.out.println("Error al crear directorio");
				}
			}
		}
		return file;
	}
	
	/*
	public static void main(String[] args){
		try{
			new ControlGasto(new Usuario("Julio236"));					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
