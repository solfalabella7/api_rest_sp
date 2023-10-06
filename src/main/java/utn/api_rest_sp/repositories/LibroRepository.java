package utn.api_rest_sp.repositories;

import org.springframework.stereotype.Repository;
import utn.api_rest_sp.entities.Libro;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {
}
