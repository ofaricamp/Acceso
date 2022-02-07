import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio9 {
	Ejercicio1 ej1 = new Ejercicio1();

	public void apartadoA(String bd) {
		DatabaseMetaData dbmt;
		ej1.abrirConexion("add", "localhost", "root", "");
		try {

			dbmt = ej1.conexion.getMetaData();

			System.out.println(dbmt.getDriverName());
			System.out.println(dbmt.getDriverVersion());
			System.out.println(dbmt.getURL());
			System.out.println(dbmt.getUserName());
			System.out.println(dbmt.getDatabaseProductName());
			System.out.println(dbmt.getSQLKeywords());

		} catch (SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		}
	}

	public void apartadoB(String bd) {
		DatabaseMetaData dbmt;
		ResultSet tablas;
		ej1.abrirConexion("add", "localhost", "root", "");
		try {
			dbmt = ej1.conexion.getMetaData();
			//tablas = dbmt.getTables(bd, null, null, null);
			tablas = dbmt.getCatalogs();
			while (tablas.next()) {
				System.out.println(tablas.getString("TABLE_CAT"));
			}
		} catch (

		SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		}
	}
	
	public void apartadoC(String bd) {
		DatabaseMetaData dbmt;
		ResultSet tablas;
		ej1.abrirConexion("add", "localhost", "root", "");
		try {
			dbmt = ej1.conexion.getMetaData();
			tablas = dbmt.getTables(bd, null, null, null);
			while (tablas.next()) {
				System.out.println("NOMBRE: "+tablas.getString("TABLE_NAME")+"\n Type: "+tablas.getString("TABLE_TYPE"));
			}
		} catch (

		SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		}
	}
	
	public void apartadoD(String bd) {
		DatabaseMetaData dbmt;
		ResultSet tablas;
		ej1.abrirConexion("add", "localhost", "root", "");
		try {
			dbmt = ej1.conexion.getMetaData();
			tablas = dbmt.getTables(bd, null, null, null);
			
			while (tablas.next()) {
				if (tablas.getString("TABLE_TYPE").equals("VIEW")) {
					System.out.println("NOME: "+tablas.getString("TABLE_NAME")+" Type: "+tablas.getString("TABLE_TYPE"));	
				}
			}
		} catch (

		SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		}
	}
	
	public void apartadoE(String bd) {
		DatabaseMetaData dbmt;
		ResultSet tablas,catalog;
		ej1.abrirConexion("add", "localhost", "root", "");
		try {
			dbmt = ej1.conexion.getMetaData();
			tablas = dbmt.getTables(bd, null, null, null);
			catalog = dbmt.getCatalogs();
			while (tablas.next()) {
				System.out.println("Catalog: "+catalog.getString("TABLE_CAT"));
				System.out.println("\nNOME: "+tablas.getString("TABLE_NAME")+" Type: "+tablas.getString("TABLE_TYPE"));	
			}
		} catch (

		SQLException e) {
			System.out.println("Error obteniendo datos " + e.getLocalizedMessage());
		}
	}
	
	public static void main(String[] args) {
		Ejercicio9 ej9 = new Ejercicio9();

		//ej9.apartadoA("add");
		//ej9.apartadoB("add");
		//ej9.apartadoC("add");
		//ej9.apartadoD("add");
		ej9.apartadoE("add");
	}
}
