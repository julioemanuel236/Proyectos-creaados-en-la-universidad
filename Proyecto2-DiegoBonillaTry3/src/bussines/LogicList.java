package bussines;

import doMain.Grafo;
import doMain.ListMsg;
import doMain.ListReaction;
import doMain.ListTop10;
import doMain.ListaInt;
import doMain.ListaAdyacente;
import doMain.Person;
import nodos.NodoGraf;
import nodos.NodoMsg;
import nodos.NodoReaction;
import nodos.NodoSubList;
import nodos.NodoTop10;

public class LogicList {

	public static boolean insertarGrafo(Person origen, Grafo grafo) {
		NodoGraf nodo = new NodoGraf(origen);
		if (grafo.getPrimero() == null) {
			grafo.setPrimero(nodo);
			grafo.setUltimo(nodo);
		} else {
			grafo.getUltimo().setSigNodo(nodo);
			grafo.setUltimo(nodo);
		}
		return true;
	}

	/*
	 * public static boolean insertarReact(ListMsg listMsg, int reaccion) { NodoMsg
	 * nuevoNodo = new NodoMsg(reaccion); // Crear un nuevo nodo con el mensaje y la
	 * reacciï¿½n
	 * 
	 * if (listMsg.getPrimero() == null) { // Si la lista estï¿½ vacï¿½a
	 * listMsg.setPrimero(nuevoNodo); // El nuevo nodo se convierte en el primero
	 * listMsg.setUltimo(nuevoNodo); // El nuevo nodo tambiï¿½n es el ï¿½ltimo } else {
	 * listMsg.getUltimo().setSigNodo(nuevoNodo); // Agregar el nuevo nodo al final
	 * de la lista listMsg.setUltimo(nuevoNodo); // Actualizar el ï¿½ltimo nodo }
	 * 
	 * return true; }
	 */

	public static boolean insertarMens(ListMsg listMsg, String message) {
		NodoMsg nuevoNodo = new NodoMsg(message, (int) (Math.random() * 10) + 1); // Crear un nuevo nodo con el mensaje
																					// y la reaccion

		if (listMsg.getPrimero() == null) { // Si la lista estï¿½ vacï¿½a
			listMsg.setPrimero(nuevoNodo); // El nuevo nodo se convierte en el primero
			listMsg.setUltimo(nuevoNodo); // El nuevo nodo tambiï¿½n es el ï¿½ltimo
		} else {
			listMsg.getUltimo().setSigNodo(nuevoNodo); // Agregar el nuevo nodo al final de la lista
			listMsg.setUltimo(nuevoNodo); // Actualizar el ï¿½ltimo nodo
		}

		return true;
	}

	public static String showList(ListMsg listMsg) {
		String salida = " ";
		NodoMsg temp = listMsg.getPrimero();
		// System.out.println(lista.getPrimero().getTool().getPlate());
		while (temp != null) {
			// System.out.println(temp.getTool().getPlate());// temporal apunta a cada nodo,
			// se recorre el while por cada nodo
			salida += temp;
			temp = temp.getSigNodo();// genera la conexion del temporal al siguiente nodo
		}
		return salida;

	}

	public static boolean insertar(ListTop10 listSeat, String name, int reaction) {
		NodoTop10 nodoSeat = new NodoTop10(name, reaction);// primer paso, creo el nodo

		if (listSeat.getPrimero() == null) {// pregunto el estado del primero, si primero es nulo, el ultimo tambien es
											// nulo
			listSeat.setPrimero(nodoSeat);// Asigno primero y ultimo un nodo //////// se traza una linea hasta otro
											// elemento
			listSeat.setUltimo(nodoSeat);

		} else {
			listSeat.getUltimo().setSigNodo(nodoSeat);
			listSeat.setUltimo(nodoSeat);
		}

		return true;

	}

	public static boolean insertar(Person destino, ListaAdyacente list, int distancia) {
		NodoSubList nodo = new NodoSubList(destino, distancia);
		if (list.getPrimero() == null) {
			list.setPrimero(nodo);
			list.setUltimo(nodo);
		} else {
			list.getUltimo().setSigNodo(nodo);
			list.setUltimo(nodo);
		}
		return true;
	}

	public static void search(Person origen, Person destino, int distancia, Grafo grafo) {
		// Verificar si tanto el origen como el destino son vï¿½lidos en el grafo
		if (validateSearch(grafo, origen) && validateSearch(grafo, destino)) {
			// Si ambos nodos son vï¿½lidos, insertar el destino en la lista adyacente del
			// origen con la distancia proporcionada
			insertar(destino, validatee(grafo, origen), distancia);
		}
	}

	// Funciï¿½n para obtener la lista adyacente de un nodo de persona dado
	public static ListaAdyacente validatee(Grafo grafo, Person person) {
		ListaAdyacente exit = null;
		// Obtener el primer nodo del grafo
		NodoGraf temp = grafo.getPrimero();
		// Iterar sobre los nodos del grafo
		while (temp != null) {
			// Si el nodo actual coincide con la persona dada, asignar su lista adyacente a
			// 'exit'
			if (temp.getPerson() == person) {
				exit = temp.getSubList();
			}
			// Avanzar al siguiente nodo en el grafo
			temp = temp.getSigNodo();
		}
		return exit;
	}

	// Funciï¿½n para verificar si un nodo de persona dado estï¿½ presente en el grafo
	public static boolean validateSearch(Grafo grafo, Person person) {
		boolean exit = false;
		// Obtener el primer nodo del grafo
		NodoGraf temp = grafo.getPrimero();
		// Iterar sobre los nodos del grafo
		while (temp != null) {
			// Si el nodo actual coincide con la persona dada, establecer 'exit' como
			// verdadero y salir del bucle
			if (temp.getPerson() == person) {
				exit = true;
				break;
			}
			// Avanzar al siguiente nodo en el grafo
			temp = temp.getSigNodo();
		}
		return exit;
	}

	/**
	 * Busca una persona por su nombre en el grafo.
	 * 
	 * @param nombre El nombre de la persona que se estï¿½ buscando.
	 * @return La persona encontrada, o null si no se encuentra ninguna persona con
	 *         ese nombre.
	 */
	public static Person buscarPersonaPorNombre(String nombre) {
		NodoGraf temp = Utils.grafo.getPrimero();
		// Iterar sobre los nodos del grafo
		while (temp != null) {
			// Si el nombre del nodo actual coincide con el nombre buscado, devolver esa
			// persona
			if (temp.getPerson().getName().equals(nombre)) {
				return temp.getPerson();
			}
			// Avanzar al siguiente nodo en el grafo
			temp = temp.getSigNodo();
		}
		// Si no se encuentra la persona, retornar null
		return null;
	}

	/**
	 * Busca un mensaje en una lista de mensajes.
	 * 
	 * @param lista          La lista de mensajes en la que se buscarï¿½ el mensaje.
	 * @param confirm        Indica si se ha encontrado el mensaje o no.
	 * @param mensajeBuscado El mensaje que se estï¿½ buscando.
	 * @return El nodo del mensaje encontrado, o null si no se encuentra el mensaje
	 *         en la lista.
	 */
	public static NodoMsg buscarMensaje(ListMsg lista, boolean confirm, String mensajeBuscado) {
		NodoMsg temp = lista.getPrimero();
		// Iterar sobre los nodos de la lista de mensajes
		while (temp != null) {
			// Si el mensaje del nodo actual coincide con el mensaje buscado, devolver ese
			// nodo
			if (temp.getMessage().equals(mensajeBuscado)) {
				return temp;
			}
			// Avanzar al siguiente nodo en la lista
			temp = temp.getSigNodo();
		}
		// Si no se encuentra el mensaje, retornar null
		return null;
	}

	/**
	 * Busca una persona por su ID en el grafo.
	 * 
	 * @param id El ID de la persona que se estï¿½ buscando.
	 * @return La persona encontrada, o null si no se encuentra ninguna persona con
	 *         ese ID.
	 */
	public static Person buscarPersonaPorID(int id) {
		NodoGraf temp = Utils.grafo.getPrimero();
		// Iterar sobre los nodos del grafo
		while (temp != null) {
			// Si el ID del nodo actual coincide con el ID buscado, devolver esa persona
			if (temp.getPerson().getiD() == id) {
				return temp.getPerson();
			}
			// Avanzar al siguiente nodo en el grafo
			temp = temp.getSigNodo();
		}
		// Si no se encuentra la persona, retornar null
		return null;
	}

	/**
	 * Verifica si una cï¿½dula existe en el grafo.
	 * 
	 * @param cedula La cï¿½dula que se estï¿½ buscando.
	 * @param grafo  El grafo en el que se realizarï¿½ la bï¿½squeda.
	 * @return true si la cï¿½dula existe en el grafo, false en caso contrario.
	 */
	public static boolean existeCedula(int cedula, Grafo grafo) {
		NodoGraf temp = Utils.grafo.getPrimero();
		// Iterar sobre los nodos del grafo
		while (temp != null) {
			// Si la cï¿½dula del nodo actual coincide con la cï¿½dula buscada, retornar true
			if (temp.getPerson().getiD() == cedula) {
				return true;
			}
			// Avanzar al siguiente nodo en el grafo
			temp = temp.getSigNodo();
		}
		// Si no se encuentra la cï¿½dula, retornar false
		return false;
	}

	public static String Shwo(Grafo grafo) {
		String exit = "";
		NodoGraf temp = grafo.getPrimero();
		while (temp != null) {
			exit += temp + "\n";
			temp = temp.getSigNodo();
		}
		return exit;
	}

	public static String showListTop1(ListTop10 listTop) {
		String salida = " ";
		NodoTop10 temp = listTop.getPrimero();
		// System.out.println(lista.getPrimero().getTool().getPlate());
		while (temp != null) {
			// System.out.println(temp.getTool().getPlate());// temporal apunta a cada nodo,
			// se recorre el while por cada nodo
			salida += temp;
			temp = temp.getSigNodo();// genera la conexion del temporal al siguiente nodo
		}
		return salida;

	}

	/**
	 * Inserta la suma de las reacciones de cada persona en el top 10.
	 * 
	 * @param grafo      El grafo que contiene la informaciï¿½n de las personas y sus
	 *                   relaciones.
	 * @param listaTop10 La lista Top 10 en la que se insertarï¿½ la suma de
	 *                   reacciones.
	 */
	public static void insertarSumaReaccionesEnTop10(Grafo grafo, ListTop10 listaTop10) {
		NodoGraf nodoActual = grafo.getPrimero();

		// Iterar sobre todos los nodos del grafo
		while (nodoActual != null) {
			// Calcular la suma de las reacciones de la persona actual
			int sumaReacciones = calcularSumaReacciones(nodoActual);
			// Insertar la suma de reacciones en la lista Top 10
			insertarSumaEnTop10(nodoActual.getPerson().getName(), sumaReacciones, listaTop10);
			// Mover al siguiente nodo del grafo
			nodoActual = nodoActual.getSigNodo();
		}
	}

	/**
	 * Calcula la suma de las reacciones de los amigos de una persona.
	 * 
	 * @param nodo El nodo de persona del que se calcularï¿½ la suma de reacciones de
	 *             sus amigos.
	 * @return La suma de las reacciones de los amigos de la persona.
	 */
	private static int calcularSumaReacciones(NodoGraf nodo) {
		int suma = 0;
		NodoMsg nodoAdyacente = nodo.getPerson().getListM().getPrimero();
		// Iterar sobre los nodos adyacentes al nodo actual
		while (nodoAdyacente != null) {
			// Sumar las distancias (reacciones) de los nodos adyacentes
			suma += nodoAdyacente.getReactions();
			// Mover al siguiente nodo adyacente
			nodoAdyacente = nodoAdyacente.getSigNodo();
		}

		return suma;
	}

	/**
	 * Inserta la suma de reacciones en la lista Top 10.
	 * 
	 * @param nombre         El nombre de la persona.
	 * @param sumaReacciones La suma de reacciones de la persona.
	 * @param listaTop10     La lista Top 10 en la que se insertarï¿½ la suma de
	 *                       reacciones.
	 */
	private static void insertarSumaEnTop10(String nombre, int sumaReacciones, ListTop10 listaTop10) {
		// Crear un nuevo nodo para la persona con su suma de reacciones
		NodoTop10 nuevoNodo = new NodoTop10(nombre, sumaReacciones);

		if (listaTop10.getPrimero() == null) {
			// Si la lista Top 10 estï¿½ vacï¿½a, establecer el nuevo nodo como el primero y el
			// ï¿½ltimo
			listaTop10.setPrimero(nuevoNodo);
			listaTop10.setUltimo(nuevoNodo);
		} else {
			// Si la lista Top 10 no estï¿½ vacï¿½a, verificar si el nombre ya existe en la
			// lista
			NodoTop10 nodoActual = listaTop10.getPrimero();
			boolean nombreEncontrado = false;

			// Iterar sobre los nodos de la lista Top 10
			while (nodoActual != null) {
				// Si el nombre ya estï¿½ en la lista, marcarlo como encontrado y salir del bucle
				if (nodoActual.getMessage().equals(nombre)) {

					nodoActual.setReaction(sumaReacciones);
					nombreEncontrado = true;
					break;
				}
				// Mover al siguiente nodo de la lista Top 10
				nodoActual = nodoActual.getSigNodo();
			}

			if (!nombreEncontrado) {
				// Si el nombre no se encuentra en la lista, insertar el nuevo nodo al principio
				// de la lista
				nuevoNodo.setSigNodo(listaTop10.getPrimero());
				listaTop10.setPrimero(nuevoNodo);
			}
		}
	}

	/**
	 * Organiza una lista top 10 en orden descendente segï¿½n el nï¿½mero de reacciones.
	 * 
	 * @param listTop La lista top 10 que se desea organizar.
	 * @return La lista top 10 organizada en orden descendente.
	 */
	public static ListTop10 organiceList(ListTop10 listTop) {
		NodoTop10 temp1, temp2;
		int auxReaction;
		String auxMessage;

		// Recorrer la lista utilizando dos bucles anidados para comparar elementos dos
		// a dos
		for (temp1 = listTop.getPrimero(); temp1 != null; temp1 = temp1.getSigNodo()) {
			for (temp2 = temp1.getSigNodo(); temp2 != null; temp2 = temp2.getSigNodo()) {
				// Si la reacciï¿½n del primer nodo es menor que la reacciï¿½n del segundo nodo
				if (temp1.getReaction() < temp2.getReaction()) {
					// Intercambiar la reacciï¿½n entre los nodos
					auxReaction = temp1.getReaction();
					temp1.setReaction(temp2.getReaction());
					temp2.setReaction(auxReaction);

					// Intercambiar el mensaje entre los nodos
					auxMessage = temp1.getMessage();
					temp1.setMessage(temp2.getMessage());
					temp2.setMessage(auxMessage);
				}
			}
		}

		return listTop; // Devolver la lista top 10 organizada en orden descendente
	}

	// Metodo para aÃ±adir nuevo seguidor
	public static void añadirSugerencia(String user, String name) {

		NodoGraf temp = Utils.grafo.getPrimero();

		while (temp != null) {

			if (temp.getPerson().getName().equals(user)) {

				System.out.println(temp.getPerson().getName());

				NodoGraf temp1 = Utils.grafo.getPrimero();

				while (temp1 != null) {

					if (temp1.getPerson().getName().equals(name)) {

						System.out.println(temp1.getPerson().getName());

						insertar(temp1.getPerson(), temp.getSubList(), 0);
						Shwo(Utils.grafo);
					}

					temp1 = temp1.getSigNodo();
				}

			}

			temp = temp.getSigNodo();
		}

	}

	public Person persona(String nombre) {
		NodoGraf temp = Utils.grafo.getPrimero();
		
		while(temp != null) {
			if(temp.getPerson().getName().equalsIgnoreCase(nombre))
				return temp.getPerson();
		}
		return null;
	}
	
	// Metodo para reaccionar a un comentario.
	public void reaction(String user, String publication, String follower) {

		NodoGraf temp = Utils.grafo.getPrimero();

		while (temp != null) {

			if (temp.getPerson().getName().equals(follower)) {

				NodoMsg menssage = temp.getPerson().getListM().getPrimero();

				while (menssage != null) {

					if (menssage.getMessage().equalsIgnoreCase(publication)) {

						insertarReaccion(menssage.getListR(), persona(follower), persona(user));
						menssage.setReactions(menssage.getReactions() + 1);
						System.out.println(showListMessage(temp.getPerson().getListM()));

					}

					menssage = menssage.getSigNodo();
				}

			}

			temp = temp.getSigNodo();
		}

	}

	public boolean insertarReaccion(ListReaction listReac, Person user,Person follower) {

		NodoReaction nuevoNodo = new NodoReaction(follower,user);

		if (listReac.getFirst() == null) {

			listReac.setFirst(nuevoNodo);
			listReac.setLast(nuevoNodo);

		} else {

			listReac.getLast().setNextNod(nuevoNodo);
			listReac.setLast(nuevoNodo);
		}

		return true;
	}

	public static String showListMessage(ListMsg listMsg) {
		String salida = " ";
		NodoMsg temp = listMsg.getPrimero();

		while (temp != null) {

			salida += temp.toString();

			temp = temp.getSigNodo();
		}

		return salida;

	}

	//Metodo para obtener el total de personas en un grafo:
	public int numeroPersonas (Grafo grafo) {
		
		int result = 0;
		
		NodoGraf temp = grafo.getPrimero();

		while (temp != null) {

			result++;

			temp = temp.getSigNodo();
		}
		
		System.out.println(result);
		
		return result;
	}
	
	public int posicionPersona(Person p,Grafo g) {
		NodoGraf nodo = g.getPrimero();
		int pos = 0;
		
		while(nodo != null) {
			if(nodo.getPerson() == p)return pos;
			pos++;
			nodo = nodo.getSigNodo();
		}
		
		return -1;
	}

	public Person getPersona(Grafo grafo,int pos) {
		
		int index = 0;
		
		NodoGraf temp = grafo.getPrimero();
		
		while(index < pos && temp != null) {
			index++;
			temp = temp.getSigNodo();
		}
		
		if(index == pos && temp != null)
			return temp.getPerson();
		
		return null;
	}
	
	public String dijkstraPrueba(Grafo grafo, Person origen, Person destino) {
		int nodo = posicionPersona(origen,grafo);
		
		//Primero construir la matrix de adyacencia basado en las reacciones
			
		int n = numeroPersonas(Utils.grafo);//cantidad de nodos del grafo
		
		int matrix[][] = new int[n][n];//matriz de adyacencia ponderada
		
		int distancias[] = new int[n];//distancias desde el origen hasta todos los nodos
		
		int padre[] = new int[n];//para saber el camino mas corto por donde pasa
		
		//estableceremos las distancias en -1, asi sabremos a donde no hemos llegado, y cuando lleguemos con un camino mejor en el mismo arreglo
		for(int i=0;i<n;i++) {
			distancias[i] = -1;
			//establecer el padre de cada uno en si mismo
			padre[i] = i;
		}
		
		boolean agregado[] = new boolean[n];
		
		//aqui recorremos todos los nodos del grafo, y vemos quiens han reaccionado para agregarlos a la matriz
		NodoGraf nodog = grafo.getPrimero(); 

		while(nodog != null) {
			NodoSubList react = nodog.getSubList().getPrimero();
			while(react != null) {
				int b = posicionPersona(nodog.getPerson(),grafo);
				int a = posicionPersona(react.getPerson(),grafo);
				matrix[a][b] = react.getDistance();
				react = react.getSigNodo();
			}
			nodog = nodog.getSigNodo();
		}
		
		
		//luego aplicamos disktra
		
		ListaInt lista = new ListaInt();
		
		lista.agregar(nodo);
		distancias[nodo] = 0;
		String result = "";
		while(!lista.isEmpty()) {
			nodo = lista.poll();
			//System.out.println("REVISANDO "+ nodo);
			if(!agregado[nodo]) {
				result += "Adyacentes de "+getPersona(grafo, nodo) + ": ";
			}
																							
			for(int next=0;next<n;next++) {
				if(matrix[nodo][next] == 0 )
					continue;
				
				if(nodo == next)
					continue;
				if(!agregado[nodo])
				result += (getPersona(grafo,next))+" "+matrix[nodo][next] + " -> ";
				int nuevaDistancia = distancias[nodo] + matrix[nodo][next];
				if(distancias[nodo] == -1)
					nuevaDistancia++;
				
				if(distancias[next] == -1 || nuevaDistancia < distancias[next]) {
			//		System.out.println("LLEGANDO A "+next+ " CON " + nuevaDistancia); 				
					distancias[next] = nuevaDistancia;
					padre[next] = nodo;
					lista.agregar(next);
				}
				
			}
			
			agregado[nodo] = true;
			result+="\n";
			
		}
		
		
		String camino = obtenerCamino(padre,posicionPersona(destino, grafo));		
		result = "Peso: ("+distancias[posicionPersona(destino, grafo)] + ") -> Ruta: "+camino+"\n" + result; 
			
		
        return result;
	}

	public String obtenerCamino(int[] padre,int pos) {
		System.out.println(pos);
		if(padre[pos] == pos) {
			return getPersona(Utils.grafo, pos).getName();
		}
		
		String res = "";
		
		res = obtenerCamino(padre,padre[pos]) + " -> " + getPersona(Utils.grafo, pos).getName();;
		
		return res;
	}
	
}
