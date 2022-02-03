import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicios {

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

	public int ejecutadorDeQuerys(String query) {
		abrirConexion("add", "localhost", "root", "");
		int insert = -1;

		try (Statement stm = conexion.createStatement();) {

			insert = stm.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			cerrarConexion();
		}
		return insert;
	}

	public void Ejercicio1(String cadena) throws SQLException {
		int cont = 0;
		String query = "Select nombre from alumnos where nombre like '%" + cadena + "%'";
		abrirConexion("add", "localhost", "root", "");
		try (Statement stm = conexion.createStatement();) {
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				System.out.println("Nombre: " + rs.getString("nombre"));
				cont++;
			}
			stm.close();
			cerrarConexion();
			System.out.println("Número de Resultados: " + cont);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
	}

	public int Ejercicio2a(String nombre, String apellido, int altura, int aula) throws SQLException {
		String query = "INSERT INTO alumnos(nombre,apellidos,altura,aula) VALUES (\"" + nombre + "\", \"" + apellido
				+ " \"," + altura + "," + aula + ")";
		System.out.println(query);
		return ejecutadorDeQuerys(query);

	}

	public int Ejercicio2b(String nombre) throws SQLException {
		String query = "INSERT INTO asignaturas(NOMBRE) VALUES \"" + nombre + "\"";
		System.out.println(query);
		return ejecutadorDeQuerys(query);
	}

	public int Ejercicio3a(int IdAlumnos) throws SQLException {
		String query = "DELETE FROM alumnos WHERE codigo = " + IdAlumnos;
		System.out.println(query);
		return ejecutadorDeQuerys(query);
	}

	public int Ejercicio3b(int idAsignatura) throws SQLException {
		String query = "DELETE FROM asignaturas WHERE COD=\"" + idAsignatura + "\"";
		System.out.println(query);
		return ejecutadorDeQuerys(query);
	}

	public int Ejercicio4a(String nombre, String apellido, int altura, int aula, int codigo) throws SQLException {
		String query = "UPDATE alumnos SET nombre =\"" + nombre + "\",apellidos =\"" + apellido + "\",altura=" + altura
				+ ", aula=" + aula + " WHERE codigo=" + codigo;
		System.out.println(query);
		return ejecutadorDeQuerys(query);
	}

	public int Ejercicio4b(String asignatura, int codigo) throws SQLException {
		String query = "UPDATE asignaturas set nombre=\"" + asignatura + "\" WHERE COD = " + codigo;
		return ejecutadorDeQuerys(query);
	}

	public String Ejercicio5a(String query) {
		abrirConexion("add", "localhost", "root", "");
		ResultSet rs;
		String aula = "";
		try (Statement stm = conexion.createStatement();) {
			rs = stm.executeQuery(query);
			while (rs.next()) {
				aula += "\n" + rs.getString("nombreAula");
			}

		} catch (SQLException w) {
			w.printStackTrace();
			cerrarConexion();
		} finally {
			cerrarConexion();
		}
		return aula;
	}

	public void Ejercicio5b() throws SQLException {
		String query = "SELECT DISTINCT aulas.nombreAula FROM aulas INNER JOIN alumnos ON aulas.numero = alumnos.aula";
		System.out.println(query);
		abrirConexion("add", "localhost", "root", "");
		try (Statement stm = conexion.createStatement();) {
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				System.out.println("--------------------");
				System.out.println(rs.getString("nombreAula"));
			}
			stm.execute(query);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			cerrarConexion();
		} finally {
			cerrarConexion();
		}
	}

	private PreparedStatement ps = null;

	public void Ejercicio6a(String patron, int valor) {
		String query = "Select nombre,altura from alumnos where nombre LIKE ? AND altura > ?";
		try {
			conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/add?useServerPrepStmts=true", "root",
					"");

			if (ps == null) {
				ps = conexion.prepareStatement(query);
			}
			System.out.println(query);
			ps.setString(1, patron);
			ps.setInt(2, valor);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Nombre: " + rs.getString("nombre") + " Altura: " + rs.getInt("altura"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cerrarConexion();
		} finally {
			cerrarConexion();
		}
	}

	public void Ejercicio6b(String patron, int valor) {
		abrirConexion("add", "localhost", "root", "");
		try (Statement stm = conexion.createStatement();) {
			String query = "Select nombre,altura from alumnos where nombre like '%" + patron + "%' AND altura >"
					+ valor;
			System.out.println(query);

			ResultSet rs = stm.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			cerrarConexion();
		} finally {
			cerrarConexion();
		}
	}

	public int ejercicio8(String tabla, String nombreDelCampo, String tipoDeDato, String propiedades) {
		String query = "CREATE OR REPLACE TABLE " + tabla + "(" + nombreDelCampo + " " + tipoDeDato + "(" + propiedades
				+ ")";
		System.out.println(query);
		return ejecutadorDeQuerys(query);
	}

	public void Ejercicio9apartadoA(String bd) {
		DatabaseMetaData dbmt;
		abrirConexion("add", "localhost", "root", "");
		try {

			dbmt = conexion.getMetaData();

			System.out.println(dbmt.getDriverName());
			System.out.println(dbmt.getDriverVersion());
			System.out.println(dbmt.getURL());
			System.out.println(dbmt.getUserName());
			System.out.println(dbmt.getDatabaseProductName());
			System.out.println(dbmt.getSQLKeywords());

		} catch (SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		} finally {
			cerrarConexion();
		}
	}

	public void Ejercicio9apartadoB(String bd) {
		DatabaseMetaData dbmt;
		ResultSet tablas;
		abrirConexion("add", "localhost", "root", "");
		try {
			dbmt = conexion.getMetaData();
			// tablas = dbmt.getTables(bd, null, null, null);
			tablas = dbmt.getCatalogs();
			while (tablas.next()) {
				System.out.println(tablas.getString("TABLE_CAT"));
			}
		} catch (SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		} finally {
			cerrarConexion();
		}
	}

	public void Ejercicio9apartadoC(String bd) {
		DatabaseMetaData dbmt;
		ResultSet tablas;
		abrirConexion("add", "localhost", "root", "");
		try {
			dbmt = conexion.getMetaData();
			tablas = dbmt.getTables(bd, null, null, null);
			while (tablas.next()) {
				System.out.println(
						"NOMBRE: " + tablas.getString("TABLE_NAME") + "\n Type: " + tablas.getString("TABLE_TYPE"));
			}
		} catch (

		SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		}
	}

	public void Ejercicio9apartadoD(String bd) {
		DatabaseMetaData dbmt;
		ResultSet tablas;
		abrirConexion("add", "localhost", "root", "");
		try {
			dbmt = conexion.getMetaData();
			tablas = dbmt.getTables(bd, null, null, null);

			while (tablas.next()) {
				if (tablas.getString("TABLE_TYPE").equals("VIEW")) {
					System.out.println(
							"NOME: " + tablas.getString("TABLE_NAME") + " Type: " + tablas.getString("TABLE_TYPE"));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		} finally {
			cerrarConexion();
		}
	}

	public void Ejercicio9apartadoE(String bd) {
		DatabaseMetaData dbmt;
		ResultSet tablas, catalog;
		abrirConexion("add", "localhost", "root", "");
		try {
			dbmt = conexion.getMetaData();
			tablas = dbmt.getTables(bd, null, null, null);
			catalog = dbmt.getCatalogs();
			while (tablas.next()) {
				System.out.println("Catalog: " + catalog.getString("TABLE_CAT"));
				System.out.println(
						"\nNOME: " + tablas.getString("TABLE_NAME") + " Type: " + tablas.getString("TABLE_TYPE"));
			}
		} catch (SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		} finally {
			cerrarConexion();
		}
	}
	
	public void Ejercicio9apartadoF(String bd) {
		DatabaseMetaData dbmt;
		abrirConexion("add", "localhost", "root", "");
		try {
			dbmt = conexion.getMetaData();
			ResultSet rs = dbmt.getProcedures(bd, null, null);
			while (rs.next()) {
				System.out.println(rs.getString("PROCEDURE_NAME"));
			}
		} catch (SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		} finally {
			cerrarConexion();
		}
	}
	
	public void Ejercicio9apartadoG(String bd) {
		DatabaseMetaData dbtm;
		abrirConexion("add", "localhost", "root", "");
		try {
			dbtm = conexion.getMetaData();
			ResultSet rs = dbtm.getColumns(bd, null, null, null);
			while (rs.next()) {
				if (rs.getString("COLUMN_NAME").startsWith("a")) {
					System.out.println(rs.getString("COLUMN_RELATIVE"));
					System.out.println(rs.getString("COLUMN_NAME"));
					System.out.println(rs.getString("COLUMN_TYPE"));
					System.out.println(rs.getString("COLUMN_SIZE"));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		}finally {
			cerrarConexion();
		}
	}

	public static void main(String[] args) throws SQLException {
		Ejercicios p = new Ejercicios();
		//p.Ejercicio1("J");
		//System.out.println("----------------------------------------------");
		//p.Ejercicio1("F");
		//p.Ejercicio2a("Alváro", "Virgolini", 500, 20);
		p.Ejercicio9apartadoG("add");
	}
}
