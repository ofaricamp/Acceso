import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio1 {

	public Connection conexion;

	public void abrirConexion(String bd, String servidor, String usuario, String password) {
		try {
			String url = String.format("jdbc:mariadb://%s:3306/%s", servidor, bd);
			this.conexion = DriverManager.getConnection(url, usuario, password); // Establecemos la conexión con la
																					// BD
			if (this.conexion != null)
				System.out.println("Conectado a la base de datos " + bd + " en " + servidor);
			else
				System.out.println("No se ha conectado a la base de datos " + bd + " en " + servidor);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getLocalizedMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Código error: " + e.getErrorCode());
		}
	}

	public void cerrarConexion() {
		try {
			this.conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión: " + e.getLocalizedMessage());
		}

	}

	public void NombresDeLaDataBase(String cadena) throws SQLException {
		int cont = 0;
		String query = "Select nombre from alumnos where nombre like '%" + cadena + "%'";
		abrirConexion("add", "localhost", "root", "");
		Statement stm = conexion.createStatement();
		ResultSet rs = stm.executeQuery(query);
		while (rs.next()) {
			System.out.println("Nombre: " + rs.getString("nombre"));
			cont++;
		}
		stm.close();
		cerrarConexion();
		System.out.println("Número de Resultados: " + cont);
	}

	public static void main(String[] args) throws SQLException {
		Ejercicio1 p = new Ejercicio1();
		p.NombresDeLaDataBase("J");
		System.out.println("----------------------------------------------");
		p.NombresDeLaDataBase("F");
	}
}
