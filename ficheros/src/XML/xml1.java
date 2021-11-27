package XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class xml1 {
	public Document creaArbol(String ruta) {
	    Document doc=null;
	try {
	        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
	factoria.setIgnoringComments(true);
	        DocumentBuilder builder = factoria.newDocumentBuilder();
	doc=builder.parse(ruta);
	    } catch (Exception e) {
	        System.out.println("Error generando el �rbol DOM: "+e.getMessage());
	    }
	return doc;
	}
	
	public static void main(String[] args) {
	xml1 dom = new xml1();
	String ruta = "C:\\DirectorioPadre\\peliculas.xml";
	Document doc = dom.creaArbol(ruta);
	System.out.println("No peto");
	}

}
