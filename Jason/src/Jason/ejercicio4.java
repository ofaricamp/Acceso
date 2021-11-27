package Jason;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class ejercicio4 {

	static ejercicio1 p = new ejercicio1();
	
	public JsonObject devuelveID(String ciudad) {
		String url = "http://api.openweathermap.org/data/2.5/weather?q="+ciudad+",es&lang=es&APPID=8f8dccaf02657071004202f05c1fdce0";
		JsonObject raiz = p.leeJSON(url).asJsonObject();
		JsonArray weather = raiz.getJsonArray("weather");
		JsonObject id;
		for (int i = 0; i < weather.size(); i++) {
			id = weather.getJsonObject(i);
			return id;
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ejercicio4 d = new ejercicio4();
		String ciudad = "vigo";
		String url = "http://api.openweathermap.org/data/2.5/weather?q="+ciudad+",es&lang=es&APPID=8f8dccaf02657071004202f05c1fdce0";
		//JsonObject raiz = p.leeJSON(url).asJsonObject();
		
		
		System.out.println(d.devuelveID("vigo").getInt("id"));
		System.out.println(p.leeJSON(url).asJsonObject().getInt("id"));
	}

}
