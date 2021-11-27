package XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xml3 {
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
	public void getTituloYDirector(Document document) {
		NodeList titulos = document.getElementsByTagName("titulo");
		Element padre;
		NodeList directores;
		NodeList nombres;
		NodeList apellidos;
		for (int i = 0; i < titulos.getLength(); i++) {
			padre = (Element)titulos.item(i).getParentNode();
			System.out.println("--------------------------------");
			System.out.println("Titulo: "+titulos.item(i).getFirstChild().getNodeValue());
			directores = padre.getElementsByTagName("director");
			nombres = padre.getElementsByTagName("nombre");
			apellidos = padre.getElementsByTagName("apellido");
			//System.out.println(directores.getLength()+" "+nombres.getLength()+apellidos.getLength());
			for (int j = 0; j < directores.getLength(); j++) {
				System.out.println("Nombre: "+nombres.item(j).getFirstChild().getNodeValue()+
						"\tApellido: "+apellidos.item(j).getFirstChild().getNodeValue());
			}
			//for (int k = 0; k < apellidos.getLength(); k++) {
			//	padre =(Element)apellidos.item(k).getParentNode();
			//	System.out.println("Apellido Director: "+apellidos.item(k).getFirstChild().getNodeValue());
			//}
		}
	}
	
	public static void main(String[] args) {
		xml3 dom = new xml3();
		String ruta = "C:\\DirectorioPadre\\peliculas.xml";
		Document document =  dom.creaArbol(ruta);
		dom.getTituloYDirector(document);
	}
}
