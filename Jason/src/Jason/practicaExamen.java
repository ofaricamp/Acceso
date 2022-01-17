package Jason;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.net.ssl.HttpsURLConnection;

public class practicaExamen {
	public static JsonValue leeJSON(String ruta) {
		try {
		if (ruta.toLowerCase().startsWith("http://")) {
			return leerHttp(ruta);
		 } else if (ruta.toLowerCase().startsWith("https://")) {
			 return leerHttps(ruta);
		 } else {
			 return leerFichero(ruta);
		 }
		 } catch (IOException e) {
			 System.out.println("Error procesando documento Json " + e.getLocalizedMessage());
			 return null;
		 }
	}
	public static JsonValue leerHttp(String direccion) throws IOException {
			 URL url = new URL(direccion);
			 try (InputStream is = url.openStream(); JsonReader reader = Json.createReader(is)) {
				 return reader.read();
			  }
	}
	public static JsonValue leerHttps(String direccion) throws IOException {
			  URL url = new URL(direccion);
			  HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			 try (InputStream is = conn.getInputStream(); JsonReader reader = Json.createReader(is)) {
				 return reader.read();
			  } finally {
				  conn.disconnect();
			  }
	}
	public static JsonValue leerFichero(String ruta) throws FileNotFoundException {
		try (JsonReader reader = Json.createReader(new FileReader(ruta))) {
			return reader.read();
		/*
		 * JsonStructure jsonSt = reader.read();
		 * System.out.println(jsonSt.getValueType());
		 *
		 * JsonObject jsonObj = reader.readObject();
		 * System.out.println(jsonObj.getValueType());
		 *
		 * JsonArray jsonArr = reader.readArray();
		 * System.out.println(jsonArr.getValueType());
		 */
		 }
	}
	
	public static void nombrej(String ruta) {
		JsonObject raiz = leeJSON(ruta).asJsonObject();
		 System.out.println("Title: " + raiz.getString("title"));
		 System.out.println("Id: "+raiz.getInt("id"));
		 System.out.println("Score: "+raiz.getJsonNumber("score").doubleValue());
	}
	
	public static void finEmisionj (String ruta) {
		JsonObject raiz = leeJSON(ruta).asJsonObject();
		JsonObject aired = raiz.getJsonObject("aired");
		JsonObject prop = aired.getJsonObject("prop");
		JsonObject to = prop.getJsonObject("to");
		System.out.println("Year: "+to.getInt("year"));
		System.out.println("Day: "+to.getInt("day"));
	}
	
	public static void comparadorDeGenerosj(String ruta1, String ruta2) {
		JsonObject raiz = leeJSON(ruta1).asJsonObject();
		JsonObject raiz2 = leeJSON(ruta2).asJsonObject();
		
		if ((raiz.getJsonArray("genres").size()) > (raiz2.getJsonArray("genres").size())) {
			generosj(ruta1);
		} else {
			generosj(ruta2);	
		}
	}
	
	public static void generosj(String ruta) {
		JsonObject raiz = leeJSON(ruta).asJsonObject();
		JsonArray generos = raiz.getJsonArray("genres");
		JsonObject datos;
		System.out.println("Title: " + raiz.getString("title"));
		System.out.println("Numero De Generos: "+generos.size());
		for (int i = 0; i < generos.size(); i++) {
			datos = generos.getJsonObject(i);
			System.out.println("Genero: "+datos.getString("name")+" Id: "+datos.getInt("id"));
		}
	}
	public static void main(String[] args) {
		String ruta = "C:\\Nueva carpeta\\RurouniKenshin.JSON";
		String ruta2 = "C:\\Nueva carpeta\\CowboyBebop.JSON";
		nombrej(ruta);
		System.out.println("------------------------------------------------");
		finEmisionj(ruta);
		System.out.println("-------------------------------------------------");
		comparadorDeGenerosj(ruta, ruta2);
	}
}
