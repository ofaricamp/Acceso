import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio3 {
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
	
	public void DarDeBajaAlumno(int IdAlumnos) throws SQLException{

		String query = "DELETE FROM alumnos WHERE codigo = "+IdAlumnos;
		System.out.println(query);
		this.ejecutadorDeQuerys(query);
	}
	
	public void DarDeBajaAsignatura(int idAsignatura) throws SQLException {
		
		String query = "DELETE FROM asignaturas WHERE COD=\""+idAsignatura+"\"";
		System.out.println(query);
		this.ejecutadorDeQuerys(query);
	}
	
	public static void main(String[] args) throws SQLException {
		Ejercicio3 ej = new Ejercicio3();
		ej.DarDeBajaAlumno(12);
		
		
	}
}
