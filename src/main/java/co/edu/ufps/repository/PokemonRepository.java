package co.edu.ufps.repository;

import co.edu.ufps.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByTipoPokemon(Long tipoPokemon);
    Optional<Pokemon> findByUuid(String uuid);
}