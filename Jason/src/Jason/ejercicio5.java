package Jason;

import javax.json.JsonObject;

public class ejercicio5 {

	public String nombreCiudad(int id) {
		ejercicio1 p = new ejercicio1();
		String url = "http://api.openweathermap.org/data/2.5/weather?id="+id+"&lang=es&APPID=8f8dccaf02657071004202f05c1fdce0";
		return p.leeJSON(url).asJsonObject().getString("name");
	}
	public static void main(String[] args) {
		ejercicio5 v = new ejercicio5();
		int id = 3105976;
		System.out.println(v.nombreCiudad(id));
	}
}
