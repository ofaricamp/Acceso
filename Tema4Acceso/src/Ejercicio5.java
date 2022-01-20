import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio5 {

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
	
	public String devuelveAulas(String query) {
		ej1.abrirConexion("add", "localhost", "root", "");
		Statement stm;
		ResultSet rs;
		String aula = "";
		try {
			stm = ej1.conexion.createStatement();
			rs = stm.executeQuery(query);
			
			while (rs.next()) {
				aula += "\n" + rs.getString("nombreAula");
				
			}
			ej1.cerrarConexion();
		} catch (SQLException w) {
			w.printStackTrace();
			ej1.cerrarConexion();
		}
		return aula;
		
	}
	
	public void nombreDeAulasConAlumnos() throws SQLException {
		//SELECT DISTINCT aulas.nombreAula FROM aulas INNER JOIN alumnos ON aulas.numero = alumnos.aula
		String query = "SELECT DISTINCT aulas.nombreAula FROM aulas INNER JOIN alumnos ON aulas.numero = alumnos.aula";
		System.out.println(query);
		ej1.abrirConexion("add", "localhost", "root", "");
		Statement stm = ej1.conexion.createStatement();
		ResultSet rs = stm.executeQuery(query);
		while (rs.next()) {
			System.out.println("--------------------");
			System.out.println(rs.getString("nombreAula"));
		}
		//stm.execute(query);
		stm.close();
		ej1.cerrarConexion();
	}
	
	public void alumnosQueAprobaron() throws SQLException {
		String query = "SELECT DISTINCT alumnos.nombre,asignaturas.NOMBRE,notas.NOTA \r\n"
				+ "FROM alumnos,asignaturas,notas \r\n"
				+ "WHERE notas.NOTA >= 5 \r\n"
				+ "AND alumnos.codigo = notas.alumno\r\n"
				+ "AND asignaturas.COD = notas.asignatura";
		System.out.println(query);
		ej1.abrirConexion("add","localhost","root","");
		Statement stm = ej1.conexion.createStatement();
		ResultSet rs = stm.executeQuery(query);
		while (rs.next()) {
			System.out.println("--------------------");
			System.out.println("Nombre: "+rs.getString("nombre"));
			System.out.println("Asignatura: "+rs.getString("asignaturas.NOMBRE"));
			System.out.println("Nota: "+rs.getInt("NOTA"));
		}
		stm.close();
		ej1.cerrarConexion();
	}
	
	public void asignaturasSinAlumnos() throws SQLException{
		String query = "SELECT asignaturas.NOMBRE FROM asignaturas \r\n"
				+ "WHERE asignaturas.COD NOT IN  (SELECT DISTINCT asignatura FROM notas)";
		System.out.println(query);
		ej1.abrirConexion("add", "localhost", "root", "");
		Statement stm = ej1.conexion.createStatement();
		ResultSet rs = stm.executeQuery(query);
		while (rs.next()) {
			System.out.println("--------------------");
			System.out.println("Asignatura: "+rs.getString("NOMBRE"));
		}
		stm.close();
		ej1.cerrarConexion();
	}
	
	public static void main(String[] args) throws SQLException {
		Ejercicio5 ej5 = new Ejercicio5();
		//ej5.nombreDeAulasConAlumnos();
		//ej5.alumnosQueAprobaron();
		ej5.asignaturasSinAlumnos();
	}
}
