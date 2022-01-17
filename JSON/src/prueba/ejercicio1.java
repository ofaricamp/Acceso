package prueba;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.net.ssl.HttpsURLConnection;

public class ejercicio1 {
	public JsonValue leeJSON(String ruta) {
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
	public JsonValue leerHttp(String direccion) throws IOException {
			 URL url = new URL(direccion);
			 try (InputStream is = url.openStream(); JsonReader reader = Json.createReader(is)) {
				 return reader.read();
			  }
	}
	public JsonValue leerHttps(String direccion) throws IOException {
			  URL url = new URL(direccion);
			  HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			 try (InputStream is = conn.getInputStream(); JsonReader reader = Json.createReader(is)) {
				 return reader.read();
			  } finally {
				  conn.disconnect();
			  }
	}
	public JsonValue leerFichero(String ruta) throws FileNotFoundException {
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
	public JsonObject prediccionMeteorilogica(String ciudad) {
		String obj ="http://api.openweathermap.org/data/2.5/weather?q="+ciudad+",es&lang=es&APPID=8f8dccaf02657071004202f05c1fdce0";
		
		return null;
	}
	public static void main(String[] args) {
		//Crea un método, usando Open Weather Map, que dada una localidad devuelva un JsonObject con
		//los datos devueltos de las predicciones meteorológicas.
	}
}
