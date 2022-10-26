package controllers;

import models.Usuario;
import services.UsuarioService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("usuarios")
public class UsuariosController {

    @Inject
    UsuarioService userService;


    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Usuario> get(){
        //ArrayList<Usuario> arreglo=userService.get();
        //System.out.println(arreglo[0]);
        return userService.get();
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void create(Usuario usuario){
        userService.create(usuario);
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public void update(Usuario usuario){
        userService.update(usuario);
    }


    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        userService.delete(id);
    }
}
