package utn.api_rest_sp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utn.api_rest_sp.entities.Domicilio;
import utn.api_rest_sp.entities.Persona;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {
    //Anotación método de Query
    List<Domicilio> findByCalleContainingOrNumeroContaining(String calle, int numero);
    //boolean existsByDni(int dni);
    Page<Domicilio> findByCalleContainingOrNumeroContaining(String calle, int numero, Pageable pageable);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT p FROM Domicilio p WHERE p.calle LIKE %:filtro% OR p.numero = :filtro")
    List<Domicilio> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Domicilio p WHERE p.calle LIKE %:filtro% OR p.numero = :filtro")
    Page<Domicilio> search(@Param("filtro") String filtro,  Pageable pageable);

    @Query(
            value = "SELECT * FROM Domicilio p WHERE p.filtro LIKE %:filtro% OR p.numero = :filtro",
            nativeQuery = true
    )
    List<Domicilio> searchNativo(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM Domicilio p WHERE p.filtro LIKE %:filtro% OR p.numero = :filtro",
            countQuery = "SELECT count(*) FROM Domicilio",
            nativeQuery = true
    )
    Page<Domicilio> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
