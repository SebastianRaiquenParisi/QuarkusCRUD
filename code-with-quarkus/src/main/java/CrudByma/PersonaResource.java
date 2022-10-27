package CrudByma;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/personas")
public class PersonaResource {

    public static List<Persona> personas=new ArrayList<>();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonas(){
        return Response.ok(personas).build();

    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/size")
    public Integer countPersonas(){
        return personas.size();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(Persona newPersona){
        personas.add(newPersona);
        return Response.ok(personas).build();

    }

    @PUT
    @Path("{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePersona(
            @PathParam("id") Long id,
            @PathParam("name") String name){
       personas= personas.stream().map(persona->{
        if (persona.getId().equals(id)){
            System.out.println(name);
            persona.setName(name);

        }
        return persona;
        }).collect(Collectors.toList());
        return Response.ok(personas).build();
    }
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMovie(@PathParam("id") Long id){

        Optional<Persona> personaToDelete = personas.stream().filter(persona -> persona.getId().equals(id)).findFirst();
        boolean removed=false;
        if(personaToDelete.isPresent()){
            removed=personas.remove(personaToDelete.get());
        }
        if (removed){
            return Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }

}
