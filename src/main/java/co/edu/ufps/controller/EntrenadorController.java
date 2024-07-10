package co.edu.ufps.controller;

import co.edu.ufps.entity.Entrenador;
import co.edu.ufps.entity.Pokemon;
import co.edu.ufps.entity.Captura;
import co.edu.ufps.entity.CapturaId;
import co.edu.ufps.service.EntrenadorService;
import co.edu.ufps.service.CapturaService;
import co.edu.ufps.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @Autowired
    private CapturaService capturaService;

    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        Optional<Entrenador> entrenador = entrenadorService.findByUuid(request.get("uuid"));
        if (entrenador.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("uuid", entrenador.get().getUuid());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/{uuid}/pokemons")
    public ResponseEntity<List<Pokemon>> getPokemons(@PathVariable String uuid) {
        Optional<Entrenador> entrenador = entrenadorService.findByUuid(uuid);
        if (entrenador.isPresent()) {
            List<Captura> capturas = capturaService.findByEntrenadorId(entrenador.get().getId());
            List<Pokemon> pokemons = new ArrayList<>();
            for (Captura captura : capturas) {
                pokemonService.findById(captura.getPokemonId()).ifPresent(pokemons::add);
            }
            return ResponseEntity.ok(pokemons);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/{uuid}/pokemons/{pokemonUuid}")
    public ResponseEntity<?> addPokemonToEntrenador(@PathVariable String uuid, @PathVariable String pokemonUuid) {
        Optional<Entrenador> entrenadorOpt = entrenadorService.findByUuid(uuid);
        Optional<Pokemon> pokemonOpt = pokemonService.findByUuid(pokemonUuid);
        
        if (entrenadorOpt.isEmpty() || pokemonOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Entrenador entrenador = entrenadorOpt.get();
        Pokemon pokemon = pokemonOpt.get();
        
        CapturaId capturaId = new CapturaId(pokemon.getId(), entrenador.getId());
        
        if (capturaService.existsById(capturaId)) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", true);
            response.put("message", "Pokemon ya está registrado al entrenador");
            return ResponseEntity.ok(response);
        }
        
        Captura captura = new Captura(pokemon.getId(), entrenador.getId());
        capturaService.save(captura);
        
        List<Pokemon> updatedPokemons = getUpdatedPokemonList(entrenador.getId());
        return ResponseEntity.ok(updatedPokemons);
    }

    private List<Pokemon> getUpdatedPokemonList(Long entrenadorId) {
        List<Captura> capturas = capturaService.findByEntrenadorId(entrenadorId);
        return capturas.stream()
            .map(captura -> pokemonService.findById(captura.getPokemonId()))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }
}