package XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xml2 {
	
	public Document creaArbol(String ruta) {
		Document doc = null;
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			factoria.setIgnoringComments(true);
			DocumentBuilder builder = factoria.newDocumentBuilder();
			doc = builder.parse(ruta);
		} catch (Exception e) {
			System.out.println("Error generando el arbol DOM: "+e.getMessage());
		}
		return doc;
	}

	public void getTitulo(Document doc, String cad) {
		NodeList pelis = doc.getElementsByTagName("titulo");
		for (int i = 0; i < pelis.getLength(); i++) {
			if (pelis.item(i).getFirstChild().getNodeValue().contains(cad)) {
				System.out.println(pelis.item(i).getFirstChild().getNodeValue());
			}
		}
	}
	
	public void getTituloFor(Document doc) {
		Node raiz = doc.getFirstChild();
		NodeList datos;
		NodeList nodosHijos = raiz.getChildNodes();
		for (int i = 0; i < nodosHijos.getLength(); i++) {
			if (nodosHijos.item(i).getNodeName().equals("pelicula")) {
				datos = nodosHijos.item(i).getChildNodes();
				for (int j = 0; j < datos.getLength(); j++) {
					if (datos.item(j).getNodeName().equals("titulo")) {
						System.out.println(datos.item(j).getFirstChild().getNodeValue());
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		xml2 dom = new xml2();
		String ruta = "C:\\DirectorioPadre\\peliculas.xml";
		Document doc = dom.creaArbol(ruta);
		dom.getTituloFor(doc);
		System.out.println("--------------------------------");
		dom.getTitulo(doc, "n");
	}
}

