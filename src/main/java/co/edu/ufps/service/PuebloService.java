package co.edu.ufps.service;

import co.edu.ufps.entity.Pueblo;
import co.edu.ufps.repository.PuebloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PuebloService {

    @Autowired
    private PuebloRepository puebloRepository;

    public Optional<Pueblo> findById(Long id) {
        return puebloRepository.findById(id);
    }

    public Pueblo save(Pueblo pueblo) {
        return puebloRepository.save(pueblo);
    }
}
