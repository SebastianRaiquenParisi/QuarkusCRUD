package controllers;

import models.Usuario;
import services.UsuarioService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosController {

    @Inject
    UsuarioService userService;

    @GET
    public List<Usuario> get(){
        return userService.get();
    }

    @POST
    public void create(Usuario usuario){
        userService.create(usuario);
    }

    @PUT
    public void update(Usuario usuario){
        userService.update(usuario);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        userService.delete(id);
    }
}
