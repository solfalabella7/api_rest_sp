package utn.api_rest_sp.repositories;

import org.springframework.stereotype.Repository;
import utn.api_rest_sp.entities.Persona;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
}
