package utn.api_rest_sp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.api_rest_sp.entities.Domicilio;
import utn.api_rest_sp.repositories.BaseRepository;
import utn.api_rest_sp.repositories.DomicilioRepository;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long>{

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository){
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }
}
