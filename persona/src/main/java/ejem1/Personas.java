package ejem1;

import java.util.ArrayList;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path ("/personas")
public class Personas {
	static ArrayList<Persona> personas = new ArrayList<>();
	
		@POST
		@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		@Produces(MediaType.TEXT_PLAIN)
		public String guardar(Persona persona) {
			personas.add(persona);
			return "bien bien";
		}
		
		@GET
		@Produces(MediaType.APPLICATION_XML)
		public ArrayList<Persona> listar(){
			return this.personas;
		}
		
		@GET
		@Path("{nombre}")
		@Produces(MediaType.APPLICATION_JSON)
		public Persona ver(@PathParam("nombre") String name) {
			for (Persona persona : personas) {
				if(persona.getNombre() == name) {
					return persona;
				}
			}
			return null;
		}
		
		@GET
		@Path("buscar")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Persona ver1(@DefaultValue("pepe") @QueryParam("nombre") String name) {
			//System.out.println(name);
			for (Persona persona : personas) {
				if(persona.getNombre().toLowerCase().equals(name.toLowerCase())) {
					return persona;
				}
			}
			return null;
		}
		
		@POST
		@Path("add")
		@Consumes ({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		@Produces(MediaType.TEXT_PLAIN)
		public String Insertar() {
			return "";
		}
		
		
		@DELETE
		@Path("{id}")
		@Produces(MediaType.TEXT_PLAIN)
		public String Borrar(@PathParam("id") int id) {
			//for (Persona persona : personas) {
			for (int i = 0; i <= personas.size(); i++) {
				if(personas.get(i).getId() == id) {
					personas.remove(i);
					return "Persona con el ID "+id+" fue borrada";
				}
			}
			return "error al borrar";
		}
}
