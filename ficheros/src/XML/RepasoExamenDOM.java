import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class RepasoExamenDOM {
	public static Document creaArbol(String ruta) {
		Document doc = null;
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			factoria.setIgnoringComments(true);
			DocumentBuilder builder = factoria.newDocumentBuilder();
			doc = builder.parse(ruta);
		} catch (Exception e) {
			System.out.println("Error generando el árbol DOM: " + e.getMessage());
		}
		return doc;
	}

	public static void CircuitIdD(Document doc) {
		NodeList datas = doc.getElementsByTagName("data");
		Element temporal;
		NodeList raceTables;
		NodeList racess;
		NodeList races;
		NodeList circuits;
		NodeList circuitsIDs;

		for (int i = 0; i < datas.getLength(); i++) {
			temporal = (Element) datas.item(i);
			// System.out.println("hola");
			raceTables = temporal.getElementsByTagName("RaceTable");
			for (int j = 0; j < raceTables.getLength(); j++) {
				// System.out.println("holaj");
				temporal = (Element) raceTables.item(j);
				racess = temporal.getElementsByTagName("Races");
				for (int k = 0; k < racess.getLength(); k++) {
					// System.out.println("holak");
					temporal = (Element) racess.item(k);
					races = temporal.getElementsByTagName("Race");
					for (int l = 0; l < races.getLength(); l++) {
						// System.out.println("holal");
						temporal = (Element) races.item(l);
						circuits = temporal.getElementsByTagName("Circuit");
						for (int m = 0; m < circuits.getLength(); m++) {
							// System.out.println("holam");
							temporal = (Element) circuits.item(m);
							circuitsIDs = temporal.getElementsByTagName("circuitId");
							System.out.println("Id: " + circuitsIDs.item(0).getFirstChild().getNodeValue());
						}
					}
				}
			}
		}
	}

	public static Element Optimitation(NodeList list) {
		Element element;
		for (int i = 0; i < list.getLength(); i++) {
			element = (Element) list.item(i);
			return element;
		}
		return null;
	}

	public static void CountryLarLongContructorName(Document doc) {
		NodeList datas = doc.getElementsByTagName("data");
		Element temporal;
		NodeList countrys;
		NodeList lats;
		NodeList longs;
		NodeList names;
		NodeList contructors;

		temporal = (Element) datas.item(0);

		countrys = temporal.getElementsByTagName("country");
		lats = temporal.getElementsByTagName("lat");
		longs = temporal.getElementsByTagName("long");

		for (int i = 0; i < countrys.getLength(); i++) {
			if (countrys.item(i).getNodeName().equals("country")) {
				System.out.println("Country: " + countrys.item(i).getFirstChild().getNodeValue());
				System.out.println("lat: " + lats.item(i).getFirstChild().getNodeValue());
				System.out.println("long: " + longs.item(i).getFirstChild().getNodeValue());
			}
		}

		contructors = temporal.getElementsByTagName("Constructor");
		for (int j = 0; j < contructors.getLength(); j++) {
			temporal = (Element) contructors.item(j);
			names = temporal.getElementsByTagName("name");
			for (int k = 0; k < names.getLength(); k++) {
				System.out.println("ConstrucName: " + names.item(k).getFirstChild().getNodeValue());
			}
		}
	}

	public static void main(String[] args) {
		String ruta = "C:\\githubAlvaro\\AccesoDatos-main\\Tema1\\Repaso2\\Carreras.XML";
		Document doc = creaArbol(ruta);
		CircuitIdD(doc);
		System.out.println("--------------------------------");
		CountryLarLongContructorName(doc);
	}
}
