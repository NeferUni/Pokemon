package co.edu.ufps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapturaId implements Serializable {
    private Long pokemonId;
    private Long entrenadorId;
}