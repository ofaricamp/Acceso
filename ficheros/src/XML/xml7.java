package XML;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class xml7 {

	public void recorreArbol(Document document) {
		
	}
	
	public void addAtributos(Document document,String titulo, String atributo) {
		Boolean existe = false;
		ArrayList<String> atributos = new ArrayList();
		NodeList titulos = document.getElementsByTagName("titulo");
		for (int i = 0; i < titulos.getLength(); i++) {	
			if (!atributos.contains(atributo)) {
				
			}
			if (titulos.item(i).getFirstChild().getNodeValue().equals(titulo)) {
				
			}
		}
	}
	
	public void remueveAtributos(Document document,String titulo, String atributo) {
		
	}
	
	public static void main(String[] args) {
		xml1 creador = new xml1();
		String ruta = "C:\\DirectorioPadre\\peliculas.xml";
		Document document = creador.creaArbol(ruta);
	}
}
