package utn.api_rest_sp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import utn.api_rest_sp.entities.Autor;
import utn.api_rest_sp.entities.Libro;

import java.util.List;

public interface LibroService extends BaseService<Libro,Long>{
    List<Libro> search(String filtro) throws Exception;
    Page<Libro> search(String filtro, Pageable pageable) throws Exception;
}
