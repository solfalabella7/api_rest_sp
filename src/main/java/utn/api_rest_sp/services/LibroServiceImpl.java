package utn.api_rest_sp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import utn.api_rest_sp.entities.Autor;
import utn.api_rest_sp.entities.Libro;
import utn.api_rest_sp.repositories.BaseRepository;
import utn.api_rest_sp.repositories.LibroRepository;

import java.util.List;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long>{

    @Autowired
    private LibroRepository libroRepository;

    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository, LibroRepository libroRepository){
        super(baseRepository);
        this.libroRepository = libroRepository;
    }
    public List<Libro> search(String filtro) throws Exception{
        try {
            //List<Libro> libros = libroRepository.findByTituloContaining(filtro, filtro);
            //List<Libro> libros = libroRepository.search(filtro);
            List<Libro> libros = libroRepository.searchNativo(filtro);
            return libros;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Page<Libro> search(String filtro, Pageable pageable) throws Exception{
        try {
            //Page<Libro> libros = personaRepository.findByTituloContaining(filtro, filtro, pageable);
            //Page<Libro> libros = personaRepository.search(filtro, pageable);
            Page<Libro> libros = libroRepository.searchNativo(filtro, pageable);
            return libros;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
