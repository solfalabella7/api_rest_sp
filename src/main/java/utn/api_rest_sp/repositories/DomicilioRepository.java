package utn.api_rest_sp.repositories;

import org.springframework.stereotype.Repository;
import utn.api_rest_sp.entities.Domicilio;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {
}
