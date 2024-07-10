package co.edu.ufps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "captura")
@IdClass(CapturaId.class)
@NoArgsConstructor
@AllArgsConstructor
public class Captura {
    @Id
    @Column(name = "pokemon_id")
    private Long pokemonId;

    @Id
    @Column(name = "entrenador_id")
    private Long entrenadorId;
}