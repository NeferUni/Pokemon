package co.edu.ufps.service;

import co.edu.ufps.entity.Entrenador;
import co.edu.ufps.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Optional<Entrenador> findByUuid(String uuid) {
        return entrenadorRepository.findByUuid(uuid);
    }
}