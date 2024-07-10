package co.edu.ufps.repository;

import co.edu.ufps.entity.Captura;
import co.edu.ufps.entity.CapturaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CapturaRepository extends JpaRepository<Captura, CapturaId> {
    List<Captura> findByEntrenadorId(Long entrenadorId);
}