package data;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.text.Format;
import java.time.LocalDateTime;

public class ControlGasto {
	public static String DATAEXTENSION = ".ggm";
	
	private LinkedList<Gasto> gastos;
	
	public static final String SEPARATOR = System.getProperty("file.separator");
	
	private Usuario usuario;
	
	private boolean ready = false;
	
	public ControlGasto() {
		this.gastos = new LinkedList<>();
		ready = true;
	}
	
	public ControlGasto(Usuario usuario)throws IOException, URISyntaxException  {
		this.gastos = new LinkedList<>();
		this.usuario = usuario;
		cargarUsuario(usuario);		
	}
	
	public void cargarUsuario(Usuario usuario)throws IOException, URISyntaxException {
		ready = false;
		this.usuario = usuario;			
		String fileName = LocalDateTime.now().getYear() + "" + (LocalDateTime.now().getMonthValue()) + DATAEXTENSION;
		cargarGastos(fileName);
		ready = true;
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
			
			int n = Integer.parseInt(scanner.nextLine());
			
			for(int i = 0 ; i < n ; i++) {
				String nombre = scanner.nextLine();
				String tipo = scanner.nextLine();
				String costeUnitario = scanner.nextLine();
				int unidades = Integer.parseInt(scanner.nextLine());
				long tiempoCreacion = Long.parseLong(scanner.nextLine());
				Moneda moneda = Moneda.valueOf(scanner.nextLine());
				gastos.add(new Gasto(nombre, tipo, costeUnitario, unidades,tiempoCreacion,moneda));
				System.out.println("|"+nombre+"|"+tipo+"|"+costeUnitario+"|"+unidades+"|"+tiempoCreacion+"|"+moneda+"|");
				 
			}
			fr.close();
			scanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
					
	}
	
	public void guardarGastos() {
		if(usuario == null) {
			return;
		}
		
		try {
			String fileName = LocalDateTime.now().getYear() + "" + (LocalDateTime.now().getMonthValue()) + DATAEXTENSION;
			String dir = chek_dir(usuario);
			String dataFileRute = dir + SEPARATOR + fileName;
			FileWriter fw = new FileWriter(dataFileRute);			
			
			fw.write(gastos.size()+"\n");
			
			for(Gasto g : gastos) {
				fw.write(g.getNombre()+"\n");
				fw.write(g.getTipo()+"\n");
				fw.write(g.getCosteUnitario()+"\n");
				fw.write(g.getUnidades()+"\n");
				fw.write(g.getTiempoCreacion()+"\n");		
				fw.write(g.getMoneda()+"\n");
			}
			
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
						
					
		
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
	
	public LinkedList<Gasto> getGastos() {
		return gastos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public static void main(String[] args){
		try{
			ControlGasto g = new ControlGasto(new Usuario("Julio236"));
			for(int i=1;i<=20;i++) {
				g.getGastos().add(new Gasto("Aceite " + i,"Cocina","750",1,Moneda.CUP));
			}
			
			g.guardarGastos();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitUntilReady() {
		
		while(!ready) {
			try {
				Thread.sleep(1000/144);
			}
			catch(Exception e) {
				
			}
		}
		
	}
	
}
