package FrancescoAlves.U2W2D5.repositories;

import FrancescoAlves.U2W2D5.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
