package XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
 * DOM. Crea el método nombred que muestre el titulo del anime (title) junto con su atributo release y su URL (url). 
DOM.  Crea el método finEmisiond que muestre, en este orden, el año (year) y el día (day) de finalización de emisión (to dentro de prop dentro de aired). 

DOM. Crea el método generosd que, del anime que tiene más géneros (genre), muestre el nombre del Anime (title), el número de géneros que tiene y en una línea para cada género: el nombre del genero (name) y su identificador (id). 
*/
public class examenReapaso {
	
	public static Document creaArbol(String ruta) {
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

	public static void nombred(Document doc) {
		//Element animes = (Element) doc.getElementsByTagName("anime");
		NodeList titles = doc.getElementsByTagName("title");
		NodeList url = doc.getElementsByTagName("url");
		Element titulo;
		for (int i = 0; i < titles.getLength(); i++) {
			titulo = (Element) titles.item(i);
			System.out.println("Title: "+titles.item(i).getFirstChild().getNodeValue());
			System.out.println("Release: "+titulo.getAttribute("release"));
			System.out.println("URL: "+url.item(i).getFirstChild().getNodeValue()+"\n");
		}
	}
	
	public static void finEmisiond(Document doc) {
		NodeList aireds = doc.getElementsByTagName("aired");
		NodeList prop;
		NodeList to;
		NodeList año,dia;
		Element elementTemporal;
		for (int i = 0; i < aireds.getLength(); i++) {
			elementTemporal = (Element) aireds.item(i);
			prop = elementTemporal.getElementsByTagName("prop");
			for (int j = 0; j < prop.getLength(); j++) {
				elementTemporal = (Element) prop.item(i);
				to = elementTemporal.getElementsByTagName("to");
				for (int k = 0; k < to.getLength(); k++) {
					elementTemporal = (Element)to.item(i);
					año = elementTemporal.getElementsByTagName("year");
					dia = elementTemporal.getElementsByTagName("day");
					System.out.println("Año: "+año.item(k).getFirstChild().getNodeValue()+
							" - Dia:"+dia.item(k).getFirstChild().getNodeValue());
				}
			}
		}
	}
	//DOM. Crea el método generosd que, del anime que tiene más géneros (genre), 
	//muestre el nombre del Anime (title), el número de géneros que tiene y en una línea para 
	//cada género: el nombre del genero (name) y su identificador (id). 
	public static void comparagenerosgeneros(Document doc, Document doc2) {
		if ((doc.getElementsByTagName("genre").getLength()) > (doc2.getElementsByTagName("genre").getLength())) {
			generosd(doc);
		}else {
			generosd(doc2);
		}
	}
	
	public static void generosd(Document doc) {
		NodeList titles = doc.getElementsByTagName("title");
		NodeList generos = doc.getElementsByTagName("genres");
		Element genero;
		NodeList name;
		for (int i = 0; i < generos.getLength(); i++) {
			genero = (Element)generos.item(i);
			name = genero.getElementsByTagName("name");
			System.out.println("Title: "+titles.item(0).getFirstChild().getNodeValue());
			System.out.println("Numero de Generos: "+name.getLength());
			for (int j = 0; j < name.getLength(); j++) {
				genero =(Element) name.item(j).getParentNode();
				System.out.println("Name: "+name.item(j).getFirstChild().getNodeValue()+" ID: "+genero.getAttribute("id"));
			}
			
		}
	}
	
	public static void main(String[] args) {
		String ruta = "C:\\Nueva carpeta\\CowboyBebop.xml";
		String ruta2 = "C:\\Nueva carpeta\\RurouniKenshin.xml";
		Document doc = creaArbol(ruta);
		Document doc2 = creaArbol(ruta2);
		
		nombred(doc);
		finEmisiond(doc);		
		System.out.println("------------------------------------");

		nombred(doc2);
		finEmisiond(doc2);
		System.out.println("--------------------------------------");
		
		comparagenerosgeneros(doc, doc2);
	}
}
