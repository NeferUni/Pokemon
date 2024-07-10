package co.edu.ufps.service;

import co.edu.ufps.entity.Captura;
import co.edu.ufps.entity.CapturaId;
import co.edu.ufps.repository.CapturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CapturaService {

    @Autowired
    private CapturaRepository capturaRepository;

    public List<Captura> findByEntrenadorId(Long entrenadorId) {
        return capturaRepository.findByEntrenadorId(entrenadorId);
    }

    public Captura save(Captura captura) {
        return capturaRepository.save(captura);
    }

    public boolean existsById(CapturaId capturaId) {
        return capturaRepository.existsById(capturaId);
    }
}