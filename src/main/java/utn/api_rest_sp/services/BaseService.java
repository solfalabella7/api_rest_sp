package utn.api_rest_sp.services;

import org.springframework.stereotype.Service;
import utn.api_rest_sp.entities.Base;

import java.io.Serializable;
import java.util.List;

@Service
public interface BaseService <E extends Base, ID extends Serializable>{

    public List<E> findAll() throws Exception;

    public E findById(ID id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(ID id, E entity) throws Exception;

    public boolean delete(ID id) throws Exception;

}
