package co.edu.ufps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "entrenador")
@NoArgsConstructor
@AllArgsConstructor
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private Date fechaVinculacion;

    @Column(name = "pueblo_id")
    private Long puebloId;

    @Column(nullable = false, length = 100)
    private String uuid;
}