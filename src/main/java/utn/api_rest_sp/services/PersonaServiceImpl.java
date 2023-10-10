package utn.api_rest_sp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import utn.api_rest_sp.entities.Persona;
import utn.api_rest_sp.repositories.BaseRepository;
import utn.api_rest_sp.repositories.PersonaRepository;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long>{

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository){
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    public List<Persona> search(String filtro) throws Exception{
        try {
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Persona> personas = personaRepository.search(filtro);
            List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Page<Persona> search(String filtro, Pageable pageable) throws Exception{
        try {
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //Page<Persona> personas = personaRepository.search(filtro, pageable);
            Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);
            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
