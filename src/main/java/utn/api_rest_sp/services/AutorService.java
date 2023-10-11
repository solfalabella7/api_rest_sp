package utn.api_rest_sp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import utn.api_rest_sp.entities.Autor;

import java.util.List;

public interface AutorService extends BaseService<Autor,Long>{
    List<Autor> search(String filtro) throws Exception;
    Page<Autor> search(String filtro, Pageable pageable) throws Exception;
}
