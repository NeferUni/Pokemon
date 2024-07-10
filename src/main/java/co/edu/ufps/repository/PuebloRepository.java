package co.edu.ufps.repository;

import co.edu.ufps.entity.Pueblo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuebloRepository extends JpaRepository<Pueblo, Long> {
}