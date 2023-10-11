package utn.api_rest_sp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import utn.api_rest_sp.entities.Autor;
import utn.api_rest_sp.entities.Persona;
import utn.api_rest_sp.repositories.AutorRepository;
import utn.api_rest_sp.repositories.BaseRepository;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long>{

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository, AutorRepository autorRepository){
        super(baseRepository);
        this.autorRepository = autorRepository;
    }
    public List<Autor> search(String filtro) throws Exception{
        try {
            //List<Autor> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Autor> personas = personaRepository.search(filtro);
            List<Autor> autores = autorRepository.searchNativo(filtro);
            return autores;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Page<Autor> search(String filtro, Pageable pageable) throws Exception{
        try {
            //Page<Autor> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //Page<Autor> personas = personaRepository.search(filtro, pageable);
            Page<Autor> autores = autorRepository.searchNativo(filtro, pageable);
            return autores;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
