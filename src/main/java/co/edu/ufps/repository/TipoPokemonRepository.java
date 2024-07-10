package co.edu.ufps.repository;

import co.edu.ufps.entity.TipoPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPokemonRepository extends JpaRepository<TipoPokemon, Long> {
}