package CrudByma;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonaService {

    @Transactional
    public Persona create(String firstName, String lastName) {
        Persona p = new Persona();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.persist();
        return p;
    }
    @Transactional
    public Persona editar(Long id, String firstName, String lastName){
        Persona p=Persona.findById(id);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.persist();
        return p;
    }

    @Transactional
    public void delete (Long id){
        Persona.deleteById(id);
    }

    public List<Persona> list(){
        List<Persona> personas=Persona.findAll().list();
        return personas;
    }


}
