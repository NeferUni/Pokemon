package co.edu.ufps.repository;

import co.edu.ufps.entity.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    Optional<Entrenador> findByUuid(String uuid);
}