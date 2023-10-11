package utn.api_rest_sp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import utn.api_rest_sp.entities.Autor;
import utn.api_rest_sp.entities.Domicilio;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio,Long>{
    List<Domicilio> search(String filtro) throws Exception;
    Page<Domicilio> search(String filtro, Pageable pageable) throws Exception;
}
