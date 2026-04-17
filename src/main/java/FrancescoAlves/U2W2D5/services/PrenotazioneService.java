package FrancescoAlves.U2W2D5.services;

import FrancescoAlves.U2W2D5.entities.Dipendente;
import FrancescoAlves.U2W2D5.entities.Prenotazione;
import FrancescoAlves.U2W2D5.entities.Viaggio;
import FrancescoAlves.U2W2D5.exceptions.BadRequestException;
import FrancescoAlves.U2W2D5.exceptions.NotFoundException;
import FrancescoAlves.U2W2D5.payloads.NewPrenotazioneDTO;
import FrancescoAlves.U2W2D5.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepo;
    @Autowired
    private DipendenteService dipendenteService;
    @Autowired
    private ViaggioService viaggioService;

    public Prenotazione save(NewPrenotazioneDTO body) {
        Dipendente dip = dipendenteService.findById(body.dipendenteId());
        Viaggio via = viaggioService.findById(body.viaggioId());

        boolean giaOccupato = prenotazioneRepo.existsByDipendenteAndViaggio_Data(dip, via.getData());

        if (giaOccupato) {
            throw new BadRequestException("il dipendente " + dip.getNome() + " ha già un viaggio per il giorno " + via.getData());
        }
        Prenotazione nuova = new Prenotazione();
        nuova.setDipendente(dip);
        nuova.setViaggio(via);
        nuova.setDataRichiesta(body.dataRichiesta());
        nuova.setNote(body.note());
        System.out.println("prenotazione creata con successo");
        return prenotazioneRepo.save(nuova);
    }


    public Prenotazione findById(Long id) {
        java.util.Optional<Prenotazione> op = prenotazioneRepo.findById(id);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new NotFoundException("prenotazione non trovata");
        }
    }

}