package services;

import models.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioService {

    public List<Usuario> get() {
        List<Usuario> listAll = Usuario.findAll().list();
        return listAll.stream().map(ie -> {
            return new Usuario();
        }).collect(Collectors.toList());
    }

    @Transactional
    public void create(Usuario item) {
        Usuario usuario = new Usuario();
        usuario.dni = item.getDni();
        usuario.last_name = item.getLast_name();
        usuario.name = item.getName();
        usuario.persist();
    }

    @Transactional
    public void update(Usuario item) {
        Usuario entity = Usuario.findById(item.getId());
        entity.name = item.getName();
        entity.last_name = item.getLast_name();
        entity.dni = item.getDni();
        entity.localidad = item.getLocalidad();
    }

    @Transactional
    public void delete(Long id) {
        Usuario.deleteById(id);
    }
}
