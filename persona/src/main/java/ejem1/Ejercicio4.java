package ejem1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/deportistas")
public class Ejercicio4 {
	public Connection conexion;

	static ArrayList<Deportista> deportistas = new ArrayList<>();
	static DB baseDeDatos = new DB();
	
	
	@GET
	@Path("todos")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response Todos() {
		String query = "Select * from deportistas";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		//abrirConexion("ad_tema6","localhost","root","");
		try (Statement st = baseDeDatos.conexion.createStatement()){
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			
			while (datos.next()) {
				deportista = new Deportista(
						datos.getInt("id"),
						datos.getString("nombre"),
						datos.getInt("activo"),
						datos.getString("genero"),
						datos.getString("deporte"));
				
				this.deportistas.add(deportista);
			}
			return Response.ok(this.deportistas).build();
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response buscarID(@PathParam("id") int id) {
		String query = "Select * from deportistas where id="+id+"";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		try(Statement st = baseDeDatos.conexion.createStatement()) {
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			while (datos.next()) {
					deportista = new Deportista(
							datos.getInt("id"),
							datos.getString("nombre"),
							datos.getInt("activo"),
							datos.getString("genero"),
							datos.getString("deporte"));
					this.deportistas.add(deportista);
			}
			return Response.ok(this.deportistas).build();
			
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("deporte/{nombreDeporte}")
	@Produces ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response PorDeportes(@PathParam("nombreDeporte") String nombreDeporte) {
		String query = "Select * from deportistas where deporte = '"+nombreDeporte+"'";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		try (Statement st = baseDeDatos.conexion.createStatement()){
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			
			while (datos.next()) {
				deportista = new Deportista(
						datos.getInt("id"),
						datos.getString("nombre"),
						datos.getInt("activo"),
						datos.getString("genero"),
						datos.getString("deporte"));
				
			this.deportistas.add(deportista);
			}
			return Response.ok(this.deportistas).build();
			
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/activos")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response buscarActivos() {
		String query = "Select * from deportistas where activo = 1";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		try(Statement st = baseDeDatos.conexion.createStatement()) {
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			while (datos.next()) {
				deportista = new Deportista(
						datos.getInt("id"),
						datos.getString("nombre"),
						datos.getInt("activo"),
						datos.getString("genero"),
						datos.getString("deporte"));
				this.deportistas.add(deportista);
			}
			return Response.ok(this.deportistas).build();
			
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/retirados")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response buscarRetirados() {
		String query = "Select * from deportistas where activo = 0";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		try(Statement st = baseDeDatos.conexion.createStatement()) {
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			while (datos.next()) {
				deportista = new Deportista(
						datos.getInt("id"),
						datos.getString("nombre"),
						datos.getInt("activo"),
						datos.getString("genero"),
						datos.getString("deporte"));
				this.deportistas.add(deportista);
			}
			return Response.ok(this.deportistas).build();
			
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/masculinos")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response buscarMasculinos() {
		String query = "Select * from deportistas where genero = 'masculino'";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		try(Statement st = baseDeDatos.conexion.createStatement()) {
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			while (datos.next()) {
				deportista = new Deportista(
						datos.getInt("id"),
						datos.getString("nombre"),
						datos.getInt("activo"),
						datos.getString("genero"),
						datos.getString("deporte"));
				this.deportistas.add(deportista);
			}
			return Response.ok(this.deportistas).build();
			
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/femeninos")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response buscarFemeninos() {
		String query = "Select * from deportistas where genero = 'femenino'";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		try(Statement st = baseDeDatos.conexion.createStatement()) {
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			while (datos.next()) {
				deportista = new Deportista(
						datos.getInt("id"),
						datos.getString("nombre"),
						datos.getInt("activo"),
						datos.getString("genero"),
						datos.getString("deporte"));
				this.deportistas.add(deportista);
			}
			return Response.ok(this.deportistas).build();
			
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/xg")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response DeportesPorGenero() {
		ArrayList<Deportista> masculinos = new ArrayList<>();
		ArrayList<Deportista> femeninos = new ArrayList<>();
		ArrayList<ArrayList<Deportista>> todos = new ArrayList<>();
		String query = "Select * from deportistas";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		try(Statement st = baseDeDatos.conexion.createStatement()) {
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			while (datos.next()) {
				if (datos.getString("genero").equals("masculino")) {
					deportista = new Deportista(
							datos.getInt("id"),
							datos.getString("nombre"),
							datos.getInt("activo"),
							datos.getString("genero"),
							datos.getString("deporte"));
					masculinos.add(deportista);	
				}else {
					deportista = new Deportista(
							datos.getInt("id"),
							datos.getString("nombre"),
							datos.getInt("activo"),
							datos.getString("genero"),
							datos.getString("deporte"));
					femeninos.add(deportista);	
				}
				
			}
			todos.add(masculinos);
			todos.add(femeninos);
			return Response.ok(todos).build();
			
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	//http://localhos:8080/persona/rest/deportistas/deporte/baloncesto/activos
	@GET
	@Path("deporte/{nombreDeporte}/activos")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response ActivosPorDeporte(@PathParam("nombreDeporte") String nombreDeporte) {
		String query = "Select * from deportistas where deporte = '"+nombreDeporte+"' && activo = 1";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		try(Statement st = baseDeDatos.conexion.createStatement()) {
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			while (datos.next()) {
				deportista = new Deportista(
						datos.getInt("id"),
						datos.getString("nombre"),
						datos.getInt("activo"),
						datos.getString("genero"),
						datos.getString("deporte"));
				this.deportistas.add(deportista);
			}
			return Response.ok(this.deportistas).build();
			
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/sdepor")
	@Produces(MediaType.TEXT_PLAIN)
	public Response Contar() {
		String query = "Select * from deportistas";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		//abrirConexion("ad_tema6","localhost","root","");
		try (Statement st = baseDeDatos.conexion.createStatement()){
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			
			while (datos.next()) {
				deportista = new Deportista(
						datos.getInt("id"),
						datos.getString("nombre"),
						datos.getInt("activo"),
						datos.getString("genero"),
						datos.getString("deporte"));
				
				this.deportistas.add(deportista);
			}
			return Response.ok(this.deportistas.size()).type(MediaType.TEXT_PLAIN).build();
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/sdepor")
	@Produces(MediaType.TEXT_PLAIN)
	public Response listar() {
		ArrayList<String> deportes = new ArrayList<>();
		String query = "Select * from deportistas";
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		//abrirConexion("ad_tema6","localhost","root","");
		try (Statement st = baseDeDatos.conexion.createStatement()){
			ResultSet datos = st.executeQuery(query);
			Deportista deportista;
			
			while (datos.next()) {
				/*deportista = new Deportista(
						datos.getInt("id"),
						datos.getString("nombre"),
						datos.getInt("activo"),
						datos.getString("genero"),
						datos.getString("deporte"));*/
				if (deportes.contains(datos.getString("deporte"))) {
					deportes.add(datos.getString("deporte"));
				}
			}
			return Response.ok(deportes).type(MediaType.TEXT_PLAIN).build();
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	//SELECT  DISTINCT  deporte from deportistas ORDER BY deporte ASC
	
	@POST
	@Path("insertar")
	@Consumes ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces (MediaType.TEXT_PLAIN)
	public Response crearDeportista(ArrayList<Deportista> newDeportistas) {
		baseDeDatos.abrirConexion("ad_tema6", "localhost", "root", "");
		try (Statement stm = baseDeDatos.conexion.createStatement()){
			int rs;
			for (int i = 0; i < newDeportistas.size(); i++) {
				rs = stm.executeUpdate("Insert into deportistas values("+newDeportistas.get(i).getId()+
						",'"+newDeportistas.get(i).getNombre()+"',"+newDeportistas.get(i).isActivo()+",'"+
						newDeportistas.get(i).getGenero()+"','"+newDeportistas.get(i).getDeporte()+"')");
			}
			return Response.ok("Deportista añadido correctamente").type(MediaType.TEXT_PLAIN).build();
					//Response.ok("Deportista añadido").build();
		} catch (SQLException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.TEXT_PLAIN).build();
		}
	}

}
