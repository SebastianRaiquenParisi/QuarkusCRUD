package CrudByma;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("persona")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class PersonaResource {

        @Inject
        PersonaService personService;

        @GET
        public Response list() {
            List<Persona> list = personService.list();
            return Response.ok(list).build();
        }

        @POST
        public Response create(Persona persona) {
            Persona p = personService.create(persona.getFirstName(), persona.getLastName());
            return Response.ok(p).build();
        }

        @PUT
        @Path("{id}")
        public Response update(@PathParam Long id, Persona p){
            Persona persona=personService.editar(id,p.getFirstName(),p.getLastName());
            return Response.ok(persona).build();
        }
        @DELETE
        @Path("{id}")
        public Response delete (@PathParam  Long id){
            personService.delete(id);
            return Response.ok().build();
        }
}


