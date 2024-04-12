package data;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import bussines.LogicList;
import bussines.Utils;
import doMain.Grafo;
import doMain.ListMsg;
import doMain.Person;
import nodos.NodoGraf;
import presentation.GuiListPerson;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class FileXML {
	String existFile = "";
	LogicList logL;
	File archivo = new File(existFile);

	public FileXML() {
		logL = new LogicList();
	}

	public static void writeXML(String message, Person person) {

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(new File(message));
			doc.getDocumentElement().normalize();

			Element rootElement = doc.getDocumentElement();

			// Crear elemento para la nueva persona
			Element newPersonElement = doc.createElement("Persona");
			rootElement.appendChild(newPersonElement);

			// A�adir atributos y datos de la nueva persona

			Element nameElement = doc.createElement("Nombre");
			nameElement.appendChild(doc.createTextNode(person.getName()));
			newPersonElement.appendChild(nameElement);

			Element lastNameElement = doc.createElement("Apellido");
			lastNameElement.appendChild(doc.createTextNode(person.getLastName()));
			newPersonElement.appendChild(lastNameElement);

			Element cedula = doc.createElement("Cedula");
			cedula.appendChild(doc.createTextNode((String.valueOf(person.getiD()))));
			newPersonElement.appendChild(cedula);

			Element dateOfBirthElement = doc.createElement("FechaNacimiento");
			dateOfBirthElement.appendChild(
					doc.createTextNode(person.getDateBorn().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
			newPersonElement.appendChild(dateOfBirthElement);

			Element districtElement = doc.createElement("Distrito");
			districtElement.appendChild(doc.createTextNode(person.getDistrict()));
			newPersonElement.appendChild(districtElement);

			Element genderElement = doc.createElement("Genero");
			if (person.isGender()) {
				genderElement.appendChild(doc.createTextNode("Masculino"));
			} else {
				genderElement.appendChild(doc.createTextNode("Femenino"));
			}
			newPersonElement.appendChild(genderElement);

			// Insertar la nueva persona en el grafo
			LogicList.insertarGrafo(person, Utils.grafo);

			// Agregar seguidores aleatorios
			Grafo grafo = Utils.grafo;
			NodoGraf temp = grafo.getPrimero();
			int seguidoresAgregados = 0;
			Random random = new Random();

			while (temp != null && seguidoresAgregados < 3) {
				// Seleccionar aleatoriamente si agregar esta persona como seguidor
				if (random.nextBoolean()) {
					// Establecer una reacci�n aleatoria (por ejemplo, de 1 a 5)
					int reaccion = random.nextInt(5) + 1;
					// Establecer una relaci�n entre la nueva persona y el seguidor con la reacci�n
					// generada
					LogicList.search(person, temp.getPerson(), reaccion, Utils.grafo);

					// Crear elemento para el seguidor
					Element seguidorElement = doc.createElement("Seguidor");
					newPersonElement.appendChild(seguidorElement);

					// A�adir datos del seguidor
					Element nombreElement = doc.createElement("Nombre");
					nombreElement.appendChild(doc.createTextNode(temp.getPerson().getName()));
					seguidorElement.appendChild(nombreElement);

					Element cedulaElement = doc.createElement("Cedula");
					cedulaElement.appendChild(doc.createTextNode(String.valueOf(temp.getPerson().getiD())));
					seguidorElement.appendChild(cedulaElement);

					Element reaccionesElement = doc.createElement("Reaccion");
					reaccionesElement.appendChild(doc.createTextNode(String.valueOf(reaccion)));
					seguidorElement.appendChild(reaccionesElement);

					seguidoresAgregados++;
				}
				temp = temp.getSigNodo();
			}

			// Escribir el contenido en un archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File(message));
			transformer.transform(source, result);

			System.out.println("Registro guardado");

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}

	public static void readXML(String address, Grafo grafo) {
		try {
			File inputFile = new File(address);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			System.out.println("Raiz de los elementos: " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Persona");
			System.out.println("--------------------------------------");

			// Primera pasada: insertar personas en el grafo
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					// Obtener informaci�n de la persona
					String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
					String apellido = eElement.getElementsByTagName("Apellido").item(0).getTextContent();
					int cedula = Integer.parseInt(eElement.getElementsByTagName("Cedula").item(0).getTextContent());
					LocalDate fechaNacimiento = LocalDate.parse(
							eElement.getElementsByTagName("FechaNacimiento").item(0).getTextContent(),
							DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					String distrito = eElement.getElementsByTagName("Distrito").item(0).getTextContent();
					boolean genero = Boolean
							.parseBoolean(eElement.getElementsByTagName("Genero").item(0).getTextContent());

					// Crear objeto Persona
					Person nuevaPersona = new Person(nombre, apellido, cedula, fechaNacimiento, distrito, genero);

					// Insertar en el grafo
					LogicList.insertarGrafo(nuevaPersona, Utils.grafo);

					// Obtener las publicaciones y comentarios
					NodeList publicacionesList = eElement.getElementsByTagName("Publicacion");
					for (int j = 0; j < publicacionesList.getLength(); j++) {
						Node publicacionNode = publicacionesList.item(j);
						if (publicacionNode.getNodeType() == Node.ELEMENT_NODE) {
							Element publicacionElement = (Element) publicacionNode;
							String comentario = publicacionElement.getElementsByTagName("Comentario").item(0)
									.getTextContent();

							LogicList.insertarMens(nuevaPersona.getListM(), comentario);
						}
					}
				}
			}

			// Segunda pasada: insertar seguidores en las listas
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					// Obtener informaci�n de la persona
					int cedula = Integer.parseInt(eElement.getElementsByTagName("Cedula").item(0).getTextContent());
					Person nuevaPersona = LogicList.buscarPersonaPorID(cedula);

					NodeList seguidoresList = eElement.getElementsByTagName("Seguidor");
					for (int j = 0; j < seguidoresList.getLength(); j++) {
						Node seguidorNode = seguidoresList.item(j);
						if (seguidorNode.getNodeType() == Node.ELEMENT_NODE) {
							Element seguidorElement = (Element) seguidorNode;
							int seguidorCedula = Integer
									.parseInt(seguidorElement.getElementsByTagName("Cedula").item(0).getTextContent());
							int reaccion = Integer.parseInt(
									seguidorElement.getElementsByTagName("Reaccion").item(0).getTextContent());

							// Crear objeto Persona para el seguidor
							Person seguidor = LogicList.buscarPersonaPorID(seguidorCedula);

							// Insertar relaci�n en la lista de adyacencia
							if (seguidor != null) {
								LogicList.search(nuevaPersona, seguidor, reaccion, grafo);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
