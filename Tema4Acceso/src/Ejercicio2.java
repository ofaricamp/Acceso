import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2 {
	
	Ejercicio1 ej1 = new Ejercicio1();

	public int ejecutadorDeQuerys(String query) {
		ej1.abrirConexion("add", "localhost", "root", "");
		Statement stm;
		int insert = -1;
		try {
			stm = ej1.conexion.createStatement();
			insert = stm.executeUpdate(query);
			ej1.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			ej1.cerrarConexion();
		}
		
		return insert;
	}
	
	public void DarDeAltaAlumno(String nombre,String apellido,int altura,int aula) throws SQLException{
		String query = "INSERT INTO alumnos(nombre,apellidos,altura,aula) VALUES (\""+nombre+"\", \""+apellido+" \","+
						altura+","+aula+")";
		//System.out.println(query);
		this.ejecutadorDeQuerys(query);
	}
	
	public void DarDeAltaAsignatura(String nombre) throws SQLException{
		String query = "INSERT INTO asignaturas(NOMBRE) VALUES \""+nombre+"\"";
		//System.out.println(query);
		this.ejecutadorDeQuerys(query);
	}
	public static void main(String[] args) throws SQLException {
		Ejercicio2 ej2 = new Ejercicio2();
		ej2.DarDeAltaAlumno("Alváro", "Virgolini", 500, 20);
	}
}
