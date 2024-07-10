package co.edu.ufps.controller;

import co.edu.ufps.entity.Pokemon;
import co.edu.ufps.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{tipoId}")
    public ResponseEntity<List<Pokemon>> getPokemonsByTipo(@PathVariable Long tipoId) {
        List<Pokemon> pokemons = pokemonService.findByTipoPokemon(tipoId);
        return ResponseEntity.ok(pokemons);
    }

    @PostMapping
    public ResponseEntity<Pokemon> registerPokemon(@RequestBody Pokemon pokemon) {
        Pokemon savedPokemon = pokemonService.save(pokemon);
        return ResponseEntity.ok(savedPokemon);
    }
}