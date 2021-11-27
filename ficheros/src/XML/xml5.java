package XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class xml5 {

	public Document creaArbol(String ruta) {
		Document doc = null;
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			factoria.setIgnoringComments(true);
			DocumentBuilder builder = factoria.newDocumentBuilder();
			doc = builder.parse(ruta);
		} catch (Exception e) {
			System.out.println("Error generando el �rbol");
		}
		return doc;
	}
	
	public void getPeliculasConNDirectores(Document document,int n) {
		NodeList peliculas = document.getElementsByTagName("pelicula");
		NodeList directores;
		
		for (int i = 0; i < peliculas.getLength(); i++) {
			directores = ((Element)peliculas.item(i)).getElementsByTagName("director");
			//System.out.println(directores.getLength());
			if(directores.getLength() >= n) {
				//for (int j = 0; j < directores.getLength(); j++) {
					NodeList titulos = ((Element)peliculas.item(i)).getElementsByTagName("titulo");
					if (titulos.getLength() > 0) {
						System.out.println(titulos.item(0).getFirstChild().getNodeValue());
					}
				//}
			
			}
		}
	}
	public static void main(String[] args) {
		xml5 dom = new xml5();
		String ruta = "C:\\DirectorioPadre\\peliculas.xml";
		Document document =  dom.creaArbol(ruta);
		System.out.println("Prueba 1");
		dom.getPeliculasConNDirectores(document,1);
		System.out.println("----------------------------------------------");
		System.out.println("Prueba 2");
		dom.getPeliculasConNDirectores(document,2);
		System.out.println("--------------------------------------------------");
		System.out.println("Prueba 3");
		dom.getPeliculasConNDirectores(document,3);
	}
}

