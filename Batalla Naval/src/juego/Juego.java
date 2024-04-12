package juego;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Juego {
	
	public	TreeMap<String,Tablero> faciles = new TreeMap<>();//para guardar los mapas faciles
	public TreeMap<String,Tablero> normales= new TreeMap<>();//para guardar los mapas noramles
	public TreeMap<String,Tablero> dificiles= new TreeMap<>();//para guardar los mapas dificles
	public LinkedList<Tablero> lista = new LinkedList<>();//para guardar todos los mapas y mostrarlos en la coleccion
	public int mostrando=-1;//la posicon en la lista del mapa que se está mostrando en colección
	
	public boolean noMapa() {
		//retorn verdadero si las 3 listas de mapas están vacias
		return faciles.isEmpty()&&normales.isEmpty()&&dificiles.isEmpty();
	}
	
	public void cargarMapas() {
		JFileChooser fc = new JFileChooser();// crear un filechoser, abre una ventana de seleccion
		FileNameExtensionFilter filtrer = new FileNameExtensionFilter("Archivos de mapas","th");//filtro para los archivos.th
		fc.addChoosableFileFilter(filtrer);//aplicar filtro
		fc.addActionListener((ActionEvent)->{
		System.out.println(fc.getSelectedFile().getName());//mostrar por conosla el nombre del fichero seleccioando
		});
		int respuesta = fc.showOpenDialog(null);//si se selecciono un fichero o no
		
		if (respuesta == JFileChooser.APPROVE_OPTION) {// si la opcion fue seleccionar un fichero
			
		    File archivoElegido = fc.getSelectedFile();// obtener el fichero seleccionado
		    int c=0;// para contar cuantos mapas se leyeron correctamente
		    try {// intentar por si ocurre algun error
		    	Scanner entry = new Scanner(archivoElegido);// crear un scanner para leer el fichero como texto
		    	
		    	while(entry.hasNext()) {    //mientras que se pueda seguir avanzando en el fichero		    		
		    		String id = entry.next();//la id del tablero como string, primero se lee la palabra tablero
		    		id = entry.next();//se le lo siguiente que sería <<nombre>> 
		    		int pi=id.lastIndexOf('<');//ultima posicion del <
		    		int pf=id.indexOf('>');//primera posicon del >
		    		if(pi==-1||pf==-1)continue;//si alguna de las pociones es -1 es que no esta entre <>, continuar a otra cosa en ese caso
		    		
		    		id = id.substring(pi+1,pf);//id = a la subcadena entre < y >
		    		String dimension = entry.next();//leer la palabra dimension
		    		dimension = entry.next();//ahora si leer largo X alto		    		
		    		int alto = Integer.parseInt(dimension.substring(dimension.indexOf('X')+1));//definir alto como el numero despues de la X
		    		int ancho = Integer.parseInt(dimension.substring(0,dimension.indexOf('X')));//definir largo como el numero hasat la X sin incluirla
		    		
		    		TreeMap<String,Tablero> tablero;//para elegir a que dificultad pertenece
		    		if(alto*ancho>64)tablero = dificiles;// si es dificil
		    		else if(alto*ancho>32)tablero = normales;// si es normal
		    		else tablero = faciles;// si es facil
		    		//se escoga cualquiera tablero sera esa lsita
		    		boolean existe = false;
		    		if(tablero.keySet().contains(id)) {//si ya existe un mapa con la misma ID
		    			JOptionPane.showMessageDialog(fc, "El mapa con id "+id+" ya fue cargado");//mostrar error
		    			existe =true;//marcar que ya existe un mapa asi
		    		}
		    		
		    		String mapa="";
		    		for(int i=0;i<alto;i++) {
		    			String s=entry.next();
		    			mapa+=s;        		   			
		    		}
		    		if(existe) {//si fue marcado que ya existia
		    			continue;//continuar a la proxima iteracion, omitiendo la creacion e insercion en la lista del mapa
		    		}
		    		Tablero t = new Tablero(id,ancho,alto,mapa);//crear tablero con esa caracteristicas
		    		tablero.put(id,t);//añadir a la lista que se selecciono
		    		lista.add(t);//añadir a la lista total
		    		c++;//incrementar el contador de mapas leidos correctamente
		    	}	
		    	JOptionPane.showMessageDialog(fc, "Mapas cargados con exito: "+c);//luego de todo si no hubo errores garrafales
		    	//avisar que se cargaron tantos mapas
		    	
		    }
		    catch(Exception e) {    		    	
		    	e.printStackTrace();//mostrar error en la consola
		    	JOptionPane.showMessageDialog(fc, "Error al cargar los mapas");//mostrar error
		    	JOptionPane.showMessageDialog(fc, "Mapas cargados con exito: "+c);//decir cuantos mapas se cargaron correctamente
		    }
		}	
    }

	public Tablero siguienteDemo() {
		if(lista.isEmpty())return null;//si no hay mapas retornar null
		mostrando++;//aumentar en 1 el mapa mostradi
		if(mostrando==lista.size())mostrando=0;//si se paso del ultimo vovler al primero
		System.err.println(mostrando);//mostrar en consola el que se va a mostrar
		return lista.get(mostrando);//retornar ese mapa
	}
	
	public Tablero anteriorDemo() {
		if(lista.isEmpty())return null;//si no hay mapas retornar null
		mostrando--;//disminuir en 1 el mapa mostradi
		if(mostrando<=0)mostrando=lista.size()-1;//si se pasa del primero para atras volver al ultimo
		System.err.println(mostrando);//mostrar en consola el que se va a mostrar
		return lista.get(mostrando);
	}

	public Object[] mejores() {
		try {//intentar por si hay algun error
			FileReader fr = new FileReader("punteos.war");//abrir el fichero punteos.war
			Scanner entry = new Scanner(fr);//scanner para leer si texto
			ArrayList<Jugador> lista = new ArrayList<>();//una lista de la clase Jugador
			while(entry.hasNext()) {//mientras se pueda leer un siguiente
				String s = entry.next();//leer su nombre				
				System.err.println(s);//mostrar su nombre en consola
				int p = Integer.parseInt(entry.next());//leer su punto
				boolean existe=false;//para saber si ya se leyo y acumular en el
				for(int i=0;i<lista.size();i++) {//recorrer la lista de jugadores
					Jugador j = lista.get(i);//obtener el jugador de ese momento
					if(j.nombre.equals(s)) {//si tiene el mismo nombre que el que se leyo
						j.puntos+=p;//aumentar sus puntos
						existe=true;//marcar que ya existe
						break;
					}
				}
				if(!existe)lista.add(new Jugador(s,p));//si no existe añadir a la lista
			}
			
			Comparator<Jugador> cmp = new Comparator<Jugador>() {//comparador para ordenarlos

				@Override
				public int compare(Jugador o1, Jugador o2) {
					if(o1.puntos<o2.puntos)return 1;//si tiene menos puntos el primero va depues
					else if(o1.puntos>o2.puntos)return -1;//si tiene mas va primero
					else return 0;//da igual si tienen los mismos
					
				}
				
			};
			
			Collections.sort(lista,cmp);//ordenar la lista por el comparador

			return lista.toArray();//retornar la lista en forma de arreglo
		}
		catch(Exception e) {//si hubiese alguna execpcino
			e.printStackTrace();//imprimir el error
			return null;//retornar null
		}
	}
	
	public static void escribirAccion(String s) {//accion a escribir como parametro s
		try {//intentar
			FileWriter fw = new FileWriter("acciones.avn",true);//abrir el archivo acciones.avn en modo de escribir al final
			Date date = new Date();//una Date para saber la hora
			fw.write(s+":"+date.getHours()+":"+date.getMinutes()+"\n");//guardar en el fichero la accion mas la hora mas los minutos más un fin de linea
			fw.close();//cerrar el fichero para guardar
		}
		catch(Exception e) {//si algun error
			JOptionPane.showMessageDialog(null, "Error al guardar la accion");//mostrar error
		}
	}
	
	public static void guardarPuntaje(String nombre,int puntos) {//nombre y puntaje del jugador
		try {//intentar
			FileWriter fw = new FileWriter("punteos.war",true);//abrir puntaje en modo escritura al final
			fw.write("\n"+nombre+" "+puntos);//añadir un fin de linea más nombre + un esapcio + puntos
			fw.close();//cerrar para guardar
		}
		catch(Exception e) {//si algun error
			JOptionPane.showMessageDialog(null, "Error al guardar puntaje");//mostrar error
		}
	}
}
