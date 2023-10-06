package utn.api_rest_sp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.api_rest_sp.entities.Libro;
import utn.api_rest_sp.repositories.BaseRepository;
import utn.api_rest_sp.repositories.LibroRepository;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long>{

    @Autowired
    private LibroRepository libroRepository;

    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository, LibroRepository libroRepository){
        super(baseRepository);
        this.libroRepository = libroRepository;
    }
}
