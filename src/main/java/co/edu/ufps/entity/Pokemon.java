package co.edu.ufps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "pokemon")
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "tipo_pokemon")
    private Long tipoPokemon;

    private Date fechaDescubrimiento;

    @Column(nullable = false)
    private Integer generacion;

    @Column(nullable = false, length = 100)
    private String uuid;
}