package FrancescoAlves.U2W2D5.repositories;

import FrancescoAlves.U2W2D5.entities.Dipendente;
import FrancescoAlves.U2W2D5.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    // cerco se esiste una prenotzione per uno specifico dipendente in una DATA specifica
    boolean existsByDipendenteAndViaggio_Data(Dipendente dipendente, LocalDate data);
}
