package utn.api_rest_sp.repositories;

import org.springframework.stereotype.Repository;
import utn.api_rest_sp.entities.Autor;

@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {
}
