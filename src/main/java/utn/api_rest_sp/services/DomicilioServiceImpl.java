package utn.api_rest_sp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import utn.api_rest_sp.entities.Autor;
import utn.api_rest_sp.entities.Domicilio;
import utn.api_rest_sp.repositories.BaseRepository;
import utn.api_rest_sp.repositories.DomicilioRepository;

import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long>{

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository){
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }
    public List<Domicilio> search(String filtro) throws Exception{
        try {
            //List<Domicilio> domicilios = domicilioRepository.findByCalleContainingOrNumeroContaining(filtro, filtro);
            //List<Domicilio> domicilios = domicilioRepository.search(filtro);
            List<Domicilio> domicilios = domicilioRepository.searchNativo(filtro);
            return domicilios;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Page<Domicilio> search(String filtro, Pageable pageable) throws Exception{
        try {
            //Page<Domicilio> domicilios = domicilioRepository.findByCalleContainingOrNumeroContaining(filtro, filtro, pageable);
            //Page<Domicilio> domicilios = domicilioRepository.search(filtro, pageable);
            Page<Domicilio> domicilios = domicilioRepository.searchNativo(filtro, pageable);
            return domicilios;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
