import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio4 {
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
	
	public void actualizarAlumnos(String nombre,String apellido,int altura,int aula, int codigo) throws SQLException {
		String query = "UPDATE alumnos SET nombre =\""+nombre+"\",apellidos =\""+apellido+"\",altura="+altura+", aula="+aula+" WHERE codigo="+codigo;
		//System.out.println(query);
		this.ejecutadorDeQuerys(query);
	}
	
	public void actualizarAsignaturas(String asignatura,int codigo) throws SQLException {
		String query = "UPDATE asignaturas set nombre=\""+asignatura+"\" WHERE COD = "+codigo;
		this.ejecutadorDeQuerys(query);
	}
	
	public static void main(String[] args) throws SQLException {
		Ejercicio4 ej4 = new Ejercicio4();
		ej4.actualizarAlumnos("HALBARO", "Virgolini", 199, 20, 10);
	}
}
