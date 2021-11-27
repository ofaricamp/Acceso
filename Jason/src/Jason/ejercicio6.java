package Jason;

import javax.json.JsonObject;

public class ejercicio6 {
	static ejercicio1 p = new ejercicio1();
	public double devuelveLon(String ciudad) {
		String url = "http://api.openweathermap.org/data/2.5/weather?q="+ciudad+",es&lang=es&APPID=8f8dccaf02657071004202f05c1fdce0";
		JsonObject raiz = p.leeJSON(url).asJsonObject();
		JsonObject coord = raiz.getJsonObject("coord");
		
		
		return coord.getJsonNumber("lon").doubleValue();
	}
	public double devuelveLat(String ciudad) {
		String url = "http://api.openweathermap.org/data/2.5/weather?q="+ciudad+",es&lang=es&APPID=8f8dccaf02657071004202f05c1fdce0";
		JsonObject raiz = p.leeJSON(url).asJsonObject();
		JsonObject coord = raiz.getJsonObject("coord");
		
		
		return coord.getJsonNumber("lat").doubleValue();
	}

	 public double[]  devuelveCoord(String ciudad) {
		 String url = "http://api.openweathermap.org/data/2.5/weather?q="+ciudad+",es&lang=es&APPID=8f8dccaf02657071004202f05c1fdce0";
			JsonObject raiz = p.leeJSON(url).asJsonObject();
			JsonObject coord = raiz.getJsonObject("coord");
			
			return new  double[] {coord.getJsonNumber("lon").doubleValue(),coord.getJsonNumber("lat").doubleValue()};
	}
	public static void main(String[] args) {
		ejercicio6 h = new ejercicio6();
		int id = 3105976;
		String ciudad = "vigo";
		double[] coords = h.devuelveCoord(ciudad);
		System.out.println("lon: "+h.devuelveLon(ciudad)+"\nlat: "+h.devuelveLat(ciudad));
		System.out.println("------------------------------------------------------------");
		System.out.println("lon: "+coords[0]+"\nlat: "+coords[1]);
	}
}
