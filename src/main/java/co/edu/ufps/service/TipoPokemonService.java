package co.edu.ufps.service;

import co.edu.ufps.entity.TipoPokemon;
import co.edu.ufps.repository.TipoPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoPokemonService {

    @Autowired
    private TipoPokemonRepository tipoPokemonRepository;

    public Optional<TipoPokemon> findById(Long id) {
        return tipoPokemonRepository.findById(id);
    }

    public TipoPokemon save(TipoPokemon tipoPokemon) {
        return tipoPokemonRepository.save(tipoPokemon);
    }
}
