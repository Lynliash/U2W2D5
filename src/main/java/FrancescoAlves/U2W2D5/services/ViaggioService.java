package FrancescoAlves.U2W2D5.services;

import FrancescoAlves.U2W2D5.entities.Viaggio;
import FrancescoAlves.U2W2D5.exceptions.NotFoundException;
import FrancescoAlves.U2W2D5.payloads.NewViaggioDTO;
import FrancescoAlves.U2W2D5.payloads.StatoViaggioDTO;
import FrancescoAlves.U2W2D5.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepo;

    public Viaggio save(NewViaggioDTO body) {
        Viaggio nuovoViaggio = new Viaggio();
        nuovoViaggio.setDestinazione(body.destinazione());
        nuovoViaggio.setData(body.data());
        nuovoViaggio.setStato(body.stato());
        return viaggioRepo.save(nuovoViaggio);
    }

    public Viaggio findById(Long id) {
        java.util.Optional<Viaggio> op = viaggioRepo.findById(id);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new NotFoundException("viaggio con id " + id + " non trovato");
        }
    }

    // per cambiare lo stato
    public Viaggio updateStato(Long id, StatoViaggioDTO body) {
        Viaggio trovato = this.findById(id);
        trovato.setStato(body.stato());
        return viaggioRepo.save(trovato);
    }

    public List<Viaggio> findAll() {
        return viaggioRepo.findAll();
    }
}