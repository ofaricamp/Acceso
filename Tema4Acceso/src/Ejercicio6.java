import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio6 {
	
	Ejercicio1 ej1 = new Ejercicio1();
	
	private PreparedStatement ps=null;
	
	public void sentenciaPreparada(String patron, int valor) {
		String query = "Select nombre,altura from alumnos where nombre LIKE ? AND altura > ?";
		try {
			ej1.conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/add?useServerPrepStmts=true","root", "");
			
			if (ps == null) {
				ps = ej1.conexion.prepareStatement(query);
			}
			System.out.println(query);
			ps.setString(1, patron);
			ps.setInt(2, valor);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Nombre: "+rs.getString("nombre")+" Altura: "+rs.getInt("altura"));
			}
			ej1.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			ej1.cerrarConexion();
		}
	}
	
	public void sentenciaNOPreparada(String patron, int valor) {
		ej1.abrirConexion("add", "localhost", "root", "");
		Statement stm;
		try {
			String query = "Select nombre,altura from alumnos where nombre like '%" + patron + "%' AND altura >"+valor;
			System.out.println(query);
			stm = ej1.conexion.createStatement();
			ResultSet rs = stm.executeQuery(query);
			ej1.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			ej1.cerrarConexion();
		}
	}
	
	public static void main(String[] args) {
		Ejercicio6 ej6 = new Ejercicio6();
		ej6.sentenciaPreparada("%ar%",178);
		
	}
}
