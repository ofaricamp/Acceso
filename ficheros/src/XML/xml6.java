package XML;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class xml6 {

	public void buscaGenero(Document document) {
		ArrayList<String> generos = new ArrayList();
		NodeList peliculas = document.getElementsByTagName("pelicula");
		for (int i = 0; i < peliculas.getLength(); i++) {
			Element pelicula = (Element)peliculas.item(i);
			if (pelicula.hasAttribute("genero")) {
				if(!generos.contains(pelicula.getAttribute("genero"))) {
					generos.add(pelicula.getAttribute("genero"));
				}
			}
		}
		for (int i = 0; i < generos.size(); i++) {
			System.out.println("Genero:"+generos.get(i));
		}
		System.out.println("Hay un total de "+generos.size()+" generos distintos");
	}
	
	public static void main(String[] args) {
		xml1 creador = new xml1();
		xml6 dom = new xml6();
		String ruta = "C:\\DirectorioPadre\\peliculas.xml";
		Document document =creador.creaArbol(ruta);
		dom.buscaGenero(document);
	}
}

