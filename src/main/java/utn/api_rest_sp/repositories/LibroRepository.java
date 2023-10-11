package utn.api_rest_sp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utn.api_rest_sp.entities.Libro;
import utn.api_rest_sp.entities.Persona;

import java.util.List;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {
    //Anotación método de Query
    List<Libro> findByTituloContaining(String titulo);
    Page<Libro> findByTituloContaining(String titulo, Pageable pageable);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT p FROM Libro p WHERE p.titulo LIKE %:filtro%")
    List<Libro> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Libro p WHERE p.titulo LIKE %:filtro% ")
    Page<Libro> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM Libro p WHERE p.titulo LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Libro> searchNativo(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM Libro p WHERE p.titulo LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM Libro",
            nativeQuery = true
    )
    Page<Libro> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
