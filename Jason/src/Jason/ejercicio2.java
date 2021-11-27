package Jason;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class ejercicio2 {

	static ejercicio1 e = new ejercicio1();
	public JsonObject Descripcion(String ciudad) {
		String url = "http://api.openweathermap.org/data/2.5/weather?q="+ciudad+",es&lang=es&APPID=8f8dccaf02657071004202f05c1fdce0";
		JsonObject raiz = e.leeJSON(url).asJsonObject();
		JsonArray weather = raiz.getJsonArray("weather");
		JsonObject description;
		
		for (int i = 0; i < weather.size(); i++) {
			return description = weather.getJsonObject(i);
		}
		
		return null;
	}
	public static void main(String[] args) {
		ejercicio2 c = new ejercicio2();
		String ciudad = "vigo";
		
		System.out.println(c.Descripcion(ciudad).getString("description"));
	}
}
