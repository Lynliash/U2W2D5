package FrancescoAlves.U2W2D5.services;

import FrancescoAlves.U2W2D5.entities.Dipendente;
import FrancescoAlves.U2W2D5.exceptions.BadRequestException;
import FrancescoAlves.U2W2D5.exceptions.NotFoundException;
import FrancescoAlves.U2W2D5.payloads.NewDipendenteDTO;
import FrancescoAlves.U2W2D5.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepo;

    public Dipendente save(NewDipendenteDTO body) {
        // controllo se l'email o l'username esistono già e poi salvo
        if (dipendenteRepo.existsByEmail(body.email())) {
            throw new BadRequestException("l'email " + body.email() + " è già in uso");
        }

        if (dipendenteRepo.existsByUsername(body.username())) {
            System.out.println("username già in uso");
            throw new BadRequestException("lo username " + body.username() + " è già in uso, scegline un altro");
        }

        Dipendente nuovo = new Dipendente(body.username(), body.nome(), body.cognome(), body.email());
        return dipendenteRepo.save(nuovo);
    }

    public List<Dipendente> findAll() {
        return dipendenteRepo.findAll();
    }

    //    cerca per id
    public Dipendente findById(Long id) {
        Optional<Dipendente> op = dipendenteRepo.findById(id);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new NotFoundException("dipendente con id " + id + " non trovato");
        }
    }

    public Dipendente findByIdAndUpdate(Long id, NewDipendenteDTO body) {
        Dipendente found = this.findById(id);
        found.setNome(body.nome());
        found.setCognome(body.cognome());
        found.setEmail(body.email());
        found.setUsername(body.username());
        return dipendenteRepo.save(found);
    }

    public void findByIdAndDelete(Long id) {
        Dipendente found = this.findById(id);
        dipendenteRepo.delete(found);
    }
}