package utn.api_rest_sp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.api_rest_sp.entities.Localidad;
import utn.api_rest_sp.repositories.BaseRepository;
import utn.api_rest_sp.repositories.LocalidadRepository;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long>{

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository, LocalidadRepository localidadRepository){
        super(baseRepository);
        this.localidadRepository = localidadRepository;
    }
}
