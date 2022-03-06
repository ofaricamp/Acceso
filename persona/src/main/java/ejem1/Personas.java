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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

@Path ("/personas")
public class Personas {
	static ArrayList<Persona> personas = new ArrayList<>();
	
		//Ejercicio 1
		@POST
		@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		@Produces(MediaType.TEXT_PLAIN)
		public Response guardar(Persona persona) {
			personas.add(persona);
			return Response.ok("Persona guardada correctamente").build();
		}
		
		//Ejercicio 2
		@GET
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Response listar(){
			return Response.ok(this.personas).build();
		}
		
		// Ejercicio 3
		@GET
		@Path("/{nombre}")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Response ver(@PathParam("nombre") String name) {
			for (Persona persona : personas) {
				if(persona.getNombre() == name) {
					return Response.ok(persona).build();
				}
			}
			return Response.status(Status.NOT_FOUND).build();
		}
		
		// Ejercicio 4 junto con el 9
		@GET
		@Path("/buscar")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Response verEjer3(@DefaultValue("pepe") @QueryParam("nombre") String name) {
			//System.out.println(name);
			for (Persona persona : personas) {
				if(persona.getNombre().toLowerCase().equals(name.toLowerCase())) {
					return Response.ok(persona).build();
				}
			}
			return Response.status(Status.NOT_FOUND).build();
		}
		
		//Ejercicio 7
		@POST
		@Path("/add")
		@Consumes ({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		@Produces(MediaType.TEXT_PLAIN)
		public Response Insertar(ArrayList<Persona> personas) {
			for (int i = 0; i < personas.size(); i++) {
				this.personas.add(personas.get(i));
			}
			return Response.ok("Agregado Correctamente").build();
		}
		
		
		//Ejercicio 8
		@DELETE
		@Path("/{id}")
		@Produces(MediaType.TEXT_PLAIN)
		public Response Borrar(@PathParam("id") int id) {
			//for (Persona persona : personas) {
			for (int i = 0; i <= personas.size(); i++) {
				if(personas.get(i).getId() == id) {
					personas.remove(i);
					//return "Persona con el ID "+id+" fue borrada";
					return Response.ok("Persona con el ID "+id+" fue borrada").build();
				}
			}
			//return "error al borrar";
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		//Ejercicio 10
		/* Para este apartado debemos poner y que el ID sea un atributo debemos ponerle en el  
		getter @XmlAttribute para que sea un atributo, pero esto solo se aprecia en el XML puesto que en 
		JSON ignora el @XmlAttribute*/
		@GET
		@Path("/XML")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Response XMLAtributo(){
			//return this.personas;
			return Response.ok(this.personas).build();
		}		
}
