package Jason;

import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class ejercicio3 {
	static ejercicio1 p = new ejercicio1();

	public ArrayList<String> predicciones(double lon, double lat,int cantidadDeCiudades) {
		String url = "http://api.openweathermap.org/data/2.5/find?lat="+lat+"&lon="+lon+"&cnt="+cantidadDeCiudades+"&APPID=8f8dccaf02657071004202f05c1fdce0"; 
		JsonObject raiz = p.leeJSON(url).asJsonObject();
		JsonArray lista = raiz.getJsonArray("list");
		JsonObject datos, descripcion;
		JsonArray weather;
		ArrayList<String> tiempo = new ArrayList<>();
		for (int i = 0; i < lista.size(); i++) {
			datos = lista.getJsonObject(i);
			weather = datos.getJsonArray("weather");
			for (int j = 0; j < weather.size(); j++) {
			
				tiempo.add(weather.getJsonObject(j).getString("description"));
			}
		}
		return tiempo;
	}

	public static void main(String[] args) {
		ejercicio3 r = new ejercicio3();
		ArrayList<String> tiempoResult = r.predicciones(-8.7226, 42.2328, 10);
		for (String tiempo : tiempoResult) {
			System.out.println(tiempo);
			System.out.println("------------------");
		}
	}
}
