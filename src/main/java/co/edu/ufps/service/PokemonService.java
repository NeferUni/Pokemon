package co.edu.ufps.service;

import co.edu.ufps.entity.Pokemon;
import co.edu.ufps.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> findByTipoPokemon(Long tipoPokemon) {
        return pokemonRepository.findByTipoPokemon(tipoPokemon);
    }

    public Pokemon save(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Optional<Pokemon> findById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Optional<Pokemon> findByUuid(String uuid) {
        return pokemonRepository.findByUuid(uuid);
    }
}