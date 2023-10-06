package utn.api_rest_sp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="Libro")
public class Libro extends Base{

    @Column(name="título")
    private String titulo;

    @Column(name="fecha")
    private int fecha;

    @Column(name="género")
    private String genero;

    @Column(name="páginas")
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;

}
