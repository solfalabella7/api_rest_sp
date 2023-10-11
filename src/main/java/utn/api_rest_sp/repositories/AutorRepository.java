package utn.api_rest_sp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utn.api_rest_sp.entities.Autor;
import utn.api_rest_sp.entities.Persona;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {
    //Anotación método de Query
    List<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    //boolean existsByDni(int dni);
    Page<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT p FROM Autor p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Autor> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Autor p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Autor> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM Autor p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Autor> searchNativo(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM Autor p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM Autor",
            nativeQuery = true
    )
    Page<Autor> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
