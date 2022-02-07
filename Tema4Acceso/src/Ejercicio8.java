
public class Ejercicio8 {
	
	public void addTable(String tabla,String nombreDelCampo,String tipoDeDato,String propiedades) {
		String query = "CREATE OR REPLACE TABLE "+tabla+"("+nombreDelCampo+" "+tipoDeDato+"("+propiedades+")";
		System.out.println(query);
		
	}
	public static void main(String[] args) {
		
	}
}
