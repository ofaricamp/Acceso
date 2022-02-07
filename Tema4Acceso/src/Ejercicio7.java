import java.sql.SQLException;

public class Ejercicio7 {

	Ejercicio1 ejercicio1 = new Ejercicio1();
	Ejercicio2 ejercicio2 = new Ejercicio2();
	Ejercicio3 ejercicio3 = new Ejercicio3();
	Ejercicio4 ejercicio4 = new Ejercicio4();
	Ejercicio5 ejercicio5 = new Ejercicio5();
	Ejercicio6 ejercicio6 = new Ejercicio6();
	
	public void pruebas() throws SQLException {
		long tiempo = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			//ejercicio2.DarDeAltaAlumno("Alváro", "Virgolini", 500, 20);	
			ejercicio6.sentenciaPreparada("%a%",178);
		}
		tiempo = (long) (tiempo - System.currentTimeMillis());
	}
	public static void main(String[] args) throws SQLException {
		Ejercicio7 ej7 = new Ejercicio7();
		ej7.pruebas();
		
	}
}
